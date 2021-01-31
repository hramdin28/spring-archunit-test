package com.hanish.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@ArchTag("StereotypeConventionTest")
@AnalyzeClasses(packages = "com.hanish", importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class,
        ImportOption.DoNotIncludeArchives.class})
public class AnnotationConventionTest {

    /**
     * Check classes/Interfaces in package ..repository has annotation @Repository
     */
    @ArchTest
    static ArchRule repository_classes_reside_in_repository_package =
            classes()
                    .that().areAnnotatedWith(Repository.class)
                    .should().resideInAPackage("..repository");
    /**
     * Check classes in package ..service.impl has annotation @Service
     */
    @ArchTest
    static ArchRule service_classes_reside_in_service_impl_package =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().resideInAPackage("..service.impl");
    /**
     * Check classes in package ..controller has annotation @RestController
     */
    @ArchTest
    static ArchRule controller_classes_reside_in_controller_package =
            classes()
                    .that().areAnnotatedWith(RestController.class)
                    .should().resideInAPackage("..controller");
    /**
     * Check classes in package ..model has annotation @Entity
     */
    @ArchTest
    static ArchRule entity_classes_reside_in_model_package =
            classes()
                    .that().areAnnotatedWith(Entity.class)
                    .should().resideInAPackage("..model");
}
