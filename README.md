# SoapAndRest

this maven project use spring boot to provide soap and rest webservices example based on spring.io recommandations 
this project also consume a ADD soap webservice found in the internet http://www.dneonline.com/calculator.asmx?WSDL 
to be returned in rest webservice created as a response

to test this application 
soap ws : 

create a new file request.xml

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCountryRequest>
         <gs:name>Spain</gs:name>
      </gs:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>

call the service as you like, for me I use curl :

$ curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/soapAndRest/ws

rest ws :

just open the url below in your browser, it's a simple http Get :

http://localhost:8080/soapAndRest/greeting?name=User

in this ws the http://www.dneonline.com/calculator.asmx?WSDL is called to calculat 11+12 and returning the result in the id of the response

