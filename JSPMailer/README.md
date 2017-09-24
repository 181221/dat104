## Send mail med JSP mailer! 
### Dependencies - Ligger i JspMail.jar!
* JavaMail
* JavaBeans Activation Framework JAF - version 1.0.2
### Getting started
* Tillat mindre sikre apper på <a href="https://myaccount.google.com/lesssecureapps?pli=1">google</a>
* Last ned <a href="https://github.com/h181221/h181221.github.io/raw/master/dat104/jspmailer/Mail.jar" download>JspMail.jar</a> version 1.0.0 - 
* Form parameternavn: <span><em>"til", "subject", "msg".</em></span> - en input til hver av dem i JSP filen.
* Legg til mail info så ordnet alt seg selv! 

### Form - JSP

|Tekst| HTML        | Attribute           | name  |
|-----| ------------- |:-------------:| -----:|
|Til | Input     | name | til|
|Emne     | Input      | name      |   subject |
|Melding| Input | name      |    msg |

### I servlet

![Mail](https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/setupny.JPG)

### Kjør app - Mail
<br>

<img src="https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/jspmailer.JPG" width="400" height="200">

### Sendt
<img src="https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/sent.JPG" width="300" height="80">


### Sjekk gmail
<br>
<img src="https://github.com/h181221/h181221.github.io/blob/master/dat104/jspmailer/gmail.JPG" width="500" height="100">


