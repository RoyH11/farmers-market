#!/bin/bash
# Compile and run tests
rm -rf bin/
mkdir bin
javac -cp "lib/*:bin" -d bin $(find src -name "*.java") test/*.java
java -cp "lib/*:bin" org.junit.platform.console.ConsoleLauncher execute --scan-classpath