import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {


        GamePanel panel  = new GamePanel();
		
		JFrame  frame = new JFrame();
		frame.setResizable(false);
		frame.add(panel);
		frame.setSize(700, 480);
		frame.setLocation(300, 150);
		frame.setTitle("Happy Bird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.initializeGameComponents();
		
		//waits until Up key pressed
		while (panel.isStarted() == false){			
			try { Thread.sleep(10); } catch (Exception e) { }
		}
		
		//Starts the game
		while(panel.isStarted()){
			panel.gravityPull();
			panel.scrollWalls();
			panel.collisionOrScore();
			panel.scrollBG();
			panel.scrollGround();
			try { Thread.sleep(12); } catch (Exception e) { }
			panel.repaint();
		}
	}
}
