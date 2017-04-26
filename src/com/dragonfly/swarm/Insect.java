package com.dragonfly.swarm;

import java.util.Random;

public class Insect {
	public static enum Tendancy { AUDACIOUS, CONSERVATIVE, SHEEP }
	
	private int posX;
	private int posY;
	private int velocity;
	private Best personalBest;
	private Best audaciousHeading;
	private Tendancy tendancy;
	private int environmentWidth;
	private int environmentHeight;
	
	public Insect(int posX, int posY, int environmentWidth, int environmentHeight, Tendancy tendancy) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.velocity = 1;
		this.environmentHeight = environmentHeight;
		this.environmentWidth = environmentWidth;
		this.tendancy = tendancy;
		this.personalBest = new Best();
		
		personalBest.set(posX, posY, 0.0);
		this.audaciousHeading = new Best();
		if(tendancy==Tendancy.AUDACIOUS) calculateAudaciousHeading();
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public Best getPersonalBest() {
		return personalBest;
	}

	public void setPersonalBest(Best personalBest) {
		this.personalBest = personalBest;
	}
	
	public void move(Double currentValue, Best globalBest) {
		System.out.println("Insect position : " + posX + ", " + posY);
		
		System.out.println("Personal Best : " + personalBest.posX + ", " + personalBest.posY + " " + personalBest.value);
//
		if(currentValue > personalBest.getValue()) {
			personalBest.set(posX, posY, currentValue);
		}
		
		System.out.println("Personal Best : " + personalBest.posX + ", " +  personalBest.posY + " " + personalBest.value);
		
		switch (tendancy) {
			// insect continues the search
			case AUDACIOUS : 	calculateNewPosition(this.posX, this.posY, audaciousHeading.posX, audaciousHeading.posY, 1);
								break;
			// insect heads back towards personal best
			case CONSERVATIVE : calculateNewPosition(this.posX, this.posY, personalBest.posX, personalBest.posY, 1);
								break;
			// insect heads towards swarm global best
			case SHEEP : 		calculateNewPosition(this.posX, this.posY, globalBest.posX, globalBest.posY, 1);
								break;
			default : break;
		}
		
		System.out.println("Insect position : " + posX + ", " + posY);
	}
	
	private void calculateAudaciousHeading() {
		Random random;
		
		random = new Random();
		int x = random.nextInt(this.environmentWidth);
		random = new Random();
		int y = random.nextInt(this.environmentHeight);
		
		audaciousHeading.set(x, y, 0.0);
	}
	
	private void calculateNewPosition(int origX, int origY, int destX, int destY, int velocity){
		    int t, distance;
		    int xerr=0, yerr=0, delta_x, delta_y;
		    int incx, incy;
		 
		    /* compute the distances in both directions */
		    delta_x=destX-origX;
		    delta_y=destY-origY;
		 
		    /* Compute the direction of the increment,
		       an increment of 0 means either a horizontal or vertical
		       line.
		    */
		    if(delta_x>0) incx=1;
		    else if(delta_x==0) incx=0;
		    else incx=-1;
		 
		    if(delta_y>0) incy=1;
		    else if(delta_y==0) incy=0;
		    else incy=-1;
		 
		    /* determine which distance is greater */
		    delta_x=Math.abs(delta_x);
		    delta_y=Math.abs(delta_y);
		    if(delta_x>delta_y) distance=delta_x;
		    else distance=delta_y;
		 
		    /* draw the line */
		    //for(t=0; t<=distance+1; t++) {
		    for(t=0; t<=velocity+1; t++) {
		         
		        setPosX(origX);
				setPosY(origY);
				
		        xerr+=delta_x;
		        yerr+=delta_y;
		        if(xerr>distance) {
		            xerr-=distance;
		            origX+=incx;
		        }
		        if(yerr>distance) {
		            yerr-=distance;
		            origY+=incy;
		        }
		    }
		    
		
	}
	
}
