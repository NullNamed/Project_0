import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JFrame implements KeyListener
{
	private ArrayList<JPanel> leftSide = new ArrayList<>();
	private int leftPos = 0;
	private int rightPos = 0;
	private ArrayList<JPanel> rightSide = new ArrayList<>();

	private int circleXLoc = 50;
	private int circleYLoc = 50;
	
	public boolean otherSide = false;
	private JPanel right;
	private JPanel left;
	public Pong()
	{
		this.setLayout(new BorderLayout());
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(10,1));
		for(int x = 0;x<10;x++)
		{
			JPanel test = new JPanel();
			left.add(test);
			leftSide.add(test);
		}
		leftSide.get(0).setBackground(Color.black);
		
		left.setBackground(Color.WHITE);
		JPanel right = new JPanel();
		right.setBackground(Color.WHITE);
		right.setLayout(new GridLayout(10,1));
		for(int x = 0;x<10;x++)
		{
			JPanel test = new JPanel();
			right.add(test);
			rightSide.add(test);
		}
		rightSide.get(0).setBackground(Color.black);
		
		playAreaPanel playArea = new playAreaPanel(){
			
			public void paint(Graphics g) 
			{
				boolean answer = false;
				if(left.getComponentAt(0, circleYLoc).getBackground() == Color.black &&  circleXLoc <=0)
				{
					answer = true;
				}
				System.out.println(answer);
				double maxXBound = this.getBounds().getWidth() - right.getBounds().getWidth();
				
				if(circleXLoc >= maxXBound )
				{
					otherSide = true;
				}
				if(circleXLoc <=0)
				{
					otherSide = false;
				}
		        super.paint(g);

		        if(!otherSide)
				{
					circleXLoc +=5;
				}
		        else if(otherSide)
		        {
		        	circleXLoc -=5;
		        }

		        g.drawOval(circleXLoc,circleYLoc,10,10);
		        g.fillOval(circleXLoc,circleYLoc,10,10);

		    }
		};
		playArea.setBackground(Color.WHITE);
		
		
		this.add(left,BorderLayout.WEST);
		this.add(right,BorderLayout.EAST);
		this.add(playArea, BorderLayout.CENTER);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(this);
        //Timer gameTime = new Timer();
        double timerSec =0;
        while(true)
        {
        	
        	try {
				Thread.sleep(50);
				timerSec += .5;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		playArea.repaint();
        	/*while( rightPos !=9)
    		{


    			rightSide.get(rightPos).setBackground(Color.WHITE);
    			rightPos++;
    			rightSide.get(rightPos).setBackground(Color.black);
    		}
    		while(rightPos !=0)
    		{
    			playArea.repaint();
    			rightSide.get(rightPos).setBackground(Color.WHITE);
    			rightPos--;
    			rightSide.get(rightPos).setBackground(Color.black);
    		}*/
        }
	}

	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		if(KeyEvent.VK_DOWN== arg0.getKeyCode() && leftPos !=9)
		{
			leftSide.get(leftPos).setBackground(Color.WHITE);
			leftPos++;
			leftSide.get(leftPos).setBackground(Color.black);
		}
		if(KeyEvent.VK_UP== arg0.getKeyCode() && leftPos !=0)
		{
			leftSide.get(leftPos).setBackground(Color.WHITE);
			leftPos--;
			leftSide.get(leftPos).setBackground(Color.black);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	public boolean getPixel(int y)
	{
		boolean answer = false;
		if(left.getComponentAt(0, y).getBackground() == Color.black )
		{
			answer = true;
		}
			
		return answer;
	}
}
