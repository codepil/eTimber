<?xml version="1.0"?>
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:import href="LoadSample-presentationLogic.xsl"/>
  

  <xsl:template match="/*">
    <xsl:call-template name="printincomingLobs">
            <xsl:with-param name="lorryName">
              <xsl:value-of select=".//loadDetails/lorryName"/>
            </xsl:with-param>
            <xsl:with-param name="estateName">
              <xsl:value-of select=".//loadDetails/estateName"/>
            </xsl:with-param>
            <xsl:with-param name="date">
              <xsl:value-of select=".//loadDetails/date"/>
            </xsl:with-param>
      </xsl:call-template>
  </xsl:template>
  

  <xsl:template name="handleload">
    <xsl:for-each select="load">
      <xsl:call-template name="printload">
        <xsl:with-param name="SNo">
          <xsl:value-of select="./SNo"/>
        </xsl:with-param>
        <xsl:with-param name="Length">
          <xsl:value-of select="./Length"/>
        </xsl:with-param>
        <xsl:with-param name="Girth">
          <xsl:value-of select="./Girth"/>
        </xsl:with-param>
        <xsl:with-param name="Quantity">
          <xsl:value-of select="./Quantity"/>
        </xsl:with-param>
        <xsl:with-param name="ClassA">
          <xsl:value-of select="./ClassA"/>
        </xsl:with-param>
        <xsl:with-param name="ClassB">
          <xsl:value-of select="./ClassB"/>
        </xsl:with-param>
        <xsl:with-param name="ClassC">
          <xsl:value-of select="./ClassC"/>
        </xsl:with-param>
        <xsl:with-param name="ClassD">
          <xsl:value-of select="./ClassD"/>
        </xsl:with-param>
        <xsl:with-param name="TotalCFT">
          <xsl:value-of select="./TotalCFT"/>
        </xsl:with-param>
        <xsl:with-param name="Rate">
          <xsl:value-of select="./Rate"/>
        </xsl:with-param>
        <xsl:with-param name="Amount">
          <xsl:value-of select="./Amount"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handletotal">
    <xsl:for-each select="total">
      <xsl:call-template name="printtotal">
        <xsl:with-param name="ClassAcft">
          <xsl:value-of select="./ClassAcft"/>
        </xsl:with-param>
        <xsl:with-param name="ClassBcft">
          <xsl:value-of select="./ClassBcft"/>
        </xsl:with-param>
        <xsl:with-param name="ClassCcft">
          <xsl:value-of select="./ClassCcft"/>
        </xsl:with-param>
        <xsl:with-param name="ClassDcft">
          <xsl:value-of select="./ClassDcft"/>
        </xsl:with-param>
        <xsl:with-param name="tCFT">
          <xsl:value-of select="./tCFT"/>
        </xsl:with-param>
        <xsl:with-param name="tAmount">
          <xsl:value-of select="./tAmount"/>
        </xsl:with-param>
        <xsl:with-param name="Lobs">
          <xsl:value-of select="./Lobs"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleincomingLobs">
    <xsl:for-each select="incomingLobs">
      <xsl:call-template name="printincomingLobs">
        <xsl:with-param name="lorryName">
          <xsl:value-of select="./loadDetails/lorryName"/>
        </xsl:with-param>
        <xsl:with-param name="estateName">
          <xsl:value-of select="./loadDetails/estateName"/>
        </xsl:with-param>
        <xsl:with-param name="date">
          <xsl:value-of select="./loadDetails/date"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

</xsl:transform>
