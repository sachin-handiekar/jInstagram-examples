package com.sachinhandiekar.examples.listener;


import com.sachinhandiekar.examples.Constants;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.oauth.InstagramService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DemoAppContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        String clientId = System.getenv(Constants.CLIENT_ID);
        String clientSecret = System.getenv(Constants.CLIENT_SECRET);
        String callbackUrl = System.getenv(Constants.REDIRECT_URI);


        InstagramService service = new InstagramAuthService()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(callbackUrl)
                .build();

        sce.getServletContext().setAttribute(Constants.INSTAGRAM_SERVICE, service);

    }

    public void contextDestroyed(ServletContextEvent sce) {

        sce.getServletContext().removeAttribute(Constants.INSTAGRAM_SERVICE);

    }


}