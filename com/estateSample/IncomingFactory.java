package com.estateSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* Provides convenience methods for creating Java beans for elements
* in this XML document
*/
public class IncomingFactory extends Factory
{
  public IncomingFactory()
  {
    super();
  }
  
  /**
  * Create the Java bean Incoming for the root element
  *   @param rootElementname The tag for the root element
  *   @return Incoming The Java bean representing this element
  */
  public Incoming createRoot(String rootElementname)
  {
    return (Incoming) createRootDOMFromComplexType("Incoming",rootElementname);
  }
  
  /**
  * Create the Java bean Incoming by loading the XML file
  *   @param filename The XML file name
  *   @return Incoming The Java bean representing the root element
  */
  public Incoming loadDocument(String filename)
  {
    return (Incoming) loadDocument("Incoming",filename);
  }
  
  /**
  * Create the Java bean ClassA for the element
  *   @param elementName The tag for the element
  *   @return ClassA The Java bean representing this element
  */
  public ClassA createClassA(String elementName)
  {
    return (ClassA) createDOMElementFromSimpleType("ClassA",elementName);
  }
  
  /**
  * Create the Java bean ClassB for the element
  *   @param elementName The tag for the element
  *   @return ClassB The Java bean representing this element
  */
  public ClassB createClassB(String elementName)
  {
    return (ClassB) createDOMElementFromSimpleType("ClassB",elementName);
  }
  
  /**
  * Create the Java bean ClassC for the element
  *   @param elementName The tag for the element
  *   @return ClassC The Java bean representing this element
  */
  public ClassC createClassC(String elementName)
  {
    return (ClassC) createDOMElementFromSimpleType("ClassC",elementName);
  }
  
  /**
  * Create the Java bean ClassD for the element
  *   @param elementName The tag for the element
  *   @return ClassD The Java bean representing this element
  */
  public ClassD createClassD(String elementName)
  {
    return (ClassD) createDOMElementFromSimpleType("ClassD",elementName);
  }
  
  /**
  * Create the Java bean Clerk for the element
  *   @param elementName The tag for the element
  *   @return Clerk The Java bean representing this element
  */
  public Clerk createClerk(String elementName)
  {
    return (Clerk) createDOMElementFromSimpleType("Clerk",elementName);
  }
  
  /**
  * Create the Java bean CoupContractor for the element
  *   @param elementName The tag for the element
  *   @return CoupContractor The Java bean representing this element
  */
  public CoupContractor createCoupContractor(String elementName)
  {
    return (CoupContractor) createDOMElementFromSimpleType("CoupContractor",elementName);
  }
  
  /**
  * Create the Java bean Date for the element
  *   @param elementName The tag for the element
  *   @return Date The Java bean representing this element
  */
  public Date createDate(String elementName)
  {
    return (Date) createDOMElementFromSimpleType("Date",elementName);
  }
  
  /**
  * Create the Java bean DelNo for the element
  *   @param elementName The tag for the element
  *   @return DelNo The Java bean representing this element
  */
  public DelNo createDelNo(String elementName)
  {
    return (DelNo) createDOMElementFromSimpleType("DelNo",elementName);
  }
  
  /**
  * Create the Java bean Estate for the element
  *   @param elementName The tag for the element
  *   @return Estate The Java bean representing this element
  */
  public Estate createEstate(String elementName)
  {
    return (Estate) createDOMElementFromComplexType("Estate",elementName);
  }
  
  /**
  * Create the Java bean Incoming for the element
  *   @param elementName The tag for the element
  *   @return Incoming The Java bean representing this element
  */
  public Incoming createIncoming(String elementName)
  {
    return (Incoming) createDOMElementFromComplexType("Incoming",elementName);
  }
  
  /**
  * Create the Java bean LoadDetails for the element
  *   @param elementName The tag for the element
  *   @return LoadDetails The Java bean representing this element
  */
  public LoadDetails createLoadDetails(String elementName)
  {
    return (LoadDetails) createDOMElementFromComplexType("LoadDetails",elementName);
  }
  
