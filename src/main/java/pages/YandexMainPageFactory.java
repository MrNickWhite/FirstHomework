package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class YandexMainPageFactory {
    /**
     * Переменная для хранения драйвера Chrome
     * @author Паничев Н.В.
     */
    protected WebDriver chromeDriver;

    /**
     * Переменная для хранения поискового элемента на странице
     * @author Паничев Н.В.
     */
    @FindBy(xpath = "//input[contains(@name, 'text')]")
    WebElement searchField;

    /**
     * Переменная для хранения результатов наличия капчи
     * @author Паничев Н.В.
     */
    @FindBy(xpath = "//*[contains(@class,'Captcha')]")
    List<WebElement> captcha;

    /**
     * Переменная для хранения кнопки выполнения поиска
     * @author Паничев Н.В.
     */
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    /**
     * Переменная для хранения ссылки на искомый сайт
     * @author Паничев Н.В.
     */
    @FindBy(xpath = "//li[contains(@class,'serp')]//a[contains(@href, 'wikipedia.org')]")
    WebElement siteLink;

    /**
     * Переменная для хранения результатов поисковой выдачи
     * @author Паничев Н.В.
     */
    @FindBy(xpath = "//li[contains(@class,'serp')]//a[contains(@href, 'wikipedia.org')]")
    List<WebElement> results;

    /**
     * Конструктор класса главной страницы Яндекса
     * @author Паничев Н.В.
     */
    public YandexMainPageFactory(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    /**
     * Метод для ввода значения в поисковую строку и поиска
     * @author Паничев Н.В.
     */
    public void findAWord(String word){
        searchField.click();
        searchField.sendKeys(word);
        searchButton.click();
    }

    /**
     * Метод, возвращающий элементы, в которых содержится ссылка на wikipedia.org
     * @author Паничев Н.В.
     */
    public List<WebElement> getResults(){
        return results;
    }

    /**
     * Метод для перехода по ссылке на сайт
     * @author Паничев Н.В.
     */
    public void openSite(){
        siteLink.click();
    }

    /**
     * Метод для проверки наличия капчи на странице, возвращает элементы, относящиеся к капче
     * @author Паничев Н.В.
     */
    public List<WebElement> checkCaptcha(){
        return captcha;
    }


}
