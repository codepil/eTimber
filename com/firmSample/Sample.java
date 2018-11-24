package com.firmSample;

import com.ibm.etools.xmlschema.beans.*;
import java.util.*;

/**
* A sample program to show how to use the generated Java beans to:
*  - create and save an XML document
*  - load the XML document and print its content
*/
public class Sample
{
  firmFactory iFirmFactory;
  firm iFirm;
  
  public Sample()
  {
  }
  
  /**
  * Set the element SLR to the specified value
  *   @param iSLR The Java bean for this element
  *   @return SLR The Java bean
  */
  SLR initSLR(SLR iSLR)
  {
    iSLR.updateElementValue("SLR");
    return iSLR;
  }
  
  /**
  * Print the element value represented by the Java bean SLR
  *   @param iSLR The Java bean for this element
  */
  void printSLR(SLR iSLR)
  {
    System.out.println(iSLR.getElementValue());
  }
  
  /**
  * Set the element amount to the specified value
  *   @param iAmount The Java bean for this element
  *   @return amount The Java bean
  */
  amount initamount(amount iAmount)
  {
    iAmount.updateElementValue("amount");
    return iAmount;
  }
  
  /**
  * Print the element value represented by the Java bean amount
  *   @param iAmount The Java bean for this element
  */
  void printamount(amount iAmount)
  {
    System.out.println(iAmount.getElementValue());
  }
  
  /**
  * Set the element battons to the specified value
  *   @param iBattons The Java bean for this element
  *   @return battons The Java bean
  */
  battons initbattons(battons iBattons)
  {
    iBattons.updateElementValue("battons");
    return iBattons;
  }
  
  /**
  * Print the element value represented by the Java bean battons
  *   @param iBattons The Java bean for this element
  */
  void printbattons(battons iBattons)
  {
    System.out.println(iBattons.getElementValue());
  }
  
  /**
  * Create the Java bean details
  *   @param name The element tag name
  *   @return details The Java bean for this element
  */
  details createdetails(String name)
  {
    details iDetails = iFirmFactory.createdetails(name);
    
    return initdetails(iDetails);
  }
  
  /**
  * Set the children (element or attribute) values in the element that is 
  * represented by the Java bean
  *   @param details The Java bean
  *   @return details The Java bean
  */
  details initdetails(details iDetails)
  {
    iDetails.setFirmName("firmName");
    iDetails.setFirmAddress("firmAddress");
    iDetails.setTcft("tcft");
    iDetails.setTlc("tlc");
    iDetails.setDis("dis");
    
    return iDetails;
  }
  
  /**
  * Print the element represented by the Java bean details
  */
  void printdetails(details iDetails)
  {
    System.out.println(iDetails.getFirmName());
    System.out.println(iDetails.getFirmAddress());
    System.out.println(iDetails.getTcft());
    System.out.println(iDetails.getTlc());
    System.out.println(iDetails.getDis());
  }
  
  /**
  * Set the element dis to the specified value
  *   @param iDis The Java bean for this element
  *   @return dis The Java bean
  */
  dis initdis(dis iDis)
  {
    iDis.updateElementValue("dis");
    return iDis;
  }
  
  /**
  * Print the element value represented by the Java bean dis
  *   @param iDis The Java bean for this element
  */
  void printdis(dis iDis)
  {
    System.out.println(iDis.getElementValue());
  }
  
  /**
  * Create the root element in the document
  */
  void createfirm()
  {
    iFirm.setDetails(createdetails("details"));
    iFirm.setLoad(0,createload("load"));
  }
  
  /**
  * Print the content of the root element
  */
  void printfirm()
  {
    printdetails(iFirm.getDetails());
    printload(iFirm.getLoad(0));
  }
  
  /**
  * Set the element firmAddress to the specified value
  *   @param iFirmAddress The Java bean for this element
  *   @return firmAddress The Java bean
  */
  firmAddress initfirmAddress(firmAddress iFirmAddress)
  {
    iFirmAddress.updateElementValue("firmAddress");
    return iFirmAddress;
  }
  
  /**
  * Print the element value represented by the Java bean firmAddress
  *   @param iFirmAddress The Java bean for this element
  */
  void printfirmAddress(firmAddress iFirmAddress)
  {
    System.out.println(iFirmAddress.getElementValue());
  }
  
