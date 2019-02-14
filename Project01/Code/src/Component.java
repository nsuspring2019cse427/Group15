import javax.swing.*;

import java.awt.*;

public class Component {
	
	private int x;
	private int y;
	private int width, height; 
	private String imagePath;
	
	public Component(int x, int y,int width, int height, String imagePath){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
	}

	
	//Draw Method
	public void draw(Graphics g){
		ImageIcon birdImage = new ImageIcon(imagePath);
		g.drawImage(birdImage.getImage(),x,y,null);
		
	}
	
	
	//Setters of Birds Component
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	//Getters of Component
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
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