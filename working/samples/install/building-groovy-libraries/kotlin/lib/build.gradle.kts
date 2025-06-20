plugins {
    groovy // <1>
    `java-library` // <2>
}

repositories {
    mavenCentral() // <3>
}

dependencies {
    implementation(libs.groovy.all) // <4>

    implementation(libs.guava) // <5>

    testImplementation(libs.spock.core) // <6>
    testImplementation(libs.junit)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    api(libs.commons.math3) // <7>
}

tasks.named<Test>("test") {
    useJUnitPlatform() // <8>
}
