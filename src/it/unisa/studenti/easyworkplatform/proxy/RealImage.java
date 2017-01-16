package it.unisa.studenti.easyworkplatform.proxy;

/**
 * RealSubject
 */
public class RealImage implements Image{

	private String fileName;

	public RealImage(String filename) {

		this.fileName = filename;
		loadFromDisk(fileName);
	}

	private void loadImage(String imageFilePath) {

		// load Image from disk into memory
		// this is heavy and costly operation
	}

	@Override
	public void display() {

		// Actual Image rendering logic

	}
	
	private void loadFromDisk(String fileName){
		getClass().getResource(fileName);
	}
}
