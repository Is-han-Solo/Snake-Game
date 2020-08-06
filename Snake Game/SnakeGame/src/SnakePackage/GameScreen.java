package SnakePackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class GameScreen extends JPanel implements Runnable, KeyListener
{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	
	private int mXCoor;
	private int mYCoor;
	private int mSize;
	private int mTicks;
	
	private boolean mRunning;
	private boolean mRight;
	private boolean mLeft;
	private boolean mUp;
	private boolean mDown;
	
	private Thread mThread;
	
	private SnakesBody mSnakeBody;
	
	private SnakeFood mSnakeFood;
	
	private ArrayList<SnakeFood> mFood;
	private ArrayList<SnakesBody> mSnake;
	
	private Random mSpawn;
	
	
	public GameScreen()
	{
		mXCoor = 10;
		mYCoor = 10;
		mSize = 15;
		mTicks = 0;
		
		mRight = true;
		mLeft = false;
		mUp = false;
		mDown = false;
		
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this);
		
		mSnake = new ArrayList<SnakesBody>();
		mFood = new ArrayList<SnakeFood>();
		
		mSpawn = new Random();
		
		
		start();
	}
	
	public void start()
	{
		mRunning = true;
		
		mThread = new Thread(this);
		mThread.start();
	}
	
	public void stop()
	{
		mRunning = false;
		
		try 
		{
			mThread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	public void paint(Graphics graphics)
	{
		graphics.clearRect(0, 0, WIDTH, HEIGHT);
		
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		for (int i = 0 ; i < WIDTH/10 ; i++)
		{
			graphics.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		
		for (int i = 0 ; i < HEIGHT/10 ; i++)
		{
			graphics.drawLine(0, i * 10, HEIGHT, i * 10);
		}
		
		for (int i = 0 ; i < mSnake.size() ; i++)
		{
			mSnake.get(i).drawSnakeBody(graphics);
		}
		
		for (int i = 0 ; i < mFood.size() ; i++)
		{
			mFood.get(i).drawSnakeBody(graphics);
		}
	}
	
	public void tick()
	{
		if (mSnake.size() == 0)
		{
			mSnakeBody = new SnakesBody(mXCoor, mYCoor, 10);
			mSnake.add(mSnakeBody);
		}
		
		mTicks++;
		
		if (mTicks > 1200000)
		{
			if (mRight)
			{
				mXCoor++;
			}
			if (mLeft)
			{
				mXCoor--;
			}
			if (mUp)
			{
				mYCoor--;
			}
			if (mDown)
			{
				mYCoor++;
			}
			
			mTicks = 0;
			
			mSnakeBody = new SnakesBody(mXCoor, mYCoor, 10);
			mSnake.add(mSnakeBody);
			
			if (mSnake.size() > mSize)
			{
				mSnake.remove(0);
			}
		}
		
		if (mFood.size() == 0)
		{
			int xCoor = mSpawn.nextInt(69);
			int yCoor = mSpawn.nextInt(69);
			
			mSnakeFood = new SnakeFood(xCoor, yCoor, 10);
			mFood.add(mSnakeFood);
		}
		
		for (int i = 0 ; i < mFood.size(); i++) 
		{
			if (mXCoor == mFood.get(i).getmXCoor() && mYCoor == mFood.get(i).getmYCoor())
			{
				mSize++;
				mFood.remove(i);
				i++;
			}
		}
		// collision on snake
		for (int i = 0 ; i < mSnake.size() ; i++)
		{
			if (mXCoor == mSnake.get(i).getmXCoor() && mYCoor == mSnake.get(i).getmYCoor())
			{
				if (i != mSnake.size() - 1)
				{
					System.out.println("Game Over!");
					stop();
				}
			}
		}
		// collision on border
		if (mXCoor < 0 || mXCoor > 69 || mYCoor < 0 || mYCoor > 69)
		{
			System.out.println("Game Over!");
			stop();
		}
		
	}

	@Override
	public void run() 
	{
		while (mRunning)
		{
			tick();
			repaint();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT && !mLeft)
		{
			mRight = true;
			mUp = false;
			mDown = false;
		}
		
		if (key == KeyEvent.VK_LEFT && !mRight)
		{
			mLeft = true;
			mUp = false;
			mDown = false;
		}
		
		if (key == KeyEvent.VK_UP && !mDown)
		{
			mUp = true;
			mRight = false;
			mLeft = false;
		}
		
		if (key == KeyEvent.VK_DOWN && !mUp)
		{
			mDown = true;
			mRight = false;
			mLeft = false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}
}
