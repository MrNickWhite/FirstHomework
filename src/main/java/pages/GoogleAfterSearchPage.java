package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleAfterSearchPage extends GoogleBeforeSearchPage {
    /**
     * Переменная для хранения полученных элементов страницы
     * @author Паничев Н.В.
     */
    protected List<WebElement> results;
    /**
     * Переменная для хранения ссылки на искомый сайт
     * @author Паничев Н.В.
     */
    protected WebElement siteLink;

    /**
     * Конструктор класса страницы поисковой выдачи после выполнения запроса
     * @author Паничев Н.В.
     */
    public GoogleAfterSearchPage(WebDriver chromeDriver){
        super(chromeDriver);
    }

    /**
     * Метод, возвращающий элементы, в которых содержится ссылка на wikipedia.org
     * @author Паничев Н.В.
     */
    public List<WebElement> getResults(String siteName){
        results = chromeDriver.findElements(By.xpath(String.format("//div[@id='search']//a[contains(@href,'%s')]",siteName)));
        return results;
    }
    /**
     * Метод, возвращающий элементы, в которых содержится искомый заголовок
     * @author Паничев Н.В.
     */
    public List<WebElement> getSiteByHeader(String siteHeaderText){

        results = chromeDriver.findElements(By.xpath(String.format("//div[@id='search']//h3[contains(text(),'%s')]", siteHeaderText)));
        return results;
    }

    /**
     * Метод, открывающий сайт по заголовку
     * @author Паничев Н.В.
     */
    public void openSite(String siteHeaderText){
        siteLink = chromeDriver.findElement(By.xpath(String.format("//div[@id='search']//h3[contains(text(),'%s')]",siteHeaderText)));
        siteLink.click();
    }

}
