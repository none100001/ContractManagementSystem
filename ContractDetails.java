
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdesktop.swingx.JXDatePicker;

public class ContractDetails extends JPanel implements ListSelectionListener, ActionListener {
	

	JButton scheduleButton = new JButton("Schedule of Rates");
	JButton saveButton = new JButton("SAVE DETAILS");
	
	String [] categoryList = {"Advertising and Media","Business Services","Cleaning","Community and support events","Constructions and operations","Enegry and utilities","Facilities management",		
	"HR Services","Insurance","IT and telecoms","Library Services","Office related supplies and services",
	"Parking","Parks and gardens","Plant and vehicles","Postage and freight",
	"Property","Regulatory charges and expenses","Repairs and maintenances",
	"Roads","Signs and barriers","Subcriptions and memberships",
	"Travel","Waste management and landfill","Water and sewerage","Other Goods/Services"};
	
	
	
	
	String [] tenderingList = {"Tender Process","EOI Process","Direct Negotiations","Other Selection"};
	String [] contractOptionList = {"1","2","3","4","5","Manual"};
	String [] supplierList = {"Single Supplier","Supplier Panel"};
	
	
	
	
	JCheckBox g1 = new JCheckBox("GIPA - Class 1");
    JCheckBox g2 = new JCheckBox("GIPA - Class 2");
    JCheckBox g3 = new JCheckBox("GIPA - Class 3");
	
	
	
	
    JTextField contractReferenceNumber;
    JTextArea contractDescription;
    JTextField contractValue;
    
   
    
    JXDatePicker contractAward;
    JXDatePicker contractExpiry;
    
    
    
    String tenderText = "";
    String contractOptionText = "";
    String contractCategoryText = "";
    String typesOFSupplierText = "";
    
    
    
    
    
    
    JList tenderingProcess = new JList(tenderingList);
    JList contractOptions = new JList(contractOptionList);
	JList contractCategory = new JList(categoryList);
	JList supplierCategory = new JList(supplierList);
	

	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	JTabbedPane topPane;
	
