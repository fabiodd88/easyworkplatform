package it.unisa.studenti.easyworkplatform.proxy;

/**
 * Proxy
 */
public class ProxyImage implements Image{

	/**
	 * Private Proxy data 
	 */
	private String imageFilePath;
	
	/**
	 * Reference to RealSubject
	 */
	private Image proxifiedImage;
	
	
	public ProxyImage(String imageFilePath) {
		this.imageFilePath= imageFilePath;	
	}
	
	@Override
	public void showImage() {

		// create the Image Object only when the image is required to be shown
		
		proxifiedImage = new RealImage(imageFilePath);
		
		// now call showImage on realSubject
		proxifiedImage.showImage();
		
	}
}
