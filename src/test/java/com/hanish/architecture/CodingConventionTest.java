package com.hanish.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTag;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.slf4j.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

@ArchTag("CodingConventionTest")
@AnalyzeClasses(packages = "com.hanish", importOptions = {
        ImportOption.DoNotIncludeTests.class,
        ImportOption.DoNotIncludeJars.class,
        ImportOption.DoNotIncludeArchives.class})
public class CodingConventionTest {
    /**
     * Test to make sure field injection is not used in classes
     */
    @ArchTest
    private final ArchRule no_field_injection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    /**
     * Test to make sure interfaces are not available in packages ..impl..
     */
    @ArchTest
    static final ArchRule interfaces_must_not_be_placed_in_implementation_packages =
            noClasses()
                    .that().resideInAPackage("..impl..")
                    .should().beInterfaces();

    /**
     * Test to make sure loggers are private, static, final
     */
    @ArchTest
    private final ArchRule loggers_should_be_private_static_final =
            fields()
                    .that()
                    .haveRawType(Logger.class)
                    .should().bePrivate()
                    .andShould().beStatic()
                    .andShould().beFinal();
}
