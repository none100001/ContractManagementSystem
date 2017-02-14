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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.jdesktop.swingx.JXDatePicker;

public class G3 extends JPanel implements ActionListener{
	
	AccountManagement jframe;
	JButton refreshButton = new JButton("REFRESH");
	JLabel [] label;
	JTextField [] editText;
	
	String [] questions = {
			
			"Tender Number:",
			"Name of the Contractor:",
			"Address of the Contractor",
			"Particulars of any related body corporate of the contractor or any other private sector entity in which the contractor has an interest, which will be involved in carrying out any of the contractor's obligations under the contract or will receive a benefit under the contract:",
			"Effective Date of the Contract:",
			"Duration of the Contract:",
			"Particulars of the project to be undertaken, the goods or services to be provided or the real property to be transferred or leased under the contract:",
			"Estimated amount payable to the contractor under the contract:",
			"Description of any provisions under which the amount payable to the contractor may be varried:",
			"In the case of contractor arising from a tendering process, the method of tendering and a summary of the criteria against which the various tenders were assessed:",
			"Description of any provision under which it is agreed that the contractor is to receive payment for providing operational or maintainance services:",
			"Particulars of future transfers of significant assets to the State at zero, or nominal, cost to the State, including the date of their proposed transfer:",
			"Particulars of future transfers of significant assest to the contractor, including the date of the proposed transfer:",
			"The results of any cost-benefits analysis of the contract conducted by the organization:",
			"The components and quantum of the public sector comparator if used:",
			"If relevant, a summary of information used in the contractors's full base case finantial model (for example, the pricing formula for tolls of usage charges):",
			"If relevant, particulars of how risk, during the construction and operational phase of the a contract to undertake a specific project ( such as construction, infrastructure or property development), is to be apportioned between the parties, quantified (where practicable) in net present-value terms and specifying the major assumptions involved:",
			"Particulars as to any significant gurantees or undertaking between the parties, including any guarantee or undertakings with respect to loan agreements entered into or proposed to be entered into:",
			"Paticulars of any other key elements of the contract:"
	};
	
	public G3(AccountManagement jframe){
			
			JXDatePicker date = new JXDatePicker();
		
	        final String html1 = "<html><body style='width: ";
	        final String html2 = "px'>";

		    //GridLayout gridLayout = new GridLayout(questions.length,2);
		    //gridLayout.setHgap(100);
		    //gridLayout.setVgap(10);
	        
	        JPanel panel = new JPanel();
	        
	        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
	        panel.setPreferredSize(new Dimension(200,200));
			
			label = new JLabel[questions.length];
			editText = new JTextField[questions.length];
			
			
			for(int c = 0;c<questions.length;c++){
				label[c] = new JLabel(html1 + "300" + html2 + (c+1)+". "+questions[c]);
				editText[c] = new JTextField(20);
				JPanel p = new JPanel();
				p.add(label[c]);
				if(c != 4){
					p.add(editText[c]);
				}
				else{
					date = new JXDatePicker();
					date.setDate(Calendar.getInstance().getTime());
					date.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
					p.add(date);
				}
				panel.add(p);
			}
			
			panel.add(Box.createVerticalGlue());
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
			panel.setPreferredSize(new Dimension(200,2000));
			JScrollPane scrollFrame = new JScrollPane(panel);
			scrollFrame.setAutoscrolls(true);
			scrollFrame.setPreferredSize(new Dimension(800,600));

			this.add(scrollFrame);	
			
		}

	
	

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == refreshButton){
				jframe.restart();
			}
			
		}
}
