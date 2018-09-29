#!/usr/bin/env bash

echo "start..."

java -Djava.security.egd=file:/dev/./urandom -jar app.jar

echo "...done"
