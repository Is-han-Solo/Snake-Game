package SnakePackage;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeFood 
{
	private int mXCoor;
	private int mYCoor;
	private int mWidth;
	private int mHeight;
	
	public SnakeFood(int xCoor, int yCoor, int tileSize)
	{
		mXCoor = xCoor;
		mYCoor = yCoor;
		mWidth = tileSize;
		mHeight = tileSize;
	}
	
	public void tick()
	{
		
	}
	
	public void drawSnakeBody(Graphics snakeFood)
	{
		snakeFood.setColor(Color.RED);
		snakeFood.fillRect(mXCoor * mWidth, mYCoor * mHeight, mWidth, mHeight);
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
