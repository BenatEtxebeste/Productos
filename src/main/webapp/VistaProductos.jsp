<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>

<style>
h1 {
	font-family: 'Amarante', Tahoma, sans-serif;
	font-weight: bold;
	font-size: 3.6em;
	line-height: 1.7em;
	margin-bottom: 10px;
	text-align: center;
}

#keywords {
	margin: 0 auto;
	font-size: 1.2em;
	margin-bottom: 15px;
}

#keywords thead {
	cursor: pointer;
	background: #c9dff0;
}

#keywords thead tr th {
	font-weight: bold;
	padding: 12px 30px;
	padding-left: 42px;
}

#keywords thead tr th span {
	padding-right: 20px;
	background-repeat: no-repeat;
	background-position: 100% 100%;
}

#keywords thead tr th.headerSortUp, #keywords thead tr th.headerSortDown
	{
	background: #acc8dd;
}

#keywords tbody tr {
	color: #555;
}

#keywords tbody tr td {
	text-align: center;
	padding: 15px 10px;
}

a {
	text-decoration: none;
	color: #555;
}

a:hover {
	color: lightblue;
}

#menu {
	display: inline-flex;
	list-style: none;
	margin-left: 38%;
	margin-bottom: 100px;
}

#menu li a {
	position: relative;
	font-weight: bold;
	color: rgb(0, 183, 255);
	margin: 0px 60px;
	text-decoration: none;
}

#menu li a:after {
	position: absolute;
	bottom: 7px;
	left: 0px;
	width: 100%;
	height: 4px;
	background-color: rgb(32, 32, 226);
	content: "";
	opacity: 0;
	transition: opacity 0.3s ease 0s, transform 0.3s ease 0s;
	transform: translateY(20px);
}

#menu li a:hover:after {
	opacity: 1;
	transform: translateY(15px)
}

.menuRayas li {
	list-style: none;
	padding: 0.6em 1em;
	background-color: #fff;
}

.menuRayas li a {
	text-decoration: none;
	color: #333;
}

.menuRayas li a:hover {
	color: rgb(32, 32, 226);
}

.open-hide {
	background-color: white;
	width: 35px;
	height: 35px;
	display: block;
	background-image:
		url(https://cdn-icons-png.flaticon.com/512/54/54206.png);
	/*https://s3-us-west-2.amazonaws.com/s.cdpn.io/6001/menu.png*/
	background-repeat: no-repeat;
	background-position: center center;
	background-size: 25px;
	text-indent: -9999em;
	margin-top: -650px;
	border-radius: 10px;
}

.open-hide:hover {
	cursor: pointer;
}

.menuRayas {
	height: 0px;
	-webkit-transition: all 0.2s ease;
	-moz-transition: all 0.2s ease;
	-o-transition: all 0.2s ease;
	transition: all 0.2s ease;
	width: 10em;
	overflow: hidden;
	margin-top: 0;
	padding: 0;
	box-sizing: border-box;
}

.menuRayas:hover {
	height: 320px;
	padding-top: 1em;
}

.open-hide:hover+.menuRayas {
	height: 320px;
	padding-top: 1em;
}
</style>

<body>
	
		<ul id="menu">
			<li><a href="FormularioInsertarProducto" title="CREAR">CREAR</a></li>
			<li><a href="VistaProducto.jsp" title="VISTAS">VISTAS</a></li>
		</ul>

		<h1>Productos</h1>

		<table id="keywords" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><span>id</span></th>
					<th><span>codigo</span></th>
					<th><span>nombre</span></th>
					<th><span>cantidad</span></th>
					<th><span>precio</span></th>
					<th><span>caducidad</span></th>
					<th><span>id_seccion</span></th>
				</tr>
			</thead>
			<tbody>
	  <c:forEach items="${productos}" var="productos">
	    <tr>
	      <th scope="row">${productos.id}</th>
	      <td>${productos.codigo}</td>
	      <td>${productos.nombre}</td>
	      <td>${productos.cantidad}</td>
	      <td>${productos.precio}</td>
	      <td>${productos.caducidad}</td>
	      <td>${productos.seccion.nombre}</td>
	    </tr>
	  </c:forEach>
  </tbody>
		</table>
	</div>
</body>
</html>