# CLI - Practical work 1
This CLI, written in Java, is a simple program that takes an input file, does some operations on it and writes the result to an output file.
All the example will be with the same test sentence:
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 10 27 15" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/1520b47b-5ebd-421a-afb0-bdfd8d3a4842">
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
To run the project, you MUST use the input and output parameter with the corresponding file names. If not, the help message will show up.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt``
<br></br>

This will only copy the input file to the output file. You can then add parameters to the command to change the behaviour of the program.
For example adding "uppercase" will convert the text to uppercase.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt uppercase``
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 10 59 54" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/5018b784-9c52-4bf6-98ea-57a36c5afca3">
<br></br>

The same goes for "lowercase", "reverse" and "alternate. In order, it will convert the input text to lowercase, reverse the text and alternate between lower and uppercase for each character.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt lowercase``
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 11 01 40" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/64336e6f-7a9e-4b0d-b0f1-196a789da770">

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt reverse``
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 11 01 51" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/bf68ee61-c4f3-45fe-84bf-ede80f5007c5">

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt alternate``
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 11 02 05" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/850087db-936a-4fc5-bbc2-c81bc910885a">
<br></br>

You can also combine multiple parameters. All of them if you really want to.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt uppercase lowercase reverse alternate``
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 11 03 33" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/24df59a5-0952-4926-b892-83cc8b921ab2">
<br></br>

There is also the option to use an encoding for the input and output file. They are not compulsory and you can use only one of them at the time.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -ie UTF-8 -o output.txt``

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -i input.txt -o output.txt -oe ISO_8859_1``
<br></br>
<img width="210" alt="Capture d’écran 2023-10-07 à 10 28 10" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/3da93a36-1a1c-4873-a163-8320921b63db">
<br></br>

And finally, you can ask for the program version and for help to display the different parameters.

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -v``

``java -jar target/dai-bleuer-practical-work-1-1.0-SNAPSHOT.jar -h``
<br></br>
<img width="1087" alt="Capture d’écran 2023-10-07 à 11 05 24" src="https://github.com/RemyBlr/dai-bleuer-practical-work-1/assets/35931021/661f796c-0e6e-4c5e-97ca-8df3aa9b446f">
