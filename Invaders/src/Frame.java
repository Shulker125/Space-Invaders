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
	ArrayList<Projectile> enemyBullet = new ArrayList<>();
	Music impact = new Music("impact_sound.wav", false);
	Music fire = new Music("ship_sound.wav", false);
	Music gameOver = new Music("gameover_sound.wav", false);
	Music levelUp = new Music("levelup_sound.wav", false);
	Music music = new Music("background-sound.wav", true);
	public String check = "Hello";
	public int bulletNum = 1;
	public long start = System.currentTimeMillis();
	public long timeStart = start;
	public boolean init = false, hit = false, firstStart = true, isStageDisplayed = false;
	public int maxBullet = 0, score = 0, index1, index2, index3, index4, indexRemove, difficulty, multiplier, maxScore;
	public int totalTime = 60, time = totalTime;
	public int increment = 1000;
	public int isGameOver = 0;
	public int stageNum = 1;
	public double bullets;
	
	public Frame() {
		bullet.add(new Projectile(-5, -5));
		enemyBullet.add(new Projectile(-5, -5));
		JFrame f = new JFrame("Universe Marauders");
		f.setSize(new Dimension(390, 600));
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
		if (stageClear() && init && !firstStart && !isStageDisplayed) {
			calculateTimeScore();
			nextStage();
		}
		bg.paint(g);
		player.paint(g);
		if (firstStart) {
			title.paint(g);
			g.setColor(white);
			g.setFont(new Font("Monospaced", Font.BOLD, 20));
			g.drawString("Select Difficulty", 100, 250);
			g.drawString("Easy: Click 1", 120, 270);
			g.drawString("Medium: Click 2", 120, 290);
			g.drawString("Hard: Click 3", 120, 310);
			g.setFont(new Font("Monospaced", Font.BOLD, 15));
			g.drawString("WASD/Arrow Keys to move, Space to fire", 16, 330);
		}
		if (isStageDisplayed) {
			displayStage();
			g.setColor(white);
			g.setFont(new Font("Monospaced", Font.BOLD, 30));
			g.drawString("Stage " + stageNum, 130, 250);
		}
		g.setColor(black);
		g.setFont(new Font("Monospaced", Font.BOLD, 30));
		g.drawString("Score:"+score, 115, 500);
		g.drawString("Time:"+time, 125, 550);
		if (init && !firstStart && !isStageDisplayed) {
			paint1(g);
			paint2(g);
			paint3(g);
			paint4(g);
			for (int i = 0; i < bullet.size(); i++) {
				bullet.get(i).paint(g);
			}
			for (int i = 0; i < enemyBullet.size(); i++) {
				enemyBullet.get(i).paint(g);
			}
		}
		if (hit) {
			bullet.remove(indexRemove);
			hit = false;
		}
		if (collide()) {
			init = false;
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
		if (init && !firstStart && !isStageDisplayed) {
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
			for (int i = 0; i < enemyBullet.size(); i++) {
				enemyBullet.get(i).fireEnemy();
			}
			
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			int key = arg0.getKeyCode();
			System.out.println(key);
			if (key == 68 || key == 39) {
				player.v = 2;
			}
			else if (key == 65 || key == 37) {
				player.v = -2;
			}
			if (!init && key == 82) {
				reset();
			}
			if (firstStart && key == 49) {
				setDifficultyEasy();
				isStageDisplayed = true;
				timeStart = System.currentTimeMillis();
				reset();
				firstStart = false;
			}
			else if (firstStart && key == 50) {
				setDifficultyMedium();
				isStageDisplayed = true;
				timeStart = System.currentTimeMillis();
				reset();
				firstStart = false;
			}
			else if (firstStart && key == 51) {
				setDifficultyHard();
				isStageDisplayed = true;
				timeStart = System.currentTimeMillis();
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
		if (key == 32 && init && !firstStart && !isStageDisplayed) {
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
				spawnBullet(enemy1.get(i).getX()-20, enemy1.get(i).getY());
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy1.get(i).getY() && bullet.get(x).getY() <= enemy1.get(i).getY()+50 && !enemy1.isEmpty()) {
						if (bullet.get(x).getX() >= enemy1.get(i).getX()-50 && bullet.get(x).getX() <= enemy1.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy1.remove(i);
							index1++;
							score+=maxScore;
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
				spawnBullet(enemy2.get(i).getX()-20, enemy2.get(i).getY());
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy2.get(i).getY() && bullet.get(x).getY() <= enemy2.get(i).getY()+50 && !enemy2.isEmpty()) {
						if (bullet.get(x).getX() >= enemy2.get(i).getX()-50 && bullet.get(x).getX() <= enemy2.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy2.remove(i);
							index2++;
							score+=maxScore-1;
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
				spawnBullet(enemy3.get(i).getX()-20, enemy3.get(i).getY());
				for (int x = 0; x < bullet.size(); x++) {
					if (bullet.get(x).getY() >= enemy3.get(i).getY() && bullet.get(x).getY() <= enemy3.get(i).getY()+50 && !enemy3.isEmpty()) {
						if ( bullet.get(x).getX() >= enemy3.get(i).getX()-50 && bullet.get(x).getX() <= enemy3.get(i).getX()) {
							impact.play();
							indexRemove = x;
							hit = true;
							enemy3.remove(i);
							index3++;
							score+=maxScore-2;
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
							score+=maxScore-3;
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
		timeStart = System.currentTimeMillis();
		isStageDisplayed = true;
		music.loop();
		bg.resetBg();
		score = 0;
		bulletNum = 1;
		hit = false;
		maxBullet = 0;
		isGameOver = 0;
		index1 = 0;
		index2 = 0;
		index3 = 0;
		index4 = 0;
		totalTime = time;
		stageNum = 1;
		bullet.clear();
		enemyBullet.clear();
		enemy1.clear();
		enemy2.clear();
		enemy3.clear();
		enemy4.clear();
		increment = 1000;
		bullet.add(new Projectile(-5, -5));
		enemyBullet.add(new Projectile(-5, -5));
		init = true;
	}
	public void nextStage() {
		levelUp.play();
		bg.changeImage();
		if (!firstStart) {
			isStageDisplayed = true;
			timeStart = System.currentTimeMillis();
		}
		bulletNum = 1;
		hit = false;
		maxBullet = 0;
		index1 = 0;
		index2 = 0;
		index3 = 0;
		index4 = 0;
		stageNum++;
		increment = 0;
		if (difficulty == 1) {
			if (totalTime != 30) {
				totalTime -= 5;
			}
		}
		if (difficulty == 2) {
			if (totalTime != 30) {
				totalTime -= 5;
			}
		}
		if (difficulty == 3) {
			if (totalTime != 25) {
				totalTime -= 5;
			}
		}
		
		time = totalTime;
		bullet.clear();
		enemyBullet.clear();
		enemy1.clear();
		enemy2.clear();
		enemy3.clear();
		enemy4.clear();
		bullet.add(new Projectile(-5, -5));
		enemyBullet.add(new Projectile(-5, -5));
		
	}
	public void updateTime() { 
		long currentTime = System.currentTimeMillis() - timeStart;
		if (currentTime > increment && !stageClear() && !isStageDisplayed) {
			time--;
			increment += 1000;
		}
	}
	public void calculateTimeScore() {
		if (stageClear()) {
			score += (time*multiplier);
		}
	}
	public void displayStage() {
		long currentTime = System.currentTimeMillis() - timeStart;
		if (currentTime > 2000) {
			isStageDisplayed = false;
			timeStart = System.currentTimeMillis();
			for (int i = 0, x = 0; i < 5; i++, x+=60) {
				enemy1.add(new Enemy1(x, 10));
				enemy2.add(new Enemy2(x, 90));
				enemy3.add(new Enemy3(x, 170));
				enemy4.add(new Enemy4(x, 250));
			}
		}
	}
	public void spawnBullet(int x, int y) {
		if (Math.random() < bullets) {
			enemyBullet.add(new Projectile(x, y));
		}
	}
	public boolean collide() {
		for (int i = 0; i < enemyBullet.size(); i++) {
			if (enemyBullet.get(i).getX()+65 >= player.getX()+15 && enemyBullet.get(i).getX()+75 <= player.getX()+55) {
				if (enemyBullet.get(i).getY()+10 >= player.getY()+10 && enemyBullet.get(i).getY()+20 <= player.getY()+60) {
					return true;
				}
			}
		}
		return false;
	}
	public void setDifficultyEasy() {
		difficulty = 1;
		time = 60;
		multiplier = 3;
		bullets = 0.001;
		maxScore = 5;
	}
	public void setDifficultyMedium() {
		difficulty = 2;
		time = 60;
		multiplier = 5;
		bullets = 0.002;
		maxScore = 6;
	}
    public void setDifficultyHard() {
		difficulty = 3;
		time = 50;
		multiplier = 10;
		bullets = 0.003;
		maxScore = 8;
	}

}
