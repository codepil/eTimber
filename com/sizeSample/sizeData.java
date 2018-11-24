package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <sizeData>
*/
public class sizeData extends ComplexType
{
  public sizeData()
  {
  }
  
  public void setLoad(int index, load load)
  {
    setElementValue(index, "load", load);
  }
  
  public load getLoad(int index)
  {
    return (load) getElementValue("load", "load", index);
  }
  
  public int getloadCount()
  {
    return sizeOfElement("load");
  }
  
  public boolean removeLoad(int index)
  {
    return removeElement(index, "load");
  }
  
  public void setLoadTotal(loadTotal loadTotal)
  {
    setElementValue("loadTotal", loadTotal);
  }
  
  public loadTotal getLoadTotal()
  {
    return (loadTotal) getElementValue("loadTotal", "loadTotal");
  }
  
  public boolean removeLoadTotal()
  {
    return removeElement("loadTotal");
  }
  
}

