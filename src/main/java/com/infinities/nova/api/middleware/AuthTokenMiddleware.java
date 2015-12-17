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
package com.infinities.nova.api.middleware;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;

import com.infinities.keystonemiddleware.AuthProtocol;

@Priority(1004)
public class AuthTokenMiddleware extends Middleware {

	private final AuthProtocol authProtocol;


	public AuthTokenMiddleware() throws MalformedURLException {
		authProtocol = new AuthProtocol();
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		authProtocol.call(requestContext);
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

	}

}
