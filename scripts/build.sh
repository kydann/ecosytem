if [ "$#" -ne 2 ]
then
	echo "usage example: $0 accounts /home/user/projects"
        exit
fi	

ARTIFACT=$1
PROJECT_PATH=$2

if [ "${PROJECT_PATH: -1}" == "/" ]
then
        PROJECT_PATH="${PROJECT_PATH:: -1}"
fi

cd $PROJECT_PATH

mvn archetype:generate -B -DarchetypeGroupId=com.citibanamex.bne -DarchetypeArtifactId=api-domain-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=com.citibanamex.bne -DartifactId=$ARTIFACT -Dversion=1.0.0-SNAPSHOT

cd -

mv -f $PROJECT_PATH/$ARTIFACT/src/main/resources/$ARTIFACT.yml ../config/src/main/resources/shared

cd ..

echo "" >> config/src/main/resources/shared/gateway.yml
echo "    $ARTIFACT:" >> config/src/main/resources/shared/gateway.yml
echo "        path: /$ARTIFACT/**" >> config/src/main/resources/shared/gateway.yml
echo "        serviceId: $ARTIFACT" >> config/src/main/resources/shared/gateway.yml

