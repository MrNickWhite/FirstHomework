package wikipedia.org;

import google.com.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class Tests extends BaseTest {

    /**
     * Параметризорованный автотест, проверяющий правильность порядка размещения преподавателей в таблице на сайте wikipedia.org
     * @author Паничев Н.В.
     * */
    @ParameterizedTest(name = "Тест №{index} - {0} проверка нахождения преподавателей на нужных местах в таблице.")
    @CsvSource({"Таблица, Сергей Владимирович, Иван Иванович","Таблица, Пашков Сергей, Иванов Иван"})
    public void testTable(String word, String firstPerson, String secondPerson){
        chromeDriver.get("https://yandex.ru/");
        YandexMainPageFactory yandexMainPageFactory = PageFactory.initElements(chromeDriver,YandexMainPageFactory.class);
        Assertions.assertFalse(yandexMainPageFactory.checkCaptcha().size()>0, "Капча мешает пройти тест");
        chromeDriver.switchTo().frame(0);
        yandexMainPageFactory.findAWord(word);
        yandexMainPageFactory = PageFactory.initElements(chromeDriver,YandexMainPageFactory.class);
        chromeDriver.switchTo().window(chromeDriver.getWindowHandles().stream().toArray()[1].toString());
        Assertions.assertTrue(yandexMainPageFactory.getResults().size()>0, "Результатов по запросу не найдено");
        yandexMainPageFactory.openSite();
        chromeDriver.switchTo().window(chromeDriver.getWindowHandles().stream().toArray()[2].toString());
        WikipediaArticlePageFactory wikipediaArticlePageFactory = PageFactory.initElements(chromeDriver,WikipediaArticlePageFactory.class);
        List<String> tableStrings = new ArrayList<>();
        wikipediaArticlePageFactory.getTable().forEach(x -> tableStrings.add(x.getText()));
        tableStrings.remove(0);

        for (String s : tableStrings){
            if(s.contains(firstPerson)) firstPerson = s;
            if(s.contains(secondPerson)) secondPerson = s;
        }
        Assertions.assertTrue(tableStrings.indexOf(firstPerson)==0 && tableStrings.indexOf(secondPerson)==tableStrings.size()-1,
                "В таблице нарушен порядок преподавателей: " + firstPerson + " на " + tableStrings.indexOf(firstPerson) + " позиции, " + secondPerson + " на " + tableStrings.indexOf(secondPerson));

    }

}
