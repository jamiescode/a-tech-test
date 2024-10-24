// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlinter)
}

buildscript {
    dependencies {
        classpath(libs.navigation.safe.args.plugin)
    }
}

allprojects {
    tasks.withType<Test> { applyTestConfig() }
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        buildUponDefaultConfig = true
        config.setFrom("$rootDir/detekt.yml")
    }
}

fun Test.applyTestConfig() {
    useJUnitPlatform()
    testLogging {
        // Logging out the events allows us to spot any hanging tests
        events("started", "passed", "skipped", "failed", "standardOut", "standardError")
        outputs.upToDateWhen { false }
        showStandardStreams = true
    }
    addTestListener(createTestListener())
}

@Suppress("detekt.EmptyFunctionBlock")
fun createTestListener(): TestListener = object: TestListener {
    override fun beforeTest(testDescriptor: TestDescriptor?) {}
    override fun afterTest(testDescriptor: TestDescriptor?, result: TestResult?) {}
    override fun beforeSuite(suite: TestDescriptor?) {}
    override fun afterSuite(suite: TestDescriptor?, result: TestResult?) {
        if (suite?.parent != null && result != null) {
            val output = createTestSummaryText(result)
            val startItem = "|  "
            val endItem = "  |"
            val repeatLength = startItem.length + output.length + endItem.length
            val separator = "-".repeat(repeatLength)
            println("\n" + separator + "\n" + startItem + output + endItem + "\n" + separator)
        }
    }

    fun createTestSummaryText(result: TestResult): String {
        val summaryText = "Results: ${result.resultType} "
        val countText = "${result.testCount} tests"
        val passedText = "${result.successfulTestCount} passed"
        val failedText = "${result.failedTestCount} failed"
        val skippedText = "${result.skippedTestCount} skipped"
        return "$summaryText ($countText, $passedText, $failedText, $skippedText)"
    }
}