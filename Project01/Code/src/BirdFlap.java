public class BirdFlap extends Thread {
	
	private GamePanel panel;
	
	
	public BirdFlap(GamePanel panel){
		this.panel = panel;
	}
	
	public void run(){
		int i = 0;
		while(i < 10){
			panel.flap();
			i++;
			
			try{
				super.sleep(15);
			} catch (Exception e){}	
				
			panel.repaint();
		}	
	}

}