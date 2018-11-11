/*
 * University of Central Florida
 * COP3330 - Fall 2018
 * Author: Luis Vargas 
 */

package asteroidgame;

import java.awt.Color;
import java.awt.Point;
import blobz.BlobUtils;
import blobz.PolyBlob;
import blobz.BlobAction;
import blobz.BlobProximity;
import blobz.SandBox;
import java.awt.event.KeyEvent;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity
{

	private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    private static SandBox sand; 
    private static final Point [] p = 
    	{
            new Point(10, 0),
            new Point(-10, -7),
            new Point(-5, 0),
            new Point(-10, 7),
        };
    
    public Rocket( int x, int y, SandBox sbx ) 
    {

        // Run super class constructor.
        super( x, y, 0 );
        super.setLoc( x, y );
        sand = sbx;
        super.setColor( Color.magenta );
        super.setDelta(0,0);
        super.setPolygon( p );

    
    }

    public void keyAction( KeyEvent e ) 
    {

        // Left Arrow: Update angle.
        if ( e.getKeyCode() == 37 ) 
        {
            if ( angle - delta < 2*Math.PI ) 
            {
                angle = angle - delta + 2*Math.PI;
                super.setAngle(angle);
            }
            else 
            {
                angle = angle - delta;
                super.setAngle(angle);
            }
        }

        // Up Arrow: Update x and y location.
        else if ( e.getKeyCode() == 38 ) 
        {
            Point p = super.getLoc();
            p.x = p.x + (int) Math.round(speed * Math.cos(angle));
            p.y = p.y + (int) Math.round(speed * Math.sin(angle));
            super.setLoc(p.x, p.y);
        }

        // Right Arrow: Update angle.
        else if ( e.getKeyCode() == 39 ) 
        {
            if ( angle + delta > 2*Math.PI ) 
            {
                angle = angle + delta - 2*Math.PI;
                super.setAngle(angle);
            }
            else 
            {
                angle = angle + delta;
            }   super.setAngle(angle);
        }
        else if ( e.getKeyCode() == 32) 
        {
        	Launch ( sand );
        	BlobUtils.playSound();
        	
        }
    }
    
    public void Launch ( SandBox sb )
    {
    	int boundRadius = this.getSize()/2;
    	
    	Point currentLocation = this.getLoc();
    	Point launchPoint = BlobUtils.rotatePoint( boundRadius+5, angle );
    	int distx = currentLocation.x + launchPoint.x;
    	int disty = currentLocation.y + launchPoint.y;
    	
    	Missile missile = new Missile( distx, disty, angle);
    	sb.addBlob(missile);
    }
    
    
}