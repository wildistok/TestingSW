package firefox;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testInvest {
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
    public void testInvest() throws Exception {
        driver.get(baseUrl + "/investment/");
        assertEquals("Инвестиции | Банки.ру", driver.getTitle());
        assertEquals("Монитор инвестора Сравните доходность облигаций с доходностью банковских вкладов", driver.findElement(By.xpath("//div[4]/div")).getText());
        try {
            assertEquals("", driver.findElement(By.cssSelector("path.amcharts-plot-area")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//div[2]/ul/li[2]")).click();
        try {
            assertEquals("", driver.findElement(By.cssSelector("path.amcharts-plot-area")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//div[2]/span")).click();
        assertEquals("Открыть брокерский счет", driver.findElement(By.xpath("//div[@id='checkout-popup']/div/div/h2")).getText());
    }

    @Test
    public void testEatInflation() throws Exception {
        driver.get(baseUrl + "/investment/");
        assertEquals("Инвестиции | Банки.ру", driver.getTitle());
        assertEquals("Монитор сохранности моих накоплений", driver.findElement(By.xpath("//section/div")).getText());
        try {
            assertEquals("400 000", driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("1 год", driver.findElement(By.xpath("//div[@id='uiSelect_1']/div/div[2]/span")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("Хранили дома", driver.findElement(By.xpath("//section/div[2]/div/div[2]/div/div")).getText());
        assertEquals("Вложили в акции", driver.findElement(By.xpath("//div[2]/div/div[3]/div/div")).getText());
        driver.findElement(By.xpath("//div[@id='uiSelect_1']/div/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='uiSelect_1']/div[2]/div/div/div/div/div[2]")).click();
        assertEquals("Хранили дома", driver.findElement(By.xpath("//section/div[2]/div/div[2]/div/div")).getText());
        assertEquals("Вложили в акции", driver.findElement(By.xpath("//div[2]/div/div[3]/div/div")).getText());
        try {
            assertEquals("1 000 000", driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
