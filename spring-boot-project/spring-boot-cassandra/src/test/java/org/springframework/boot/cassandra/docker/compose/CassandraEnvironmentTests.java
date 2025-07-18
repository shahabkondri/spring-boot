/*
 * Copyright 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.cassandra.docker.compose;

import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link CassandraEnvironment}.
 *
 * @author Scott Frederick
 */
class CassandraEnvironmentTests {

	@Test
	void getDatacenterWhenDatacenterIsNotSet() {
		CassandraEnvironment environment = new CassandraEnvironment(Collections.emptyMap());
		assertThat(environment.getDatacenter()).isEqualTo("datacenter1");
	}

	@Test
	void getDatacenterWhenDcIsSet() {
		CassandraEnvironment environment = new CassandraEnvironment(Map.of("CASSANDRA_DC", "testdc1"));
		assertThat(environment.getDatacenter()).isEqualTo("testdc1");
	}

	@Test
	void getDatacenterWhenDatacenterIsSet() {
		CassandraEnvironment environment = new CassandraEnvironment(Map.of("CASSANDRA_DATACENTER", "testdc1"));
		assertThat(environment.getDatacenter()).isEqualTo("testdc1");
	}

}
