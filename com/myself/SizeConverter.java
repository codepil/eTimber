/*
 * Created on Apr 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.myself;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * @author pbijjala
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SizeConverter extends JFrame {
	private String type = " ";
	private boolean configSaved = false;
	public static boolean clearSizeTable= false;
	private FirmTable firmTable;
	private JTextField clerkField;
	private JTextField articlesField;
	private JTextField orderNumField;
	private JTextField loadDateField; public static JTextField addressField;
	private Box disRootPanel;
	private javax.swing.JPanel TablePane;
	public String[] estatelist, estatelist1;
	public String currentEstateName = null, currentEstateLoad = null;
	public boolean loadenable=true;
	public javax.swing.JComboBox jComboBox = null;
	private javax.swing.JComboBox jComboBox1 = null;

private String CfileName;

private javax.swing.JScrollPane jScrollPane, jFScrollPane;
private javax.swing.JTable jTable, jFTable;
private SizeTableDisplay outLogTable;
public static int sno=0;

//	Values for the text fields
	  private int amount = 6; private int minLength = 0;
	  private double rate = 6.0;
	  private double thick = 1.5;
	  private int numPeriods = 1;
	  private int bundle = 1;
	  private double payment = 0.0, rft = 0.0;
	  private double widthIn=6.0; double thickIn=1.5;
	  private int lengthFt=10;

	  // total variables, for a perticulat size
      //	 fcft = firm's total CFT
	  // tFLnumPeriods = Firm's no.of loads
	  public static double tsrft=0.0, tscft=0.0; public static int tsnumPeriods=0;
	  public static double trft=0.0, tcft=0.0, fcft=0.0; public static int tnumPeriods=0, tFLnumPeriods=0;
	  private DecimalFormat tcftFormat,tcftDFormat, tcftCFormat, tcftBFormat, tcftAFormat ;
	  private DecimalField tcftA,tcftB,tcftC,tcftD;
	  private double tcftpA,tcftpB,tcftpC,tcftpD;
	  public static DecimalField tsrftField, tscftField, trftField, tcftField, tempField, fcftField;
	  public static WholeNumberField tsnumPeriodsField, tnumPeriodsField, bundleField, tFLnumPeriodsField;

	  //Labels to identify the text fields
	  private JLabel amountLabel;
	  private JLabel rateLabel, thickLabel;
	  private JLabel numPeriodsLabel;
	  private JLabel rftLabel, paymentLabel,dummyLabel,compLabel,inLabel,ftLabel, bundleLabel;
	  private javax.swing.JPanel j7Panel, j6Panel, j8Panel, temp1Panel, tempPanel;

	  private javax.swing.JRadioButton jRadioButton = null;
	  private javax.swing.JRadioButton jRadioButton1 = null;
	  private javax.swing.JRadioButton jRadioButton2 = null;
	  private javax.swing.JRadioButton jRadioButton3 = null;

	  //Strings for the labels
	  private static String amountString = "Length: ";
	  private static String rateString = "     Width: ";
	  private static String thickString = "     Thickness: ";
	  private static String numPeriodsString = "   Quantity: ";
	  private static String paymentString = "Cubic Feet  ";
	  private static String rftString = "Running Feet  ";
	  private static String cal = "Done Size";

	  // having bug
	  public WholeNumberField amountField;
	  private DecimalField rateField, thickField ;
	  private WholeNumberField numPeriodsField;
	  private DecimalField paymentField, rftField;

	  private JButton calculateButton;
	  private JButton calAddButton, clearButton;

	  //Formats to format and parse numbers
	  private NumberFormat moneyFormat;
	  //private NumberFormat percentFormat;
	  private DecimalFormat paymentFormat;

	  public boolean focusIsSet = false, pieceFlag = false, logsFlag=false;

	private javax.swing.JDialog jDialog = null;  //  @jve:visual-info  decl-index=0 visual-constraint="768,366"
		private javax.swing.JPanel jContentPane1 = null, jContentPane1dif = null;
		private javax.swing.JPanel jPanel = null;  //  @jve:visual-info  decl-index=0 visual-constraint="1058,505"
		private javax.swing.JPanel jPanel1 = null;  //  @jve:visual-info  decl-index=0 visual-constraint="984,507"
		private javax.swing.JPanel jButtonPanel = null;
		private javax.swing.JPanel jPanelEstate = null;

		//Estate configuration, stored in estate/config/<name>.xml
		private DecimalField cfgRateAField, cfgRateBField, cfgRateCField,cfgRateDField;
		private JTextField cfgClassAField, cfgClassBField, cfgClassCField, cfgClassDField, cfgRateEField;
		private JTextField cfgClassEField;
		private JTextField cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
		public static String EA, EC, ES;
		private double rateA = 0, rateB = 0, rateC = 0, rateD = 0, rateE =0;
		private int classAlimit = 36, classBlimit = 24, classClimit = 18, classDlimit = 0, classElimit = 5;


	public int typeSno = 0;


	  public SizeConverter() {
		  super("SizeConverter");
	  }
	  public javax.swing.JPanel getConvertPanel() {
		initialize();

		  setUpFormats();

		  payment = computePaymentCFT(lengthFt, widthIn, numPeriods, thickIn, bundle);
		  rft = computePaymentRFT(lengthFt, widthIn, numPeriods, thickIn, bundle);
		  ImageIcon icon1 = new ImageIcon("images/convert.gif", "Convert CFT");
		  ImageIcon icon2 = new ImageIcon("images/logo.gif", "Convert CFT");


		  //Create the labels.
		  amountLabel = new JLabel(amountString);
		  amountLabel.setText("<html><Font Color=green>" + amountString + "</Font><Font Color=black>in Feet</font></html>");


		  rateLabel = new JLabel(rateString);
		  thickLabel = new JLabel(thickString);
		  rateLabel.setText("<html><Font Color=green>" + rateString + "</Font> <Font Color=black>in Inches</font></html>");
		  thickLabel.setText("<html><Font Color=green>" + thickString + "</Font><Font Color=black> Inches</font></html>");

		  numPeriodsLabel = new JLabel(numPeriodsString);
		  numPeriodsLabel.setText("<html><Font Color=green>" + numPeriodsString + "</Font> &#35 <Font Color=black> </font></html>");
		  bundleLabel = new JLabel("<html><Font Color=green>Bundle Size</Font> &#35 <Font Color=black> </font></html>");
		  
		  paymentLabel = new JLabel(paymentString);
		  rftLabel = new JLabel(rftString);
		  paymentLabel.setText("<html><Font Color=red>" + paymentString + "</Font> &#61 <Font Color=black> </font></html>");
		  rftLabel.setText("<html><Font Color=red>" + rftString + "</Font> &#61 <Font Color=black> </font></html>");

		  //calculateButton = new JButton(icon);
		  calculateButton = new JButton(cal);
		  calculateButton.setToolTipText("Done with a one size");
		  calculateButton.setMnemonic(KeyEvent.VK_C);
		  calAddButton = new JButton("ADD");
		  calAddButton.setMnemonic(KeyEvent.VK_A);
		  calAddButton.setToolTipText("Add converted CFT to sheet");
		  clearButton = new JButton ("Clear"); clearButton.setToolTipText("Clear the Data"); clearButton.setMnemonic(KeyEvent.VK_O);

		  compLabel = new JLabel(icon2);
		  dummyLabel = new JLabel();
		  ftLabel = new JLabel("Ft"); inLabel = new JLabel("In");


       //Create the text fields and set them up.
        MyDocumentListener myDocumentListener = new MyDocumentListener();

        amountField = new WholeNumberField(amount, 6);
        amountField.getDocument().addDocumentListener(myDocumentListener);
        amountField.getDocument().putProperty("name", "amount");
		amountField.setCaretPosition(0);

        rateField = new DecimalField(rate, 6, moneyFormat);
        rateField.getDocument().addDocumentListener(myDocumentListener);
        rateField.getDocument().putProperty("name", "rate");

		thickField = new DecimalField(thick, 6, moneyFormat);
		thickField.getDocument().addDocumentListener(myDocumentListener);
		thickField.getDocument().putProperty("name", "thick");

        numPeriodsField = new WholeNumberField(numPeriods, 6);
        numPeriodsField.getDocument().addDocumentListener(myDocumentListener);
        numPeriodsField.getDocument().putProperty("name", "numPeriods");
		//numPeriodsField.setCaretPosition(0);
        
        bundleField = new WholeNumberField(1, 6);
        bundleField.getDocument().addDocumentListener(myDocumentListener);
        bundleField.getDocument().putProperty("name", "bundle");

        paymentField = new DecimalField(payment, 6, paymentFormat);
        paymentField.setEditable(false);
        paymentField.setForeground(Color.red);

		rftField = new DecimalField(rft, 6, paymentFormat);
		rftField.setEditable(false);
		rftField.setForeground(Color.red);



		  //Tell accessibility tools about label/textfield pairs.
		  amountLabel.setLabelFor(amountField);

		  amountField.setToolTipText("Enter Length in feet, Ex: 10 ");
		  rateLabel.setLabelFor(rateField);
		  rateField.setToolTipText("Enter Width in feet, Ex: 4.6 for 4 Feet 6 Inches");
		  thickLabel.setLabelFor(thickField);
		  thickField.setToolTipText("Enter Thickness in feet, Ex: 4.6 for 4 Feet 6 Inches");
		  numPeriodsLabel.setLabelFor(numPeriodsField);
		  numPeriodsField.setToolTipText("Enter number of pieces");
		  
		  bundleLabel.setLabelFor(bundleField);
		  bundleField.setToolTipText("Enter number of pieces per Bundle");
		  paymentLabel.setLabelFor(paymentField);
		  paymentField.setToolTipText("Converted cut size in Cubic Feet");
		  rftLabel.setLabelFor(rftField);
		  rftField.setToolTipText("Converted cut size in Running Feet");

		  //Layout the labels in a panel.
		  JPanel labelPane = new JPanel();
		  labelPane.setLayout(new GridLayout(0, 1));
		  labelPane.add(amountLabel);
		  labelPane.add(rateLabel);
		  labelPane.add(thickLabel);
		  labelPane.add(numPeriodsLabel);
		  labelPane.add(paymentLabel);
		  labelPane.add(rftLabel);
		  labelPane.add(bundleLabel);


		  //Layout the text fields in a panel.
		  JPanel fieldPane = new JPanel();
		  fieldPane.setLayout(new GridLayout(0, 1));
		  fieldPane.add(amountField);
		  fieldPane.add(rateField);
		  fieldPane.add(thickField);
		  fieldPane.add(numPeriodsField);
		  fieldPane.add(paymentField);
		  fieldPane.add(rftField);
		  fieldPane.add(bundleField);


		  //Convert & add
		  JPanel field2Pane = new JPanel();
		  //field2Pane.setLayout(new GridLayout(0, 1));
		  //calculateButton.setSize(10,10);
		  //calAddButton.setSize(10,10);
		  field2Pane.add(calculateButton);
		  field2Pane.add(clearButton);
		  field2Pane.add(calAddButton);

		  //Put the panels in another panel, labels on left,
		  //text fields on right.
		  JPanel contentPane = new JPanel();
		  contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		  contentPane.setLayout(new BorderLayout());
		  contentPane.add(labelPane, BorderLayout.WEST);
		  contentPane.add(fieldPane, BorderLayout.CENTER);
		  contentPane.add(field2Pane, BorderLayout.SOUTH);

		amountField.addActionListener(new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					//System.out.println("Enter key pressed ="+ e.getActionCommand() );
					if(rateField.isEditable()) rateField.requestFocus();
					else numPeriodsField.requestFocus();
				  }
				});

				numPeriodsField.addActionListener(new ActionListener() {
						  public void actionPerformed(ActionEvent e) {
							//System.out.println("Enter key pressed ="+ e.getActionCommand() );
							calculateAdd(e);
						  }
						});

				rateField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//System.out.println("Enter key pressed ="+ e.getActionCommand() );
						thickField.requestFocus();
					}
				});

		thickField.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//System.out.println("Enter key pressed ="+ e.getActionCommand() );
			numPeriodsField.requestFocus();
		  }
	    });

          calculateButton.addActionListener(new ActionListener() {
		  		 public void actionPerformed(ActionEvent e) {

				  addToTableTotalCutSize(sno, minLength, "Total", rate, thick, tsrft, tscft, tsnumPeriods );
				  amountField.setText("");
				  rateField.setText("");
				  thickField.setText("");
				  numPeriodsField.setText("");
				  paymentField.setValue(0);
				  rftField.setValue(0);
						   //get focus to Length
				  amountField.requestFocus();

		  		 }
		  });

		  calAddButton.addActionListener(new ActionListener() {
		  		            public void actionPerformed(ActionEvent e) {
		  		                //if (e.getActionCommand().equals(cal)) {
		  						//System.out.println("key pressed ="+ e.getActionCommand() );
		  						calculateAdd(e);
							    //}
		  		            }
		        });
		  clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  //				reset fields;
				  amountField.setText("");
				  rateField.setText("");
				  thickField.setText("");
				  numPeriodsField.setText("");
				  paymentField.setValue(0);
				  rftField.setValue(0);
						   //get focus to Length
				  amountField.requestFocus();
			}
          });

		  return contentPane;
	  }

      /**
	 * @param string
	 * @param rate
	 * @param thick
	 * @param tsrft
	 * @param tscft
	 * @param tsnumPeriods
	 */
	protected void addToTableTotalCutSize(int snum, int length, String string, double rate, double thick, double tsrft, double tscft, int tsnumPeriods) {

		String sizeType; // "Planks", "Runners", "Battons", "SLR", "Lapha"
		int col = getType(length, rate,thick );

		//System.out.println("Done size Values:"+length+","+rate+","+thick+","+tsrft+","+tscft+","+tsnumPeriods);

		final Object[] data = { new String(string), type,  new Double(rate), new Double(thick), new Double(tsrft), new Double(tscft),
					new Integer(tsnumPeriods), new Boolean(false)};

		if (snum > 0) {
			outLogTable.store2XML(currentEstateName, currentEstateLoad, type, tsrft, tscft, tsnumPeriods);
		    outLogTable.getModel().addRow(data);

		    //call for Firm table 2 display & update.
		    firmTable.updateRowCFT(currentEstateLoad, col, tscft, orderNumField.getText(),loadDateField.getText());
		}
		// clear the Size table
		clearSizeTable = true;
		col = 0;
		tsrftField.setValue(0); this.tsrft = 0;
		tscftField.setValue(0); this.tscft = 0; 
		bundle=1; bundleField.setValue(bundle);
		tsnumPeriodsField.setValue(0); this.tsnumPeriods = 0; this.numPeriods=0;
		minLength = 0;
		type = " "; calculateButton.setText("Done ");calculateButton.setEnabled(false);
		//calculateButton.setBackground(Color.gray);
		rateField.setEditable(true); thickField.setEditable(true);
	}
	private void calculate(ActionEvent e) {

		  //System.out.println("key pressed ="+ e.getActionCommand() );

		  payment = computePaymentCFT(lengthFt, widthIn, numPeriodsField.getValue(),
		                           thickIn, bundle);
		  paymentField.setValue(payment);

		  rft = computePaymentRFT(lengthFt, widthIn, numPeriodsField.getValue(),
										   thickIn, bundle);
		  rftField.setValue(rft);

		  amountField.requestFocus();

	  }
	  private void calculateAdd(ActionEvent e) {
	  		  double cft = 0.0, rft =0.0; 
	  		  boolean showFlag=false;
	  		  String wclass = null;
	  		  double rateclass = 0, amt=0;


	  		  cft = paymentField.getValue();
	  		  rft = rftField.getValue();


	  	    if ((amount == 0 || rate ==0 || thick ==0 || numPeriods ==0)) {
	  		javax.swing.JOptionPane.showMessageDialog(null, "Size Length/Width/Thickness/Quantity can't be zero", "Add alert", javax.swing.JOptionPane.ERROR_MESSAGE);
	  		//showFlag = true;
	  		return; }

		    if (minLength==0) minLength = amount;
			if  (minLength > amount ) minLength = amount;

			int tempCol = getType(amount, rate, thick);
		   if (!type.equalsIgnoreCase(" ")){calculateButton.setText("Done "+type+"?");
			calculateButton.setBackground(Color.magenta);
			calculateButton.setEnabled(true);}
	  	    // amount = length, rate = width :-))
		   addToTable(amount, rate, thick, rftField.getValue(), paymentField.getValue(), numPeriods*bundle );
		   tsrftField.setValue(tsrft + rftField.getValue()); tsrft = tsrftField.getValue();
		   tscftField.setValue(tscft + paymentField.getValue());tscft = tscftField.getValue();
		   tsnumPeriods = tsnumPeriods + (numPeriods*bundle); tsnumPeriodsField.setValue(tsnumPeriods);

		   trft = rft + trft; trftField.setValue(trft);
		   //tcft = tcft + paymentField.getValue(); tcftField.setValue(tcft); // buggy, too large no.
		   tcftField.setValue(tcft + paymentField.getValue()); tcft = tcftField.getValue();
		   tnumPeriods = tnumPeriods + (numPeriods*bundle); tnumPeriodsField.setValue(tnumPeriods);

	  		  // reset fields;
		      amountField.setText("");
		      numPeriodsField.setText("");
		      rateField.setEditable(false); thickField.setEditable(false);
		      paymentField.setValue(0);
		      amountField.requestFocus();

	  }



	  /**
	 * @param amount
	 * @param rate
	 * @param thick
	 * @return
	 */
	private int getType(int length, double rate, double thick) {
		int col = 0;
				//if thick == 1.5 then Planks (LW>=6), Battons (L>=6 & W<6), Lapha (LW<6)
				// else Runners (L>=6), SLR (L<6)
				if ((length >= 6) && (rate >= 6) && (thick == 1.5)){ col=4; type = "Planks"; }// Planks
				if ((length >= 6) && (rate < 6) && (thick == 1.5)) {col=6; type = "Battons";} // Battons
				if ((length >= 6) && (rate < 6) && (thick != 1.5)) {col=5; type = "Runners";} // Runners
				if ((length < 6) && (rate < 6) && (thick != 1.5)) {col=7; type = "SLR";} // SLR
				if ((length < 6) && (rate < 6) && (thick == 1.5)) {col=8; type = "Lapha";} // Lapha
		  // l<6 w>6 t!=1.5 or l<6 w>6 t==1.5
				if (col == 0 ) { System.out.println("SizeConverter.getType: Unable to classify size"); col = 9; type = "others";}

		return col;
	}
	class MyDocumentListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			  calculateValue(e);
		  }
		  public void removeUpdate(DocumentEvent e) {
			  calculateValue(e);
		  }
		  public void changedUpdate(DocumentEvent e) {
			  // we won't ever get this with PlainDocument
		  }
		  private void calculateValue(DocumentEvent e) {
			  Document whatsup = e.getDocument();

			 if (whatsup.getProperty("name").equals("amount")){
				amount = amountField.getValue();
			 }
			  else if (whatsup.getProperty("name").equals("rate")){
				rate = rateField.getValue();
			 } else if (whatsup.getProperty("name").equals("numPeriods")){
				  numPeriods = numPeriodsField.getValue();
		     } else if (whatsup.getProperty("name").equals("thick")){
						  thick = thickField.getValue();
		  } else if (whatsup.getProperty("name").equals("bundle"))
			  bundle = bundleField.getValue();


			lengthFt = amount; widthIn = rate; thickIn = thick;
			  payment = computePaymentCFT(lengthFt, widthIn, numPeriods, thickIn, bundle);
			  paymentField.setValue(payment);
			  rft = computePaymentRFT(lengthFt, widthIn, numPeriods,thickIn, bundle);
              rftField.setValue(rft);


		  }
	  }

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
        this.setSize(260, 131);

	}




	  public static void main(String[] args) {
		final SizeConverter demo = new SizeConverter();
		JPanel cp = demo.getConvertPanel();
		demo.setContentPane(cp);

		  demo.addWindowListener(

		   new WindowListener() {
			  public void windowClosing(WindowEvent e) {
				  System.exit(0);
			  }

			  //Whenever window gets the focus, let the
			  //SizeConverter set the initial focus.
			  public void windowActivated(WindowEvent e) {
				  demo.setFocus();
			  }

			public void windowOpened(WindowEvent arg0) {


			}

			public void windowClosed(WindowEvent arg0) {

			}

			public void windowIconified(WindowEvent arg0) {

			}

			public void windowDeiconified(WindowEvent arg0) {

			}

			public void windowDeactivated(WindowEvent arg0) {

			}
		   });
		  demo.pack();
		  demo.setVisible(true);
	  }

	  private void setFocus() {
		  if (!focusIsSet) {
			  amountField.requestFocus();
			  focusIsSet = true;
		  }
	  }

	  // Compute the monthly payment based on the loan amount,
	  // APR, and length of loan.
	  double computePaymentCFT(int lengthFt, double widthIn, int Quantity, double thickIn, int bun) {
		 int denominator=0; double answerCFT=0;
		  denominator = 16*9; // = 144
		  answerCFT = ((lengthFt * widthIn * thickIn)/denominator) * Quantity * bun;

		  return answerCFT;
	  }
	  double computePaymentRFT(int lengthFt, double widthIn, int Quantity, double thickIn, int bun) {
		double answerRFT=0;
		answerRFT = (lengthFt * Quantity)* bun;

			  return answerRFT;
	  }

	  // Create and set up number formats. These objects also
	  // parse numbers input by user.
	  private void setUpFormats() {
		  moneyFormat = NumberFormat.getNumberInstance();
		  //XXXX: Workaround. With an empty positive suffix
		  //the format allows letters in the number.
		  ((DecimalFormat)moneyFormat).setPositiveSuffix(" ");
		  moneyFormat.setGroupingUsed(false);

		  //percentFormat = NumberFormat.getNumberInstance();
		  //percentFormat.setMinimumFractionDigits(3);
		  //XXXX: Workaround. With an empty positive suffix
		  //the format allows letters in the number.
		  //((DecimalFormat)percentFormat).setPositiveSuffix(" ");

		  paymentFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		  paymentFormat.setMaximumFractionDigits(2);
		  paymentFormat.setMinimumFractionDigits(2);
		  paymentFormat.setNegativePrefix("(");
		  paymentFormat.setNegativeSuffix(")");
		  paymentFormat.setGroupingUsed(false);
	  }
	/**
	 * @return
	 */
	public javax.swing.JPanel getFieldPane(){

		JPanel selectPane = new JPanel();
					selectPane.setLayout(new BorderLayout());

		JLabel patternLabel1 = new JLabel("Firm Name:");
		JLabel patternLabel2 = new JLabel("Load :");

		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		JPanel northPane = new JPanel(new GridLayout(0, 1));


		JComboBox el = getEstateList();
		el.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		//el.setSize(30, 15); no effect
		JComboBox ll = getLoadList();
		//ll.setSize(30,15);

		//		Tell accessibility tools about label/textfield pairs.
		patternLabel1.setLabelFor(el);
		el.setToolTipText("Select <FirmName> if already exists from the list, or if the entry is new then type the name of Estate ");
		patternLabel2.setLabelFor(ll);
		ll.setToolTipText("Select <Lorry No> if already exists from the list, or if the entry is new then type the name to identify the load ");

		labelPane.add(patternLabel1);fieldPane.add(el, null);
		labelPane.add(patternLabel2);fieldPane.add(ll, null);

		addressField = new JTextField();
		labelPane.add(new JLabel("Address:"));fieldPane.add(addressField);

		loadDateField = new JTextField ((new SimpleDateFormat("d MMM yyyy")).format(new Date()));
		labelPane.add(new JLabel("Date:"));fieldPane.add(loadDateField);

		orderNumField = new JTextField();
		labelPane.add(new JLabel("Order No:"));fieldPane.add(orderNumField);

		articlesField = new JTextField("Silver Oak sawn sizes");
		labelPane.add(new JLabel("Articles:"));fieldPane.add(articlesField);

		clerkField = new JTextField();
		labelPane.add(new JLabel("Clerk Name:"));fieldPane.add(clerkField);


		northPane.add(new JLabel("   "));

		selectPane.add(labelPane,BorderLayout.WEST);
		selectPane.add(fieldPane,BorderLayout.CENTER);
		selectPane.add(northPane,BorderLayout.SOUTH);
		addressField.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								loadDateField.requestFocus();
								//loadDateField.setText("");
							}
						});
		loadDateField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						orderNumField.requestFocus();
						orderNumField.setText("");
					}
				});
		orderNumField.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								articlesField.requestFocus();
								//articlesField.setText("");
							}
				});
		articlesField.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										clerkField.requestFocus();
										clerkField.setText("");
									}
				});
		clerkField.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												amountField.requestFocus();
												amountField.setText("");
											}
		});

		return selectPane;

	  }
	/**
			 * This method initializes jComboBox
			 *
			 * @return javax.swing.JComboBox
			 */
	private javax.swing.JComboBox getEstateList() {
	if(jComboBox == null) {
		File dir = new File("firm\\data");

		estatelist1 = dir.list();
		jComboBox = new javax.swing.JComboBox(estatelist1);
		jComboBox.setEditable(true);
		//jComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		jComboBox.setSize(new Dimension(10,4));

		jComboBox.addActionListener(new ActionListener() {
			private String current; boolean flag=false;

			public void actionPerformed(ActionEvent e) {

					JComboBox cb = (JComboBox)e.getSource();
					String newSelection = (String)cb.getSelectedItem();
					currentEstateName = newSelection;

					if (estatelist1 == null) {
								// Either dir does not exist or is not a directory
					} else {
						for (int i=0; i<estatelist1.length; i++) {
						// Get filename of file or directory

						//System.out.println("Firm list:"+i+" "+estatelist1[i]);
						if (estatelist1[i].endsWith(currentEstateName) && flag == false) { flag=true;
							System.out.println("SizeCoverter:Firm already exits, loading the"+currentEstateName +" details..");
							firmTable.retrive4File(currentEstateName);
							break;
						}
					    }
					}
					// Create new dir by estate name not already exits
					String dn = new String("ogdata\\"+currentEstateName);
					if (!flag) { if(!(new File(dn)).mkdir()) System.out.println("New Firm creation:"+dn);
								else {
												// Todo
								}
					}
								// Populate load list combo box.
								File dir1 = new File(dn); estatelist = dir1.list();
								loadenable = false;
								jComboBox1.removeAllItems(); // remove default items
									// Add new load items, as per dir entry.
									for (int i=0; i<estatelist.length; i++) jComboBox1.addItem(estatelist[i]);
								jComboBox1.setEnabled(true);jComboBox1.setEditable(true);
								loadenable = true;

									// for Estate combobox
								jComboBox.setEditable(false);
								jComboBox.setEnabled(false);

						  }
				});
	}
	return jComboBox;
}
/**
 * This method initializes jComboBox1
 *
 * @return javax.swing.JComboBox
 */
