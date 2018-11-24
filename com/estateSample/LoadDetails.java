package com.estateSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <LoadDetails>
*/
public class LoadDetails extends ComplexType
{
  public LoadDetails()
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
  
}

