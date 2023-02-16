package com.lucaslima.cms.configuration;

import com.lucaslima.cms.application.ports.out.RegisterCustomerPort;
import com.lucaslima.cms.application.ports.out.SearchCustomerDataPort;
import com.lucaslima.cms.application.services.RegisterCustomerService;
import com.lucaslima.cms.application.services.SearchCustomerDataService;
import com.lucaslima.cms.application.services.validators.CustomerValidator;
import com.lucaslima.cms.application.services.validators.validations.CnpjIsValid;
import com.lucaslima.cms.application.services.validators.validations.CustomerValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SpringConfiguration {


    @Bean
    public RegisterCustomerService beanRegisterCustomerService(RegisterCustomerPort registerCustomerPort) {
        List<CustomerValidation> customerValidationList = List.of(new CnpjIsValid(List.of()));
        CustomerValidator customerValidator = new CustomerValidator(customerValidationList);
        return new RegisterCustomerService(customerValidator, registerCustomerPort);
    }

    @Bean
    public SearchCustomerDataService beanSearchCustomerDataService(SearchCustomerDataPort searchCustomerDataPort) {
        return new SearchCustomerDataService(searchCustomerDataPort);
    }

}
