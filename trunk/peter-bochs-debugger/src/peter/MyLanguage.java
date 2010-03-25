package peter;

public class MyLanguage {
	public static String getString(String str) {
		try {
			return Application.language.getString(str);
		} catch (Exception ex) {
			return str;
		}
	}
}
