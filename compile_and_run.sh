#!/bin/bash
# Compile and run the main App class
rm -f bin/*.class
javac -cp "lib/*:bin" -d bin src/*.java
java -cp "lib/*:bin" App
