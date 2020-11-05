package com.vzelenin.edu.signature.starter.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.vzelenin.edu.signature.starter")
//This annotation turns off own starter if property has value "false". Default "true"
@ConditionalOnProperty(value = "demo.signature.enabled", havingValue = "true", matchIfMissing = true)
public class SignatureAutoConfiguration {
}
