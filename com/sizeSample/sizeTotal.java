package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <sizeTotal>
*/
public class sizeTotal extends ComplexType
{
  public sizeTotal()
  {
  }
  
  public void setPlanks(String planks)
  {
    setElementValue("planks", planks);
  }
  
  public String getPlanks()
  {
    return getElementValue("planks");
  }
  
  public boolean removePlanks()
  {
    return removeElement("planks");
  }
  
  public void setRunners(String Runners)
  {
    setElementValue("Runners", Runners);
  }
  
  public String getRunners()
  {
    return getElementValue("Runners");
  }
  
  public boolean removeRunners()
  {
    return removeElement("Runners");
  }
  
  public void setBattons(String Battons)
  {
    setElementValue("Battons", Battons);
  }
  
  public String getBattons()
  {
    return getElementValue("Battons");
  }
  
  public boolean removeBattons()
  {
    return removeElement("Battons");
  }
  
  public void setSLR(String SLR)
  {
    setElementValue("SLR", SLR);
  }
  
  public String getSLR()
  {
    return getElementValue("SLR");
  }
  
  public boolean removeSLR()
  {
    return removeElement("SLR");
  }
  
  public void setLapha(String Lapha)
  {
    setElementValue("Lapha", Lapha);
  }
  
  public String getLapha()
  {
    return getElementValue("Lapha");
  }
  
  public boolean removeLapha()
  {
    return removeElement("Lapha");
  }
  
  public void setOthers(String Others)
  {
    setElementValue("Others", Others);
  }
  
  public String getOthers()
  {
    return getElementValue("Others");
  }
  
  public boolean removeOthers()
  {
    return removeElement("Others");
  }
  
  public void setTotalCFT(String totalCFT)
  {
    setElementValue("totalCFT", totalCFT);
  }
  
  public String getTotalCFT()
  {
    return getElementValue("totalCFT");
  }
  
  public boolean removeTotalCFT()
  {
    return removeElement("totalCFT");
  }
  
}

