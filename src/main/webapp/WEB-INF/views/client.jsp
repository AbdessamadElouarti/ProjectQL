<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="box-shadow: gray 0px 0px 6px 6px;width:600px;margin-left:300px;height:150px" align="center" >
		<table cellpadding="6px" cellspacing="4px">
			<tr>
				<th>Bonjour Monsieur :</th><td>${nom_prenom}</th>
			</tr>
			<tr>
				<th>votre montant totale est :</th><td> ${montant}</td>
			</tr>
		</table>
		<a href="j_spring_security_logout" style="float:left">Se déconnecter</a>
	</div>
	
</body>
</html>