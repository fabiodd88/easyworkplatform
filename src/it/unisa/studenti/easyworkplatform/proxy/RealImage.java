package it.unisa.studenti.easyworkplatform.proxy;

/**
 * RealSubject
 */
public class RealImage implements Image{

	
public RealImage(String imageFilePath) {
		
		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {

		// load Image from disk into memory
		// this is heavy and costly operation
	}

	@Override
	public void showImage() {

		// Actual Image rendering logic

	}
}
