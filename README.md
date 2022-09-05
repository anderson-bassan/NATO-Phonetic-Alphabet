
# Nato
### A Command-line Game to Help You Learn the NATO Alphabet

## What is Nato?
Nato is a command-line simple game to help you learn the NATO Phonetic Alphabet quickly while having fun.

## What is the Nato Phonetic Alphabet
According to wikipedia:

```
The (International) Radiotelephony Spelling Alphabet, commonly known as the NATO phonetic alphabet,
is the most widely used set of clear code words for communicating the letters of the Roman alphabet,
technically a radiotelephonic spelling alphabet.
```

It's commonly used in armies, airports and in situations where people from different parts of the world need to communicate without spelling mistakes.

## Dependencies
The following software is required to run the nato project:
* [Java JDK 17.0.2](https://www.oracle.com/java/technologies/downloads/)
* [Java JRE 1.8.0_341](https://www.java.com/en/download/manual.jsp)
* [Java JVM 17.0.2](https://www.java.com/en/download/manual.jsp)
* [Apache Maven 3.8.6](https://maven.apache.org/download.cgi)

## How Build and Run the Project

### In Windows:

1. Start a CMD
2. To build the package:

```
git clone https://github.com/anderson-bassan/Nato.git && cd Nato\src && mvn package

```

3. To run the package:
```
run.bat
```

  OR

```
java -cp target\NATOPhoneticAlphabet-3.1-RELEASE.jar com.nato.Main
```

### In Linux
1. Start a Terminal
2. To build the package:

```
git clone https://github.com/anderson-bassan/Nato.git && cd Nato\src && mvn package
```

3. To run the package
```
$ sudo chmod +777 run.sh
$ ./run.sh
```
 OR
```
$ java -cp target\NATOPhoneticAlphabet-3.1-RELEASE.jar com.nato.Main
```

## TODO

- [ ] code refactoring
- [ ] add translation to Portuguese and German
- [ ] add time out to the guess game
- [ ] add database of highest scores
- [ ] add a NATO translator
- [ ] add a "Translate the NATO phrase game"
