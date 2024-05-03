package entities;

import interfaces.MediaPlayer;
import interfaces.Phone;
import interfaces.WebBrowser;

public class IPhone implements MediaPlayer, Phone, WebBrowser {

	public IPhone() {
		super();
	}

	@Override
	public void showPage(String url) {
		System.out.println("Showing page: " + url);

	}

	@Override
	public void refreshPage(String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openNewTab() {
		System.out.println("Opening new tab");

	}

	@Override
	public void call(String number) {
		System.out.println("Calling " + number);

	}

	@Override
	public void answer() {
		System.out.println("Answering the phone");

	}

	@Override
	public void voiceMail() {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		System.out.println("Playing media");

	}

	@Override
	public void pause() {
		System.out.println("Pausing media");

	}

	@Override
	public void stop() {
		System.out.println("Stopping  media");

	}

	@Override
	public void selectMedia(String media) {
		System.out.println("Selecting media");

	}

}
