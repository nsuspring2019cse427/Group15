import java.io.File;
import javax.sound.sampled.*;

public class GameSound {

	//Flap 
	public static void flapSound(){
		try{	
			File sound = new File("sounds//flap.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){
			System.out.println("Sound file loading error!");
		}
		
		
	}
	
	
	//Game Over
	public static void hitSound(){
		try{	
			File sound = new File("sounds//die.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){
			System.out.println("Sound file loading error!");
		}
		
		
	}
	
	//Point
	public static void pointSound(){
		try{	
			File sound = new File("sounds//point.wav");
			AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		
		catch(Exception e){
			System.out.println("Sound file loading error!");
		}
		
		
	}

}