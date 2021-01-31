package com.hanish.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@ArchTag("LayerConventionTest")
@AnalyzeClasses(packages = "com.hanish", importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class,
        ImportOption.DoNotIncludeArchives.class})
public class LayerConventionTest {
    /**
     * Layers testing:
     * Check Controllers not accessed by other classes
     * Check Services are only accessed by Controllers and Main application class
     * Check Repositories are only accessed by services
     */
    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Controllers").definedBy("com.hanish.controller..")
            .layer("Services").definedBy("com.hanish.service..")
            .layer("Repositories").definedBy("com.hanish.repository..")
            .layer("Application").definedBy("com.hanish..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers", "Application")
            .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Services");
}
