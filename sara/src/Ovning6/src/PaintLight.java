import javax.swing.*;		//F�r grafiska komponenter
import java.awt.event.*;	//F�r h�ndelsehantering
import java.awt.*;			//F�r layouts

public class PaintLight extends JFrame implements MouseListener, MouseMotionListener
{
	//Instansvariabler
	private Container cont;
	private JComboBox<String> comboBox;
	private int mouseX;
	private int mouseY;
	private Color currentColor;
	
	//Konstruktor
	public PaintLight()
	{
		initiateInstanceVariables();
		buildFrame();
		
		//Registrera lyssnare
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	//Metoder
	private void initiateInstanceVariables()
	{
		cont = getContentPane();
		
		//Combobox
		String[] items = new String[2];
		items[0] = "Rektangel";
		items[1] = "Frihand";
		//Alternativ
		//String[] items = {"Rektangel", "Frihand"};
		comboBox = new JComboBox<String>(items);
		
		mouseX = 0;
		mouseY = 0;
		currentColor = null;
	}
	
	private void buildFrame()
	{
		setTitle("PaintLight");
		setSize(550, 300);
		setLocation(200, 300);
		setResizable(false);
		cont.setLayout(null);
		
		buildColorPanels();
		
		comboBox.setBounds(450, 0, 95, 30);	//x-pos, y-pos, bredd, h�jd
		cont.add(comboBox);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Skapar f�rgpanelerna
	private void buildColorPanels()
	{
		makeColorPanel(Color.RED, 0);
		makeColorPanel(Color.GREEN, 1);
		makeColorPanel(Color.BLUE, 2);
		makeColorPanel(Color.CYAN, 3);
		makeColorPanel(Color.YELLOW, 4);
		makeColorPanel(Color.MAGENTA, 5);
	}
	
	private void makeColorPanel(Color color, int posNr)
	{
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(color);
		colorPanel.setBounds(posNr*75, 0, 75, 30);
		cont.add(colorPanel);
	}

	//H�ndelsehanterare
	public void mouseDragged(MouseEvent e) 
	{
		//Dra med musen (knapp intryckt)
		int index = comboBox.getSelectedIndex();
		
		if (index == 1 && !e.isMetaDown())
		{
			int mouseXEnd = e.getX();
			int mouseYEnd = e.getY();
			
			//Rita frihand i aktuell f�rg
			if (currentColor != null)
			{
				Graphics g = getGraphics();	//h�mta ritytan
				g.setColor(currentColor);
				
				//Rita linje
				g.drawLine(mouseX, mouseY, mouseXEnd, mouseYEnd);
				g.dispose();				//frig�r resurser, uppdaterar f�nstret
				
				//Uppdatera startpositionen
				mouseX = mouseXEnd;
				mouseY = mouseYEnd;
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) 
	{
		//En knapp trycks in och sl�pps
		if (e.isMetaDown())						//h�ger musknapp
		{
			//T�m ritytan
			Graphics g = getGraphics();			//h�mta ritytan
			Rectangle r = getBounds();			//h�mtar koordinaterna f�r f�nstret
			g.clearRect(0, 55, r.width, r.height);	//nedanf�r f�rgpaneler
			g.dispose();
		}
		else
		{
			mouseX = e.getX();
			mouseY = e.getY();
			
			if (mouseY >= 25 && mouseY < 55)	//inkl titelrad
			{
				if (mouseX >= 0 && mouseX < 75)
				{
					currentColor = Color.RED;
				}
				if (mouseX >= 75 && mouseX < 150)
				{
					currentColor = Color.GREEN;
				}
				if (mouseX >= 150 && mouseX < 225)
				{
					currentColor = Color.BLUE;
				}
				if (mouseX >= 225 && mouseX < 300)
				{
					currentColor = Color.CYAN;
				}
				if (mouseX >= 300 && mouseX < 375)
				{
					currentColor = Color.YELLOW;
				}
				if (mouseX >= 375 && mouseX < 425)
				{
					currentColor = Color.MAGENTA;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) 
	{
		//En knapp trycks in
		//Ta reda p� var muspekaren �r
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseReleased(MouseEvent e) 
	{
		//En intryckt knapp sl�pps
		int index = comboBox.getSelectedIndex();
		if (index == 0 && !e.isMetaDown())
		{
			//var sl�pps knapp upp
			int mouseXEnd = e.getX();
			int mouseYEnd = e.getY();
			
			//Rita rektangel i aktuell f�rg
			if (currentColor != null)
			{
				Graphics g = getGraphics(); 	//ger ritm�jligheter
				g.setColor(currentColor);
				g.fillRect(mouseX, mouseY, mouseXEnd - mouseX, mouseYEnd - mouseY); //x-pos, y-pos, bredd, h�jd
				g.dispose();					//kallas efter att saker ritats f�r att frig�ra resurser
			}
		}
		
	}
	
	//main-metod
	public static void main(String[] args)
	{
		PaintLight pl = new PaintLight();
		pl.setVisible(true);
	}
}