  /**
  * Create the Java bean Logs for the element
  *   @param elementName The tag for the element
  *   @return Logs The Java bean representing this element
  */
  public Logs createLogs(String elementName)
  {
    return (Logs) createDOMElementFromSimpleType("Logs",elementName);
  }
  
  /**
  * Create the Java bean LorryNumber for the element
  *   @param elementName The tag for the element
  *   @return LorryNumber The Java bean representing this element
  */
  public LorryNumber createLorryNumber(String elementName)
  {
    return (LorryNumber) createDOMElementFromSimpleType("LorryNumber",elementName);
  }
  
  /**
  * Create the Java bean PlantAddress for the element
  *   @param elementName The tag for the element
  *   @return PlantAddress The Java bean representing this element
  */
  public PlantAddress createPlantAddress(String elementName)
  {
    return (PlantAddress) createDOMElementFromSimpleType("PlantAddress",elementName);
  }
  
  /**
  * Create the Java bean PlanterName for the element
  *   @param elementName The tag for the element
  *   @return PlanterName The Java bean representing this element
  */
  public PlanterName createPlanterName(String elementName)
  {
    return (PlanterName) createDOMElementFromSimpleType("PlanterName",elementName);
  }
  
  /**
  * Create the Java bean SNo for the element
  *   @param elementName The tag for the element
  *   @return SNo The Java bean representing this element
  */
  public SNo createSNo(String elementName)
  {
    return (SNo) createDOMElementFromSimpleType("SNo",elementName);
  }
  
  /**
  * Create the Java bean Stumps for the element
  *   @param elementName The tag for the element
  *   @return Stumps The Java bean representing this element
  */
  public Stumps createStumps(String elementName)
  {
    return (Stumps) createDOMElementFromSimpleType("Stumps",elementName);
  }
  
  /**
  * Create the Java bean SyNo for the element
  *   @param elementName The tag for the element
  *   @return SyNo The Java bean representing this element
  */
  public SyNo createSyNo(String elementName)
  {
    return (SyNo) createDOMElementFromSimpleType("SyNo",elementName);
  }
  
  /**
  * Create the Java bean Tape for the element
  *   @param elementName The tag for the element
  *   @return Tape The Java bean representing this element
  */
  public Tape createTape(String elementName)
  {
    return (Tape) createDOMElementFromSimpleType("Tape",elementName);
  }
  
  /**
  * Create the Java bean TotalCFT for the element
  *   @param elementName The tag for the element
  *   @return TotalCFT The Java bean representing this element
  */
  public TotalCFT createTotalCFT(String elementName)
  {
    return (TotalCFT) createDOMElementFromSimpleType("TotalCFT",elementName);
  }
  
  /**
  * Create the Java bean Unload for the element
  *   @param elementName The tag for the element
  *   @return Unload The Java bean representing this element
  */
  public Unload createUnload(String elementName)
  {
    return (Unload) createDOMElementFromSimpleType("Unload",elementName);
  }
  
  /**
  * Create the Java bean disTcft for the element
  *   @param elementName The tag for the element
  *   @return disTcft The Java bean representing this element
  */
  public disTcft createdisTcft(String elementName)
  {
    return (disTcft) createDOMElementFromSimpleType("disTcft",elementName);
  }
  
  /**
  * Create the Java bean discount for the element
  *   @param elementName The tag for the element
  *   @return discount The Java bean representing this element
  */
  public discount creatediscount(String elementName)
  {
    return (discount) createDOMElementFromSimpleType("discount",elementName);
  }
  
  /**
  * Create the Java bean load for the element
  *   @param elementName The tag for the element
  *   @return load The Java bean representing this element
  */
  public load createload(String elementName)
  {
    return (load) createDOMElementFromComplexType("load",elementName);
  }
  
  /**
  * Create the Java bean tcft for the element
  *   @param elementName The tag for the element
  *   @return tcft The Java bean representing this element
  */
  public tcft createtcft(String elementName)
  {
    return (tcft) createDOMElementFromSimpleType("tcft",elementName);
  }
  
}

