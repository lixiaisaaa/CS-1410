package a10;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Zombie1 extends Zombie {
static  BufferedImage image ;
	
	static {	
		
		try {
			image = ImageIO.read(new File("assignment/a10/zombie1.png"));
		}catch( IOException e ) {
			System.out.println("File not found");
		}
}
	
	public Zombie1(Double startingPosition) {
		super(startingPosition, new Point2D.Double(image.getWidth(),image.getHeight()), image, 50, 5, -2, 5);
		// TODO Auto-generated constructor stub
	}

	
	}