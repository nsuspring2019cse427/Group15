import java.io.File;
import javax.sound.sampled.*;

public class GameSound {

	private File sound;

	public GameSound(String audioFilePath){
		this.sound = new File(audioFilePath);
	}

	//Plays the audio file as received as parameters
	public boolean playAudioFeedback(){
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			return true;
		}
		catch(Exception e) {
			System.out.println("Sound file loading error!");
		}
		return false;
	}

}