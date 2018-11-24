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
import javax.swing.table.JTableHeader;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

// Esate file table is always at <estateDIR>/.estate
// Estate root data = Name of the Planter, Village, Survey No, Coup Contractor
// estate root data is at first row of .estate file

public class FirmTable extends JFrame {
	private boolean DEBUG = false;
	public int rowno=0;


	JTable table = null;
	public static MyTableModel myModel = null;
	Vector values;
	//int sno=0;
	

	final String[] columnNames = {"SNo","Order no", "Load Name", "Date", "Planks", "Runners", "Battons", 
              "SLR", "Lapha","others", "TotalCFT",  "Mark"};

	// constructor
	public FirmTable() {
				super("FrimTable");
				if (myModel == null){
				  myModel = new MyTableModel();
				  myModel.setColumnIdentifiers(columnNames);
				 
				}
				if (table == null){				
				  table = new JTable(myModel);
				  //JTableHeader th = new JTableHeader(); ??
				}
				//table.sizeColumnsToFit(1);
				table.setPreferredScrollableViewportSize(new Dimension(600, 40)); //30 before
	}

	public JTable getTableDisplay(){
		table.setBackground(Color.lightGray);
		return table;
	}
	public static MyTableModel getModel(){
			return myModel;
	}
	
	
	public void store2File(String estate, String lorry, String address){
						   	
		int sno =0; boolean tableRowMatch = false;
			try {   
					
			FirmFileSupport sample = new FirmFileSupport();
			int index=0;
			double tempCFT=0.0;
				//---------------------------------------------------------------------
			  /*boolean foundMatch=false;
			  if ( (new File("firm/data"+estate+"/index.xml")).exists()){
				 sample.loadExistingInstance("firm/data"+estate+"/index.xml");
				 // search & update correct load
				 for ( int i = 0 ; i < sample.iFirm.getloadCount(); i++){
					if (sample.iFirm.getLoad(i).getLoadName().equalsIgnoreCase(lorry)){
						index = i; foundMatch = true;
					}
				}
				if (foundMatch) {System.out.println("Firm load already exits..using index:"+index);
					//update firm & Load
				} else {// create a new load & update.
				}
				
				sample.iFirmFactory.save("firm/data"+estate+"/index.xml");
			  }
			  else{ */
			  //------------------------------------------------------------------
			  
			  // create a new index.html
			String tempfn = "firm/temp/"+estate;
			sample.createNewInstance(tempfn+".xml");
			index=0;
			 //update Firm details & load details
			Vector vt = myModel.getDataVector();
			for (Enumeration e = vt.elements(); e.hasMoreElements();) {
				Vector v = (Vector) e.nextElement(); 
				if (index > 0) sample.iFirm.setLoad(index, sample.createload("load"));
				Enumeration e1 = v.elements() ;
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setSno((e1.nextElement()).toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setOrderNo(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setLoadName(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setLoadDate(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setPlanks(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setRunners(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setBattons(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setSLR(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setLapha(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setOthers(e1.nextElement().toString());
				if (e1.hasMoreElements()) sample.iFirm.getLoad(index).setTotalCFT(e1.nextElement().toString());
				
				sample.iFirm.getLoad(index).setAmount("");
				tempCFT += (new Double(sample.iFirm.getLoad(index).getTotalCFT())).doubleValue();
				index++;
				
			}
			System.out.println("FirmTable.store2file: updated & saved firm table, #of load = "+index);
			//update display fields
			SizeConverter.tFLnumPeriods = index;
			SizeConverter.tFLnumPeriodsField.setValue(index);
			SizeConverter.fcft = tempCFT;
			SizeConverter.fcftField.setValue(tempCFT);
			
			    sample.iFirm.getDetails().setFirmName(estate);
				sample.iFirm.getDetails().setFirmAddress(address);
				sample.iFirmFactory.save(tempfn+".xml");
				
				(new File("firm/data/"+estate)).mkdir();
				appendXSL(tempfn+".xml" ,"firm/data/"+estate+"/index.xml");
				
				{ File fx = new File(tempfn+".xml");
				if(!fx.delete()){ /*System.gc(); Thread.sleep(1000); fx.delete();*/ 
					fx.deleteOnExit(); }
				}
				
				(new File("reports/Firm/"+estate)).mkdir();
				TransformerFactory tf = TransformerFactory.newInstance();
				try {Source sr = new StreamSource("firm/data/"+estate+"/index.xml");
					 Result rs = new StreamResult("reports/Firm/"+estate+"/"+estate+".html"); 
					 // templates
					 Source xsl = new StreamSource("firm/config/sampleFirmTable-dataLogic.xsl");
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
			  
			} catch (Exception e) {
				System.out.println("Store2File: Unable to append to file:"+e);
				//if ((new File(fn)).exists())
			}
		}
	
		public void retrive4File(String estatename){
		
			String fn = "firm/data/"+estatename;	
				 // XML read 4 "estate/data/"+estatename+".xml"
			FirmFileSupport sample = new FirmFileSupport();
			int index=0; double tempCFT=0.0;
			boolean foundMatch=false;
			if ( (new File(fn+"/index.xml")).exists()){
				sample.loadExistingInstance(fn+"/index.xml");	
				// populate JTable	
				for ( int i = 0 ; i < sample.iFirm.getloadCount(); i++)
				{
			        //System.out.println(" retive4File bug: sno ="+sample.iFirm.getLoad(i).getSno() );
				Object[] rowdata = { new Integer(sample.iFirm.getLoad(i).getSno()), 
					sample.iFirm.getLoad(i).getOrderNo(), 
					sample.iFirm.getLoad(i).getLoadName(),
					sample.iFirm.getLoad(i).getLoadDate(),
					new Double(sample.iFirm.getLoad(i).getPlanks()),
					new Double(sample.iFirm.getLoad(i).getRunners()),
					new Double(sample.iFirm.getLoad(i).getBattons()),
					new Double(sample.iFirm.getLoad(i).getSLR()),
					new Double(sample.iFirm.getLoad(i).getLapha()),
					new Double(sample.iFirm.getLoad(i).getOthers()),
					new Double(sample.iFirm.getLoad(i).getTotalCFT()),
					new Boolean(false)
					};
				myModel.addRow(rowdata);
				tempCFT += new Double(sample.iFirm.getLoad(i).getTotalCFT()).doubleValue();
				}
				//System.out.println("FT retrived "+ sample.iFirm.getloadCount() +" rows to FT");
				SizeConverter.addressField.setText(sample.iFirm.getDetails().getFirmAddress());
				
				SizeConverter.tFLnumPeriods = sample.iFirm.getloadCount();
				SizeConverter.tFLnumPeriodsField.setValue(sample.iFirm.getloadCount());
				SizeConverter.fcft = tempCFT;
				SizeConverter.fcftField.setValue(tempCFT);
		
			return ;
		   }
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
			if (col < 1 || col == 2) {
				return false;
			} else {
				return true;
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
			
			if (DEBUG) {
				System.out.println("Deleted a row at " + row + "," + col
								   + " to " + value
								   + " (an instance of "
								   + value.getClass() + ")");
			}
			if ( (col >= 4 ) && ( col <= 9)) { // update total cft
				double temp = ((Double)getValueAt(row,col)).doubleValue();
				double tcft = ((Double)getValueAt(row,10)).doubleValue();
				super.setValueAt( new Double((tcft -temp)+((Double)value).doubleValue()),row,10 );
			}
			super.setValueAt(value,row,col);
			if (col == 11) {
				//removeRow(row);
			}
			
		}

	}
	/**
	 * @param currentEstateLoad
	 * @param sizeType
	 * @param tscft
	 */
	public void updateRowCFT(String currentEstateLoad, int col, double tscft, String orderno, String date) {
		
		int row = getLoadRowIndex(currentEstateLoad);
		
		if ( row == 0 ) {// add a new Load row
			final Object[] fdata = { new Integer(myModel.getRowCount()+1), 
				orderno, currentEstateLoad , date, new Double(0.0), 
				new Double(0.0),new Double(0.0), new Double(0.0), new Double(0.0), new Double(0.0), 
				new Double(0.0),  new Boolean(false)};
			myModel.addRow(fdata);
			
			// update tscft, tcft
			myModel.setValueAt(new Double(tscft), myModel.getRowCount()-1 , col );
			myModel.setValueAt(new Double(tscft), myModel.getRowCount()-1 , 10 );
			SizeConverter.fcft += tscft;
						
		} else { // update (retrive & add) tscft, tcft
			System.out.println("FirmTable.updateRowCFT: Firm table row found, index:"+(row-1));
			row--;
			double temp1 = ((Double)myModel.getValueAt(row,col)).doubleValue();
			double temp2 = ((Double)myModel.getValueAt(row,10)).doubleValue();
			myModel.setValueAt(new Double(tscft + temp1), row , col );
			myModel.setValueAt(new Double(tscft + temp2), row , 10 );
			SizeConverter.fcft += tscft;
		} 
		SizeConverter.tFLnumPeriods = myModel.getRowCount();
		SizeConverter.tFLnumPeriodsField.setValue(myModel.getRowCount());
		SizeConverter.fcftField.setValue(SizeConverter.fcft);
	}

	/**
	 * @param currentEstateLoad
	 * @return value = (actual index+1)
	 */
	public int getLoadRowIndex(String currentEstateLoad) {
		boolean tableRowMatch = false;
		
		int count = myModel.getRowCount(), rowindex =0;
		
			for (int i=0; i<count; i++)
				if(((String)myModel.getValueAt(i, 2)).equalsIgnoreCase(currentEstateLoad)) {
					rowindex = i + 1; tableRowMatch = true;
				}
		
		return rowindex;
	}
	public void appendXSL(String from, String to)
		{
			try{
				LineNumberReader in = new LineNumberReader (new FileReader(from));	
				PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(to, false)));
				String line = in.readLine(); 
				boolean first = true;
				while (line != null){
					if (first) out1.println(line +"\n"+ "<?xml-stylesheet type=\"text/xsl\" " +
						"href=\"../../config/sampleFirmTable-dataLogic.xsl\"?>");
					else out1.println(line);
				first = false;
				line = in.readLine();
				}
				in.close();
				out1.flush();
				out1.close();
			} catch (IOException e) {
			  System.out.println(" FirmTable.appendXSL: Error in opening file:"+from+" exception is:"+e);}

		}
	
	
}