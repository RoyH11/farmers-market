#!/bin/bash
# Compile and run tests
javac -cp "lib/*:bin" -d bin test/*.java src/*.java
java -cp "lib/*:bin" org.junit.platform.console.ConsoleLauncher --scan-classpath
