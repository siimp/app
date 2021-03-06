# Näidisrakendus
Kogu rakendus asub kaustas `backend` kaustas ja käivitub `bootRun` käsuga. Frontend koodi serveerib spring-boot rakendus public ressursside kaustast. 
Kasutaja autentitakse kasutajanime ja parooliga (vt pt Testkasutajad allpool) ning sessioon hoitakse püsti küpsise abil.
Kõik kasutaja tegevused logitakse. Korrelatsiooni id'd kasutamist ei pidanud antud rakenudse juures vajalikuks aga kõigi logi kirjete juures on kasutaja info,
kes antud tegevuse algatas.

## Kasutatud tarkvara
Frontend raamistik, põhilised teegid ja keel
* vuejs
* typescript
* vuex, vue-router, axios
* kasutajaliidese jaoks bootstrap
* tslint - staatiline koodi analüüs

Backend raamistik, põhilised teegid ja keel
* Spring-boot
* Java (10.0.1)
* Gradle
* jpa, spring-security, liquibase, lombok, h2
* SonarLint - staatiline koodi analüüs
* Koodi struktuur on by-feature


## Rakenduse jooksutamine
käivitada gradle'i bootRun  
rakenduse jookseb aadressil http://localhost:8080

## Testkasutajad
| Kasutajanimi | Parool |
| ------ | ------ |
| mari | maasikas123 |
| juku | 12345 |
| admin | admin |

## Frontent rakenduse ehitamine (valikuline)
```sh
$ cd frontend/app
$ yarn build
```
**yarn build käsk kopeerib dist kausta sisu kausta ../../backend/app/src/main/resources/public.**

## Teadaolevad puudused
* Frontend koodi serveeritakse backend rakenduse sees. Tehtud lihtsuse mõttes ja et võimaldada rakenduse jooksutamist ühe nupuvajutusega
* CSRF token on väljalülitatud, kuna frontend koodi serveeritakse staatiliselt ja ei kasuta template mootorit thymeleaf. CSRF rünne antud rakenduse puhul
saab toimuda ainult GET päringute suunal, POST päringute puhul kaitseb CORS selle eest. GET rünnakute puhul saadakse teada ainult andmed, andmete muudatust nende käigus ei tehta.
* Vormi valideerimine toimub ainult backend poole peal. Tehtud lihtsuse mõttes ja et näidata backend valideerimise osa. Korrektne oleks dubleerida vormi valideerimine nii 
frontend, kui ka backend poole peal, et vältida asjatuid päringuid serverisse.
* REST teenust turvatakse küpsisega. Õigem oleks kasutada token'i põhist stateless lähenemist nagu oauth2 + JWT. 
Et jätta rakenduse kood võimalikult väiekseks ja lihtsaks otsustasin mitte oauth2'te kasutada (Oleks juurde tulnud ressursi serveri ja autroseerimis serveri kood).
* Rakendus jookseb http peal, mitte https peal. (kasutaja nimi ja parool liiguva üle võrgu teksti kujul).

