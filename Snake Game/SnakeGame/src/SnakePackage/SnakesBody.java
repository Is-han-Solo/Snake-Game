package SnakePackage;

import java.awt.Graphics;
import java.awt.Color;

public class SnakesBody 
{
	private int mXCoor;
	private int mYCoor;
	private int mWidth;
	private int mHeight;
	
	public SnakesBody(int xCoor, int yCoor, int tileSize)
	{
		mXCoor = xCoor;
		mYCoor = yCoor;
		mWidth = tileSize;
		mHeight = tileSize;
	}
	
	public void tick()
	{
		
	}
	
	public void drawSnakeBody(Graphics snakeBody)
	{
		snakeBody.setColor(Color.YELLOW);
		snakeBody.fillRect(mXCoor * mWidth, mYCoor * mHeight, mWidth, mHeight);
	}

	public int getmXCoor() 
	{
		return mXCoor;
	}

	public void setmXCoor(int xCoor) 
	{
		this.mXCoor = xCoor;
	}

	public int getmYCoor() 
	{
		return mYCoor;
	}

	public void setmYCoor(int yCoor) 
	{
		this.mYCoor = yCoor;
	}
}
