import javax.swing.*;	//För grafiska komponenter
import java.awt.event.*;//För knapphantering
import java.awt.*;		//För layouts

public class GUI extends JFrame implements ActionListener
{
	//Instansvariabler
	private Logic logic;
	private Container cont;		//fönstrets huvudbehållare för grafiska komponenter
	
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
		runTime.setBorder(BorderFactory.createTitledBorder("Tid(vänligen skriv i sekunder)"));
		licNumber = new JTextField(); 
		licNumber.setBorder(BorderFactory.createTitledBorder("Licensnummer - för elitlöpare"));
		clubName = new JTextField();
		clubName.setBorder(BorderFactory.createTitledBorder("Klubbnamn - för elitlöpare"));
		orderedShirt = new JCheckBox();
		orderedShirt.setLabel("Beställt T-shirt? - för motionslöpare");
		
		
	}
	
	private void buildFrame()
	{
		setTitle("Löpare");
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
		
		JButton addButton = new JButton("Lägg till Motionslöpare");
		addButton.addActionListener(this);
		leftPanel.add(addButton); 
		
		JButton addButtonElite = new JButton("Lägg till Elitlöpare");
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
		menuBar.add(menu);		//lägg till ett menyalternativ till menyraden
		
		JMenuItem menuItem = new JMenuItem("Lägg till person");
		menuItem.setActionCommand("Lägg till");
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
		if(theText.equals("Lägg till Motionslöpare"))
		{
			addExerciseRunner();
		}	
		if ( theText.equals("Lägg till Elitlöpare"))
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
			JOptionPane.showMessageDialog(null, "Du måste markera en person i listan!");
		}
	}
	
	private void clear()
	{
		nameField.setText("");
		startNumber.setText("");
		runTime.setText(""); 
		licNumber.setText("");
		clubName.setText("");
		orderedShirt.setSelected(false); // ta INTE set enabled som jag gjorde först. Det blir liiite fel. 
	}
	
}