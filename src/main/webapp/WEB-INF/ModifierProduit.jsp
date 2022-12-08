<%@ page import="java.sql.Connection" %>
<%@ page import="repositories.ConnexionBDEcommece" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <title>Apprendre les servlets de JEE </title>
</head>
<%
    Connection con = ConnexionBDEcommece.getConnection();
    PreparedStatement ps = con.prepareStatement("select * from produit where idProduit=?");
        ps.setLong(1, Long.parseLong(request.getParameter("id")));
    ResultSet rs = ps.executeQuery();

%>
<header>
    <nav class="navbar navbar-expand-lg bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="/serveurWildfly-1.0-SNAPSHOT/">Diayeuma boutik</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/serveurWildfly-1.0-SNAPSHOT/">Accueil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/serveurWildfly-1.0-SNAPSHOT/produit">Produit</a>
                    </li>


                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn text-white border-white bg-success btn-outline-success" type="submit">Rechercher</button>
                </form>
            </div>
        </div>
    </nav>
</header>
<body>
<form action="insertProduitById" method="POST">

<% while (rs.next()){%>
        <div class="mb-3 invisible">
            <label for="id" class="form-label">Id</label>
            <input type="text" class="form-control" id="id" name="id" value="<%=rs.getString(1)%>">
        </div>
        <div class="mb-3">
            <label for="nom" class="form-label">Nom du produit</label>
            <input type="text" class="form-control" id="nom" name="nom" placeholder="<%=rs.getString(2)%>">
        </div>
        <div class="mb-3">
            <label for="prix" class="form-label">Prix du produit</label>
            <input type="text" class="form-control" name="prix" id="prix" placeholder="<%=rs.getString(3)%>">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <%}%>

</form>
</body>
</html>