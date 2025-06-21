plugins {
    groovy // <1>
}

repositories {
    mavenCentral() // <2>
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.13.0") // <3>

        implementation("org.apache.groovy:groovy-all:4.0.27")
    }

    implementation("org.apache.groovy:groovy-all") // <4>

    testImplementation("org.junit.jupiter:junit-jupiter:5.12.1") // <5>

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform() // <6>
}
