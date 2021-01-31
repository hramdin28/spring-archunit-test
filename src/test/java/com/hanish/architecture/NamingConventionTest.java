package com.hanish.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@ArchTag("NamingConventionTest")
@AnalyzeClasses(packages = "com.hanish", importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class,
        ImportOption.DoNotIncludeArchives.class})
class NamingConventionTest {

    /**
     * Check classes/interfaces names in packages ..repository ends with Repository
     */
    @ArchTest
    static ArchRule repositories_should_end_with_Repository =
            classes()
                    .that().resideInAPackage("..repository")
                    .should().haveSimpleNameEndingWith("Repository");
    /**
     * Check classes/interfaces names in packages ..service ends with Service
     */
    @ArchTest
    static ArchRule services_should_end_with_Service =
            classes()
                    .that().areInterfaces()
                    .and().resideInAPackage("..service")
                    .should().haveSimpleNameEndingWith("Service");
    /**
     * Check classes/interfaces names in packages ..service.impl ends with ServiceImpl
     */
    @ArchTest
    static ArchRule services_impl_should_end_with_ServiceImpl =
            classes()
                    .that().resideInAPackage("..service.impl")
                    .should().haveSimpleNameEndingWith("ServiceImpl");
    /**
     * Check classes names in packages ..controller ends with Controller
     */
    @ArchTest
    static ArchRule controllers_should_end_with_Controller =
            classes()
                    .that().resideInAPackage("..controller")
                    .should().haveSimpleNameEndingWith("Controller");

}
