package dashboard.cmc.com.settings;

public class Constant {
	public static final String BASE_URL = System.getenv("BASE_URL") != null ? System.getenv("BASE_URL")
			: "http://192.168.66.11:8081/login";
	public static final String USERNAME = System.getenv("USERNAME");
	public static final String PASSWORD = System.getenv("PASSWORD");

	public static String File_MenuData = "TestData.xlsx";
}
