<!-- //Almicke Navarro 
//CST-323
//January 14, 2020 
//I used source from the following website:https://startbootstrap.com/theme/creative

//Request will act as the form for players to input their request to add a new song to the database -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS Stylesheet -->
        <link href="resources/style.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
		<meta charset="UTF-8"> <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Request a Song</title>
</head>
<body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">Karaoke Machine</a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="home">Home</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="songList">Song List</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="requestASong">Request a Song</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container h-100">
                <div class="row h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-10 align-self-end">
                        <h1 class="text-uppercase text-white font-weight-bold">Request a Song</h1>
                        <hr class="divider my-4" />
                    </div>
                    <div class="align-self-baseline">
								<form:form method= "POST" modelAttribute="song" action="requestSuccess">
									<table> 
										<tr>
											<td class="text-white">Artist:</td>
											<td><form:input path="artist"/></td>
										</tr>
										<tr>
											<td class="text-white">Title:</td>
											<td><form:input path="title"/></td>
										</tr>
										<tr>
											<td class="text-white">Youtube Link (Embed link preferred):</td>
											<td><form:input path="youtubeLink"/></td>
										</tr>
										<tr>
											<td> 
											    <input class="btn btn-primary btn-xl js-scroll-trigger" type = "submit" value = "Submit">
											</td>
										</table>
								</form:form> 
                    </div>
                </div>
            </div>
        </header>
        <!-- Footer-->
        <footer class="py-5">
            <div class="container"><div class="small text-center text-muted">By Almicke Navarro</div></div>
        </footer>
    </body>
</html>