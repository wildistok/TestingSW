package chrome;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class testService {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/istokolyas/Documents/Uni/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "http://www.banki.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testService() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//span[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")).click();
        assertEquals(driver.getTitle(), "Банки.ру – Профиль пользователя testSW");
        driver.findElement(By.xpath("//a/div[3]/span")).click();
        driver.findElement(By.xpath("//a/div[3]/span")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame |  | ]]
        assertEquals(driver.getTitle(), "Страница предоставляемых услуг");
        driver.findElement(By.xpath("(//a[contains(text(),'Получить')])[8]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Получить')])[8]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Заказать')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Заказать')]")).click();
    }

    @Test
    public void testService1() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//span[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")).click();
        assertEquals("Банки.ру – Профиль пользователя testSW", driver.getTitle());
        driver.findElement(By.xpath("//a/div[3]/span")).click();
        driver.findElement(By.xpath("//a/div[3]/span")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame |  | ]]
        assertEquals("Страница предоставляемых услуг", driver.getTitle());
        driver.findElement(By.xpath("(//a[contains(text(),'Получить')])[8]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'Получить')])[8]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Заказать')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Заказать')]")).click();
        assertEquals("Заказ продукта «Рефинансирование кредита»", driver.getTitle());
    }

    @Test
    public void testPayservice() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//span[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сервисы')]")).click();
        assertEquals("Банки.ру – Профиль пользователя testSW", driver.getTitle());
        driver.findElement(By.xpath("//a/div[3]/span")).click();
        driver.findElement(By.xpath("//a/div[3]/span")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame |  | ]]
        assertEquals("Страница предоставляемых услуг", driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'Получить')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Получить')]")).click();
        assertEquals("Заказ продукта «Кредитная история»", driver.getTitle());
        driver.findElement(By.xpath("//input[@value='Получить кредитную историю']")).click();
        driver.findElement(By.xpath("//input[@value='Получить кредитную историю']")).click();
        assertEquals("Заказ продукта «Кредитная история»", driver.getTitle());
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
}