private javax.swing.JComboBox getLoadList() {
	if(jComboBox1 == null) {

		String dn = new String("OgData\\SampleSizeLoad"); // to avoid timing prb in loading
		File dir = new File(dn);

		estatelist = dir.list();
		jComboBox1 = new javax.swing.JComboBox(estatelist);
		jComboBox1.setEditable(true);jComboBox1.setEnabled(false); // disable initially
		jComboBox1.setAlignmentX(Component.LEFT_ALIGNMENT);
		jComboBox1.addActionListener(new ActionListener() {
					 boolean flag=false;

			public void actionPerformed(ActionEvent e) {
				if (loadenable){  // enable code path only thr' estate combo action item

				JComboBox cb = (JComboBox)e.getSource();
				String newSelection = (String)cb.getSelectedItem();
				currentEstateLoad = newSelection;
				CfileName = new String("OgData\\"+currentEstateName+"\\"+currentEstateLoad);

						if (estatelist == null) {
						// Either dir does not exist or is not a directory
						} else {
						  for (int i=0; i<estatelist.length; i++) {
							// Get filename of file or directory
							if (estatelist[i].endsWith(currentEstateLoad)) {
								flag=true; System.out.println("SizeConverter:load details already exits,"+currentEstateLoad +" loading them now..");
								SizeTableDisplay.retrive4File(CfileName);
								ConvertLobs.fileName = CfileName;
							}
						  }
						}

						if (!flag) { try {
									   //new File(fileName);
									   ConvertLobs.fileName = CfileName;}
									 catch (Exception ex) { System.out.println("Failed to create new load file:"+CfileName);}
						}
				// once selected, disable combo
				jComboBox1.setEditable(false);
				jComboBox1.setEnabled(false);

				} // end of load enable if loop
				}
				});
	}
	return jComboBox1;
}

	    public javax.swing.JScrollPane getJScrollPane() {
			if(jScrollPane == null) {
				jScrollPane = new javax.swing.JScrollPane();
				jScrollPane.setViewportView(getJTable());
				jScrollPane.setAutoscrolls(true);
				jScrollPane.setWheelScrollingEnabled(true);
			}
			return jScrollPane;
		}

	   private javax.swing.JTable getJTable() {
			if(jTable == null) {
				outLogTable = new SizeTableDisplay();
				//jTable = new javax.swing.JTable(tbd.getTableDisplay());
				jTable = outLogTable.getTableDisplay();
			}
			return jTable;
		}

			private javax.swing.JScrollPane getFirmTable() {
				if(jFTable == null) {
					firmTable = new FirmTable();
					jFTable = firmTable.getTableDisplay();
				}

				if(jFScrollPane == null) {
				jFScrollPane = new javax.swing.JScrollPane();
				jFScrollPane.setViewportView(jFTable);
				}

				return jFScrollPane;
			}


	//table rows: amount, rate, wclass ,rate ,numPeriods, amt, tcft
	public void addToTable(int length, double width, double thick, double rft, double cft, int Quantity){
		if (clearSizeTable) {
				 //	reset the outLogTable & create new
			 int i = outLogTable.getModel().getRowCount();
			 //System.out.println("Clearing the Size Table, row count = "+ i);

			 for (; i>0; i--) outLogTable.getModel().removeRow(0);
				 /*outLogTable = null;
				 outLogTable = new SizeTableDisplay();
				 jTable = outLogTable.getTableDisplay(); // bring the ref 2 jTable for displayPane */
				 sno = 0;
			 clearSizeTable = false;
		 }
		sno++;
		final Object[] data = { new Integer(sno), new Integer(length), new Double(width), new Double(thick), new Double(rft), new Double(cft),
			new Integer(Quantity), new Boolean(false)};


		outLogTable.getModel().addRow(data);

	}
	/**
	 * @return
	 */
	public javax.swing.Box getDisplayPane() {

				tcftFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				tcftFormat.setMaximumFractionDigits(2);
				tcftFormat.setMinimumFractionDigits(2);
				tcftFormat.setNegativePrefix("(");
				tcftFormat.setNegativeSuffix(")");tcftFormat.setGroupingUsed(false);

				tcftAFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				tcftAFormat.setMaximumFractionDigits(2);tcftAFormat.setMinimumFractionDigits(2);
				tcftAFormat.setNegativePrefix("(");
				tcftAFormat.setNegativeSuffix(")");tcftAFormat.setGroupingUsed(false);
				tcftBFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				tcftBFormat.setMaximumFractionDigits(2);tcftBFormat.setMinimumFractionDigits(2);
				tcftBFormat.setNegativePrefix("(");
				tcftBFormat.setNegativeSuffix(")");tcftBFormat.setGroupingUsed(false);
				tcftCFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				tcftCFormat.setMaximumFractionDigits(2);tcftCFormat.setMinimumFractionDigits(2);
				tcftCFormat.setNegativePrefix("(");
				tcftCFormat.setNegativeSuffix(")");tcftCFormat.setGroupingUsed(false);
				tcftDFormat = (DecimalFormat)NumberFormat.getNumberInstance();
				tcftDFormat.setMaximumFractionDigits(2);tcftDFormat.setMinimumFractionDigits(2);
				tcftDFormat.setNegativePrefix("(");
				tcftDFormat.setNegativeSuffix(")");tcftDFormat.setGroupingUsed(false);

		tempField = new DecimalField(0, 4, tcftFormat); // used in converting string to double digit decimel
		
		if(disRootPanel == null) {
					//disRootPanel = new javax.swing.JPanel();
					//disRootPanel.setLayout(new javax.swing.BoxLayout(rootPanel, javax.swing.BoxLayout.Y_AXIS));
					disRootPanel = new Box(BoxLayout.Y_AXIS);
			TablePane = new javax.swing.JPanel(new java.awt.BorderLayout());

                     
					 if(j6Panel == null) {
						j6Panel = new javax.swing.JPanel();
						j6Panel.setMinimumSize(new Dimension(600, 10));
						//j6Panel = new Box(BoxLayout.X_AXIS);
						tsrftField = new DecimalField(tsrft, 4, tcftFormat);
						tscftField = new DecimalField(tscft, 4, tcftFormat);
						tsnumPeriodsField = new WholeNumberField(tsnumPeriods, 3);

						tsrftField.setEditable(false);
						tsrftField.setForeground(Color.red);
						tsrftField.setToolTipText("Total Running Feet");

						tscftField.setEditable(false); tscftField.setForeground(Color.red);
						tscftField.setToolTipText("Total Cubic Feet");
						tsnumPeriodsField.setEditable(false); tsnumPeriodsField.setForeground(Color.red);
						tsnumPeriodsField.setToolTipText("Total Quantity of wood");

						j6Panel.add(new javax.swing.JLabel("TS running Ft"));
						j6Panel.add(tsrftField);
						j6Panel.add(new JLabel("TS Cubic Ft"));
						j6Panel.add(tscftField);
						j6Panel.add(new JLabel("TS Quantity"));
						j6Panel.add(tsnumPeriodsField);
					}
					if(j7Panel == null) {
						j7Panel = new javax.swing.JPanel();

						trftField = new DecimalField(trft, 6, tcftAFormat);trftField.setEditable(false); trftField.setForeground(Color.blue);
						tcftField = new DecimalField(tcft, 6, tcftBFormat); tcftField.setEditable(false);tcftField.setForeground(Color.blue);
						tnumPeriodsField = new WholeNumberField(tnumPeriods, 6); tnumPeriodsField.setEditable(false);tnumPeriodsField.setForeground(Color.blue);
						//tcftD = new DecimalField(tcftpD, 6, tcftDFormat);tcftD.setEditable(false);tcftD.setForeground(Color.blue);

						j7Panel.add(new JLabel("Total RFT:")); j7Panel.add(trftField);
						j7Panel.add(new JLabel("Total CFT:")); j7Panel.add(tcftField);
						j7Panel.add(new JLabel("Total Quantity:")); j7Panel.add(tnumPeriodsField);

					}
										
                // get SizeTable and add
				TablePane.add(getJScrollPane(),BorderLayout.NORTH);
				
                //build FirmTable display & add
				//javax.swing.Box bPane2 = new Box(BoxLayout.Y_AXIS);
				TablePane.add(getFirmTable(),BorderLayout.CENTER );
				if(j8Panel == null) { 
					j8Panel = new javax.swing.JPanel();
					/*j8Panel = new javax.swing.JPanel(new java.awt.BorderLayout());
					
					temp1Panel = new javax.swing.JPanel();
					temp1Panel.add(new JLabel("Firm Details:"));
					tempPanel = new javax.swing.JPanel();*/
					
					// fcft = firm's total CFT
					// tFLnumPeriods = Firm's no.of loads
					
					fcftField = new DecimalField(fcft, 6, tcftBFormat); fcftField.setEditable(false);fcftField.setForeground(Color.red);
					tFLnumPeriodsField = new WholeNumberField(tFLnumPeriods, 4); tFLnumPeriodsField.setEditable(false);tFLnumPeriodsField.setForeground(Color.red);
					/*tempPanel.add(new JLabel("Firm Total No.of Loads:")); 
					tempPanel.add(tFLnumPeriodsField);
					tempPanel.add(new JLabel("Total CFT:")); 
					tempPanel.add(fcftField);
					
					j8Panel.add(temp1Panel, BorderLayout.NORTH);
					j8Panel.add(getFirmTable(),BorderLayout.CENTER );
					j8Panel.add(tempPanel,BorderLayout.SOUTH );*/
					j8Panel.add(new JLabel("Firm Total No.of Loads:")); 
					j8Panel.add(tFLnumPeriodsField);
					j8Panel.add(new JLabel("Total CFT:")); 
					j8Panel.add(fcftField);
				}
				TablePane.add(j8Panel, BorderLayout.SOUTH);
				
				
				disRootPanel.add(TablePane);
				
			    //disRootPanel.add(getFirmTable());
				//disRootPanel.add(j6Panel);
				//disRootPanel.add(j7Panel);
		}

		return disRootPanel;
	}


	public static void addTSRFT(double tc){
				tsrft = tsrft + tc;
				//tcftp = Double.parseDouble(tcft.getText());
				tsrftField.setValue(tsrft);

	}

	         /********************************************************************************************************************************************8
			 * This method jContentPane1 for Configuration of Firm
			 *
			 * @return javax.swing.JPanel
			 */
			private javax.swing.JPanel getJContentPane1() {

				if(jPanelEstate == null) { // Estate fields -> cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
					jPanelEstate = new javax.swing.JPanel(new java.awt.BorderLayout());
					javax.swing.JPanel jPanelLabel = new javax.swing.JPanel(new GridLayout(0, 1));
					javax.swing.JPanel jPanelFiled = new javax.swing.JPanel(new GridLayout(0, 1));

					cfgEstateAddress = new JTextField("<sample address>",15);
					//JTextField EstateName = new JTextField(currentEstateName);
					//EstateName.setEditable(false); EstateName.setForeground(Color.blue);
					//jPanelFiled.add(EstateName);
					//jPanelFiled.add(cfgEstateAddress);
					//jPanelFiled.add(cfgEstateSyNo);jPanelFiled.add(cfgCoupContractor);

					//JLabel estName = new JLabel ("Firm Name:");
					JLabel estAdd = new JLabel ("Firm Address:");
					//jPanelLabel.add(estName);
					//jPanelLabel.add(estAdd);

					//estName.setLabelFor(EstateName);
					estAdd.setLabelFor(cfgEstateAddress);

					jPanelEstate.add(jPanelLabel,BorderLayout.CENTER );
					jPanelEstate.add(jPanelFiled,BorderLayout.EAST );
					jPanelEstate.add(getFieldPane(), BorderLayout.NORTH); // load parameters

				}
				if(jContentPane1dif == null) {
					jContentPane1dif = new javax.swing.JPanel();
					jContentPane1dif.setLayout(new java.awt.BorderLayout());
					jContentPane1dif.add(getJPanel2(), BorderLayout.CENTER); // rate & class labels
					jContentPane1dif.add(jPanel1, BorderLayout.EAST); //rate & class fields
					jContentPane1dif.add(getJPanel1(), BorderLayout.SOUTH); // buttons
				}

				if(jContentPane1 == null) {
					jContentPane1 = new javax.swing.JPanel();
					jContentPane1.add(jPanelEstate); // estate fields
					jContentPane1.add(jContentPane1dif); // classification fields
				}

				return jContentPane1;
			}
			/**
			 * This method initializes jDialog
			 *
			 * @return javax.swing.JDialog
			 */
			public javax.swing.JDialog getJDialog(JFrame f) {
				if(jDialog == null) {
					jDialog = new javax.swing.JDialog(f, "Firm Configure ..", true);
					//retriveConfig();
				configSaved = false; // make dirty for next write
				jDialog.setContentPane(getJContentPane1());
				jDialog.addWindowListener(new WindowAdapter() {
								public void windowClosing(WindowEvent we) {
								   /*if (!configSaved){
									Object[] options = {"Yes","No", "Cancel"};
									int n = JOptionPane.showOptionDialog(null,"Would you like to save data?", "Config exit",
												JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,     //don't use a custom Icon
												options,  //the titles of buttons
												options[0]); //default button title

									if (n == 0) {
										saveConfig();
										configSaved = false;
									}
									configSaved = false;
								   }*/

							}
						});
				}
				return jDialog;
			}
			/**
			 * This method initializes Estate configuration
			 * and writes to XML file.
			 * @return javax.swing.JPanel
			 */
			private javax.swing.JPanel getJPanel2() {
				if(jPanel == null) {
					jPanel = new javax.swing.JPanel(new GridLayout(0, 1));
					JLabel rateALabel = new JLabel("<html><Font Color=green> Planks</Font></html>"); // for rate of each class
					JLabel rateBLabel = new JLabel("<html><Font Color=green> Battons</Font></html>");
					JLabel rateCLabel = new JLabel("<html><Font Color=green> Runners</Font></html>");
					JLabel rateDLabel = new JLabel("<html><Font Color=green> SLR</Font></html>");
					JLabel rateELabel = new JLabel("<html><Font Color=green> Lapha</Font></html>");



					JLabel classALabel = new JLabel("<html><Font Color=green> Planks </Font></html>");
					JLabel classBLabel = new JLabel("<html><Font Color=green> Battons </Font></html>");
					JLabel classCLabel = new JLabel("<html><Font Color=green> Runners </Font></html>");
					JLabel classDLabel = new JLabel("<html><Font Color=green> SLR</Font></html>");
					JLabel classELabel = new JLabel("<html><Font Color=green> Lapha</Font></html>");




					jPanel.add(new JLabel("  "));jPanel.add(new JLabel("<html><Font Color=red><b>Timber Rate:</b></Font></html>"));
					jPanel.add(rateALabel);jPanel.add(rateBLabel);jPanel.add(rateCLabel);jPanel.add(rateDLabel);jPanel.add(rateELabel);
					jPanel.add(new JLabel("  "));jPanel.add(new JLabel("<html><Font Color=red><b>Classification:</b></Font></html>"));
					jPanel.add(classALabel);jPanel.add(classBLabel);jPanel.add(classCLabel);jPanel.add(classDLabel);
					jPanel.add(classELabel);


					if(jPanel1 == null) {
						jPanel1 = new javax.swing.JPanel(new GridLayout(0, 1));}
					cfgRateAField = new DecimalField(rateA, 6, paymentFormat);
					cfgRateBField = new DecimalField(rateB, 6, paymentFormat);
					cfgRateCField = new DecimalField(rateC, 6, paymentFormat);
					cfgRateDField = new DecimalField(rateD, 6, paymentFormat);
					cfgRateEField = new DecimalField(rateD, 6, paymentFormat);
					cfgClassAField = new JTextField("L>=6, W>=6, T=1.5");
					cfgClassBField = new JTextField("L>=6, W<=6, T=1.5");
					cfgClassCField = new JTextField("L>=6, W<6, T!=1.5");
					cfgClassDField = new JTextField("L<6, W<6, T!=1.5");
					cfgClassEField = new JTextField("L<6, W<6, T=1.5");

					jPanel1.add(new JLabel("  "));jPanel1.add(new JLabel("  "));
					jPanel1.add(cfgRateAField);jPanel1.add(cfgRateBField);jPanel1.add(cfgRateCField);jPanel1.add(cfgRateDField);jPanel1.add(cfgRateEField);
					jPanel1.add(new JLabel("    "));
					jPanel1.add(cfgClassAField);jPanel1.add(cfgClassBField);jPanel1.add(cfgClassCField);jPanel1.add(cfgClassDField);
					jPanel1.add(cfgClassEField);

					// allign fields
					rateALabel.setLabelFor(cfgRateAField);classALabel.setLabelFor(cfgClassAField);
					rateBLabel.setLabelFor(cfgRateBField);classBLabel.setLabelFor(cfgClassBField);
					rateCLabel.setLabelFor(cfgRateCField);classCLabel.setLabelFor(cfgClassCField);
					rateDLabel.setLabelFor(cfgRateDField);classDLabel.setLabelFor(cfgClassDField);
					classELabel.setLabelFor(cfgClassEField);

					configSaved = false;

					// currently disable all fields
					cfgRateAField.setEditable(false);cfgRateBField.setEditable(false);cfgRateCField.setEditable(false);cfgRateDField.setEditable(false);cfgRateEField.setEditable(false);
					cfgClassAField.setEditable(false);cfgClassBField.setEditable(false);cfgClassCField.setEditable(false);cfgClassDField.setEditable(false);cfgClassEField.setEditable(false);

				}
				return jPanel;
			}
			/**
			 * This method initializes jPanel1
			 *
			 * @return javax.swing.JPanel
			 */
			private javax.swing.JPanel getJPanel1() {
				if(jButtonPanel == null) {
					jButtonPanel = new javax.swing.JPanel();
					JButton ok =  new JButton("Done");
					ok.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								//Save config
								//saveConfig(); // not used in current version
								jDialog.dispose();
							}
					} );
					JButton cancel = new JButton("Cancel");
					cancel.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												//close window.
												jDialog.dispose();
											}
									} );
					jButtonPanel.add (ok);
					jButtonPanel.add (cancel );
				}
				return jButtonPanel;
			}
	private void saveConfig (){
				rateA = cfgRateAField.getValue();
				rateB = cfgRateBField.getValue();
				rateC = cfgRateCField.getValue();
				rateD = cfgRateDField.getValue();

			/*
				classAlimit = new Integer(cfgClassAField.getText()).intValue();
				classBlimit = new Integer(cfgClassBField.getText()).intValue();
				classClimit = new Integer(cfgClassCField.getText()).intValue();
				classDlimit = new Integer(cfgClassDField.getText()).intValue();
				classElimit = new Integer(cfgClassEField.getText()).intValue();

				//other fields are saved to XML file @ estate/date/<currentEstateName>.xml by "save Estate" button
				////cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
				EA = cfgEstateAddress.getText();
				ES = cfgEstateSyNo.getText();
				EC = cfgCoupContractor.getText();
				//rest (class & rate)  to txt file @ estate/config/<currentEstateName>.xml
				try {
					PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("firm\\config\\"+currentEstateName, false)));
					out.print(" ");out.print(rateA);out.print(" ");out.print(rateB);out.print(" ");
					out.print(rateC);out.print(" ");out.print(rateD);out.print(" ");
					out.print(classAlimit);out.print(" ");out.print(classBlimit);out.print(" ");
					out.print(classClimit);out.print(" ");out.print(classDlimit);out.print(" ");
					out.print(classDLlimit);out.print(" ");
					out.print("\n");
					out.flush();
					out.close();
					configSaved = true;
				} catch (IOException e) {

					e.printStackTrace();
				} */
			 }
		private void retriveConfig (){
				String fn = "firm\\data\\" + currentEstateName;
			 if ((new File("firm\\config\\" + currentEstateName)).exists()){

				LineNumberReader in;
				try {
					 in = new LineNumberReader( new FileReader("firm\\config\\" + currentEstateName));
					 String newLine = in.readLine();
					 while (newLine != null){
						//System.out.println("reTriving the config data");
					   StringTokenizer st = new StringTokenizer(newLine," ");
					   if (st.hasMoreTokens()) rateA = new Double(st.nextToken()).doubleValue();
				   if (st.hasMoreTokens()) rateB = new Double(st.nextToken()).doubleValue();
				   if (st.hasMoreTokens()) rateC = new Double(st.nextToken()).doubleValue();
				   if (st.hasMoreTokens()) rateD = new Double(st.nextToken()).doubleValue();
					   if (st.hasMoreTokens()) classAlimit = new Integer(st.nextToken()).intValue();
					   if (st.hasMoreTokens()) classBlimit = new Integer(st.nextToken()).intValue();
					   if (st.hasMoreTokens()) classClimit = new Integer(st.nextToken()).intValue();
					   if (st.hasMoreTokens()) classDlimit = new Integer(st.nextToken()).intValue();
					   if (st.hasMoreTokens()) classElimit = new Integer(st.nextToken()).intValue();

					   newLine = in.readLine();
					}
					in.close();
				} catch (Exception e) {

					e.printStackTrace();
				}
				 // read others from from XML file @ esate/data/<CESN>

				EstateFileSupport sample = new EstateFileSupport();
				if ( (new File(fn+".xml")).exists()){
					sample.loadExistingInstance(fn+".xml");
					EA = sample.iIncoming.getEstate().getPlantAddress();
					ES = sample.iIncoming.getEstate().getSyNo();
					EC = sample.iIncoming.getEstate().getCoupContractor();
				}
			 }

		}
		/**
		 *
		 */
		protected void storeData(String fn) {
			// Trigger from ConvertLobs
			outLogTable.store2File(fn, currentEstateName, currentEstateLoad, loadDateField.getText(), firmTable, addressField.getText(), this.orderNumField.getText(), this.articlesField.getText() );
			//call retrive & store FirmTable xml file methods.
			firmTable.store2File(currentEstateName, currentEstateLoad, addressField.getText());
		}
		   /*******************************************************************************************************************************************/
}  //  @jve:visual-info  decl-index=0 visual-constraint="50,14"

