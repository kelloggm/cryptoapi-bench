#!/bin/bash

CD=`pwd`

CFJAVAC="${CD}/../../../jsr308/checker-framework/checker/bin-devel/javac"

KMSCHECKER="com.amazon.checkerframework.compliance.kms.ComplianceChecker"
CRYPTOCHECKER="com.amazon.checkerframework.cryptopolicy.CryptoPolicyComplianceChecker"
APS="${KMSCHECKER},${CRYPTOCHECKER}"

KMSJAR="${CD}/../aws-kms-compliance-checker/build/libs/aws-kms-compliance-checker.jar"

CRYPTOJAR="${CD}/../aws-crypto-policy-compliance-checker/build/libs/aws-crypto-policy-compliance-checker.jar"

CP="${KMSJAR}:${CRYPTOJAR}"

find . -name "*.java" > arg_file

rm -rf build
mkdir build

sh ${CFJAVAC} -processor ${APS} -classpath ${CP} -Astubs="stubs/kms:stubs/crypto" -d ${CD}/build @arg_file
