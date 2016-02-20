<jsp:include page="common/header.jsp" />

<%@ page import="org.jinstagram.auth.oauth.InstagramService" %>
<%@ page import="com.sachinhandiekar.examples.Constants" %>


<%
    // If we already have an instagram object, then redirect to profile.jsp
    Object objInstagram = session.getAttribute(Constants.INSTAGRAM_OBJECT);
    if (objInstagram != null) {
        response.sendRedirect(request.getContextPath() + "/profile.jsp");
    }

    InstagramService service = (InstagramService) session.getServletContext().getAttribute(Constants.INSTAGRAM_SERVICE);

    String authorizationUrl = service.getAuthorizationUrl();

%>

<div class="container">

    <div class="jumbotron">
        <h1>Demo</h1>
        <p class="lead">A basic web application demonstrating the use of <a href="https://github.com/sachin-handiekar/jInstagram">jInstagram API</a></p>
        <p><a href="<%= authorizationUrl%>"><img src="images/Instagram_normal.png"/></a>
        </p>
    </div>


<jsp:include page="common/footer.jsp" />
