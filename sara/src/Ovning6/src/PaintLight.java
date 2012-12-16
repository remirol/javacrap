import javax.swing.*;		//För grafiska komponenter
import java.awt.event.*;	//För händelsehantering
import java.awt.*;			//För layouts

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
		
		comboBox.setBounds(450, 0, 95, 30);	//x-pos, y-pos, bredd, höjd
		cont.add(comboBox);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Skapar färgpanelerna
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

	//Händelsehanterare
	public void mouseDragged(MouseEvent e) 
	{
		//Dra med musen (knapp intryckt)
		int index = comboBox.getSelectedIndex();
		
		if (index == 1 && !e.isMetaDown())
		{
			int mouseXEnd = e.getX();
			int mouseYEnd = e.getY();
			
			//Rita frihand i aktuell färg
			if (currentColor != null)
			{
				Graphics g = getGraphics();	//hämta ritytan
				g.setColor(currentColor);
				
				//Rita linje
				g.drawLine(mouseX, mouseY, mouseXEnd, mouseYEnd);
				g.dispose();				//frigör resurser, uppdaterar fönstret
				
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
		//En knapp trycks in och släpps
		if (e.isMetaDown())						//höger musknapp
		{
			//Töm ritytan
			Graphics g = getGraphics();			//hämta ritytan
			Rectangle r = getBounds();			//hämtar koordinaterna för fönstret
			g.clearRect(0, 55, r.width, r.height);	//nedanför färgpaneler
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
		//Ta reda på var muspekaren är
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseReleased(MouseEvent e) 
	{
		//En intryckt knapp släpps
		int index = comboBox.getSelectedIndex();
		if (index == 0 && !e.isMetaDown())
		{
			//var släpps knapp upp
			int mouseXEnd = e.getX();
			int mouseYEnd = e.getY();
			
			//Rita rektangel i aktuell färg
			if (currentColor != null)
			{
				Graphics g = getGraphics(); 	//ger ritmöjligheter
				g.setColor(currentColor);
				g.fillRect(mouseX, mouseY, mouseXEnd - mouseX, mouseYEnd - mouseY); //x-pos, y-pos, bredd, höjd
				g.dispose();					//kallas efter att saker ritats för att frigöra resurser
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
