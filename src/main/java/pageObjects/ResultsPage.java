package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.util.List;

public class ResultsPage {
    private WebDriver driver;

    @FindBy(className = "flex-link")
    private List<WebElement> vacationResults;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int getAvailableVacationsCount() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
        wait.until(ExpectedConditions.titleContains("Hotel Search Results"));

        return vacationResults.size();
    }

}
