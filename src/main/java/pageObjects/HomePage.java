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

    public HomePage selectBundleOption() {
        bundleOption.click();
        return this;
    }

    public HomePage enterFlight(String from, String to) {
        flyFromInput.sendKeys(from + Keys.ENTER);
        flyToInput.sendKeys(to + Keys.ENTER);
        return this
    }

    public HomePage enterDepartureAndReturning(int departureInDays, int returnInDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate today = LocalDate.now();
        LocalDate departureDate = today.plusDays(departureInDays);
        LocalDate returningDate = today.plusDays(returnInDays);

        departingDate.sendKeys(departureDate.toString());
        returningDate.sendKeys(returningDate.toString());
        return this;
    }

    public ResultsPage findADeal() {
        findADealButton.click();
        return new ResultsPage(driver);
    }

}
