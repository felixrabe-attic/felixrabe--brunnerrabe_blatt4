#!/bin/bash

set -e

./make.sh

export CLASSPATH=$CLASSPATH:./junit-4.11.jar
java org.junit.runner.JUnitCore ListTest # | less
