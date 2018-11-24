package com.estateSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* This class represents the complex type <Incoming>
*/
public class Incoming extends ComplexType
{
  public Incoming()
  {
  }
  
  public void setEstate(Estate Estate)
  {
    setElementValue("Estate", Estate);
  }
  
  public Estate getEstate()
  {
    return (Estate) getElementValue("Estate", "Estate");
  }
  
  public boolean removeEstate()
  {
    return removeElement("Estate");
  }
  
  public void setLoadDetails(LoadDetails LoadDetails)
  {
    setElementValue("LoadDetails", LoadDetails);
  }
  
  public LoadDetails getLoadDetails()
  {
    return (LoadDetails) getElementValue("LoadDetails", "LoadDetails");
  }
  
  public boolean removeLoadDetails()
  {
    return removeElement("LoadDetails");
  }
  
}

