import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class GamePanel  extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Game sounds initialization, fixes after testing the GameSound Class
	 *
	 */
	protected GameSound dieSound = new GameSound("sounds//die.wav");
	protected GameSound pointSound = new GameSound("sounds//point.wav");
	protected GameSound flapSound = new GameSound("sounds//flap.wav");

	public final int WIDTH = 700, HEIGHT = 490;
	protected double points = 0;
	
	//background
	protected Component background1 = new Component(0, 0, 700, 490, "images//background.png");
	protected Component background2 = new Component(700, 0, 700, 490, "images//background.png");

	//Bird
	protected Component bird = new Component((WIDTH/ 2 - 150), (HEIGHT /2) - 40, 25 , 25, "images//bird.png");

	//Wall array
	protected Component[] walls = new Component[8];

	//Ground
	protected Component ground1 = new Component(0, 445, 710, 490, "images//ground.png");
	protected Component ground2 = new Component(705, 445, 710, 490, "images//ground.png");

	//Game Controller
	protected boolean started = false, gameOver = false;
	
	//GamePanel Constructor
	public GamePanel(){
		super.addKeyListener(this);
		super.setFocusable(true);
	}
	
	//Create the wall and
	public void initializeGameComponents(){
		createWalls();
	}

	//Gives bird Some Gravity
	public void gravityPull(){
		//Starts falling by One Pixel
		bird.setY(bird.getY() + 2);
	}
	
	//Helps wall to shift from left to right 
	public void scrollWalls(){
		for(int i = 0; i < walls.length; i+=2) {
			if (walls[i].getX() > -150) {
				walls[i].setX(walls[i].getX() - 2);
				walls[i + 1].setX(walls[i + 1].getX() - 2);
			} else {
				walls[i].setX(700);
				walls[i + 1].setX(700);
			}
		}
	}
	
	//Helps wall to shift from left to right 
	public void scrollBG(){

		//Moves First BG Image
		if(background1.getX() > -700){
			background1.setX(background1.getX() - 1);
		} else { background1.setX(700);	}
		
		//Moves Second BG Image
		if(background2.getX() > -700){
			background2.setX(background2.getX() -1);
		} else { background2.setX(700);	}

	}

    //Helps wall to shift from left to right
    public void flap(){
        bird.setY(bird.getY() - 6);
    }
	
	
	//Helps Ground to shift from left to right 
	public void scrollGround(){ 
		
		//Moves First ground Image
		if(ground1.getX() > -700){
			ground1.setX(ground1.getX() - 2);
		} else {  ground1.setX(700); }
		
		//Moves Second ground Image
		if(ground2.getX() > -700){	
			ground2.setX(ground2.getX() -2);
		} else {  ground2.setX(700); }
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
			g.drawString(String.valueOf("Score:"+points), 10 , 25);
		}

		//Draws Grounds
		ground1.draw(g);
		ground2.draw(g);
	}

	//Checks Collisions between wall and bird
	public void collisionOrScore(){
		//Creates bound of all walls
		for(int i = 0; i < walls.length; i++) {
			if (bird.detectCollision(walls[i]) || bird.getY() > 450 || bird.getY() <= 0) {
				bird.setX(-500);
				if (!gameOver) dieSound.playAudioFeedback();
				gameOver = true;
				break;
			} else if (bird.getX() == walls[i].getX()) {
				//if bird passes one wall then counts a point
				this.points = incrementScore(this.points, 0.5);
				pointSound.playAudioFeedback();
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
				points = 0;
				gameOver = false;
			}

			//Flaps if key pressed
			BirdFlap flap = new BirdFlap(this);
			flap.start();
			flapSound.playAudioFeedback();
		}
	
	}
	
	//Increments the score
	public double incrementScore(double points, double amount){
		if(points >= 0)
			points += amount;
		return points;
	}
	
	public void createWalls(){

		int initialPipeDistance = 600;
		//walls width and height, width is static and height changes constantly
		int width = 60, height = 280;
		for(int i = 0; i < walls.length; i++){
			int y = ThreadLocalRandom.current().nextInt(180, 360);
			walls[i] = new Component(initialPipeDistance, y, width, height, "images//wallUp.png");
			i++;
			walls[i] = new Component(initialPipeDistance, y-370, width, height, "images//wallDown.png");
			initialPipeDistance = initialPipeDistance + 220;
		}
	}
	
	//Setters and Getters
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
