<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
a
{
	text-decoration: none;
	box-shadow:gray 0px 0px 1px 1px;
	padding:7px
}
li
{
	float:left;
	padding:7px
}
a:hover
{
	background-color:black;
	color:white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="box-shadow: gray 0px 0px 6px 6px;width:600px;margin-left:300px;height:150px" align="center" >
		<table align="left" style="margin-left:20px;margin-top:10px">
			<tr>
				<td>
					<ul style="float:left;list-style:none;">
						<li><a href="Alltransaction">voir les transactions</a></li>
						<li><a href="jspring_security_logout">Se déconnecter</a></li>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Bonjour Monsieur : ${nom_prenom}</td>
			</tr>
		</table>
		
	<p></p>
	</div>

</body>
</html>