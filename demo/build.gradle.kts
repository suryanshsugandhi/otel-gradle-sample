plugins {
    java
    id("application")
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("com.example.demo.DemoApplication")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.springframework.boot:spring-boot-starter-logging")
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.projectlombok:lombok:1.18.28")

    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")

//    implementation("io.opentelemetry:opentelemetry-api");
    implementation("io.opentelemetry:opentelemetry-sdk");
//    implementation("io.opentelemetry:opentelemetry-exporter-logging");
//    implementation("io.opentelemetry.semconv:opentelemetry-semconv:1.25.0-alpha");
//    implementation("io.opentelemetry:opentelemetry-sdk-extension-autoconfigure");

	implementation("org.apache.logging.log4j:log4j-core")
	implementation("org.apache.logging.log4j:log4j-api")

//	runtimeOnly("io.opentelemetry.instrumentation:opentelemetry-log4j-context-data-2.17-autoconfigure:1.32.1-alpha")
//	implementation("io.opentelemetry.instrumentation:opentelemetry-log4j-context-data-2.17-autoconfigure:2.4.0-alpha")


//	implementation("io.opentelemetry:opentelemetry-exporter-otlp:1.38.0")
}

configurations {
    all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}