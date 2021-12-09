import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
// 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
public class Background{
	
	//add location attributes
	private Image img; 	
	private AffineTransform tx;
	private String[] stage = {"/imgs/bg.png", "/imgs/bg2.png", "/imgs/bg3.png", "/imgs/bg4.png"};
	private int stageNum = 0;
	public Background(int x, int y) {
		img = getImage(stage[stageNum]); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}

	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		
		
		
		g2.drawImage(img, tx, null);
		
		

	}
	/* update the picture variable location */
	private void update() {

		
		
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(0.32, 0.31);
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
	public void changeImage() {
		try {
			if (stageNum < 4) {
				stageNum++;
			}
			else {
				stageNum = 0;
			}
		}
		catch (ArrayIndexOutOfBoundsException ignore) {}
		img = getImage(stage[stageNum]);
	}
	public void resetBg() {
		stageNum = 0;
		img = getImage(stage[stageNum]);
	}

}
