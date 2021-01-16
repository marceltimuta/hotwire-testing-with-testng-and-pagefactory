import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ResultsPage;
import utils.DriverFactory;
import utils.DriverType;

public class FlightSearchTest {

    private HomePage homePage;
    private ResultsPage resultsPage;

    @BeforeTest
    public void setUp() {
        DriverFactory.startDriver(DriverType.FIREFOX);
        homePage = new HomePage(DriverFactory.getDriver());
        resultsPage = new ResultsPage(DriverFactory.getDriver());
    }

    @AfterTest
    public void cleanUp() {
        DriverFactory.quitDriver();
    }

    @Test
    public void testSearchFlight() {
        homePage.open();
        homePage.selectBundleOption();
        homePage.enterFlight("SFO", "LAX");
        homePage.enterDepartureAndReturning();
        homePage.findADeal();

        Assert.assertTrue(resultsPage.getAvailableVacationsCount() > 0, "No results found");
    }
}
