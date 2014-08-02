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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = request.getParameter("code");


        InstagramService service = (InstagramService) request.getSession().getAttribute(Constants.INSTAGRAM_SERVICE);

        Verifier verifier = new Verifier(code);

        Token accessToken = service.getAccessToken(null, verifier);
        Instagram instagram = new Instagram(accessToken);

        HttpSession session = request.getSession();

        session.setAttribute(Constants.INSTAGRAM_OBJECT, instagram);

        // Redirect to User Profile page.
        response.sendRedirect("/profile");

    }


}
