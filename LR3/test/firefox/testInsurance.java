package firefox;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testInsurance {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/istokolyas/Documents/Uni/geckodriver");
        driver = new FirefoxDriver();
        baseUrl = "http://www.banki.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOsago() throws Exception {
        driver.get(baseUrl + "insurance/");
        waitClickAd(driver);
        assertEquals("Все виды страхования | Банки.ру", driver.getTitle());
        waitElement("//a/div[2]/div");
        driver.findElement(By.xpath("//a/div[2]/div")).click();
        driver.findElement(By.xpath("//a/div[2]/div")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div/div[2]/div/div/div/div/ul/li/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("(//input[@value='on'])[6]")).click();
        driver.findElement(By.xpath("(//input[@value='on'])[6]")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div[5]/div/div[2]/div/div/label/span")).click();
        driver.findElement(By.xpath("(//input[@value='on'])[6]")).click();
        driver.findElement(By.xpath("(//input[@value='on'])[6]")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div[5]/div/div[2]/div/div/label/span")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals("", driver.findElement(By.xpath("//input[@name='name']")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("+7 (___) ___-__-__", driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("", driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("asdf");
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("asdf");
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("iowl@mail.com");
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("iowl@mail.com");
        assertEquals("Отправить", driver.findElement(By.xpath("(//button[@type='submit'])[2]")).getText());
        assertEquals("Для перехода к результатам расчетов и получения бесплатной консультации независимого эксперта оставьте ваш номер и e-mail.\nИмя\nТелефон\nE-mail\nПодтверждаю свое согласие с условиями передачи данных\nПодтверждаю свое согласие на получение информационных писем от Банки.ру на указанный e-mail\nОтправить", driver.findElement(By.xpath("//div[@id='react-result']/div/div/div[2]/div/div/div")).getText());
        assertEquals("Рассчитать стоимость полиса", driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div/div/div/div")).getText());
    }

    @Test
    public void testKasco() throws Exception {
        driver.get(baseUrl + "/insurance/");
        driver.findElement(By.xpath("//a[2]/div[2]/div")).click();
        driver.findElement(By.xpath("//a[2]/div[2]/div")).click();
        assertEquals("Страховой калькулятор КАСКО, рассчитать стоимость автостраховки КАСКО онлайн, посчитать стоимость полиса КАСКО 2017 во всех страховых компаниях бесплатно | Банки.ру", driver.getTitle());
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div/div[2]/div/div/div/div/ul/li/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        driver.findElement(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//section[@id='react-auto-form']/div/div[2]/div/div/div[2]/div[2]/div/div/span"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("(//input[@value='1'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@value='1'])[2]")).click();
        driver.findElement(By.xpath("//input[@value='2']")).clear();
        driver.findElement(By.xpath("//input[@value='2']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@value='2']")).clear();
        driver.findElement(By.xpath("//input[@value='2']")).sendKeys("2");
        driver.findElement(By.xpath("(//input[@value=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[3]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@value=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[3]")).sendKeys("1");
        driver.findElement(By.xpath("(//input[@value=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[3]")).sendKeys("2");
        driver.findElement(By.xpath("(//input[@value=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[3]")).sendKeys("2");
        driver.findElement(By.xpath("(//input[@value=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[3]")).sendKeys("20");
        driver.findElement(By.xpath("(//input[@value=''])[3]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[3]")).sendKeys("20");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void testHelth() throws Exception {
        driver.get(baseUrl + "/insurance/");
        driver.findElement(By.xpath("//a[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//a[3]/div[2]/div")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Оформить заявку')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Оформить заявку')]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | 41088 | ]]
        assertEquals("Заявка", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
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
