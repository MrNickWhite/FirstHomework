package google.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import pages.*;



public class Tests extends BaseTest {
    /**
    * Параметризорованный автотест, проверяющий наличие в поисковой выдаче ссылки на статью про искомый объект на сайте wikipedia.org
    * @author Паничев Н.В.
    * */
    @ParameterizedTest(name = "Тест №{index} - {0} есть статья на википедии.")
    @ValueSource(strings = {"Гладиолус","Абрикос","Ананас","Java"})
    public void testFindSite(String word){
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearchPage googleBeforeSearchPage = new GoogleBeforeSearchPage(chromeDriver);
        googleBeforeSearchPage.findAWord(word);
        GoogleAfterSearchPage googleAfterSearchPage = new GoogleAfterSearchPage(chromeDriver);
        Assertions.assertTrue(googleAfterSearchPage.getResults("wikipedia.org").size()>0, "Ссылки на википедию не обнаружены");
    }


}
