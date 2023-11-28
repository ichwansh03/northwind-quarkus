package com.northwind.web.config;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

@SecurityScheme(
        securitySchemeName = "JWT",
        description = "JWT authentication with bearer token",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "Bearer [token]"
)
@OpenAPIDefinition(
        info = @Info(
                title = "Northwind API",
                description = "Bootcamp Java ~ Quarkus Seesion",
                contact = @Contact(name = "Kang Dian", email = "dian@code.id", url = "https://code.id"),
                version = "1.0.0-SNAPSHOT"
        ),
        security = @SecurityRequirement(name = "JWT")
)
public class OpenApiConfig extends Application {
}
