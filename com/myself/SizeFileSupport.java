package com.myself;

import com.ibm.etools.xmlschema.beans.*;
//import java.util.*;
import com.sizeSample.*;

/**
* A sample program to show how to use the generated Java beans to:
*  - create and save an XML document
*  - load the XML document and print its content
*/
public class SizeFileSupport
{
  outGoingFactory iOutGoingFactory;
  outGoing iOutGoing;

  public SizeFileSupport()
  {
  }

  /**
  * Set the element Battons to the specified value
  *   @param iBattons The Java bean for this element
  *   @return Battons The Java bean
  */
  Battons initBattons(Battons iBattons)
  {
    iBattons.updateElementValue("Battons");
    return iBattons;
  }

  /**
  * Print the element value represented by the Java bean Battons
  *   @param iBattons The Java bean for this element
  */
  void printBattons(Battons iBattons)
  {
    System.out.println(iBattons.getElementValue());
  }

  /**
  * Create the Java bean FirmDetails
  *   @param name The element tag name
  *   @return FirmDetails The Java bean for this element
  */
  FirmDetails createFirmDetails(String name)
  {
    FirmDetails iFirmDetails = iOutGoingFactory.createFirmDetails(name);

    return initFirmDetails(iFirmDetails);
  }

  /**
  * Set the children (element or attribute) values in the element that is
  * represented by the Java bean
  *   @param FirmDetails The Java bean
  *   @return FirmDetails The Java bean
  */
  FirmDetails initFirmDetails(FirmDetails iFirmDetails)
  {
    iFirmDetails.setFirmName("firmName");
    iFirmDetails.setFirmAddress("firmAddress");
    iFirmDetails.setBillNo("billNo");
    iFirmDetails.setOrderNo("orderNo");
    iFirmDetails.setArticles("articles");
    iFirmDetails.setLorryName("lorryName");
    iFirmDetails.setLoadDate("loadDate");

    return iFirmDetails;
  }

  /**
  * Print the element represented by the Java bean FirmDetails
  */
  void printFirmDetails(FirmDetails iFirmDetails)
  {
    System.out.println(iFirmDetails.getFirmName());
    System.out.println(iFirmDetails.getFirmAddress());
    System.out.println(iFirmDetails.getBillNo());
    System.out.println(iFirmDetails.getOrderNo());
    System.out.println(iFirmDetails.getArticles());
    System.out.println(iFirmDetails.getLorryName());
    System.out.println(iFirmDetails.getLoadDate());
  }

  /**
  * Set the element Lapha to the specified value
  *   @param iLapha The Java bean for this element
  *   @return Lapha The Java bean
  */
  Lapha initLapha(Lapha iLapha)
  {
    iLapha.updateElementValue("Lapha");
    return iLapha;
  }

  /**
  * Print the element value represented by the Java bean Lapha
  *   @param iLapha The Java bean for this element
  */
  void printLapha(Lapha iLapha)
  {
    System.out.println(iLapha.getElementValue());
  }

  /**
  * Set the element Others to the specified value
  *   @param iOthers The Java bean for this element
  *   @return Others The Java bean
  */
  Others initOthers(Others iOthers)
  {
    iOthers.updateElementValue("Others");
    return iOthers;
  }

  /**
  * Print the element value represented by the Java bean Others
  *   @param iOthers The Java bean for this element
  */
  void printOthers(Others iOthers)
  {
    System.out.println(iOthers.getElementValue());
  }

  /**
  * Set the element Runners to the specified value
  *   @param iRunners The Java bean for this element
  *   @return Runners The Java bean
  */
  Runners initRunners(Runners iRunners)
  {
    iRunners.updateElementValue("Runners");
    return iRunners;
  }

