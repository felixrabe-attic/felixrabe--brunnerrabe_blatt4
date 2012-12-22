#!/bin/bash

set -e

./make.sh

export CLASSPATH=$CLASSPATH:./junit-4.11.jar
java org.junit.runner.JUnitCore brunnerrabe.blatt4.aufgabe1.ListTest | less
