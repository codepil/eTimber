<?xml version="1.0"?>
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:import href="sampleFirmTable-presentationLogic.xsl"/>
  

  <xsl:template match="/*">
    <xsl:call-template name="printfirm"/>
  </xsl:template>
  

  <xsl:template name="handledetails">
    <xsl:for-each select="details">
      <xsl:call-template name="printdetails">
        <xsl:with-param name="firmName">
          <xsl:value-of select="./firmName"/>
        </xsl:with-param>
        <xsl:with-param name="firmAddress">
          <xsl:value-of select="./firmAddress"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleload">
    <xsl:for-each select="load">
      <xsl:call-template name="printload">
        <xsl:with-param name="sno">
          <xsl:value-of select="./sno"/>
        </xsl:with-param>
        <xsl:with-param name="orderNo">
          <xsl:value-of select="./orderNo"/>
        </xsl:with-param>
        <xsl:with-param name="loadName">
          <xsl:value-of select="./loadName"/>
        </xsl:with-param>
        <xsl:with-param name="date">
          <xsl:value-of select="./date"/>
        </xsl:with-param>
        <xsl:with-param name="runners">
          <xsl:value-of select="./runners"/>
        </xsl:with-param>
        <xsl:with-param name="planks">
          <xsl:value-of select="./planks"/>
        </xsl:with-param>
        <xsl:with-param name="battons">
          <xsl:value-of select="./battons"/>
        </xsl:with-param>
        <xsl:with-param name="SLR">
          <xsl:value-of select="./SLR"/>
        </xsl:with-param>
        <xsl:with-param name="lapha">
          <xsl:value-of select="./lapha"/>
        </xsl:with-param>
        <xsl:with-param name="others">
          <xsl:value-of select="./others"/>
        </xsl:with-param>
        <xsl:with-param name="totalCFT">
          <xsl:value-of select="./totalCFT"/>
        </xsl:with-param>
        <xsl:with-param name="amount">
          <xsl:value-of select="./amount"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handlefirm">
    <xsl:for-each select="firm">
      <xsl:call-template name="printfirm"/>
    </xsl:for-each>
  </xsl:template>
  

</xsl:transform>
