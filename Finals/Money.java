package a10;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Money extends Actor {
	Random rand = new Random();
	private static int speed = 2;
	static BufferedImage image;
	static {

		try {
			image = ImageIO.read(new File("assignment/a10/money.png"));
		} catch (IOException e) {
			System.out.println("File not find");
			System.exit(0);
		}
	}

	public Money(Point2D.Double startingPosition) {
		super(startingPosition, new Point2D.Double(image.getWidth(), image.getHeight()), image, 1, 1, speed, 0);

	}

	@Override
	public void move() {
		int x = rand.nextInt(100);
		if (x % 3 == 0) {
			shiftPosition(new Point2D.Double(speed, 0));
		}
		if (x % 4 == 0) {
			shiftPosition(new Point2D.Double(0, speed));
		}

	}
}