call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo errors with calling runcrud
goto fail

:startbrowser
start "" http://localhost:8080/crud/v1/task/getTasks
goto done

:fail
echo.
echo There were errors

:done
echo.
echo showtasks success