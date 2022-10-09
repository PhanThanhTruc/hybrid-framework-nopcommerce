package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_URL = "https://admin-demo.nopcommerce.com/";
	
	public static final String PROJECT_PATH= System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER= PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWLOAD_FILE_FOLDER= PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG_FOLDER= PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5= PROJECT_PATH + File.separator + "dragDropHTML5";
	
	public static final String DB_DEV_URL="102.168.1.1:3036";
	public static final String DB_DEV_USER="";
	public static final String DB_DEV_PASS="";
	
	public static final String DB_TEST_URL="102.168.1.1:3036";
	public static final String DB_TEST_USER="";
	public static final String DB_TEST_PASS="";
	
	
	public static final String OS_NAME= System.getProperty("os");
	public static final long SORT_TIME_OUT=5;
	public static final long LONG_TIME_OUT=30;
	public static final long RETRY_TEST_FAIL= 3;
	

}
