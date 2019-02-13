public class BirdFlap extends Thread {
	
	private GamePanel panel;
	private Component bird;
	
	
	public BirdFlap(GamePanel panel,Component bird){
		this.panel = panel;
		this.bird = bird;
	}
	
	public void run(){
		int i = 0;
		while(i < 10 && bird.getY() > 0){
			bird.setY(bird.getY() - 6);
			i++;
			
			try{
				super.sleep(15);
			} catch (Exception e){}	
				
			panel.repaint();
		}	
	}
	
	
	

}