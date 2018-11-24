package com.loadSample;

import java.util.*;
import java.text.DateFormat;
import com.ibm.etools.xmlschema.beans.*;

/**
* Provides convenience methods for creating Java beans for elements
* in this XML document
*/
public class incomingLobsFactory extends Factory
{
  public incomingLobsFactory()
  {
    super();
  }
  
  /**
  * Create the Java bean incomingLobs for the root element
  *   @param rootElementname The tag for the root element
  *   @return incomingLobs The Java bean representing this element
  */
  public incomingLobs createRoot(String rootElementname)
  {
    return (incomingLobs) createRootDOMFromComplexType("incomingLobs",rootElementname);
  }
  
  /**
  * Create the Java bean incomingLobs by loading the XML file
  *   @param filename The XML file name
  *   @return incomingLobs The Java bean representing the root element
  */
  public incomingLobs loadDocument(String filename)
  {
    return (incomingLobs) loadDocument("incomingLobs",filename);
  }
  
  /**
  * Create the Java bean Amount for the element
  *   @param elementName The tag for the element
  *   @return Amount The Java bean representing this element
  */
  public Amount createAmount(String elementName)
  {
    return (Amount) createDOMElementFromSimpleType("Amount",elementName);
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
  * Create the Java bean ClassAcft for the element
  *   @param elementName The tag for the element
  *   @return ClassAcft The Java bean representing this element
  */
  public ClassAcft createClassAcft(String elementName)
  {
    return (ClassAcft) createDOMElementFromSimpleType("ClassAcft",elementName);
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
  * Create the Java bean ClassBcft for the element
  *   @param elementName The tag for the element
  *   @return ClassBcft The Java bean representing this element
  */
  public ClassBcft createClassBcft(String elementName)
  {
    return (ClassBcft) createDOMElementFromSimpleType("ClassBcft",elementName);
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
  * Create the Java bean ClassCcft for the element
  *   @param elementName The tag for the element
  *   @return ClassCcft The Java bean representing this element
  */
  public ClassCcft createClassCcft(String elementName)
  {
    return (ClassCcft) createDOMElementFromSimpleType("ClassCcft",elementName);
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
  * Create the Java bean ClassDcft for the element
  *   @param elementName The tag for the element
  *   @return ClassDcft The Java bean representing this element
  */
  public ClassDcft createClassDcft(String elementName)
  {
    return (ClassDcft) createDOMElementFromSimpleType("ClassDcft",elementName);
  }
  
  /**
  * Create the Java bean Girth for the element
  *   @param elementName The tag for the element
  *   @return Girth The Java bean representing this element
  */
  public Girth createGirth(String elementName)
  {
    return (Girth) createDOMElementFromSimpleType("Girth",elementName);
  }
  
  /**
  * Create the Java bean Length for the element
  *   @param elementName The tag for the element
  *   @return Length The Java bean representing this element
  */
  public Length createLength(String elementName)
  {
    return (Length) createDOMElementFromSimpleType("Length",elementName);
  }
  
  /**
  * Create the Java bean Lobs for the element
  *   @param elementName The tag for the element
  *   @return Lobs The Java bean representing this element
  */
  public Lobs createLobs(String elementName)
  {
    return (Lobs) createDOMElementFromSimpleType("Lobs",elementName);
  }
  
  /**
  * Create the Java bean Quantity for the element
  *   @param elementName The tag for the element
  *   @return Quantity The Java bean representing this element
  */
  public Quantity createQuantity(String elementName)
  {
    return (Quantity) createDOMElementFromSimpleType("Quantity",elementName);
  }
  
  /**
  * Create the Java bean Rate for the element
  *   @param elementName The tag for the element
  *   @return Rate The Java bean representing this element
  */
  public Rate createRate(String elementName)
  {
    return (Rate) createDOMElementFromSimpleType("Rate",elementName);
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
  * Create the Java bean TotalCFT for the element
  *   @param elementName The tag for the element
  *   @return TotalCFT The Java bean representing this element
  */
  public TotalCFT createTotalCFT(String elementName)
  {
    return (TotalCFT) createDOMElementFromSimpleType("TotalCFT",elementName);
  }
  
  /**
  * Create the Java bean date for the element
  *   @param elementName The tag for the element
  *   @return date The Java bean representing this element
  */
  public date createdate(String elementName)
  {
    return (date) createDOMElementFromSimpleType("date",elementName);
  }
  
  /**
  * Create the Java bean estateName for the element
  *   @param elementName The tag for the element
  *   @return estateName The Java bean representing this element
  */
  public estateName createestateName(String elementName)
  {
    return (estateName) createDOMElementFromSimpleType("estateName",elementName);
  }
  
  /**
  * Create the Java bean incomingLobs for the element
  *   @param elementName The tag for the element
  *   @return incomingLobs The Java bean representing this element
  */
  public incomingLobs createincomingLobs(String elementName)
  {
    return (incomingLobs) createDOMElementFromComplexType("incomingLobs",elementName);
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
  * Create the Java bean loadDetails for the element
  *   @param elementName The tag for the element
  *   @return loadDetails The Java bean representing this element
  */
  public loadDetails createloadDetails(String elementName)
  {
    return (loadDetails) createDOMElementFromComplexType("loadDetails",elementName);
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
  * Create the Java bean tAmount for the element
  *   @param elementName The tag for the element
  *   @return tAmount The Java bean representing this element
  */
  public tAmount createtAmount(String elementName)
  {
    return (tAmount) createDOMElementFromSimpleType("tAmount",elementName);
  }
  
  /**
  * Create the Java bean tCFT for the element
  *   @param elementName The tag for the element
  *   @return tCFT The Java bean representing this element
  */
  public tCFT createtCFT(String elementName)
  {
    return (tCFT) createDOMElementFromSimpleType("tCFT",elementName);
  }
  
  /**
  * Create the Java bean total for the element
  *   @param elementName The tag for the element
  *   @return total The Java bean representing this element
  */
  public total createtotal(String elementName)
  {
    return (total) createDOMElementFromComplexType("total",elementName);
  }
  
}

