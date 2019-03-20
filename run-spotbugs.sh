#!/bin/bash

# this script runs spotbugs on each benchmark inscope for the compliance paper,
# and prints the results to stdout

source utils.sh

SPOTVERSION="3.1.12"
SPOTBUGSJAR="./spotbugs-${SPOTVERSION}/lib/spotbugs.jar"

# if spotbugs isn't already present, fetch it
if [ ! -d "spotbugs-${SPOTVERSION}" ]; then
    wget "http://repo.maven.apache.org/maven2/com/github/spotbugs/spotbugs/${SPOTVERSION}/spotbugs-${SPOTVERSION}.tgz"
    gunzip -c "spotbugs-${SPOTVERSION}.tgz" | tar xvf -
fi

rm -rf build
mkdir build

create_argfile

echo "running SpotBugs ${SPOTVERSION} on microbenchmarks"

for inputfile in `cat arg_file`; do
    javac -d ${CD}/build ${inputfile}
done

for inputdir in ${inputdirs}; do
    echo "-------------"
    echo "${inputdir}"
    echo "-------------"
    java -jar $SPOTBUGSJAR -textui ${CD}/build/org/cryptoapi/bench/${inputdir}/
done
