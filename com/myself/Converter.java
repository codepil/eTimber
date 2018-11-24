/*
 * Created on Mar 29, 2006
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
public class Converter extends JFrame {

	private boolean configSaved = false;
	public static JTextField DCField, stumpsField; // Load fields
	public static JTextField tapeField;
	public static JTextField loadClerkField;
	public static JTextField loadDateField;
	public String[] estatelist, estatelist1;
		public String currentEstateName, currentEstateLoad = null;
		public boolean loadenable=true;
	    public javax.swing.JComboBox jComboBox = null;
		private javax.swing.JComboBox jComboBox1 = null;

	    private String CfileName;

//	Values for the text fields
	  private int amount = 10; int amount1= 0;
	  private double rate = 4.6; int rate1=0;
	  private int numPeriods = 1;
	  private double payment = 0.0;
	  private int lengthIn=0, breadthFt=4, breadthIn=6;
		  private int lengthFt=10;

	  //Labels to identify the text fields
	  private JLabel amountLabel, amountLabel1;
	  private JLabel rateLabel, rateLabel1;
	  private JLabel numPeriodsLabel;
	  private JLabel paymentLabel,dummyLabel,compLabel,inLabel,ftLabel;

	  private javax.swing.JRadioButton jRadioButton = null;
	  private javax.swing.JRadioButton jRadioButton1 = null;
	  private javax.swing.JRadioButton jRadioButton2 = null;
	  private javax.swing.JRadioButton jRadioButton3 = null;



	  //Strings for the labels
	  private static String amountString = "Length: ";
	  private static String rateString = "     Girth: ";
	  private static String numPeriodsString = "   Quantity: ";
	  private static String paymentString = "Cubic Feet  ";
	  private static String cal = "Calculate";


	  
	  public WholeNumberField amountField;
	  private DecimalField rateField ;
	  private WholeNumberField amountField1 ;
	  private WholeNumberField rateField1;
	  private WholeNumberField numPeriodsField;
	  private DecimalField paymentField; private DecimalField timberAmtField;

	  private JButton calculateButton;
	  private JButton calAddButton, clearButton;

	  //Formats to format and parse numbers
	  private NumberFormat moneyFormat;
	  private NumberFormat percentFormat;
	  private DecimalFormat paymentFormat;
	  
	private javax.swing.JDialog jDialog = null;  //  @jve:visual-info  decl-index=0 visual-constraint="429,99"
	private javax.swing.JPanel jContentPane1 = null, jContentPane1dif = null;
	private javax.swing.JPanel jPanel = null;  //  @jve:visual-info  decl-index=0 visual-constraint="1058,505"
	private javax.swing.JPanel jPanel1 = null;  //  @jve:visual-info  decl-index=0 visual-constraint="984,507"
	private javax.swing.JPanel jButtonPanel = null;
	private javax.swing.JPanel jPanelEstate = null;
	//Estate configuration, stored in estate/config/<name>.xml
	private DecimalField cfgRateAField, cfgRateBField, cfgRateCField,cfgRateDField;
	private WholeNumberField cfgClassAField, cfgClassBField, cfgClassCField, cfgClassDField;
	private WholeNumberField cfgLClassDField;
	private WholeNumberField cfgEstDiscountField;
	public JTextField cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
	public static String EA, EC, ES;
	public static double rateA = 0, rateB = 0, rateC = 0, rateD = 0;
	public static int classAlimit = 36, classBlimit = 24, classClimit = 18, classDlimit = 0, classDLlimit = 5;
	public static int estDiscount = 10;
	

	  public boolean focusIsSet = false, pieceFlag = false, logsFlag=false;


	  public Converter() {
		  super("Converter");
	  }
	  // for display of core convertion fields
	  public javax.swing.JPanel getConvertPanel() {		initialize();

		  setUpFormats();

		  payment = computePayment(lengthFt, breadthFt, numPeriods, lengthIn, breadthIn);
		  ImageIcon icon1 = new ImageIcon("images/convert.gif", "Convert CFT");
		 



		  //Create the labels.
		  amountLabel = new JLabel(amountString);
		  amountLabel.setText("<html><Font Color=green>" + amountString + "</Font> &#180 <Font Color=black> Feet</font></html>");
		  amountLabel1 = new JLabel("<html><Font Color=black>&#168 In</font></html>");

		  rateLabel = new JLabel(rateString);
		  rateLabel.setText("<html><Font Color=green>" + rateString + "</Font> &#180 <Font Color=black> Feet</font></html>");
		  rateLabel1 = new JLabel("<html><Font Color=black>&#168 In</font></html>");

		  numPeriodsLabel = new JLabel(numPeriodsString);
		  numPeriodsLabel.setText("<html><Font Color=green>" + numPeriodsString + "</Font> &#35 <Font Color=black> </font></html>");
		  paymentLabel = new JLabel(paymentString);
		  paymentLabel.setText("<html><Font Color=red>" + paymentString + "</Font> &#61 <Font Color=black> </font></html>");

		  //calculateButton = new JButton(icon1);
		  //calculateButton.setSize(50,15);
		  calculateButton = new JButton(cal);
		  calculateButton.setToolTipText("Convert to CFT");
		  calculateButton.setMnemonic(KeyEvent.VK_C);
		  calAddButton = new JButton("ADD to Load -->");
		  calAddButton.setMnemonic(KeyEvent.VK_ENTER);
		  calAddButton.setToolTipText("Add converted CFT to sheet");
		  clearButton = new JButton ("Clear"); clearButton.setToolTipText("Clear the Data"); clearButton.setMnemonic(KeyEvent.VK_O);


		  dummyLabel = new JLabel();
		  ftLabel = new JLabel("Ft"); inLabel = new JLabel("In");


       //Create the text fields and set them up.
        MyDocumentListener myDocumentListener = new MyDocumentListener();

        //amountField = new DecimalField(amount, 6, moneyFormat);
        amountField = new WholeNumberField(amount, 6);
        amountField.getDocument().addDocumentListener(myDocumentListener);
        amountField.getDocument().putProperty("name", "amount");
		amountField.setCaretPosition(0);
        amountField1 = new WholeNumberField(amount1, 2);
        amountField1.getDocument().addDocumentListener(myDocumentListener);
        amountField1.getDocument().putProperty("name", "amount1");


        rateField = new DecimalField(rate, 6, moneyFormat);
        //rateField = new WholeNumberField(rate, 6);
        rateField.getDocument().addDocumentListener(myDocumentListener);
        rateField.getDocument().putProperty("name", "rate");
        //rateField.setCaretPosition(0);
        rateField1 = new WholeNumberField(rate1, 2);
		rateField1.getDocument().addDocumentListener(myDocumentListener);
        rateField1.getDocument().putProperty("name", "rate1");

        numPeriodsField = new WholeNumberField(numPeriods, 6);
        numPeriodsField.getDocument().addDocumentListener(myDocumentListener);
        numPeriodsField.getDocument().putProperty("name", "numPeriods");
		//numPeriodsField.setCaretPosition(0);

        paymentField = new DecimalField(payment, 6, paymentFormat);
        paymentField.setEditable(false);
        paymentField.setForeground(Color.red);



		  //Tell accessibility tools about label/textfield pairs.
		  amountLabel.setLabelFor(amountField);
		  amountField.setToolTipText("Enter Length in feet, Ex: 10.2 for 10 Feet 2 Inches");
		  rateLabel.setLabelFor(rateField);
		  rateField.setToolTipText("Enter Breadth in feet, Ex: 4.6 for 4 Feet 6 Inches");
		  numPeriodsLabel.setLabelFor(numPeriodsField);
		  numPeriodsField.setToolTipText("Enter number of Logs");
		  paymentLabel.setLabelFor(paymentField);
		  paymentField.setToolTipText("Converted Log size in Cubic Feet");

		  //Layout the labels in a panel.
		  JPanel labelPane = new JPanel();
		  labelPane.setLayout(new GridLayout(0, 1));
		  labelPane.add(amountLabel);
		  labelPane.add(rateLabel);
		  labelPane.add(numPeriodsLabel);
		  labelPane.add(paymentLabel);


		  //Layout the text fields in a panel.
		  JPanel fieldPane = new JPanel();
		  fieldPane.setLayout(new GridLayout(0, 1));
		  fieldPane.add(amountField);
		  fieldPane.add(rateField);
		  fieldPane.add(numPeriodsField);
		  fieldPane.add(paymentField);




		  //Convert & add
		  JPanel field2Pane = new JPanel();
		  //field2Pane.setLayout(new GridLayout(0, 1));
		  //calculateButton.setSize(10,10);
		  //calAddButton.setSize(10,10);
		  //field2Pane.add(calculateButton);
		  field2Pane.add(clearButton);
		  field2Pane.add(calAddButton);

		  //field2Pane.add(new JLabel("<html><body><table border=\"1\"><tr><td>row 1, cell 1</td><td>row 1, cell 2</td></tr><tr><td>row 2, cell 1</td><td>row 2, cell 2</td></tr></table><img src=\"images/convert.gif\"></body></html>"));

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
			rateField.requestFocus();
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
				numPeriodsField.requestFocus();
			}
        });

          calculateButton.addActionListener(new ActionListener() {
		  		            public void actionPerformed(ActionEvent e) {
		  		                //if (e.getActionCommand().equals(cal)) {
		  						//System.out.println("key pressed ="+ e.getActionCommand() );
		  						calculate(e);
							    //}
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
				  numPeriodsField.setText("");
				  paymentField.setValue(0);
						   //get focus to Length
				  amountField.requestFocus();
			}
          });

		  return contentPane;
	  }

	  public javax.swing.JPanel getFieldPane(){

		JPanel selectPane = new JPanel();
					selectPane.setLayout(new BorderLayout());

		JLabel patternLabel1 = new JLabel("Estate Name:");
		JLabel patternLabel2 = new JLabel("Load Name  :");
		
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
		el.setToolTipText("Select <EstateName> if already exists from the list, or if the entry is new then type the name of Estate ");
		patternLabel2.setLabelFor(ll);
		ll.setToolTipText("Select <LoadName> if already exists from the list, or if the entry is new then type the name to identify the load ");

		labelPane.add(patternLabel1);fieldPane.add(el, null);
		labelPane.add(patternLabel2);fieldPane.add(ll, null);
		
		loadDateField = new JTextField ((new SimpleDateFormat("d MMM yyyy")).format(new Date()));
		labelPane.add(new JLabel("Date:"));fieldPane.add(loadDateField);
		
		loadClerkField = new JTextField("<Unload Place>");
		labelPane.add(new JLabel("Unload Place"));fieldPane.add(loadClerkField);
		
		tapeField = new JTextField("<Clerk Name(s)>");
		labelPane.add(new JLabel("Tape Clerk"));fieldPane.add(tapeField);
		
		DCField = new JTextField("<DN#>");
		labelPane.add(new JLabel("Del Note:"));fieldPane.add(DCField);
		
		stumpsField = new JTextField("<no of trees>");
		labelPane.add(new JLabel("Stumps:"));fieldPane.add(stumpsField);
		
		
		northPane.add(new JLabel("   "));
		
		selectPane.add(labelPane,BorderLayout.WEST);
		selectPane.add(fieldPane,BorderLayout.CENTER);
		selectPane.add(northPane,BorderLayout.SOUTH);
		
		loadDateField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadClerkField.requestFocus();
						loadClerkField.setText("");
						//loadDateField.setEnabled(false);
						//loadDateField.setBackground(Color.LIGHT_GRAY);
					}
				});
		loadClerkField.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								tapeField.requestFocus();
								tapeField.setText("");
								//loadClerkField.setBackground(Color.LIGHT_GRAY);
							}
				});
		tapeField.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										DCField.requestFocus();
										DCField.setText("");
										//tapeField.setBackground(Color.LIGHT_GRAY);
									}
				});
		DCField.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												stumpsField.requestFocus();
												stumpsField.setText("");
												
												//DCField.setBackground(Color.LIGHT_GRAY);
											}
		});
		stumpsField.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														cfgEstateAddress.requestFocus();
														
														//stumpsField.setBackground(Color.LIGHT_GRAY);
							                        }
				});

	  	return selectPane;

	  }



      private void calculate(ActionEvent e) {

		  //System.out.println("key pressed ="+ e.getActionCommand() );

		  payment = computePayment(lengthFt, breadthFt, numPeriodsField.getValue(),
		                           lengthIn, breadthIn);
		  paymentField.setValue(payment);
		  amountField.requestFocus();

	  }
	  private void calculateAdd(ActionEvent e) {
	  		  double tcft = 0.0; boolean showFlag=false;
	  		  String wclass = null;
	  		  double rateclass = 0, amt=0;


	  	tcft = paymentField.getValue();
	  		//System.out.println("Breadth = " + rateField.getText());
	  	timberAmtField  = new DecimalField(amt, 6, paymentFormat);
	  	//System.out.println("["+amount+"."+amount1+","+ rate+"."+rate1+"] = " + getValuetcft );

	  	if ((amount == 0 || rate ==0 )) {
	  		javax.swing.JOptionPane.showMessageDialog(null, "Log Length/Girth can't be zero", "Add alert", javax.swing.JOptionPane.ERROR_MESSAGE);
			amountField.requestFocus();
	  		//showFlag = true;
	  		return; }

            if (lengthFt <= classDLlimit) { // if length is less than 6 ft then its a class D irespective of girth.
				wclass = "D";rateclass = rateD; ConvertLobs.addTCFTD(tcft);
				timberAmtField.setValue(rateclass*tcft);
				ConvertLobs.addToTable(amount, rateField.getText(), " ", " ", " ", paymentField.getText(), wclass ,rateclass ,numPeriods, timberAmtField.getText(), paymentField.getText());
            }
            else {
            
	  		  if ((breadthFt*12+breadthIn)>=classAlimit) { wclass = "A"; rateclass = rateA; ConvertLobs.addTCFTA(tcft);
	  		     timberAmtField.setValue(rateclass*tcft);
				ConvertLobs.addToTable(amount, rateField.getText(), paymentField.getText(), " ", " ", " ", wclass ,rateclass ,numPeriods, timberAmtField.getText(), paymentField.getText());
				 }
	  		  else if ((breadthFt*12+breadthIn)>=classBlimit) {wclass = "B"; rateclass = rateB;ConvertLobs.addTCFTB(tcft);
	  		    timberAmtField.setValue(rateclass*tcft);
				ConvertLobs.addToTable(amount, rateField.getText(), " ", paymentField.getText(), " ", " ", wclass ,rateclass ,numPeriods, timberAmtField.getText(), paymentField.getText());
				}
	  		       else if ((breadthFt*12+breadthIn)>=classClimit) {wclass = "C";rateclass = rateC; ConvertLobs.addTCFTC(tcft);
	  		           timberAmtField.setValue(rateclass*tcft);
					   ConvertLobs.addToTable(amount, rateField.getText(), " ", " ", paymentField.getText(), " ", wclass ,rateclass ,numPeriods, timberAmtField.getText(), paymentField.getText());
					   }
		                else {wclass = "D";rateclass = rateD; ConvertLobs.addTCFTD(tcft);
		                    timberAmtField.setValue(rateclass*tcft);
							ConvertLobs.addToTable(amount, rateField.getText(), " ", " ", " ", paymentField.getText(), wclass ,rateclass ,numPeriods, timberAmtField.getText(), paymentField.getText());
							}
            }

	  		  // reset fields;
		      amountField.setText("");
		      rateField.setText("");
		      paymentField.setValue(0);
		      //amountField.setCaretPosition(0);
		      amountField.requestFocus();


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

				StringTokenizer st = new StringTokenizer(Double.toString(amount),".");
				if (st.hasMoreTokens()) lengthFt= (new Integer(st.nextToken())).intValue();
				if (st.hasMoreTokens()) lengthIn= (new Integer(st.nextToken())).intValue();
				else lengthIn = (new Integer(0)).intValue();
			 }

			  else if (whatsup.getProperty("name").equals("rate")){
				rate = rateField.getValue();
				StringTokenizer st = new StringTokenizer(rateField.getText(),".");
								if (st.hasMoreTokens()) breadthFt= (new Integer(st.nextToken())).intValue();
								if (st.hasMoreTokens()) breadthIn= (new Integer(st.nextToken())).intValue();
								else breadthIn = (new Integer(0)).intValue();
			  }


			  else if (whatsup.getProperty("name").equals("numPeriods"))
				  numPeriods = numPeriodsField.getValue();
			  else if (whatsup.getProperty("name").equals("amount1"))
				  amount1 = amountField1.getValue();
			  else if (whatsup.getProperty("name").equals("rate1"))
				  rate1 = rateField1.getValue();

			  //System.out.println("Before compute:"+lengthFt+"* ("+breadthFt+"."+breadthIn+" ");
			  payment = computePayment(lengthFt, breadthFt, numPeriods, lengthIn, breadthIn);

			  paymentField.setValue(payment);

			  StringTokenizer st = new StringTokenizer(Double.toString(rate),".");
			  //System.out.println("String value ="+Double.toString(rate));
							 //while (st.hasMoreTokens()) {
								 //System.out.println("token ="+ st.nextToken());
							 //}
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
		final Converter demo = new Converter();
		JPanel cp = demo.getConvertPanel();
		demo.setContentPane(cp);

		  demo.addWindowListener(

		   new WindowListener() {
			  public void windowClosing(WindowEvent e) {
				  System.exit(0);
			  }

			  //Whenever window gets the focus, let the
			  //Converter set the initial focus.
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
	  double computePayment(int lengthFt, int BreadthFt, int Quantity, int lin, int bin) {
		int lengthIn=0;int breadthIn=0; int denominator=0; int ft2in=0; double answerCFT=0;
		  denominator = 16;
		  ft2in=12*12*12;

		  lengthIn = (lengthFt * 12) + lin;
		  breadthIn = (BreadthFt * 12) + bin;

		  //answerCFT = (lengthIn * breadthIn * breadthIn * Quantity)/(denominator*ft2in);
		  answerCFT = ((lengthFt * breadthIn * breadthIn)/2304.0) * Quantity;
		  //System.out.println("compute:"+lengthFt+"* ("+breadthIn+"="+BreadthFt+"."+bin+"), " +Quantity+ ", "+answerCFT );
		  return answerCFT;
	  }

	/**
		 * This method initializes jComboBox
		 *
		 * @return javax.swing.JComboBox
		 */
		private javax.swing.JComboBox getEstateList() {
			if(jComboBox == null) {
				File dir = new File("icdata");

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
									
									//System.out.println("Estate list:"+i+" "+estatelist1[i]);
									if (estatelist1[i].endsWith(currentEstateName)&& flag == false) { flag=true; 
										System.out.println("Estate already exits, loading the "+currentEstateName+" details..");
										EstateTable.retrive4File(currentEstateName);
										updateConfig(currentEstateName);
										break;
										}
								  }
								}
								// Create new dir by estate name not already exits
								String dn = new String("icdata\\"+currentEstateName);
								if (!flag) { if(!(new File(dn)).mkdir()) System.out.println("New Estate creation:"+dn);
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

				String dn = new String("icdata\\SampleEstateName");
				File dir = new File(dn);

				estatelist = dir.list();
				jComboBox1 = new javax.swing.JComboBox(estatelist);
				jComboBox1.setSize(new Dimension(10,4));
				jComboBox1.setEditable(true);jComboBox1.setEnabled(false); // disable initially
				jComboBox1.setAlignmentX(Component.LEFT_ALIGNMENT);
				jComboBox1.addActionListener(new ActionListener() {
							 boolean flag=false;

					public void actionPerformed(ActionEvent e) {
						if (loadenable){  // enable code path only thr' estate combo action item

						JComboBox cb = (JComboBox)e.getSource();
						String newSelection = (String)cb.getSelectedItem();
						currentEstateLoad = newSelection;
						CfileName = new String("icdata\\"+currentEstateName+"\\"+currentEstateLoad);

								if (estatelist == null) {
								// Either dir does not exist or is not a directory
								} else {
								  for (int i=0; i<estatelist.length; i++) {
									// Get filename of file or directory
									if (estatelist[i].endsWith(currentEstateLoad)) {
										flag=true; System.out.println("load details already exits, "+currentEstateLoad+" loading them now..");
										TableDisplay.retrive4File(CfileName);
										EstateTable.retrive4load(currentEstateName,currentEstateLoad);
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
						loadDateField.requestFocus();
						
						} // end of load enable if loop
						}
						});
			}
			return jComboBox1;
		}

	  // Create and set up number formats. These objects also
	  // parse numbers input by user.
	  private void setUpFormats() {
		  moneyFormat = NumberFormat.getNumberInstance();
		  //XXXX: Workaround. With an empty positive suffix
		  //the format allows letters in the number.
		  ((DecimalFormat)moneyFormat).setPositiveSuffix(" ");
		  moneyFormat.setGroupingUsed(false);
		  

		  percentFormat = NumberFormat.getNumberInstance();
		  percentFormat.setMinimumFractionDigits(3);
		  //XXXX: Workaround. With an empty positive suffix
		  //the format allows letters in the number.
		  ((DecimalFormat)percentFormat).setPositiveSuffix(" ");

		  paymentFormat = (DecimalFormat)NumberFormat.getNumberInstance();
		  paymentFormat.setMaximumFractionDigits(2);
		  paymentFormat.setMinimumFractionDigits(2);
		  paymentFormat.setNegativePrefix("(");
		  paymentFormat.setNegativeSuffix(")");
		  paymentFormat.setGroupingUsed(false);

	  }
	/**
		 * This method initializes jContentPane1
		 * 
		 * @return javax.swing.JPanel
		 */
		private javax.swing.JPanel getJContentPane1() {
			
			if(jPanelEstate == null) { // Estate fields -> cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
				jPanelEstate = new javax.swing.JPanel(new java.awt.BorderLayout());
				javax.swing.JPanel jPanelLabel = new javax.swing.JPanel(new GridLayout(0, 1));
				javax.swing.JPanel jPanelFiled = new javax.swing.JPanel(new GridLayout(0, 1));
				//EA = "<sample address>"; ES = "<Survey#>"; EC = "<Contractor Name>";
				cfgEstateAddress = new JTextField(EA,15);
				cfgEstateSyNo = new JTextField(ES);
				cfgCoupContractor = new JTextField(EC);
				JTextField EstateName = new JTextField(currentEstateName);
				EstateName.setEditable(false); EstateName.setForeground(Color.blue);
				//jPanelFiled.add(EstateName);
				jPanelFiled.add(cfgEstateAddress);jPanelFiled.add(cfgEstateSyNo);jPanelFiled.add(cfgCoupContractor);
				
				JLabel estName = new JLabel ("Estate/Planter Name:");
				JLabel estAdd = new JLabel ("Estate/Planter Address:");
				JLabel estsyno = new JLabel ("Survey Number:");
				JLabel estCC = new JLabel ("Coup Contractor Name:");
				//jPanelLabel.add(estName);
				jPanelLabel.add(estAdd);jPanelLabel.add(estsyno);jPanelLabel.add(estCC);
				
				//estName.setLabelFor(EstateName);
				estAdd.setLabelFor(cfgEstateAddress);
				estsyno.setLabelFor(cfgEstateSyNo);
				estCC.setLabelFor(cfgCoupContractor);
				
				jPanelEstate.add(jPanelLabel,BorderLayout.CENTER ); 
				jPanelEstate.add(jPanelFiled,BorderLayout.EAST );
				jPanelEstate.add(getFieldPane(), BorderLayout.NORTH); // load parameters
						
			}
			if(jContentPane1dif == null) {
							jContentPane1dif = new javax.swing.JPanel();
							jContentPane1dif.setLayout(new java.awt.BorderLayout());
							jContentPane1dif.add(getJPanel2(), BorderLayout.CENTER); // labels
							jContentPane1dif.add(jPanel1, BorderLayout.EAST); //rate & class
							//jContentPane1dif.add(jPanelEstate, BorderLayout.WEST);// estate details
							jContentPane1dif.add(getJPanel1(), BorderLayout.SOUTH); // buttons
						}
						
			if(jContentPane1 == null) {
				jContentPane1 = new javax.swing.JPanel();
				//jContentPane1.setLayout(new java.awt.BorderLayout());
				jContentPane1.add(jPanelEstate);
				jContentPane1.add(jContentPane1dif);
			}
			
		cfgEstateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cfgEstateSyNo.requestFocus();
			}
		});
		cfgEstateSyNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cfgCoupContractor.requestFocus();
			}
		});
		cfgCoupContractor.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				amountField.requestFocus();
				amountField.setText("");
				rateField.setText("");
			}
		});
			
			return jContentPane1;
		}
		/**
		 * This method initializes jDialog
		 * 
		 * @return javax.swing.JDialog
		 */
		public javax.swing.JDialog getJDialog(JFrame f) {
			if(jDialog == null) {
				jDialog = new javax.swing.JDialog(f, "Configure ..", true);
				retriveConfig(currentEstateName);
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
				JLabel rateALabel = new JLabel("<html><Font Color=green> Rate for Class A</Font> &#64 <Font Color=black>Rs</font></html>"); // for rate of each class
				JLabel rateBLabel = new JLabel("<html><Font Color=green> Rate for Class B</Font> &#64 <Font Color=black>Rs</font></html>");
				JLabel rateCLabel = new JLabel("<html><Font Color=green> Rate for Class C</Font> &#64 <Font Color=black>Rs</font></html>");
				JLabel rateDLabel = new JLabel("<html><Font Color=green> Rate for Class D</Font> &#64 <Font Color=black>Rs</font></html>");
				
				JLabel LclassDLabel = new JLabel("<html><Font Color=green> Class D</Font><Font Color=black>Length in Feet &#60&#61</font></html>"); // below 6 feet
					  
				JLabel classALabel = new JLabel("<html><Font Color=green> Class A </Font><Font Color=black>Girth (Inches) &#62&#61</font></html>"); // above 36 Inches
				JLabel classBLabel = new JLabel("<html><Font Color=green> Class B </Font><Font Color=black>Girth (Inches) &#62&#61</font></html>");
				JLabel classCLabel = new JLabel("<html><Font Color=green> Class C </Font><Font Color=black>Girth (Inches) &#62&#61</font></html>");
				JLabel classDLabel = new JLabel("<html><Font Color=green> Class D </Font><Font Color=black>Girth (Inches) &#62&#61</font></html>");
					  
				JLabel estateDiscountLabel = new JLabel("<html><Font Color=green> Estate discount </Font><Font Color=black> &#37</font></html>");
				
				
				
				jPanel.add(new JLabel("  "));jPanel.add(new JLabel("<html><Font Color=red><b>Rate for Timber:</b></font></html>"));
				jPanel.add(rateALabel);jPanel.add(rateBLabel);jPanel.add(rateCLabel);jPanel.add(rateDLabel);
				jPanel.add(new JLabel("  "));jPanel.add(new JLabel("<html><Font Color=red><b>Classification:</b></font></html>"));
				jPanel.add(classALabel);jPanel.add(classBLabel);jPanel.add(classCLabel);jPanel.add(classDLabel);
				jPanel.add(LclassDLabel);
				jPanel.add(new JLabel("  "));jPanel.add(estateDiscountLabel);
				

				if(jPanel1 == null) {jPanel1 = new javax.swing.JPanel(new GridLayout(0, 1));}
				cfgRateAField = new DecimalField(rateA, 6, paymentFormat);
				cfgRateBField = new DecimalField(rateB, 6, paymentFormat);
				cfgRateCField = new DecimalField(rateC, 6, paymentFormat);
				cfgRateDField = new DecimalField(rateD, 6, paymentFormat);
				cfgClassAField = new WholeNumberField(classAlimit, 6);	
				cfgClassBField = new WholeNumberField(classBlimit, 6);	
				cfgClassCField = new WholeNumberField(classClimit, 6);	
				cfgClassDField = new WholeNumberField(classDlimit, 6);
				cfgLClassDField = new WholeNumberField(classDLlimit, 6);
				
				cfgEstDiscountField = new WholeNumberField(estDiscount, 6);
				
				jPanel1.add(new JLabel("  "));jPanel1.add(new JLabel("  "));
				jPanel1.add(cfgRateAField);jPanel1.add(cfgRateBField);jPanel1.add(cfgRateCField);jPanel1.add(cfgRateDField);
				jPanel1.add(new JLabel("    "));jPanel1.add(new JLabel("  "));
				jPanel1.add(cfgClassAField);jPanel1.add(cfgClassBField);jPanel1.add(cfgClassCField);jPanel1.add(cfgClassDField);
				jPanel1.add(cfgLClassDField);
				jPanel1.add(new JLabel("    "));
				jPanel1.add(cfgEstDiscountField);
				
				// allign fields
				rateALabel.setLabelFor(cfgRateAField);classALabel.setLabelFor(cfgClassAField);
				rateBLabel.setLabelFor(cfgRateBField);classBLabel.setLabelFor(cfgClassBField);
				rateCLabel.setLabelFor(cfgRateCField);classCLabel.setLabelFor(cfgClassCField);
				rateDLabel.setLabelFor(cfgRateDField);classDLabel.setLabelFor(cfgClassDField);
				LclassDLabel.setLabelFor(cfgLClassDField);
				estateDiscountLabel.setLabelFor(cfgEstDiscountField);
				
				cfgClassDField.setEditable(false);
				configSaved = false;
					
				
			}
			cfgRateAField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgRateBField.requestFocus();
				}
			});
			cfgRateBField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgRateCField.requestFocus();
				}
			});
			cfgRateCField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgRateDField.requestFocus();
				}
			});
			cfgRateDField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgClassAField.requestFocus();
				}
			});
			cfgClassAField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgClassBField.requestFocus();
				}
			});
			cfgClassBField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgClassCField.requestFocus();
				}
			});
			cfgClassCField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgLClassDField.requestFocus();
				}
			});
			cfgClassDField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgLClassDField.requestFocus();
				}
			});
			cfgLClassDField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cfgEstDiscountField.requestFocus();
				}
			});
			cfgEstDiscountField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
				}
			});
			return jPanel;
		}
		private void updateConfig(String currentEstateName){
			retriveConfig (currentEstateName);
			
			cfgRateAField.setValue(rateA);
			cfgRateBField.setValue(rateB);
			cfgRateCField.setValue(rateC);
			cfgRateDField.setValue(rateD);
			cfgClassAField.setValue(classAlimit);	
			cfgClassBField.setValue(classBlimit);	
			cfgClassCField.setValue(classClimit);	
			cfgClassDField.setValue(classDlimit);
			cfgLClassDField.setValue(classDLlimit);	
			cfgEstDiscountField.setValue(estDiscount);
			
			updateConfigFields(currentEstateName);
			
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
							//System.out.println("Changed rate value:"+cfgRateAField.getValue());
							saveConfig();
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
			
			classAlimit = new Integer(cfgClassAField.getText()).intValue();
			classBlimit = new Integer(cfgClassBField.getText()).intValue();
			classClimit = new Integer(cfgClassCField.getText()).intValue();
			classDlimit = new Integer(cfgClassDField.getText()).intValue();
			classDLlimit = new Integer(cfgLClassDField.getText()).intValue();
			estDiscount = new Integer(cfgEstDiscountField.getText()).intValue();
			
			//other fields are saved to XML file @ estate/date/<currentEstateName>.xml by "save Estate" button
			////cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
			EA = cfgEstateAddress.getText();
			ES = cfgEstateSyNo.getText();
			EC = cfgCoupContractor.getText();
			//rest (class & rate)  to txt file @ estate/config/<currentEstateName>.xml
			try {
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("estate\\configData\\"+currentEstateName, false)));
				out.print(" ");out.print(rateA);out.print(" ");out.print(rateB);out.print(" ");
				out.print(rateC);out.print(" ");out.print(rateD);out.print(" ");
				out.print(classAlimit);out.print(" ");out.print(classBlimit);out.print(" ");
				out.print(classClimit);out.print(" ");out.print(classDlimit);out.print(" ");
				out.print(classDLlimit);out.print(" ");
				out.print(estDiscount);out.print(" ");
				out.print("\n");
				out.flush();
				out.close();
				configSaved = true;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		 }
	private void retriveConfig (String currentEstateName){
		 	
		 if ((new File("estate\\configData\\" + currentEstateName)).exists()){
		 	
			LineNumberReader in;
			try {
				 in = new LineNumberReader( new FileReader("estate\\configData\\" + currentEstateName));
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
				   if (st.hasMoreTokens()) classDLlimit = new Integer(st.nextToken()).intValue();
				   if (st.hasMoreTokens()) estDiscount = new Integer(st.nextToken()).intValue();
				   
				   newLine = in.readLine();
				}
				in.close();   
			} catch (Exception e) {
				
				e.printStackTrace();
			}
             // read others from from XML file @ esate/data/<CESN>
			updateConfigFields(currentEstateName);
			
		 }
         
	}
	private void updateConfigFields(String currentEstateName) {
		// TODO Auto-gen
		EstateFileSupport sample = new EstateFileSupport();
		String fn = "estate\\data\\" + currentEstateName+"\\index";
					if ( (new File(fn+".xml")).exists()){
						sample.loadExistingInstance(fn+".xml");
						EA = sample.iIncoming.getEstate().getPlantAddress();
						ES = sample.iIncoming.getEstate().getSyNo();
						EC = sample.iIncoming.getEstate().getCoupContractor();
					}
		cfgEstateAddress.setText(EA);
		cfgEstateSyNo.setText(ES);
		cfgCoupContractor.setText(EC);	
		
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="50,14"
