#!/bin/bash

echo "Introduzca el paquete que desea instalar: ";

read package_name;

{
    $installed = dpkg -l $package_name | cut -d "" -f1 | grep ii | wc -l;
} &> /dev/null

if $installed
then
    echo "El paquete ya está instalado.";
    exit 0;
fi;

apt-get install -y $package_name;