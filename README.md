# Challenge

# de que es la api
La api es un buscador de pokemones la cual recibe como parametro unicamente el nombre del pokemon, ej. Ditto, entonces nos retornara la siguiente informacion 

● abilities
● base_experience
● held_items
● id
● name
● location_area_encounters

Como tambien tiene endpoints el cual traen la informacion de cada punto individualmente los cuales estan mas abajo en el archivo.
# MySQL

adjunte el archivo sql que se debera ejecutar antes de levantar la api y consumirla.

se usa el usuario root con password 1234 en el puerto 3306 

# Instalacion

Abrimos el proyecto en IntelliJ Idea, abrimos la terminal del mismo y tiramos el siguiente comando

mvn clean install

al tirar el comando y que todo se haya instalado correctamente, levantamos nuestra api con (Mayus + F10) asegurandonos que se vaya a ejecutar el archivo Main

Esperamos a que levante y quedaria ir a Postman para consumirlo

# curl postman

curl --location 'http://localhost:8081/ws' \
--header 'content-type: text/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:gs="http://jocalomo.dev/challenge">
    <soapenv:Header/>
    <soapenv:Body>
        <gs:GetPokemonRequest>
            <gs:name>ditto</gs:name>
        </gs:GetPokemonRequest>
    </soapenv:Body>
</soapenv:Envelope>'

a continuacion dejo los otros endpoints solo se deberia remplazar lo que esta dentro del Body, para mandar llamarlos.

<gs:GetPokemonRequest>
    <gs:name>ditto</gs:name>
</gs:GetPokemonRequest>

<gs:GetAbilitiesRequest>
    <gs:name>ditto</gs:name>
</gs:GetAbilitiesRequest>

<gs:GetBaseExperienceRequest>
    <gs:name>ditto</gs:name>
</gs:GetBaseExperienceRequest>

<gs:GetIdRequest>
    <gs:name>ditto</gs:name>
</gs:GetIdRequest>

<gs:GetNameRequest>
    <gs:name>ditto</gs:name>
</gs:GetNameRequest>

<gs:GetLocationAreaEncountersRequest>
    <gs:name>ditto</gs:name>
</gs:GetLocationAreaEncountersRequest>

<gs:GetHeldItemsRequest>
    <gs:name>ditto</gs:name>
</gs:GetHeldItemsRequest>

otros nombres de pokemon podrias utilizar

bulbasaur
ivysaur
venusaur
charmander
charmeleon
charizard
squirtle
wartortle
blastoise
caterpie
metapod
butterfree
weedle
kakuna
beedrill
pidgey
pidgeotto
pidgeot
rattata
raticate
spearow
fearow