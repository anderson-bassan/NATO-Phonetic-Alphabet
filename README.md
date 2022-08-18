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

<pre>
    OR
</pre>

```
java -cp target\NATOPhoneticAlphabet-3.1-RELEASE.jar com.nato.Main
```

## TODO

* add database of highest scores
* implement non-blocking system input
* implement testing