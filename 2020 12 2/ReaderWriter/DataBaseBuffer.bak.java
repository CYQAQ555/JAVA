/*	DataBaseBuffer.java
 *  This class is the database buffer for writer and reader
*/

import java.awt.*;

public class DataBaseBuffer extends Canvas implements Runnable{
	int[] readWantQ;
	int[] writerWantQ;
	int frameDelay = 2560;

	private int[] buffer;
	private int[] readersQ;
	private int writerID;
	private boolean readLock  = false;		//is reading
	private boolean writeLock = false;		//is writting
	private int readerCount;
	private int readerWantCount, writerWantCount;
	private int writerCount;

	private int readTop, readBottom, writerTop, writerBottom, nums, size;
	private Font font;
	private FontMetrics fm;
	private int x;     					//reader consumed item

	public DataBaseBuffer( ){
		size = 5;    					//defualt buffer size
		nums = 0;
		readTop 	= readBottom  = writerTop 		= writerBottom 	  = 0;
		readerCount = writerCount = readerWantCount = writerWantCount = 0;
		setSize(size);
		resize(500, 300);
		setBackground(Color.white);
		font = new Font("TimesRoman", Font.BOLD, 18);
		fm	 = getFontMetrics(font);
 	 }

	public void run(){
		while(true) {
			try{
				Thread.sleep(frameDelay);
			}catch(InterruptedException e){}
			repaint();
		}
	}

	public void setSize(int s)
	{
		size 		= s;
		buffer  	= new int[size];
		readWantQ 	= new int[size];
		writerWantQ = new int[size];
		readersQ 	= new int[size];
		repaint();
	}

	public synchronized void acquireReadLock(ReaderWriter applet, int id)
	{
		readWantQ[readTop] = id;     //nums is the index for readWantQ
		readTop = (readTop+1) % size;
		readerWantCount ++;
		repaint();
		applet.r[id].status = 4;    //want in
		applet.mb.println(applet.r[id].status, "r", id);

		try{
			applet.r[id].sleep((int) (Math.random()*frameDelay));
			}catch(InterruptedException e) {}

		while(readWantQ[readBottom] != id)
		{
			try{
					applet.r[id].status = 1;
					applet.mb.println(applet.r[id].status, "r", id);
					wait();
				}catch(InterruptedException e) {
					System.err.println("Execption " +  e.toString());
			    }
		}
		if(applet.writerPriority)
		{
			while(writerWantCount != 0)		//if there is a writer is waitting
			{
				try{
					applet.r[id].status = 5;
					applet.mb.println(applet.r[id].status, "r", id);
					wait();
			   		}catch(InterruptedException e) {
				   		System.err.println("Execption " +  e.toString());
			    	}
			}//end of while loop
		}//end of if statement

		while(writeLock)		//if there is any writer is writting
		{
			try{
				applet.r[id].status = 1;
				System.out.println("reader " + id + " is waitting");
				applet.mb.println(applet.r[id].status, "r", id);
				wait();
			}catch(InterruptedException e){
				System.err.println("Execption " +  e.toString());
		    }
		}

		if(readLock == false)
		{
			readLock = true;
			System.out.println("Reader " + id + "locked the buffer");
	    }

		readBottom = (readBottom+1) %size;
		readersQ[nums] = id;
		nums = (nums + 1) % size;
		readerWantCount --;
		readerCount++;
		repaint();
		applet.r[id].status = 2;
		applet.mb.println(applet.r[id].status, "r", id);
		System.out.println("Reader "+id + "is reading");
		notifyAll();
	}

	public synchronized void releaseReadLock(ReaderWriter applet,int id)
	{
			readerCount --;
			if(readerCount == 0) 		//the last reader release the lock
			{ 		readLock = false;
					System.out.println("Reader " + id + "released the lock");
			}
			applet.r[id].status = 7;
			applet.mb.println(applet.r[id].status, "r", id);
			System.out.println("readerCount is " + readerCount);
			notifyAll();
	}

