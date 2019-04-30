import javax.swing.*;

import java.awt.*;
import java.io.File;

public class Component {
	
	private int x;
	private int y;
	private int width, height;
	private String imagePath;
	
	public Component(int x, int y, int width, int height, String imagePath){
		this.setX(x);
		this.setY(y);
		this.setHeight(height);
		this.setWidth(width);
		this.setImagePath(imagePath);
	}
	
	//Draw Method
	public boolean draw(Graphics g){
		ImageIcon birdImage = new ImageIcon(imagePath);
		return (g.drawImage(birdImage.getImage(),x,y,null));
	}

	public boolean detectCollision(Component component){
		//Creates bound of bird and walls
		Rectangle boundOne = new Rectangle( this.getX(), this.getY(),this.getWidth(),this.getHeight());
		Rectangle BoundTwo = new Rectangle(component.getX(),component.getY(),component.getWidth(),component.getHeight());
		return boundOne.intersects(BoundTwo);
	}

	//Setters of Component
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		if (width >= 0)
			this.width = width;
		else throw new RuntimeException("Cannot set negative width");
		return;
	}
	public void setHeight(int height) {
		if (height >= 0)
			this.height = height;
		else throw new RuntimeException("Cannot set negative height");
		return;
	}

	public void setImagePath(String imagePath) {
		// Check to see if a file exists, set link if exists.
		File file = new File(imagePath);
		if (file.exists() && file.isFile() && imagePath != null) {
			this.imagePath = imagePath;
		} else throw new RuntimeException("Invalid file");
		return;
	}

	//Getters of Component
	public int getX() { return x; }
	public int getY() { return y; }
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getImagePath() {
		return imagePath;
	}
	
}
