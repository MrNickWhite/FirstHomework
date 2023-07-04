package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankOpenMainPage {

    /**
     * Переменная для хранения драйвера Chrome
     * @author Паничев Н.В.
     */
    protected WebDriver chromeDriver;

    /**
     * Переменная для хранения ссылки на страницу курсов обмена валют
     * @author Паничев Н.В.
     */
    protected WebElement courseExchangeLink;

    /**
     * Конструктор главной страницы сайта банка Открытие
     * @author Паничев Н.В.
     */
    public BankOpenMainPage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.courseExchangeLink = chromeDriver.findElement(By.xpath("//a[contains(text(),'курсы')]"));
    }

    /**
     * Метод для перехода на страницу курсов обмена валют
     * @author Паничев Н.В.
     */
    public void openExchangePage(){

        WebElement cookieButton = chromeDriver.findElement(By.xpath("//button[contains(@class,'cookie')]"));
        cookieButton.click();
        courseExchangeLink.click();

    }
}
