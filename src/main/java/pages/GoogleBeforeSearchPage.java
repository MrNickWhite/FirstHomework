package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleBeforeSearchPage {
    /**
     * Переменная для хранения драйвера Chrome
     * @author Паничев Н.В.
     */
    protected WebDriver chromeDriver;
    /**
     * Переменная для хранения поискового элемента на странице
     * @author Паничев Н.В.
     */
    protected WebElement searchField;
    /**
     * Переменная для хранения кнопки выполнения поиска
     * @author Паничев Н.В.
     */
    protected WebElement searchButton;

    /**
     * Конструктор класса главной страницы google.com
     * @author Паничев Н.В.
     */
    public GoogleBeforeSearchPage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.searchField = chromeDriver.findElement(By.xpath("//textarea[@type='search']"));
        this.searchButton = chromeDriver.findElement(By.xpath("//*[@type='submit']"));
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

}
