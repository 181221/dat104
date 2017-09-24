## Send mail med JSP mailer! 
### Getting started
* Tillat mindre sikre apper på <a href="https://myaccount.google.com/lesssecureapps?pli=1">google</a> 
* Last ned <a href="https://github.com/javaee/javamail/releases/download/JAVAMAIL-1_6_0/javax.mail.jar" download>JavaMail</a>
* Last ned <a href="http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-plat-419418.html#7017-jaf-1.0.2-oth-JPR" > JavaBeans Activation Framework JAF </a> version 1.0.2
* Last ned <a href="https://github.com/h181221/h181221.github.io/raw/master/dat104/jspmailer/JSPMailer.jar" download>JSPMAILER.jar</a> version 1.0.0
* Form parameternavn: <span style="text-decoration: underline;"><em>til</em>, <em>subject</em>, <em>msg.</em></span> - en input til hver av dem i JSP filen.
* Legg til mail info så ordnet alt seg selv! 

### Form - JSP

|Tekst| HTML        | Attribute           | name  |
|-----| ------------- |:-------------:| -----:|
|Til | Input     | name | til|
|Emne     | Input      | name      |   subject |
|Melding| Input | name      |    msg |

### I servlet

![Mail](https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/setupny.JPG)

# Kjør app - Mail
<br>

![Mail](https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/jspmailer.JPG)

# Sendt

![SENDT](https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/sent.JPG)

# Sjekk gmail
<br>

![Mail](https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/gmail.JPG)

