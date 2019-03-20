#!/bin/bash

source utils.sh

CFJAVAC="${CD}/../../../jsr308/checker-framework/checker/bin-devel/javac"

KMSCHECKER="com.amazon.checkerframework.compliance.kms.ComplianceChecker"
CRYPTOCHECKER="com.amazon.checkerframework.cryptopolicy.CryptoPolicyComplianceChecker"
APS="${CRYPTOCHECKER}"

KMSJAR="${CD}/../aws-kms-compliance-checker/build/libs/aws-kms-compliance-checker.jar"

CRYPTOJAR="${CD}/../aws-crypto-policy-compliance-checker/build/libs/aws-crypto-policy-compliance-checker.jar"

CP="${KMSJAR}:${CRYPTOJAR}"

create_argfile

rm -rf build
mkdir build

for inputfile in `cat arg_file`; do
    echo "------------------------"
    echo "$inputfile"
    echo "------------------------"
    sh ${CFJAVAC} -processor ${APS} -classpath ${CP} -Astubs="stubs/crypto" -d ${CD}/build $inputfile -AsuppressWarnings=cast.unsafe
done