	public synchronized void acquireWriteLock(ReaderWriter applet, int id)
	{
		writerWantQ[writerTop] = id;
		writerTop=(writerTop+1)%size;
		applet.w[id].status = 4;  //want in
		applet.mb.println(applet.w[id].status, "w", id);
		writerWantCount ++;
		repaint();
		try{ applet.w[id].sleep(frameDelay); }
		catch(InterruptedException e) {}

		/** if the writer already be stopped, give the chance to other writers **/
		if(applet.w[id].status == 3)
		{
			writerWantQ[writerBottom] = 0;
			writerBottom = (writerBottom +1) %size;
			System.out.println("writerBottom has been updated after check the writerIndex");
		}

		while(writerWantQ[writerBottom] != id)
		{
			try {
					applet.w[id].status = 6;
					applet.mb.println(applet.w[id].status, "w", id);
					System.out.println("Writer " + id + " is waitting for the turn");
					wait();
				}catch(InterruptedException e){
					System.err.println("Execption " +  e.toString());
			    }
		}

		if(applet.readerPriority)
		{
			while(readerWantCount != 0)
			{
				try{	applet.w[id].status = 5;
						applet.mb.println(applet.w[id].status, "w", id);
						System.out.println("Writer "+id + " is waitting ");
						//repaint();
						wait();
					}catch(InterruptedException e){
						System.err.println("Execption " +  e.toString());
			    	}
			}//end of while loop
		}//end of if

	  while(readLock || writeLock)
	   {
			try{
					applet.w[id].status = 1;
					applet.mb.println(applet.w[id].status, "w", id);
					System.out.println("Writer "+id + " is waitting for the lock");
					//repaint();
					wait();
				}catch(InterruptedException e){
					System.err.println("Execption " +  e.toString());
		       }
		}

		writeLock = true;
		notifyAll();
		writerWantQ[writerBottom] = 0;
		writerBottom = (writerBottom + 1)%size;
		writerID = id;
		writerWantCount --;
		writerCount++;
		repaint();
		applet.w[id].status = 2;
		applet.mb.println(applet.w[id].status, x, "w", id);
	}

	public synchronized void releaseWriteLock(ReaderWriter applet, int id)
	{
		        System.out.println("Writer " + id + " released the lock");
		        writerCount --;
				applet.w[id].status = 7;
				applet.mb.println(applet.w[id].status, x, "w", id);
				writeLock = false;
				notifyAll();
   }


	public void clear()
	{
		size			= 5;
		writerBottom 	= writerTop = 0;
		readBottom 		= readTop 	= 0;
		writerWantCount = 0;
		readerWantCount = 0;
		readerCount 	= 0;
		writerCount 	= 0;
		readLock 		= writeLock = false;
		nums 			= 0;
		buffer 			= new int[size];
		readWantQ 		= new int[size];
		writerWantQ 	= new int[size];
		readersQ 		= new int[size];
		//repaint();
	}

	/* print the queue on the canvas */
	public void paint(Graphics g){
		int xpos = 630;
		int ypos = 5;
		g.setFont(new Font("TimesRoman", Font.BOLD, 11));
		g.setColor(Color.green);
		g.draw3DRect(xpos, ypos, 10, 10, true);
		g.fillRect(xpos, ypos, 10, 10);
		g.drawString("Reading", xpos+15, ypos+10);
		g.setColor(Color.red);
		g.draw3DRect(xpos, ypos+14, 10, 10, true);
		g.fillRect(xpos, ypos+14, 10, 10);
		g.drawString("Writing", xpos+15, ypos+25);
		g.setColor(Color.blue);
		g.draw3DRect(xpos, ypos+28, 10, 10, true);
		g.fillRect(xpos, ypos+28, 10, 10);
		g.drawString("Empty", xpos+15, ypos+40);

		g.setFont(new Font("TimesRoman", Font.BOLD, 14));
		g.setColor(Color.blue);
		xpos = 40;
		ypos = 50;
		g.drawString("Want in Readers", xpos-5, ypos-10);
		g.drawString("Want in Writers", xpos+455, ypos-10);

		/** Draw Want-In readers queue on canvas **/
		int i = readBottom;
		System.out.println("readBottom is: " + readBottom);
		for(int j=0; j< readerWantCount; j++)
		{
			g.drawString(Integer.toString(readWantQ[i]), xpos+30, ypos+15+25*j);
			g.draw3DRect(xpos+20,ypos+25*j, 22, 22, true);
			i = (i+1) % size;
		}

		/** Draw Want-In writers queue on canvas **/
		i = writerBottom;
		for(int j=0; j< writerWantCount; j++)
		{
			g.drawString(Integer.toString(writerWantQ[i]), xpos+507, ypos+15+25*j);
			g.draw3DRect(xpos+500,ypos+25*j, 22, 22, true);
			i = (i+1) % size;
		}

		/** Draw database buffer on canvas      **/
		if(readLock) 	     		g.setColor(Color.green);
		else if(writeLock) 		    g.setColor(Color.red);
		else                 		g.setColor(Color.blue);

		g.draw3DRect(xpos+250, ypos+20, 100, 100, true);
		g.fillRect(xpos+250, ypos+20, 100, 100);
		if(readLock)
		{
			g.setColor(Color.black);
			g.drawString("Reading", xpos + 270, ypos+60);
		}
		else if(writeLock)
		{
			g.setColor(Color.black);
			g.drawString("W " +Integer.toString(writerID), xpos + 280, ypos+45);
			g.drawString("Writting", xpos + 270, ypos+60);
		}
	}
}