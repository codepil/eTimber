package com.estateSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <Estate>
*/
public class Estate extends ComplexType
{
  public Estate()
  {
  }
  
  public void setPlanterName(String PlanterName)
  {
    setElementValue("PlanterName", PlanterName);
  }
  
  public String getPlanterName()
  {
    return getElementValue("PlanterName");
  }
  
  public boolean removePlanterName()
  {
    return removeElement("PlanterName");
  }
  
  public void setPlantAddress(String PlantAddress)
  {
    setElementValue("PlantAddress", PlantAddress);
  }
  
  public String getPlantAddress()
  {
    return getElementValue("PlantAddress");
  }
  
  public boolean removePlantAddress()
  {
    return removeElement("PlantAddress");
  }
  
  public void setSyNo(String SyNo)
  {
    setElementValue("SyNo", SyNo);
  }
  
  public String getSyNo()
  {
    return getElementValue("SyNo");
  }
  
  public boolean removeSyNo()
  {
    return removeElement("SyNo");
  }
  
  public void setCoupContractor(String CoupContractor)
  {
    setElementValue("CoupContractor", CoupContractor);
  }
  
  public String getCoupContractor()
  {
    return getElementValue("CoupContractor");
  }
  
  public boolean removeCoupContractor()
  {
    return removeElement("CoupContractor");
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
  
  public void setDiscount(String discount)
  {
    setElementValue("discount", discount);
  }
  
  public String getDiscount()
  {
    return getElementValue("discount");
  }
  
  public boolean removeDiscount()
  {
    return removeElement("discount");
  }
  
  public void setDisTcft(String disTcft)
  {
    setElementValue("disTcft", disTcft);
  }
  
  public String getDisTcft()
  {
    return getElementValue("disTcft");
  }
  
  public boolean removeDisTcft()
  {
    return removeElement("disTcft");
  }
  
}

