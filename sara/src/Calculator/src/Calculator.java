import javax.swing.*;	//Grafiska komponenter
import java.awt.*;		//Layouts
import java.awt.event.*;//H�ndelsehantering f�r knappar

public class Calculator extends JFrame implements ActionListener
{
	//Instansvariabler
	private Container cont;			//beh�llare f�r allt inneh�ll i v�rt f�nster
	private JTextField display;		//h�r visas v�ra ber�kningar
	
	//Konstruktor
	public Calculator()
	{
		super();					//kalla JFrames konstruktor
		//setResizable(false);		//g�r s� att man inte kan �ndra storlek p� f�nstret
		setSize(325, 350);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Skapa inneh�llet
		cont = getContentPane();
		cont.setLayout(new BorderLayout());	//s�tter layout f�r f�nstret
		
		buildTopPanel();
		buildNumberButtonPanel();
		buildOperatorButtonPanel();
	}
	
	//Fr�n interfacet ActionListener
	public void actionPerformed(ActionEvent e) 
	{
		String buttonText = e.getActionCommand();
		
		if (buttonText.equals("C"))
		{
			//Rensa f�nstret
			display.setText("");
		}
		else if (buttonText.equals("="))
		{
			//G�r ber�kning
			calculateResult();
		}
		else
		{
			//L�gg till text i displayen
			String currentText = display.getText();
			currentText += buttonText;
			display.setText(currentText);
		}
	}
	
	private void calculateResult()
	{
		String str = display.getText();	//detta ska vi ber�kna
		
		//Kolla om det �r + eller -
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
		
		//2. L�gg till knappar till panelen
		JButton button = new JButton("C");
		button.setBackground(Color.white);	//�ndra till vit f�rg
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
		
		//3. l�gg till i f�nsterbeh�llaren
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
		
		panel.add(new JPanel());		//l�gg till en tom ruta till v�nster om 0-knappen
		button = new JButton("0");
		button.addActionListener(this);
		panel.add(button);
		
		cont.add(panel, BorderLayout.CENTER);
	}
	
	private void buildTopPanel()
	{
		//Label + textf�lt
		//JPanel panel = new JPanel();
		//panel.setLayout(new GridLayout(2, 1, 0, 10));
		JPanel panel = new JPanel(new GridLayout(2, 1, 0, 10));
		
		JLabel label = new JLabel("Calculator ver 9.4", JLabel.CENTER);
		panel.add(label);
		
		display = new JTextField(20);
		display.setEditable(false);		//l�ser f�ltet f�r inmatning fr�n anv�ndaren
		panel.add(display);
		
		//l�gg till i f�nsterbeh�llaren
		cont.add(panel, BorderLayout.NORTH);
	}
	
	//Main-metod
	public static void main(String[] args) 
	{
		Calculator calc = new Calculator();
		calc.setVisible(true);
	}

}
