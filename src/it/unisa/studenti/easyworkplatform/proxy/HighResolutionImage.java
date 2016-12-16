package it.unisa.studenti.easyworkplatform.proxy;

/**
 * RealSubject
 */
public class HighResolutionImage implements Image{

	
/**
 * @param imageFilePath
 */
public HighResolutionImage(String imageFilePath) {
		
		loadImage(imageFilePath);
	}

	private void loadImage(String imageFilePath) {

		// load Image from disk into memory
		// this is heavy and costly operation
	}

	/* (non-Javadoc)
	 * @see it.unisa.studenti.easyworkplatform.proxy.Image#showImage()
	 */
	@Override
	public void showImage() {

		// Actual Image rendering logic

	}
}
