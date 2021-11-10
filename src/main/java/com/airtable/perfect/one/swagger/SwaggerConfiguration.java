package com.airtable.perfect.one.swagger;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public Docket SwaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title(Messages.getString("SwaggerConfiguration.0")) //$NON-NLS-1$
				.version(Messages.getString("SwaggerConfiguration.1")) //$NON-NLS-1$
				.description(Messages.getString("SwaggerConfiguration.2")) //$NON-NLS-1$
				.contact(new Contact(Messages.getString("SwaggerConfiguration.3"), //$NON-NLS-1$
						Messages.getString("SwaggerConfiguration.4"), Messages.getString("SwaggerConfiguration.5"))) //$NON-NLS-1$ //$NON-NLS-2$
				.license(Messages.getString("SwaggerConfiguration.6")).build(); //$NON-NLS-1$
	}
}