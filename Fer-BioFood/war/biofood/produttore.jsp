<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="it.aip.mcdonald.model.Produttore" %>
<%@page import="org.slim3.datastore.Datastore" %>
<%@page import="it.aip.mcdonald.meta.ProduttoreMeta" %>

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
      	<ul id="structLink" >
    	</ul>
        
       <ul id="transLink" >
        	<li ><a href="prodottiPerProduttore?n=${produttore.nome}">Prodotti</a></li>
    	</ul> 
      </div>
  </div>
  <div id="content">
  <%
  	if (request.getAttribute("foto") != null) { %>
  <img id= "toprightimage" src="${foto}" alt="${produttore.nome}" />
  <% } %>
	<div class="padding"><h2>${produttore.nome}</h2>
	  <p>${f:h(produttore.descr)}</p>
	  <h4>Come contattarci</h4>
	  <ul>
	  	<li>Email: <a href="mailto:${produttore.mail}">${produttore.mail}</a></li>
	  	<li>Telefono: ${produttore.telefono}</li>
	  	<li>Indirizzo: ${produttore.indirizzo}</li> 
	  	<img src="${map}" />
	  </ul>
</div>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>