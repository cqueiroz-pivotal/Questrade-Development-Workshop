#!/bin/bash

## create demo users
##
## Parameters
## Usage:
## $ cleanup.sh <org>
##
## This script assumes you are already logged into your PCF instance.
## You must be an org manager.
## It will delete 10 spaces in the current org, from "student1" to 
## "student10", and delete the "workshop" quota.
##

org=$1
cf target -o $org -s questrade

echo Deleting space quota workshop....
cf delete-space-quota -f workshop

echo Deleting spaces...
i="1"
while [ $i -lt 11 ]
do
# No permissions in PEZ to delete users
#cf delete-user -f student$[$i] $pword
cf delete-space -f student$[$i]

i=$[$i+1]
done

echo You will have to manually request the student accounts be deleted.
echo
echo Done!