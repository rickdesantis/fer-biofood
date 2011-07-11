<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="java.util.List" %>

	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	    <title>BioFood</title>
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
        	<li ><a href="tipiProdotto">Prodotti per tipo</a></li>
            
    	</ul> 
      </div>
  </div>
  <div id="content">
  
	<div class="padding"><h2>Tipo prodotti: ${n}</h2>
		<%
			List<String> pr = (List<String>) request.getAttribute("prodotti");
			if (pr.size() > 0) {
		%>
		<ul id="productList" >
        	<%
				
				
				for (int i = 0; i < pr.size(); ++i) {
					out.println("<li><a href=\"prodotto?n=" + pr.get(i).replace(" ", "+") + "\">" + pr.get(i) + "</a></li>");
				}
			%>
    	</ul>
    	<%
    		} else {
    			out.println("<p>Nessun elemento trovato!</p>");
    		}
    	%>
</div>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>