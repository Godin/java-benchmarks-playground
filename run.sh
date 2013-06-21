#!/bin/sh

name=${1}
shift
mvn -V clean package || exit 1
java -jar target/microbenchmarks.jar ".*${name}.*" -v "${@}"
