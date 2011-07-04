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
<title>biofood ElencoProduttori</title>
</head>
<body>
<p>Hello biofood ElencoProduttori !!!</p>
<ul>
<%
	TipoProduttoreMeta e = TipoProduttoreMeta.get();
    List<TipoProduttore> list = Datastore.query(e).asList();
	for ( TipoProduttore u: list) {
		out.println( "<li>" + u.getNome() + "</li>");
	}
%>
</ul>
</body>
</html>
