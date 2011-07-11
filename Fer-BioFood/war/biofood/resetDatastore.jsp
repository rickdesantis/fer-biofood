<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Reset del Datastore</title>
</head>
<body>
<h1>Reset manuale del Datastore</h1>
<%
	String d = (String) request.getAttribute("done");
	if (d != null) {
		out.println("<p>Hai resettato " + d + ".</p>");
	}
%>
Scegli un comando (seguendo l'ordine):
<ul>
<li><a href="resetDatastore?n=tuttoproduttore">Resetta tutto per i Produttori</a>, oppure, singolarmente:</li>
<ul>
	<li><a href="resetDatastore?n=tipoproduttore">Resetta TipiProduttori</a></li>
	<li><a href="resetDatastore?n=produttore">Resetta Produttori</a></li>
	<li><a href="resetDatastore?n=fotoproduttori">Resetta FotoProduttori</a></li>
</ul>
<li><a href="resetDatastore?n=tuttoprodotti">Resetta tutto per i Prodotti</a>, oppure, singolarmente:</li>
<ul>
	<li><a href="resetDatastore?n=tipoprodotto">Resetta TipiProdotti</a></li>
	<li><a href="resetDatastore?n=esigenze">Resetta Esigenze</a></li>
	<li><a href="resetDatastore?n=prodotto">Resetta Prodotti</a></li>
	<li><a href="resetDatastore?n=fotoprodotti">Resetta FotoProdotti</a></li>
	<li><a href="resetDatastore?n=offerte">Resetta Offerte</a></li>
</ul>
</ul>
<p>NOTA: se selezioni una voce, devi selezionare poi anche tutte quelle sotto!</p>
</body>
</html>
