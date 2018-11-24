package com.myself;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
import javax.swing.JLabel;
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

public class TableDisplay extends JFrame {
    private boolean DEBUG = false;
    public int rowno=0;

    JTable table = null;
    public static MyTableModel myModel = null;
 	Vector values;
	final Object[] data =
				{"10", "11", "4", "2", new Integer(5), new Double(60.0), new Boolean(false) };

	final String[] columnNames = {"SNo","Length", "Girth", "A Class", "B Class","C Class","D Class",
													  "Class", "Rate",
													  "Quantity",
													  "Amount",
													  "CFT",
													  "Delete?"
													 };

    // constructor
 	public TableDisplay() {
				super("TableDisplay");
				if (myModel == null){
				  myModel = new MyTableModel();
                  myModel.setColumnIdentifiers(columnNames);
				}
                if (table == null){
				table = new JTable(myModel);
                }
				//table.sizeColumnsToFit(1);
				table.setPreferredScrollableViewportSize(new Dimension(600, 250));
				
	}

	public JTable getTableDisplay(){
		return table;
	}
	public MyTableModel getModel(){
			return myModel;
	}
	public void store2File(String fn, String estateName, String loadName, String date){

		try {   //System.out.println("Writing to data a file:"+fn);
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fn, false)));
				// convert row to a string
				Vector vt = myModel.getDataVector();
			    for (Enumeration e = vt.elements() ; e.hasMoreElements() ;) {
					 Vector v = (Vector) e.nextElement();
					 for (Enumeration e1 = v.elements() ; e1.hasMoreElements() ;) {
					    out.print(e1.nextElement()); out.print(",");
					 }
					out.print("\n");
				 }
			   out.flush();
			   out.close();
			   
               //write as XML file "estate\\data\\"+currentEstateName+"\\"+currentEstateLoad+".xml"
               //then, save/append as XML data
				LoadFileSupport sample = new LoadFileSupport();
				int index=0;
				String xmlfile = "estate\\temp\\"+estateName+loadName;
				sample.createNewInstance(xmlfile+".xml"); index=0;
					
				sample.iIncomingLobs.getLoadDetails().setLorryName(loadName);
			    sample.iIncomingLobs.getLoadDetails().setEstateName(estateName);
			    sample.iIncomingLobs.getLoadDetails().setDate(date);
			    Vector vt1 = myModel.getDataVector();
				for (Enumeration e = vt1.elements() ; e.hasMoreElements() ;index++) {
					if (index > 0) sample.iIncomingLobs.setLoad(index, sample.createload("load"));
				    Vector v = (Vector) e.nextElement();
					Enumeration e1 = v.elements() ;
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setSNo(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setLength(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setGirth(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setClassA(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setClassB(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setClassC(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setClassD(e1.nextElement().toString());
					// ignore next one;
					if (e1.hasMoreElements()) e1.nextElement();
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setRate(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setQuantity(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setAmount(e1.nextElement().toString());
					if (e1.hasMoreElements()) sample.iIncomingLobs.getLoad(index).setTotalCFT(e1.nextElement().toString());
					if (e1.hasMoreElements()) e1.nextElement(); //ignore 
				}
			    sample.iIncomingLobs.getTotal().setClassAcft(ConvertLobs.tcftA.getText());
			    sample.iIncomingLobs.getTotal().setClassBcft(ConvertLobs.tcftB.getText());
			    sample.iIncomingLobs.getTotal().setClassCcft(ConvertLobs.tcftC.getText());
			    sample.iIncomingLobs.getTotal().setClassDcft(ConvertLobs.tcftD.getText());
			    sample.iIncomingLobs.getTotal().setTCFT(ConvertLobs.tcft.getText());
			    sample.iIncomingLobs.getTotal().setTAmount(ConvertLobs.tamt.getText());
			    sample.iIncomingLobs.getTotal().setLobs(ConvertLobs.tqntt.getText());
			    
				sample.iIncomingLobsFactory.save(xmlfile+".xml");
				
				(new File("estate\\data\\"+estateName)).mkdir();
				LineNumberReader in = new LineNumberReader (new FileReader(xmlfile+".xml"));	
				PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("estate\\data\\"+estateName+"\\"+loadName+".xml", false)));
				String line = in.readLine(); boolean first = true;
				while (line != null){
					if (first) out1.println(line +"\n"+ "<?xml-stylesheet type=\"text/xsl\" href=\"../../config/LoadSample-dataLogic.xsl\"?>");
					else out1.println(line);
					first = false;
					line = in.readLine();
				}
				in.close();
				out1.flush();
				out1.close();
				
				{ File fx = new File(xmlfile+".xml");
				if(!fx.delete()){ /*System.gc(); Thread.sleep(1000); fx.delete();*/ 
					fx.deleteOnExit(); }
				}
				
				(new File("reports/estate/"+estateName)).mkdir();
				TransformerFactory tf = TransformerFactory.newInstance();
				try {Source sr = new StreamSource("estate/data/"+estateName+"/"+loadName+".xml");
					 Result rs = new StreamResult("reports/estate/"+estateName+"/"+loadName+".html"); 
					 // templates
					 Source xsl = new StreamSource("estate/config/LoadSample-dataLogic.xsl");
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
			System.out.println("TableDisplay.store2File: Unable to append to file:"+fn+"  "+e);
			//if ((new File(fn)).exists())
			}
	}

	public static void retrive4File(String fn){

		try {

			LineNumberReader in = new LineNumberReader (new FileReader(fn));
			String newLine = in.readLine();
			while (newLine != null){
				// use stringTokeniser to parse newline, & write to a vector + plus add to table
				// ex: 1 10.0 4.6 12.66 0.0 0.0 0.0 A 200.0 1 2532.0 12.66 false

				StringTokenizer st = new StringTokenizer(newLine,",");
				Vector vt = new Vector();
				//while (st.hasMoreTokens()){
					if (st.hasMoreTokens()){ Integer sno = new Integer(st.nextToken()); vt.add(sno); ConvertLobs.sno++; }//sno
					if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp);} //Length
					if (st.hasMoreTokens()) {vt.add(st.nextToken());}// grith
					if (st.hasMoreTokens()) {String temp = st.nextToken(); vt.add(temp);if (!temp.equalsIgnoreCase(" "))ConvertLobs.addTCFTA(new Double(temp).doubleValue());}// class A cft
					if (st.hasMoreTokens()) {String temp = st.nextToken(); vt.add(temp);if (!temp.equalsIgnoreCase(" "))ConvertLobs.addTCFTB(new Double(temp).doubleValue());} // class b
					if (st.hasMoreTokens()) {String temp = st.nextToken(); vt.add(temp);if (!temp.equalsIgnoreCase(" "))ConvertLobs.addTCFTC(new Double(temp).doubleValue());} // class c
					if (st.hasMoreTokens()) {String temp = st.nextToken(); vt.add(temp);if (!temp.equalsIgnoreCase(" "))ConvertLobs.addTCFTD(new Double(temp).doubleValue());} // class d
					if (st.hasMoreTokens()) vt.add(st.nextToken()); // String Calss
					if (st.hasMoreTokens()) vt.add(new Double(st.nextToken())); // rate
					if (st.hasMoreTokens()) {Integer temp = new Integer(st.nextToken()); vt.add(temp);ConvertLobs.addQuantity(temp.intValue());} // Quantity
					if (st.hasMoreTokens()) {Double temp = new Double(st.nextToken()); vt.add(temp.toString());ConvertLobs.addAmount(temp.doubleValue());} // amt
					if (st.hasMoreTokens()) {String temp = st.nextToken(); vt.add(temp);ConvertLobs.addTCFT(new Double(temp).doubleValue());} // cft
					if (st.hasMoreTokens()) vt.add(new Boolean(st.nextToken())); // flag
				//}
                // TODO: increment ConvertLobs.sno, tcft, class cft ..etc
				
                
				myModel.addRow(vt);
				newLine = in.readLine();
			};
			in.close();

		} catch (IOException e) {
			System.out.println(" TableDisplay.retrive4File: Error in opening file:"+fn+" exception is:"+e);
		}

		//return table;
	}

	public void printTable(){
		
		/*LineNumberReader in;StringBuffer sb; sb = new StringBuffer(); 
		try {
			in = new LineNumberReader(
					new FileReader("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/IncomingTimber/extractedData1_estateSample-dataLogic_transform.html"));
				 
		String newLine;
		newLine = in.readLine();
					do{ sb.append(newLine);
						newLine = in.readLine();
					} while (newLine != null);
		in.close();
		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		javax.swing.JDialog jDialog = new javax.swing.JDialog(f, "Configure ..", true);
		javax.swing.JPanel jPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
		//System.out.println(sb.toString());
		final String hi = sb.toString();
		JLabel jl = new JLabel("<html>"+sb.toString()+"</html>"); //jl.setText(sb.toString()); // not working...
		jPanel.add(jl, BorderLayout.CENTER);
		jDialog.setContentPane(jPanel);
		jDialog.pack();
		jDialog.setVisible(true);
		*/
		
		/*try {
			MessageFormat headerFormat = new MessageFormat("Page {0}");
			MessageFormat footerFormat = new MessageFormat("- {0} -");
			table.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);

		} catch (PrinterException pe) {
			System.err.println("Error printing: " + pe.getMessage());
		} */

	}

	public void disTable () {
				//Create the scroll pane and add the table to it.
				JScrollPane scrollPane = new JScrollPane(table);
				values = new Vector();
				values.add("20"); values.add("20"); values.add("20"); values.add("20"); values.add("20");values.add("20");values.add(new Boolean(false));
				myModel.addRow(values ); // more practicle, vector can take only objects.
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
        TableDisplay frame = new TableDisplay();
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
			//if (col == 12 || col == 1 || col == 2 || col== 9 || col == 0) {
			if (col == 12 || col == 0) {
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

			if (col==1 || col==2 || col==9){// length or Girth
				int bFt=0, bIn=0, breadthIn=0; double rateclass=0 ; double cft=0, amt =0.0; String wclass="";

				StringTokenizer st = new StringTokenizer((getValueAt(row,2)).toString(),".");
								if (st.hasMoreTokens()) bFt= (new Integer(st.nextToken())).intValue();
								if (st.hasMoreTokens()) bIn= (new Integer(st.nextToken().trim())).intValue();
								else bIn = (new Integer(0)).intValue();
				breadthIn = bFt *12 + bIn;

				double x = ((Double)getValueAt(row,1)).doubleValue();
				cft = (( x * breadthIn * breadthIn)/2304.0) * ((Integer)getValueAt(row,9)).intValue();

				ConvertLobs.subTCFT((new Double((String)getValueAt(row,11))).doubleValue());
				ConvertLobs.subAmount(((Double)getValueAt(row,10)).doubleValue());

				String cl = (String)getValueAt(row, 7);
							if (cl.equals("A")) super.setValueAt(" ", row, 3);
							if (cl.equals("B")) super.setValueAt(" ", row, 4);
							if (cl.equals("C")) super.setValueAt(" ", row, 5);
							if (cl.equals("D")) super.setValueAt(" ", row, 6);

				if ((breadthIn)>=Converter.classAlimit) { wclass = "A"; rateclass = Converter.rateA;
								amt = rateclass*cft;
								ConvertLobs.subTCFTA((new Double((String)getValueAt(row,3))).doubleValue()); ConvertLobs.addTCFTA(cft);
								super.setValueAt(new Double(cft).toString(), row, 11);
								super.setValueAt(new Double(cft).toString(), row, 3);
								 }
				else if ((breadthIn)>=Converter.classBlimit) {wclass = "B"; rateclass = Converter.rateB;ConvertLobs.addTCFTB(cft);
								amt = rateclass*cft;
								ConvertLobs.subTCFTB((new Double((String)getValueAt(row,4))).doubleValue());
								super.setValueAt(new Double(cft).toString(), row, 11);
								super.setValueAt(new Double(cft).toString(), row, 4);
								}
				else if ((breadthIn)>=Converter.classClimit) {wclass = "C";rateclass = Converter.rateC; ConvertLobs.addTCFTC(cft);
									   amt = rateclass*cft;
							 ConvertLobs.subTCFTC((new Double((String)getValueAt(row,5))).doubleValue());
							 super.setValueAt(new Double(cft).toString(), row, 11);
							 super.setValueAt(new Double(cft).toString(), row, 5);
									   }
				else if ((breadthIn)>=Converter.classDlimit) {wclass = "D";rateclass = Converter.rateD; ConvertLobs.addTCFTD(cft);
											amt = rateclass*cft;
						ConvertLobs.subTCFTD((new Double((String)getValueAt(row,6))).doubleValue());
						super.setValueAt(new Double(cft).toString(), row, 11);
						super.setValueAt(new Double(cft).toString(), row, 6);
											}
				super.setValueAt(wclass, row, 7);
				super.setValueAt(new Double(rateclass), row, 8);
				ConvertLobs.addAmount(amt);
				super.setValueAt(new Double(amt), row, 10);
				ConvertLobs.addTCFT(cft);

			}

			if (col == 12){// get row vector and get tcft
			Double temp= new Double((String)getValueAt(row, col-1));
			ConvertLobs.subTCFT(temp.doubleValue());
			Double temp1= new Double((String)getValueAt(row, col-2));
			ConvertLobs.subAmount(temp1.doubleValue());
			Integer temp2= (Integer)getValueAt(row, col-3);
			ConvertLobs.subQuantity(temp2.intValue());
			ConvertLobs.sno--;
			for (int i=row-1;  i >= 0; i--) super.setValueAt(new Integer( ((Integer)getValueAt(i,0)).intValue() - 1 ), i, 0);

			String cl = (String)getValueAt(row, col-5);//
			if (cl.equals("A")) ConvertLobs.subTCFTA(temp.doubleValue());
			if (cl.equals("B")) ConvertLobs.subTCFTB(temp.doubleValue());
			if (cl.equals("C")) ConvertLobs.subTCFTC(temp.doubleValue());
			if (cl.equals("D")) ConvertLobs.subTCFTD(temp.doubleValue());

							removeRow(row);
			}
			if (col == 0){
				ConvertLobs.sno = ((Integer)getValueAt(row,col)).intValue();
			}

		}

	}
}