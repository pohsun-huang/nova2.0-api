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

import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

public abstract class Middleware implements ContainerRequestFilter, ContainerResponseFilter {

//	protected Response processRequest(Request request) {
//		return null;
//	}
//
//	protected Response processResponse(Response response) {
//		return response;
//	}
//
//	public Response process(Request request) {
//		Response response = processRequest(request);
//		if (response != null) {
//			return response;
//		}
//
//		return processResponse(response);
//	}

}
