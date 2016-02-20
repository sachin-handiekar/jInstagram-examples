jInstagram-examples
===================


#Basic Web Demo 

## Live Demo 

[jInstagram Web Demo](http://jinstagram-demo.herokuapp.com/)

##How to use it

Note : Create a new client with the following redirect uri -	

http://host.name/handleInstagramToken

e.x. http://localhost:8080/BasicWebDemo/handleInstagramToken/

1. Import the maven project in your favourite IDE.
2. Change the following lines in DemoAppContextListener.java (src/main/java/com/sachinhandiekar/examples/listener/)

```java
        String clientId = System.getenv(Constants.CLIENT_ID);
        String clientSecret = System.getenv(Constants.CLIENT_SECRET);
        String callbackUrl = System.getenv(Constants.REDIRECT_URI);
```

to

```java
        String clientId = "Your Client ID"
        String clientSecret = "Your Client Secret";
        String callbackUrl = "Your callback URL";
```

3. Replace the clientId, clientSecret and callbackUrl with the values used during Client registration on Instagram Developer website.
4. Build the project and deploy the war file in your web server.
5. Open the following URL : http://localhost:8080/IGWebDemo/
