@echo off
REM start-all-services.bat - launches each project in a new cmd window so you can see its console
n:: Adjust paths to your workspace if you moved projectsnset WORKSPACE=C:\Users\Shiva\Documents\workspace-spring-tools-for-eclipse-4.32.0.RELEASE
necho Starting services in new windows (Eureka -> Admin -> Services -> Gateway)
n:: 1) Eureka (port 8761)
start "Eureka" cmd /k "cd /d %WORKSPACE%\EurekaServerforExceptionHandlingMicroservices1 && mvnw.cmd spring-boot:run"
n:: small delay to give Eureka a chance to boot; the cmd windows are independent so the script will continuen:: 2) Admin Server (port 2024)
start "AdminServer" cmd /k "cd /d %WORKSPACE%\adminserver\adminserver && mvnw.cmd spring-boot:run"
n:: 3) Services (2020, 2021, 2022)
start "Service-2020" cmd /k "cd /d %WORKSPACE%\ExceptionHandlingAndRestValidation && mvnw.cmd spring-boot:run"
start "Service-2021" cmd /k "cd /d %WORKSPACE%\ExceptionHandlingAndRestValidationMicroservice && mvnw.cmd spring-boot:run"
start "Service-2022" cmd /k "cd /d %WORKSPACE%\ObserverPatternRestValidationMicroservice && mvnw.cmd spring-boot:run"
n:: 4) API Gateway (port 2023)
start "APIGateway" cmd /k "cd /d %WORKSPACE%\APIGateWayMicro && mvnw.cmd spring-boot:run"
necho All start commands issued. Check the new windows for logs.
pause
