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

public class G1 extends JPanel implements ActionListener{
	
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
			
	};
	
	public G1(AccountManagement jframe){
			
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
