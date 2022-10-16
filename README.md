# Calculator Application
*Application represents the remake of the classic calculator*

### Interface overview

Calculator functionality includes:
- Basic mathematical operations `+, -, /, *, =`
- Altering sign of entered number `+/-`
- Adding decimal point to number `.`
- Cleaning text field `<-, C, CE`

### Program execution

<p float="left">
<img src="https://user-images.githubusercontent.com/81090139/196044028-9a2f253c-d96b-468e-9dde-4e0435114009.gif" width="450">
</p>

## Launching the program
- Make sure Maven is [installed](https://maven.apache.org/download.cgi) on your computer
- Run the following command to build the project:
```
  mvn install
```
This also generates JAR file with all the dependencies 
- Run the `main` method in `Calculator.java`:
```
  mvn exec:java
```
- Otherwise, run the `main` method in `AutocompleteProgram.java` in your chosen IDE, e.g. `IntelliJ`
