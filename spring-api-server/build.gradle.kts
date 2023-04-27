import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinXCoroutineVersion = "1.6.4"
val kotlinXSerializationVersion = "1.4.1"
plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.smokyearlgray"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {

    //KOTLIN
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.22")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinXCoroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$kotlinXCoroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$kotlinXCoroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinXSerializationVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinXCoroutineVersion")

    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.2.1")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    testImplementation("io.projectreactor:reactor-test:3.5.1")

    // SPRING
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework:spring-context")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
        // ARMERIA
//    implementation("com.linecorp.armeria:armeria-grpc-protocol")
//    implementation("com.linecorp.armeria:armeria-grpc")
    implementation("com.linecorp.armeria:armeria-kotlin")
    implementation("com.linecorp.armeria:armeria-spring-boot2-webflux-starter")
    implementation(platform("com.linecorp.armeria:armeria-bom:1.19.0"))
    implementation(platform("io.netty:netty-bom:4.1.79.Final"))
    testImplementation("com.ninja-squad:springmockk:3.1.1")


//    // PROTOBUF & GRPC
//    implementation("com.google.protobuf:protobuf-java:3.21.5")
//    implementation("com.google.protobuf:protobuf-kotlin:3.21.5")
//    implementation("io.confluent:kafka-protobuf-serializer:7.3.0")
//    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
//    implementation("io.grpc:grpc-stub:${grpcVersion}")
//    api("io.grpc:grpc-kotlin-stub:1.3.0")

//    // AWS
//    implementation(platform("software.amazon.awssdk:bom:2.17.276"))
//    implementation("aws.sdk.kotlin:dynamodb:0.17.6-beta")
//    implementation("software.amazon.awssdk:dynamodb-enhanced")
//    implementation("software.amazon.awssdk:kinesis")
//    implementation("software.amazon.awssdk:s3")
//    implementation("software.amazon.awssdk:sqs")
//    implementation("software.amazon.awssdk:sts") // For EKS Service Account Credential
//    implementation("software.amazon.msk:aws-msk-iam-auth:1.1.5")
//
//    // JWT
//    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
//    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
//    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
//
//    // MISC
//    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
//    implementation("com.databricks:databricks-jdbc:2.6.32")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("com.github.jillesvangurp.kt-search:search-client:1.99.18")
//    implementation("com.google.code.gson:gson:2.9.1")
//    implementation("com.google.firebase:firebase-admin:9.1.1")
//    implementation("io.ktor:ktor-client-auth:$ktorVersion")
//    implementation("io.ktor:ktor-client-cio:$ktorVersion")
//    implementation("io.ktor:ktor-client-core:$ktorVersion")
//    implementation("io.micrometer:micrometer-registry-statsd")
//    implementation("net.logstash.logback:logstash-logback-encoder:6.6")
//    implementation("org.bitbucket.b_c:jose4j:0.8.0")
//
//    testImplementation("io.mockk:mockk:1.13.2")
//    testImplementation("mysql:mysql-connector-java")
//    testImplementation("org.assertj:assertj-core:3.23.1")
//    testImplementation("org.testcontainers:mysql:1.17.6")
//    testImplementation("org.testcontainers:r2dbc:1.17.6")
//    testImplementation("org.testcontainers:testcontainers:1.17.6")
//
//    testImplementation(kotlin("test"))
    }

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
