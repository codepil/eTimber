package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <FirmDetails>
*/
public class FirmDetails extends ComplexType
{
  public FirmDetails()
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
  
  public void setBillNo(String billNo)
  {
    setElementValue("billNo", billNo);
  }
  
  public String getBillNo()
  {
    return getElementValue("billNo");
  }
  
  public boolean removeBillNo()
  {
    return removeElement("billNo");
  }
  
  public void setOrderNo(String orderNo)
  {
    setElementValue("orderNo", orderNo);
  }
  
  public String getOrderNo()
  {
    return getElementValue("orderNo");
  }
  
  public boolean removeOrderNo()
  {
    return removeElement("orderNo");
  }
  
  public void setArticles(String articles)
  {
    setElementValue("articles", articles);
  }
  
  public String getArticles()
  {
    return getElementValue("articles");
  }
  
  public boolean removeArticles()
  {
    return removeElement("articles");
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
  
  public void setLoadDate(String loadDate)
  {
    setElementValue("loadDate", loadDate);
  }
  
  public String getLoadDate()
  {
    return getElementValue("loadDate");
  }
  
  public boolean removeLoadDate()
  {
    return removeElement("loadDate");
  }
  
}

