package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <load>
*/
public class load extends ComplexType
{
  public load()
  {
  }
  
  public void setLength(String length)
  {
    setElementValue("length", length);
  }
  
  public String getLength()
  {
    return getElementValue("length");
  }
  
  public boolean removeLength()
  {
    return removeElement("length");
  }
  
  public void setWidth(String width)
  {
    setElementValue("width", width);
  }
  
  public String getWidth()
  {
    return getElementValue("width");
  }
  
  public boolean removeWidth()
  {
    return removeElement("width");
  }
  
  public void setThinkness(String thinkness)
  {
    setElementValue("thinkness", thinkness);
  }
  
  public String getThinkness()
  {
    return getElementValue("thinkness");
  }
  
  public boolean removeThinkness()
  {
    return removeElement("thinkness");
  }
  
  public void setQnt(String qnt)
  {
    setElementValue("qnt", qnt);
  }
  
  public String getQnt()
  {
    return getElementValue("qnt");
  }
  
  public boolean removeQnt()
  {
    return removeElement("qnt");
  }
  
  public void setRft(String rft)
  {
    setElementValue("rft", rft);
  }
  
  public String getRft()
  {
    return getElementValue("rft");
  }
  
  public boolean removeRft()
  {
    return removeElement("rft");
  }
  
  public void setCft(String cft)
  {
    setElementValue("cft", cft);
  }
  
  public String getCft()
  {
    return getElementValue("cft");
  }
  
  public boolean removeCft()
  {
    return removeElement("cft");
  }
  
}

