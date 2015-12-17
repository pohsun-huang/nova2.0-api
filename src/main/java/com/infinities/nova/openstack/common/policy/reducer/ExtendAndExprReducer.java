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
package com.infinities.nova.openstack.common.policy.reducer;

import java.util.List;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.infinities.nova.openstack.common.policy.BaseCheck;
import com.infinities.nova.openstack.common.policy.BaseReducer;
import com.infinities.nova.openstack.common.policy.check.AndCheck;

public class ExtendAndExprReducer extends AbstractReducer {

	private final static List<List<String>> reducers = Lists.newArrayList();
	static {
		List<String> reducer1 = Lists.newArrayList();
		reducer1.add("and_expr");
		reducer1.add("and");
		reducer1.add("check");
		reducers.add(reducer1);
	}


	public ExtendAndExprReducer(BaseReducer reducer) {
		super(reducer);
	}

	@Override
	public List<List<String>> getReducers() {
		return reducers;
	}

	@Override
	public Entry<String, BaseCheck> getEntry(List<Entry<String, BaseCheck>> entrys) {
		((AndCheck) entrys.get(0).getValue()).addCheck(entrys.get(2).getValue());
		return Maps.immutableEntry("and_expr", entrys.get(0).getValue());
	}
}
