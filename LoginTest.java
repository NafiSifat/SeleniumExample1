
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginTest {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ewomack\\Desktop\\java\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://php.thedemosite.co.uk/addauser.php");
		final String userName = "jeff";
		final String password = "test123";

		WebElement usernameBox = driver.findElement(By.name("username"));
		WebElement passwordBox = driver.findElement(By.name("password"));
		WebElement saveBtn = driver.findElement(By.name("FormsButton2"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();

		driver.get("http://php.thedemosite.co.uk/login.php");

		usernameBox = driver.findElement(By.name("username"));
		passwordBox = driver.findElement(By.name("password"));
		saveBtn = driver.findElement(By.name("FormsButton2"));

		usernameBox.sendKeys(userName);
		passwordBox.sendKeys(password);
		saveBtn.click();

		// create a wait with a timeout of 5 seconds
		WebDriverWait wait = new WebDriverWait(driver, 5);
		boolean testElement = false;
		try {
			System.out.println("Searching...");
			testElement = wait
					.until(ExpectedConditions.textToBePresentInElementLocated(
							By.xpath(
									"/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"),
							"Success"));
		} catch (Exception e) {
			e.printStackTrace();
			testElement = false;
		}

		if (testElement)
			System.out.println("Passed");
		else
			System.out.println("Failed");

		driver.close();
		System.exit(0);
	}
}