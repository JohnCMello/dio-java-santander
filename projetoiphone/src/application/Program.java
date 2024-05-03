package application;

import entities.IPhone;

public class Program {

	public static void main(String[] args) {
		IPhone iphone = new IPhone();
		
		iphone.call("+55 48 99876-5432");
		
		iphone.play();
		
		iphone.stop();
		
		iphone.selectMedia("Black Sabbath - Paranoid.mp4");
		
		iphone.pause();
		
		iphone.showPage("www.google.com");
		
		iphone.openNewTab();
		
		iphone.showPage("www.stackoverflow.com");
	}

}
