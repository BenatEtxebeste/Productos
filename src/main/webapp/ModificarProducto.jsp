<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar producto</title>
</head>

<style>
p#tituloActividad {
	font-family: 'Courier New';
	text-transform: uppercase;
	margin-left: 835px;
	margin-top: 100px;
	position: absolute;
	font-size: 40px;
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

input {
	border-radius: 10px;
	padding: 4px;
}

#LogIn {
	margin-left: 55px;
}

#formulario {
	background-color: rgb(209, 208, 208);
	width: 400px;
	height: 600px;
	margin-top: 10%;
	border-radius: 10px;
	display: inline-flex;
}

#formulario:hover {
	background-color: rgba(209, 208, 208, 0.363);
}

form {
	margin-left: 32%;
	padding-top: 15%;
}

#formulario2 {
	background-color: rgb(209, 208, 208);
	width: 850px;
	height: 600px;
	margin-top: 7.2%;
	margin-left: -300px;
	border-radius: 10px;
	display: inline-flex;
}

img {
	width: 770px;
	height: 520px;
	padding-left: 40px;
	padding-top: 40px;
	border-radius: 100px;
}

nav ul {
	display: flex;
	justify-content: space-evenly;
	list-style: none;
}

.menu li {
	list-style: none;
	padding: 0.6em 1em;
	background-color: #fff;
}

.menu li a {
	text-decoration: none;
	color: #333;
}

.menu li a:hover {
	color: rgb(32, 32, 226);
}

.open-hide {
	background-color: #fff;
	color: yellow;
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
	margin-top: -840px;
	border-radius: 10px;
}

.open-hide:hover {
	cursor: pointer;
}

.menu {
	height: 0;
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

.menu:hover {
	height: 320px;
	padding-top: 1em;
}

.open-hide:hover+.menu {
	height: 320px;
	padding-top: 1em;
}
</style>


<body>

	<P id="tituloProducto">productos</P>

	<ul id="menu">
		<li><a href="FormularioInsertarProducto" title="CREAR">CREAR</a></li>
		<li><a href="VistaProducto.jsp" title="VISUALIZAR">VISUALIZAR </a></li>
	</ul>

	<br>
	<br>
	<br>

	<nav>
		<ul>
			<li><a>
					<div id="formulario">
						<form method="POST" action="ModificarProducto">
							<label>Id: <input readonly type="number" id="id" name="id" value="${producto.id}" /></label>
							<br><br>
							<label>Codigo: <input type="text" id="codigo" name="codigo" value="${producto.codigo}" /></label> 
							<br>
							<br> 
							<label>Nombre: <input type="text" id="nombre" name="nombre" value="${producto.nombre}" /></label> 
							<br>
							<br> 
							<label>Cantidad: <input type="number" id="cantidad" name="cantidad" value="${producto.cantidad}" /></label> 
							<br>
							<br>
							<label>Precio: <input type="text" id="precio" name="precio" value="${producto.precio}" /></label> 
							<br>
							<br>
							<label>Caducidad: <input type="date" id="caducidad" name="caducidad" value="${producto.caducidad}"/></label>
							<br>
							<br>
                    		<select required="required" name="seccion" id="inputState" class="form-control">
		                        <c:forEach items="${secciones}" var="seccion">
		                            <option>${seccion.id}</option>
		                        </c:forEach>
                    		</select>
							<br>
							<br>
							<input id="LogIn" type="submit" value="MODIFICAR" />
						</form>
					</div>
			</a></li>
			<li><a>
					<div id="formulario2">
						<img
							src="https://static.vecteezy.com/system/resources/previews/008/070/292/original/blue-boat-logo-symbol-illustration-free-vector.jpg"
							alt="">
					</div>
			</a></li>
		</ul>
	</nav>

	<a class="open-hide">Menu</a>

	<ul class="menu">
		<li><a href="AinadirActi.jsp">actividad</a></li>
		<li><a href="AinadirCrucero.jsp">cruceros</a></li>
		<li><a href="AinadirEmple.jsp">empleados</a></li>
		<li><a href="AinadirHabita.jsp">habitaciones</a></li>
		<li><a href="AinadirParada.jsp">paradas</a></li>
		<li><a href="AinadirPuerto.jsp">puertos</a></li>
		<li><a href="AinadirRuta.jsp">rutas</a></li>

	</ul>

</body>
</html>