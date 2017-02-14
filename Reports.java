
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Reports extends JPanel implements ListSelectionListener {
	

	String [] categoryList = {"Advertising and Media","Business Services","Cleaning"};
	
	
	
    JTextField contractReferenceNumber;
    JTextArea contractDescription;
    JTextField contractValue;
    JTextField contractAwardDate;
    JTextField contractExpiryDate;
    JTextField contractOptions;
	@SuppressWarnings("rawtypes")
	JList contractCategory = new JList(categoryList);
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Reports(){
		
		
        JLabel labelReferenceNumber = new JLabel("Contract Reference Number:   ");
        JLabel labelContractDescription = new JLabel("Contract Description:   ");
        JLabel labelContractValue = new JLabel("Contract Value:   ");
        JLabel labelContractAwardDate = new JLabel("Contract Award Date:  ");
        JLabel labelContractExpiryDate = new JLabel("Contract Expiry Date:  ");
        JLabel labelContractOption = new JLabel("Contract Option:  ");
        JLabel labelContractCategory = new JLabel("Contract Category:  ");
   
        //JButton button = new JButton("HELLO BROTHER");
        
        JScrollPane contractScroller = new JScrollPane(contractCategory);
        contractScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contractScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contractCategory.setVisibleRowCount(2);
        contractCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contractCategory.addListSelectionListener(this);
        
        
        
        contractReferenceNumber = new JTextField(20);
        contractDescription = new JTextArea(10,25);
        contractValue = new JTextField(20);
        contractAwardDate = new JTextField(20);
        contractExpiryDate = new JTextField(20);
        contractOptions = new JTextField(20);
        
        
        
        
        JScrollPane contractDescriptionScroller = new JScrollPane(contractDescription);
        contractDescription.setLineWrap(true);
        contractScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contractScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contractDescription.selectAll();
        contractDescription.requestFocus();
        
        
        
        
        
        
        
        
        JPanel panel1 = new JPanel();
        panel1.add(labelReferenceNumber);
        panel1.add(contractReferenceNumber);
        
        
        
        JPanel panel2 = new JPanel();
        panel2.add(labelContractDescription);
        panel2.add(contractDescriptionScroller);
        
        
        JPanel panel3 = new JPanel();
        panel3.add(labelContractValue);
        panel3.add(contractValue);
        
        
        JPanel panel4 = new JPanel();
        panel4.add(labelContractAwardDate);
        panel4.add(contractAwardDate);
        
        
        JPanel panel5 = new JPanel();
        panel5.add(labelContractExpiryDate);
        panel5.add(contractExpiryDate);
        
        
        JPanel panel6 = new JPanel();
        panel6.add(labelContractOption);
        panel6.add(contractOptions);
        
        
        JPanel panel7 = new JPanel();
        panel7.add(labelContractCategory);
        panel7.add(contractScroller);
        
        
     
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        this.add(panel7);
        
		
	}
	
	
	public void addDetails(){
		
		
	
	}
	
	public void showDetails(){
		
		
		
	}


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
	
	
	
}	
