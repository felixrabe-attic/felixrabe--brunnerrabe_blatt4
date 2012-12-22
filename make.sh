#!/bin/bash

set -e

export CLASSPATH=$CLASSPATH:./junit-4.11.jar

find . -type f -name "*.java" |
  while read javafile ; do
    classfile="${javafile%.java}.class"
    if [[ ! -e "$classfile" || "$javafile" -nt "$classfile" ]] ; then
      echo "Compiling $javafile ..."
      javac "$javafile"
    fi
  done
