<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div  style="box-shadow: gray 0px 0px 6px 6px;width:600px;margin-left:300px" align="center" >
		<img alt="banque" src="${pageContext.request.contextPath}/resources/images.jpg" style="width:600px;height:100px">
		<c:if test="${size>0}">
			<table border="2" cellpadding="3px" cellspacing="0px">
					<caption style="margin-bottom:8px"><b><u>liste des cash retracted</u></b></caption>
						<tr>
				    		<th>compte client</th>
				    		<th>montant retiré</th>
				    	</tr>
				<c:forEach items="${transactions}" var="transaction">				    
				    	<tr>
				    		<td>${transaction.userLogin}</td>
				    		<td>${transaction.montant}</td>
				    	</tr>
				</c:forEach>
			</table>
			<pre></pre>
			<div style="margin-left:155px;text-align:left"><a href="http://localhost:8080/ql/reglerCA" >régler le cash retracted</a></div>
		</c:if>
		
			<pre>
			</pre>
				<div style="text-align:left;margin-left:10px"><a href="http://localhost:8080/ql/admin">retour</a></div>
			
	</div>	
</body>
</html>