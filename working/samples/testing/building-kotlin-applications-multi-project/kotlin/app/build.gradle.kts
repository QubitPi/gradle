plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
}

application {
    mainClass = "demo.app.AppKt" // <1>
}
