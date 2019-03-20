#!/bin/bash

source utils.sh

create_argfile

rm -rf ${CD}/build
mkdir ${CD}/build

javac -d ${CD}/build @arg_file
