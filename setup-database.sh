#!/bin/sh -e

mysql -uroot -p -e "DROP DATABASE IF EXISTS example;
CREATE DATABASE example;
GRANT ALL PRIVILEGES ON example.* TO example@localhost IDENTIFIED BY 'example';"
