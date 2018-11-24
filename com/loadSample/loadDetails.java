package com.loadSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <loadDetails>
*/
public class loadDetails extends ComplexType
{
  public loadDetails()
  {
  }
  
  public void setLorryName(String lorryName)
  {
    setElementValue("lorryName", lorryName);
  }
  
  public String getLorryName()
  {
    return getElementValue("lorryName");
  }
  
  public boolean removeLorryName()
  {
    return removeElement("lorryName");
  }
  
  public void setEstateName(String estateName)
  {
    setElementValue("estateName", estateName);
  }
  
  public String getEstateName()
  {
    return getElementValue("estateName");
  }
  
  public boolean removeEstateName()
  {
    return removeElement("estateName");
  }
  
  public void setDate(String date)
  {
    setElementValue("date", date);
  }
  
  public String getDate()
  {
    return getElementValue("date");
  }
  
  public boolean removeDate()
  {
    return removeElement("date");
  }
  
}

