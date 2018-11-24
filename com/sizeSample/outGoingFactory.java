package com.sizeSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* Provides convenience methods for creating Java beans for elements
* in this XML document
*/
public class outGoingFactory extends Factory
{
  public outGoingFactory()
  {
    super();
  }
  
  /**
  * Create the Java bean outGoing for the root element
  *   @param rootElementname The tag for the root element
  *   @return outGoing The Java bean representing this element
  */
  public outGoing createRoot(String rootElementname)
  {
    return (outGoing) createRootDOMFromComplexType("outGoing",rootElementname);
  }
  
  /**
  * Create the Java bean outGoing by loading the XML file
  *   @param filename The XML file name
  *   @return outGoing The Java bean representing the root element
  */
  public outGoing loadDocument(String filename)
  {
    return (outGoing) loadDocument("outGoing",filename);
  }
  
  /**
  * Create the Java bean Battons for the element
  *   @param elementName The tag for the element
  *   @return Battons The Java bean representing this element
  */
  public Battons createBattons(String elementName)
  {
    return (Battons) createDOMElementFromSimpleType("Battons",elementName);
  }
  
  /**
  * Create the Java bean FirmDetails for the element
  *   @param elementName The tag for the element
  *   @return FirmDetails The Java bean representing this element
  */
  public FirmDetails createFirmDetails(String elementName)
  {
    return (FirmDetails) createDOMElementFromComplexType("FirmDetails",elementName);
  }
  
  /**
  * Create the Java bean Lapha for the element
  *   @param elementName The tag for the element
  *   @return Lapha The Java bean representing this element
  */
  public Lapha createLapha(String elementName)
  {
    return (Lapha) createDOMElementFromSimpleType("Lapha",elementName);
  }
  
  /**
  * Create the Java bean Others for the element
  *   @param elementName The tag for the element
  *   @return Others The Java bean representing this element
  */
  public Others createOthers(String elementName)
  {
    return (Others) createDOMElementFromSimpleType("Others",elementName);
  }
  
  /**
  * Create the Java bean Runners for the element
  *   @param elementName The tag for the element
  *   @return Runners The Java bean representing this element
  */
  public Runners createRunners(String elementName)
  {
    return (Runners) createDOMElementFromSimpleType("Runners",elementName);
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
  * Create the Java bean articles for the element
  *   @param elementName The tag for the element
  *   @return articles The Java bean representing this element
  */
  public articles createarticles(String elementName)
  {
    return (articles) createDOMElementFromSimpleType("articles",elementName);
  }
  
  /**
  * Create the Java bean billNo for the element
  *   @param elementName The tag for the element
  *   @return billNo The Java bean representing this element
  */
  public billNo createbillNo(String elementName)
  {
    return (billNo) createDOMElementFromSimpleType("billNo",elementName);
  }
  
  /**
  * Create the Java bean cft for the element
  *   @param elementName The tag for the element
  *   @return cft The Java bean representing this element
  */
  public cft createcft(String elementName)
  {
    return (cft) createDOMElementFromSimpleType("cft",elementName);
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
  * Create the Java bean length for the element
  *   @param elementName The tag for the element
  *   @return length The Java bean representing this element
  */
  public length createlength(String elementName)
  {
    return (length) createDOMElementFromSimpleType("length",elementName);
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
  * Create the Java bean loadTotal for the element
  *   @param elementName The tag for the element
  *   @return loadTotal The Java bean representing this element
  */
  public loadTotal createloadTotal(String elementName)
  {
    return (loadTotal) createDOMElementFromComplexType("loadTotal",elementName);
  }
  
  /**
  * Create the Java bean lorryName for the element
  *   @param elementName The tag for the element
  *   @return lorryName The Java bean representing this element
  */
  public lorryName createlorryName(String elementName)
  {
    return (lorryName) createDOMElementFromSimpleType("lorryName",elementName);
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
  * Create the Java bean outGoing for the element
  *   @param elementName The tag for the element
  *   @return outGoing The Java bean representing this element
  */
  public outGoing createoutGoing(String elementName)
  {
    return (outGoing) createDOMElementFromComplexType("outGoing",elementName);
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
  * Create the Java bean qnt for the element
  *   @param elementName The tag for the element
  *   @return qnt The Java bean representing this element
  */
  public qnt createqnt(String elementName)
  {
    return (qnt) createDOMElementFromSimpleType("qnt",elementName);
  }
  
  /**
  * Create the Java bean rft for the element
  *   @param elementName The tag for the element
  *   @return rft The Java bean representing this element
  */
  public rft createrft(String elementName)
  {
    return (rft) createDOMElementFromSimpleType("rft",elementName);
  }
  
  /**
  * Create the Java bean rowData for the element
  *   @param elementName The tag for the element
  *   @return rowData The Java bean representing this element
  */
  public rowData createrowData(String elementName)
  {
    return (rowData) createDOMElementFromComplexType("rowData",elementName);
  }
  
  /**
  * Create the Java bean sizeData for the element
  *   @param elementName The tag for the element
  *   @return sizeData The Java bean representing this element
  */
  public sizeData createsizeData(String elementName)
  {
    return (sizeData) createDOMElementFromComplexType("sizeData",elementName);
  }
  
  /**
  * Create the Java bean sizeTotal for the element
  *   @param elementName The tag for the element
  *   @return sizeTotal The Java bean representing this element
  */
  public sizeTotal createsizeTotal(String elementName)
  {
    return (sizeTotal) createDOMElementFromComplexType("sizeTotal",elementName);
  }
  
  /**
  * Create the Java bean thinkness for the element
  *   @param elementName The tag for the element
  *   @return thinkness The Java bean representing this element
  */
  public thinkness createthinkness(String elementName)
  {
    return (thinkness) createDOMElementFromSimpleType("thinkness",elementName);
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
  
  /**
  * Create the Java bean type for the element
  *   @param elementName The tag for the element
  *   @return type The Java bean representing this element
  */
  public type createtype(String elementName)
  {
    return (type) createDOMElementFromSimpleType("type",elementName);
  }
  
  /**
  * Create the Java bean width for the element
  *   @param elementName The tag for the element
  *   @return width The Java bean representing this element
  */
  public width createwidth(String elementName)
  {
    return (width) createDOMElementFromSimpleType("width",elementName);
  }
  
}

