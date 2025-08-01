# Compile and run the main App class
if (Test-Path bin) { Remove-Item -Recurse -Force bin }
New-Item -ItemType Directory -Name bin
javac -cp "lib/*;bin" -d bin src/*.java src/produce/*.java
java -cp "lib/*;bin" App
