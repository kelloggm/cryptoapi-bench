#!/bin/bash

CD=`pwd`

CFJAVAC="${CD}/../../../jsr308/checker-framework/checker/bin-devel/javac"

KMSCHECKER="com.amazon.checkerframework.compliance.kms.ComplianceChecker"
CRYPTOCHECKER="com.amazon.checkerframework.cryptopolicy.CryptoPolicyComplianceChecker"
APS="${CRYPTOCHECKER}"

KMSJAR="${CD}/../aws-kms-compliance-checker/build/libs/aws-kms-compliance-checker.jar"

CRYPTOJAR="${CD}/../aws-crypto-policy-compliance-checker/build/libs/aws-crypto-policy-compliance-checker.jar"

CP="${KMSJAR}:${CRYPTOJAR}"

rm arg_file
touch arg_file

find src/main/java/org/cryptoapi/bench/ecbcrypto -name "*.java" >> arg_file
find src/main/java/org/cryptoapi/bench/brokenhash -name "*.java" >> arg_file
find src/main/java/org/cryptoapi/bench/brokencrypto -name "*.java" >> arg_file
find src/main/java/org/cryptoapi/bench/insecureasymmetriccrypto -name "*.java" >> arg_file

rm -rf build
mkdir build

for inputfile in `cat arg_file`; do
    echo "------------------------"
    echo "$inputfile"
    echo "------------------------"
    sh ${CFJAVAC} -processor ${APS} -classpath ${CP} -Astubs="stubs/crypto" -d ${CD}/build $inputfile -AsuppressWarnings=cast.unsafe
done