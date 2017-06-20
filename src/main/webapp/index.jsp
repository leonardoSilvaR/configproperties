<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.br.configproperties.loader.ConfigPropertiesLoader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Properties Loader!</title>
    </head>
    <body>
        <h1>Carregando um arquivo de propriedades pelo classpath do tomcat</h1>
        <% ConfigPropertiesLoader cp = new ConfigPropertiesLoader();
            cp.loadProperties();
            request.setAttribute("propriedades", cp.values);
        %>
        <table>
            <tr>
                <th>Chave</th>
                <th>valor</th>
            </tr>
            <c:forEach var="prop" items="${propriedades}">
                <tr>
                    <td>${prop.key}</td>
                    <td>${prop.value}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
