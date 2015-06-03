package com.communeup.swagger;

import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet();

		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);

		// Custom resources in the project (all restful services)
		resources.add(com.communeup.web.rest.CommuneCrolController.class);

		addRestResourceClasses(resources);

		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method. It is automatically
	 * populated with all resources defined in the project. If required, comment
	 * out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources) {
	}

}
