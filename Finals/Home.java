package a10;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Home extends Plant {
	static BufferedImage image;
	final static int health = 1;
	final static int coolDown = 0;
	final static int attackDamage = 0;

	static {
		try {
			image = ImageIO.read(new File("assignment/a10/home.png"));
		} catch (IOException e) {
			System.out.println("Home not found");
			System.exit(0);
		}
	}

	public boolean isAlive() {
		return health > 0;
	}

	public Home(Point2D.Double position) {
		super(position, new Point2D.Double(image.getWidth(), 5 * 75), image, health, coolDown, attackDamage);

	}

}