package open.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import pages.BankOpenExchangePage;
import pages.BankOpenMainPage;
import pages.GoogleAfterSearchPage;
import pages.GoogleBeforeSearchPage;

public class Tests extends BaseTest {
    /**
     * Параметризорованный автотест, проверяющий, что на сайте банка Открытие курс продажи валюты больше чем курс покупки.
     *
     * @author Паничев Н.В.
     */
    @ParameterizedTest(name = "Тест №{index} - {0} проверка курсов валют>.")
    @CsvSource({"Открытие, USD EUR"})
    public void testBank(String searchWord, String currencyNames) {
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearchPage googleBeforeSearchPage = new GoogleBeforeSearchPage(chromeDriver);
        googleBeforeSearchPage.findAWord(searchWord);
        GoogleAfterSearchPage googleAfterSearchPage = new GoogleAfterSearchPage(chromeDriver);
        String searchString = "Банк Открытие: кредит наличными — от 4% годовых";
        Assertions.assertTrue(googleAfterSearchPage.getSiteByHeader(searchString).size() > 0, "Сайт по заголовку " + searchString + " не найден");
        googleAfterSearchPage.openSite(searchString);
        BankOpenMainPage bankOpenMainPage = new BankOpenMainPage(chromeDriver);
        bankOpenMainPage.openExchangePage();
        BankOpenExchangePage bankOpenExchangePage = new BankOpenExchangePage(chromeDriver);
        int i = 0;
        int buyIndex = 0;
        int sellIndex = 0;
        int currencyNameIndex = 0;
        for (WebElement x : bankOpenExchangePage.getTableHead()) {
            if (x.getText().toLowerCase().contains("покуп")) buyIndex = i;
            else if (x.getText().toLowerCase().contains("прода")) sellIndex = i;
            else if (x.getText().toLowerCase().contains("валют")) currencyNameIndex = i;
            i++;
        }

        for (WebElement x : bankOpenExchangePage.getCoursesRows()){
            String[] buf = x.getText().split("[ \n]");
            buf[buyIndex] = buf[buyIndex].replace(',','.');
            buf[sellIndex] = buf[sellIndex].replace(',','.');
            if (currencyNames.toUpperCase().contains(buf[currencyNameIndex].toUpperCase())){
                Assertions.assertTrue(Float.parseFloat(buf[buyIndex]) < Float.parseFloat(buf[sellIndex]), "Курс валюты " + buf[currencyNameIndex] + " на продажу меньше чем на покупку");
                currencyNames = currencyNames.replace(buf[currencyNameIndex].toUpperCase(),"");
            }
        }
        currencyNames = currencyNames.replace(" ","");
        Assertions.assertTrue(currencyNames.length()<1, "Не все курсы валют были сравнены!");
    }
}
