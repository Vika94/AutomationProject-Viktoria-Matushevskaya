# Test-project

### **-Команда для просмотра доступных обновлений библиотек:**
### _**mvn versions:display-dependency-updates**_

Вывод команды:

The following dependencies in Dependencies have newer versions:

[INFO]   com.codeborne:selenide .......... 5.25.0 -> 5.25.0-selenium-4.0.0-rc-2

[INFO]   com.fasterxml.jackson.dataformat:jackson-dataformat-yaml ...
 2.12.5 -> 2.13.0

[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0

### **-Команда для запуска testng.xml файла**

(Предварительно прописав ![img_8.png](img_8.png)конфигурации в  pom.xml файле)

### **mvn clean test**

Вывод команды:

[INFO] Results:

[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
[INFO] BUILD SUCCESS

### **-Команда для проброса параметра из mvn command line в тест Task17**

### **mvn clean -Dtest=Task17#test1 -Duserid=1**

где Duserid=1-параметр теста со значением 1,
    
Task17-класс с тестами,
   
test1-имя теста
