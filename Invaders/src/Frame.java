import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
// 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
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//CREATE THE OBJECT (STEP 1)
	Background 	bg 	= new Background(0, 0);
	Player player = new Player(155, 400);
	Title title = new Title(15, 100);
	Color black = new Color(0, 0, 0);
	Color white = new Color(255, 255, 255);
	ArrayList<Enemy1> enemy1 = new ArrayList<>(); 
	ArrayList<Enemy2> enemy2 = new ArrayList<>();
	ArrayList<Enemy3> enemy3 = new ArrayList<>();
	ArrayList<Enemy4> enemy4 = new ArrayList<>();
	ArrayList<Projectile> bullet = new ArrayList<>();
	Music impact = new Music("impact_sound.wav", false);
	Music fire = new Music("ship_sound.wav", false);
	Music gameOver = new Music("gameover_sound.wav", false);
	Music levelUp = new Music("levelup_sound.wav", false);
	Music music = new Music("background-sound.wav", true);
	public String check = "Hello";
	public int bulletNum = 1;
	public long start = System.currentTimeMillis();
	public long timeStart = start;
	public boolean init = false;
	public boolean hit = false;
	public boolean firstStart = true;
	public int maxBullet = 0;
	public int score = 0;
	public int index1, index2, index3, index4, indexRemove;
	public int totalTime = 60;
	public int time = totalTime;
	public int increment = 1000;
	public int isGameOver = 0;
	
	public Frame() {
		bullet.add(new Projectile(-5, -5));
		JFrame f = new JFrame("Universe Marauders");
		f.setSize(new Dimension(390, 585));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(20, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		init = true;
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		if (time > 0 && init) {
			updateTime();
		}
		else {
			init = false;
		}
		if (stageClear() && init && !firstStart) {
			calculateTimeScore();
			nextStage();
		}
		bg.paint(g);
		player.paint(g);
		if (firstStart) {
			title.paint(g);
			g.setColor(white);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Click R to Start!", 40, 250);
			g.setFont(new Font("Monospaced", Font.BOLD, 15));
			g.drawString("WASD/Arrow Keys to move, Space to fire", 16, 280);
		}
		g.setColor(black);
		g.setFont(new Font("Monospaced", Font.BOLD, 30));
		g.drawString("Score:"+score, 125, 500);
		g.drawString("Time:"+time, 125, 550);
		if (init && !firstStart) {
			paint1(g);
			paint2(g);
			paint3(g);
			paint4(g);
			for (int i = 0; i < bullet.size(); i++) {
				bullet.get(i).paint(g);
			}
		}
		if (hit) {
			bullet.remove(indexRemove);
			hit = false;
		}
		if (!init) {
			music.stop();
			g.setColor(white);
			g.drawString("Game Over!", 110, 200);
			g.drawString("Click R to Respawn", 30, 250);
			while (isGameOver < 1 && !firstStart) {
				gameOver.play();
				isGameOver++;
			}
			
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
		if (init && !firstStart) {
			player.move();
			for (int i = 0; i < 5-index1; i++) {
				enemy1.get(i).move();
			}
			for (int i = 0; i < 5-index2; i++) {
				enemy2.get(i).move();
			}
			for (int i = 0; i < 5-index3; i++) {
				enemy3.get(i).move();
			}
			for (int i = 0; i < 5-index4; i++) {
				enemy4.get(i).move();
			}
			for (int i = 0; i < bullet.size(); i++) {
				bullet.get(i).fire();
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			int key = arg0.getKeyCode();
			if (key == 68 || key == 39) {
				player.v = 2;
			}
			else if (key == 65 || key == 37) {
				player.v = -2;
			}
			if (!init && key == 82) {
				reset();
			}
			if (firstStart && key == 82) {
				reset();
				firstStart = false;
			}
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
		if (key == 32 && init && !firstStart) {
			long time = System.currentTimeMillis()-start;
			
			if (maxBullet < 1) {
				bullet.add(new Projectile(player.getX()-36, player.getY()));
				fire.play();
				bulletNum++;
				maxBullet++;
			}
			if (time >= 1000) {
				start = System.currentTimeMillis();
				maxBullet = 0;
			}
			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void paint1(Graphics g) {
		try {
			for (int i = 0; i < 5-index1;  i++) {
				enemy1.get(i).paint(g);
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy1.get(i).getY() && bullet.get(x).getY() <= enemy1.get(i).getY()+50 && !enemy1.isEmpty()) {
						if (bullet.get(x).getX() >= enemy1.get(i).getX()-50 && bullet.get(x).getX() <= enemy1.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy1.remove(i);
							index1++;
							score+=5;
						}
					}
				}
			}
		}
		catch (IndexOutOfBoundsException ignore) {}
		
	}
	public void paint2(Graphics g) {
		try {
			for (int i = 0; i < 5-index2;  i++) {
				enemy2.get(i).paint(g);
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy2.get(i).getY() && bullet.get(x).getY() <= enemy2.get(i).getY()+50 && !enemy2.isEmpty()) {
						if (bullet.get(x).getX() >= enemy2.get(i).getX()-50 && bullet.get(x).getX() <= enemy2.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy2.remove(i);
							index2++;
							score+=4;
						}
						
					}
				}
			}
		}
		catch (IndexOutOfBoundsException ignore) {}
		
	}
	public void paint3(Graphics g) {
		try {
			for (int i = 0; i < 5-index3;  i++) {
				enemy3.get(i).paint(g);
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy3.get(i).getY() && bullet.get(x).getY() <= enemy3.get(i).getY()+50 && !enemy3.isEmpty()) {
						if ( bullet.get(x).getX() >= enemy3.get(i).getX()-50 && bullet.get(x).getX() <= enemy3.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy3.remove(i);
							index3++;
							score+=3;
						}
						
					}
				}
			}
		}
		catch (IndexOutOfBoundsException ignore) {}
		
	}
	public void paint4(Graphics g) {
		try {
			for (int i = 0; i < 5-index4;  i++) {
				enemy4.get(i).paint(g);
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy4.get(i).getY() && bullet.get(x).getY() <= enemy4.get(i).getY()+50 && !enemy4.isEmpty()) {
						if (bullet.get(x).getX() >= enemy4.get(i).getX()-50 && bullet.get(x).getX() <= enemy4.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy4.remove(i);
							index4++;
							score+=2;
						}
						
					}
				}
			}
		}
		catch (IndexOutOfBoundsException ignore) {}
		
	}
	public boolean stageClear() {
		if (enemy1.size() == 0 && enemy2.size() == 0 && enemy3.size() == 0 && enemy4.size() == 0) {
			return true;
		}
		return false;
	}
	public void reset() {
		music.loop();
		score = 0;
		bulletNum = 1;
		hit = false;
		maxBullet = 0;
		isGameOver = 0;
		index1 = 0;
		index2 = 0;
		index3 = 0;
		index4 = 0;
		time = 60;
		bullet.clear();
		enemy1.clear();
		enemy2.clear();
		enemy3.clear();
		enemy4.clear();
		start = System.currentTimeMillis();
		timeStart = System.currentTimeMillis();
		increment = 1000;
		for (int i = 0, x = 0; i < 5; i++, x+=60) {
			enemy1.add(new Enemy1(x, 10));
			enemy2.add(new Enemy2(x, 90));
			enemy3.add(new Enemy3(x, 170));
			enemy4.add(new Enemy4(x, 250));
		}
		bullet.add(new Projectile(-5, -5));
		init = true;
	}
	public void nextStage() {
		levelUp.play();
		bulletNum = 1;
		hit = false;
		maxBullet = 0;
		index1 = 0;
		index2 = 0;
		index3 = 0;
		index4 = 0;
		if (totalTime != 25) {
			totalTime -= 5;
		}
		time = totalTime;
		bullet.clear();
		enemy1.clear();
		enemy2.clear();
		enemy3.clear();
		enemy4.clear();
		start = System.currentTimeMillis();
		for (int i = 0, x = 0; i < 5; i++, x+=60) {
			enemy1.add(new Enemy1(x, 10));
			enemy2.add(new Enemy2(x, 90));
			enemy3.add(new Enemy3(x, 170));
			enemy4.add(new Enemy4(x, 250));
		}
		bullet.add(new Projectile(-5, -5));
		
	}
	public void updateTime() {
		long currentTime = System.currentTimeMillis() - timeStart;
		if (currentTime > increment && !stageClear()) {
			time--;
			increment += 1000;
		}
	}
	public void calculateTimeScore() {
		if (stageClear()) {
			score += (time*5);
		}
	}

}
