package asteroidgame;

import blobz.BlobUtils;
import blobz.PolyBlob;
import java.awt.Point;
import java.util.Random;

public class Asteroid extends PolyBlob 
{
    public Asteroid(int x, int y, double rotate) 
    {
        super(-100, -100, rotate);
        
        super.setDelta(x, y);
        
        Random random = new Random();
        int numSides = 5 + random.nextInt( 5 );
        Point poly[] = new Point [ numSides ];
        double regSize = ( 2 * Math.PI ) / numSides;
        double[] angle = new double[ numSides ];
        int[] vertex = new int[ numSides ];
        
        for ( int i = 0; i < numSides; i++ )
        {
        	vertex[ i ] = 5 + random.nextInt( 11 );
            angle[ i ] = ( i * regSize ) + ( Math.random() * regSize );
            poly[ i ] = BlobUtils.rotatePoint( vertex[ i ], angle[ i ] );
        }
        
        setPolygon(poly);
        setRate(rotate);
    }

}