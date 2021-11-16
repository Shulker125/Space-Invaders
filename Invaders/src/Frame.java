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
	Enemy1 enemy1 = new Enemy1(50, 10);
	Enemy2 enemy2 = new Enemy2(50, 90);
	Enemy3 enemy3 = new Enemy3(50, 170);
	Enemy4 enemy4 = new Enemy4(50, 250);
	ArrayList<Projectile> bullet = new ArrayList<>(0);
	public int bulletNum = 1;
	long start = System.currentTimeMillis();
	
	
	
	public void paint(Graphics g) {
		
		super.paintComponent(g);
		bg.paint(g);
		player.paint(g);
		enemy1.paint(g);
		enemy2.paint(g);
		enemy3.paint(g);
		enemy4.paint(g);
		for (int i = 0; i < bulletNum; i++) {
			bullet.get(i).paint(g);
		}
	} 
	 
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	} 
	 
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
		enemy1.move();
		enemy2.move();
		enemy3.move();
		enemy4.move();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			//System.out.println(arg0.getKeyCode());
			int key = arg0.getKeyCode();
			if (key == 68) {
				player.v = 2;
			}
			else if (key == 65) {
				player.v = -2;
			}
			
			
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if (key == 68) {
			player.v = 0;
		}
		else if (key == 65) {
			player.v = 0;
		}
		if (key == 32) {
			long time = System.currentTimeMillis()-start;
			System.out.println(time);
			if (time > 0 && time < 200) {
				bullet.add(new Projectile(player.getX()-36, player.getY()));
				bulletNum++;
			}
			if (time >= 1000) {
				start = System.currentTimeMillis();
			}
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
