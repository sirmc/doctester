/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import controllers.utils.NinjaTest;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class ApplicationControllerTest extends NinjaTest {
    
    @Before
    public void setup() {

        makeRequest(Request.GET().url(testServerUrl().path("setup")));
        
    }


	@Test
	public void testThatHeadRequestIsSent() {

		// /redirect will send a location: redirect in the headers
		Response result = makeRequest(Request.HEAD().url(testServerUrl().path("/")));

		assertThat(result.headers, CoreMatchers.notNullValue());
		assertThat(result.payload, CoreMatchers.nullValue());

		assertThat(result.httpStatus, CoreMatchers.equalTo(404)); //ninja server not yet supporting HEAD

	}

}
