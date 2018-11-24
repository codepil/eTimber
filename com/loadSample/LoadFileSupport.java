package com.loadSample;

import com.ibm.etools.xmlschema.beans.*;
import java.util.*;

/**
* A sample program to show how to use the generated Java beans to:
*  - create and save an XML document
*  - load the XML document and print its content
*/
public class LoadFileSupport
{
  incomingLobsFactory iIncomingLobsFactory;
  incomingLobs iIncomingLobs;
  
  public LoadFileSupport()
  {
  }
  
  /**
  * Set the element Amount to the specified value
  *   @param iAmount The Java bean for this element
  *   @return Amount The Java bean
  */
  Amount initAmount(Amount iAmount)
  {
    iAmount.updateElementValue("Amount");
    return iAmount;
  }
  
  /**
  * Print the element value represented by the Java bean Amount
  *   @param iAmount The Java bean for this element
  */
  void printAmount(Amount iAmount)
  {
    System.out.println(iAmount.getElementValue());
  }
  
  /**
  * Set the element ClassA to the specified value
  *   @param iClassA The Java bean for this element
  *   @return ClassA The Java bean
  */
  ClassA initClassA(ClassA iClassA)
  {
    iClassA.updateElementValue("ClassA");
    return iClassA;
  }
  
  /**
  * Print the element value represented by the Java bean ClassA
  *   @param iClassA The Java bean for this element
  */
  void printClassA(ClassA iClassA)
  {
    System.out.println(iClassA.getElementValue());
  }
  
  /**
  * Set the element ClassAcft to the specified value
  *   @param iClassAcft The Java bean for this element
  *   @return ClassAcft The Java bean
  */
  ClassAcft initClassAcft(ClassAcft iClassAcft)
  {
    iClassAcft.updateElementValue("ClassAcft");
    return iClassAcft;
  }
  
  /**
  * Print the element value represented by the Java bean ClassAcft
  *   @param iClassAcft The Java bean for this element
  */
  void printClassAcft(ClassAcft iClassAcft)
  {
    System.out.println(iClassAcft.getElementValue());
  }
  
  /**
  * Set the element ClassB to the specified value
  *   @param iClassB The Java bean for this element
  *   @return ClassB The Java bean
  */
  ClassB initClassB(ClassB iClassB)
  {
    iClassB.updateElementValue("ClassB");
    return iClassB;
  }
  
  /**
  * Print the element value represented by the Java bean ClassB
  *   @param iClassB The Java bean for this element
  */
  void printClassB(ClassB iClassB)
  {
    System.out.println(iClassB.getElementValue());
  }
  
  /**
  * Set the element ClassBcft to the specified value
  *   @param iClassBcft The Java bean for this element
  *   @return ClassBcft The Java bean
  */
  ClassBcft initClassBcft(ClassBcft iClassBcft)
  {
    iClassBcft.updateElementValue("ClassBcft");
    return iClassBcft;
  }
  
  /**
  * Print the element value represented by the Java bean ClassBcft
  *   @param iClassBcft The Java bean for this element
  */
  void printClassBcft(ClassBcft iClassBcft)
  {
    System.out.println(iClassBcft.getElementValue());
  }
  
  /**
  * Set the element ClassC to the specified value
  *   @param iClassC The Java bean for this element
  *   @return ClassC The Java bean
  */
  ClassC initClassC(ClassC iClassC)
  {
    iClassC.updateElementValue("ClassC");
    return iClassC;
  }
  
  /**
  * Print the element value represented by the Java bean ClassC
  *   @param iClassC The Java bean for this element
  */
  void printClassC(ClassC iClassC)
  {
    System.out.println(iClassC.getElementValue());
  }
  
  /**
  * Set the element ClassCcft to the specified value
  *   @param iClassCcft The Java bean for this element
  *   @return ClassCcft The Java bean
  */
  ClassCcft initClassCcft(ClassCcft iClassCcft)
  {
    iClassCcft.updateElementValue("ClassCcft");
    return iClassCcft;
  }
  
  /**
  * Print the element value represented by the Java bean ClassCcft
  *   @param iClassCcft The Java bean for this element
  */
  void printClassCcft(ClassCcft iClassCcft)
  {
    System.out.println(iClassCcft.getElementValue());
  }
  
