#!/bin/bash
# Compile and run the main App class
rm -rf bin/
mkdir bin
javac -cp "lib/*:bin" -d bin $(find src -name "*.java")
java -cp "lib/*:bin" App