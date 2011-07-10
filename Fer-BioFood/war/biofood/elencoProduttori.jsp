<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="org.slim3.datastore.Datastore" %>
<%@page import="it.aip.mcdonald.meta.TipoProduttoreMeta" %>
<%@page import="it.aip.mcdonald.model.TipoProduttore" %>
<%@page import="java.util.List" %>	
    
    
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	    <meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	    <title>biofood ElencoProduttori</title>
	    <meta http-equiv="Content-Language" content="en-us" />
	     
	    <meta http-equiv="imagetoolbar" content="no" />
	    <meta name="MSSmartTagsPreventParsing" content="true" />
	     
	    <meta name="description" content="Description" />
	    <meta name="keywords" content="Keywords" />
	     
	    <meta name="author" content="Enlighten Designs" />
	     
	    <style type="text/css" media="all">@import "../css/BioStyle.css";</style>  <style type="text/css" media="all">@import "../biofood/css/BioStyle.css";</style>
	</head>
	 
<body>
<div id="page-container">
  <div id="header"><h1></h1></div>
  <div  id="landmarks">
	<ul >
        	<li ><a href="elencoProduttori.jsp">Produttori</a></li>
            <li ><a href="#">Info Alimenti</a></li>
            <li ><a href="#">Ricette</a></li>
            <li><a href="#">Diete</a></li>
            <li ><a href="#">Offerte</a></li>
            <li ><a href="#">Come Acquistare</a></li>
            <li ><a href="#">Il Consorzio</a></li>
            <li><a href="#">Cibo Bio</a></li> 
        </ul>
  </div>
<div id="sidebar">
   	  <div class="padding"></div>
    </div>
  <div id="content">
  <img id= "toprightimage" src="images/cc-carne.gif" width="256" height="200" alt="carnazza" />
<div class="padding"><h2>Elenco Produttori</h2>
	    <ul>
<%
	TipoProduttoreMeta e = TipoProduttoreMeta.get();
    List<TipoProduttore> list = Datastore.query(e).asList();
	for ( TipoProduttore u: list) {
		out.println( "<li>" + u.getNome() + "</li>");
	}
%>
</ul></div>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>