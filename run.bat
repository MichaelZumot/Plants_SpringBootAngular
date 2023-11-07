@echo off

:: Change directory to \client and run ng serve
cd  C:\Users\zmich\OneDrive\Documenten\Plants_SpringBootAngular\client
start ng serve

:: Change directory to \backend and run mvn spring-boot:run
cd  C:\Users\zmich\OneDrive\Documenten\Plants_SpringBootAngular\backend
start mvn spring-boot:run

:: Change directory to \backend\src\treffle-proxy-server and run npm start
cd C:\Users\zmich\OneDrive\Documenten\Plants_SpringBootAngular\backend\src\trefle-proxy-server
start npm start