  /**
  * Set the element ClassD to the specified value
  *   @param iClassD The Java bean for this element
  *   @return ClassD The Java bean
  */
  ClassD initClassD(ClassD iClassD)
  {
    iClassD.updateElementValue("ClassD");
    return iClassD;
  }
  
  /**
  * Print the element value represented by the Java bean ClassD
  *   @param iClassD The Java bean for this element
  */
  void printClassD(ClassD iClassD)
  {
    System.out.println(iClassD.getElementValue());
  }
  
  /**
  * Set the element ClassDcft to the specified value
  *   @param iClassDcft The Java bean for this element
  *   @return ClassDcft The Java bean
  */
  ClassDcft initClassDcft(ClassDcft iClassDcft)
  {
    iClassDcft.updateElementValue("ClassDcft");
    return iClassDcft;
  }
  
  /**
  * Print the element value represented by the Java bean ClassDcft
  *   @param iClassDcft The Java bean for this element
  */
  void printClassDcft(ClassDcft iClassDcft)
  {
    System.out.println(iClassDcft.getElementValue());
  }
  
  /**
  * Set the element Girth to the specified value
  *   @param iGirth The Java bean for this element
  *   @return Girth The Java bean
  */
  Girth initGirth(Girth iGirth)
  {
    iGirth.updateElementValue("Girth");
    return iGirth;
  }
  
  /**
  * Print the element value represented by the Java bean Girth
  *   @param iGirth The Java bean for this element
  */
  void printGirth(Girth iGirth)
  {
    System.out.println(iGirth.getElementValue());
  }
  
  /**
  * Set the element Length to the specified value
  *   @param iLength The Java bean for this element
  *   @return Length The Java bean
  */
  Length initLength(Length iLength)
  {
    iLength.updateElementValue("Length");
    return iLength;
  }
  
  /**
  * Print the element value represented by the Java bean Length
  *   @param iLength The Java bean for this element
  */
  void printLength(Length iLength)
  {
    System.out.println(iLength.getElementValue());
  }
  
  /**
  * Set the element Lobs to the specified value
  *   @param iLobs The Java bean for this element
  *   @return Lobs The Java bean
  */
  Lobs initLobs(Lobs iLobs)
  {
    iLobs.updateElementValue("Lobs");
    return iLobs;
  }
  
  /**
  * Print the element value represented by the Java bean Lobs
  *   @param iLobs The Java bean for this element
  */
  void printLobs(Lobs iLobs)
  {
    System.out.println(iLobs.getElementValue());
  }
  
  /**
  * Set the element Quantity to the specified value
  *   @param iQuantity The Java bean for this element
  *   @return Quantity The Java bean
  */
  Quantity initQuantity(Quantity iQuantity)
  {
    iQuantity.updateElementValue("Quantity");
    return iQuantity;
  }
  
  /**
  * Print the element value represented by the Java bean Quantity
  *   @param iQuantity The Java bean for this element
  */
  void printQuantity(Quantity iQuantity)
  {
    System.out.println(iQuantity.getElementValue());
  }
  
  /**
  * Set the element Rate to the specified value
  *   @param iRate The Java bean for this element
  *   @return Rate The Java bean
  */
  Rate initRate(Rate iRate)
  {
    iRate.updateElementValue("Rate");
    return iRate;
  }
  
  /**
  * Print the element value represented by the Java bean Rate
  *   @param iRate The Java bean for this element
  */
  void printRate(Rate iRate)
  {
    System.out.println(iRate.getElementValue());
  }
  
  /**
  * Set the element SNo to the specified value
  *   @param iSNo The Java bean for this element
  *   @return SNo The Java bean
  */
  SNo initSNo(SNo iSNo)
  {
    iSNo.updateElementValue("SNo");
    return iSNo;
  }
  
  /**
  * Print the element value represented by the Java bean SNo
  *   @param iSNo The Java bean for this element
  */
  void printSNo(SNo iSNo)
  {
    System.out.println(iSNo.getElementValue());
  }
  
  /**
  * Set the element TotalCFT to the specified value
  *   @param iTotalCFT The Java bean for this element
  *   @return TotalCFT The Java bean
  */
  TotalCFT initTotalCFT(TotalCFT iTotalCFT)
  {
    iTotalCFT.updateElementValue("TotalCFT");
    return iTotalCFT;
  }
  
  /**
  * Print the element value represented by the Java bean TotalCFT
  *   @param iTotalCFT The Java bean for this element
  */
  void printTotalCFT(TotalCFT iTotalCFT)
  {
    System.out.println(iTotalCFT.getElementValue());
  }
  
