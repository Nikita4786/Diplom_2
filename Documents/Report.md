# Краткое описание:

Было проведено тестированию функционала покупки тура через дебетовую и кредитную карты приложения "Путешествие дня".

## Количество Тест-кейсов:

Всего было пройдено 23 тест-кейса. Общий процент успешных тестов: 73.91%.

Тесты были разбиты на следующие классы:

* NegativeTests - негативные сценарии
* PositiveTest - позитивные сценарии
* ApiTest - тестирование REST API (позитивные и негативные сценарии)

![Screenshot_1.png](pic%2FScreenshot_1.png)

* NegativeTests - 7 тестов пройдено, 2 теста не пройдено
* PositiveTest - 2 теста пройдено, 2 теста не пройдено
* ApiTest - 8 тестов пройдено, 2 теста не пройдено.

## Более подробный график результатов:

![Screenshot_2.png](pic%2FScreenshot_2.png)

## Список тестов в отчёте:

![Screenshot_3.png](pic%2FScreenshot_3.png)

### Общие итоги:

|                  | Кол-во тестов | Passed | Failed | Passed, % |
|:-----------------|:-------------:|:------:|:------:|----------:|
| ApiTest          |      10       |   8    |   2    |       80% |
| PositiveTest     |       4       |   2    |   2    |       50% |
| NegativeTests    |       9       |   7    |   2    |     77.7% |
| Всего            |      23       |   17   |   6    |    73.91% |

В результате было составлено 3 баг-репорта https://github.com/Nikita4786/Diplom_2/issues 

## Общие рекомендации

* Интерфейс не очень удобный
* Сложно искать уникальные локаторы