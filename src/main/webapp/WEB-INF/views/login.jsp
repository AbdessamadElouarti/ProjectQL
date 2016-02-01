<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>application </title>
</head>
<body>
		<div style="box-shadow: gray 0px 0px 6px 6px;width:600px;margin-left:300px" align="center" >
			<img alt="banque" src="${pageContext.request.contextPath}/resources/images.jpg" style="width:600px;height:100px">
			 <form action="j_spring_security_check" method="post">
		            <center>
		            <table  width="30%" cellpadding="6px" cellspacing="0px">
		                <thead>
		                    <tr>
		                        <th colspan="2">page de Login</th>
		                    </tr>
		                </thead>
		                <tbody>
		                    <tr>
		                        <td>login</td>
		                        <td><input type="text" name="username"  /></td>
		                    </tr>
		                    <tr>
		                        <td>mot de passe</td>
		                        <td><input type="password" name="password"  /></td>
		                    </tr>
		                    <tr>
		                        <td><input type="submit" value="Login" /></td>
		                        <td><input type="reset" value="Reset" /></td>
		                    </tr>
		                </tbody>
		            </table>
		            </center>
		        </form>
	        </div>
</body>
</html>