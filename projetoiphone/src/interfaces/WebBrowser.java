package interfaces;

public interface WebBrowser {
	void showPage(String url);

	void refreshPage(String url);

	void openNewTab();
}
