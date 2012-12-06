import javax.swing.*;	//Grafiska komponenter
import java.awt.*;		//Layouts
import java.awt.event.*;//Händelsehantering för knappar

public class Calculator extends JFrame implements ActionListener
{
	//Instansvariabler
	private Container cont;			//behållare för allt innehåll i vårt fönster
	private JTextField display;		//här visas våra beräkningar
	
	//Konstruktor
	public Calculator()
	{
		super();					//kalla JFrames konstruktor
		//setResizable(false);		//gör så att man inte kan ändra storlek på fönstret
		setSize(325, 350);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Skapa innehållet
		cont = getContentPane();
		cont.setLayout(new BorderLayout());	//sätter layout för fönstret
		
		buildTopPanel();
		buildNumberButtonPanel();
		buildOperatorButtonPanel();
	}
	
	//Från interfacet ActionListener
	public void actionPerformed(ActionEvent e) 
	{
		String buttonText = e.getActionCommand();
		
		if (buttonText.equals("C"))
		{
			//Rensa fönstret
			display.setText("");
		}
		else if (buttonText.equals("="))
		{
			//Gör beräkning
			calculateResult();
		}
		else
		{
			//Lägg till text i displayen
			String currentText = display.getText();
			currentText += buttonText;
			display.setText(currentText);
		}
	}
	
	private void calculateResult()
	{
		String str = display.getText();	//detta ska vi beräkna
		
		//Kolla om det är + eller -
		if (str.contains("+"))		//addition
		{
			String[] tokens = str.split("\\+");
			int value1 = Integer.parseInt(tokens[0]);
			int value2 = Integer.parseInt(tokens[1]);
			int sum = value1 + value2;
			display.setText(Integer.toString(sum));
		}
		else if (str.contains("-"))		//subtraktion
		{
			String[] tokens = str.split("\\-");
			int value1 = Integer.parseInt(tokens[0]);
			int value2 = Integer.parseInt(tokens[1]);
			int result = value1 - value2;
			display.setText(Integer.toString(result));
		}
	}
	
	//Metoder
	private void buildOperatorButtonPanel()
	{
		//1. Skapa panelen
		JPanel panel = new JPanel(new GridLayout(4, 1, 0, 10));
		
		//2. Lägg till knappar till panelen
		JButton button = new JButton("C");
		button.setBackground(Color.white);	//ändra till vit färg
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton("+");
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton("-");
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton("=");
		button.addActionListener(this);
		panel.add(button);
		
		//3. lägg till i fönsterbehållaren
		cont.add(panel, BorderLayout.EAST);
	}
	
	private void buildNumberButtonPanel()
	{
		JPanel panel = new JPanel(new GridLayout(4, 3, 5, 10));	//4 rader, 3 kolumner, 5 i x-led och 10 i y-led
	
		JButton button;
		for (int i = 1; i <= 9; i++)
		{
			button = new JButton(Integer.toString(i));
			button.addActionListener(this);
			panel.add(button);
		}
		
		panel.add(new JPanel());		//lägg till en tom ruta till vänster om 0-knappen
		button = new JButton("0");
		button.addActionListener(this);
		panel.add(button);
		
		cont.add(panel, BorderLayout.CENTER);
	}
	
	private void buildTopPanel()
	{
		//Label + textfält
		//JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(2, 1, 0, 10));
		JPanel panel = new JPanel(new GridLayout(2, 1, 0, 10));
		
		JLabel label = new JLabel("Calculator ver 9.4", JLabel.CENTER);
		panel.add(label);
		
		display = new JTextField(20);
		display.setEditable(false);		//låser fältet för inmatning från användaren
		panel.add(display);
		
		//lägg till i fönsterbehållaren
		cont.add(panel, BorderLayout.NORTH);
	}
	
	//Main-metod
	public static void main(String[] args) 
	{
		Calculator calc = new Calculator();
		calc.setVisible(true);
	}

}
