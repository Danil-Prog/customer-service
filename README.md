# customer-service

## Read operations from the database by criteria

------
## Preliminary development environment

| environment | version                                        |
|-------------|------------------------------------------------|
| Maven       | [3.9.x](https://maven.apache.org/download.cgi) |
| Java JDK 8  | [8](https://adoptium.net/)                     |


------

## Maven dependency in develop

 - JDBC Driver (connection to Postgresql database)
 - Jackson (Used to convert data to json format)

------

## How to run with your own configuration

 1. Initializing project -  `$ git clone https://github.com/Danil-Prog/customer-service.git`
 2. Open docker-compose.yaml and set variable **POSTGRES_DB**, **POSTGRES_USER**, **POSTGRES_PASSWORD**
 3. Up database - `$ docker compose build` and `$ docker compose up `
 4. Next, insert the db connection variables in the configuration file along the path /src/main/resources/application.properties
 5. Go to the root directory and enter `$ mvn package `
 6. Two jar files will be formed, use a file with the ending **-jar-with-dependencies** to run since it contains all the dependencies, and does not depend on the location
 7. `$ java -jar search || stat  input.json output.json ` (examples of input parameters are located in the 'example' directory)

-------

## Notes

 * The input parameters can be arranged in any sequence, but the criteria file must be located before the response file
 * If the file from the input parameters was not found, the program will create the file 'errors.json' relative to its path
 * Exceptions, errors that occurred during the program will be recorded in the output file
 * The output format of the sql query response is json for easier object formation
 * Application Architecture - mvc

-------

## Future

 - Optimize sql queries, eliminate unnecessary processing by java code
 - Implement dependency management
 - Add margins to json formations for readability

-------
