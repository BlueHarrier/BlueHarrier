#!/bin/bash

touch "$HOME/.find_temp";

find /usr/bin -type f -size +1536k -atime +30 >> "$HOME/.find_temp";

ans='';
while [[ $ans != 'Y' ]] && [[ $ans != 'n' ]]
do
    echo "¿Desea borrar los archivos encontrados? [Y/n]";
    read ans;
done

if [[ $ans == 'Y' ]]
then
    cat "$HOME/.find_temp";
fi

rm "$HOME/.find_temp";
