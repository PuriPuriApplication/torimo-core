import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
	kotlin("plugin.jpa") version "1.3.61"
}

buildscript {
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-noarg")
	}
}

apply {
	plugin("kotlin-jpa")
}

group = "com.ppap"
version = "0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val retrofitVersion = "2.6.0"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
	implementation("com.squareup.retrofit2:adapter-rxjava:$retrofitVersion")
	implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
	implementation("com.google.firebase:firebase-admin:6.8.1")

	runtimeOnly("mysql:mysql-connector-java")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks {

	withType<Test> {
		useJUnitPlatform()
	}

	withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

	val cleanBuildWithCorePlugins by creating(GradleBuild::class) {
		tasks = listOf("clean")
	}
	"clean" {
		dependsOn(cleanBuildWithCorePlugins)
	}
}
