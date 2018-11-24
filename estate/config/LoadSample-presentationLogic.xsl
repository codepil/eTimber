<?xml version="1.0"?>
<?HTMLTemplate version="0.1"?>
<!--================================================================================-->
<!--  This file was generated by IBM's HTMLToXSL Generator.                         -->
<!--================================================================================-->
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <?HTMLTemplate version="0.1"?>
  

  <!--================================================================================-->
  <!--  printincomingLobs                                                             -->
  <!--================================================================================-->
  <xsl:template name="printincomingLobs">
    <xsl:param name="date"/>
    <xsl:param name="estateName"/>
    <xsl:param name="lorryName"/>
    <html>
      <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="Content-Type"/>
        <meta content="IBM WebSphere Studio" name="GENERATOR"/>
        <link rel="stylesheet" type="text/css" href="../../../jars/config/mystyle.css"/>
      </head>
      <body>
      
      <BR/>
        
          <table class="others" border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr align="left">
                <td>
                  <b>Lorry Name:&#160;&#160; </b>
                  <xsl:value-of select="$lorryName"/>
                  <br />
                  <b>Estate:&#160;&#160; </b>
                  <xsl:value-of select="$estateName"/>
                  <br />
                  <b>Date:&#160;&#160; </b>
                  <xsl:value-of select="$date"/>
                </td>
              </tr>
            </tbody>
          </table>
        
        <hr/>
        
          <table class="lobs" border="1" cellpadding="0" cellspacing="0">
              <thead>
              <tr align="center" bgcolor="#00ff00" valign="middle">
                <th>SNo&#160;</th>
                <th>Length&#160;</th>
                <th>Girth&#160;</th>
                <th>Qnty&#160;</th>
                <th>ClassA&#160;</th>
                <th>ClassB&#160;</th>
                <th>ClassC&#160;</th>
                <th>ClassD&#160;</th>
                <th>Total CFT&#160;</th>
                <th>Rate&#160;</th>
                <th>Amount&#160;</th>
              </tr>
              </thead>
              
              <tbody>
                <xsl:call-template name="handleload"/>
              </tbody>
          </table>
        
        <br/>
        
          <table class="total" border="1" cellpadding="0" cellspacing="0">
            <tbody>
              <tr align="center" valign="middle" bgcolor="#8080ff">
                <th>
                  <b>Class A&#160;</b>
                </th>
                <th>
                  <b>Class B&#160;</b>
                </th>
                <th>
                  <b>Class C&#160;</b>
                </th>
                <th>
                  <b>Class D&#160;</b>
                </th>
                <th>
                  <b>Total CFT&#160;</b>
                </th>
                <th>
                  <b>Amount&#160;</b>
                </th>
                <th>
                  <b>#Logs&#160;</b>
                </th>
              </tr>
              <xsl:call-template name="handletotal"/>
            </tbody>
          </table>
        
      </body>
    </html>
  </xsl:template>
  

  <!--================================================================================-->
  <!--  printload                                                                     -->
  <!--================================================================================-->
  <xsl:template name="printload">
    <xsl:param name="Amount"/>
    <xsl:param name="Rate"/>
    <xsl:param name="TotalCFT"/>
    <xsl:param name="ClassD"/>
    <xsl:param name="ClassC"/>
    <xsl:param name="ClassB"/>
    <xsl:param name="ClassA"/>
    <xsl:param name="Quantity"/>
    <xsl:param name="Girth"/>
    <xsl:param name="Length"/>
    <xsl:param name="SNo"/>
    <tr align="center" valign="middle">
      <td>
        <xsl:value-of select="$SNo"/>
      </td>
      <td>
        <xsl:value-of select="$Length"/>
      </td>
      <td>
        <xsl:value-of select="$Girth"/>
      </td>
      <td>
        <xsl:value-of select="$Quantity"/>
      </td>
      <td>
        <xsl:value-of select="$ClassA"/>
      </td>
      <td>
        <xsl:value-of select="$ClassB"/>
      </td>
      <td>
        <xsl:value-of select="$ClassC"/>
      </td>
      <td>
        <xsl:value-of select="$ClassD"/>
      </td>
      <td>
        <xsl:value-of select="$TotalCFT"/>
      </td>
      <td>
        <xsl:call-template name="printVar">
			   <xsl:with-param name="var">
			      <xsl:value-of select="$Rate"/>
		           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:call-template name="printVar">
		   <xsl:with-param name="var">
		      <xsl:value-of select="$Amount"/>
	           </xsl:with-param>
        </xsl:call-template>
      </td>
    </tr>
  </xsl:template>
  

  <!--================================================================================-->
  <!--  printtotal                                                                    -->
  <!--================================================================================-->
  <xsl:template name="printtotal">
    <xsl:param name="Lobs"/>
    <xsl:param name="tAmount"/>
    <xsl:param name="tCFT"/>
    <xsl:param name="ClassDcft"/>
    <xsl:param name="ClassCcft"/>
    <xsl:param name="ClassBcft"/>
    <xsl:param name="ClassAcft"/>
    <tr align="center" valign="middle">
      <td>
        <xsl:call-template name="printVar">
		   <xsl:with-param name="var">
		      <xsl:value-of select="$ClassAcft"/>
	           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:call-template name="printVar">
		   <xsl:with-param name="var">
		      <xsl:value-of select="$ClassBcft"/>
	           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:call-template name="printVar">
		   <xsl:with-param name="var">
		      <xsl:value-of select="$ClassCcft"/>
	           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:call-template name="printVar">
		   <xsl:with-param name="var">
		      <xsl:value-of select="$ClassDcft"/>
	           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:call-template name="printVar">
		   <xsl:with-param name="var">
		      <xsl:value-of select="$tCFT"/>
	           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:call-template name="printVar">
	   <xsl:with-param name="var">
	      <xsl:value-of select="$tAmount"/>
           </xsl:with-param>
        </xsl:call-template>
      </td>
      <td>
        <xsl:value-of select="$Lobs"/>
      </td>
    </tr>
  </xsl:template>
  
   <!--================================================================================-->
    <!--  Formats & prints the decimal into xx.yy string                                -->
    <!--================================================================================-->
    
  <xsl:template name="printVar">
      <xsl:param name="var" select="0.0"/>
      <xsl:if test="$var != ''">
      <xsl:if test="$var != 0.0">
      <xsl:if test="contains($var,'.')">
        <xsl:variable name="deci" select="substring-after($var,'.')" />
        <xsl:variable name="int" select="substring-before($var,'.')" />
          <xsl:value-of select="concat($int, '.', substring($deci,1,2))"/>      
      </xsl:if>
      </xsl:if>
      </xsl:if>
  </xsl:template>


  <!--================================================================================-->
  <!--  Overide these methods to specify parameters and control flow logic            -->
  <!--================================================================================-->
  

  <xsl:template name="handleload">
    <xsl:call-template name="printload"/>
  </xsl:template>
  

  <xsl:template name="handletotal">
    <xsl:call-template name="printtotal"/>
  </xsl:template>
</xsl:transform>
