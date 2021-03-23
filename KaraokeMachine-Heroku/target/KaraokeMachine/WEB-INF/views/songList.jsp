<!-- //Almicke Navarro 
//CST-323
//January 15, 2020 
//I used source from the following website:https://startbootstrap.com/theme/creative

//songList will output all the songs in the database-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSS Stylesheet -->
        <link href="resources/style.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Song List</title>
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
                        <h1 class="text-uppercase text-white font-weight-bold">Song List</h1>
                        <hr class="divider my-4" />
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        <div class="table-responsive">
							<table class="table table-borderless table-dark" style="width:50%">
									<tr>
										<th><label>Song Title</label></th>
										<th><label>Artist</label></th>
										<th><label>Youtube Link</label></th>
									</tr>
									<c:forEach var = "song" items = "${songs}">
									<tr>
									<td><form action = karaokeSong method = 'POST'><input type = 'hidden' name = 'songID' value = '${song.ID}'><input type = 'submit' value = '${song.title}'></form></td>
										<td>${song.artist}</td>
										<td>${song.youtubeLink}</td>
									</tr>
									</c:forEach>
						    </table>
						</div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Footer-->
        <footer class="bg-light py-5">
            <div class="container"><div class="small text-center text-muted">By Almicke Navarro</div></div>
        </footer>
    </body>
</html>