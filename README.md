# CLI - Practical work 1
This CLI, written in Java, is a simple program that takes an input file, does some operations on it and writes the result to an output file.
<br></br>

## Resolve dependencies
Not always necessary, but if you have some problems with the dependencies, you can try to resolve them with the following command.

``./mvnw dependency:resolve``
<br></br>

## Build the project
``./mvnw package``
<br></br>

## First step
create a new input file in the root of the project with some text.

``echo "Hello World" > input.txt``
<br></br>

## Run the project
To run the project, you have to use the input and output parameter with the corresponding file names.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt``
<br></br>

This will only copy the input file to the output file. You can then add parameters to the command to change the behaviour of the program.
For example adding "uppercase" will convert the text to uppercase.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt uppercase``
<br></br>

The same goes for "lowercase", "reverse" and "alternate. In order, it will convert the input text to lowercase, reverse the text and alternate between lower and uppercase for each character.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt lowercase``

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt reverse``

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt alternate``
<br></br>

You can also combine multiple parameters. All of them if you really want to.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt uppercase lowercase reverse alternate``
<br></br>

And finally, you can ask for the program version and for help to display the different parameters.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -v``

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -h``
