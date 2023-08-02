#!/bin/sh

# Check if the JAR app exists
if [ ! -f "/app/app.jar" ]; then
  echo "The JAR app does not exist."
  exit 1
fi

# Run the JAR app
java -jar /app/app.jar
