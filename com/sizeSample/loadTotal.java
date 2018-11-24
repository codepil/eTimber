package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <loadTotal>
*/
public class loadTotal extends ComplexType
{
  public loadTotal()
  {
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
  
  public void setType(String type)
  {
    setElementValue("type", type);
  }
  
  public String getType()
  {
    return getElementValue("type");
  }
  
  public boolean removeType()
  {
    return removeElement("type");
  }
  
}

