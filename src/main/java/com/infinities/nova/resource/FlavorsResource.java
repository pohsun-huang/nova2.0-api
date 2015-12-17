/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.nova.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.infinities.nova.api.NovaRequestContext;
import com.infinities.nova.api.openstack.compute.flavors.FlavorTemplate;
import com.infinities.nova.api.openstack.compute.flavors.FlavorsController;
import com.infinities.nova.api.openstack.compute.flavors.FlavorsTemplate;
import com.infinities.nova.api.openstack.compute.flavors.MinimalFlavorsTemplate;
import com.infinities.nova.api.openstack.wsgi.Resource;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FlavorsResource {

	private final FlavorsController controller;


	@Inject
	public FlavorsResource(FlavorsController controller) {
		this.controller = controller;
	}

	@GET
	public MinimalFlavorsTemplate index(@PathParam("projectId") String projectId,
			@Context ContainerRequestContext requestContext) throws Exception {
		NovaRequestContext novaContext = (NovaRequestContext) requestContext.getProperty("nova.context");
		Resource.processStack(requestContext, projectId, novaContext);
		return controller.index(requestContext);
	}

	@GET
	@Path("detail")
	public FlavorsTemplate datail(@PathParam("projectId") String projectId, @Context ContainerRequestContext requestContext)
			throws Exception {
		NovaRequestContext novaContext = (NovaRequestContext) requestContext.getProperty("nova.context");
		Resource.processStack(requestContext, projectId, novaContext);
		return controller.detail(requestContext);
	}

	@GET
	@Path("{flavorId}")
	public FlavorTemplate show(@PathParam("projectId") String projectId, @PathParam("flavorId") String flavorId,
			@Context ContainerRequestContext requestContext) throws Exception {
		NovaRequestContext novaContext = (NovaRequestContext) requestContext.getProperty("nova.context");
		Resource.processStack(requestContext, projectId, novaContext);
		return controller.show(flavorId, requestContext);
	}
}
