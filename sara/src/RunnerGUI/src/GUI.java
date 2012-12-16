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
	private JTextField phoneNrField;
	
	
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
		phoneNrField = new JTextField();
		phoneNrField.setBorder(BorderFactory.createTitledBorder("Telefonnummer"));
		personList = new JList<Runner>();
		personList.setBorder(BorderFactory.createTitledBorder("Registrerade personer"));
	}
	
	private void buildFrame()
	{
		setTitle("L�pare");
		setSize(350,250);
		cont.setLayout(new GridLayout(1,2));
		
		JPanel leftPanel = new JPanel(new GridLayout(5,1));
		leftPanel.add(nameField);
		leftPanel.add(phoneNrField);
		JButton addButton = new JButton("L�gg till");
		addButton.addActionListener(this);
		leftPanel.add(addButton);
		JButton showButton = new JButton("Visa");
		showButton.addActionListener(this);
		leftPanel.add(showButton);
		JButton clearButton = new JButton("Rensa");
		clearButton.addActionListener(this);
		leftPanel.add(clearButton);
		cont.add(leftPanel);
		
		cont.add(personList);
		
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
		if(theText.equals("L�gg till"))
		{
			add();
		}		
		if(theText.equals("Visa"))
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
	
	private void addExersiceRunner()
	{
		logic.addPerson(nameField.getText(), phoneNrField.getText());
		personList.setListData(logic.getAllPersons());
		clear();
	}
	
	private void showSelected()
	{
		int position = personList.getSelectedIndex();
		if(position > -1)
		{
			nameField.setText(logic.getNameForPersonAt(position));
			phoneNrField.setText(logic.getPhoneNrForPersonAt(position));
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Du m�ste markera en person i listan!");
		}
	}
	
	private void clear()
	{
		nameField.setText("");
		phoneNrField.setText("");	
	}
	
}