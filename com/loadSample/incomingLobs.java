package com.loadSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <incomingLobs>
*/
public class incomingLobs extends ComplexType
{
  public incomingLobs()
  {
  }
  
  public void setLoadDetails(loadDetails loadDetails)
  {
    setElementValue("loadDetails", loadDetails);
  }
  
  public loadDetails getLoadDetails()
  {
    return (loadDetails) getElementValue("loadDetails", "loadDetails");
  }
  
  public boolean removeLoadDetails()
  {
    return removeElement("loadDetails");
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
  
  public void setTotal(total total)
  {
    setElementValue("total", total);
  }
  
  public total getTotal()
  {
    return (total) getElementValue("total", "total");
  }
  
  public boolean removeTotal()
  {
    return removeElement("total");
  }
  
}

