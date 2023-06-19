#!/bin/bash

for dir in $(ls /home);
do
    find "/home/$dir" -type f;
done