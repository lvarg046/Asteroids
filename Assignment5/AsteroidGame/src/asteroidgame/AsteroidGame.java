/*
 * University of Central Florida
 * COP3330 - Fall 2018
 * Author: Luis Vargas 
 */
 
package asteroidgame;

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;


public class AsteroidGame implements BlobGUI
{
	private static int argsAccess;
	public static void main(String[] args) 
	{
		new AsteroidGame( Integer.parseInt ( ( args[ 0 ]  ) ) );
		argsAccess = Integer.parseInt(( args[ 0 ] ) );
	}

	private final SandBox sb; 
	private final Random random = new Random();
	
	public AsteroidGame ( int i ) 
	{
		sb = new SandBox();
		sb.setSandBoxMode(  SandBoxMode.FLOW );
		sb.setFrameRate( 15 );
		sb.init( this );
	}

	public void generate() 
	{
		int x = sb.getPanelBounds().width / 2;
		int y = sb.getPanelBounds().height / 2;
		Rocket rocket = new Rocket ( x, y, sb);
		sb.addBlob( rocket );
		
		for( int j = 0; j <= argsAccess; j++)
		{
			int ranDelx = 0;
			 while ( ranDelx == 0)
			 {
				 ranDelx = -3 + random.nextInt(7);
			 }
			 
			 int ranDely = 0;
			 while ( ranDely == 0 )
			 {
				 ranDely = -3 + random.nextInt(7);
			 }
			 
			 double rot = .1;
			 int b = random.nextInt(2);
			 if ( b == 0)
			 {
				 rot = -rot;
			 }
			 
			 Asteroids asteroid = new Asteroids( ranDelx, ranDely, rot);
			 sb.addBlob(asteroid);
		}
		
	}
}