	public ContractDetails(JTabbedPane topPane){
		
		this.topPane = topPane;
		
		
		
		contractAward = new JXDatePicker();
		contractAward.setDate(Calendar.getInstance().getTime());
		contractAward.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        
		
		contractExpiry = new JXDatePicker();
		contractExpiry.setDate(Calendar.getInstance().getTime());
		contractExpiry.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	
		
		scheduleButton.addActionListener(this);
		saveButton.addActionListener(this);
		
        JLabel labelReferenceNumber = new JLabel("Contract Reference Number:        ");
        JLabel labelContractDescription = new JLabel("                     Contract Description:");
        JLabel labelContractValue = new JLabel("                                                                               Contract Value:");
        JLabel labelContractAwardDate = new JLabel("                                                           Contract Award Date:");
        JLabel labelContractExpiryDate = new JLabel("                                                            Contract Expiry Date:");
        JLabel labelTender = new JLabel("                                                       Tendering Process:");
        JLabel labelContractOption = new JLabel("                                                                                   Contract Option:");
        JLabel labelContractCategory = new JLabel("                                                   Contract Category:");
        JLabel labelSupplierCategory = new JLabel("                                                                  Types of Supplier:");
        
        
        
        
        
        
        JScrollPane contractScroller = new JScrollPane(contractCategory);
        contractScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contractScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contractCategory.setVisibleRowCount(2);
        contractCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contractCategory.addListSelectionListener(this);
        
        
        
        
        JScrollPane tenderScroller = new JScrollPane(tenderingProcess);
        tenderScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tenderScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        tenderingProcess.setVisibleRowCount(2);
        tenderingProcess.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tenderingProcess.addListSelectionListener(this);
        
        
        
        
        JScrollPane optionScroller = new JScrollPane(contractOptions);
        optionScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        optionScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contractOptions.setVisibleRowCount(2);
        contractOptions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contractOptions.addListSelectionListener(this);
        
        
        
        
        JScrollPane supplierScroller = new JScrollPane(supplierCategory);
        supplierScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        supplierScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        supplierCategory.setVisibleRowCount(2);
        supplierCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        supplierCategory.addListSelectionListener(this);
        
        
        
        
        
        
        
        contractReferenceNumber = new JTextField(25);
        contractDescription = new JTextArea(5,20);
        contractValue = new JTextField(20);

        
        
        
        
        JScrollPane contractDescriptionScroller = new JScrollPane(contractDescription);
        contractDescription.setLineWrap(true);
        contractScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contractScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contractDescription.selectAll();
        contractDescription.requestFocus();
        

        g1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {         
                if(e.getStateChange() == 1){
                   g2.setSelected(false);
                   g3.setSelected(false);
             	   topPane.setEnabledAt(13,false);
             	   topPane.setEnabledAt(11,true);
             	   topPane.setEnabledAt(12,false);
                }
                else{
             	   topPane.setEnabledAt(13,true);
             	   topPane.setEnabledAt(11,false);
             	   topPane.setEnabledAt(12,true);
                }
            }           
         });
        
        g2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {         
                if(e.getStateChange() == 1){
                   g1.setSelected(false);
                   g3.setSelected(false);
             	   topPane.setEnabledAt(12,true);
             	   topPane.setEnabledAt(11,false);
             	   topPane.setEnabledAt(13,false);
                }
                else{
             	   topPane.setEnabledAt(13,true);
             	   topPane.setEnabledAt(11,true);
             	   topPane.setEnabledAt(12,false);
                }
            }           
         });
         
         g3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {         
               if(e.getStateChange() == 1){
                   g1.setSelected(false);
                   g2.setSelected(false);
            	   topPane.setEnabledAt(13,true);
            	   topPane.setEnabledAt(11,false);
            	   topPane.setEnabledAt(12,false);
               }
               else{
            	   topPane.setEnabledAt(13,false);
            	   topPane.setEnabledAt(11,true);
            	   topPane.setEnabledAt(12,true);
               }
            }           
         });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        JPanel panel1 = new JPanel();
        panel1.add(labelReferenceNumber);
        panel1.add(contractReferenceNumber);
        panel1.add(g1);panel1.add(g2);panel1.add(g3);
        
        
        
        JPanel panel2 = new JPanel();
        panel2.add(labelContractDescription);
        panel2.add(contractDescriptionScroller);
        
        
        JPanel panel3 = new JPanel();
        panel3.add(labelContractValue);
        panel3.add(contractValue);
        panel3.add(scheduleButton);
        
        
        JPanel panel4 = new JPanel();
        panel4.add(labelContractAwardDate);
        panel4.add(contractAward);
        
        
        JPanel panel5 = new JPanel();
        panel5.add(labelContractExpiryDate);
        panel5.add(contractExpiry);
        
        
        
        JPanel panel6 = new JPanel();
        panel6.add(labelTender);
        panel6.add(tenderScroller);
        
        
        
        JPanel panel7 = new JPanel();
        panel7.add(labelContractOption);
        panel7.add(optionScroller);
        
        
        JPanel panel8 = new JPanel();
        panel8.add(labelContractCategory);
        panel8.add(contractScroller);
        
        
        JPanel panel9 = new JPanel();
        panel9.add(labelSupplierCategory);
        panel9.add(supplierScroller);
        
        JPanel panel10 = new JPanel();
        panel10.add(new JLabel("     "));
        panel10.add(saveButton);
        
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
        this.add(panel6);
        this.add(panel7);
        this.add(panel8);
        this.add(panel9);
        this.add(panel10);
        
        
        //this.add(labelContractDescription);
        

	}
	
	
	public void saveData(){
		
		if(typesOFSupplierText.equals(supplierList[0])){
			Database.insertTableClientDetails(contractReferenceNumber.getText(), 
					contractDescription.getText(),
					contractValue.getText(),
					contractAward.getDate()+"", 
					contractExpiry.getDate()+"", 
					tenderText, 
					contractOptionText, 
					contractCategoryText, 
					typesOFSupplierText);
		}
		else{
			Database.insertTableSupplierDetails(contractReferenceNumber.getText(), 
					contractDescription.getText(),
					contractValue.getText(),
					contractAward.getDate()+"", 
					contractExpiry.getDate()+"", 
					tenderText, 
					contractOptionText, 
					contractCategoryText, 
					typesOFSupplierText);
		}
	}
	
	
	



	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(!event.getValueIsAdjusting()){
			if(event.getSource() == tenderingProcess){
				tenderText = (String)tenderingProcess.getSelectedValue();
				if(tenderText.equals("Other Selection")){
					tenderText = JOptionPane.showInputDialog(getParent(),
			                "Type your other selection", null);
				}
			}
			else if(event.getSource() == contractOptions){
				contractOptionText = (String)contractOptions.getSelectedValue();
				if(contractOptionText.equals("Manual")){
					contractOptionText = JOptionPane.showInputDialog(getParent(),
			                "Type your manual option", null);
					
				}
			}
			else if(event.getSource() == contractCategory){
				contractCategoryText = (String)contractCategory.getSelectedValue();
			}
			else{
				typesOFSupplierText = (String)supplierCategory.getSelectedValue();
				if(typesOFSupplierText.equals(supplierList[0])){
					topPane.setEnabledAt(2,false);
					topPane.setEnabledAt(3,false);
					topPane.setEnabledAt(4,false);
					topPane.setEnabledAt(5,false);
					topPane.setEnabledAt(7,false);
					topPane.setEnabledAt(8,false);
					topPane.setEnabledAt(9,false);
					topPane.setEnabledAt(10,false);
					topPane.setEnabledAt(1,true);
				}
				else{
					topPane.setEnabledAt(2,true);
					topPane.setEnabledAt(3,true);
					topPane.setEnabledAt(4,true);
					topPane.setEnabledAt(5,true);
					topPane.setEnabledAt(7,true);
					topPane.setEnabledAt(8,true);
					topPane.setEnabledAt(9,true);
					topPane.setEnabledAt(10,true);
					topPane.setEnabledAt(1,false);
				}
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == saveButton){
			if(contractReferenceNumber.getText().equals("") ||
			contractDescription.getText().equals("") ||
			contractValue.getText().equals("") ||
			(contractAward.getDate()+"").equals("") || 
			(contractExpiry.getDate()+"").equals("") || 
			contractOptionText.equals("")|| 
			contractCategoryText.equals("")|| 
			typesOFSupplierText.equals("")){
				
				JOptionPane.showMessageDialog(null, "Please fill up All Details!", "Error",
	                    JOptionPane.ERROR_MESSAGE);
				
			}
			else{
				ClientContractManager.referenceId = contractReferenceNumber.getText();
				SupplierContractManager.referenceId = ClientContractManager.referenceId;
				saveData();
				if(typesOFSupplierText.equals("Supplier Panel")){
					JOptionPane.showMessageDialog(null, "Data Entried!\nNow please fill up Supplier Contract Details!");
				}
				else{
					JOptionPane.showMessageDialog(null, "Data Entried!\nNow please fill up Client Contract Details!");
				}
			}
		}
		else if(contractValue.isEnabled()){
			contractValue.setText("Removed..");
			contractValue.setEnabled(false);
		}
		else{
			contractValue.setText("");
			contractValue.setEnabled(true);
		}
	}


	
	
	
	
}	
