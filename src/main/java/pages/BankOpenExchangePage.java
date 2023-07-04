package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BankOpenExchangePage {
    /**
     * Переменная для хранения драйвера Chrome
     * @author Паничев Н.В.
     */
    protected WebDriver chromeDriver;

    /**
     * Переменная для хранения рядов таблицы обмена валют
     * @author Паничев Н.В.
     */
    protected List<WebElement> coursesRows;

    /**
     * Конструктор класса страницы обмена валют банка Открытие
     * @author Паничев Н.В.
     */
    public BankOpenExchangePage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }

    /**
     * Метод, возвращающий ряды таблицы с курсами обмена валют
     * @author Паничев Н.В.
     */
    public List<WebElement> getCoursesRows(){
        coursesRows = chromeDriver.findElements(By.xpath("//section[contains(@class, 'currency')][not(contains(@style,'none'))]//table[@class='card-rates-table cards']//tbody/tr"));
        return coursesRows;
    }
    /**
     * Метод, возвращающий оглавление таблицы с курсами обмена валют
     * @author Паничев Н.В.
     */
    public List<WebElement> getTableHead(){
        coursesRows = chromeDriver.findElements(By.xpath("//section[contains(@class, 'currency')][not(contains(@style,'none'))]//table[@class='card-rates-table cards']//thead/tr/th"));
        return coursesRows;
    }
}
