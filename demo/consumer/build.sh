#!/bin/bash

docker rmi registry.cop.beomzh.local:8443/apps/activemq-consumer:latest
mvn clean package
mv target/consumer-1.0-SNAPSHOT.jar ./consumer.jar


docker build . -t registry.cop.beomzh.local:8443/apps/activemq-consumer:latest

docker push registry.cop.beomzh.local:8443/apps/activemq-consumer:latest
