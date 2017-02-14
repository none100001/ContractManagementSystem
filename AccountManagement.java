
import java.awt.*;
import javax.swing.*;
 

public class AccountManagement extends JFrame {
	

	static AccountManagement frame;
	static Database database;
	
    public static void main(String[] args) {
    	
    	go();
 
    }
    
    
    public static void go(){
    	frame = new AccountManagement();
    	database = new Database();
    	
    	
    	Icon iconNew = new ImageIcon("new.png");
    	Icon iconContracts = new ImageIcon("contracts.png");
    	Icon iconVariation = new ImageIcon("variation.png");
    	Icon iconReports = new ImageIcon("reports.png");
    	Icon mainIcon = new ImageIcon("mainicon.png");
    	
    	
      
        
    	JButton topPanel  = new JButton("Contract Management Solution");
    	topPanel.setIcon(mainIcon);
    	topPanel.setBackground(Color.LIGHT_GRAY);
    	
    	
    	
    	
    	
        
    	JTabbedPane topPane = new JTabbedPane();
        JTabbedPane leftPane = new JTabbedPane();
    	
    	

        ClientContractManager clientContractDetails = new ClientContractManager(frame);
        SupplierContractManager supplierContractDetails = new SupplierContractManager(frame);
        
        Quality quality = new Quality(frame);
        WHS whs = new WHS(frame);
        ENV env = new ENV(frame);
        IC ic = new IC(frame);
        FD fd = new FD(frame);
        PL pl = new PL(frame);
        RP rp = new RP(frame);
        CSR csr = new CSR(frame);
        G1 g1 = new G1(frame);
        G2 g2 = new G2(frame);
        G3 g3 = new G3(frame);
        
        ContractDetails contractDetails = new ContractDetails(topPane);
        
        ClientDetails clientDetails = new ClientDetails(frame);
        SupplierDetails supplierDetails = new SupplierDetails(frame);
        ClientManager clientManager = new ClientManager(frame);
        SupplierManager supplierManager = new SupplierManager(frame);
        Reports reports = new Reports();
    	
    	

    	
    	
    

        // Left Pane Tab...
        
        leftPane.addTab("ClientDetails   ",iconContracts,clientDetails);
        leftPane.addTab("ClientManager   ",iconContracts,clientManager);
        leftPane.addTab("SupplierDetails   ",iconContracts,supplierDetails);
        leftPane.addTab("SupplierManager   ",iconContracts,supplierManager);
	
		topPane.addTab("Contract Details",contractDetails);
        topPane.addTab("Client Contract Details",clientContractDetails);
        topPane.addTab("Supplier Contract Details",supplierContractDetails);
        topPane.addTab("Quality Manager Details",quality);
        topPane.addTab("WHS Systems, Policy Details",whs);
        topPane.addTab("Environmental Management",env);
        topPane.addTab("Insurance Certificates",ic);
        topPane.addTab("Conflicts of Interest and Fair Dealings",fd);
        topPane.addTab("Threatened or Pending Litigation",pl);
        topPane.addTab("Recent Prosecution and Fines",rp);
        topPane.addTab("CSR",csr);
        topPane.addTab("GIPA - Class 1",g1);
        topPane.addTab("GIPA - Class 2",g2);
        topPane.addTab("GIPA - Class 3",g3);
        
        
        
		topPane.setEnabledAt(1,false);
		topPane.setEnabledAt(2,false);
        
        
        topPane.setTabPlacement(JTabbedPane.TOP);
        topPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        leftPane.setTabPlacement(JTabbedPane.LEFT);
    	


        
        JTabbedPane fullPane = new JTabbedPane();
        fullPane.add("EDIT ENTRY",leftPane);
        fullPane.add("NEW ENTRY",topPane);
        
        frame.getContentPane().add(BorderLayout.NORTH,topPanel);
        frame.getContentPane().add(fullPane);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1362,750);
        frame.setVisible(true);
    }
    
    

	public void restart() {
		frame.setVisible(false);
		go();
	}


}