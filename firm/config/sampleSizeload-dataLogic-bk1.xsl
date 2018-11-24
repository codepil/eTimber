<?xml version="1.0"?>
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:import href="sampleSizeload-presentationLogic.xsl"/>
  

  <xsl:template match="/*">
    <xsl:call-template name="printoutGoing"/>
  </xsl:template>
  

  <xsl:template name="handleFirmDetails">
    <xsl:for-each select="FirmDetails">
      <xsl:call-template name="printFirmDetails">
        <xsl:with-param name="firmName">
          <xsl:value-of select="./firmName"/>
        </xsl:with-param>
        <xsl:with-param name="firmAddress">
          <xsl:value-of select="./firmAddress"/>
        </xsl:with-param>
        <xsl:with-param name="billNo">
          <xsl:value-of select="./billNo"/>
        </xsl:with-param>
        <xsl:with-param name="orderNo">
          <xsl:value-of select="./orderNo"/>
        </xsl:with-param>
        <xsl:with-param name="articles">
          <xsl:value-of select="./articles"/>
        </xsl:with-param>
        <xsl:with-param name="lorryName">
          <xsl:value-of select="./lorryName"/>
        </xsl:with-param>
        <xsl:with-param name="date">
          <xsl:value-of select="./date"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleload">
    <xsl:for-each select="load">
      <xsl:call-template name="printload">
        <xsl:with-param name="length">
          <xsl:value-of select="./length"/>
        </xsl:with-param>
        <xsl:with-param name="width">
          <xsl:value-of select="./width"/>
        </xsl:with-param>
        <xsl:with-param name="thinkness">
          <xsl:value-of select="./thinkness"/>
        </xsl:with-param>
        <xsl:with-param name="qnt">
          <xsl:value-of select="./qnt"/>
        </xsl:with-param>
        <xsl:with-param name="rft">
          <xsl:value-of select="./rft"/>
        </xsl:with-param>
        <xsl:with-param name="cft">
          <xsl:value-of select="./cft"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleloadTotal">
    <xsl:for-each select="loadTotal">
      <xsl:call-template name="printloadTotal">
        <xsl:with-param name="qnt">
          <xsl:value-of select="./qnt"/>
        </xsl:with-param>
        <xsl:with-param name="rft">
          <xsl:value-of select="./rft"/>
        </xsl:with-param>
        <xsl:with-param name="cft">
          <xsl:value-of select="./cft"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handlesizeData">
    <xsl:for-each select="sizeData">
      <xsl:call-template name="printsizeData"/>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handlerowData">
    <xsl:for-each select="rowData">
      <xsl:call-template name="printrowData"/>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handlesizeTotal">
    <xsl:for-each select="sizeTotal">
      <xsl:call-template name="printsizeTotal">
        <xsl:with-param name="planks">
          <xsl:value-of select="./planks"/>
        </xsl:with-param>
        <xsl:with-param name="Runners">
          <xsl:value-of select="./Runners"/>
        </xsl:with-param>
        <xsl:with-param name="Battons">
          <xsl:value-of select="./Battons"/>
        </xsl:with-param>
        <xsl:with-param name="SLR">
          <xsl:value-of select="./SLR"/>
        </xsl:with-param>
        <xsl:with-param name="Lapha">
          <xsl:value-of select="./Lapha"/>
        </xsl:with-param>
        <xsl:with-param name="totalCFT">
          <xsl:value-of select="./totalCFT"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleoutGoing">
    <xsl:for-each select="outGoing">
      <xsl:call-template name="printoutGoing"/>
    </xsl:for-each>
  </xsl:template>
  

</xsl:transform>
