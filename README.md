# Дипломый проект #

## Требования:

Для запуска приложения необходимо установить инструменты:
* Docker
* IntelliJ IDEA
* Git

## Скачивание проекта:

Необходимо клонировать репозиторий в IntelliJ IDEA.

### Запуск контейнеров, тестов и создание отчёта:

1. Запустить терминал в папке с проектом. В терминале набрать:

   `docker-compose up -d`

2. Проверить запущенные контейнеры командой:

   `docker-compose ps`

3. Дождаться запуска контейнеров и запустить проект. 
Надо выбрать БД, на которой будете запускать.
К примеру, если будете запускать приложение на MySQL:

   `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`

Если будете запускать приложение на Postgresql, то команда будет следующая:

   `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app`

4. В другом терминале запустить тесты командой:

   `.\gradlew clean test -Ddbt=mysql`

или `.\gradlew clean test -Ddbt=postgresql` соответственно.

5. Далее открыть отчёт:

   `.\gradlew allureServe`

6. Для остановки контейнеров:

   `docker-compose down`

   или

   `docker stop mysqlserver postgres gate`