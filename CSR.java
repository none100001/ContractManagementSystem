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
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CSR extends JPanel implements ActionListener, ItemListener{
	
	int length = 0;
	JCheckBox [] yes;
	JCheckBox [] no;
	JCheckBox [] na;
	String [] ans;
	
	HashMap<Integer,String> map = new HashMap<Integer,String>();
	AccountManagement jframe;
	JButton refreshButton = new JButton("REFRESH");
	
	public CSR(AccountManagement jframe){
		
		try {
			this.jframe = jframe;
			refreshButton.addActionListener(this);
			length = Database.getNumberOfSuppliersManager();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(length>0){
			
			yes = new JCheckBox[length];
			no = new JCheckBox[length];
			na = new JCheckBox[length];
			ans = new String[length];
			
			
			for(int c = 0;c<ans.length;c++){
				ans[c] = "na";
			}
			
			
			
			for(int c = 0;c<length;c++){
				yes[c] = new JCheckBox();
				yes[c].addItemListener(this);
			}
			
			for(int c = 0;c<length;c++){
				no[c] = new JCheckBox();
				no[c].addItemListener(this);
			}
			
			for(int c = 0;c<length;c++){
				na[c] = new JCheckBox();
				na[c].addItemListener(this);
			}


			Connection connection = null;
			Statement statement = null;
			ResultSet ans = null;
			
		    GridLayout gridLayout = new GridLayout(length+1,5);
		    gridLayout.setHgap(100);
		    gridLayout.setVgap(10);
		    
		    JPanel panel = new JPanel();
			panel.setLayout(gridLayout);
			
			panel.add(new JLabel("REFERENCE ID"));
			panel.add(new JLabel("NAME"));
			panel.add(new JLabel(" YES"));
			panel.add(new JLabel(" NO"));
			panel.add(new JLabel(" N/A"));
			
			
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
				statement = connection.createStatement();
				ans = statement.executeQuery("select * from SUPPLIERMANAGER");
				int index = 0;
				
				while(ans.next()){
					String refID = ans.getString("referenceID");
					panel.add(new JLabel(refID));
					panel.add(new JLabel(ans.getString("name")));
					panel.add(yes[index]);
					panel.add(no[index]);
					panel.add(na[index]);
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
	
	class YesListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == 1){
				for(int c = 0;c<length;c++){
					if(yes[c] == e.getSource()){
						no[c].setSelected(false);
						na[c].setSelected(false);
						ans[c] = "yes";
					}
				}
			}
			
		}
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
