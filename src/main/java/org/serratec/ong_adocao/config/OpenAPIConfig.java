package org.serratec.ong_adocao.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contato = new Contact();
        contato.setEmail("marcospaulo@email.com.br");
        contato.setName("Marcos Paulo");
        contato.setUrl("https://serratec.org.br");

        License apacheLicense = new License()
                .name("Apache License")
                .url("https://www.apache.org/license/LICENSE-2.0");

        Info info = new Info()
                .title("API de ONG de Adoção de Animais")
                .version("1.0")
                .contact(contato)
                .description("API criada para uma ONG de adoção de animais.")
                .termsOfService("https://serratec.org.br")
                .license(apacheLicense);

        return new OpenAPI().info(info);
    }
}
