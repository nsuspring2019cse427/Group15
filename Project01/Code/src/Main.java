import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		
		GamePanel panel  = new GamePanel(); 
		
		JFrame  frame = new JFrame();
		frame.setResizable(false);
		frame.add(panel);
		frame.setSize(706, 488);
		frame.setLocation(300, 150);
		frame.setTitle("Happy Bird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.Start();
		
		//waits until Up key pressed
		while (panel.isStarted() == false){			
			try { Thread.sleep(10); } catch (Exception e) { }
		}
		
		
		//Starts the game
		while(panel.isStarted()){
			panel.Gravity();
			panel.scrollWalls();
			panel.checkCollision();
			panel.scrollBG();
			panel.scrollGround();
			
		}	
	}
}
