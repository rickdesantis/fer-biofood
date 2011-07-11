<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="org.slim3.datastore.Datastore" %>
<%@page import="it.aip.mcdonald.meta.OffertaMeta" %>
<%@page import="it.aip.mcdonald.model.Offerta" %>
<%@page import="it.aip.mcdonald.meta.ProdottoMeta" %>
<%@page import="it.aip.mcdonald.model.Prodotto" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>

	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	    <title>CompanyName - PageName</title>
	    <meta http-equiv="Content-Language" content="en-us" />
	     
	    <meta http-equiv="imagetoolbar" content="no" />
	    <meta name="MSSmartTagsPreventParsing" content="true" />
	     
	    <meta name="description" content="Description" />
	    <meta name="keywords" content="Keywords" />
	     
	    <meta name="author" content="Enlighten Designs" />
	     
	    <style type="text/css" media="all">@import "../css/BioStyle.css";</style>  <style type="text/css" media="all">@import "../css/BioStyle.css";</style>
	</head>
	 
<body>
<div id="page-container">
  <div id="header"><h1></h1></div>
<%@ include file="landmarks.html" %>
<div id="sidebar">
   	  <div class="padding">
       <ul id="transLink" >
       		<li ><a href="#">Prodotti</a></li>
        	<li ><a href="#">Esigenze speciali</a></li>
            
    	</ul> 
      </div>
  </div>
  <div id="content">
  
  <img id= "toprightimage" src="images/cc-carne.gif" width="256" height="200" alt="carnazza" />
	<div class="padding">
	  <h2>Offerte</h2>
		<ul id="offertList" >
        	<%
				List<String> pr = (List<String>) request.getAttribute("prodotti");
				List<Date> scadenze = (List<Date>) request.getAttribute("scadenze");
				
				for (int i = 0; i < pr.size(); ++i) {
					out.println("<li><a href=\"prodotto?n=" + pr.get(i).replace(" ", "+") + "\">" + pr.get(i) + " (fino al " + scadenze.get(i) + ")</a></li>");
				}
			%>
    	</ul>
</div>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>