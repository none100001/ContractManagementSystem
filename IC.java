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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IC extends JPanel implements ActionListener{
	
	int length = 0;
	JButton [] button;
	String [] ans;
	
	HashMap<Integer,String> map = new HashMap<Integer,String>();
	AccountManagement jframe;
	JButton refreshButton = new JButton("REFRESH");
	
	public IC(AccountManagement jframe){
		
		try {
			this.jframe = jframe;
			refreshButton.addActionListener(this);
			length = Database.getNumberOfSuppliersManager();
			length += Database.getNumberOfClientsManager();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(length>0){
			
			button = new JButton[length];
			

			
			for(int c = 0;c<length;c++){
				button[c] = new JButton("Click here to add another row");
			}
			


			Connection connection = null;
			Statement statement = null;
			ResultSet ans = null;
			
		    GridLayout gridLayout = new GridLayout(length+1,3);
		    gridLayout.setHgap(100);
		    gridLayout.setVgap(10);
		    
		    JPanel panel = new JPanel();
			panel.setLayout(gridLayout);
			
			panel.add(new JLabel("REFERENCE ID"));
			panel.add(new JLabel("NAME"));
			panel.add(new JLabel(" CHOICE"));
			
			
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
				statement = connection.createStatement();
				ans = statement.executeQuery("select * from SUPPLIERMANAGER");
				int index = 0;
				
				while(ans.next()){
					String refID = ans.getString("referenceID");
					panel.add(new JLabel(refID));
					panel.add(new JLabel(ans.getString("name")));
					panel.add(button[index]);
					map.put(index,refID);
					index++;
				}
				
				statement = connection.createStatement();
				ans = statement.executeQuery("select * from CLIENTMANAGER");
				while(ans.next()){
					String refID = ans.getString("referenceID");
					panel.add(new JLabel(refID));
					panel.add(new JLabel(ans.getString("name")));
					panel.add(button[index]);
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
		if(e.getSource() == refreshButton){
			jframe.restart();
		}
	}
}
