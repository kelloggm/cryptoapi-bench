#!/bin/bash

source utils.sh

# if the CrySL jar isn't here, go fetch it.
if [ ! -f CryptoAnalysis-2.0-jar-with-dependencies.jar ]; then
    wget https://github.com/CROSSINGTUD/CryptoAnalysis/releases/download/2.0/CryptoAnalysis-2.0-jar-with-dependencies.jar
fi

rm -rf ${CD}/build
mkdir ${CD}/build

create_argfile

for inputfile in `cat arg_file`; do
    javac -d ${CD}/build ${inputfile}
done

java -cp CryptoAnalysis-2.0-jar-with-dependencies.jar crypto.HeadlessCryptoScanner --rulesDir=${CD}/JCA_rules --applicationCp=${CD}/build/
