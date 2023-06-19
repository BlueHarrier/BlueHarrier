#!/bin/bash

size=$(du -sh -B 1G $HOME | cut -f 1);

if [[ $size -ge 3 ]]
then
    echo "Demasiado espacio...";
fi
