package com.myself;

import com.ibm.etools.xmlschema.beans.*;
import com.estateSample.*;

import java.io.File;


/**
* A sample program to show how to use the generated Java beans to:
*  - create and save an XML document
*  - load the XML document and print its content
*/
public class EstateFileSupportOld
{
  public IncomingFactory iIncomingFactory;
  public Incoming iIncoming;
  
  public EstateFileSupportOld()
  {
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
  * Set the element Clerk to the specified value
  *   @param iClerk The Java bean for this element
  *   @return Clerk The Java bean
  */
  Clerk initClerk(Clerk iClerk)
  {
    iClerk.updateElementValue("Clerk");
    return iClerk;
  }
  
  /**
  * Print the element value represented by the Java bean Clerk
  *   @param iClerk The Java bean for this element
  */
  void printClerk(Clerk iClerk)
  {
    System.out.println(iClerk.getElementValue());
  }
  
  /**
  * Set the element CoupContractor to the specified value
  *   @param iCoupContractor The Java bean for this element
  *   @return CoupContractor The Java bean
  */
  CoupContractor initCoupContractor(CoupContractor iCoupContractor)
  {
    iCoupContractor.updateElementValue("CoupContractor");
    return iCoupContractor;
  }
  
  /**
  * Print the element value represented by the Java bean CoupContractor
  *   @param iCoupContractor The Java bean for this element
  */
  void printCoupContractor(CoupContractor iCoupContractor)
  {
    System.out.println(iCoupContractor.getElementValue());
  }
  
  /**
  * Set the element Date to the specified value
  *   @param iDate The Java bean for this element
  *   @return Date The Java bean
  */
  Date initDate(Date iDate)
  {
    iDate.updateElementValue("Date");
    return iDate;
  }
  
  /**
  * Print the element value represented by the Java bean Date
  *   @param iDate The Java bean for this element
  */
  void printDate(Date iDate)
  {
    System.out.println(iDate.getElementValue());
  }
  
  /**
  * Set the element DelNo to the specified value
  *   @param iDelNo The Java bean for this element
  *   @return DelNo The Java bean
  */
  DelNo initDelNo(DelNo iDelNo)
  {
    iDelNo.updateElementValue("DelNo");
    return iDelNo;
  }
  
  /**
  * Print the element value represented by the Java bean DelNo
  *   @param iDelNo The Java bean for this element
  */
  void printDelNo(DelNo iDelNo)
  {
    System.out.println(iDelNo.getElementValue());
  }
  
  /**
  * Create the Java bean Estate
  *   @param name The element tag name
  *   @return Estate The Java bean for this element
  */
  Estate createEstate(String name)
  {
    Estate iEstate = iIncomingFactory.createEstate(name);
    
    return initEstate(iEstate);
  }
  
  /**
  * Set the children (element or attribute) values in the element that is 
  * represented by the Java bean
  *   @param Estate The Java bean
  *   @return Estate The Java bean
  */
  Estate initEstate(Estate iEstate)
  {
    iEstate.setPlanterName("PlanterName");
    iEstate.setPlantAddress("PlantAddress");
    iEstate.setSyNo("SyNo");
    iEstate.setCoupContractor("CoupContractor");
    
    return iEstate;
  }
  
  /**
  * Print the element represented by the Java bean Estate
  */
  void printEstate(Estate iEstate)
  {
    System.out.println(iEstate.getPlanterName());
    System.out.println(iEstate.getPlantAddress());
    System.out.println(iEstate.getSyNo());
    System.out.println(iEstate.getCoupContractor());
  }
  
  /**
  * Create the root element in the document
  */
  void createIncoming()
  {
    iIncoming.setEstate(createEstate("Estate"));
    iIncoming.setLoadDetails(createLoadDetails("LoadDetails"));
  }
  
  /**
  * Print the content of the root element
  */
  void printIncoming()
  {
    printEstate(iIncoming.getEstate());
    printLoadDetails(iIncoming.getLoadDetails());
  }
  
  /**
  * Create the Java bean LoadDetails
  *   @param name The element tag name
  *   @return LoadDetails The Java bean for this element
  */
  LoadDetails createLoadDetails(String name)
  {
    LoadDetails iLoadDetails = iIncomingFactory.createLoadDetails(name);
    
    return initLoadDetails(iLoadDetails);
  }
  
  /**
  * Set the children (element or attribute) values in the element that is 
  * represented by the Java bean
  *   @param LoadDetails The Java bean
  *   @return LoadDetails The Java bean
  */
  LoadDetails initLoadDetails(LoadDetails iLoadDetails)
  {
    iLoadDetails.setLoad(0,createload("load"));
    
    return iLoadDetails;
  }
  
  /**
  * Print the element represented by the Java bean LoadDetails
  */
  void printLoadDetails(LoadDetails iLoadDetails)
  {
    printload(iLoadDetails.getLoad(0));
  }
  
  /**
  * Set the element Logs to the specified value
  *   @param iLogs The Java bean for this element
  *   @return Logs The Java bean
  */
  Logs initLogs(Logs iLogs)
  {
    iLogs.updateElementValue("Logs");
    return iLogs;
  }
  
  /**
  * Print the element value represented by the Java bean Logs
  *   @param iLogs The Java bean for this element
  */
  void printLogs(Logs iLogs)
  {
    System.out.println(iLogs.getElementValue());
  }
  
  /**
  * Set the element LorryNumber to the specified value
  *   @param iLorryNumber The Java bean for this element
  *   @return LorryNumber The Java bean
  */
  LorryNumber initLorryNumber(LorryNumber iLorryNumber)
  {
    iLorryNumber.updateElementValue("LorryNumber");
    return iLorryNumber;
  }
  
  /**
  * Print the element value represented by the Java bean LorryNumber
  *   @param iLorryNumber The Java bean for this element
  */
  void printLorryNumber(LorryNumber iLorryNumber)
  {
    System.out.println(iLorryNumber.getElementValue());
  }
  
  /**
  * Set the element PlantAddress to the specified value
  *   @param iPlantAddress The Java bean for this element
  *   @return PlantAddress The Java bean
  */
  PlantAddress initPlantAddress(PlantAddress iPlantAddress)
  {
    iPlantAddress.updateElementValue("PlantAddress");
    return iPlantAddress;
  }
  
  /**
  * Print the element value represented by the Java bean PlantAddress
  *   @param iPlantAddress The Java bean for this element
  */
  void printPlantAddress(PlantAddress iPlantAddress)
  {
    System.out.println(iPlantAddress.getElementValue());
  }
  
  /**
  * Set the element PlanterName to the specified value
  *   @param iPlanterName The Java bean for this element
  *   @return PlanterName The Java bean
  */
  PlanterName initPlanterName(PlanterName iPlanterName)
  {
    iPlanterName.updateElementValue("PlanterName");
    return iPlanterName;
  }
  
  /**
  * Print the element value represented by the Java bean PlanterName
  *   @param iPlanterName The Java bean for this element
  */
  void printPlanterName(PlanterName iPlanterName)
  {
    System.out.println(iPlanterName.getElementValue());
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
  * Set the element Stumps to the specified value
  *   @param iStumps The Java bean for this element
  *   @return Stumps The Java bean
  */
  Stumps initStumps(Stumps iStumps)
  {
    iStumps.updateElementValue("Stumps");
    return iStumps;
  }
  
  /**
  * Print the element value represented by the Java bean Stumps
  *   @param iStumps The Java bean for this element
  */
  void printStumps(Stumps iStumps)
  {
    System.out.println(iStumps.getElementValue());
  }
  
  /**
  * Set the element SyNo to the specified value
  *   @param iSyNo The Java bean for this element
  *   @return SyNo The Java bean
  */
  SyNo initSyNo(SyNo iSyNo)
  {
    iSyNo.updateElementValue("SyNo");
    return iSyNo;
  }
  
  /**
  * Print the element value represented by the Java bean SyNo
  *   @param iSyNo The Java bean for this element
  */
  void printSyNo(SyNo iSyNo)
  {
    System.out.println(iSyNo.getElementValue());
  }
  
  /**
  * Set the element Tape to the specified value
  *   @param iTape The Java bean for this element
  *   @return Tape The Java bean
  */
  Tape initTape(Tape iTape)
  {
    iTape.updateElementValue("Tape");
    return iTape;
  }
  
  /**
  * Print the element value represented by the Java bean Tape
  *   @param iTape The Java bean for this element
  */
  void printTape(Tape iTape)
  {
    System.out.println(iTape.getElementValue());
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
  * Set the element Unload to the specified value
  *   @param iUnload The Java bean for this element
  *   @return Unload The Java bean
  */
  Unload initUnload(Unload iUnload)
  {
    iUnload.updateElementValue("Unload");
    return iUnload;
  }
  
  /**
  * Print the element value represented by the Java bean Unload
  *   @param iUnload The Java bean for this element
  */
  void printUnload(Unload iUnload)
  {
    System.out.println(iUnload.getElementValue());
  }
  
  /**
  * Create the Java bean load
  *   @param name The element tag name
  *   @return load The Java bean for this element
  */
  load createload(String name)
  {
    load iLoad = iIncomingFactory.createload(name);
    
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
    iLoad.setDate("Date");
    iLoad.setLorryNumber("LorryNumber");
    iLoad.setTape("Tape");
    iLoad.setClerk("Clerk");
    iLoad.setLogs("Logs");
    iLoad.setClassA("ClassA");
    iLoad.setClassB("ClassB");
    iLoad.setClassC("ClassC");
    iLoad.setClassD("ClassD");
    iLoad.setTotalCFT("TotalCFT");
    iLoad.setUnload("Unload");
    iLoad.setDelNo("DelNo");
    iLoad.setStumps("Stumps");
    
    return iLoad;
  }
  
  /**
  * Print the element represented by the Java bean load
  */
  void printload(load iLoad)
  {
    System.out.println(iLoad.getSNo());
    System.out.println(iLoad.getDate());
    System.out.println(iLoad.getLorryNumber());
    System.out.println(iLoad.getTape());
    System.out.println(iLoad.getClerk());
    System.out.println(iLoad.getLogs());
    System.out.println(iLoad.getClassA());
    System.out.println(iLoad.getClassB());
    System.out.println(iLoad.getClassC());
    System.out.println(iLoad.getClassD());
    System.out.println(iLoad.getTotalCFT());
    System.out.println(iLoad.getUnload());
    System.out.println(iLoad.getDelNo());
    System.out.println(iLoad.getStumps());
  }
  
  /**
  * Create a new XML document using the generated IncomingFactory class
  *   @param filename The XML file name
  */
  void createNewInstance(String filename)
  {
    iIncomingFactory = new IncomingFactory();
    iIncomingFactory.setPackageName("com.estateSample");
    
    // include schemaLocation hint for validation
    iIncomingFactory.setXSDFileName("estateSample.xsd");
    
    // encoding for output document
    iIncomingFactory.setEncoding("UTF8");
    
    // encoding tag for xml declaration
    iIncomingFactory.setEncodingTag("UTF-8");
    
    // Create the root element in the document using the specified root element name
    iIncoming = (Incoming) iIncomingFactory.createRoot("Incoming");
    createIncoming();
    
    iIncomingFactory.save(filename);
  }
  
  /**
  * Load an XML document using the generated IncomingFactory class
  *   @param filename An existing XML file name
  */
  void loadExistingInstance(String filename)
  {
    iIncomingFactory = new IncomingFactory();
    iIncomingFactory.setPackageName("com.estateSample");
    
    // Load the document
    iIncoming = (Incoming) iIncomingFactory.loadDocument(filename);
    //printIncoming();
  }
  
  /**
  * The main program.
  * Creates an example XML document and then loads it
  */
  public static void main(String args[])
  {
    EstateFileSupportOld sample = new EstateFileSupportOld();
	if ( (new File("estate/data/estateSampleSample1.xml")).exists()){
		System.out.println("estate already exits..");
		sample.loadExistingInstance("estate/data/estateSampleSample1.xml");
		System.out.println("Count is:"+sample.iIncoming.getLoadDetails().getloadCount());
		sample.loadExistingInstance("estate/data/estateSampleSample1.xml");
	}
	else{
		sample.createNewInstance("estate/data/estateSampleSample1.xml");
		System.out.println("estate created new ..");
		sample.iIncoming.getEstate().setCoupContractor("changed text");
		sample.iIncoming.getLoadDetails().getLoad(0).setLorryNumber("myLorry1234");
		sample.iIncomingFactory.save("estate/data/estateSampleSample1.xml");
		System.out.println("Printing changes ones..");
		sample.printload(sample.iIncoming.getLoadDetails().getLoad(0));
		}
    //sample.Initialise();
  }
   
  public void Initialise(){
  	
	EstateFileSupport sample = new EstateFileSupport();
	
	
		
	
	}
	
  
}

