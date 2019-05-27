package info.chen.microservice.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRuleConfiguration {

    @Bean
    public IRule getRule() {
        return new CustomRule();
    }

}
