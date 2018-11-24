package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <outGoing>
*/
public class outGoing extends ComplexType
{
  public outGoing()
  {
  }
  
  public void setFirmDetails(FirmDetails FirmDetails)
  {
    setElementValue("FirmDetails", FirmDetails);
  }
  
  public FirmDetails getFirmDetails()
  {
    return (FirmDetails) getElementValue("FirmDetails", "FirmDetails");
  }
  
  public boolean removeFirmDetails()
  {
    return removeElement("FirmDetails");
  }
  
  public void setRowData(int index, rowData rowData)
  {
    setElementValue(index, "rowData", rowData);
  }
  
  public rowData getRowData(int index)
  {
    return (rowData) getElementValue("rowData", "rowData", index);
  }
  
  public int getrowDataCount()
  {
    return sizeOfElement("rowData");
  }
  
  public boolean removeRowData(int index)
  {
    return removeElement(index, "rowData");
  }
  
  public void setSizeTotal(sizeTotal sizeTotal)
  {
    setElementValue("sizeTotal", sizeTotal);
  }
  
  public sizeTotal getSizeTotal()
  {
    return (sizeTotal) getElementValue("sizeTotal", "sizeTotal");
  }
  
  public boolean removeSizeTotal()
  {
    return removeElement("sizeTotal");
  }
  
}

