package a10;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Zombie2 extends Zombie {
static  BufferedImage image ;
static int speed = -2;
Random rand = new Random(); 
	static {	
		
		try {
			image = ImageIO.read(new File("assignment/a10/zombie2.png"));
		}catch( IOException e ) {
			System.out.println("File not found");
		}
}
	
	public Zombie2(Double startingPosition) {
		super(startingPosition, new Point2D.Double(image.getWidth(),image.getHeight()), image, 40, 3, speed, 4);
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public void move() {
		super.move();
		Double position;
		double positionY;
		position =this.getPosition();
		positionY=position.y;
		
			int x = rand.nextInt(500);
			int y = rand.nextInt(50);
		
			if(x%50==0) {
				if(y%2==0) {
					if ( positionY+75 <450) {
				shiftPosition(new Point2D.Double(0,75));}
			}else
				if(positionY-75 > 0 ) {
			
				shiftPosition(new Point2D.Double(0,-75));}
			
		}
      }
	}