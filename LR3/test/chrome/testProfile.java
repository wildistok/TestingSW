package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class testProfile {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/istokolyas/Documents/Uni/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://www.banki.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUser() throws Exception {
        driver.get(baseUrl + "/");

        waitClickAd(driver);

        waitElement("//a/span");
        driver.findElement(By.xpath("//a/span")).click();
        driver.findElement(By.xpath("//a/span")).click();

        Thread.sleep(1000);

        waitElement("//input[@id='login']");

        driver.findElement(By.xpath("//input[@id='login']")).clear();
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("testSW");
        driver.findElement(By.xpath("//input[@id='login']")).clear();
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("testSW");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234Qwerty");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234Qwerty");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        driver.get(baseUrl + "/");

            waitAndClick("//span[2]");
            waitAndClick("//a[contains(text(),'Профиль')]");
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try {
                    if ("Банки.ру – Профиль пользователя testSW".equals(driver.getTitle()))
                        break;
                } catch (Exception e) {}
                Thread.sleep(1000);
            }
            assertEquals("Банки.ру – Профиль пользователя testSW", driver.getTitle());
            waitElement("//dd");
            assertEquals("26.11.2017", driver.findElement(By.xpath("//dd")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void waitAndClick(String xpath) {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath(xpath))) {
                    driver.findElement(By.xpath(xpath)).click();

                    break;
                }
            } catch (Exception e) {

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void waitElement(String xpath) {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath(xpath))) {
                    break;
                }
            } catch (Exception e) {

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void waitClickAd(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Закрыть']")));
        element.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt='Закрыть']")).click();
    }

}
