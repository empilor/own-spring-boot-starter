package com.vzelenin.edu.signature.starter.autoconfigure;

import com.vzelenin.edu.signature.starter.controller.SignatureController;
import org.junit.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

public class SignatureAutoConfigurationIT {

    @Test
    public void shouldAutoConfigurationBeAppliedToWebApplication() {
        new WebApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(SignatureAutoConfiguration.class))
                .run(context -> {
                    assertThat(context).hasNotFailed()
                            .hasSingleBean(SignatureController.class)
                            .hasSingleBean(SignatureProperties.class)
                            .getBean(SignatureProperties.class)
                            .hasNoNullFieldsOrProperties();
                });
    }

    @Test
    public void shouldAutoConfigurationFailedDueToValidationConstraints() {
        new WebApplicationContextRunner()
                .withConfiguration(AutoConfigurations.of(SignatureAutoConfiguration.class))
                .withPropertyValues(
                        "edu.signature.username=Uma"
                )
                .run(context -> {
                    assertThat(context).hasFailed().getFailure()
                            .hasRootCauseInstanceOf(BindValidationException.class)
                            .hasStackTraceContaining("'edu.signature' on field 'username'");
                });
    }
}
