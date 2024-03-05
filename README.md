# Pokemon API Connectivity

A group of Tech Elevator alumni have committed a week to practicing small projects with the Pokemon API. This repo is my code base for that purpose.


### Built with

- Java
- IntelliJ IDEA Community Edition
- Spring Framework
- Maven
- [Pokemon API](https://pokeapi.co/docs/v2) 


### Notes on Day 1 - Command Line Interface Build

I'm writing this note at the end of day 1! So far, we've started to build a small command line project where we can call the API to ask for information on individual Pokemon. The user will prompt the command line, 
which we've given access to the first 60 Pokemon in the Pokedex, and can search any Pokemon by it's National Pokedex number. These are just my thoughts for improvement on the code we have created to this point.
-- the boilerplate could be reduced significantly by utilizing lombok.
-- null checks are not currently being performed when accessing the API or any call that points to data that may not exist.
-- we are not currently caching our API calls. API caching would improve our processing speed and, in the case of an API that charges per request, reduce the associated costs of the project.
-- we need tests! Currently there's no test coverage.


### External resources

- [Caching In The Backend Systems: A Beginner's Guide]((https://www.youtube.com/watch?v=_93bg_NnjqM)) - This video is a great reference for someone new to data caching creating a command line application!
