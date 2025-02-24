### 1 - creation of interface `IDao`

```java
public interface IDao {
    public double getData();
}
```

### 2 - An implementation of `IDao`

```java
public class DaoImplV1 implements IDao {
    @Override
    public double getData() {
        System.out.println("version base de donnees");
        return 29;
    }
}
```

### 3 - creation of interface `IMetier`

```java
public interface IMetier {
    public double calcul();
}
```

### 4 - an implementation of `IMetier` with dependency inversion.

- generally speaking we can do that by declaring the variable using the interface instead of the class itself.

```java
public class MetierImpl implements IMetier {
    IDao daoImp;
    public MetierImpl() {

    }
    @Override
    public double calcul() {
        return daoImp.getData() * 10;
    }
}
```

### 5 - dependency injection :

#### a - with static instantiation

- in general we achieve it by using the simple instantiation with `new` keyword, like how we did in presentation layer

```java
public class PresentationSimple {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // static instantiation using "new" keyword
        IMetier metierImpl = new MetierImpl();
        System.out.println(metierImpl.calcul());
    }
}
```

#### b - with dynamic instantiation

- dynamic instantiation is done by avoid using the `new` keyword, that help us to read a close code to the modifications.

```java
public class MetierImpl implements IMetier {
    IDao daoImp;
    public MetierImpl() throws FileNotFoundException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // dynamic instantiation
        Scanner scanner = new Scanner(new File("config.txt"));
        Class iDao = Class.forName(scanner.nextLine());
        daoImp = (IDao)iDao.getConstructor().newInstance();
    }
}
```

#### c - with spring framework

##### xml version

- first we must import the three libraries to work with spring framework

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>7.0.0-M2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.0-M2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>7.0.0-M2</version>
</dependency>
```

- then instead of using a config file that has no standard way we can use xml file that will hold our object in terms of `<beans>`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="d" class="com.example.xml.DaoImplV1"></bean>
    <bean id="metier" class="com.example.xml.MetierImpl">
        <property name="daoImp" ref="d"></property>
    </bean></beans>
```

- after defining our objects now we just call them in java code.

```java
public class XmlPresentation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}
```

##### annotations version

- when the objects become too much it becomes so difficult to manage with an xml file, here the annotation way of dependency injection solve the problem. by using annotations we can write a closed code that will respect dependency inversion.
- the presentation layer is like the xml version but we use the package location instead of the xml config file.

```java
public class AnnotationsPresentation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.annotations");
        IMetier metier = (IMetier) context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
```

- by using `@Compoenent`, `@Service` or `@Repository` we tell spring to instantiate objects of the corresponding classes.

```java
@Service("metier")
public class MetierImpl implements IMetier {...}

@Repository("dao2")
public class DaoImplV2 implements IDao {...}
```

- there is a lot of annotation that help us in `IOC` and `dependency injection` but it is hard to cover every details in this practical work
- thank you for reading.
- end.
