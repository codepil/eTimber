/*
 * Created on Apr 14, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.myself;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
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

// Log root data is at first row of log file,  also stored in .estate file as a row.
// Log data: Date, Lorry No, #of Logs, Class Data, tcft, clerk, tape, unload, del.no, stumps;

public class SizeTableDisplay extends JFrame {
	private boolean DEBUG = false;
	public int rowno=0;

	JTable table = null;
	public static MyTableModel myModel = null;
	Vector values;
	final Object[] data =
				{"1","10", "11", "4", "2", new Integer(5), new Double(60.0), new Boolean(false) };

	final String[] columnNames = {"SNo", "Length", "Width", "Thickness", 
													  "RFT", "CFT",
													  "Quantity",
													   "Delete?"
													 };
    //static int rowcount = 0;
	// constructor
	public SizeTableDisplay() {
				super("SizeTableDisplay");
				if (myModel == null){
				  myModel = new MyTableModel();
				  myModel.setColumnIdentifiers(columnNames);
				}
				if (table == null){				
				table = new JTable(myModel);
				}
				//table.sizeColumnsToFit(1);
				table.setPreferredScrollableViewportSize(new Dimension(600, 150));
	}

	public JTable getTableDisplay(){
		return table;
	}
	public MyTableModel getModel(){
			return myModel;
	}
	// called to store partial size load to data file, firmtable data to XML file & save sizeload XML file.
	public void store2File(String fn, String estateName, String loadName, String date, FirmTable ft, String address, String ordno, String articles){
    
		try {   
			
			System.out.println("sizeTableDisplay.store2File: Writing binary load data to a file:"+fn);
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fn, false)));
				// convert row to a string
				if (!SizeConverter.clearSizeTable){
				Vector vt = myModel.getDataVector();
				for (Enumeration e = vt.elements() ; e.hasMoreElements() ;) {
					 Vector v = (Vector) e.nextElement();
					 for (Enumeration e1 = v.elements() ; e1.hasMoreElements() ;) {
						out.print(e1.nextElement()); out.print(" ");
					 }
					out.print("\n");
				 }
				}
			   out.flush();
			   out.close();

			SizeFileSupport sample = new SizeFileSupport();
			int index=0;
				
			String tempXMLfile = "firm\\temp\\"+estateName+loadName;
			    if ( (new File(tempXMLfile+".xml")).exists()){
					sample.loadExistingInstance(tempXMLfile+".xml");	 
			    } else {
					// file must already exits, if not size total is not done hence don't save it to XML
					//sample.createNewInstance(xmlfile+".xml");
					//index=0;
					//System.out.println("Store2File:Complete till given size & press \"Done Size\" button..");
					return;
			    }
						 
			//update FirmSizeTotal attr
			int i = ft.getLoadRowIndex(loadName);
			if (i==0) System.out.println("Error in index load @ Store2File 4"+loadName);
			else { i--;
			sample.iOutGoing.getSizeTotal().setLapha((ft.getModel().getValueAt(i,8)).toString());
			sample.iOutGoing.getSizeTotal().setRunners((ft.getModel().getValueAt(i,5)).toString());
			sample.iOutGoing.getSizeTotal().setPlanks((ft.getModel().getValueAt(i,4)).toString());
			sample.iOutGoing.getSizeTotal().setSLR((ft.getModel().getValueAt(i,7)).toString());
			sample.iOutGoing.getSizeTotal().setBattons((ft.getModel().getValueAt(i,6)).toString());
			sample.iOutGoing.getSizeTotal().setOthers((ft.getModel().getValueAt(i,9)).toString());
			sample.iOutGoing.getSizeTotal().setTotalCFT((ft.getModel().getValueAt(i,10)).toString());
			}
			
			sample.iOutGoing.getFirmDetails().setFirmName(estateName);
			sample.iOutGoing.getFirmDetails().setFirmAddress(address);
			sample.iOutGoing.getFirmDetails().setOrderNo(ordno);
			sample.iOutGoing.getFirmDetails().setArticles(articles);
			sample.iOutGoing.getFirmDetails().setLorryName(loadName);
			sample.iOutGoing.getFirmDetails().setLoadDate(date);
			
						    
			sample.iOutGoingFactory.save(tempXMLfile+".xml");
			    
			(new File("firm\\data\\"+estateName)).mkdir();
			appendXSL(tempXMLfile+".xml", "firm\\data\\"+estateName+"\\"+loadName+".xml");
			
			{ File fx = new File(tempXMLfile+".xml");
			if(!fx.delete()){ /*System.gc(); Thread.sleep(1000); fx.delete();*/ 
				fx.deleteOnExit(); }
			}
			
			(new File("reports/Firm/"+estateName)).mkdir();
			TransformerFactory tf = TransformerFactory.newInstance();
			try {Source sr = new StreamSource("firm/data/"+estateName+"/"+loadName+".xml");
				 Result rs = new StreamResult("reports/Firm/"+estateName+"/"+loadName+".html"); 
				 // templates
				 Source xsl = new StreamSource("firm/config/sampleSizeload-dataLogic.xsl");
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
	// retrive sizeTable from load data file, update tsrft..etc
	// retrive FirmTable from XML file.
	public static void retrive4File(String fn){

		boolean sizeFlag = false;

		try {

			LineNumberReader in = new LineNumberReader (new FileReader(fn));
			String newLine = in.readLine();
			while (newLine != null) {
				// final Object[] data = { new Integer(sno), new Integer(length), new Double(width), new Double(thick), new Double(rft), new Double(cft),
				// new Integer(Quantity), new Boolean(false)};
				// ex: 1 10.0 4.6 12.66 0.0 0.0 0.0 A 200.0 1 2532.0 12.66 false

				StringTokenizer st = new StringTokenizer(newLine," ");
				Vector vt = new Vector();
				/* do according to format of sizefile storage
				 */
				
					if (st.hasMoreTokens()){ String temp =st.nextToken();
						if ( temp.equalsIgnoreCase("Total")) { vt.add("Total"); vt.add(st.nextToken()); sizeFlag = true;} 
						else {
						Integer sno = new Integer(temp); vt.add(sno); SizeConverter.sno++;
						if (st.hasMoreTokens()) {Integer temp1 = new Integer(st.nextToken()); vt.add(temp1);} //Length 
						}
					}//sno
					
					if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);}// width
					if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);}// Thick
					//if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);SizeConverter.addTCFTA(temp.doubleValue());}// class A cft
					//if (st.hasMoreTokens()) vt.add(new String(st.nextToken())); // String Calss
					if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);
						if(!sizeFlag){
							SizeConverter.tsrft = temp.doubleValue() + SizeConverter.tsrft;
							SizeConverter.trft = temp.doubleValue()+ SizeConverter.trft;
					    } else {
						    SizeConverter.tsrft = 0.0;
					    }
					SizeConverter.trftField.setValue(SizeConverter.trft);
				    SizeConverter.tsrftField.setValue(SizeConverter.tsrft);
							
					} // rft
						
				    if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);
						if(!sizeFlag){
				    	SizeConverter.tscft = temp.doubleValue()+SizeConverter.tscft;
						SizeConverter.tcft = temp.doubleValue()+SizeConverter.tcft;
						} else {
							SizeConverter.tscft = 0.0;
						}
						SizeConverter.tscftField.setValue(SizeConverter.tscft);
						SizeConverter.tcftField.setValue(SizeConverter.tcft);
						SizeConverter.tcft = SizeConverter.tcftField.getValue();
						
					} // cft
						
					if (st.hasMoreTokens()) {vt.add(new Integer(st.nextToken()));} // Quantity
					//if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);ConvertLobs.addAmount(temp.doubleValue());} // amt
					if (st.hasMoreTokens()) vt.add(new Boolean(st.nextToken())); // flag
				
				// TODO: increment ConvertLobs.sno, tcft, class cft ..etc
				 
			    sizeFlag = false;        
				myModel.addRow(vt);
				newLine = in.readLine();
			}; // while
			in.close();

		} catch (IOException e) {
			System.out.println(" SizeTableDisplay.retrive4File: Error in opening file:"+fn+" exception is:"+e);
		}
		
	}
	
	public void printTable(){
		
		/*try {
			MessageFormat headerFormat = new MessageFormat("Page {0}");
			MessageFormat footerFormat = new MessageFormat("- {0} -");
			table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
			
		} catch (PrinterException pe) {
			System.out.println("SizeTable.PrintTable:Error printing: " + pe.getMessage());
			}
			*/
		
	}

	public void disTable () {
				//Create the scroll pane and add the table to it.
				JScrollPane scrollPane = new JScrollPane(table);
				values = new Vector();
				//values.add("20"); values.add("20"); values.add("20"); values.add("20"); values.add("20");values.add("20");values.add(new Boolean(false));
				//myModel.addRow(values ); // more practicle, vector can take only objects.
				myModel.addRow(data);
		     
	
				getContentPane().add(scrollPane, BorderLayout.CENTER);

						addWindowListener(new WindowAdapter() {
							public void windowClosing(WindowEvent e) {
								System.exit(0);
							}
						});
	}

   public static void main(String[] args) {
		Vector values = new Vector();
		//values.
		SizeTableDisplay frame = new SizeTableDisplay();
	SizeTableDisplay.myModel.addRow(frame.data);
		frame.disTable();
		frame.pack();
		frame.setVisible(true);
	}

	public class MyTableModel extends DefaultTableModel {
			/*
		 * Don't need to implement this method unless your table's
		 * editable.
		 */
		public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			// # = total Col -1
			if (col == 6 || col == 1 || col == 2 || col==3 ||col== 7) {
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
				System.out.println("Changed a row at " + row + "," + col
								   + " to " + value
								   + " (an instance of "
								   + value.getClass() + ")");
			}
            //final Object[] data = { new Integer(sno), new Integer(length), new Double(width), new Double(thick), new Double(rft), new Double(cft),
			// new Integer(Quantity), new Boolean(false)};
			// ex: 1 10.0 4.6 12.66 0.0 0.0 0.0 A 200.0 1 2532.0 12.66 false
			if (col==1 || col==2 || col == 3 ||col==6){// length or width or thick or quantity
				int bFt=0, bIn=0, breadthIn=0, rateclass=0 ; 
				double cft=0, rft =0.0; String wclass="";

				double x = ((Double)getValueAt(row,2)).doubleValue();
				double x1 = ((Double)getValueAt(row,3)).doubleValue();
				int q = ((Integer)getValueAt(row,6)).intValue();
				int l = ((Integer)getValueAt(row,1)).intValue();
				
				cft = (l* x * x1 * q)/(16*9);
				rft = (l* x * x1 * q)/(9);

				SizeConverter.tcft = SizeConverter.tcft - (((Double)getValueAt(row,5)).doubleValue());
				SizeConverter.tcft = SizeConverter.tcft + cft;
				SizeConverter.tcftField.setValue(SizeConverter.tcft);
				SizeConverter.tcft = SizeConverter.tcftField.getValue();
				super.setValueAt(new Double(cft), row, 5);
				
				//ConvertLobs.subAmount(((Double)getValueAt(row,10)).doubleValue());

				SizeConverter.trft = SizeConverter.trft - (((Double)getValueAt(row,4)).doubleValue());
				SizeConverter.trft = SizeConverter.trft + rft;
				SizeConverter.trftField.setValue(SizeConverter.trft);
				super.setValueAt(new Double(rft), row, 5);

			}

			if (col == 7){// get row vector and get tcft
			Double temp= (Double)getValueAt(row, col-2);
			SizeConverter.tcft = SizeConverter.tcft - (temp.doubleValue());
			SizeConverter.tcftField.setValue(SizeConverter.tcft);
			SizeConverter.tcft = SizeConverter.tcftField.getValue();
			SizeConverter.tscft = SizeConverter.tscft - (temp.doubleValue());
			SizeConverter.tscftField.setValue(SizeConverter.tscft);
			SizeConverter.tscft = SizeConverter.tscftField.getValue();
			
			Double temp1= (Double)getValueAt(row, col-3);
			SizeConverter.trft = SizeConverter.trft - (temp1.doubleValue());
			SizeConverter.trftField.setValue(SizeConverter.trft);
			SizeConverter.tsrft = SizeConverter.tsrft - (temp1.doubleValue());
			SizeConverter.tsrftField.setValue(SizeConverter.tsrft);
			
			Integer temp3= (Integer)getValueAt(row, col-1);
			SizeConverter.tsnumPeriods = SizeConverter.tsnumPeriods - temp3.intValue();
			SizeConverter.tsnumPeriodsField.setValue(SizeConverter.tsnumPeriods);
			SizeConverter.tnumPeriods = SizeConverter.tnumPeriods - temp3.intValue();
			SizeConverter.tnumPeriodsField.setValue(SizeConverter.tnumPeriods);
			
			
			SizeConverter.sno--;
			//BUG, at row containing " ".intvalue();
			for (int i=row+1;  i <= SizeConverter.sno ; i++) 
			   super.setValueAt(new Integer( ((Integer)getValueAt(i,0)).intValue() - 1 ), i, 0);

			removeRow(row);
			}

		}
	}
	/**
	 * @param currentEstateName
	 * @param currentEstateLoad
	 * @param rate
	 * @param thick
	 * @param tsrft
	 * @param tscft
	 * @param tsnumPeriods
	 */
	// called to store size date in a XML file, from myModel size Table.
	public void store2XML(String estateName, String loadName, String type, double tsrft, double tscft, int tsnumPeriods) {
		SizeFileSupport sample = new SizeFileSupport();
		
	    int rowcount=0, rowIndex =0, sizecount=0, sizeIndex=0, loadcount = 0;	
	    boolean newSize = false;
		String tempXMLfile = "firm\\temp\\"+estateName+loadName;
		if ( (new File(tempXMLfile+".xml")).exists()){
			sample.loadExistingInstance(tempXMLfile+".xml");
			System.out.println("SizeTableDisplay.StoreSize2XML: Loading existing XML file..");
			rowcount = sample.iOutGoing.getrowDataCount(); rowIndex = rowcount -1;
			sizecount = sample.iOutGoing.getRowData(rowIndex).getsizeDataCount(); sizeIndex = sizecount -1;
		} else {
			sample.createNewInstance(tempXMLfile+".xml");
			newSize = true;
		}
		if (sizecount == 3) {sample.iOutGoing.setRowData(++rowIndex, sample.createrowData("rowData"));
			sizeIndex = 0;
			newSize = true;
		} 
		// by default index = 0 element is created.
		if(!newSize)sample.iOutGoing.getRowData(rowIndex).setSizeData(++sizeIndex, sample.createsizeData("sizeData"));
		
		// create a load element  & update
		Vector vt1 = myModel.getDataVector();
		for (Enumeration e = vt1.elements() ; e.hasMoreElements() ;loadcount++) {
			if (loadcount != 0) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).setLoad(loadcount, sample.createload("load"));
			Vector v = (Vector) e.nextElement();
			Enumeration e1 = v.elements() ;
			if (e1.hasMoreElements()) e1.nextElement(); // no need 4 sno#
			if (e1.hasMoreElements()) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoad(loadcount).setLength(e1.nextElement().toString());
			if (e1.hasMoreElements()) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoad(loadcount).setWidth(e1.nextElement().toString());
			if (e1.hasMoreElements()) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoad(loadcount).setThinkness(e1.nextElement().toString());
			if (e1.hasMoreElements()) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoad(loadcount).setRft(e1.nextElement().toString());
			if (e1.hasMoreElements()) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoad(loadcount).setCft(e1.nextElement().toString());
			if (e1.hasMoreElements()) sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoad(loadcount).setQnt(e1.nextElement().toString());
		}
		// total size
		SizeConverter.tempField.setValue(tscft);
		sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoadTotal().setCft( SizeConverter.tempField.getText());
		sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoadTotal().setRft((new Double(tsrft)).toString());
		sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoadTotal().setQnt((new Integer(tsnumPeriods)).toString());
		//sample.iOutGoing.getRowData(rowIndex).getSizeData(sizeIndex).getLoadTotal().setType(type+" Total");
		
		sample.iOutGoingFactory.save(tempXMLfile+".xml");
		
	}
	
	public void appendXSL(String from, String to)
	{
		try{
			LineNumberReader in = new LineNumberReader (new FileReader(from));	
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(to, false)));
			String line = in.readLine(); 
			boolean first = true;
			while (line != null){
				if (first) out1.println(line +"\n"+ "<?xml-stylesheet type=\"text/xsl\" " +					"href=\"../../config/sampleSizeload-dataLogic.xsl\"?>");
				else out1.println(line);
			first = false;
			line = in.readLine();
			}
			in.close();
			out1.flush();
			out1.close();
		} catch (IOException e) {
		  System.out.println(" SizeTableDisplay.appendXSL: Error in opening file:"+from+" exception is:"+e);}

	}
}