package demo.automation;
public class Alert {
	static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lgthang\\Desktop\\chromedriver_win32_V83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/delete_customer.php");

	}

	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).submit();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).submit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().alert().dismiss();
		/*
		 * String alertMessage = driver.switchTo().alert().getText();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * assertEquals(alertMessage, "Do you really want to delete this Customer?");
		 * driver.switchTo().alert().accept();
		 */
	}

	
	  @After public void close() {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.close(); }
}
