   <%@ page contentType="text/html;charset=UTF-8" language="java" %>
   <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>LilaBank</title>

            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">

            <style>
                body {
                    margin: 0;
                    padding: 0;
                    font-family: Arial, sans-serif;
         background-color: #f8f9fa; /* Set your page background color */
              }

              header {
                  background: linear-gradient(to right, #3494e6, #ec6ead); /* Set your gradient colors */
                  color: #fff;
                  padding: 20px 0;
              }

              .container {
                  max-width: 1200px;
                  margin: 0 auto;
              }

              .logo {
                  color: #fff;
                  font-size: 24px;
                  font-weight: bold;
                  text-decoration: none;
              }
        nav {
            float: right;
        }

        nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        nav li {
            display: inline-block;
            margin-left: 20px;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
        }
    </style>
</head>
<body>

<header>
    <div class="container">
        <a href="/" class="logo">LilaBank</a>
        <nav>
            <ul>
                <li><a href="/home">Home</a></li>
                <li><a href="/about">About Us</a></li>
                <li><a href="/services">Services</a></li>
                <li><a href="/contact">Contact</a></li>
            </ul>
        </nav>
    </div>
</header>

<!-- The rest of your page content goes here -->

<!-- Add your script tags or include your JavaScript files here -->
</body>
</html>