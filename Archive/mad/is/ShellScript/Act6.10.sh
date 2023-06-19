#!/bin/bash

if [[ $1 == "" ]]
then
    echo "Error: se necesita introducir un usuario.";
    exit;
fi

# Copia de seguridad
cp -f /etc/passwd /etc/passwd_cp
cp -f /etc/group /etc/group_cp
cp -f /etc/shadow /etc/shadow_cp
cp -f /etc/shadow /etc/gshadow_cp

coincidence=$(cat /etc/passwd_cp | grep $1 | wc -l);

if [[ $coincidence -le 0 ]]
then
    echo "Error: el usuario introducido no existe.";
    exit;
fi

home=$(cat /etc/passwd_cp | grep $1 | cut -d ":" -f 6);

if [ -d $home ]
then
    echo "rm" $home "-r";
fi

function remove_user_from_file () {
    l=1;
    while read -r line
    do
        user=$(echo $line | cut -d ":" -f 1);
        if [[ $user == $1 ]]
        then
            sed -i $l"d" $2;
            break;
        fi
        l=$(($l+1));
    done < $2
}

remove_user_from_file $1 "/etc/passwd_cp";
remove_user_from_file $1 "/etc/shadow_cp";
remove_user_from_file $1 "/etc/group_cp";
remove_user_from_file $1 "/etc/gshadow_cp";

sed -i "s/$user,//" "/etc/group_cp";
sed -i "s/$user//" "/etc/group_cp";
sed -i "s/$user,//" "/etc/gshadow_cp";
sed -i "s/$user//" "/etc/gshadow_cp";