/*
 * Created on Mar 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.myself;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.ImageIcon;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.manage.ManageData;



/**
 * @author pbijjala
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConvertLobs implements ActionListener {

	public SizeTableDisplay sizeTable;

	public static int sno=0; public static int isno=0; 

	public boolean focusIsSet = false, pieceFlag = false, logsFlag=false, reportFlag=false;

	private javax.swing.JLabel jAmtLabel;

    static JTextField tqntt; static DecimalField tamt;

	static double tamtp=0.0; static int tqnt=0, tqntp = 0;

    public static String fileName;

	private String resultTime;

	private String resultDate;

	private static String saveAndExit = "Save";

    // root content pane for the Jframe
	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JButton jButton = null;
	private javax.swing.JScrollPane jScrollPane = null, jScrollPane1 = null;
	private javax.swing.JTable jTable = null;
	private javax.swing.JMenuBar jJMenuBar = null;
	private javax.swing.JMenu jMenu = null;
	private javax.swing.JMenu jMenu1 = null;
	private javax.swing.JMenu jMenu2 = null;
	private javax.swing.JPanel rootPanel = null;
	private javax.swing.Box disRootPanel = null;

	private javax.swing.JPanel j1Panel = null;
	private javax.swing.JPanel j2Panel = null;
	private javax.swing.JPanel j3Panel = null;
	private javax.swing.JPanel j4Panel = null;

	private DecimalFormat moneyFormat;

	private javax.swing.JPanel j5Panel = null; private javax.swing.JPanel bPane1 = null;
	private javax.swing.JPanel j6Panel = null;private javax.swing.JPanel j7Panel = null;
	private javax.swing.JPanel j8Panel = null;

	private javax.swing.JLabel jFileLabel = null;
	private javax.swing.JLabel jDateLabel = null;private javax.swing.JLabel jTCFTLabel = null;

    private javax.swing.JLabel jLabel = null;
	private javax.swing.JTextField jTextField = null;
	private javax.swing.JRadioButton jRadioButton = null;
	private javax.swing.JRadioButton jRadioButton1 = null;

	private javax.swing.JLabel jLabel1 = null;
	private javax.swing.JTextField jTextField1 = null;
	private javax.swing.JButton jButton2 = null;
	private javax.swing.JRadioButton jRadioButton2 = null;
	private javax.swing.JRadioButton jRadioButton3 = null;

	private javax.swing.JButton jButton1 = null;
	private javax.swing.JMenuItem jMenuItem = null;  //  @jve:visual-info  decl-index=0 visual-constraint="67,135"
	private javax.swing.JMenuItem jMenuItem1 = null;  //  @jve:visual-info  decl-index=0 visual-constraint="72,123"
	private javax.swing.JPopupMenu jPopupMenu1 = null;  //  @jve:visual-info  decl-index=0 visual-constraint="15,105"

	private JFrame converterFrame;  //  @jve:visual-info  decl-index=0 visual-constraint="120,94"

	static public TableDisplay logTable;
	public EstateTable estateTable; public FirmTable firmTable;
	static DecimalField tcft, estTCFT, estDisTCFT;
	static String ELC = "00"; static javax.swing.JTextField jELC = null;
	
	static DecimalField tcftD; static DecimalField tcftC; static DecimalField tcftB; static DecimalField tcftA;
	private DecimalFormat tcftFormat, tcftDFormat, tcftCFormat, tcftBFormat, tcftAFormat, edtcftFormat, etcftFormat ;
	private static DecimalFormat tempFormat;
	static double tcftp=0.0;static double  tcftpD=0.0;static double  tcftpC=0.0;static double  tcftpB=0.0;static double  tcftpA=0.0;
	static double etcftp=0.0;static double  edtcftp=0.0;
	
	JPanel contentPane = null; // for converter
	Converter rootObject; SizeConverter rootObject1;

	private javax.swing.JButton jButton3 = null;
	private javax.swing.JButton jButton4 = null;
	private javax.swing.JButton jButton5 = null;
	private javax.swing.JButton jButton6 = null;
	private javax.swing.JButton jButton7 = null;
	private javax.swing.JButton jButton8 = null;
	private javax.swing.JButton jButtonDummy= null;
	
	private javax.swing.JButton jButton9 = null;
	/**
	 * This is the default constructor
	 */
	public ConvertLobs() {
		super();
		initialize();
		verifyPasswd(converterFrame);

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {

		// Create the frame and container.
	    converterFrame = new JFrame("Timber Enterprise");
			Date today;
			SimpleDateFormat formatter;
			today = new Date();

		    formatter = new SimpleDateFormat("EEEdMMMyyyy");
			String temp1 = formatter.format(today);
		    formatter = new SimpleDateFormat("EEE d MMM yyyy");
			resultDate = formatter.format(today);
			formatter = new SimpleDateFormat("HHmmss");
			String temp2 = formatter.format(today);
		    formatter = new SimpleDateFormat("h:mm a");
			resultTime=formatter.format(today);

			//fileName=temp1+"file"+temp2;

		converterFrame.setSize(724, 364);
		//converterFrame.setIconImage(new ImageIcon());
		//System.out.println("will be using file name:"+fileName);
		//converterFrame.setJMenuBar(getJJMenuBar());

  	}

	private void postInitialize(){

		// get Conversion type
		Object[] possibleValues = {"Round Timber", "Size Timber",
				"Manage Data", 
				"Mill Reports"};
	    Object selectedValue = JOptionPane.showInputDialog(null, "Select Timber Type", "Converter", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
	    
	    System.out.println("------------------------------------------------------------------------------------ ");
	    System.out.println(resultDate +" "+ resultTime);
	    System.err.println("------------------------------------------------------------------------------------ ");
	    System.err.println(resultDate +" "+ resultTime);
	    
		if (selectedValue.toString().equals("Round Timber")) {
			System.out.println("Incoming Timber is selected");
			logsFlag = true;
			rootObject= new Converter();
					logTable= new TableDisplay();
					estateTable = new EstateTable();

		} else if (selectedValue.toString().equals("Size Timber")) {
			System.out.println("Outgoing Timber is selected");
			pieceFlag = true;
			rootObject1= new SizeConverter();
			sizeTable = new SizeTableDisplay();
			firmTable = new FirmTable();
		} else if (selectedValue.toString().equals("Manage Data")) {
			System.out.println("Manage Timber Data is selected");
			//try {Runtime.getRuntime().exec("start manageData.bat");
		    //} catch (IOException e1) {	e1.printStackTrace(); }
			ManageData mg = new ManageData();
		    //System.exit(0);
		}else {
			System.out.println("Timber Reporting is selected");
			generateReport();
		    try {Runtime.getRuntime().exec(getBrowserPath()+" reports/index.html");
		    } catch (IOException e1) {	e1.printStackTrace(); }
		   System.exit(0);
		}
		
		if (pieceFlag || logsFlag) {
			converterFrame.setContentPane(getJContentPane());
//			 Show the converter.
		    converterFrame.pack();
		    converterFrame.setVisible(true);
		    
			jButton7.doClick(); // get configuration first..
		}

		converterFrame.addWindowListener(new WindowAdapter() {
						            public void windowClosing(WindowEvent e) { 
						            	System.out.println("ConvertLobs: Main Window closed event");
						            	System.exit(0); }
				        });
		
	}

	/**
	 * 
	 */
	public static void generateReport() {
		// TODO create Reports/index.html
		// data is from "reports/<estate> or <firm> " dir
		String from = "jars/firsthalf.txt";
		String to = "reports/index.html";
		try{
					LineNumberReader in = new LineNumberReader (new FileReader(from));	
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(to, false)));
					String line = in.readLine(); 
					while (line != null){ out.println(line); line = in.readLine();}
			/*File dir = new File("estate\\data");*/
			File dir = new File("reports\\Estate");
			String[] estatelist1 = dir.list();
			for (int i=0; i<estatelist1.length; i++) {
				//System.out.println("Firm list:"+i+" "+estatelist1[i]);
				if (estatelist1[i].endsWith("SampleEstate")) continue;
				out.println("<TR><TD>");
				//<INPUT type="button" name="firmName" onclick="func_1(firmname1);" value="sampleFirmName">
				out.print("<INPUT type=\"button\" name=\"estateName\" onclick=\"func_1('");
				out.print("estate/"+estatelist1[i]+"/"+estatelist1[i]+".html");
				/*out.print("../estate/data/"+estatelist1[i]+"/index.xml");*/
				out.print("');\" value=\""+estatelist1[i]+"\">");
				out.println("</TD>");
				out.println("<TD>"); 
				String[] loadlist1 = new File("reports/estate/"+estatelist1[i]).list();
				for (int j=0; j<loadlist1.length; j++) {
					if (loadlist1[j].endsWith("index.xml")) continue;
					if (loadlist1[j].endsWith(estatelist1[i]+".html")) continue;
					out.print("<INPUT type=\"button\" name=\"loadName\" onclick=\"func_1('");
					out.print("estate/"+estatelist1[i]+"/"+loadlist1[j]);
					String temp = loadlist1[j].substring(0,loadlist1[j].length()-5);
					//System.out.println("length "+estatelist1[i]+" :"+temp.length);
					out.print("');\" value=\""+temp+"\">");
				}
				out.println("</TD></TR>");
			}
			out.print("</TBODY></TABLE><HR align=\"center\" width=\"70%\"><TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><TBODY><TR align=\"center\" bgcolor=\"#ffff00\"><TD><B>Firm Name</B></TD><TD><B>Load Deatils</B></TD></TR>");
			// Firm
			File dir1 = new File("reports\\Firm");
						String[] estatelist = dir1.list();
						for (int i=0; i<estatelist.length; i++) {
							//System.out.println("Firm list:"+i+" "+estatelist[i]);
							if (estatelist[i].endsWith("SampleEstate")) continue;
							out.println("<TR><TD>");
							//<INPUT type="button" name="firmName" onclick="func_1(firmname1);" value="sampleFirmName">
							out.print("<INPUT type=\"button\" name=\"firmName\" onclick=\"func_1('");
							out.print("firm/"+estatelist[i]+"/"+estatelist[i]+".html");
							out.print("');\" value=\""+estatelist[i]+"\">");
							out.println("</TD>");
							out.println("<TD>"); 
							String[] loadlist = new File("reports/firm/"+estatelist[i]).list();
							for (int j=0; j<loadlist.length; j++) {
								if (loadlist[j].endsWith("index.xml")) continue;
								if (loadlist[j].endsWith(estatelist[i]+".html")) continue;
								out.print("<INPUT type=\"button\" name=\"loadName\" onclick=\"func_1('");
								out.print("firm/"+estatelist[i]+"/"+loadlist[j]);
								String temp = loadlist[j].substring(0,loadlist[j].length()-5);
								out.print("');\" value=\""+temp+"\">");
							}
							out.println("</TD></TR>");
						}
			out.print("	</TBODY></TABLE></CENTER><P><BR></P></BODY></HTML>");
					
					in.close();
					out.flush();
					out.close();
				} catch (IOException e) {
				  System.out.println(" ConvertLobs.generateReport: Error in opening file:"+from+" exception is:"+e);}
		
	}

	private void loginError() {
		JOptionPane.showMessageDialog(converterFrame,
		                        "Invalid password. Try again.",
		                        "Error Message",
		                        JOptionPane.ERROR_MESSAGE);
    }

	public void verifyPasswd(JFrame f) {

		        JLabel label = new JLabel("Enter the password: ");
		        JPasswordField passwordField = new JPasswordField(10);
		        passwordField.setEchoChar('*');


		        passwordField.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                JPasswordField input = (JPasswordField)e.getSource();
		                char[] password = input.getPassword();
		                if (isPasswordCorrect(password)) {
		                    postInitialize();
		                } else {
		                    loginError();
		                }
		            }
		        });

		        JPanel contentPane = new JPanel(new BorderLayout());
		        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		        contentPane.add(label, BorderLayout.WEST);
		        contentPane.add(passwordField, BorderLayout.CENTER);

		        f.setContentPane(contentPane);
		        f.addWindowListener(new WindowAdapter() {
											public void windowClosing(WindowEvent e) {
												 // Not saving since there a provision 4 "exit" button
												 /*if (fileName != null){									 
												 	if (logsFlag) {logTable.store2File(fileName, rootObject.currentEstateName, rootObject.currentEstateLoad, rootObject.loadDateField.getText()); }
												 	 else rootObject1.storeData(fileName);
												 } */
												System.exit(0); }
								});
		        f.pack();
	            f.setVisible(true);

	}

    private static boolean isPasswordCorrect(char[] input) {
		        char[] correctPassword = { 'w', 'o', 'o', 'd' };
		        if (input.length != correctPassword.length)
		            return false;
		        for (int i = 0;  i < input.length; i ++)
		            if (input[i] != correctPassword[i])
		                return false;
		        return true;
    }
	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {

		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			//ScalePanel jContentPane = new ScalePanel(new ImageIcon("images/a773.jpg", "Convert CFT").getImage());
			//this.jContentPane = jContentPane;
			jContentPane.setLayout(new java.awt.BorderLayout());

            // By default select Incoming log conversion
			jContentPane.add(getButtonPane(), java.awt.BorderLayout.SOUTH); // exit & save Pane
			jContentPane.add(getDisplayPane(logsFlag), java.awt.BorderLayout.EAST); // Display Table + fields
			jContentPane.add(getJPanel(logsFlag), java.awt.BorderLayout.WEST); // Conveter Pane

			// constant
			JPanel constantPane = new JPanel();
			//constantPane.setLayout(new GridLayout(0, 2));
			constantPane.add(getDateJLabel());//selectPane.add(new JLabel(""));
			constantPane.add(new JLabel("<html> &#169 developed by <bold> <Font Color=green>TeBS Labs </font> </bold> in Singapore. </html>", SwingConstants.RIGHT));
			constantPane.add(bPane1); // real button Pane :-)
			jContentPane.add(constantPane, java.awt.BorderLayout.NORTH);

		}
		return jContentPane;
	}

	private javax.swing.JPanel getButtonPane() {

		javax.swing.JPanel bPane = new javax.swing.JPanel(new java.awt.BorderLayout());
		
		if (bPane1 == null){ // real button Pane
		bPane1 = new javax.swing.JPanel();
		bPane1.add(getJButton7(), null); // configure estate
		//if (logsFlag) bPane1.add(getJButton9(), null); // save estate, is no more required
		bPane1.add (getJButton()); // Save, both load & estate/firm data
		bPane1.add(getJButton8(), null); // Print Firm
		bPane1.add(getJButton4(), null); // Print estate
		bPane1.add(getJButton3(), null); // Print load of both estate & Firm
		//bPane1.add(getJButton5(), null); // timber reports
		bPane1.add(getJButton6(), null); // exit
		}
		
		if (logsFlag){// estate Table
		javax.swing.Box bPane2 = new Box(BoxLayout.Y_AXIS);//new javax.swing.JPanel(new GridLayout(0, 1));
		//bPane2.add(new JLabel("<html><center><b><Font Color=green>Estate Details</font></b></center></html>"));
		bPane2.add(getJScrollPane1());
		
		    // add estate details
			if(j8Panel == null) {
				j8Panel = new javax.swing.JPanel();
				
				etcftFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				etcftFormat.setMaximumFractionDigits(2);
				etcftFormat.setMinimumFractionDigits(2);
				etcftFormat.setNegativePrefix("(");
				etcftFormat.setNegativeSuffix(")");
				etcftFormat.setGroupingUsed(false);
				edtcftFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				edtcftFormat.setMaximumFractionDigits(2);
				edtcftFormat.setMinimumFractionDigits(2);
				edtcftFormat.setNegativePrefix("(");
				edtcftFormat.setNegativeSuffix(")");
				edtcftFormat.setGroupingUsed(false);
				
				estTCFT = new DecimalField(etcftp, 6, etcftFormat);
				estDisTCFT = new DecimalField(edtcftp, 6, edtcftFormat);
				jELC = new javax.swing.JTextField(ELC);
				jELC.setEditable(false); jELC.setForeground(Color.red);
				
				estTCFT.setEditable(false);
				estTCFT.setForeground(Color.red);
				estTCFT.setToolTipText("Total Cubic Feet for a given Estate");

				estDisTCFT.setEditable(false); estDisTCFT.setForeground(Color.red);
				
				j8Panel.add(new JLabel("Estate total no.of Loads:"));
				j8Panel.add(jELC);
				j8Panel.add(new JLabel("Total CFT:"));
				j8Panel.add(estTCFT);
				//j8Panel.add(new JLabel(" after Discount:"));
				//j8Panel.add(estDisTCFT);
				
			}
		    bPane2.add(j8Panel);
		
		// done with bPane2 == pane to hold estate table & data, now add
		bPane.add(bPane2,BorderLayout.SOUTH ); // add estate table
		}
		// Final Button Pane
		// bPane.add(bPane1,BorderLayout.CENTER ); // added on the top section of Converter
		
		return bPane;

	}
	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if(jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Save Load");
			jButton.setActionCommand(saveAndExit);
			jButton.setMnemonic(KeyEvent.VK_S);
			jButton.setToolTipText("Save the Data entered to a file");
			jButton.addActionListener(this);
			//jButton.setIcon();
		}
		return jButton;
	}
	/**
	 * This method initializes jTable
	 *
	 * @return javax.swing.JTable
	 */
	private javax.swing.JTable getJTable() {
		if(jTable == null) {
			//logTable = new TableDisplay();
			//jTable = new javax.swing.JTable(tbd.getTableDisplay());
			jTable = logTable.getTableDisplay();
		}
		return jTable;
	}


    //table rows: amount, rate, wclass ,rate ,numPeriods, amt, tcft
	public static void addToTable(double length, String Breadth, String acft, String bcft, String ccft, String dcft,String wclass, double rate, int Quantity, String amt,String tcft){
		sno++;
		
		final Object[] data = { new Integer(sno), new Double(length), Breadth, acft,bcft, ccft,dcft,
			wclass, new Double(rate), new Integer(Quantity), amt,tcft, new Boolean(false)};

		//logTable.getModel().addRow(data);
		logTable.getModel().insertRow(0,data);
		try {
			//this.tcft.setValue(tcft+this.tcft.getValue());
			addTCFT(new Double(tcft).doubleValue()); 
			//addTCFT(((Double)tempFormat.parse(tcft)).doubleValue()); // not required
			addAmount(new Double(amt).doubleValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addQuantity(Quantity);
	}

	/**
	 * @param amt
	 */
	public static void addAmount(double amt) {
		tamtp = amt + tamtp;
		tamt.setValue(tamtp);
	}
	public static void addQuantity(int Quantity) {
			tqntp = Quantity + tqntp;
			tqntt.setText(Integer.toString(tqntp));
		}
	public static void subAmount(double amt) {
			tamtp = tamtp - amt;
			tamt.setValue(tamtp);
	}
	public static void subQuantity(int amt) {
				tqntp = tqntp - amt;
				tqntt.setText(Integer.toString(tqntp));
		}

	public static void addTCFT(double tc){
		tcftp = tcftp + tc;
		//tcftp = Double.parseDouble(tcft.getText());
		tcft.setValue(tcftp);

	}

	public static void subTCFT(double tc){
					tcftp = tcftp - tc;
			//tcftp = Double.parseDouble(tcft.getText());
			tcft.setValue(tcftp);
	}

	// for load details display
	private javax.swing.Box getDisplayPane(boolean Logs) {

		tcftFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		tcftFormat.setMaximumFractionDigits(2);
		tcftFormat.setMinimumFractionDigits(2);
		tcftFormat.setNegativePrefix("(");
		tcftFormat.setNegativeSuffix(")");
		tcftFormat.setGroupingUsed(false);
		tcftAFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		tcftAFormat.setMaximumFractionDigits(2);
		tcftAFormat.setMinimumFractionDigits(2);
		tcftAFormat.setNegativePrefix("(");
		tcftAFormat.setNegativeSuffix(")");tcftAFormat.setGroupingUsed(false);
		tcftBFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		tcftBFormat.setMaximumFractionDigits(2);
		tcftBFormat.setMinimumFractionDigits(2);
		tcftBFormat.setNegativePrefix("(");
		tcftBFormat.setNegativeSuffix(")");tcftBFormat.setGroupingUsed(false);
		tcftCFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		tcftCFormat.setMaximumFractionDigits(2);
		tcftCFormat.setMinimumFractionDigits(2);
		tcftCFormat.setNegativePrefix("(");
		tcftCFormat.setNegativeSuffix(")");tcftCFormat.setGroupingUsed(false);
		tcftDFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		tcftDFormat.setMaximumFractionDigits(2);
		tcftDFormat.setMinimumFractionDigits(2);
		tcftDFormat.setNegativePrefix("(");
		tcftDFormat.setNegativeSuffix(")");tcftDFormat.setGroupingUsed(false);
		tempFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		tempFormat.setMaximumFractionDigits(2);
		tempFormat.setMinimumFractionDigits(2);
		tempFormat.setNegativePrefix("(");
		tempFormat.setNegativeSuffix(")");tempFormat.setGroupingUsed(false);


		if(disRootPanel == null) {
			//disRootPanel = new javax.swing.JPanel();
			//disRootPanel.setLayout(new javax.swing.BoxLayout(rootPanel, javax.swing.BoxLayout.Y_AXIS));
			disRootPanel = new Box(BoxLayout.Y_AXIS);

		  if(Logs){ // if the conversion is incoming
		     if(j6Panel == null) {
				j6Panel = new javax.swing.JPanel();
				tcft = new DecimalField(tcftp, 6, tcftFormat);
				tamt = new DecimalField(tcftp, 6, tcftFormat);tqntt = new JTextField(8);
				

				tcft.setEditable(false);
				tcft.setForeground(Color.red);
				tcft.setToolTipText("Total Cubic Feet");

				tamt.setEditable(false); tamt.setForeground(Color.red);
				tqntt.setEditable(false); tqntt.setForeground(Color.red);
				tamt.setToolTipText("Total Amount in Rupees");

				j6Panel.add(getTotalcftJLabel());
				j6Panel.add(tcft);
				j6Panel.add(getAmtJLabel());
				j6Panel.add(tamt);
				j6Panel.add(new JLabel("Total No. of Logs:"));
				j6Panel.add(tqntt);
		    }
			if(j7Panel == null) {
				j7Panel = new javax.swing.JPanel();

				tcftA = new DecimalField(tcftpA, 6, tcftAFormat);tcftA.setEditable(false); tcftA.setForeground(Color.blue);
				tcftB = new DecimalField(tcftpB, 6, tcftBFormat); tcftB.setEditable(false);tcftB.setForeground(Color.blue);
				tcftC = new DecimalField(tcftpC, 6, tcftCFormat); tcftC.setEditable(false);tcftC.setForeground(Color.blue);
				tcftD = new DecimalField(tcftpD, 6, tcftDFormat);tcftD.setEditable(false);tcftD.setForeground(Color.blue);

				j7Panel.add(new JLabel("A Class:")); j7Panel.add(tcftA);
				j7Panel.add(new JLabel(" B Class:")); j7Panel.add(tcftB);
				j7Panel.add(new JLabel(" C Class:")); j7Panel.add(tcftC);
				j7Panel.add(new JLabel(" D Class:")); j7Panel.add(tcftD);
			}


		disRootPanel.add(getJScrollPane());
		disRootPanel.add(j7Panel);
		disRootPanel.add(j6Panel);
		  }
		  else {
		  	// Conversion is outgoing
		  	// call methods from SizeConverter
			disRootPanel = rootObject1.getDisplayPane();
		  }

		}
		return disRootPanel;

	}

	private javax.swing.JLabel getDateJLabel() {

			if(jDateLabel == null) {
				jDateLabel = new javax.swing.JLabel();
				jDateLabel.setText("<html><Font Color=green>"+resultDate+"</font></html>");
			}
			return jDateLabel;
	}
	private javax.swing.JLabel getFileJLabel() {

			if(jFileLabel == null) {
				jFileLabel = new javax.swing.JLabel();
				jFileLabel.setText("<html>,   File:<Font Color=green>"+resultTime +"       "+"</font></html>");
			}
			return jFileLabel;
	}
	private javax.swing.JLabel getTotalcftJLabel() {

			if(jTCFTLabel == null) {
				jTCFTLabel = new javax.swing.JLabel();
				jTCFTLabel.setText("Load Total CFT: ");
			}
			return jTCFTLabel;
	}
	private javax.swing.JLabel getAmtJLabel() {

				if(jAmtLabel == null) {
					jAmtLabel = new javax.swing.JLabel();
					jAmtLabel.setText("Total Amount: ");
				}
				return jAmtLabel;
		}


	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if(jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}
	private javax.swing.JScrollPane getJScrollPane1() {
			if(jScrollPane1 == null) {
				jScrollPane1 = new javax.swing.JScrollPane();
				if(logsFlag)jScrollPane1.setViewportView(estateTable.getTableDisplay());
				else { 
					//jScrollPane1.setViewportView(firmTable.getTableDisplay());
				}
				jScrollPane1.setBackground(Color.lightGray);
			}
			return jScrollPane1;
		}
	
	/**
	 * This method initializes jJMenuBar
	 *
	 * @return javax.swing.JMenuBar
	 */
	private javax.swing.JMenuBar getJJMenuBar() {
		if(jJMenuBar == null) {
			jJMenuBar = new javax.swing.JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
			jJMenuBar.add(getJMenu2());
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes jMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getJMenu() {
		if(jMenu == null) {
			jMenu = new javax.swing.JMenu();
			jMenu.setText("File");
		}
		return jMenu;
	}
	/**
	 * This method initializes jMenu1
	 *
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getJMenu1() {
		if(jMenu1 == null) {
			jMenu1 = new javax.swing.JMenu();
			jMenu1.setText("View");
		}
		return jMenu1;
	}
	/**
	 * This method initializes jMenu2
	 *
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getJMenu2() {
		if(jMenu2 == null) {
			jMenu2 = new javax.swing.JMenu();
			jMenu2.setText("Help");
		}
		return jMenu2;
	}
	/**
	 * This method initializes jPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel(boolean Logs) {
		if (contentPane == null) contentPane = new JPanel();
	    contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    contentPane.setLayout(new BorderLayout());

			ImageIcon icon2 = new ImageIcon("images/logo.gif", "Convert CFT");
			JLabel compLabel = new JLabel(icon2);
			//		add Logo


		    //JPanel selectPane = new JPanel();
			//selectPane.setLayout(new GridLayout(0, 2));
		    //selectPane.add(new JLabel("<html><Font Color=blue>Timber Type:</Font></html>"));
			//selectPane.add(new JLabel(":  "));
			//selectPane.add(getJRadioButton());
			//selectPane.add(getJRadioButton1());

			JPanel compPane = new JPanel();
			compPane.setLayout(new GridLayout(0, 1));
		    compPane.add(compLabel);
		    
		    compLabel.setEnabled(false); // for better LF
		    
		    contentPane.add(compPane, BorderLayout.CENTER);

				   // Group the radio buttons.
							 //ButtonGroup group1 = new ButtonGroup();
							 //group1.add(jRadioButton);
							 //group1.add(jRadioButton1);

        if (Logs) { // conversion for Logs
			//jRadioButton.setSelected(true);

		//contentPane.add(rootObject.getFieldPane(),BorderLayout.NORTH);
		contentPane.add(rootObject.getConvertPanel(), BorderLayout.SOUTH);

        } else { // conversion for cut sizes
			//jRadioButton1.setSelected(true);

		//contentPane.add(rootObject1.getFieldPane(),BorderLayout.NORTH); // extra  static fields
		contentPane.add(rootObject1.getConvertPanel(), BorderLayout.SOUTH); // convert data

        }

		return contentPane;
	}
	/**
	 * This method initializes jLabel
	 *
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel() {
		if(jLabel == null) {
			jLabel = new javax.swing.JLabel();
			jLabel.setText("Length");
		}
		return jLabel;
	}
	/**
	 * This method initializes jTextField
	 *
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getJTextField() {
		if(jTextField == null) {
			jTextField = new javax.swing.JTextField();
			jTextField.setText("200");
		}
		return jTextField;
	}
	/**
	 * This method initializes jRadioButton
	 *
	 * @return javax.swing.JRadioButton
	 */


	/**
	 * This method initializes jLabel1
	 *
	 * @return javax.swing.JLabel
	 */
	private javax.swing.JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new javax.swing.JLabel();
			jLabel1.setText("Girth");
		}
		return jLabel1;
	}
	/**
	 * This method initializes jTextField1
	 *
	 * @return javax.swing.JTextField
	 */
	private javax.swing.JTextField getJTextField1() {
		if(jTextField1 == null) {
			jTextField1 = new javax.swing.JTextField();
			jTextField1.setText("23");
			//jTextField1.setMnemonic(KeyEvent.VK_B);
		}
		return jTextField1;
	}
	/**
	 * This method initializes jButton2
	 *
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setText("Caluculate");
			jButton2.setMnemonic(KeyEvent.VK_C);
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setText("Caluculate & Add -->");
			jButton1.setMnemonic(KeyEvent.VK_A);
		}
		return jButton1;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getJMenuItem() {
		if(jMenuItem == null) {
			jMenuItem = new javax.swing.JMenuItem();
			jMenuItem.setText("1");
		}
		return jMenuItem;
	}
	/**
	 * This method initializes jMenuItem1
	 *
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getJMenuItem1() {
		if(jMenuItem1 == null) {
			jMenuItem1 = new javax.swing.JMenuItem();
			jMenuItem1.setText("2");
		}
		return jMenuItem1;
	}
	/**
	 * This method initializes jPopupMenu1
	 *
	 * @return javax.swing.JPopupMenu
	 */
	private javax.swing.JPopupMenu getJPopupMenu1() {
		if(jPopupMenu1 == null) {
			jPopupMenu1 = new javax.swing.JPopupMenu();
		}
		return jPopupMenu1;
	}
	public static void addTCFTA(double tc){
			tcftpA = tcftpA + tc;
			//tcftp = Double.parseDouble(tcft.getText());
			tcftA.setValue(tcftpA);

		}

		public static void subTCFTA(double tc){
						tcftpA = tcftpA - tc;
				//tcftp = Double.parseDouble(tcft.getText());
				tcftA.setValue(tcftpA);
		}

	public static void addTCFTB(double tc){
			tcftpB = tcftpB + tc;
			//tcftp = Double.parseDouble(tcft.getText());
			tcftB.setValue(tcftpB);

		}

		public static void subTCFTB(double tc){
						tcftpB = tcftpB - tc;
				//tcftp = Double.parseDouble(tcft.getText());
				tcftB.setValue(tcftpB);
		}
	public static void addTCFTC(double tc){
			tcftpC = tcftpC + tc;
			//tcftp = Double.parseDouble(tcft.getText());
			tcftC.setValue(tcftpC);

		}

		public static void subTCFTC(double tc){
						tcftpC = tcftpC - tc;
				//tcftp = Double.parseDouble(tcft.getText());
				tcftC.setValue(tcftpC);
		}
	public static void addTCFTD(double tc){
			tcftpD = tcftpD + tc;
			//tcftp = Double.parseDouble(tcft.getText());
			tcftD.setValue(tcftpD);

		}

		public static void subTCFTD(double tc){
						tcftpD = tcftpD - tc;
				//tcftp = Double.parseDouble(tcft.getText());
				tcftD.setValue(tcftpD);
		}
		
		public static void setETCFT(double tc){
			etcftp = tc;
			//tcftp = Double.parseDouble(tcft.getText());
			estTCFT.setValue(etcftp);
		}
		public static void setEDTCFT(double tc){
			edtcftp = tc;
			//tcftp = Double.parseDouble(tcft.getText());
			estDisTCFT.setValue(edtcftp);
		}
		public static void setELC(String tc){
			ELC = tc;
			//tcftp = Double.parseDouble(tcft.getText());
			jELC.setText(ELC);
		}

	public static void main(String[] args) {

			// set the look and feel
				try {
				    UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		        } catch(Exception e) {}



			ConvertLobs cr = new ConvertLobs();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(saveAndExit)) {
		  //System.out.println("ConvertLobs: Saving filename ="+ fileName );
		  if (logsFlag) {
			logTable.store2File(fileName,rootObject.currentEstateName, rootObject.currentEstateLoad, rootObject.loadDateField.getText());
	      	
			estateTable.store2File(rootObject.currentEstateName, rootObject.loadDateField.getText(), rootObject.currentEstateLoad, 
			tqntp, tcftA.getText(), tcftB.getText(), tcftC.getText(), tcftD.getText(), tcft.getText(), rootObject.loadClerkField.getText(), 
			rootObject.tapeField.getText(), rootObject.DCField.getText(), rootObject.stumpsField.getText());
		  	} 
		  else rootObject1.storeData(fileName);
		  generateReport();
		}
		
	}

	/**
	 * This method initializes jButton3
	 *
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton3() {
		if(jButton3 == null) {
			jButton3 = new javax.swing.JButton();
			jButton3.setText("Print Load");
			jButton3.setMnemonic(KeyEvent.VK_L);
			jButton3.setToolTipText("Print Load data");
			jButton3.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				//System.out.println("ConvertLobs: PRINT load actionPerformed()"); 
				jButton.doClick(); // save before printing.
				try { 
					if (logsFlag)Runtime.getRuntime().exec(getBrowserPath()+" reports\\estate\\"+rootObject.currentEstateName.replaceAll("\u0020","%20")+"\\"+rootObject.currentEstateLoad.replaceAll("\u0020","%20")+".html");
					else Runtime.getRuntime().exec(getBrowserPath()+" reports\\firm\\"+rootObject1.currentEstateName.replaceAll("\u0020","%20")+"\\"+rootObject1.currentEstateLoad.replaceAll("\u0020","%20")+".html");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		}
		return jButton3;
	}
	/**
	 * This method initializes jButton4
	 *
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton4() {
		if(jButton4 == null) {
			final String state, stateName;
			jButton4 = new javax.swing.JButton();
			jButton4.setText("Print Estate");
			jButton4.setToolTipText("Print Estate Data");
			
			jButton4.setMnemonic(KeyEvent.VK_P);
			
			jButton4.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				System.out.println("ConvertLobs: PRINT Estate actionPerformed()"); 
				jButton.doClick(); // save before printing
				try {			//String cmd = "C:\\PROGRA~1\\INTERN~1\\iexplore.exe icdata\\" + 
									String nospaceName = rootObject.currentEstateName.replaceAll("\u0020","%20");
									Runtime.getRuntime().exec(getBrowserPath()+" reports\\estate\\"+nospaceName+"\\"+nospaceName+".html");
								} catch (IOException e1) {
									e1.printStackTrace();
								}
				//logTable.printTable(converterFrame);
			}
		});
			if (!logsFlag) jButton4.setVisible(false);
		}
		return jButton4;
	}
	/**
			 * This method initializes jRadioButton
			 *
			 * @return javax.swing.JRadioButton
			 */
			private javax.swing.JRadioButton getJRadioButton() {
				if(jRadioButton == null) {
					jRadioButton = new javax.swing.JRadioButton();
					jRadioButton.setText("Incoming");
					if (!logsFlag && !pieceFlag) { //jRadioButton.setSelected(true);
						logsFlag = true;}
					jRadioButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {


													if(jRadioButton.isSelected()) {
														if (!logsFlag) {
															//System.out.println("Radio button slected ="+ e.getActionCommand() );
															// call
															contentPane.add(rootObject.getFieldPane(),BorderLayout.CENTER);
															contentPane.add(rootObject.getConvertPanel(), BorderLayout.SOUTH);
															//set visible
															converterFrame.pack();
															converterFrame.setVisible(true);
														}
														logsFlag = true;
													}
													else { if (logsFlag == true) logsFlag = false;
														   else System.out.println("error in logic of radio buttion)");
													}
												}
										 }
									);
				}
				return jRadioButton;
			}
			/**
			 * This method initializes jRadioButton1
			 *
			 * @return javax.swing.JRadioButton
			 */
			private javax.swing.JRadioButton getJRadioButton1() {
				if(jRadioButton1 == null) {
					jRadioButton1 = new javax.swing.JRadioButton();
					jRadioButton1.setText("Outgoing");
					jRadioButton1.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {

													if(jRadioButton1.isSelected()) {
														if(!pieceFlag){
															//System.out.println("Radio button slected ="+ e.getActionCommand());
															//ca;ll
															contentPane.add(rootObject1.getFieldPane(),BorderLayout.CENTER); // extra  static fields
															contentPane.add(rootObject1.getConvertPanel(), BorderLayout.SOUTH); // convert data
															// set visible
															converterFrame.pack();
															converterFrame.setVisible(true);
														}
														pieceFlag = true;
													}
													else { if (pieceFlag == true) pieceFlag = false;
														   else System.out.println("error in logic of radio buttion1)");
													}

												}
									}
					);
				}
				return jRadioButton1;
		}

	/**
	 * This method initializes jButton5
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton5() {
		if(jButton5 == null) {
			jButton5 = new javax.swing.JButton();
			jButton5.setText("Timber Reports");
			jButton5.setEnabled(false);
			// TODO: depending on Timber type, display print Jdialog menu..
			// if existing load i.e from file system is selected then call PrintSupport.getPrintPanel();
			jButton5.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("PRINT MGR actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					try {				//String cmd = "C:\\PROGRA~1\\INTERN~1\\iexplore.exe icdata\\" + 
						Runtime.getRuntime().exec(getBrowserPath()+" reports.html");
					} catch (IOException e1) {
							e1.printStackTrace();
					}
				}
			});
		}
		return jButton5;
	}
	/**
	 * This method initializes jButton6
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton6() {
		if(jButton6 == null) {
			jButton6 = new javax.swing.JButton();
			jButton6.setText("Exit");
			
			
		jButton6.addActionListener(new java.awt.event.ActionListener() { 
		 public void actionPerformed(java.awt.event.ActionEvent e) {    
					System.out.println(" ConvertLobs: EXIT button - actionPerformed()"); 
//			TODO: set action, ask for saving of load & estate details, if not already saved;
		Object[] options = {"Yes",
					"No", "Cancel"};
		int n = JOptionPane.showOptionDialog(null,"Would you like to save data?", "System exit",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,     //don't use a custom Icon
						options,  //the titles of buttons
						options[0]); //default button title
	
		if (fileName != null && n == 0) {
	      if (logsFlag) {
	      	logTable.store2File(fileName,rootObject.currentEstateName, rootObject.currentEstateLoad, rootObject.loadDateField.getText());
	      	
	      	estateTable.store2File(rootObject.currentEstateName, rootObject.loadDateField.getText(), rootObject.currentEstateLoad, 
			tqntp, tcftA.getText(), tcftB.getText(), tcftC.getText(), tcftD.getText(), tcft.getText(), rootObject.loadClerkField.getText(), 
			rootObject.tapeField.getText(), rootObject.DCField.getText(), rootObject.stumpsField.getText());
	      } 
		  else {
		  	// save load , so intern it saves Firm.
			rootObject1.storeData(fileName);
		  }
	      generateReport();
		}
		boolean exit = true;
		if (fileName == null && n ==0) {JOptionPane.showMessageDialog(converterFrame, "Invalid File, select through Estate/Firm & Load options",
		"Error Message", JOptionPane.ERROR_MESSAGE); exit = false;}
		if (n != 2 && exit)	System.exit(0);
			}
		});
		}
		return jButton6;
	}
	/**
	 * This method initializes jButton7
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton7() {
		if(jButton7 == null) {
			jButton7 = new javax.swing.JButton();
			jButton7.setText("Configure");
			jButton7.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					//System.out.println("ConvertLobs: CONFIG button actionPerformed()"); 
					JDialog jd;
					if (logsFlag)
					  jd = rootObject.getJDialog(converterFrame);
					else jd = rootObject1.getJDialog(converterFrame);
					jd.pack();
					if (logsFlag) rootObject.jComboBox.requestFocus(true);
					else rootObject1.jComboBox.requestFocus(true);
					jd.setVisible(true);
					
				}
			});
		}
		return jButton7;
	}
	/**
	 * This method initializes jButton8
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton8() {
		if(jButton8 == null) {
			jButton8 = new javax.swing.JButton();
			jButton8.setText("Print Firm");
			jButton8.setMnemonic(KeyEvent.VK_F);
			jButton8.setToolTipText("Print Firm Data");
			//jButton8.addActionListener(this);
			if (!pieceFlag) jButton8.setVisible(false);
			jButton8.addActionListener(new java.awt.event.ActionListener() { 
						public void actionPerformed(java.awt.event.ActionEvent e) {    
							System.out.println("PRINT Firm actionPerformed()"); 
							jButton.doClick(); // save before printing
							try {			//String cmd = "C:\\PROGRA~1\\INTERN~1\\iexplore.exe icdata\\" + //get Current working dir incase of IE
											// "C:\\PROGRA~1\\MOZILL~1\\firefox.exe firm\\data\\" 
												String nospaceName = rootObject1.currentEstateName.replaceAll("\u0020","%20");
												Runtime.getRuntime().exec(getBrowserPath()+" reports\\firm\\"+nospaceName+"\\"+nospaceName+".html");
											} catch (IOException e1) {
												e1.printStackTrace();
											}
							//logTable.printTable(converterFrame);
						}
					});
		}
		return jButton8;
	}
	
	/**
	 * This method is not used since load save will save estate/firm too..
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton9() {
		// this button is ***not been**** used..
		if(jButton9 == null) {
			jButton9 = new javax.swing.JButton();
			if (logsFlag){jButton9.setText("Save Estate");
			jButton9.setToolTipText("Save Estate Data"); }
			else {jButton9.setText("Save Firm");
			jButton9.setToolTipText("Save Firm Data");}
		jButton9.setMnemonic(KeyEvent.VK_S);
			
			jButton9.addActionListener(new java.awt.event.ActionListener() { 
						public void actionPerformed(java.awt.event.ActionEvent e) {    
							System.out.println("ConvertLobs: Save Estate/Firm button actionPerformed()"); 
							if (logsFlag){
							
							estateTable.store2File(rootObject.currentEstateName, rootObject.loadDateField.getText(), rootObject.currentEstateLoad, 
							tqntp, tcftA.getText(), tcftB.getText(), tcftC.getText(), tcftD.getText(), tcft.getText(), rootObject.loadClerkField.getText(), 
							rootObject.tapeField.getText(), rootObject.DCField.getText(), rootObject.stumpsField.getText() );
							}
							else {
								//firmTable.store2File();
							}
							//generateReport();
						}
					});
			
		}
		return jButton9;
	}
	private javax.swing.JButton getJButtonDummy() {
			if(jButtonDummy == null) {
				jButtonDummy = new javax.swing.JButton();
				jButtonDummy.setText("   ");
				jButtonDummy.setEnabled(false);
			
		}
		return jButtonDummy;
	}
	private String getBrowserPath(){
		if ( (new File("C:\\PROGRA~1\\MOZILL~1\\firefox.exe")).exists()){
			return "C:\\PROGRA~1\\MOZILL~1\\firefox.exe";
		}
		else if ( (new File("C:\\PROGRA~1\\INTERN~1\\iexplore.exe")).exists()){
			return "C:\\PROGRA~1\\INTERN~1\\iexplore.exe";
		}
		return null;
	}
	
}  //  @jve:visual-info  decl-index=0 visual-constraint="86,12"
