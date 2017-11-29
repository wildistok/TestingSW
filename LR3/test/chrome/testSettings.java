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

public class testSettings {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/istokolyas/Documents/Uni/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.banki.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSettings() throws Exception {
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
        driver.findElement(By.xpath("//span[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Настройки')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Настройки')]")).click();
        assertEquals("Редактирование профиля пользователя testSW", driver.getTitle());
        assertEquals("Личные", driver.findElement(By.xpath("//h2")).getText());
        driver.findElement(By.xpath("//h2")).click();
        assertEquals("", driver.findElement(By.xpath("//input[@name='NAME']")).getText());
        assertEquals("", driver.findElement(By.xpath("//input[@name='LAST_NAME']")).getText());
        assertEquals("", driver.findElement(By.xpath("//input[@name='EMAIL']")).getText());
    }

    @Test
    public void testRenameUserSET() throws Exception {
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
        driver.findElement(By.xpath("//span[2]")).click();
        waitElement("//a[contains(text(),'Настройки')]");
        //driver.findElement(By.xpath("//a[contains(text(),'Настройки')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Настройки')]")).click();
        assertEquals("Редактирование профиля пользователя testSW", driver.getTitle());
        driver.findElement(By.xpath("//h2")).click();
        try {
            assertEquals("Тестирование", driver.findElement(By.xpath("//input[@name='NAME']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Тестирование1", driver.findElement(By.xpath("//input[@name='NAME']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//input[@name='NAME']")).clear();
        driver.findElement(By.xpath("//input[@name='NAME']")).sendKeys("Тестирование1");
        driver.findElement(By.xpath("//input[@name='NAME']")).clear();
        driver.findElement(By.xpath("//input[@name='NAME']")).sendKeys("Тестирование1");
        try {
            assertEquals("Сохранить", driver.findElement(By.xpath("//input[@name='save']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//input[@name='save']")).click();
        driver.findElement(By.xpath("//input[@name='save']")).click();
        assertEquals("Тестирование1 ПО", driver.findElement(By.xpath("//section/div[2]/div")).getText());
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

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
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
