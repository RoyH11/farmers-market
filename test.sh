#!/bin/bash
# Compile and run tests
rm -f bin/*Test.class
javac -cp "lib/*:bin" -d bin test/*.java src/*.java
java -cp "lib/*:bin" org.junit.platform.console.ConsoleLauncher execute --scan-classpath
