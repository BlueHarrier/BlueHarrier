#!/bin/bash
# Descargar servidor apache
# Mover carpeta de uso de apache a /var/www

apt-get install apache2 -y;

if [ ! -d "/var/www/html" ]
then
    mkdir /var/www/html;
fi

sed -i 's/\/var\/www/\/var\/www\/html/' /etc/apache2/apache2.conf;

service apache2 restart;