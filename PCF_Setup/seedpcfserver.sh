#!/bin/bash

## create demo users
##
## Parameters
## Usage:
## $ seedpcf.sh <org>
##
## This script assumes you are already logged into your PCF instance.
## You must be an org manager of the org you specify.
## It will create 10 spaces in the current org, from "student1" to 
## "student10", and create and assign a quota "workshop" to each. 
## Each student account must be created by an admin user.
##

org=$1
cf target -o $org -s questrade

cf create-space-quota workshop -m 2G -r 1000 -s 10

i="1"
## create student accounts
while [ $i -lt 11 ]
do
# No permissions in PEZ to create users
#cf create-user student$[$i] $pword
cf create-space student$[$i]
cf set-space-quota student$[$i] workshop

# Create services
cf target -o $org -s student$[$i]
cf create-service p-mysql 100mb-dev mysql-svc
cf create-service p-config-server standard config-svc

# Can only do this after the student accounts have been created
#cf set-space-role student$[$i] $org student$[$i] SpaceDeveloper

i=$[$i+1]
done

