
public class AppTest {
	static WedDriver driver;
	@Before
	public void setup
	{
		System.setProperty("webdriver.chrome.driver", System.getenv("webdriver.chrome.driver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tuyendung.cmc.com.vn/");
	}
}