  /**
  * Set the element firmName to the specified value
  *   @param iFirmName The Java bean for this element
  *   @return firmName The Java bean
  */
  firmName initfirmName(firmName iFirmName)
  {
    iFirmName.updateElementValue("firmName");
    return iFirmName;
  }
  
  /**
  * Print the element value represented by the Java bean firmName
  *   @param iFirmName The Java bean for this element
  */
  void printfirmName(firmName iFirmName)
  {
    System.out.println(iFirmName.getElementValue());
  }
  
  /**
  * Set the element lapha to the specified value
  *   @param iLapha The Java bean for this element
  *   @return lapha The Java bean
  */
  lapha initlapha(lapha iLapha)
  {
    iLapha.updateElementValue("lapha");
    return iLapha;
  }
  
  /**
  * Print the element value represented by the Java bean lapha
  *   @param iLapha The Java bean for this element
  */
  void printlapha(lapha iLapha)
  {
    System.out.println(iLapha.getElementValue());
  }
  
  /**
  * Create the Java bean load
  *   @param name The element tag name
  *   @return load The Java bean for this element
  */
  load createload(String name)
  {
    load iLoad = iFirmFactory.createload(name);
    
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
    iLoad.setSno("sno");
    iLoad.setOrderNo("orderNo");
    iLoad.setLoadName("loadName");
    iLoad.setLoadDate("loadDate");
    iLoad.setRunners("runners");
    iLoad.setPlanks("planks");
    iLoad.setBattons("battons");
    iLoad.setSLR("SLR");
    iLoad.setLapha("lapha");
    iLoad.setOthers("others");
    iLoad.setTotalCFT("totalCFT");
    iLoad.setAmount("amount");
    
    return iLoad;
  }
  
  /**
  * Print the element represented by the Java bean load
  */
  void printload(load iLoad)
  {
    System.out.println(iLoad.getSno());
    System.out.println(iLoad.getOrderNo());
    System.out.println(iLoad.getLoadName());
    System.out.println(iLoad.getLoadDate());
    System.out.println(iLoad.getRunners());
    System.out.println(iLoad.getPlanks());
    System.out.println(iLoad.getBattons());
    System.out.println(iLoad.getSLR());
    System.out.println(iLoad.getLapha());
    System.out.println(iLoad.getOthers());
    System.out.println(iLoad.getTotalCFT());
    System.out.println(iLoad.getAmount());
  }
  
  /**
  * Set the element loadDate to the specified value
  *   @param iLoadDate The Java bean for this element
  *   @return loadDate The Java bean
  */
  loadDate initloadDate(loadDate iLoadDate)
  {
    iLoadDate.updateElementValue("loadDate");
    return iLoadDate;
  }
  
  /**
  * Print the element value represented by the Java bean loadDate
  *   @param iLoadDate The Java bean for this element
  */
  void printloadDate(loadDate iLoadDate)
  {
    System.out.println(iLoadDate.getElementValue());
  }
  
  /**
  * Set the element loadName to the specified value
  *   @param iLoadName The Java bean for this element
  *   @return loadName The Java bean
  */
  loadName initloadName(loadName iLoadName)
  {
    iLoadName.updateElementValue("loadName");
    return iLoadName;
  }
  
  /**
  * Print the element value represented by the Java bean loadName
  *   @param iLoadName The Java bean for this element
  */
  void printloadName(loadName iLoadName)
  {
    System.out.println(iLoadName.getElementValue());
  }
  
  /**
  * Set the element orderNo to the specified value
  *   @param iOrderNo The Java bean for this element
  *   @return orderNo The Java bean
  */
  orderNo initorderNo(orderNo iOrderNo)
  {
    iOrderNo.updateElementValue("orderNo");
    return iOrderNo;
  }
  
  /**
  * Print the element value represented by the Java bean orderNo
  *   @param iOrderNo The Java bean for this element
  */
  void printorderNo(orderNo iOrderNo)
  {
    System.out.println(iOrderNo.getElementValue());
  }
  
  /**
  * Set the element others to the specified value
  *   @param iOthers The Java bean for this element
  *   @return others The Java bean
  */
  others initothers(others iOthers)
  {
    iOthers.updateElementValue("others");
    return iOthers;
  }
  
  /**
  * Print the element value represented by the Java bean others
  *   @param iOthers The Java bean for this element
  */
  void printothers(others iOthers)
  {
    System.out.println(iOthers.getElementValue());
  }
  
