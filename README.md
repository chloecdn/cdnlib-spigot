# How to use:


1: Add Repository to your project:

- Maven (pom.xml):
```xml
<repositories>
    <repository>
        <id>cdn-repository</id>
        <url>https://repo.chloedev.de/releases</url>
    </repository>
</repositories>
```
- Gradle (build.gradle):
```gradle
repositories {
  //Groovy
  maven { url "https://repo.chloedev.de/releases" }
  //Kotlin
  maven { url = uri("https://repo.chloedev.de/releases") }
}
```

2: Add Dependency:

- Maven (pom.xml):
```xml
<dependencies>
    <dependency>
        <groupId>de.chloedev</groupId>
        <artifactId>cdnlib-spigot</artifactId>
        <version>{version}</version>
    </dependency>
</dependencies>
```
- Gradle (build.gradle):
```gradle
dependencies {
  //Groovy
  implementation "de.chloedev:cdnlib-spigot:{version}"
  //Kotlin
  implementation("de.chloedev:cdnlib-spigot:{version}")
}
```

Versions can be found [here](https://repo.chloedev.de/#/releases/de/chloedev/cdnlib-spigot/)
