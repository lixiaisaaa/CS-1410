package a10;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Example extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	public ArrayList<Actor> actors; // Plants and zombies all go in here
	BufferedImage zombieImage;
	BufferedImage plant1Image;
	BufferedImage plant2Image;

	int numRows;
	int numCols;
	int cellSize;
	int time = 1;
	int i = 1;
	static int moneyOwned = 200;
	Random rand = new Random();
	JFrame app;
	Home home;
	private JButton plant1;
	private JButton plant2;
	private JLabel hasMoney;

	private boolean firstClick;
	private boolean firstClick2;

	/**
	 * Setup the basic info for the example
	 */
	public Example() {

		super();

		// Define some quantities of the scene
		numRows = 5;
		numCols = 7;
		cellSize = 75;
		setPreferredSize(new Dimension(50 + numCols * cellSize, 50 + numRows * cellSize));

		// Store all the plants and zombies in here.
		actors = new ArrayList<>();

		home = new Home(new Point2D.Double(20, i * 75));
		actors.add(home);

		// Load images
		try {
			zombieImage = ImageIO.read(new File("assignment/a10/zombie1.png"));

		} catch (IOException e) {
			System.out.println("A file was not found");
			System.exit(0);
		}

		addMouseListener(this);

		plant1 = new JButton("Plant 1");
		plant2 = new JButton("Plant 2 ");
		hasMoney = new JLabel();
		hasMoney.setText("Money : " + moneyOwned);
		plant1.addActionListener(this);
		plant2.addActionListener(this);

		this.add(hasMoney);
		this.add(plant1);
		this.add(plant2);

		// The timer updates the game each time it goes.
		// Get the javax.swing Timer, not from util.
		timer = new Timer(30, this);
		timer.start();

	}

	/***
	 * Implement the paint method to draw the plants
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Actor actor : actors) {
			actor.draw(g, 0);
			actor.drawHealthBar(g);
		}
	}

	/**
	 * 
	 * This method add the plant into the actor list.
	 * 
	 */
	public void addPlant(Point2D.Double position, int num) {
		int cost = 100;
		Plant plant;
		if (num == 1) {
			cost = 50;
			plant = new Plant1(position);
		} else {
			plant = new Plant2(position);
		}

		if (moneyOwned - cost < 0) {
			System.out.println("Not enough money");
			return;
		}
		for (Actor plants : actors) {
			if (plants instanceof Plant && plant.isCollidingOther(plants)) {
				System.out.println("There is already a plant");
				return;
			}
		}
		moneyOwned = moneyOwned - cost;
		hasMoney.setText("Money : " + moneyOwned);
		actors.add(plant);

	}

	public void addMoney() {
		Money money = new Money(new Point2D.Double(rand.nextInt(525), rand.nextInt(375)));
		actors.add(money);
	}

	public void addZombie() {
		int zombieY = rand.nextInt((numCols - 2)) * 75 + 75;
		int x = rand.nextInt(100);
		Zombie zombie;
		if (x % 2 == 0) {
			zombie = new Zombie1(new Point2D.Double(500, zombieY));
		} else {
			zombie = new Zombie2(new Point2D.Double(500, zombieY));
		}

		actors.add(zombie);
	}

	/**
	 * 
	 * This is triggered by the timer. It is the game loop of this test.
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(plant1)) {
			firstClick = true;
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					if (firstClick2) {
						int x = me.getX();
						int y = me.getY();
						int remainderX = x % 75;
						int remainderY = y % 75;
						if (remainderX > 37) {
							x = x + (75 - remainderX);
						} else {
							x = x - remainderX;
						}
						if (remainderY > 37) {
							y = y + (75 - remainderY);
						} else {
							y = y - remainderY;
						}
						Point2D.Double position = new Point2D.Double(x, y);
						addPlant(position, 2);
						firstClick2 = false;
					}
				}
			});
		}
		this.removeMouseListener(this);
		addMouseListener(this);

		time++;
		int level = 1;

		switch (level) {
		case 1:
			if (time % 100 == 0) {
				this.addZombie();
			}
			if (time % 50 == 0) {
				this.addMoney();
			}
			if (time == 1000) {
				level++;
			}
			break;
		case 2:
			if (time % 20 == 0) {
				this.addZombie();
			}
			if (time % 30 == 0) {
				this.addMoney();
			}
			if (time == 5000)
				break;
		case 3:
			if (time % 5 == 0) {
				this.addZombie();
			}
			if (time % 25 == 0) {
				this.addMoney();
			}
			break;

		}

		// This method is getting a little long, but it is mostly loop code
		// Increment their cooldowns and reset collision status
		for (Actor actor : actors) {
			actor.update();
		}

		// Try to attack
		for (Actor zombie : actors) {
			for (Actor other : actors) {
				zombie.attack(other);
			}
		}

		// Remove plants and zombies with low health
		ArrayList<Actor> nextTurnActors = new ArrayList<>();
		for (Actor actor : actors) {
			if (actor.isAlive())
				nextTurnActors.add(actor);
			else
				actor.removeAction(actors); // any special effect or whatever on removal
		}
		actors = nextTurnActors;

		// Check for collisions between zombies and plants and set collision status
		for (Actor zombie : actors) {
			for (Actor other : actors) {
				zombie.setCollisionStatus(other);
			}
		}

		// Move the actors.
		for (Actor actor : actors) {
			actor.move(); // for Zombie, only moves if not colliding.
		}
		// check if home is still alive
		boolean homeAlive = true;
		if (!actors.contains(home))
			homeAlive = false;
		// Redraw the new scene or game over
		if (homeAlive == false) {
			JOptionPane.showMessageDialog(app, "Game over");
			System.exit(0);
		}

		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point2D.Double point = new Point2D.Double(e.getX(), e.getY());
		for (Actor actor : actors) {
			if (actor.isCollidingPoint(point) && actor instanceof Money) {
				moneyOwned += 25;
				hasMoney.setText("Money : " + moneyOwned);
				actor.changeHealth(-5);
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Make the game and run it
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame app = new JFrame("Plant and Zombie Test");
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Example panel = new Example();

				app.setContentPane(panel);
				app.pack();
				app.setVisible(true);
			}
		});
	}
}
