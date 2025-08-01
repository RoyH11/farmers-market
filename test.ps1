# Compile and run tests
if (Test-Path bin) { Remove-Item -Recurse -Force bin }
New-Item -ItemType Directory -Name bin
javac -cp "lib/*;bin" -d bin src/*.java src/produce/*.java test/*.java
java -cp "lib/*;bin" org.junit.platform.console.ConsoleLauncher execute --scan-classpath
