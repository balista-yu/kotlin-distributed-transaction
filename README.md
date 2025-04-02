# Name

kotlin-distributed-transaction

## Overview

A Kotlin application that uses Atomikos to test distributed transactions(XA Transaction)

## Reference
- [Atomikos](https://www.atomikos.com/Main/WebHome)

## Getting Start

1. Clone the repository
```
$ git clone https://github.com/balista-yu/kotlin-distributed-transaction.git
```

2. Run docker compose
```
$ cd kotlin-distributed-transaction
$ task up
```

3. Run API
```
$ curl http://localhost:8080/sample/not-distributed-transaction
$ curl http://localhost:8080/sample/distributed-transaction
$ curl http://localhost:8080/sample/failed-not-distributed-transaction
$ curl http://localhost:8080/sample/failed-distributed-transaction
```

4. Confirm DB
- Login PostgreSQL Server
```
$ psql -h localhost -p 5432 -U test -d first_db
$ psql -h localhost -p 5432 -U test -d second_db
```

- Run SQL
```
first_db=# select id from first_table;
second_db=# select id from second_table;
```