  /**
  * Set the element date to the specified value
  *   @param iDate The Java bean for this element
  *   @return date The Java bean
  */
  date initdate(date iDate)
  {
    iDate.updateElementValue("date");
    return iDate;
  }
  
  /**
  * Print the element value represented by the Java bean date
  *   @param iDate The Java bean for this element
  */
  void printdate(date iDate)
  {
    System.out.println(iDate.getElementValue());
  }
  
  /**
  * Set the element estateName to the specified value
  *   @param iEstateName The Java bean for this element
  *   @return estateName The Java bean
  */
  estateName initestateName(estateName iEstateName)
  {
    iEstateName.updateElementValue("estateName");
    return iEstateName;
  }
  
  /**
  * Print the element value represented by the Java bean estateName
  *   @param iEstateName The Java bean for this element
  */
  void printestateName(estateName iEstateName)
  {
    System.out.println(iEstateName.getElementValue());
  }
  
  /**
  * Create the root element in the document
  */
  void createincomingLobs()
  {
    iIncomingLobs.setLoadDetails(createloadDetails("loadDetails"));
    iIncomingLobs.setLoad(0,createload("load"));
    iIncomingLobs.setTotal(createtotal("total"));
  }
  
  /**
  * Print the content of the root element
  */
  void printincomingLobs()
  {
    printloadDetails(iIncomingLobs.getLoadDetails());
    printload(iIncomingLobs.getLoad(0));
    printtotal(iIncomingLobs.getTotal());
  }
  
  /**
  * Create the Java bean load
  *   @param name The element tag name
  *   @return load The Java bean for this element
  */
  load createload(String name)
  {
    load iLoad = iIncomingLobsFactory.createload(name);
    
    return initload(iLoad);
  }
  
  /**
  * Set the children (element or attribute) values in the element that is 
  * represented by the Java bean
  *   @param load The Java bean
  *   @return load The Java bean
  */
  load initload(load iLoad)
  {
    iLoad.setSNo("SNo");
    iLoad.setLength("Length");
    iLoad.setGirth("Girth");
    iLoad.setQuantity("Quantity");
    iLoad.setClassA("ClassA");
    iLoad.setClassB("ClassB");
    iLoad.setClassC("ClassC");
    iLoad.setClassD("ClassD");
    iLoad.setTotalCFT("TotalCFT");
    iLoad.setRate("Rate");
    iLoad.setAmount("Amount");
    
    return iLoad;
  }
  
  /**
  * Print the element represented by the Java bean load
  */
  void printload(load iLoad)
  {
    System.out.println(iLoad.getSNo());
    System.out.println(iLoad.getLength());
    System.out.println(iLoad.getGirth());
    System.out.println(iLoad.getQuantity());
    System.out.println(iLoad.getClassA());
    System.out.println(iLoad.getClassB());
    System.out.println(iLoad.getClassC());
    System.out.println(iLoad.getClassD());
    System.out.println(iLoad.getTotalCFT());
    System.out.println(iLoad.getRate());
    System.out.println(iLoad.getAmount());
  }
  
  /**
  * Create the Java bean loadDetails
  *   @param name The element tag name
  *   @return loadDetails The Java bean for this element
  */
  loadDetails createloadDetails(String name)
  {
    loadDetails iLoadDetails = iIncomingLobsFactory.createloadDetails(name);
    
    return initloadDetails(iLoadDetails);
  }
  
  /**
  * Set the children (element or attribute) values in the element that is 
  * represented by the Java bean
  *   @param loadDetails The Java bean
  *   @return loadDetails The Java bean
  */
  loadDetails initloadDetails(loadDetails iLoadDetails)
  {
    iLoadDetails.setLorryName("lorryName");
    iLoadDetails.setEstateName("estateName");
    iLoadDetails.setDate("date");
    
    return iLoadDetails;
  }
  
  /**
  * Print the element represented by the Java bean loadDetails
  */
  void printloadDetails(loadDetails iLoadDetails)
  {
    System.out.println(iLoadDetails.getLorryName());
    System.out.println(iLoadDetails.getEstateName());
    System.out.println(iLoadDetails.getDate());
  }
  
  /**
  * Set the element lorryName to the specified value
  *   @param iLorryName The Java bean for this element
  *   @return lorryName The Java bean
  */
  lorryName initlorryName(lorryName iLorryName)
  {
    iLorryName.updateElementValue("lorryName");
    return iLorryName;
  }
  
