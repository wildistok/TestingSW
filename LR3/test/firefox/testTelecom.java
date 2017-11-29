package firefox;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testTelecom {
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
    public void testTelecom1() throws Exception {
        driver.get(baseUrl + "telecom/responses/");
        driver.findElement(By.xpath("//a[contains(text(),'Народный рейтинг сотовых операторов')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Народный рейтинг сотовых операторов')]")).click();
        assertEquals("Рейтинг сотовых операторов, у какого мобильного оператора лучшая связь | Банки.ру", driver.getTitle());
        assertEquals("Высшая лига", driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div/div[2]/span")).getText());
        assertEquals("Высшая лига", driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/div/div/header/div/div")).getText());
        driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div[2]/div[2]/span")).click();
        driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div[2]/div[2]/div[2]/div/ul/li[2]/span")).click();
        assertEquals("29 августа 2017", driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div[2]/div[2]/span")).getText());
        driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div/div[2]")).click();
        driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div[2]/div[2]/div/div/ul/li/span")).click();
        assertEquals("Топ 20", driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div/div[2]")).getText());
        driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div[3]/div[2]")).click();
        driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div[2]/div[2]/div[3]/ul/li[2]/a/span")).click();
        assertEquals("Мобильная связь", driver.findElement(By.xpath("//section[@id='companies-rating-container']/div/section/div/div[3]/div[2]/span")).getText());
    }

    @Test
    public void testTelecom2() throws Exception {
        driver.get(baseUrl + "telecom/responses/");
        driver.findElement(By.xpath("//a[contains(text(),'Народный рейтинг сотовых операторов')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Народный рейтинг сотовых операторов')]")).click();
        driver.findElement(By.xpath("//div[@id='intro-block']/div[2]/a")).click();
        driver.findElement(By.xpath("//div[@id='intro-block']/div[2]/a")).click();
        assertEquals("Операторы мобильной связи России, список сотовых операторов и провайдеров связи РФ | Банки.ру", driver.getTitle());
        assertEquals("Операторы мобильной связи России, список сотовых операторов и провайдеров связи РФ | Банки.ру", driver.getTitle());
    }

    @Test
    public void testTelecom3() throws Exception {
        driver.get(baseUrl + "telecom/responses/");
        driver.findElement(By.xpath("//a[contains(text(),'Народный рейтинг сотовых операторов')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Народный рейтинг сотовых операторов')]")).click();
        driver.findElement(By.xpath("//div[@id='intro-block']/div[2]/a[2]")).click();
        driver.findElement(By.xpath("//div[@id='intro-block']/div[2]/a[2]")).click();
        assertEquals("Отзывы о сотовых операторах | Банки.ру", driver.getTitle());
        assertEquals("все отзывы 19338", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div/div[2]")).getText());
        assertEquals("любая", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div[2]/div[2]")).getText());
        assertEquals("все услуги 19338", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div[3]/div[2]")).getText());
        driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div[2]/div[2]/div/ul/li[2]/a/span")).click();
        driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div[2]/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[4]/div")).click();
        driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div[3]/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div[2]/div[2]/div[3]/ul/li[3]/a/span")).click();
        assertEquals("13358", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div/div[2]/span[2]")).getText());
        assertEquals("хорошо", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div[2]/div[2]/span")).getText());
        assertEquals("Мобильный интернет 9492", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div/div/div/div[3]/div[2]")).getText());
        assertEquals("4", driver.findElement(By.xpath("//div[@id='responses-list-app']/div[2]/div[2]/div/article/div[2]/span[2]")).getText());
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
