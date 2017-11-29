package firefox;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testChangeCity {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/istokolyas/Documents/Uni/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://www.banki.ru/";
    }

    @Test
    public void testChangeCity() throws Exception {
        driver.get(baseUrl);

        //всплывающая реклама(дождаться и закрыть)
        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        try {
            assertEquals("Санкт-Петербург", driver.findElement(By.xpath("//span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        waitAndClick("//span");
        driver.findElement(By.xpath("//span"));
        waitAndClick("//div[@id='uiSelect_1']/div/div/div/div");

        waitElement("//span");
        assertEquals("Москва", driver.findElement(By.xpath("//span")).getText());

    }

    @Test
    public void testChangeCityRussia() throws Exception {
        driver.get(baseUrl);
        //всплывающая реклама(дождаться и закрыть)
        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        try {
            assertEquals("Санкт-Петербург", driver.findElement(By.xpath("//span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //дождаться элемент и открыть
        waitAndClick("//span");
        waitAndClick("//a[contains(text(),'Вся Россия')]");

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("Россия".equals(driver.findElement(By.xpath("//span")).getText()))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        assertEquals("Россия", driver.findElement(By.xpath("//span")).getText());
    }


    @Test
    public void testChangeCityIKT() throws Exception {
        driver.get(baseUrl);

        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        try {
            assertEquals("Санкт-Петербург", driver.findElement(By.xpath("//span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        waitElement("//span");
        driver.findElement(By.xpath("//span")).click();

        try {
            assertEquals("", driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Иркутск");
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Иркутск");

        try {
            assertEquals("Иркутск", driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("Иркутск (Иркутская область)".equals(driver.findElement(By.xpath("//div[@id='uiSelect_1']/div/div/div[4]/div/div/div")).getText()))
                    break;
            } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='uiSelect_1']/div/div/div[4]/div/div/div")).click();

        waitElement("//span");
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

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
