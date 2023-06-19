#!/bin/bash

letters=('a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' 'l' 'm' 'n' 'ñ' 'o' 'p' 'q' 'r' 's' 't' 'u' 'v' 'w' 'x' 'y' 'z');

rm $HOME'/Desktop/frase.txt';
touch $HOME'/Desktop/frase.txt';

for letter in "${letters[@]}"
do
    cat /usr/share/dict/spanish | grep -E '^'+$letter | head -n 1 | tr -d '\n' >> $HOME'/Desktop/frase.txt';
    if [[ "$letter" != "z" ]]
    then
        echo -n ' ' >> $HOME'/Desktop/frase.txt';
    else
        echo -n '.' >> $HOME'/Desktop/frase.txt';
    fi
done

