@echo off

set SKIP_BUILD=false

:argloop
if "%1" == "-skipBuild" (
    set SKIP_BUILD=true
    shift
    goto :argloop
)
if not "%1" == "" (
    shift
    goto :argloop
)

if "%SKIP_BUILD%" == "false" (
    call ./build.cmd
)

docker network create backend
docker-compose down --rmi local
docker-compose up -d