## SHA - HASHING

### Getting Started!

* last ned <a href="https://github.com/h181221/h181221.github.io/raw/master/dat104/SHA-Hashing/Kryptografi.jar" download>SHA-HASHING.jar</a>

* Velg en SALT - hashpassord

```
        // Sett salt - default: ValerienSteel
        SHA.setSALT("en tilfeldig streng"); 
        String passord = "passord123";
        SHA.hashPasswordSHA_512(passord);
```

