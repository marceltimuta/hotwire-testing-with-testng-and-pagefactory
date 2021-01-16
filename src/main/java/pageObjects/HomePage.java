package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HomePage extends BasePage {
    private WebDriver driver;

    @FindBy(css = "div[data-bdd='farefinder-option-bundles']")
    private WebElement bundleOption;

    @FindBy(css = "input[data-bdd='farefinder-package-origin-location-input']")
    private WebElement flyFromInput;

    @FindBy(css = "input[data-bdd='farefinder-package-destination-location-input']")
    private WebElement flyToInput;

    @FindBy(id = "input1-farefinder-package-date")
    private WebElement departingDate;

    @FindBy(id = "input2-farefinder-package-date")
    private WebElement returningDate;

    @FindBy(className = "submit-button")
    private WebElement findADealButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void selectBundleOption() {
        bundleOption.click();
    }

    public void enterFlight(String from, String to) {
        flyFromInput.sendKeys(from + Keys.ENTER);
        flyToInput.sendKeys(to + Keys.ENTER);
    }

    public void enterDepartureAndReturning() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate today = LocalDate.now();
        LocalDate nextDay = today.plusDays(1);
        LocalDate after20Days = today.plusDays(20);

        departingDate.sendKeys(nextDay.toString());
        returningDate.sendKeys(after20Days.toString());
    }

    public void findADeal() {
        findADealButton.click();
    }

}
