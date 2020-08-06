package SnakePackage;

import javax.swing.JFrame;

public class Main 
{
	
	protected JFrame mFrame;
	
	protected GameScreen mGameScreen;

	public Main()
	{
		mFrame = new JFrame();
		mGameScreen = new GameScreen();
		
		mFrame.add(mGameScreen);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setTitle("Snake Game");
		
		mFrame.pack();
		mFrame.setVisible(true);
		mFrame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) 
	{
		new Main();	
	}

}
