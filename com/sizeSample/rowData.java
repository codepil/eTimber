package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <rowData>
*/
public class rowData extends ComplexType
{
  public rowData()
  {
  }
  
  public void setSizeData(int index, sizeData sizeData)
  {
    setElementValue(index, "sizeData", sizeData);
  }
  
  public sizeData getSizeData(int index)
  {
    return (sizeData) getElementValue("sizeData", "sizeData", index);
  }
  
  public int getsizeDataCount()
  {
    return sizeOfElement("sizeData");
  }
  
  public boolean removeSizeData(int index)
  {
    return removeElement(index, "sizeData");
  }
  
}

