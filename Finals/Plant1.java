package a10;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Plant1 extends Plant {

	
	static  BufferedImage image ;
	
	static {	
		
		try {
			image = ImageIO.read(new File("assignment/a10/plant1.png"));
		}catch( IOException e ) {
			System.out.println("File not found");
		}
}
	
	public Plant1(Double startingPosition) {
		super(startingPosition, new Point2D.Double(image.getWidth(), image.getHeight()), 
				image,50,10,10);
	
	}
}