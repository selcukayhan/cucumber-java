#!/bin/bash
# health-check.sh

#We need to set -e for being able to process regex commands
set -e

#empty argument list
cmd="$@"


while ! curl -sSL "http://127.0.0.1:4444/wd/hub/status" 2>&1 | #making curl request to grid's status endpoint until it returns status=true otherwise return false.
    sed '/ready/!d' | #we are extracting the line which has ready key from response
    sed s/\"ready\"://g |
    sed s/\"//g |
    sed s/\ //g| #previous 3 sed commands for picking up second keyword in the line(value of ready key), then replacing every char with space except value. There will be only value of the ready key will stand
    grep "true," >/dev/null; do #if the last standing keyword is not true it is gonna perform following 2 line. if it is true it will return true to break while loop !true==false
    echo 'Waiting for the Grid' #will print Waiting for the Grid
    sleep 1 #then will wait for a sec to perform loop again
done

#if the ready key's value is true program gonna print Docker - Selenium Grid is up
>&2 echo "Docker - Selenium Grid is up"

#this line will execute $@ arguments and finished cmd after it (we don't have any argument, so it is basically for finishing execution of sh script)
exec $cmd