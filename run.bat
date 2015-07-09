@Echo off
if .%1 == . goto default

echo parameter %1
mvn test -Dorg.seleniumhq.selenium-version=%1
goto stop

:default
echo default
mvn test -Dorg.seleniumhq.selenium-version=2.46.0**********

:stop
exit
