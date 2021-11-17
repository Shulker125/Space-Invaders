import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
// 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
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//CREATE THE OBJECT (STEP 1)
	Background 	bg 	= new Background(0, 0);
	Player player = new Player(50, 400);
	ArrayList<Enemy1> enemy1 = new ArrayList<>(); 
	ArrayList<Enemy2> enemy2 = new ArrayList<>();
	ArrayList<Enemy3> enemy3 = new ArrayList<>();
	ArrayList<Enemy4> enemy4 = new ArrayList<>();
	ArrayList<Projectile> bullet = new ArrayList<>();
	public int bulletNum = 1;
	public long start = System.currentTimeMillis();
	public boolean init = false;
	public int maxBullet = 0;
	public int index = 0;
	
	public Frame() {
		bullet.add(new Projectile(-5, -5));
		JFrame f = new JFrame("Space Invaders");
		f.setSize(new Dimension(400, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(true);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		for (int i = 0, x = 0; i < 5; i++, x+=60) {
			enemy1.add(new Enemy1(x, 10));
			enemy2.add(new Enemy2(x, 90));
			enemy3.add(new Enemy3(x, 170));
			enemy4.add(new Enemy4(x, 250));
		}
		init = true;
	}
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		bg.paint(g);
		player.paint(g);
		if (init) {
			for (int i = 0; i < 5-index;  i++) {
				enemy1.get(i).paint(g);
				enemy2.get(i).paint(g);
				enemy3.get(i).paint(g);
				enemy4.get(i).paint(g);
				for (int x = 0; x < bulletNum; x++) {
					if (bullet.get(x).getY() == enemy1.get(i).getY()) {
						enemy1.remove(i);
						index++;
					}
				}
			}
		}
		
		for (int i = 0; i < bulletNum; i++) {
			bullet.get(i).paint(g);
		}
	} 
	 
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	} 
	 
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		player.move();
		for (int i = 0; i < bulletNum; i++) {
			bullet.get(i).fire();
		}
		if (init) {
			for (int i = 0; i < 5-index; i++) {
				enemy1.get(i).move();
				enemy2.get(i).move();
				enemy3.get(i).move();
				enemy4.get(i).move();
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			//System.out.println(arg0.getKeyCode());
			int key = arg0.getKeyCode();
			if (key == 68 || key == 39) {
				player.v = 2;
			}
			else if (key == 65 || key == 37) {
				player.v = -2;
			}
			
			System.out.println(key);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if (key == 68 || key == 39) {
			player.v = 0;
		}
		else if (key == 65 || key == 37) {
			player.v = 0;
		}
		if (key == 32) {
			long time = System.currentTimeMillis()-start;
			
			if (maxBullet < 1) {
				bullet.add(new Projectile(player.getX()-36, player.getY()));
				bulletNum++;
				maxBullet++;
			}
			if (time >= 1000) {
				start = System.currentTimeMillis();
				maxBullet = 0;
			}
			System.out.println(time);
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
