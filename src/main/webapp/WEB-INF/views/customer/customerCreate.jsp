<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>


<html>
    <head>
        <title> <s:message code="title" /> </title>
    </head>
    <body>


    <form method="post" action="${pageContext.request.contextPath}/customer/customerInsert.do" >

          <s:message code="firstName" />:
          <input type="text" name="firstName" value="${customer.firstName}" />

          <br/><br/>

          <s:message code="lastName" />:
          <input type="text" name="lastName" value="${customer.lastName}" />


           <br/> <br/>
           <input type="submit" value=" <s:message code='save' /> " />
    </form>


    </body>
</html>
