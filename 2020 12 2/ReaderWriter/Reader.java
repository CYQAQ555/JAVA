/*  File: Reader.java
 *  The reader will call the methods in DataBaseBuffer class to get the lock for reading.
 *  The last current readers will release the lock, and this activity is also controlled
 *  by the method in DataBaseBuffer class.
 *
 */

public class Reader extends Thread{
	private DataBaseBuffer buffer;
	private ReaderWriterApplet tapplet;
	private int cid;
	int delay  = 6500;
	int status = 0;

	public Reader(ReaderWriterApplet applet, DataBaseBuffer db, int id){
		buffer  = db;
		tapplet = applet;
		cid 	= id;
	}

	public void run(){
		while(true){
		 try{
			 status = 0;
			 tapplet.mc.println(status, "r", cid);
			 sleep((int) (Math.random()*delay));
			 buffer.acquireReadLock(tapplet, cid);
			 sleep((int) (Math.random()*delay));
			 buffer.releaseReadLock(tapplet, cid);
			} catch(InterruptedException e){
				System.err.println("Reader Execption " +  e.toString());
			}
		}
	}
}