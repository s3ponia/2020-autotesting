# 2020-highload-dht
Курсовой проект 2020 года [курса](https://polis.mail.ru/curriculum/program/discipline/1017/) "Highload системы" в [Технополис](https://polis.mail.ru).

## Этап 1. HTTP + storage (deadline 2020-09-30)
### Fork
[Форкните проект](https://help.github.com/articles/fork-a-repo/), склонируйте и добавьте `upstream`:
```
$ git clone git@github.com:<username>/2020-highload-dht.git
Cloning into '2020-highload-dht'...
...
$ git remote add upstream git@github.com:polis-mail-ru/2020-highload-dht.git
$ git fetch upstream
From github.com:polis-mail-ru/2020-highload-dht
 * [new branch]      master     -> upstream/master
```

### Make
Так можно запустить тесты:
```
$ ./gradlew test
```

А вот так -- сервер:
```
$ ./gradlew run
```

### Develop
Откройте в IDE -- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) нам будет достаточно.

**ВНИМАНИЕ!** При запуске тестов или сервера в IDE необходимо передавать Java опцию `-Xmx256m`.

В своём Java package `ru.mail.polis.service.<username>` реализуйте интерфейс [`Service`](2020-highload-dht/src/main/java/ru/mail/polis/service/Service.java) и поддержите следующий HTTP REST API протокол:
* HTTP `GET /v0/entity?id=<ID>` -- получить данные по ключу `<ID>`. Возвращает `200 OK` и данные или `404 Not Found`.
* HTTP `PUT /v0/entity?id=<ID>` -- создать/перезаписать (upsert) данные по ключу `<ID>`. Возвращает `201 Created`.
* HTTP `DELETE /v0/entity?id=<ID>` -- удалить данные по ключу `<ID>`. Возвращает `202 Accepted`.

Возвращайте реализацию интерфейса в [`ServiceFactory`](2020-highload-dht/src/main/java/ru/mail/polis/service/ServiceFactory.java).

Реализацию `DAO` берём из весеннего курса `2020-db-lsm`, либо запиливаем [adapter](https://en.wikipedia.org/wiki/Adapter_pattern) к уже готовой реализации LSM с биндингами на Java (например, RocksDB, LevelDB или любой другой).

Проведите нагрузочное тестирование с помощью [wrk](https://github.com/giltene/wrk2) в **одно соединение**:
* `PUT` запросами на **стабильной** нагрузке (`wrk` должен обеспечивать заданный с помощью `-R` rate запросов)
* `GET` запросами на **стабильной** нагрузке по **наполненной** БД

Почему не `curl`/F5, можно узнать [здесь](http://highscalability.com/blog/2015/10/5/your-load-generator-is-probably-lying-to-you-take-the-red-pi.html) и [здесь](https://www.youtube.com/watch?v=lJ8ydIuPFeU).

Приложите полученный консольный вывод `wrk` для обоих видов нагрузки.

Отпрофилируйте приложение (CPU и alloc) под `PUT` и `GET` нагрузкой с помощью [async-profiler](https://github.com/jvm-profiling-tools/async-profiler).
Приложите SVG-файлы FlameGraph `cpu`/`alloc` для `PUT`/`GET` нагрузки.

**Объясните** результаты нагрузочного тестирования и профилирования и приложите **текстовый отчёт** (в Markdown).

Продолжайте запускать тесты и исправлять ошибки, не забывая [подтягивать новые тесты и фиксы из `upstream`](https://help.github.com/articles/syncing-a-fork/).
Если заметите ошибку в `upstream`, заводите баг и присылайте pull request ;)

### Report
Когда всё будет готово, присылайте pull request со своей реализацией и оптимизациями на review.
Не забывайте **отвечать на комментарии в PR** (в том числе автоматизированные) и **исправлять замечания**!

## Этап 2. Многопоточность (deadline 2020-10-07)

Обеспечьте потокобезопасность реализации `DAO` с использованием примитивов `java.util.concurrent.*`.
Прокачаться можно с руководством [Java Concurrency in Practice](http://jcip.net/).

Реализуйте **асинхронный flush** MemTable в SSTable, чтобы не блокировать пользовательские запросы.

Сконфигурируйте HTTP сервер, чтобы он обрабатывал запросы с помощью пула из нескольких потоков.

Проведите нагрузочное тестирование с помощью [wrk](https://github.com/giltene/wrk2) в **несколько соединений** (не меньше 16):
* `PUT` запросами на **стабильной** нагрузке (`wrk` должен обеспечивать заданный с помощью `-R` rate запросов)
* `GET` запросами на **стабильной** нагрузке по **наполненной** БД

Приложите полученный консольный вывод `wrk` для обоих видов нагрузки.

Отпрофилируйте приложение (CPU, alloc и **lock**) под `PUT` и `GET` нагрузкой с помощью [async-profiler](https://github.com/jvm-profiling-tools/async-profiler).
Приложите SVG-файлы FlameGraph `cpu`/`alloc`/`lock` для `PUT`/`GET` нагрузки.

**Объясните** результаты нагрузочного тестирования и профилирования и приложите **текстовый отчёт** (в Markdown).

### Report
Когда всё будет готово, присылайте pull request со своей реализацией и проведёнными **оптимизациями** на review.

## Этап 3. Асинхронный сервер (deadline 2020-10-14 00:00:00 MSK)

Вынесите **обработку** запросов в отдельный `ExecutorService` с ограниченной очередью, чтобы разгрузить `SelectorThread`ы HTTP сервера.

Проведите нагрузочное тестирование с помощью [wrk2](https://github.com/giltene/wrk2) с **большим количеством соединений** (не меньше 64) `PUT` и `GET` запросами.

Отпрофилируйте приложение (CPU, alloc и lock) под `PUT` и `GET` нагрузкой с помощью [async-profiler](https://github.com/jvm-profiling-tools/async-profiler).

### Report
Когда всё будет готово, присылайте pull request с изменениями, результатами нагрузочного тестирования и профилирования, а также анализом результатов **по сравнению с предыдущей** (синхронной) версией.
