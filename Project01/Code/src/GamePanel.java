import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class GamePanel  extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	public int WIDTH = 706, HEIGHT = 490;
	private double score = 0; 
	
	//background
	private Component background1 = new Component(0, 0, 700, 490, "images//background.png");
	private Component background2 = new Component(700, 0, 700, 490, "images//background.png");
	//Bird
	private Component bird = new Component((WIDTH/ 2 - 150), (HEIGHT /2) - 40, 50 , 36, "images//bird.png");
	//Wall array
	private Component[] walls = new Component[8];
	//Ground
	private Component ground1 = new Component(0, 445, 750, 490, "images//ground.png");
	private Component ground2 = new Component(700, 445, 750, 490, "images//ground.png");
	//Wall speed
	private int speed = 2;
	//Game Controller
	private boolean started = false, gameOver = false; 
	
	
	//GamePanel Constructor
	public GamePanel(){
		super.addKeyListener(this);
		super.setFocusable(true);
	}
	
	//Create the wall and
	public void Start(){
		createWalls();
	}
	
	
	//Gives bird Some Gravity
	public void Gravity(){	
		
		bird.setY(bird.getY() + 3);						//Starts falling by One Pixel
		
		try{ Thread.sleep(3); } catch (Exception e) {}
		
		// checks if it touches the ground or Sky
		if(bird.getY() > 450 || bird.getY() <= 0){ 
			// Plays hit Sound and if bird touches anything then makes gameOver true.
			if(!gameOver) GameSound.audioFeedback("sounds//die.wav");
			gameOver = true;
			bird.setX(-500);
		}
		
		super.repaint();
	}
	
	
	//Helps wall to shift from left to right 
	public void scrollWalls(){ 
		
		for(int i = 0; i < walls.length; i+=2){
			if(walls[i].getX() > - 150){
				walls[i].setX(walls[i].getX() - speed);
				walls[i+1].setX(walls[i+1].getX() - speed);
			}
			else{
				walls[i].setX(700);
				walls[i+1].setX(700);
					
			}
		}
		
		
		try{ Thread.sleep(5); }  catch(Exception e) {}
		
		super.repaint();
	}
	
	
	
	//Helps wall to shift from left to right 
	public void scrollBG(){ 
			
		//Moves First BG Image
		if(background1.getX() > -700){
			background1.setX(background1.getX() - speed/2);
		} else { background1.setX(700);	}
		
		//Moves Second BG Image
		if(background2.getX() > -700){
			background2.setX(background2.getX() -speed/2);
		} else { background2.setX(700);	}
		
		try{ Thread.sleep(5); }  catch(Exception e) {}
		super.repaint();
	}
	
	
	
	//Helps Ground to shift from left to right 
	public void scrollGround(){ 
		
		//Moves First ground Image
		if(ground1.getX() > -700){
			ground1.setX(ground1.getX() - speed);
		} else {  ground1.setX(700); }
		
		//Moves First ground Image
		if(ground2.getX() > -700){	
			ground2.setX(ground2.getX() -speed);
		} else {  ground2.setX(700); }
		
		//interval
		try{ Thread.sleep(5); }  catch(Exception e) {}
		super.repaint();
	}
	
	
	//Draws All Components on panel
	public void paint(Graphics g){
		
		//Draws backgrounds
		background1.draw(g);
		background2.draw(g);
		
		//Draws Bird
		bird.draw(g);
		
		//Draws Walls
		for(int i = 0; i < walls.length; i++){
			walls[i].draw(g);
		}
	
		////Draws Texts
		if (gameOver) {	
			g.setFont(new Font("Arial", 1, 40));
			g.setColor(Color.red.brighter().brighter().brighter());
			g.drawString("Game Over!", 235, HEIGHT / 2 - 50);
		} 
		
		if(!started || gameOver){
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 1, 20));
			g.drawString(String.valueOf("Press Up key to Play"), 10 , 25);
		}
		
		else if (!gameOver && started){	
			g.setColor(Color.green);
			g.setFont(new Font("Arial", 1, 20));
			g.drawString(String.valueOf("Score:"+score), 10 , 25);
		}
		
		//Draws Grounds
		ground1.draw(g);
		ground2.draw(g);
		
	}
	
	
	//Checks Collisions between wall and bird
	public void checkCollision(){
		
		//Creates bound of bird
		Rectangle birdBound = new Rectangle( bird.getX(), bird.getY(),25,25);
		
		//Creates bound of all walls
		for(int i = 0; i < walls.length; i++){
			Rectangle WallRect=new Rectangle(walls[i].getX(),walls[i].getY(),walls[i].getWidth(),walls[i].getHeight());
			if(WallRect.intersects(birdBound)==true){
				bird.setX(-500);
				if(!gameOver) GameSound.audioFeedback("sounds//die.wav");
				gameOver = true;
				break;
			} else if(bird.getX() == walls[i].getX()+1){
				//if bird passes one wall then counts a point
				score();
			}	
		}
		
	}
	
	
	//When any key press this code executes 
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE){
			//Starts the game
			if(!started) {
				started = true;
			}
			
			//Restarts The Game if its Over
			if(gameOver){
				bird.setY((HEIGHT /2));
				bird.setX(WIDTH/2 - 150);
				score = 0;
				gameOver = false;
			}
				
			//Flaps if key pressed
			BirdFlap flap = new BirdFlap(this,bird);
			flap.start();
			GameSound.audioFeedback("sounds//flap.wav");
		}
	
	}
	
	
	//Increments the score
	public void score(){
		score+= 0.5;
		GameSound.audioFeedback("sounds//point.wav");
	}
	
	public void createWalls(){
		int i = 0;
		int x = 600; // First walls distance from very right side
		
		//walls width and height, width is static and height changes constantly
		int width = 60, height = 280; 
		
		
		//1st & 2nd wall
		walls[i] = new Component(x, 280, width, height, "images//wallUp.png");
		i++;
		walls[i] = new Component(x, -90, width, height, "images//wallDown.png");
		x = walls[i].getX()+220; // 160 is the difference between wall
		i++;
		
		//3rd & 4th wall
		walls[i] = new Component(x, 360, width, height, "images//wallUp.png");
		i++;
		walls[i] = new Component(x, -10, width, height, "images//wallDown.png");
		x = walls[i].getX()+220;
		i++;
		
		
		//5rd & 6th wall
		walls[i] = new Component(x, 280, width, height, "images//wallUp.png");
		i++;
		walls[i] = new Component(x, -90, width, height, "images//wallDown.png");
		x = walls[i].getX()+220;
		i++;
		
		
		//7rd & 8th wall
		walls[i] = new Component(x, 220, width, height, "images//wallUp.png");
		i++;
		walls[i] = new Component(x, -170, width, height, "images//wallDown.png");
		x = walls[i].getX()+220;
		
	}
	
	//Setters anmd Getters
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	//Key Events
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
