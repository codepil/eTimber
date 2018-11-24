/*
 * Created on Dec 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.manage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.myself.ConvertLobs;
/**
 * @author pbijjala
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ManageData extends JFrame implements ActionListener {

	private javax.swing.JPanel jContentPane = null;
	private JPanel jPanelFirm, jPanelFirmLable, jPanelFirmCheckBox;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;  //  @jve:decl-index=0:
	private JPanel jPanel2 = null;
	private JCheckBox jCheckBox = null;
	private JButton jButton = null;  //  @jve:decl-index=0:
	private JButton jButton1 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JCheckBox jCheckBox1 = null;
	private JButton jButton2 = null;
	private Vector tobeDeleteFirm, tobeDeleteEstate;
	private String[] estatelist, firmlist;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getEastFirmPane() {
		if (jPanel == null) {
			jPanel = new JPanel(new java.awt.BorderLayout());
			jPanel.add(getCheckBoxPanel1(), java.awt.BorderLayout.WEST);
			//jPanel.add(getLabelPanel1(), java.awt.BorderLayout.EAST);
		}
		return jPanel;
	}
	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getWestEstatePane() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel(new java.awt.BorderLayout());
			jPanel1.add(getCheckBoxPanel(), java.awt.BorderLayout.WEST);
			//jPanel1.add(getLabelPanel(), java.awt.BorderLayout.EAST);
		}
		return jPanel1;
	}
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getRootButtonPane() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.add(getJButton1(), null);
			jPanel2.add(getJButton(), null);
			jPanel2.add(getJButton2(), null);
		}
		return jPanel2;
	}
	
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Refresh");
			jButton.setEnabled(false);
			jButton.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					// generate dir list, refresh contentpane & populatePane ()
					//System.out.println(" Refresh actionPerformed()"); 
					// TODO Auto-generated Event stub actionPerformed()
					initialize();
					// generate reports
					ConvertLobs.generateReport();
				}
			});
		}
		return jButton;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Delete");
			jButton1.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {  
					for (int i=0; i< tobeDeleteEstate.size(); i++){
				    	//System.out.println("..TBD.."+tobeDeleteEstate.get(i));
				    	
				    	deleteDir("Reports\\"+(String)tobeDeleteEstate.get(i));
				    							
				    	// delete igData & XML data..
						String ename, eflag;
				    	// parse
				    	if (((String)tobeDeleteEstate.get(i)).startsWith("estate\\")){
				    		ename = ((String)tobeDeleteEstate.get(i)).substring(7);
				    		eflag = "estate";
				    	}else {
				    		ename = ((String)tobeDeleteEstate.get(i)).substring(5); //firm
				    	    eflag = "firm";
				    	}
				    	System.out.println(eflag+"\\"+ename+" is been selected for delete");
				    
				    	// remove configData/<ename>, data/<ename>/*, data/<ename>
				    	deleteDir(eflag+"\\data\\"+ename);
				    	(new File(eflag +"\\configData\\"+ename)).delete();
				    			    	
				    	// remove icdata//<ename>/*
				    	if (eflag.equalsIgnoreCase("estate"))
				    		deleteDir("icdata\\"+ename);
				    	else deleteDir("Ogdata\\"+ename);
				
				    }// end of For each ..
					
					// Generate reports..
					ConvertLobs.generateReport();
					
					System.exit(0); // for now
				}
			});
		}
		return jButton1;
	}
	private void deleteDir(String dir){
		File fx = new File(dir);
    	File[] files = fx.listFiles();
		for (int j=0; j<files.length; j++){
			if(!files[j].delete())files[j].deleteOnExit(); 
		}
		if(!fx.delete()){ 
			System.gc(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			if(!fx.delete())fx.deleteOnExit(); 
		}
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Exit");
			jButton2.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("actionPerformed()"); 
					System.exit(0);
					// TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButton2;
	}
	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */    
	private JPanel getCheckBoxPanel() {
		//if (jPanel3 == null) {
			jPanel3 = new JPanel(new GridLayout(0, 1));
			
		//}
		return jPanel3;
	}
	private JPanel getCheckBoxPanel1() {
		//if (jPanelFirmCheckBox == null) {
			jPanelFirmCheckBox = new JPanel(new GridLayout(0, 1));
			
		//}
		return jPanelFirmCheckBox;
	}
	
	
    public static void main(String[] args) {
      new ManageData();
	}
    
	/**
	 * This is the default constructor
	 */
	public ManageData() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300,200);
		//tobeDeleteFirm = new Vector();
		tobeDeleteEstate = new Vector();
		this.setContentPane(getJContentPane());
		this.setTitle("Manage Timber Data");
//		 Show the converter.
	    this.pack();
	    this.setVisible(true);
	    
	    this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { 
            	System.exit(0); }
        });
	    
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			
			jContentPane.add(getEastFirmPane(), java.awt.BorderLayout.EAST);
			jContentPane.add(getWestEstatePane(), java.awt.BorderLayout.WEST);
			jContentPane.add(getRootButtonPane(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(new JButton(), java.awt.BorderLayout.CENTER);
			
			//generateEstateList() // cur dir + tobeDetele dir
			populatePane();
			
		}
		return jContentPane;
	}
	private void populatePane(){
		//Estate: jPanel3 - checkBox, jPanel4 - Lable (Label is not used)
		String dn = new String("Reports\\Estate"); // to avoid timing prb in loading
		File dir = new File(dn);

		String[] estatelist = dir.list();
		for (int i=0; i< estatelist.length ; i++){
		JCheckBox jCheckBoxRef = new JCheckBox();
		jCheckBoxRef.setLabel(estatelist[i]);
		jCheckBoxRef.addActionListener(this);
		jCheckBoxRef.setActionCommand("estate\\"+estatelist[i]);
		jCheckBoxRef.setSelected(false);
		jPanel3.add(jCheckBoxRef);
		}
		//Firm: jPanelFirmCheckBox - checkBox, jPanelFirmLable - Lable
		String firm = new String("Reports\\Firm"); // to avoid timing prb in loading
		File firmdir = new File(firm);

		String[] firmlist = firmdir.list();
		for (int i=0; i< firmlist.length ; i++){
		JCheckBox jCheckBoxRef = new JCheckBox();
		jCheckBoxRef.setLabel(firmlist[i]);
		jCheckBoxRef.addActionListener(this);
		jCheckBoxRef.setActionCommand("Firm\\"+firmlist[i]);
		jCheckBoxRef.setSelected(false);
		jPanelFirmCheckBox.add(jCheckBoxRef);
		}
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Populate tobeDelete dir list..tobeDeleteFirm/tobeDeleteEstate
		//if (e.getActionCommand().equals("<estate lable>")) {
			  //System.out.println("action command ="+ e.getActionCommand() ); 
			  if ( tobeDeleteEstate.contains(e.getActionCommand())){
			  	tobeDeleteEstate.remove(e.getActionCommand());
			  } else tobeDeleteEstate.add(e.getActionCommand());
		//}
	}
}  //  @jve:decl-index=0:visual-constraint="66,26"


