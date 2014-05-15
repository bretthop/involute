<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div style="width: 80%; margin: auto;">
        <div>
            <h1>Log In</h1>
            <form action="/j_spring_security_check" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="j_username"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="text" name="j_password"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div>
            <h1>Sign Up</h1>
            <form action="/auth/signUp" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="username"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="text" name="password"/></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="text" name="email"/></td>
                        </tr>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="firstName"/></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="lastName"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</body>
</html>