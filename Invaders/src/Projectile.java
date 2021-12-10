import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Projectile {
	private int x, y;
	private int v = 10;
	private Image img;
	private AffineTransform tx;
	
	public Projectile(int x, int y) {
		this.x = x;
		this.y = y;
		img = getImage("/imgs/projectile.png");
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
	}
	public void fire() {
		y -= v;
	}
	public void fireEnemy() {
		y += v;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		update();
		g2.drawImage(img, tx, null);
	}
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(3, 3);
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
