#!/bin/bash
# Descubrir cuántos ejecutables hay en /usr/bin

ls -lha  /usr/bin | cut -d " " -f 1 | grep -E "^-.+-x$" | wc -l;
