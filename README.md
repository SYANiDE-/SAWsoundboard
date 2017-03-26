AgencyKeystore	Java.jar   rebuild.sh  SAWsoundboard.css   SAWsoundboard.jar
Java.class	Java.java  saw.jpg     SAWsoundboard.html  saw_sticker.jpg

Copy the following files to webroot:
SAWsoundboard.html
SAWsoundboard.css
saw.jpg
saw_sticker.jpg


Edit Java.java to taste

Run ./rebuild.sh.  First, it will try to clean the build area.  Then it takes through the process compiling the .java file and signing the final jar.   Then it copies the compiled and signed SAWsoundboard.jar and Java.class to /var/www/html/  (assumed webroot).  Any changes to the Java.java, you should run this file afterwards.

***Disclaimer***
I do not own nor purport to be the soleful owner or legal rightsbearer for the two SAW-related images.  These images included as public-domain OSINT publicly-available medium subject to fair use.  Do not reuse these two images for commercial purposes!  Inclusion for demonstration purposes only. 

Project created for educational purposes,  OSCP certification.
***Disclaimer***
