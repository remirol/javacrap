import javax.swing.*;	//F�r grafiska komponenter
import java.awt.event.*;//F�r knapphantering
import java.awt.*;		//F�r layouts

public class GUI extends JFrame implements ActionListener
{
	//Instansvariabler
	private Logic logic;
	private Container cont;		//f�nstrets huvudbeh�llare f�r grafiska komponenter
	
	private JList<Runner> personList;
	private JTextField nameField;
	private JTextField startNumber;
	private JTextField runTime;
	private JTextField licNumber;
	private JTextField clubName; 
	private JCheckBox orderedShirt; 
	
	//Main-metod
	public static void main(String[] args)
	{
		GUI frame = new GUI();
		frame.setVisible(true);
	}
	
	//Konstruktor
	public GUI()
	{
		initiateInstanceVariables();
		buildFrame();
	}
	
	private void initiateInstanceVariables()
	{
		logic = new Logic();
		cont = getContentPane();
		nameField = new JTextField();
		nameField.setBorder(BorderFactory.createTitledBorder("Namn"));
		startNumber = new JTextField();
		startNumber.setBorder(BorderFactory.createTitledBorder("Startnummer"));
		runTime = new JTextField(); 
		runTime.setBorder(BorderFactory.createTitledBorder("Tid(v�nligen skriv i sekunder)"));
		licNumber = new JTextField(); 
		licNumber.setBorder(BorderFactory.createTitledBorder("Licensnummer - f�r elitl�pare"));
		clubName = new JTextField();
		clubName.setBorder(BorderFactory.createTitledBorder("Klubbnamn - f�r elitl�pare"));
		orderedShirt = new JCheckBox();
		orderedShirt.setLabel("Best�llt T-shirt? - f�r motionsl�pare");
		
		
	}
	
	private void buildFrame()
	{
		setTitle("L�pare");
		setSize(700,500);
		cont.setLayout(new GridLayout(1,2));
		
		JPanel leftPanel = new JPanel(new GridLayout(11,1));
		JPanel rightPanel = new JPanel(new GridLayout(1,1));
		personList= new JList<Runner>();
		
		
		
		rightPanel.add(personList);
		leftPanel.add(nameField);
		leftPanel.add(startNumber);
		leftPanel.add(runTime); 
		leftPanel.add(clubName); 
		leftPanel.add(licNumber); 
		leftPanel.add(orderedShirt);
		
		JButton addButton = new JButton("L�gg till Motionsl�pare");
		addButton.addActionListener(this);
		leftPanel.add(addButton); 
		
		JButton addButtonElite = new JButton("L�gg till Elitl�pare");
		addButtonElite.addActionListener(this); 
		leftPanel.add(addButtonElite);
		
		JButton showButton = new JButton("Visa alla");
		showButton.addActionListener(this);
		leftPanel.add(showButton);
		
		JButton showSelectedButton = new JButton("Visa valda");
		showSelectedButton.addActionListener(this);
		leftPanel.add(showSelectedButton); 
		
		JButton clearButton = new JButton("Rensa");
		clearButton.addActionListener(this);
		leftPanel.add(clearButton);
		
		cont.add(leftPanel);
		cont.add(rightPanel); 
	//	cont.add(personList);
		
		buildMenu();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void buildMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Arkiv");
		menuBar.add(menu);		//l�gg till ett menyalternativ till menyraden
		
		JMenuItem menuItem = new JMenuItem("L�gg till person");
		menuItem.setActionCommand("L�gg till");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Avsluta");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		setJMenuBar(menuBar);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String theText = event.getActionCommand();
		if(theText.equals("L�gg till Motionsl�pare"))
		{
			addExerciseRunner();
		}	
		if ( theText.equals("L�gg till Elitl�pare"))
		{	
			addEliteRunner(); 
		}
		
		if(theText.equals("Visa alla"))
		{
			showAll();
		}
		if(theText.equals("Visa valda"))
		{
			showSelected(); 			
		}
		if(theText.equals("Rensa"))
		{
			clear();
		}
		if (theText.equals("Avsluta"))
		{
			System.exit(0);
		}
	}
	
	private void showAll() 
	{
		personList.setListData(logic.showAll());
	}

	private void addExerciseRunner()
	{
		logic.addExerciseRunner(nameField.getText(), startNumber.getText(), runTime.getText(), orderedShirt.isSelected());
		personList.setListData(logic.showAllExerciseRunners());
		clear();
	}
	
	private void addEliteRunner()
	{
		logic.addEliteRunner(nameField.getText(), startNumber.getText(), runTime.getText(), clubName.getText(), licNumber.getText());
		personList.setListData(logic.showAllEliteRunners());
		clear(); 
		
	}
	
	private void showSelected()
	{
		int position = personList.getSelectedIndex();
		if(position > -1)
		{
			//nameField.setText(logic.getNameForPersonAt(position));
			//startNumber.setText(logic.getPhoneNrForPersonAt(position));
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Du m�ste markera en person i listan!");
		}
	}
	
	private void clear()
	{
		nameField.setText("");
		startNumber.setText("");
		runTime.setText(""); 
		licNumber.setText("");
		clubName.setText("");
		orderedShirt.setSelected(false); // ta INTE set enabled som jag gjorde f�rst. Det blir liiite fel. 
	}
	
}