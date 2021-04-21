# Rx Java



## 1. Library

```groovy
plugins {
    id 'java'
}

group 'com.binance'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation "io.reactivex.rxjava2:rxjava:2.2.7"
    implementation "io.reactivex.rxjava2:rxandroid:2.1.1"
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
}
```

