package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private static WebDriverWait driverWait;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new NullPointerException("Driver was not initializedd");
        }
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    public static void startDriver(DriverType driverType, int defaultTimeout) {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                setDriver(new ChromeDriver());
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                setDriver(new EdgeDriver());
                break;
            default:
                break;
        }

        setBrowserWait(new WebDriverWait(getDriver(), defaultTimeout));
        setMaximizeWindow();
    }

    public static void startDriver() {
        startDriver(DriverType.FIREFOX);
    }

    public static void startDriver(DriverType driverType) {
        startDriver(driverType, 30);
    }

    public static void setBrowserWait(WebDriverWait wait) {
        DriverFactory.driverWait = wait;
    }

    public static void setMaximizeWindow() {
        DriverFactory.driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}