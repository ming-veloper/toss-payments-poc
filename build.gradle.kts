import com.github.gradle.node.npm.task.NpmTask
import com.github.gradle.node.task.NodeTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    // SPRING
    id("org.springframework.boot") version ("2.7.4")
    id("io.spring.dependency-management") version ("1.0.14.RELEASE")

    // JAVA
    id("java")

    // NODE_JS
    id("com.github.node-gradle.node") version ("3.4.0")

    // KOTLIN
    kotlin("jvm") version "1.7.10"
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
    implementation(kotlin("stdlib-jdk8"))
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

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("npmRemove") {
    val nodeModules = file("${project.projectDir}/src/main/resources/static/node_modules")
    val jsFileName = "main.js"
    val jsFile = file("${project.projectDir}/src/main/resources/static/$jsFileName")
    val packageLockFile = file("${project.projectDir}/src/main/resources/static/package-lock.json")

    if (nodeModules.exists()) nodeModules.deleteRecursively()
    if (jsFile.exists()) jsFile.delete()
    if (packageLockFile.exists()) packageLockFile.delete()
}

tasks.first { it.name == "clean" }.dependsOn("npmRemove")


tasks.register("npmSetScript", type = NodeTask::class) {
    dependsOn("npmInstall")
    script.set(file("${project.projectDir}/src/main/resources/static/package.json"))
}


tasks.register("npmRunBuild", type = NpmTask::class) {
    dependsOn("npmSetScript")
    args.set(listOf("run", "build"))
}

// BUILD <-- npmRunBuild <-- npmSetScript <-- npmInstall
tasks.named("bootJar", type = BootJar::class) {
    dependsOn("npmRunBuild")
    // jar 파일에 컨버팅 된 typescript 삽입
    from("${project.projectDir}/src/main/resources/static/main.js") {
        into("BOOT-INF/classes/static")
    }
}

