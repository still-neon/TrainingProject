<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
		xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="html"/>
	<xsl:template match="/pointsList">
		<table border="1">
			<xsl:apply-templates/>
		</table>
	</xsl:template>
	<xsl:template match="/pointsList/point">
		<tr>
			<xsl:apply-templates/>
		</tr>
	</xsl:template>
	<xsl:template match="/pointsList/point/x">
		<td>
			<xsl:value-of select="text()"/>
		</td>
	</xsl:template>
	<xsl:template match="/pointsList/point/y">
		<td>
			<xsl:value-of select="text()"/>
		</td>
	</xsl:template>
</xsl:stylesheet>