  /**
  * Print the element value represented by the Java bean Runners
  *   @param iRunners The Java bean for this element
  */
  void printRunners(Runners iRunners)
  {
    System.out.println(iRunners.getElementValue());
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
  * Set the element articles to the specified value
  *   @param iArticles The Java bean for this element
  *   @return articles The Java bean
  */
  articles initarticles(articles iArticles)
  {
    iArticles.updateElementValue("articles");
    return iArticles;
  }

  /**
  * Print the element value represented by the Java bean articles
  *   @param iArticles The Java bean for this element
  */
  void printarticles(articles iArticles)
  {
    System.out.println(iArticles.getElementValue());
  }

  /**
  * Set the element billNo to the specified value
  *   @param iBillNo The Java bean for this element
  *   @return billNo The Java bean
  */
  billNo initbillNo(billNo iBillNo)
  {
    iBillNo.updateElementValue("billNo");
    return iBillNo;
  }

  /**
  * Print the element value represented by the Java bean billNo
  *   @param iBillNo The Java bean for this element
  */
  void printbillNo(billNo iBillNo)
  {
    System.out.println(iBillNo.getElementValue());
  }

  /**
  * Set the element cft to the specified value
  *   @param iCft The Java bean for this element
  *   @return cft The Java bean
  */
  cft initcft(cft iCft)
  {
    iCft.updateElementValue("cft");
    return iCft;
  }

  /**
  * Print the element value represented by the Java bean cft
  *   @param iCft The Java bean for this element
  */
  void printcft(cft iCft)
  {
    System.out.println(iCft.getElementValue());
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
  * Set the element length to the specified value
  *   @param iLength The Java bean for this element
  *   @return length The Java bean
  */
  length initlength(length iLength)
  {
    iLength.updateElementValue("length");
    return iLength;
  }

  /**
  * Print the element value represented by the Java bean length
  *   @param iLength The Java bean for this element
  */
  void printlength(length iLength)
  {
    System.out.println(iLength.getElementValue());
  }

  /**
  * Create the Java bean load
  *   @param name The element tag name
  *   @return load The Java bean for this element
  */
  load createload(String name)
  {
    load iLoad = iOutGoingFactory.createload(name);

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
    iLoad.setLength("length");
    iLoad.setWidth("width");
    iLoad.setThinkness("thinkness");
    iLoad.setQnt("qnt");
    iLoad.setRft("rft");
    iLoad.setCft("cft");

    return iLoad;
  }

  /**
  * Print the element represented by the Java bean load
  */
  void printload(load iLoad)
  {
    System.out.println(iLoad.getLength());
    System.out.println(iLoad.getWidth());
    System.out.println(iLoad.getThinkness());
    System.out.println(iLoad.getQnt());
    System.out.println(iLoad.getRft());
    System.out.println(iLoad.getCft());
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
  * Create the Java bean loadTotal
  *   @param name The element tag name
  *   @return loadTotal The Java bean for this element
  */
  loadTotal createloadTotal(String name)
  {
    loadTotal iLoadTotal = iOutGoingFactory.createloadTotal(name);

    return initloadTotal(iLoadTotal);
  }

  /**
  * Set the children (element or attribute) values in the element that is
  * represented by the Java bean
  *   @param loadTotal The Java bean
  *   @return loadTotal The Java bean
  */
  loadTotal initloadTotal(loadTotal iLoadTotal)
  {
    iLoadTotal.setQnt("qnt");
    iLoadTotal.setRft("rft");
    iLoadTotal.setCft("cft");
    iLoadTotal.setType("type");

    return iLoadTotal;
  }

  /**
  * Print the element represented by the Java bean loadTotal
  */
  void printloadTotal(loadTotal iLoadTotal)
  {
    System.out.println(iLoadTotal.getQnt());
    System.out.println(iLoadTotal.getRft());
    System.out.println(iLoadTotal.getCft());
    System.out.println(iLoadTotal.getType());
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
  * Create the root element in the document
  */
  void createoutGoing()
  {
    iOutGoing.setFirmDetails(createFirmDetails("FirmDetails"));
    iOutGoing.setRowData(0,createrowData("rowData"));
    iOutGoing.setSizeTotal(createsizeTotal("sizeTotal"));
  }

  /**
  * Print the content of the root element
  */
  void printoutGoing()
  {
    printFirmDetails(iOutGoing.getFirmDetails());
    printrowData(iOutGoing.getRowData(0));
    printsizeTotal(iOutGoing.getSizeTotal());
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
  * Set the element qnt to the specified value
  *   @param iQnt The Java bean for this element
  *   @return qnt The Java bean
  */
  qnt initqnt(qnt iQnt)
  {
    iQnt.updateElementValue("qnt");
    return iQnt;
  }

  /**
  * Print the element value represented by the Java bean qnt
  *   @param iQnt The Java bean for this element
  */
  void printqnt(qnt iQnt)
  {
    System.out.println(iQnt.getElementValue());
  }

  /**
  * Set the element rft to the specified value
  *   @param iRft The Java bean for this element
  *   @return rft The Java bean
  */
  rft initrft(rft iRft)
  {
    iRft.updateElementValue("rft");
    return iRft;
  }

  /**
  * Print the element value represented by the Java bean rft
  *   @param iRft The Java bean for this element
  */
  void printrft(rft iRft)
  {
    System.out.println(iRft.getElementValue());
  }

  /**
  * Create the Java bean rowData
  *   @param name The element tag name
  *   @return rowData The Java bean for this element
  */
  rowData createrowData(String name)
  {
    rowData iRowData = iOutGoingFactory.createrowData(name);

    return initrowData(iRowData);
  }

  /**
  * Set the children (element or attribute) values in the element that is
  * represented by the Java bean
  *   @param rowData The Java bean
  *   @return rowData The Java bean
  */
  rowData initrowData(rowData iRowData)
  {
    iRowData.setSizeData(0,createsizeData("sizeData"));

    return iRowData;
  }

  /**
  * Print the element represented by the Java bean rowData
  */
  void printrowData(rowData iRowData)
  {
    printsizeData(iRowData.getSizeData(0));
  }

  /**
  * Create the Java bean sizeData
  *   @param name The element tag name
  *   @return sizeData The Java bean for this element
  */
  sizeData createsizeData(String name)
  {
    sizeData iSizeData = iOutGoingFactory.createsizeData(name);

    return initsizeData(iSizeData);
  }

  /**
  * Set the children (element or attribute) values in the element that is
  * represented by the Java bean
  *   @param sizeData The Java bean
  *   @return sizeData The Java bean
  */
  sizeData initsizeData(sizeData iSizeData)
  {
    iSizeData.setLoad(0,createload("load"));
    iSizeData.setLoadTotal(createloadTotal("loadTotal"));

    return iSizeData;
  }

  /**
  * Print the element represented by the Java bean sizeData
  */
  void printsizeData(sizeData iSizeData)
  {
    printload(iSizeData.getLoad(0));
    printloadTotal(iSizeData.getLoadTotal());
  }

  /**
  * Create the Java bean sizeTotal
  *   @param name The element tag name
  *   @return sizeTotal The Java bean for this element
  */
  sizeTotal createsizeTotal(String name)
  {
    sizeTotal iSizeTotal = iOutGoingFactory.createsizeTotal(name);

    return initsizeTotal(iSizeTotal);
  }

  /**
  * Set the children (element or attribute) values in the element that is
  * represented by the Java bean
  *   @param sizeTotal The Java bean
  *   @return sizeTotal The Java bean
  */
  sizeTotal initsizeTotal(sizeTotal iSizeTotal)
  {
    iSizeTotal.setPlanks("planks");
    iSizeTotal.setRunners("Runners");
    iSizeTotal.setBattons("Battons");
    iSizeTotal.setSLR("SLR");
    iSizeTotal.setLapha("Lapha");
    iSizeTotal.setOthers("Others");
    iSizeTotal.setTotalCFT("totalCFT");

    return iSizeTotal;
  }

  /**
  * Print the element represented by the Java bean sizeTotal
  */
  void printsizeTotal(sizeTotal iSizeTotal)
  {
    System.out.println(iSizeTotal.getPlanks());
    System.out.println(iSizeTotal.getRunners());
    System.out.println(iSizeTotal.getBattons());
    System.out.println(iSizeTotal.getSLR());
    System.out.println(iSizeTotal.getLapha());
    System.out.println(iSizeTotal.getOthers());
    System.out.println(iSizeTotal.getTotalCFT());
  }

  /**
  * Set the element thinkness to the specified value
  *   @param iThinkness The Java bean for this element
  *   @return thinkness The Java bean
  */
  thinkness initthinkness(thinkness iThinkness)
  {
    iThinkness.updateElementValue("thinkness");
    return iThinkness;
  }

  /**
  * Print the element value represented by the Java bean thinkness
  *   @param iThinkness The Java bean for this element
  */
  void printthinkness(thinkness iThinkness)
  {
    System.out.println(iThinkness.getElementValue());
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
  * Set the element type to the specified value
  *   @param iType The Java bean for this element
  *   @return type The Java bean
  */
  type inittype(type iType)
  {
    iType.updateElementValue("type");
    return iType;
  }

  /**
  * Print the element value represented by the Java bean type
  *   @param iType The Java bean for this element
  */
  void printtype(type iType)
  {
    System.out.println(iType.getElementValue());
  }

  /**
  * Set the element width to the specified value
  *   @param iWidth The Java bean for this element
  *   @return width The Java bean
  */
  width initwidth(width iWidth)
  {
    iWidth.updateElementValue("width");
    return iWidth;
  }

  /**
  * Print the element value represented by the Java bean width
  *   @param iWidth The Java bean for this element
  */
  void printwidth(width iWidth)
  {
    System.out.println(iWidth.getElementValue());
  }

  /**
  * Create a new XML document using the generated outGoingFactory class
  *   @param filename The XML file name
  */
  void createNewInstance(String filename)
  {
    iOutGoingFactory = new outGoingFactory();
    iOutGoingFactory.setPackageName("com.sizeSample");

    // include schemaLocation hint for validation
    iOutGoingFactory.setXSDFileName("sampleSizeData1.xsd");

    // encoding for output document
    iOutGoingFactory.setEncoding("UTF8");

    // encoding tag for xml declaration
    iOutGoingFactory.setEncodingTag("UTF-8");

    // Create the root element in the document using the specified root element name
    iOutGoing = (outGoing) iOutGoingFactory.createRoot("outGoing");
    createoutGoing();

    iOutGoingFactory.save(filename);
  }

  /**
  * Load an XML document using the generated outGoingFactory class
  *   @param filename An existing XML file name
  */
  void loadExistingInstance(String filename)
  {
    iOutGoingFactory = new outGoingFactory();
    iOutGoingFactory.setPackageName("com.sizeSample");

    // Load the document
    iOutGoing = (outGoing) iOutGoingFactory.loadDocument(filename);
    //printoutGoing();
  }

  /**
  * The main program.
  * Creates an example XML document and then loads it
  */
  public static void main(String args[])
  {
    SizeFileSupport sample = new SizeFileSupport();
    sample.createNewInstance("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/OutGoing/sampleSizeData1Sample.xml");
    sample.loadExistingInstance("C:/pavan/j2eeWork/ws-studio-ie-workspace/xml-test/HTMLtoXSLProject/OutGoing/sampleSizeData1Sample.xml");
  }
}

