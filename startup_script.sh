#!/usr/bin/env bash
set -e
PORT="${SERVER_PORT:-9001}"
./mvnw clean package -DskipTests
java -jar target/product.read.api-0.0.1-SNAPSHOT.jar --server.port="$PORT"