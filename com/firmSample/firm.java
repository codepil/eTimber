package com.firmSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <firm>
*/
public class firm extends ComplexType
{
  public firm()
  {
  }
  
  public void setDetails(details details)
  {
    setElementValue("details", details);
  }
  
  public details getDetails()
  {
    return (details) getElementValue("details", "details");
  }
  
  public boolean removeDetails()
  {
    return removeElement("details");
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

