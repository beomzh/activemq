#!/bin/bash

docker rmi registry.cop.beomzh.local:8443/apps/activemq-producer:latest
mvn clean package
mv target/producer-1.0-SNAPSHOT.jar ./producer.jar


docker build . -t registry.cop.beomzh.local:8443/apps/activemq-producer:latest

docker push registry.cop.beomzh.local:8443/apps/activemq-producer:latest
