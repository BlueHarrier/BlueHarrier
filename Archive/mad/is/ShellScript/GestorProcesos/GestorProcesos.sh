#!/bin/bash

function menu_continue() {
    echo "Pulsa [ENTER] para continuar";
    read;
    clear;
}

function  exec_menu1() {
    ps aux;
    menu_continue;
}

function exec_menu2(){
    echo "Introduzca el proceso que desea comprobra: ";
    read proc_name;
    clear;
    ps aux | grep $proc_name;
    menu_continue;
}

function exec_menu3(){
    if [[ $(id -u) -ne 0 ]]
    then
        echo "Por favor, ejecute el programa como root (sudo)";
        menu_continue;
        return;
    fi

    while true
    do
        echo "¿Qué desea hacer?";
        echo "1. Iniciar un proceso";
        echo "2. Detener un proceso";
        echo "3. Volver al menú principal";

        read ans;
        clear;

        if [[ $ans -eq 1 ]]
        then
            echo "Introuzca el nombre del proceso a iniciar";
            read proc;
            $($proc &>/dev/null &);
            clear;
        elif [[ $ans -eq 2 ]]
        then
            echo "Introuzca el nombre del proceso a detener";
            read proc;
            pid=pidof $proc;
            if [[ $pid == "" ]]
            then
                pid=$proc;
            fi
            kill $pid;
            clear;
        elif [[ $ans -eq 3 ]]
        then
            return;
        else
            echo "Opción no válida";
            echo "";
        fi
    done
}

clear;

while true
do
    echo "******************";
    echo "Gestor de procesos";
    echo "******************";
    echo "";
    echo "Indique una opción:";
    echo "1. Listar procesos del sistema";
    echo "2. Mostrar información de un proceso";
    echo "3. Gestión de procesos (root)";
    echo "4. Salir";

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
        exec_menu3;
    elif [[ $ans -eq 4 ]]
    then
        exit;
    else
        echo "Opción no válida";
        echo "";
    fi
done
