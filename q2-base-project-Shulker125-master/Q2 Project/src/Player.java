import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player {
	private int x, y;
	public static int v = 0;
	private Image img;
	private AffineTransform tx;
	
	public Player() {
		x = 0;
		y = 0;
	}
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/Player.gif");
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
	}
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.07, 0.07);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	public void move() {
		if (x > 0 && x < 300) {
			x += v;
		}
	}
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
