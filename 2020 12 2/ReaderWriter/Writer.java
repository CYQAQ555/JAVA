/*  File: Writer.java
 *
 *  The Writer will try to acquire the lock to access the shared data. It will return the lock
 *  after finish the writing.
 *
 */

public class Writer extends Thread{
	private DataBaseBuffer buffer;
	private ReaderWriterApplet tapplet;
	private int id;
	int delay  = 6500;
	int status = 0;

	public Writer(ReaderWriterApplet applet, DataBaseBuffer db, int id){
		buffer = db;
		tapplet = applet;
		this.id = id;
	}

	public void run(){
		while(true){
			try{
				status = 0;
				tapplet.mc.println(status, "w", id);
				sleep((int)(Math.random()*delay));
				buffer.acquireWriteLock(tapplet, id);
			   	sleep((int) (Math.random()*delay));
				buffer.releaseWriteLock(tapplet, id);
			} catch(InterruptedException e){
				System.err.println("Execption " +  e.toString());
			}
		}
	}
}