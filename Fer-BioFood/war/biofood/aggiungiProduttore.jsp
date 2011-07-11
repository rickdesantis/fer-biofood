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
<%@ include file="landmarks.html" %>
<div id="sidebar">
   	  <div class="padding"></div>
    </div>
  <div id="content">
<div class="padding"><h2>Inserisci nuovo Produttore</h2>
	  <form action="accettaProduttore" method="post">
<ul>
	<li> Nome:<input name="nome" type="text"> </li> 
    <li>Descrizione: <textarea name="descr" cols="" rows=""></textarea> </li> 
     <li>email: <input name="mail" type="text"> </li>
     <li>telefono: <input name="telefono" type="text"> </li>  
     <li>indirizzo: <input name="indirizzo" type="text"> </li> 
     <li>password: <input name="password" type="text"> </li> 
     <li>verifica password : <input name="verifica" type="text"> </li> 
     <li>tipo: <select name="tipo">
       
     <%
	 	TipoProduttoreMeta e = TipoProduttoreMeta.get();
        List<TipoProduttore> list = Datastore.query(e).asList();
		for ( TipoProduttore u : list) {
			out.println("<option>" + u.getNome() + "</option>");
		}
	 %>	
      
    </select> </li> 
 </ul>
 <input name="" type="submit"> 
</form>  
	
</div>
  </div>
  <div id="footer"></div>
</div>

</body>
</html>