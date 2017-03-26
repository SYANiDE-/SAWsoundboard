#!/bin/bash
rm {Java.jar,Java.class,AgencyKeystore,SAWsoundboard.jar}
javac Java.java
echo "Permissions: all-permissions" > /root/manifest.txt
jar cvf Java.jar Java.class
keytool -genkey -alias signapplet -keystore AgencyKeystore -keypass AgencyKeyPass -storepass AgencyStorePass
jarsigner -keystore AgencyKeystore -storepass AgencyStorePass -keypass AgencyKeyPass -signedjar SAWsoundboard.jar Java.jar signapplet
cp {SAWsoundboard.jar,Java.class} /var/www/html/

