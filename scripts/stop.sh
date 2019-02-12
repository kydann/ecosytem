#!/usr/bin/bash

if [ "$#" -ne 1 ]
then
	echo "example usage: $0 accounts"
	exit 1 
fi

ARTIFACT=$1

for i in `ps -fea | grep $ARTIFACT | grep -v grep | cut -d' ' -f2`;do kill -9 $i;done

cd ..

docker-componse down

mvn clean
