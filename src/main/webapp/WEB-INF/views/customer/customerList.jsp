<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
    <head>
        <title> <s:message code="title" /> </title>
    </head>
    <body>

     <c:if test="${not empty customerList}">


                <table border="1px">
                      <tr>
                        <th> <s:message code="edit" /> </th>
                        <th> <s:message code="delete" /> </th>
                        <th> <s:message code="firstName" /> </th>
                        <th> <s:message code="lastName" /> </th>
                      </tr>
                  <c:forEach var="customer" items="${customerList}">
                      <tr>
                       <td><a href="${pageContext.request.contextPath}/customer/customerEdit.do?id=${customer.id}" >  ${customer.id} </a> </td>
                       <td><a href="${pageContext.request.contextPath}/customer/customerDelete.do?id=${customer.id}" >  <s:message code="delete" /> </a> </td>
                       <td>${customer.firstName}</td>
                       <td>${customer.lastName}</td>
                     </tr>
                   </c:forEach>
                 </table>
        </c:if>

        <br /><br />
        <a href="${pageContext.request.contextPath}/customer/customerCreate.do" > <s:message code="new" />  </a>




    </body>
</html>
