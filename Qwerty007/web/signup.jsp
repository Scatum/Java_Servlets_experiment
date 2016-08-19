<%-- 
    Document   : aut
    Created on : 08.08.2016, 21:21:34
    Author     : ScatUm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta charset="utf-8">
        <title>Sign Up</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/aut.js"></script>
        <link rel="stylesheet" href="css/aut.css">
    </head>
    <body>

      <form action="registration" method="post">
         
        <h1>Sign Up</h1>
        
        <fieldset>
          <legend><span class="number">1</span>Your basic info</legend>
          <label for="name">Name:</label>
          <input type="text" id="name" name="user_name">
          
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="user_email">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="user_password">
          
          <label>Profile Type:</label>
          <input type="radio" id="developer" value="developer" name="type"><label for="developer" class="light">Developer</label><br>
          <input type="radio" id="manager" value="manager" name="type"><label for="manager" class="light">Manager</label>
        </fieldset>
      
        <fieldset id="dev_type">
        <label for="job">Job Role:</label>
        <select id="job" name="user_job">
          <optgroup label="Web">
            <option value="frontend_developer">Front-End Developer</option>
            <option value="php_developor">PHP Developer</option>
            <option value="python_developer">Python Developer</option>
            <option value="rails_developer"> Rails Developer</option>
            <option value="web_designer">Web Designer</option>
            <option value="WordPress_developer">WordPress Developer</option>
          </optgroup>
          <optgroup label="Mobile">
            <option value="Android_developer">Androild Developer</option>
            <option value="iOS_developer">iOS Developer</option>
            <option value="mobile_designer">Mobile Designer</option>
          </optgroup>
          <optgroup label="Business">
            <option value="business_owner">Business Owner</option>
            <option value="freelancer">Freelancer</option>
          </optgroup>
          <optgroup label="Other">
            <option value="secretary">Secretary</option>
            <option value="maintenance">Maintenance</option>
          </optgroup>
        </select>
         
        </fieldset>
        <button type="submit">Sign Up</button>
      </form>
      
    </body>
</html>
</html>
