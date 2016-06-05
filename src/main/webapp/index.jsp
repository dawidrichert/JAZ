<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>REST API</title>
</head>
<body>
<ul>
    <li>
        <a target="_blank" href="/api/rest/movies">/api/rest/movies</a>
        <br>
        <strong>GET</strong> - Wyświetlenie listy wszystkich filmów
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/movies/1">/api/rest/movies/{id}</a>
        <br>
        <strong>GET</strong> - Wyświetlenie filmu o podanym <strong>id</strong>
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/movies">/api/rest/movies</a>
        <br>
        <strong>POST</strong> - Dodanie nowego filmu
        <blockquote>
            {
                "name": "Wanted",
                "director": "Timur Bekmambetov",
                "genres": "Fantasy, Thriller, Action",
                "year": 2008
            }
        </blockquote>
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/movies/1">/api/rest/movies/{id}</a>
        <br>
        <strong>PUT</strong> - Zaktualizowanie informacji o filmie o podanym <strong>id</strong>
        <blockquote>
            {
                "name": "Deadpool",
                "director": "Jan Kowalski",
                "genres": "Adventure, Action, Comedy",
                "year": 2016
            }
        </blockquote>
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/movies/1/comments">/api/rest/movies/{id}/comments</a>
        <br>
        <strong>GET</strong> - Wyświetlenie komentarzy dla filmu o podanym <strong>id</strong>
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/movies/1/comments">/api/rest/movies/{id}/comments</a>
        <br>
        <strong>POST</strong> - Dodanie komentarza do filmu o podanym <strong>id</strong>
        <blockquote>
            {
                "author": "Bob",
                "content": "Good movie!",
                "date": "2016-06-05T19:31:42.451+02:00"
            }
        </blockquote>
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/comments/1">/api/rest/comments/{id}</a>
        <br>
        <strong>DELETE</strong> - Usunięcie komentarza o podanym <strong>id</strong>
    </li>
    <br>
    <li>
        <a target="_blank" href="/api/rest/movies/1/rate?value={ocena}">/api/rest/movies/{id}/rate?value={ocena}</a>
        <br>
        <strong>POST</strong> - Wystawienie oceny <strong>{ocena}</strong> w skali od 1 do 10 dla filmu o podanym <strong>id</strong>
    </li>
</ul>
</body>
</html>