package firefox;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testSearch {
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
    public void testSearch() throws Exception {
        driver.get(baseUrl + "/");

        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());

        driver.findElement(By.xpath("//input[@name='q']")).clear();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Ипотека");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);


        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.getTitle().equals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру")) {

                } else {
                    assertEquals("Поиск | Банки.ру", driver.getTitle());
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }

        try {
            assertNotEquals("К сожалению, по вашему поисковому запросу ничего не найдено.", driver.findElement(By.xpath("//h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testSearch2() throws Exception {
        driver.get(baseUrl + "/");

        waitClickAd(driver);

        assertEquals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру", driver.getTitle());

        driver.findElement(By.xpath("//input[@name='q']")).clear();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("qweadfqierk;aldfk");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);


        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (driver.getTitle().equals("Банки.ру информационный портал: банки, вклады, кредиты, ипотека, рейтинги банков России | Банки.ру")) {
                } else {
                    assertEquals("Поиск | Банки.ру", driver.getTitle());
                    break;
                }
            } catch (Exception e) {

            }
            Thread.sleep(1000);
        }

        try {
            assertEquals("К сожалению, по вашему поисковому запросу ничего не найдено.", driver.findElement(By.xpath("//main/div[2]")).getText());
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

    private static void waitClickAd(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Закрыть']")));
        element.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//img[@alt='Закрыть']")).click();
    }

}
