package com.example.ob_rest_datajpa.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API BOOKS",
                description = "Our app provides a listen of books",
                termsOfService = "www.prueba.com/terms",
                contact = @Contact(
                        name = "Dickson Vejar",
                        email = "dicksonvejardev@gmail.com",
                        url = "https://www.instagram.com/accounts/login/?next=https%3A%2F%2Fwww.instagram.com%2Fim_danieldev%2F&is_from_rle"
                ),
                version = "1.0.0",
                license = @License(
                        name = "Standar Software Use License for Dickson Vejar",
                        url = "www.ejemplo.com/license",
                        identifier = "521.923"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8081"
                )
        }
)

public class SwaggerConfig {
}
