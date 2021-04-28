<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
            <style>
    .error {
        color: red; font-weight: bold;
    }
</style>
        </head>

        <body>
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">

                <table align="center">
                    <tr>
                        <td>
                            <form:label path="userId">User Id</form:label>
                        </td>
                        <td>
                            <form:input path="userId" name="userId" id="userId"  />
                        </td>
                        <td align="left"><form:errors path="userId" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" name="password" id="password" />
                        </td>
                        <td align="left"><form:errors path="password" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="name">Name</form:label>
                        </td>
                        <td>
                            <form:input path="name" name="name" id="name" />
                            
                        </td>
                    </tr>
                 
                    <tr>
                        <td>
                            <form:label path="emailId">Email Id</form:label>
                        </td>
                        <td>
                            <form:input path="emailId" name="emailId" id="emailId" />
                        </td>
                        <td align="left"><form:errors path="emailId" cssClass="error"/></td>
                    </tr>
                  
                    <tr>
                        <td>
                            <form:label path="birthDate">Birth Date</form:label>
                        </td>
                        <td>
                            <form:input path="birthDate" name="birthDate" id="birthDate" />
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="index.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>

        </body>

        </html>