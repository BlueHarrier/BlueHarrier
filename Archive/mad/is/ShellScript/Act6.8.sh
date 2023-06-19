#!/bin/bash

user=$(whoami);

cat /etc/group | grep $user | cut -d ":" -f1;