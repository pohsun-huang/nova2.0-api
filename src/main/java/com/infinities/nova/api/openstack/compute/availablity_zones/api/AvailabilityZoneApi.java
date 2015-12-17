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
package com.infinities.nova.api.openstack.compute.availablity_zones.api;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.infinities.nova.api.NovaRequestContext;

public interface AvailabilityZoneApi {

	// getOnlyAvailable=false, withHosts=false
	public Entry<Map<String, Set<String>>, Map<String, Set<String>>> getAvailabilityZones(NovaRequestContext context, boolean getOnlyAvailable, boolean withHosts);

}
