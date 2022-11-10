import data.AuthData;
import data.PostData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected WebDriver driver;
    protected JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ольга/IdeaProjects/Testing/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    protected void EnterData(AuthData authData) throws InterruptedException {
        driver.findElement(By.cssSelector("*[data-test=\"login-email-input\"]")).sendKeys(authData.login());
        driver.findElement(By.cssSelector("*[data-test=\"login-password-input\"]")).sendKeys(authData.password());
        driver.findElement(By.cssSelector("*[data-test=\"login-submit\"]")).click();
        sleep(8);
    }

    public void CreateTask(PostData postData) {
        driver.get("https://app.clickup.com/30339414/home");
        driver.findElement(By.xpath("/html/body/app-root/cu-app-shell/cu-manager/div[1]/div/div[2]/main/cu-home-page/div/div/cu-user-inbox/div/cu-inbox-section[1]/cu-inbox-list/div/div[1]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"draft-view__title-task\"]")).sendKeys(postData.content());
        driver.findElement(By.cssSelector("*[data-test=\"dropdown__toggle-text\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"st-row__name__List S\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"draft-view__submit-btn_createTask\"]")).click();
    }

    protected void SetSize() {
        driver.manage().window().setSize(new Dimension(1552, 840));
    }

    protected void OpenURL() {
        driver.get("https://app.clickup.com/login");
    }

    public void sleep(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}
