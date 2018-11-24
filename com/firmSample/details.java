package com.firmSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <details>
*/
public class details extends ComplexType
{
  public details()
  {
  }
  
  public void setFirmName(String firmName)
  {
    setElementValue("firmName", firmName);
  }
  
  public String getFirmName()
  {
    return getElementValue("firmName");
  }
  
  public boolean removeFirmName()
  {
    return removeElement("firmName");
  }
  
  public void setFirmAddress(String firmAddress)
  {
    setElementValue("firmAddress", firmAddress);
  }
  
  public String getFirmAddress()
  {
    return getElementValue("firmAddress");
  }
  
  public boolean removeFirmAddress()
  {
    return removeElement("firmAddress");
  }
  
  public void setTcft(String tcft)
  {
    setElementValue("tcft", tcft);
  }
  
  public String getTcft()
  {
    return getElementValue("tcft");
  }
  
  public boolean removeTcft()
  {
    return removeElement("tcft");
  }
  
  public void setTlc(String tlc)
  {
    setElementValue("tlc", tlc);
  }
  
  public String getTlc()
  {
    return getElementValue("tlc");
  }
  
  public boolean removeTlc()
  {
    return removeElement("tlc");
  }
  
  public void setDis(String dis)
  {
    setElementValue("dis", dis);
  }
  
  public String getDis()
  {
    return getElementValue("dis");
  }
  
  public boolean removeDis()
  {
    return removeElement("dis");
  }
  
}

