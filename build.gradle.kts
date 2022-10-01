import com.github.gradle.node.npm.task.NpmTask
import com.github.gradle.node.task.NodeTask

plugins {
    // SPRING
    id("org.springframework.boot") version ("2.7.4")
    id("io.spring.dependency-management") version ("1.0.14.RELEASE")

    // JAVA
    id("java")

    // NODE_JS
    id("com.github.node-gradle.node") version ("3.4.0")
}

node {
    download.set(true)
    nodeProjectDir.set(file("${project.projectDir}/src/main/resources/static"))
}

group = "com.ming"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}
val feignVersion: String = "11.9.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.github.openfeign:feign-core:$feignVersion")
    implementation("io.github.openfeign:feign-okhttp:$feignVersion")
    implementation("io.github.openfeign:feign-gson:$feignVersion")
    implementation("io.github.openfeign:feign-slf4j:$feignVersion")
    implementation("org.modelmapper:modelmapper:3.1.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    compileOnly("org.projectlombok:lombok")
    implementation("mysql:mysql-connector-java")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("npmSetScript", type = NodeTask::class) {
    dependsOn("npmInstall")
    script.set(file("${project.projectDir}/src/main/resources/static/package.json"))
}


tasks.register("npmRunBuild", type = NpmTask::class) {
    dependsOn("npmSetScript")
    args.set(listOf("run", "build"))
}


// BUILD <-- npmRunBuild <-- npmSetScript <-- npmInstall
tasks.first { it.name == "bootJar" }.dependsOn("npmRunBuild")

