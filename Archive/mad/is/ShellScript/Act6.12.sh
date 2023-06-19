#!/bin/bash

if [[ ! -d $1 ]]
then
    echo "El directorio indicado no existe.";
    exit;
fi

find -type f -name *.log | zip -c "$1-backup-$(date).zip";