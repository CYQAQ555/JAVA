/* File: ReaderWriterApplet.java
 *
 * This is a Java applet file for readers/writers problem animation. The GUI
 * of this applet contains three parts: animation canvas, message canvas
 * and a button panel.
 * The animation canvas is where the readers/writers animation is displayed.
 * The message canvas is where the statues of readers and writers are displayed.
 * The button panel has 6 basic buttons: START, STOP, PAUSE, CONTINUE, FASTER,
 * SLOWER. The user also can select the number of the readers and writers. Unless
 * the user selects different values, the default numbers of readers and writers are 2.
 * This applet also allows the user to choose from "Same Priority", "Readers have Priority"
 * and "Writers have Priority" three situations.
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;
import java.lang.*;

public class ReaderWriterApplet extends Applet
{
	private ReaderWriterApplet applet = this;
	private DataBaseBuffer myBuffer;
	private int buffersize;

	private Button fastButton, slowButton, stopButton, startButton, pauseButton, continueButton;
	private Button stopReaderButton, stopWriterButton;
	private Panel buttonPanel, priorityPanel, namePanel;
	private Choice priority, reader, writer;
	private Thread at;
	private int readerN = 1;
	private int writerN = 1;

	boolean readerPriority = false;
	boolean writerPriority = false;
	boolean samePriority   = true; 	//default priority of readers and writers
	MessageCanvas mc;
	Reader[] r;
	Writer[] w;
	synchronized void startPushed() {notify();}
	synchronized void stopPushed() {notify();}

	public void init() {
		myBuffer = new DataBaseBuffer();
		mc = new MessageCanvas();
		resize(800, 600);
		setLayout(new GridLayout(3, 1));
		add(myBuffer);
		add(mc);

		buttonPanel = new Panel();
		priorityPanel = new Panel();
		namePanel = new Panel();
		Panel bPanel = new Panel(); 	// to hold all buttons and the labels
		bPanel.setFont(new Font("TimesRoman", Font.BOLD, 14));
		bPanel.setLayout(new GridLayout(3, 1));

		buttonPanel.add(startButton 	= new Button("START"));
		buttonPanel.add(stopButton 		= new Button("STOP"));
		buttonPanel.add(pauseButton 	= new Button("PAUSE"));
		buttonPanel.add(continueButton 	= new Button("CONTINUE"));
		buttonPanel.add(fastButton 		= new Button("FASTER"));
		buttonPanel.add(slowButton 		= new Button("SLOWER"));

		Panel choicePanel = new Panel();    //to hold all the choice boxes

		priority = new Choice();
		priority.addItem("Same Priority");
		priority.addItem("Writers Have Priority");
		priority.addItem("Readers Have Priority");
		priority.select("Same Priority");

		Label priorityLabel = new Label("Priority", 2);
		priorityLabel.setBackground(Color.lightGray);

		priorityPanel.add(priorityLabel);
		priorityPanel.add(priority);
		choicePanel.add(priorityPanel);

		reader = new Choice();
		for(int i = 0; i <=5; i++)
		{
			reader.addItem(Integer.toString(i));
		}
		reader.select("1");
		Label readerLabel = new Label("Number of Readers", 2);
		readerLabel.setBackground(Color.lightGray);
		Panel readerPanel = new Panel();
		readerPanel.add(readerLabel);
		readerPanel.add(reader);

		writer = new Choice();

		for(int i = 0; i<=5; i++)
		{
			writer.addItem(Integer.toString(i));
		}
		writer.select("1");
		Label writerLabel = new Label("Number of Writers", 2);
		writerLabel.setBackground(Color.lightGray);
		Panel writerPanel = new Panel();
		writerPanel.add(writerLabel);
		writerPanel.add(writer);

		Label nameLabel = new Label("Readers/Writers Animation");
		nameLabel.setFont(new Font("TimesRoman", Font.BOLD, 18));
		nameLabel.setForeground(Color.blue);
		namePanel.add(nameLabel);
		choicePanel.add(readerPanel);
		choicePanel.add(writerPanel);
		bPanel.add(choicePanel);
		bPanel.add(buttonPanel);
		bPanel.add(namePanel);
		add(bPanel);
	}

	public boolean action(Event evt, Object arg)
	{
		if(evt.target == priority)
		{
			if(arg.equals("Writers Have Priority"))
			{
				writerPriority = true;
				readerPriority = false;
				samePriority   = false;
			}
			else if(arg.equals("Readers Have Priority"))
			{
				readerPriority = true;
				writerPriority = false;
				samePriority   = false;
			}
			else
			{
				readerPriority = false;
				writerPriority = false;
				samePriority   = false;
			}
			return true;
		}
		else if(evt.target == reader)
		{
			readerN = Integer.parseInt(arg.toString());
			return true;
		}
		else if(evt.target == writer)
		{
			writerN = Integer.parseInt(arg.toString());
			return true;
		}
		else if(arg.equals("FASTER"))
		{
			int newDelay;
			if(readerN != 0)      newDelay = r[1].delay;
			else 				  newDelay = w[1].delay;

			newDelay /= 2;
			newDelay = newDelay < 100 ? 100: newDelay;

			for(int i = 1; i <= readerN; i++)
			{
					r[i].delay = newDelay;
			}
			for(int i = 1; i <= writerN; i++)
			{
					w[i].delay = newDelay;
			}
			return true;
		}
		else if(arg.equals("SLOWER"))
		{
			int newDelay;
			if(readerN !=0)       newDelay = w[1].delay;
			else 				  newDelay = r[1].delay;
			newDelay *= 2;
			for(int i = 1; i <= readerN; i++)
			{
				r[i].delay = newDelay;
			}
			for(int i = 1; i <= writerN; i++)
			{
				w[i].delay = newDelay;
			}
			return true;
		}
		else if(arg.equals("PAUSE"))
		{
			for(int i = 1; i <= readerN; i++)
			{
					r[i].suspend();
			}
			for(int i = 1; i <= writerN; i++)
			{
				w[i].suspend();
			}
			fastButton.setEnabled(false);
			slowButton.setEnabled(false);
			return true;
		}
		else if(arg.equals("CONTINUE"))
		{
			for(int i = 1; i <= readerN; i++)
			{
				if(r[i].isAlive()) 	r[i].resume();
			}
			for(int i = 1; i <= writerN; i++)
			{
				if(w[i].isAlive()) 	w[i].resume();
			}
			fastButton.setEnabled(true);
			slowButton.setEnabled(true);
			return true;
		}
		else if(arg.equals("START"))
		{
			r = new Reader[readerN+1];		//Reader[0] is a dummy slot
			w = new Writer[writerN+1];
			System.out.println("readers: "+readerN+" writers: " + writerN);
			mc.setMessage(writerN, readerN);
			myBuffer.setSize(readerN, writerN);
			for(int i = 1; i <= readerN; i++)
			{
				r[i] = new Reader(applet, myBuffer, i);
			}

			for(int i = 1; i <= writerN; i++)
			{
				w[i] = new Writer(applet, myBuffer, i);
			}
			for(int i = 1; i <= writerN; i++)
			{
				w[i].start();
			}
			for(int i = 1; i <= readerN; i++)
			{
				r[i].start();
			}
			fastButton.setEnabled(true);
			slowButton.setEnabled(true);
			startButton.setEnabled(false);
			reader.setEnabled(false);
			writer.setEnabled(false);
			priority.setEnabled(false);
			applet.startPushed();
			return true;
		}
		else if(arg.equals("STOP"))
		{
			for(int i = 1; i <= readerN; i++)
			{
				if(r[i].isAlive())
					r[i].stop();
				r[i] = null;
			}
			for(int i = 1; i <= writerN; i++)
			{
				if(w[i].isAlive())
					w[i].stop();
				 w[i] = null;
			}

			applet.stopPushed();
			startButton.setEnabled(true);
			fastButton.setEnabled(true);
			slowButton.setEnabled(true);
			reader.setEnabled(true);
			writer.setEnabled(true);
			priority.setEnabled(true);

			if(at != null) at.stop();
			at = null;
			return true;
		}
		else{ return false;}
	}
}