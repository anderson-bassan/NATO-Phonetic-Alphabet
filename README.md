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

## How Compile It to a Jar File

### In Windows:
Start a CMD:
```
git clone https://github.com/anderson-bassan/Nato.git
cd Nato\src
javac -d classes *.java
cd classes
jar cfe Nato.jar Main *.class
mkdir %userprofile%\Nato\
move Nato.jar %userprofile%\Nato\
cd ..\..\..
rmdir /s Nato
cd \d %userprofile%\Nato\
```
When asked "Are you sure (Y/N)?", type "Y".

Your jar file can be found at C:\Users\[your user folder]\Nato\.

## TODO

* add comments
* add database of highest scores
* implement non-blocking system input
* implement testing