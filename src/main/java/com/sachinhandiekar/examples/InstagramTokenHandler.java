package com.sachinhandiekar.examples;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class InstagramTokenHandler extends HttpServlet {

    private static final String CODE = "code";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = request.getParameter(CODE);

        InstagramService service = (InstagramService) request.getServletContext().getAttribute(Constants.INSTAGRAM_SERVICE);

        Verifier verifier = new Verifier(code);

        Token accessToken = service.getAccessToken(verifier);
        Instagram instagram = new Instagram(accessToken);

        HttpSession session = request.getSession();

        session.setAttribute(Constants.INSTAGRAM_OBJECT, instagram);

        System.out.println(request.getContextPath());
        // Redirect to User Profile page.
        response.sendRedirect(request.getContextPath() + "/profile.jsp");

    }


}
