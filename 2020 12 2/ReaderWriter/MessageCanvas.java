/* File: MessageCanvas.java
 *
 * This class provides message canvas for the applet GUI.
 * It will print the statuses of readers and writers on the GUI.
 *
 */

import java.awt.*;

class MessageCanvas extends Canvas
{
	private Font font;
	private FontMetrics fm;
	private int[] writerStatus;
	private int[] readerStatus;
	private int msgHeight;
    private int msgWidth;
	private int pn, cn;
	private int frameDelay = 256;

	public MessageCanvas( )
	{
		resize(size().width, 50);
		setBackground(Color.green);
		font = new Font("TimesRoman", 1, 18);
		fm = getFontMetrics(font);
        msgHeight = fm.getHeight();

	}

   public void setMessage(int writerN, int readerN)
    {
		pn = writerN;
		cn = readerN;
		writerStatus = new int[pn+1];
		readerStatus = new int[cn+1];
		repaint();
    }


    void println(String s)
    {
        msgWidth = fm.stringWidth(s);
        repaint();
    }

    void println(int s, String st, int id)
	{
	        if(st.equals("w"))
			 	writerStatus[id] = s;
			else
				readerStatus[id] = s;
	        repaint();
   }

	void println(int s, int number, String st, int id)
	{
		        if(st.equals("w"))
		        {
				 	writerStatus[id] = s;
				}
				else
				{
					readerStatus[id] = s;
				}
		        repaint();
   }


    public void paint(Graphics g)
    {
        g.setFont(font);
        int xpos = 60;
        int ypos = 40;

		g.drawString("Status of Readers: ", 60, 20);
		g.drawString("Status of Writers: ", 360, 20);
		g.setFont(new Font("TimesRoman", 1, 14));

		/** print on canvas the status of writers and readers **/

		for(int i=1; i<=cn;i++)
		{
			g.setColor(Color.black);
			g.drawString("R" + i, xpos, ypos+(15*i+10*(i-1)));
			if(readerStatus[i] == 0)
			{
				g.setColor(Color.yellow);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Sleeping ...", xpos+120, ypos+(15*i + 10*(i-1)));
			}
			else if (readerStatus[i] == 1)
			{
				g.setColor(Color.gray);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Want to read", xpos+120, ypos+(15*i + 10*(i-1)));
			}
			else if (readerStatus[i] == 3)
			{
				g.setColor(Color.gray);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Waiting in the queue", xpos+120, ypos+(15*i + 10*(i-1)));
			}
			else if (readerStatus[i] == 2)
			{
				g.setColor(Color.blue);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Reading...", xpos+120, ypos+(15*i + 10*(i-1)));
			}
		}
	 	xpos = 360;
	 	ypos = 40;
        for(int i=1; i<=pn; i++)
        {
			g.setColor(Color.black);
			g.drawString("W" + i, xpos, ypos+(15*i+10*(i-1)));
			if(writerStatus[i] == 0)
			{
				g.setColor(Color.yellow);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Sleeping ...", xpos+120, ypos+(15*i + 10*(i-1)));
			}
			else if (writerStatus[i] == 1)
			{
				g.setColor(Color.gray);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Waiting in the queue", xpos+120, ypos+(15*i + 10*(i-1)));
			}
			else if (writerStatus[i] == 2)
			{
				g.setColor(Color.blue);
				g.fillOval(xpos+60, ypos+(2*i+22*(i-1)), 18, 18);
				g.drawString("Writing ...", xpos+120, ypos+(15*i + 10*(i-1)));
			}

		}
    }
}