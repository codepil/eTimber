package com.firmSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* Provides convenience methods for creating Java beans for elements
* in this XML document
*/
public class firmFactory extends Factory
{
  public firmFactory()
  {
    super();
  }
  
  /**
  * Create the Java bean firm for the root element
  *   @param rootElementname The tag for the root element
  *   @return firm The Java bean representing this element
  */
  public firm createRoot(String rootElementname)
  {
    return (firm) createRootDOMFromComplexType("firm",rootElementname);
  }
  
  /**
  * Create the Java bean firm by loading the XML file
  *   @param filename The XML file name
  *   @return firm The Java bean representing the root element
  */
  public firm loadDocument(String filename)
  {
    return (firm) loadDocument("firm",filename);
  }
  
  /**
  * Create the Java bean SLR for the element
  *   @param elementName The tag for the element
  *   @return SLR The Java bean representing this element
  */
  public SLR createSLR(String elementName)
  {
    return (SLR) createDOMElementFromSimpleType("SLR",elementName);
  }
  
  /**
  * Create the Java bean amount for the element
  *   @param elementName The tag for the element
  *   @return amount The Java bean representing this element
  */
  public amount createamount(String elementName)
  {
    return (amount) createDOMElementFromSimpleType("amount",elementName);
  }
  
  /**
  * Create the Java bean battons for the element
  *   @param elementName The tag for the element
  *   @return battons The Java bean representing this element
  */
  public battons createbattons(String elementName)
  {
    return (battons) createDOMElementFromSimpleType("battons",elementName);
  }
  
  /**
  * Create the Java bean details for the element
  *   @param elementName The tag for the element
  *   @return details The Java bean representing this element
  */
  public details createdetails(String elementName)
  {
    return (details) createDOMElementFromComplexType("details",elementName);
  }
  
  /**
  * Create the Java bean dis for the element
  *   @param elementName The tag for the element
  *   @return dis The Java bean representing this element
  */
  public dis createdis(String elementName)
  {
    return (dis) createDOMElementFromSimpleType("dis",elementName);
  }
  
  /**
  * Create the Java bean firm for the element
  *   @param elementName The tag for the element
  *   @return firm The Java bean representing this element
  */
  public firm createfirm(String elementName)
  {
    return (firm) createDOMElementFromComplexType("firm",elementName);
  }
  
  /**
  * Create the Java bean firmAddress for the element
  *   @param elementName The tag for the element
  *   @return firmAddress The Java bean representing this element
  */
  public firmAddress createfirmAddress(String elementName)
  {
    return (firmAddress) createDOMElementFromSimpleType("firmAddress",elementName);
  }
  
  /**
  * Create the Java bean firmName for the element
  *   @param elementName The tag for the element
  *   @return firmName The Java bean representing this element
  */
  public firmName createfirmName(String elementName)
  {
    return (firmName) createDOMElementFromSimpleType("firmName",elementName);
  }
  
  /**
  * Create the Java bean lapha for the element
  *   @param elementName The tag for the element
  *   @return lapha The Java bean representing this element
  */
  public lapha createlapha(String elementName)
  {
    return (lapha) createDOMElementFromSimpleType("lapha",elementName);
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
  * Create the Java bean loadDate for the element
  *   @param elementName The tag for the element
  *   @return loadDate The Java bean representing this element
  */
  public loadDate createloadDate(String elementName)
  {
    return (loadDate) createDOMElementFromSimpleType("loadDate",elementName);
  }
  
  /**
  * Create the Java bean loadName for the element
  *   @param elementName The tag for the element
  *   @return loadName The Java bean representing this element
  */
  public loadName createloadName(String elementName)
  {
    return (loadName) createDOMElementFromSimpleType("loadName",elementName);
  }
  
  /**
  * Create the Java bean orderNo for the element
  *   @param elementName The tag for the element
  *   @return orderNo The Java bean representing this element
  */
  public orderNo createorderNo(String elementName)
  {
    return (orderNo) createDOMElementFromSimpleType("orderNo",elementName);
  }
  
  /**
  * Create the Java bean others for the element
  *   @param elementName The tag for the element
  *   @return others The Java bean representing this element
  */
  public others createothers(String elementName)
  {
    return (others) createDOMElementFromSimpleType("others",elementName);
  }
  
  /**
  * Create the Java bean planks for the element
  *   @param elementName The tag for the element
  *   @return planks The Java bean representing this element
  */
  public planks createplanks(String elementName)
  {
    return (planks) createDOMElementFromSimpleType("planks",elementName);
  }
  
  /**
  * Create the Java bean runners for the element
  *   @param elementName The tag for the element
  *   @return runners The Java bean representing this element
  */
  public runners createrunners(String elementName)
  {
    return (runners) createDOMElementFromSimpleType("runners",elementName);
  }
  
  /**
  * Create the Java bean sno for the element
  *   @param elementName The tag for the element
  *   @return sno The Java bean representing this element
  */
  public sno createsno(String elementName)
  {
    return (sno) createDOMElementFromSimpleType("sno",elementName);
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
  
  /**
  * Create the Java bean tlc for the element
  *   @param elementName The tag for the element
  *   @return tlc The Java bean representing this element
  */
  public tlc createtlc(String elementName)
  {
    return (tlc) createDOMElementFromSimpleType("tlc",elementName);
  }
  
  /**
  * Create the Java bean totalCFT for the element
  *   @param elementName The tag for the element
  *   @return totalCFT The Java bean representing this element
  */
  public totalCFT createtotalCFT(String elementName)
  {
    return (totalCFT) createDOMElementFromSimpleType("totalCFT",elementName);
  }
  
}

