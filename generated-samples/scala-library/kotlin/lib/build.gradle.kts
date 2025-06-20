plugins {
    scala // <1>
    `java-library` // <2>
}

repositories {
    mavenCentral() // <3>
}

dependencies {
    implementation(libs.scala.library) // <4>

    implementation(libs.guava) // <5>

    testImplementation(libs.junit) // <6>
    testImplementation(libs.scalatest.v2.v13)
    testImplementation(libs.junit.v4.v13.v2.v13)

    testRuntimeOnly(libs.scala.xml.v2.v13) // <7>

    api(libs.commons.math3) // <8>
}
