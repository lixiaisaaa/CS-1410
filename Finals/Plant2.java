package a10;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Plant2 extends Plant {
	static BufferedImage image;

	static {

		try {
			image = ImageIO.read(new File("assignment/a10/plant2.png"));
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	public Plant2(Double startingPosition) {
		super(startingPosition, new Point2D.Double(image.getWidth(), image.getHeight()), image, 50, 5, 10);

	}

	@Override
	public void attack(Actor other) {
		if (other instanceof Zombie && this.isCollidingOther(other)) {
			super.attack(other);
			if (!other.isAlive()) {
				this.changeHealth(10);

			}
		}
	}

}
