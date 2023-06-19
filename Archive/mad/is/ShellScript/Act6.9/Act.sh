#!/bin/bash

if [[ $1 == "" ]]
then
    echo "Se necesita la ruta del archivo a utilizar";
    exit;
fi

groupadd 'alumnos';
group_id=$(cat /etc/group | grep 'alumnos' | cut -d ":" -f 3);

while read -r line
do
    user_name=$(echo $line | cut -d ":" -f 1);
    user_pass=$(echo $line | cut -d ":" -f 2);
    hashed_pass=$(mkpasswd -m sha-512 $user_pass);
    useradd $user_name -m -p $hashed_pass -s "/bin/bash";
done < $1

