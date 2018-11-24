/*
 * Created on Apr 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.myself;

// support to print Estate table.
/**
 * @author pbijjala
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


// Estate only stores/retrives XML data.. no data store as in Load
// No UI modification of table, only deletion is allowed.

public class EstateTable extends JFrame {
	private boolean DEBUG = true;
	public int rowno=0;
	public static double estCFT=0.0;
	public static double estDis=0.0; public static double estLCount=0.0;

	JTable table = null;
	public static MyTableModel myModel = null;
	Vector values;
	//int sno=0;
	

	final String[] columnNames = {"SNo","Date","Lorry No", "Logs", "A Class", "B Class","C Class","D Class",
													   "Total CFT",
													  "Unload",
													  "<>",
													  "Tape Clerk","DelNo", "Stumps", "Mark"};

	// constructor
	public EstateTable() {
				super("EstateTable");
				if (myModel == null){
				  myModel = new MyTableModel();
				  myModel.setColumnIdentifiers(columnNames);
				}
				if (table == null){				
				table = new JTable(myModel);
				}
				//table.sizeColumnsToFit(1);
				table.setPreferredScrollableViewportSize(new Dimension(750, 120)); //30 before
	}

	public JTable getTableDisplay(){
		table.setBackground(Color.lightGray);
		return table;
	}
	public MyTableModel getModel(){
			return myModel;
	}
	
	
	public void store2File(String estate, String date, String lorry, int logs, String cftA, String cftB, String cftC, String cftD, String tcft, 
						   String clerk, String tape, String delno, String stumps ){
						   	
				String fn = "estate/temp/"+estate; int sno =0; boolean tableRowMatch = false;
		try {   
				// First, convert load to a row & add to jtable
				// System.out.println("Writing to a file:"+fn);
				int count = myModel.getRowCount(), rowindex =0;
				
				//load row already exits then modify it..
				if ( count > 0 ) { 
					// see if there a matching row
					for (int i=0; i<count; i++)
						if(((String)myModel.getValueAt(i, 2)).equalsIgnoreCase(lorry)) {
							rowindex = i; tableRowMatch = true;
							System.out.println("EstateTable.store2File:Saving Estate jTable, load row found, row index:"+i);
						}
						
					if (!tableRowMatch) {  // add new row
						sno = myModel.getRowCount() + 1;
						Object[] rowdata = { new Integer(sno), date, lorry, new Integer(logs), 
								cftA, cftB, cftC, cftD, tcft, 
								clerk, new String(""), tape, delno, stumps, new Boolean(false)
						};
						myModel.addRow(rowdata);
						ConvertLobs.setELC(new Integer(sno).toString());
						ConvertLobs.setETCFT((new Double(tcft)).doubleValue()+ ConvertLobs.etcftp);
					} 
					else { // load already exits then change values at rowindex
					//System.out.println("ET Changing the values at, index:"+rowindex);
					ConvertLobs.setETCFT((ConvertLobs.etcftp - (new Double((String)myModel.getValueAt(rowindex, 8))).doubleValue())
							+(new Double(tcft)).doubleValue());
					
					myModel.setValueAt(date, rowindex, 1 );
					myModel.setValueAt(new Integer(logs), rowindex, 3 );
					myModel.setValueAt(cftA, rowindex, 4 );myModel.setValueAt(cftB, rowindex, 5 );myModel.setValueAt(cftC, rowindex, 6 );myModel.setValueAt(cftD, rowindex, 7 );
					myModel.setValueAt(tcft, rowindex, 8 );
					myModel.setValueAt(clerk, rowindex, 9 );
					myModel.setValueAt(tape, rowindex, 11 );
					myModel.setValueAt(delno, rowindex, 12 );
					myModel.setValueAt(stumps, rowindex, 13 );
					// sno used at XML storing..
					sno = ((Integer)myModel.getValueAt(rowindex, 0)).intValue();
					}
				
				} 
				else { // count == 0, so it's a first load in this estate
				  sno = 1; 
				  Object[] rowdata = { new Integer(sno), date, lorry, new Integer(logs), 
							cftA, cftB,cftC,cftD,tcft, 
							clerk, new String(""), tape, delno, stumps, new Boolean(false)
									};
				  myModel.addRow(rowdata);
				  ConvertLobs.setELC("1");
				  ConvertLobs.setETCFT((new Double(tcft)).doubleValue());
				}
				
				// having updated (& displayed) the estate jTable, now create a XML file - a fresh
				
			    EstateFileSupport sample = new EstateFileSupport();
			    int index=0;
			    boolean foundMatch=false;
			    /*
				if ( (new File(fn+".xml")).exists()){
					sample.loadExistingInstance(fn+".xml");
					// search & update correct load 
					for ( int i = 0 ; i < sample.iIncoming.getLoadDetails().getloadCount() ; i++){
						if (sample.iIncoming.getLoadDetails().getLoad(i).getLorryNumber().equalsIgnoreCase(lorry)){
							index = i; foundMatch = true;
							//System.out.println("Found matching XML load, at index:"+index);
						}
					}
					if (!foundMatch){
						// create Load, don't increament since index starts from 0
						index = sample.iIncoming.getLoadDetails().getloadCount();
						//System.out.println("Not found matched load, using new index:"+index);
						sample.iIncoming.getLoadDetails().setLoad(index, sample.createload("load"));
					}
					//System.out.println("estate exits & load created/found..using index:"+index);
				}
				else{ // new estate
					sample.createNewInstance(fn+".xml");
					index=0;
					//System.out.println("estate created new ..");
					}
			    */
			    sample.createNewInstance(fn+".xml");
				index=0;
				// read from estate jTable, load by load & update XML instance
			    Vector vt = myModel.getDataVector();
				for (Enumeration e = vt.elements(); e.hasMoreElements();) {
					Vector v = (Vector) e.nextElement(); 
					if (index > 0) sample.iIncoming.getLoadDetails().setLoad(index, sample.createload("load"));
					Enumeration e1 = v.elements() ;
					
				sample.iIncoming.getLoadDetails().getLoad(index).setSNo(e1.nextElement().toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setDate((e1.nextElement()).toString());	
			    sample.iIncoming.getLoadDetails().getLoad(index).setLorryNumber((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setLogs((e1.nextElement()).toString());
			    
			    sample.iIncoming.getLoadDetails().getLoad(index).setClassA((e1.nextElement()).toString());
			    sample.iIncoming.getLoadDetails().getLoad(index).setClassB((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setClassC((e1.nextElement()).toString());
			    sample.iIncoming.getLoadDetails().getLoad(index).setClassD((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setTotalCFT((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setUnload((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setClerk((e1.nextElement()).toString()); // " "
				sample.iIncoming.getLoadDetails().getLoad(index).setTape((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setDelNo((e1.nextElement()).toString());
				sample.iIncoming.getLoadDetails().getLoad(index).setStumps((e1.nextElement()).toString());
				
				index++; // total number of loads
			    }
				System.out.println("EstateTable.store2file: created XML estate file, #of loads "+index);
				
				//cfgEstateAddress, cfgEstateSyNo, cfgCoupContractor;
				//total estate TCFT, discount & TCFT after discount
			    sample.iIncoming.getEstate().setPlanterName(estate);
				sample.iIncoming.getEstate().setPlantAddress(Converter.EA);
			    sample.iIncoming.getEstate().setSyNo(Converter.ES);
			    sample.iIncoming.getEstate().setCoupContractor(Converter.EC);
			    sample.iIncoming.getEstate().setTcft(new Double(ConvertLobs.estTCFT.getValue()).toString());
			    sample.iIncoming.getEstate().setDiscount(ConvertLobs.ELC);// discount = no of loads
			    sample.iIncoming.getEstate().setDisTcft("");
				
			    sample.iIncomingFactory.save(fn+".xml");
			    
			    // save it as index.xml, 
			    // and then transform into index.html using xsl
			    
			    (new File("estate/data/"+estate)).mkdir();
			    LineNumberReader in = new LineNumberReader (new FileReader(fn+".xml"));	
			    PrintWriter out = new PrintWriter(new BufferedWriter(
			                                new FileWriter("estate/data/"+estate+"/index.xml", false)));
				String line = in.readLine(); boolean first = true;
				while (line != null){
					if (first) out.println(line +"\n"+ "<?xml-stylesheet type=\"text/xsl\" href=\"../../config/estateSample-dataLogic.xsl\"?>");
					else out.println(line);
					first = false;
					line = in.readLine();
				}
			    in.close();
				out.flush();
				out.close();
				
				{ File fx = new File(fn+".xml");
				if(!fx.delete()){ /*System.gc(); Thread.sleep(1000); fx.delete();*/ 
					fx.deleteOnExit(); }
				}
				
				(new File("reports/Estate/"+estate)).mkdir();
				TransformerFactory tf = TransformerFactory.newInstance();
				try {Source sr = new StreamSource("estate/data/"+estate+"/"+"index.xml");
					 Result rs = new StreamResult("reports/Estate/"+estate+"/"+estate+".html"); 
					 // templates
					 Source xsl = new StreamSource("estate/config/estateSample-dataLogic.xsl");
					 Templates tmp = tf.newTemplates(xsl);
					 Transformer tranf1 = tmp.newTransformer();
					 // case1: no templates
					 // Transformer transformer = tf.newTransformer();
					 // transformer.transform(sr,rs);
					 
					 // case:2 - with templates
					 tranf1.transform(sr,rs);	 
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		} catch (IOException e) {
			System.out.println("Unable to append to file:"+fn+"  "+e);
			//if ((new File(fn)).exists())
			}
	}
	
	public static void retrive4File(String estatename){ // read from index.xml file, a fresh
		
		String fn = "estate/data/"+estatename;	
		// XML read 4 "estate/data/"+estatename+".xml"
		EstateFileSupport sample = new EstateFileSupport();
		int index=0;
		
		boolean foundMatch=false;
		if ( (new File(fn+"/index.xml")).exists()){
			sample.loadExistingInstance(fn+"/index.xml");	
			// populate into JTable	- load by load
			for ( int i = 0 ; i < sample.iIncoming.getLoadDetails().getloadCount() ; i++)
			{
			Object[] rowdata = { new Integer(sample.iIncoming.getLoadDetails().getLoad(i).getSNo()), 
				sample.iIncoming.getLoadDetails().getLoad(i).getDate(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getLorryNumber(), 
				new Integer(sample.iIncoming.getLoadDetails().getLoad(i).getLogs()), 
				sample.iIncoming.getLoadDetails().getLoad(i).getClassA(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getClassB(),
				sample.iIncoming.getLoadDetails().getLoad(i).getClassC(),
				sample.iIncoming.getLoadDetails().getLoad(i).getClassD(),
				sample.iIncoming.getLoadDetails().getLoad(i).getTotalCFT(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getUnload(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getClerk(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getTape(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getDelNo(), 
				sample.iIncoming.getLoadDetails().getLoad(i).getStumps(), 
				new Boolean(false)
				};
			  myModel.addRow(rowdata);
			  estCFT += (new Double(sample.iIncoming.getLoadDetails().getLoad(i).getTotalCFT())).doubleValue();
			}
			// retrieve total estate TCFT, discount & TCFT after discount
			// set a fresh - by calculating.
			ConvertLobs.setETCFT(estCFT);
			ConvertLobs.setELC(new Integer(sample.iIncoming.getLoadDetails().getloadCount()).toString());
			//System.out.println("ET retrived "+ estCFT +" as total estate CFT");
			//System.out.println("ET retrived "+ sample.iIncoming.getLoadDetails().getloadCount() +" rows to ET");
		}
		
		return ;
	}
	
	public static void retrive4load(String estatename, String loadname){
		// retrive for a perticular load - pertaining metadata for config panel.
		
			String fn = "estate/data/"+estatename;	
			// XML read 4 "estate/data/"+estatename+".xml"
			EstateFileSupport sample = new EstateFileSupport();
			int index=0;
			boolean foundMatch=false;
			if ( (new File(fn+"/index.xml")).exists()){
				sample.loadExistingInstance(fn+"/index.xml");	
				// populate JTable	
				for ( int i = 0 ; i < sample.iIncoming.getLoadDetails().getloadCount() ; i++)
				{
					if (sample.iIncoming.getLoadDetails().getLoad(i).getLorryNumber().equalsIgnoreCase(loadname)){
						// add to convertFields, for estate config display
						Converter.loadClerkField.setText(sample.iIncoming.getLoadDetails().getLoad(i).getUnload());
						Converter.loadDateField.setText(sample.iIncoming.getLoadDetails().getLoad(i).getDate());
						Converter.tapeField.setText(sample.iIncoming.getLoadDetails().getLoad(i).getTape());
						Converter.stumpsField.setText(sample.iIncoming.getLoadDetails().getLoad(i).getStumps());
						Converter.DCField.setText(sample.iIncoming.getLoadDetails().getLoad(i).getDelNo());
						
					}
					
				}
				//System.out.println("ET field data retrived ");
			}
		
			return ;
		}
	
	
	
	
	public class MyTableModel extends DefaultTableModel {
			/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			// # = total Col -1 // max col # 14
			if (col >= 9 || col ==1  ) {
				return true;
			} else {
				return false;
			}
		}
		
		/*
				 * JTable uses this method to determine the default renderer/
				 * editor for each cell.  If we didn't implement this method,
				 * then the last column would contain text ("true"/"false"),
				 * rather than a check box.
				 */
				public Class getColumnClass(int c) {
					return getValueAt(0, c).getClass();
				}

		/*
		 * Don't need to implement this method unless your table's
		 * data can change.
		 */
		public void setValueAt(Object value, int row, int col) {
			super.setValueAt(value,row,col);
			if (DEBUG) {
				//System.out.println("Deleted a row at " + row + "," + col+ " to " + value+ " (an instance of "+ value.getClass() + ")");
				//System.out.println("Currently not supported option");
			}
			// TODO: need to delete row & respective files of Load details, including refreshing load jTable.
			
		}

	}
	
	
}