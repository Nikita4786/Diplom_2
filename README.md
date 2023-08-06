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
Надо выбрать БД, на которой будете запускать и выставить соответствующую настройку в файле 'src/test/resources/config.properties. Параметр `db_type`. Далее, в проекте автоматически выберется необходимый драйвер для подключения к БД.
К примеру, если будете запускать приложение на MySQL, то команда:

   `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app`

Затем, в файле config.properties в поле db_type выставить `MySQL`

Если будете запускать приложение на Postgresql, то команда будет следующая:

   `java -jar .\artifacts\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app`

Затем, в файле config.properties в поле db_type выставить `Postgresql`

4. В другом терминале запустить тесты командой:

   `.\gradlew clean test`

5. Далее открыть отчёт:

   `.\gradlew allureServe`

6. Для остановки контейнеров:

   `docker-compose down`

   или

   `docker stop mysqlserver postgres gate`
