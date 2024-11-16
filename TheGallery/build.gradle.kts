plugins {
    id("java")
}

group = "dev.KwadwoAK"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Langchain4j
    implementation("dev.langchain4j:langchain4j-open-ai:0.36.0")
    implementation("dev.langchain4j:langchain4j-anthropic:0.36.0")
    implementation("dev.langchain4j:langchain4j:0.36.0")

    testImplementation(platform("org.junit:junit-bom:5.11.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.25.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.test {
    useJUnitPlatform()
}