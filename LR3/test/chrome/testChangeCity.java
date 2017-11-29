package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

//Done

public class testChangeCity {
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
    public void testChangeCity() throws Exception {
        driver.get(baseUrl);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        try {
            assertEquals("Санкт-Петербург", driver.findElement(By.xpath("//span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        waitAndClick("//span");
        waitAndClick("//div[@id='uiSelect_1']/div/div/div/div");

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//span"))) {
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }
        assertEquals("Москва", driver.findElement(By.xpath("//span")).getText());
    }

    @Test
    public void testChangeCityRussia() throws Exception {
        driver.get(baseUrl);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        try {
            assertEquals("Санкт-Петербург", driver.findElement(By.xpath("//span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        waitAndClick("//span");
        waitAndClick("//a[contains(text(),'Вся Россия')]");


        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.findElement(By.xpath("//span")).getText().equals("Россия")) {
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }
        assertEquals("Россия", driver.findElement(By.xpath("//span")).getText());
    }

    @Test
    public void testChangeCityIKT() throws Exception {
        driver.get(baseUrl);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        try {
            assertEquals("Санкт-Петербург", driver.findElement(By.xpath("//span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        waitAndClick("//span");

        waitAndClick("//input[@type='text']");

        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Иркутск");
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Иркутск");

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("Иркутск (Иркутская область)".equals(driver.findElement(By.xpath("//div[@id='uiSelect_1']/div/div/div[4]/div/div/div")).getText()))
                    break;
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//div[@id='uiSelect_1']/div/div/div[4]/div/div/div")).click();

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.findElement(By.xpath("//span")).getText().equals("Иркутск")) {
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }
        assertEquals("Иркутск", driver.findElement(By.xpath("//span")).getText());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
