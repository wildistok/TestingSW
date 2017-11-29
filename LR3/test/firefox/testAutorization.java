package firefox;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class testAutorization {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/istokolyas/Documents/Uni/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://www.banki.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAutorization() throws Exception {
        driver.get(baseUrl + "/");

        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());


        waitElement("//a/span");
        assertEquals("Вход", driver.findElement(By.xpath("//a/span")).getText());

        driver.findElement(By.xpath("//a/span")).click();
        driver.findElement(By.xpath("//a/span")).click();

        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//input[@id='login']"))) {
                    driver.findElement(By.xpath("//input[@id='login']")).clear();
                    driver.findElement(By.xpath("//input[@id='login']")).sendKeys("testSW");
                    break;
                }
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234Qwerty");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);

        driver.get(baseUrl + "auth/");
        waitElement("//p/strong");

        assertEquals("Вы зарегистрированы и успешно авторизовались.", driver.findElement(By.xpath("//p/strong")).getText());
        assertEquals("Авторизация | Банки.ру", driver.getTitle());

    }


    @Test
    public void testAutorizationNeg() throws Exception {
        driver.get(baseUrl + "/");

        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());


        waitElement("//a/span");
        assertEquals("Вход", driver.findElement(By.xpath("//a/span")).getText());

        driver.findElement(By.xpath("//a/span")).click();
        driver.findElement(By.xpath("//a/span")).click();

        for (int second = 0;; second++) {
            if (second >= 30) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//input[@id='login']"))) {
                    driver.findElement(By.xpath("//input[@id='login']")).clear();
                    driver.findElement(By.xpath("//input[@id='login']")).sendKeys("testSW");
                    break;
                }
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234Qwertq");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.ENTER);

        driver.get(baseUrl + "auth/");
        waitElement("//p/strong");

        waitElement("//a/span");
        assertEquals("Вход", driver.findElement(By.xpath("//a/span")).getText());
        assertEquals("", driver.findElement(By.xpath("//p/strong")).getText());
        assertEquals("Авторизация | Банки.ру", driver.getTitle());

    }

    @Test
    public void testlogOut() throws Exception {
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

        waitElement("//span[2]");
        assertEquals("testSW", driver.findElement(By.xpath("//span[2]")).getText());
        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());
        driver.findElement(By.xpath("//span[2]")).click();


        waitAndClick("//a[contains(text(),'Выход')]");
        waitElement("//a/span");
        assertEquals("Вход", driver.findElement(By.xpath("//a/span")).getText());
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
