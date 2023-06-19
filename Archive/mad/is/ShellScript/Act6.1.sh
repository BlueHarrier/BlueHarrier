#!/bin/bash

if [ $# -lt 2 ]
then
    echo "No hay suficientes argumentos.";
    exit;
fi

if [ ! -d "$HOME/copias" ]
then
    mkdir "$HOME/copias";
fi



for i in $(seq 1 $2)
do
    #cp $1 "$HOME/copias/CopiaArchivo$i";
done