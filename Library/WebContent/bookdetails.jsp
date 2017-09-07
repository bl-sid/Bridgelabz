<%@page import="com.bridgelabz.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

    <%
        Book book = (Book) request.getAttribute("book_object");
        String name = (String)session.getAttribute("name");
    %>
    <table class='table table-striped'>
        <tbody>
            <tr>
                <th>Title</th>
                <td><%=book.getTitle()%></td>
            </tr>
            
            <tr>
                <th>Author</th>
                <td><%=book.getAuthor()%></td>
            </tr>
            
            <tr>
                <th>Category</th>
                <td><%=book.getCategory()%></td>
            </tr>
            
            <tr>
                <th>Price</th>
                <td><%=book.getPrice()%></td>
            </tr>
            
            <tr>
                <th>Added By</th>
                <td><%=name%></td>
            </tr>
        </tbody>
    
    </table>
   

</body>
</html>