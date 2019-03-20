#!/bin/bash

### useful global constants

CD=`pwd`
inputdirs="brokencrypto brokenhash ecbcrypto insecureasymmetriccrypto"

### useful functions

# finds all the java files that are in-scope for the compliance paper benchmarks
function create_argfile() {
    rm arg_file
    touch arg_file

    find src/main/java/org/cryptoapi/bench/ecbcrypto -name "*.java" >> arg_file
    find src/main/java/org/cryptoapi/bench/brokenhash -name "*.java" >> arg_file
    find src/main/java/org/cryptoapi/bench/brokencrypto -name "*.java" >> arg_file
    find src/main/java/org/cryptoapi/bench/insecureasymmetriccrypto -name "*.java" >> arg_file
 }
