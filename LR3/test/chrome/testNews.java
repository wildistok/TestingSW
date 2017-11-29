package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class testNews {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/istokolyas/Documents/Uni/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://www.banki.ru/";
    }

    @Test
    public void testNews() throws Exception {
        driver.get(baseUrl + "/");
        waitAndClick("//a[@onclick=\"_gaq.push(['_trackEvent', 'Newsblock', 'click', 'lenta']);\"]");

        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            try {
                if ("ЛЕНТА НОВОСТЕЙ".equals(driver.findElement(By.xpath("(//a[contains(text(),'Лента новостей')])[2]")).getText()))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("ЛЕНТА НОВОСТЕЙ", driver.findElement(By.xpath("(//a[contains(text(),'Лента новостей')])[2]")).getText());
        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
    }


     @Test
    public void testNews2() throws Exception {
        driver.get(baseUrl + "/");

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());

        waitAndClick("//a[contains(text(),'Лента\n                        новостей')]");
        //driver.findElement(By.xpath("//a[contains(text(),'Лента\n                        новостей')]")).click();

         for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            try {
                if ("Лента новостей — новости России и мира. Финансовый взгляд. | Банки.ру".equals(driver.getTitle()))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        assertEquals("Лента новостей — новости России и мира. Финансовый взгляд. | Банки.ру", driver.getTitle());
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
            } catch (Exception e) {}
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
