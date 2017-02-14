import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SupplierContractManager extends JPanel implements ActionListener{
	

	
    JTextField nameText;
    JTextField positionText;
    JTextField businessText;
    JTextField phoneNoText;
    JTextField mobileNoText;
    JTextField emailAddressText;
    static String referenceId = "";
    
    
    JButton saveButton = new JButton("SAVE");
    JLabel gap = new JLabel("             ");
    JPanel newPanel = new JPanel();

    AccountManagement jframe;
	public SupplierContractManager(AccountManagement jframe){
		
		this.jframe = jframe;
		JLabel title = new JLabel("Supplier Contract Manager:           ");
        JLabel labelName = new JLabel("Name:");
        JLabel labelPosition = new JLabel("Position:");
        JLabel labelbusiness = new JLabel("Business Unit:");
        JLabel labelPhoneNo = new JLabel("Phone No:");
        JLabel labelMobileNo = new JLabel("Mobile No:");
        JLabel labelEmailAddress = new JLabel("Email Address:");
        
        saveButton.addActionListener(this);
        
        nameText = new JTextField(20);
        positionText = new JTextField(20);
        businessText = new JTextField(20);
        phoneNoText = new JTextField(20);
        mobileNoText = new JTextField(20);
        emailAddressText = new JTextField(20);
        
	    GridLayout gridLayout = new GridLayout(6,2);
	    gridLayout.setHgap(100);
	    gridLayout.setVgap(10);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(gridLayout);
	    
	    
        panel.add(labelName);
        panel.add(nameText);
        
        
        
        panel.add(labelPosition);
        panel.add(positionText);
        
        
        panel.add(labelbusiness);
        panel.add(businessText);
        
        
        panel.add(labelPhoneNo);
        panel.add(phoneNoText);
        
        
        panel.add(labelMobileNo);
        panel.add(mobileNoText);
        
        
        panel.add(labelEmailAddress);
        panel.add(emailAddressText);
        
        
        
        this.add(title);
        this.add(panel);
        
        newPanel.add(gap);
        newPanel.add(saveButton);
        this.add(newPanel);

	}
	
	public void saveDetails(){
		
		Database.insertTableSupplierManager(referenceId,
				nameText.getText(), 
				positionText.getText(),
				businessText.getText(),
				phoneNoText.getText(), 
				mobileNoText.getText(), 
				emailAddressText.getText());
		
		referenceId = "";
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(nameText.getText().equals("") ||
				positionText.getText().equals("") ||
				positionText.equals("") || 
				businessText.equals("") || 
				phoneNoText.equals("")|| 
				mobileNoText.equals("")|| 
				emailAddressText.equals("")){
					
					JOptionPane.showMessageDialog(null, "Please fill up All Details!", "Error",
		                    JOptionPane.ERROR_MESSAGE);
					
				}
				else{
					
					saveDetails();
					JOptionPane.showMessageDialog(null, "Data Entried!");
					jframe.restart();
				}
		
		}
	
	
}	