  /**
  * Print the element value represented by the Java bean lorryName
  *   @param iLorryName The Java bean for this element
  */
  void printlorryName(lorryName iLorryName)
  {
    System.out.println(iLorryName.getElementValue());
  }
  
  /**
  * Set the element tAmount to the specified value
  *   @param iTAmount The Java bean for this element
  *   @return tAmount The Java bean
  */
  tAmount inittAmount(tAmount iTAmount)
  {
    iTAmount.updateElementValue("tAmount");
    return iTAmount;
  }
  
  /**
  * Print the element value represented by the Java bean tAmount
  *   @param iTAmount The Java bean for this element
  */
  void printtAmount(tAmount iTAmount)
  {
    System.out.println(iTAmount.getElementValue());
  }
  
  /**
  * Set the element tCFT to the specified value
  *   @param iTCFT The Java bean for this element
  *   @return tCFT The Java bean
  */
  tCFT inittCFT(tCFT iTCFT)
  {
    iTCFT.updateElementValue("tCFT");
    return iTCFT;
  }
  
  /**
  * Print the element value represented by the Java bean tCFT
  *   @param iTCFT The Java bean for this element
  */
  void printtCFT(tCFT iTCFT)
  {
    System.out.println(iTCFT.getElementValue());
  }
  
  /**
  * Create the Java bean total
  *   @param name The element tag name
  *   @return total The Java bean for this element
  */
  total createtotal(String name)
  {
    total iTotal = iIncomingLobsFactory.createtotal(name);
    
    return inittotal(iTotal);
  }
  
  /**
  * Set the children (element or attribute) values in the element that is 
  * represented by the Java bean
  *   @param total The Java bean
  *   @return total The Java bean
  */
  total inittotal(total iTotal)
  {
    iTotal.setClassAcft("ClassAcft");
    iTotal.setClassBcft("ClassBcft");
    iTotal.setClassCcft("ClassCcft");
    iTotal.setClassDcft("ClassDcft");
    iTotal.setTCFT("tCFT");
    iTotal.setTAmount("tAmount");
    iTotal.setLobs("Lobs");
    
    return iTotal;
  }
  
  /**
  * Print the element represented by the Java bean total
  */
  void printtotal(total iTotal)
  {
    System.out.println(iTotal.getClassAcft());
    System.out.println(iTotal.getClassBcft());
    System.out.println(iTotal.getClassCcft());
    System.out.println(iTotal.getClassDcft());
    System.out.println(iTotal.getTCFT());
    System.out.println(iTotal.getTAmount());
    System.out.println(iTotal.getLobs());
  }
  
  /**
  * Create a new XML document using the generated incomingLobsFactory class
  *   @param filename The XML file name
  */
  void createNewInstance(String filename)
  {
    iIncomingLobsFactory = new incomingLobsFactory();
    iIncomingLobsFactory.setPackageName("com.loadSample");
    
    // include schemaLocation hint for validation
    iIncomingLobsFactory.setXSDFileName("LoadSample.xsd");
    
    // encoding for output document
    iIncomingLobsFactory.setEncoding("UTF8");
    
    // encoding tag for xml declaration
    iIncomingLobsFactory.setEncodingTag("UTF-8");
    
    // Create the root element in the document using the specified root element name
    iIncomingLobs = (incomingLobs) iIncomingLobsFactory.createRoot("incomingLobs");
    createincomingLobs();
    
    iIncomingLobsFactory.save(filename);
  }
  
  /**
  * Load an XML document using the generated incomingLobsFactory class
  *   @param filename An existing XML file name
  */
  void loadExistingInstance(String filename)
  {
    iIncomingLobsFactory = new incomingLobsFactory();
    iIncomingLobsFactory.setPackageName("com.loadSample");
    
    // Load the document
    iIncomingLobs = (incomingLobs) iIncomingLobsFactory.loadDocument(filename);
    printincomingLobs();
  }
  
  /**
  * The main program.
  * Creates an example XML document and then loads it
  */
  public static void main(String args[])
  {
    LoadFileSupport sample = new LoadFileSupport();
    sample.createNewInstance("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/IncomingTimber/LoadSampleSample.xml");
    sample.loadExistingInstance("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/IncomingTimber/LoadSampleSample.xml");
  }
}

