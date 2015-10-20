import java.awt.Graphics;

import javax.swing.JPanel;

public class playAreaPanel extends JPanel
{
	private int circleXLoc =10;
	private int circleYLoc = 10;
	public playAreaPanel()
	{
		this.repaint();
	}
    public void paintComponenet(Graphics g) {
        super.paintComponent(g);
        if(circleXLoc < 100 && circleXLoc >0)
		{
			circleXLoc += 1;
		}
        else
        {
        	circleXLoc--;
        }

        g.drawOval(circleXLoc,circleYLoc,10,10);
        g.fillOval(circleXLoc,circleYLoc,10,10);

    }

}