  /**
  * Set the element planks to the specified value
  *   @param iPlanks The Java bean for this element
  *   @return planks The Java bean
  */
  planks initplanks(planks iPlanks)
  {
    iPlanks.updateElementValue("planks");
    return iPlanks;
  }
  
  /**
  * Print the element value represented by the Java bean planks
  *   @param iPlanks The Java bean for this element
  */
  void printplanks(planks iPlanks)
  {
    System.out.println(iPlanks.getElementValue());
  }
  
  /**
  * Set the element runners to the specified value
  *   @param iRunners The Java bean for this element
  *   @return runners The Java bean
  */
  runners initrunners(runners iRunners)
  {
    iRunners.updateElementValue("runners");
    return iRunners;
  }
  
  /**
  * Print the element value represented by the Java bean runners
  *   @param iRunners The Java bean for this element
  */
  void printrunners(runners iRunners)
  {
    System.out.println(iRunners.getElementValue());
  }
  
  /**
  * Set the element sno to the specified value
  *   @param iSno The Java bean for this element
  *   @return sno The Java bean
  */
  sno initsno(sno iSno)
  {
    iSno.updateElementValue("sno");
    return iSno;
  }
  
  /**
  * Print the element value represented by the Java bean sno
  *   @param iSno The Java bean for this element
  */
  void printsno(sno iSno)
  {
    System.out.println(iSno.getElementValue());
  }
  
  /**
  * Set the element tcft to the specified value
  *   @param iTcft The Java bean for this element
  *   @return tcft The Java bean
  */
  tcft inittcft(tcft iTcft)
  {
    iTcft.updateElementValue("tcft");
    return iTcft;
  }
  
  /**
  * Print the element value represented by the Java bean tcft
  *   @param iTcft The Java bean for this element
  */
  void printtcft(tcft iTcft)
  {
    System.out.println(iTcft.getElementValue());
  }
  
  /**
  * Set the element tlc to the specified value
  *   @param iTlc The Java bean for this element
  *   @return tlc The Java bean
  */
  tlc inittlc(tlc iTlc)
  {
    iTlc.updateElementValue("tlc");
    return iTlc;
  }
  
  /**
  * Print the element value represented by the Java bean tlc
  *   @param iTlc The Java bean for this element
  */
  void printtlc(tlc iTlc)
  {
    System.out.println(iTlc.getElementValue());
  }
  
  /**
  * Set the element totalCFT to the specified value
  *   @param iTotalCFT The Java bean for this element
  *   @return totalCFT The Java bean
  */
  totalCFT inittotalCFT(totalCFT iTotalCFT)
  {
    iTotalCFT.updateElementValue("totalCFT");
    return iTotalCFT;
  }
  
  /**
  * Print the element value represented by the Java bean totalCFT
  *   @param iTotalCFT The Java bean for this element
  */
  void printtotalCFT(totalCFT iTotalCFT)
  {
    System.out.println(iTotalCFT.getElementValue());
  }
  
  /**
  * Create a new XML document using the generated firmFactory class
  *   @param filename The XML file name
  */
  void createNewInstance(String filename)
  {
    iFirmFactory = new firmFactory();
    iFirmFactory.setPackageName("com.firmSample");
    
    // include schemaLocation hint for validation
    iFirmFactory.setXSDFileName("extractedData2.xsd");
    
    // encoding for output document
    iFirmFactory.setEncoding("UTF8");
    
    // encoding tag for xml declaration
    iFirmFactory.setEncodingTag("UTF-8");
    
    // Create the root element in the document using the specified root element name
    iFirm = (firm) iFirmFactory.createRoot("firm");
    createfirm();
    
    iFirmFactory.save(filename);
  }
  
  /**
  * Load an XML document using the generated firmFactory class
  *   @param filename An existing XML file name
  */
  void loadExistingInstance(String filename)
  {
    iFirmFactory = new firmFactory();
    iFirmFactory.setPackageName("com.firmSample");
    
    // Load the document
    iFirm = (firm) iFirmFactory.loadDocument(filename);
    printfirm();
  }
  
  /**
  * The main program.
  * Creates an example XML document and then loads it
  */
  public static void main(String args[])
  {
    Sample sample = new Sample();
    sample.createNewInstance("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/OutGoing/extractedData2Sample.xml");
    sample.loadExistingInstance("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/OutGoing/extractedData2Sample.xml");
  }
}

