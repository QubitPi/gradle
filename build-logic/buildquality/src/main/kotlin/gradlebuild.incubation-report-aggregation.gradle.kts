import gradlebuild.basics.buildCommitId
import gradlebuild.basics.capitalize
import gradlebuild.incubation.tasks.IncubatingApiAggregateReportTask

plugins {
    id("base")
}

val reports by configurations.creating {
    isCanBeResolved = false
    isCanBeConsumed = false
    description = "Dependencies to aggregate reports from"
}

val allIncubationReports = tasks.register<IncubatingApiAggregateReportTask>("allIncubationReports") {
    group = "verification"
    reports.from(resolver("txt"))
    htmlReportFile = project.layout.buildDirectory.file("reports/incubation/all-incubating.html")
    csvReportFile = project.layout.buildDirectory.file("reports/incubation/all-incubating.csv")
    currentCommit = project.buildCommitId
}

tasks.register<Zip>("allIncubationReportsZip") {
    group = "verification"
    destinationDirectory = layout.buildDirectory.dir("reports/incubation")
    archiveBaseName = "incubating-apis"
    from(allIncubationReports.get().htmlReportFile)
    from(allIncubationReports.get().csvReportFile)
    from(resolver("html"))
}

fun resolver(reportType: String) = configurations.create("incubatingReport${reportType.capitalize()}Path") {
    isCanBeResolved = true
    isCanBeConsumed = false
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
        attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.DOCUMENTATION))
        attribute(DocsType.DOCS_TYPE_ATTRIBUTE, objects.named("incubation-report-$reportType"))
    }
    extendsFrom(reports)
}.incoming.artifactView { lenient(true) }.files
