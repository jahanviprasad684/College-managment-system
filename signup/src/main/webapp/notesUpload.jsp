<%@page import="java.util.Base64"%>
<%@ page import="java.sql.*"%>
 
<%@ page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 
<html>
    <head>
        <title>Notes Upload</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
            background-color: #FF9376;
          
          }
            .main{
                width: 500px;
                height: 300px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
                border: 2px solid;
                background-color: coral;
            }
            form{
                width: 100%;
                position: relative;
                display: block;
                margin: 20px auto;
            }
            input{
                margin: 10px 0;
            }
 
        </style>
    </head>
    
    <body>
       
        <div class="main">
            <form method="POST" action="UploadNotes" enctype="multipart/form-data" >
              <label for="Date">DATE:  </label>  <input type="Date" name="Date"/><br>
               <label for="Subject">SUBJECT:  </label><input type="text" name="Subject"/><br>
                <label for="Chapter_Name">CHAPTER NAME:  </label><input type="text" name="Chapter_Name"/><br>
                <input type="file" name="file"/>
                <input type="submit" value="Upload"/>
            </form>
           
        </div>
    </body>
</html>