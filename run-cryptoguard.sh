#!/bin/bash

source utils.sh

CRYPTOGUARDJAR="${CD}/../cryptoguard/main/build/libs/main.jar"
JAVA7_HOME=${JAVA_HOME}

#sudo ln -s ${CHECKERFRAMEWORK}/checker/dist/checker.jar cf-link

gradle assemble

java -jar ${CRYPTOGUARDJAR} "jar" "${CD}/build/libs/rigorityj-samples-1.0-SNAPSHOT.jar" ""

