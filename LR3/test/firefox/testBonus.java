package firefox;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testBonus {
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
    public void testBonus() throws Exception {
        driver.get(baseUrl);
        waitClickAd(driver);
        driver.findElement(By.xpath("//a[contains(text(),'Бонусный клуб')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Бонусный клуб')]")).click();


        driver.findElement(By.xpath("//div[@id='main']/div/div/div[2]/div[3]/label/strong")).click();
        driver.findElement(By.xpath("//div[@id='main']/div/div/div[2]/div[4]/button")).click();
        driver.findElement(By.xpath("//div[@id='main']/div/div/div[2]/div[4]/button")).click();
        assertEquals("Бонусный клуб - Банки.ру", driver.getTitle());
        driver.findElement(By.xpath("//a[contains(text(),'БОНУСЫ')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'БОНУСЫ')]")).click();
        assertEquals("КАТЕГОРИИ", driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div[4]/h2")).getText());
        driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div[4]/div/div/a/div[2]/div/div")).click();
        driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div[4]/div/div/a/div[2]/div/div")).click();
        assertEquals("ИНТЕРНЕТ-МАГАЗИНЫ", driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/h2")).getText());
        assertEquals("Aliexpress", driver.findElement(By.xpath("//a[contains(text(),'Aliexpress')]")).getText());
        assertEquals("Сортировка", driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div")).getText());
        driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div[2]/a[2]")).click();
        driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div[2]/a[2]")).click();
        assertEquals("ПО бонусам", driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div[2]/a[2]")).getText());
        assertEquals("Gamiss.com", driver.findElement(By.xpath("//a[contains(text(),'Gamiss.com')]")).getText());
        driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div[2]/a[3]")).click();
        driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div[2]/a[3]")).click();
        assertEquals("ПО новинкам", driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div/div/div[2]/a[3]")).getText());
    }


    @Test
    public void testBonus2() throws Exception {
        driver.get(baseUrl + "/bonus/");
        driver.findElement(By.xpath("//a[contains(text(),'Бонусный клуб')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Бонусный клуб')]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | 7329 | ]]
        driver.findElement(By.xpath("//a[contains(text(),'БОНУСЫ')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'БОНУСЫ')]")).click();
        try {
            assertEquals("", driver.findElement(By.xpath("//input[@name='searchText']")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//input[@name='searchText']")).clear();
        driver.findElement(By.xpath("//input[@name='searchText']")).sendKeys("Aliexpress");
        driver.findElement(By.xpath("//input[@name='searchText']")).clear();
        driver.findElement(By.xpath("//input[@name='searchText']")).sendKeys("Aliexpress");
        assertEquals("Название магазина", driver.findElement(By.xpath("//div[@id='main']/div/div[2]/main/div[2]/div/div[6]/table/thead/tr/th")).getText());
        assertEquals("Aliexpress", driver.findElement(By.xpath("//a[contains(text(),'Aliexpress')]")).getText());
    }

    @Test
    public void testBonusToAli() throws Exception {
        driver.get(baseUrl + "/bonus/");
        driver.findElement(By.xpath("//a[contains(text(),'Бонусный клуб')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Бонусный клуб')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'НАЧАТЬ ПОКУПКИ')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'НАЧАТЬ ПОКУПКИ')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'НАЧАТЬ ПОКУПКИ')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'НАЧАТЬ ПОКУПКИ')]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=60898 | ]]
        assertEquals("Бонусный клуб - Банки.ру", driver.getTitle());
        assertEquals("AliExpress.com - интернет-магазин электроники, модных новинок, товаров для дома и сада, игрушек, товаров для спорта, автотоваров и многого другого.", driver.getTitle());
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

    private static void waitClickAd(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Закрыть']")));
        element.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt='Закрыть']")).click();
    }

}
