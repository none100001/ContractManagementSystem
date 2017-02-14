import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SupplierDetails extends JPanel implements ActionListener,ListSelectionListener{
	

	int length = 0;
	HashMap<Integer,String> map = new HashMap<Integer,String>();
	JButton refreshButton = new JButton("REFRESH");
	AccountManagement jframe;
    final String html1 = "<html><body style='width: ";
    final String html2 = "px'>";
	
	
	String [] category = {"REFERENCEID","DESCRIPTION","CONTRACTVALUE","TENDERPROCESS","OPTION",
			"CATEGORY","TYPESOFSUPPLIER"};
	

	JList [] categoryList;
	JScrollPane [] scolar;
	
	public SupplierDetails(AccountManagement jframe){
		

		this.jframe = jframe;
		refreshButton.addActionListener(this);
		
		try {
			length = Database.getNumberOfSuppliersDetails();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(length>0){
			
			
			map = new HashMap<Integer,String>();
			categoryList = new JList[length];
			scolar = new JScrollPane[length];
			for(int c = 0;c<length;c++){
				categoryList[c] = new JList(category);
			}
			
			for(int c = 0;c<length;c++){
				
				scolar[c] = new JScrollPane(categoryList[c]);
				scolar[c].setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scolar[c].setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				categoryList[c].setVisibleRowCount(2);
				categoryList[c].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				categoryList[c].addListSelectionListener(this);
				
			}


			Connection connection = null;
			Statement statement = null;
			ResultSet ans = null;
			
		    GridLayout gridLayout = new GridLayout(length+1,8);
		    gridLayout.setHgap(5);
		    gridLayout.setVgap(1);
		    
		    JPanel panel = new JPanel();
			panel.setLayout(gridLayout);
			

			
			panel.add(new JLabel("REFERENCE ID"));
			panel.add(new JLabel("DESCRIPTION"));
			panel.add(new JLabel("CONTRACT VALUE"));
			panel.add(new JLabel("TENDER PROCESS"));
			panel.add(new JLabel("OPTION"));
			panel.add(new JLabel("CATEGORY"));
			panel.add(new JLabel("TYPES OF SUPPLIER"));
			panel.add(new JLabel("EDIT"));
			
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
				statement = connection.createStatement();
				ans = statement.executeQuery("select * from SUPPLIERDETAILS");
				int index = 0;
				
				while(ans.next()){
					String refID = ans.getString("referenceId");
					panel.add(new JLabel(refID));
					panel.add(new JLabel(ans.getString("description")));
					panel.add(new JLabel(ans.getString("contractValue")));
					panel.add(new JLabel(ans.getString("tenderProcess")));
					panel.add(new JLabel(ans.getString("contractOption")));
					panel.add(new JLabel(ans.getString("contractCategory")));
					panel.add(new JLabel(ans.getString("typesOfSupplier")));
					panel.add(scolar[index]);
					map.put(index,refID);
					index++;
					
				}
				
				panel.setPreferredSize(new Dimension(1130,500));
				panel.setBorder(BorderFactory.createLineBorder(Color.black));
				JScrollPane scroll = new JScrollPane(panel,
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				scroll.setPreferredSize(new Dimension(1123,400));
				this.add(scroll);
				this.add(refreshButton);
				
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

			
			
		}



	}


	@Override
	public void actionPerformed(ActionEvent e) {
		jframe.restart();
		
	}


	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(!event.getValueIsAdjusting()){
			for(int c = 0;c<length;c++){
				if(event.getSource() == categoryList[c]){
					String refId = map.get(c);
					String colName = (String) categoryList[c].getSelectedValue();
					String newValue = JOptionPane.showInputDialog(getParent(),
			                "Type your new value", null);
					if(colName.equals("OPTION") || colName.equals("CATEGORY")){
						colName = "CONTRACT" + colName;
					}
					
					Database.editSupplierDetails(refId,colName,newValue);
					jframe.restart();
					break;
				}
			}
		}
	}



}
