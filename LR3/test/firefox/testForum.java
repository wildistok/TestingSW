package firefox;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testForum {
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
    public void testMessage() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//span[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сообщения')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сообщения')]")).click();
        assertEquals("Входящие | Банки.ру", driver.getTitle());
        assertEquals("Форум", driver.findElement(By.xpath("//h1")).getText());
    }

    @Test
    public void testMessageSnd() throws Exception {
        driver.get(baseUrl + "/info/agreement/");
        driver.findElement(By.xpath("//span[2]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сообщения')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сообщения')]")).click();
        driver.findElement(By.xpath("//span[2]/a/span")).click();
        driver.findElement(By.xpath("//span[2]/a/span")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Домашний интернет')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Домашний интернет')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'МГТС')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'МГТС')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Ответить')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Ответить')]")).click();
        driver.findElement(By.xpath("//img[@alt=':wall:']")).click();
        driver.findElement(By.xpath("//img[@alt=':wall:']")).click();
        driver.findElement(By.xpath("//input[@name='send_button']")).click();
        driver.findElement(By.xpath("//input[@name='send_button']")).click();
    }

    @Test
    public void testLikeForum() throws Exception {
        driver.get(baseUrl + "/forum/?PAGE_NAME=topic_new&FID=123");
        driver.findElement(By.xpath("//a[contains(text(),'Сообщения')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Сообщения')]")).click();
        driver.findElement(By.xpath("//span[2]/a/span")).click();
        driver.findElement(By.xpath("//span[2]/a/span")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Конкурс «Банк года»')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Конкурс «Банк года»')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Голосование и обсуждение «Человек года 2017».')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Голосование и обсуждение «Человек года 2017».')]")).click();
        assertEquals("Голосование и обсуждение «Человек года 2017». | Банки.ру", driver.getTitle());
        assertEquals("0", driver.findElement(By.xpath("//table[@id='message6059436']/tbody/tr[2]/td[2]/div/div/div/div/span[2]")).getText());
        assertEquals("1", driver.findElement(By.xpath("//table[@id='message6059436']/tbody/tr[2]/td[2]/div/div/div/div/span[2]")).getText());
        assertEquals("", driver.findElement(By.xpath("//table[@id='message6059436']/tbody/tr[2]/td[2]/div/div/div/div/span")).getText());
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

