<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@page import="org.slim3.datastore.Datastore" %>
<%@page import="it.aip.mcdonald.meta.TipoProduttoreMeta" %>
<%@page import="it.aip.mcdonald.model.TipoProduttore" %>
<%@page import="java.util.List" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>biofood AggiungiProduttore</title>
</head>
<body>
<p>Hello biofood AggiungiProduttore !!!</p>

<form action="accettaProduttore" method="post">
<ul>
	<li> Nome:<input name="nome" type="text"> </li> 
    <li>Descrizione: <textarea name="descr" cols="" rows=""></textarea> </li> 
     <li>email: <input name="mail" type="text"> </li> 
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
</body>
</html>
