/*
 * Created on Mar 29, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.myself;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.JTable;

/**
 * @author pbijjala
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FileSupport {
	public String fileName;
	
	public String getFileNameFromDay(Date date){
		return fileName;
	}
	public JTable populateJTable (String fname){
		
		FileReader fr;
		try {
			fr = new FileReader("name of file");
			BufferedReader br = new BufferedReader(fr);
			Hashtable ht = new Hashtable();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		return null;
	}
	public void saveToFile (JTable jt, String fname){
	}
	
	// constructor
	public FileSupport() {
		super();
	}
}
