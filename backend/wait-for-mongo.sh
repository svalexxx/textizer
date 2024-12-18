#!/bin/bash
until nc -z -v -w30 mongodb 27017
do
  echo "Waiting for MongoDB connection..."
  sleep 5
done
echo "MongoDB is up!"