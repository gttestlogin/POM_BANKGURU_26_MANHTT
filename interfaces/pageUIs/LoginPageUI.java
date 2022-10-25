package pageUIs;

public class LoginPageUI {
	public static final String USERID_TEXTBOX = "//input[@name='uid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String LOGIN_BUTTON = "//input[@name='btnLogin']";
	public static final String HERE_LINK = "//a[contains(text(),'here')]";
	public static final String LOGIN_FORM = "//form[@name='frmLogin']";
	
	//public static final String USER_DATA_AT_LOGIN_PAGE= "//div[@id='userdata_el']"; //khong tim thay
	public static final String DELETE_CUSTOMER_FORM_AT_LOGIN_PAGE= "//a[contains(text(),'Delete Customer Form')]";
	public static final String EMAIL_TEXTBOX_AT_REGISTER_PAGE = "//input[@name='emailid']";
	public static final String WELCOME_MESSAGE_AT_HOME_PAGE = "//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"]";
	
	public static final String SELENIUM_DROPDOWN_TOGGLE_AT_LOGIN_PAGE = "//a[@class='dropdown-toggle' and contains(text(),'Selenium')]";

}
