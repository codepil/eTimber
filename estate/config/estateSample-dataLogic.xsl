<?xml version="1.0"?>
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:import href="estateSample-presentationLogic.xsl"/>
  

  <xsl:template match="/*">
    <xsl:call-template name="printIncoming"/>
  </xsl:template>
  

  <xsl:template name="handleEstate">
    <xsl:for-each select="Estate">
      <xsl:call-template name="printEstate">
        <xsl:with-param name="PlanterName">
          <xsl:value-of select="./PlanterName"/>
        </xsl:with-param>
        <xsl:with-param name="PlantAddress">
          <xsl:value-of select="./PlantAddress"/>
        </xsl:with-param>
        <xsl:with-param name="SyNo">
          <xsl:value-of select="./SyNo"/>
        </xsl:with-param>
        <xsl:with-param name="CoupContractor">
          <xsl:value-of select="./CoupContractor"/>
        </xsl:with-param>
        <xsl:with-param name="tcft">
	  <xsl:value-of select="./tcft"/>
        </xsl:with-param>
        <xsl:with-param name="discount">
	  <xsl:value-of select="./discount"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleload">
    <xsl:for-each select="load">
      <xsl:call-template name="printload">
        <xsl:with-param name="SNo">
          <xsl:value-of select="./SNo"/>
        </xsl:with-param>
        <xsl:with-param name="Date">
          <xsl:value-of select="./Date"/>
        </xsl:with-param>
        <xsl:with-param name="LorryNumber">
          <xsl:value-of select="./LorryNumber"/>
        </xsl:with-param>
        <xsl:with-param name="Tape">
          <xsl:value-of select="./Tape"/>
        </xsl:with-param>
        <xsl:with-param name="Clerk">
          <xsl:value-of select="./Clerk"/>
        </xsl:with-param>
        <xsl:with-param name="Logs">
          <xsl:value-of select="./Logs"/>
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
        <xsl:with-param name="Unload">
          <xsl:value-of select="./Unload"/>
        </xsl:with-param>
        <xsl:with-param name="DelNo">
          <xsl:value-of select="./DelNo"/>
        </xsl:with-param>
        <xsl:with-param name="Stumps">
          <xsl:value-of select="./Stumps"/>
        </xsl:with-param>
      </xsl:call-template>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleLoadDetails">
    <xsl:for-each select="LoadDetails">
      <xsl:call-template name="printLoadDetails"/>
    </xsl:for-each>
  </xsl:template>
  

  <xsl:template name="handleIncoming">
    <xsl:for-each select="Incoming">
      <xsl:call-template name="printIncoming"/>
    </xsl:for-each>
  </xsl:template>
  

</xsl:transform>
