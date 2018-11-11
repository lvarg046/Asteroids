
import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;
import java.util.Random;

import asteroidgame.Asteroids;

public class AsteroidField implements BlobGUI 
{
	
	private static int argsAccess; // This is so the args can be accessed outside of the main method

	public static void main(String[] args)
	{
		new AsteroidField( Integer.parseInt( args[0] ) );
		argsAccess = Integer.parseInt(args[0]); 
    }

    private final SandBox sandb;
    private final Random random = new Random();
  
    // Initializes/creates the AsteroidField
    public AsteroidField(int i)
    {
        sandb = new SandBox();
        sandb.setSandBoxMode(SandBoxMode.FLOW);
        sandb.setFrameRate(15);
        sandb.init(this);
    }

    @Override
    public void generate() // Generates the asteroid field
    { 
        for (int i = 1; i <= argsAccess; i++)  // This line is KEY. This determines how many Asteroids to generate
        {
            int delta_X = 0;
            while (delta_X == 0)
            {
                delta_X = -3 + random.nextInt(7);
            }
            
            int delta_Y = 0;
            while (delta_Y == 0)
            {
                delta_Y = -3 + random.nextInt(7);
            }
          
            double rotate = .1;
            int b = random.nextInt(2);
            if (b == 0)
            {
                rotate = -rotate;
            }
          
            Asteroids asteroid = new Asteroids(delta_X, delta_Y, rotate);
            
            sandb.addBlob(asteroid);
        }
      
    }

  
}