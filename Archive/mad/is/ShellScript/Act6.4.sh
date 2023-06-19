#!/bin/bash
# El número de archivos a los que hace más de un mes que no se accede

find / -atime +30 -type f | wc -l;