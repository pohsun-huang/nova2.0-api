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

public class WrapCheckReducer extends AbstractReducer {

	private final static List<List<String>> reducers = Lists.newArrayList();
	static {
		List<String> reducer1 = Lists.newArrayList();
		reducer1.add("(");
		reducer1.add("check");
		reducer1.add(")");
		reducers.add(reducer1);

		List<String> reducer2 = Lists.newArrayList();
		reducer2.add("(");
		reducer2.add("and_expr");
		reducer2.add(")");
		reducers.add(reducer2);

		List<String> reducer3 = Lists.newArrayList();
		reducer3.add("(");
		reducer3.add("or_expr");
		reducer3.add(")");
		reducers.add(reducer3);
	}


	public WrapCheckReducer(BaseReducer reducer) {
		super(reducer);
	}

	@Override
	public List<List<String>> getReducers() {
		return reducers;
	}

	@Override
	protected Entry<String, BaseCheck> getEntry(List<Entry<String, BaseCheck>> entrys) {
		return Maps.immutableEntry("check", entrys.get(1).getValue());
	}

}
