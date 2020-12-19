# FlyWay-Multitenancy
Spring Boot Multitenacy Project Example


You just need to define your tenent here.
```
tenants:
  datasources:
    first:
      jdbcUrl: jdbc:mysql://localhost:3306/app_db_001?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
      username: root
      password: root
    second:
      jdbcUrl: jdbc:mysql://localhost:3306/app_db_002?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
      username: root
      password: root
    third:
      jdbcUrl: jdbc:mysql://localhost:3306/app_db_003?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
      username: root
      password: root
```

Post URL Example:- https://www.getpostman.com/collections/9982790f4dd30d460a97