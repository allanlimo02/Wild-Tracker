# Wild Animal  Tracker App :evergreen_tree: :monkey_face: :monkey: :elephant:
The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study

----
## Author

* ALLAN LIMO
----
# Getting Started

Clone this repository to your local machine to get Started

---
## **Prerequisites**

You need the following installed on your machine
- java
- JDK - Java Development Kit
- Maven
- Gradle
- An IDE - Intellij
- Postgres DBMS
- Be familiar with Handlebars


To confirm run the following command on linux
```
$ java --version       
$ mvn --version        
$ gradle --version     
```
---
## Installing
* Clone this project using ``` git clone https://github.com/allanlimo02/Wild-Tracker.git```

After cloning to your local machine navigate to the folder you cloned into and open it with intellij.
* Navigate into the ``` src/main/java/App.java ``` and click run in intellij.
* Go to your browser and type ``` localhost:4567 ```
---
##Setting up database

Use the  folloring comands to create databse and tabes
* ```psql```
  * ```CREATE DATABASE wildlife_tracker;```
   * ``\c wildlife_tracker``
   * ``CREATE TABLE animals (id serial PRIMARY KEY, name VARCHAR,health VARCHAR,age VARCHAR,endangered BOOLEAN)``
    * ````CREATE TABLE sighting (id serial PRIMARY KEY, rangerId VARCHAR,animal_id,location VARCHAR)````
## Running the Tests

Create a test class for running tests in the application.

This is a sample test that tests if the getter method works

```
  @Test
    public void animal_name() {
        Animal animal = new Animal(1,"Lion");
        assertEquals("Lion", animal.getName());

    }
```
---
## Built With

* [Java](https://www.java.com/) - The language used
* [Intellij Idea](https://www.jetbrains.com/idea/) - Intergated development
* [Spark]() - Framework
* [Postgres Database](https://www.postgresql.org/)
---

## Contributing
Contact me for any future colaborations.
* Allanlimo02@gmail.com
* 0726 832 007
---
## License
This project comes with <a href="https://github.com/allanlimo02/Wild-Tracker/blob/master/LICENCE">MIT LICENCE</a> binded to it.