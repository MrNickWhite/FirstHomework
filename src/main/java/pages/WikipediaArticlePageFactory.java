package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WikipediaArticlePageFactory{

    /**
     * Переменная для хранения драйвера Chrome
     * @author Паничев Н.В.
     */
    private WebDriver chromeDriver;

    /**
     * Переменная для хранения рядов таблицы преподавателей
     * @author Паничев Н.В.
     */
    @FindBy(xpath = "//table[1]//tr")
    List<WebElement> tableRows;

    /**
     * Конструктор класса страницы со статьей на wikipedia.org
     * @author Паничев Н.В.
     */
    public WikipediaArticlePageFactory(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    /**
     * Метод, возвращающий ряды таблицы преподавателей
     * @author Паничев Н.В.
     */
    public List<WebElement> getTable(){
        return tableRows;
    }
}
