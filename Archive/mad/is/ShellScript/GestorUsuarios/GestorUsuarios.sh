#!/bin/bash

function menu_continue() {
    echo "Pulsa [ENTER] para continuar";
    read;
    clear;
}

function exec_menu1(){
    while true
    do
        echo "Gestión de usuarios";
        echo "1. Mostrar sesiones activas";
        echo "2. Crear usuario";
        echo "3. Deshabilitar cuenta";
        echo "4. Habilitar cuenta";
        echo "5. Cambiar nombre de usuario";
        echo "6. Eliminar usuario";
        echo "7. Volver";

        read ans;
        clear;

        if [[ $ans -eq 1 ]]
        then
            users;
            menu_continue;
        elif [[ $ans -eq 2 ]]
        then
            echo "(NOTA: la función mkpasswd no está en Xubuntu por defecto)";
            echo "Inserte nombre de usuario";
            read user_name;
            useradd $user_name -m;
            clear;
        elif [[ $ans -eq 3 ]]
        then
            echo "Inserte nombre de usuario";
            read user_name;
            usermod -L $user_name;
            clear;
        elif [[ $ans -eq 4 ]]
        then
            echo "Inserte nombre de usuario";
            read user_name;
            usermod -U $user_name;
            clear;
        elif [[ $ans -eq 5 ]]
        then
            echo "Inserte nombre de usuario";
            read user_name;
            echo "Inserte nuevo nombre de usuario";
            read new_name;
            usermod -l $new_name $user_name;
            clear;
        elif [[ $ans -eq 6 ]]
        then
            echo "Inserte nombre de usuario";
            read user_name;
            userdel $user_name -r;
            clear;
        elif [[ $ans -eq 7 ]]
        then
            return;
        else
            echo "Opción no válida";
            echo "";
        fi
    done
}

function  exec_menu2() {
    while true
    do
        echo "Gestión de grupos";
        echo "1. Mostrar grupos";
        echo "2. Crear grupo";
        echo "3. Mostrar miembros de un grupo";
        echo "4. Añadir miembro a un grupo";
        echo "5. Eliminar miembro de un grupo";
        echo "6. Renombrar grupo";
        echo "7. Eliminar grupo";
        echo "8. Volver";

        read ans;
        clear;

        if [[ $ans -eq 1 ]]
        then
            cat "/etc/group" | cut -d ':' -f 1;
            menu_continue;
        elif [[ $ans -eq 2 ]]
        then
            echo "Inserte nombre de grupo";
            read group;
            groupadd $group;
            clear;
        elif [[ $ans -eq 3 ]]
        then
            echo "Inserte nombre de grupo";
            read group;
            clear;
            cat "/etc/group" | grep -e "^$group" | cut -d ':' -f 4;
            menu_continue;
        elif [[ $ans -eq 4 ]]
        then
            echo "Inserte nombre del grupo";
            read group;
            echo "Inserte nombre de usuario";
            read user_name;
            usermod -aG $group $user_name;
            clear;
        elif [[ $ans -eq 5 ]]
        then
            echo "Inserte nombre del grupo";
            read group;
            echo "Inserte nombre de usuario";
            read user_name;
            userdel $user_name $group ;
            clear;
        elif [[ $ans -eq 6 ]]
        then
            echo "Inserte nombre de grupo";
            read old_group;
            echo "Inserte nuevo nombre de grupo";
            read new_group;
            groupmod --new-name $new_group $old_group;
            clear;
        elif [[ $ans -eq 7 ]]
        then
            echo "Inserte nombre de grupo";
            read group;
            groupdel $group;
            clear;
        elif [[ $ans -eq 8 ]]
        then
            return;
        else
            echo "Opción no válida";
            echo "";
        fi
    done
}

if [[ $(id -u) -ne 0 ]]
then
    echo "Se necesitan privilegios de administrador para ejecutar esta aplicación.";
    exit;
fi

clear;

while true
do
    echo "***************************";
    echo "Gestor de usuarios y grupos";
    echo "***************************";
    echo "";
    echo "Indique una opción:";
    echo "1. Gestionar usuarios";
    echo "2. Gestionar grupos";
    echo "3. Salir";

    read ans;
    clear;

    if [[ $ans -eq 1 ]]
    then
        exec_menu1;
    elif [[ $ans -eq 2 ]]
    then
        exec_menu2;
    elif [[ $ans -eq 3 ]]
    then
        exit;
    else
        echo "Opción no válida";
        echo "";
    fi
done
