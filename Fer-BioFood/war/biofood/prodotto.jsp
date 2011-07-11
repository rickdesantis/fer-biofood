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
      	<ul id="structLink" >
    	</ul>
        
       <ul id="transLink" >
       		<li><a href="tipoProdotto?n=${tipo}">Prodotti dello stesso tipo</a></li>
        	<li><a href="produttore?n=${produttore}">Produttore</a></li>
            <li><a href="#">Ricette</a></li>
            
    	</ul> 
      </div>
  </div>
  <div id="content">
  <%
  	if (request.getAttribute("foto") != null) { %>
  <img id= "toprightimage" src="${foto}" alt="${prodotto.nome}" />
  <% } %>
	<div class="padding"><h2>${prodotto.nome}</h2>
	<p>${f:h(prodotto.descr)}</p>
	<h4>Informazioni nutrizionali</h4>
	<p>${f:h(prodotto.infoNutrizionali)}</p>
	<%
		List<String> esigenze = (List<String>) request.getAttribute("esigenze");
		if (esigenze.size() > 0) {
	%>
	<h4>Buono per le seguenti esigenze</h4>
	<ul>
	<%
		for (String s : esigenze) {
			%> <li><a href="esigenza?n=<%= s.replaceAll(" ", "+") %>"><%= s %></a></li> <%
		} %>
	</ul>
	<% } %>
</div>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>