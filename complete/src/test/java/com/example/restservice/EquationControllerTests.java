/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EquationControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test1() throws Exception {

		this.mockMvc.perform(get("/equation").
						param("a", "1").
						param("b", "-12").
						param("c", "-28")

				)
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.root1").value("14.0"))
				.andExpect(jsonPath("$.root2").value("-2.0"));

		this.mockMvc.perform(get("/equation").
								param("a", "1").
								param("b", "6").
								param("c", "0")
						)
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.root1").value("0.0"))
				.andExpect(jsonPath("$.root2").value("-6.0"));

		this.mockMvc.perform(get("/equation").
						param("a", "2").
						param("b", "-14").
						param("c", "24")
				)
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.root1").value("4.0"))
				.andExpect(jsonPath("$.root2").value("3.0"));

		this.mockMvc.perform(get("/equation").
						param("a", "1").
						param("b", "3").
						param("c", "-10")
				)
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.root1").value("2.0"))
				.andExpect(jsonPath("$.root2").value("-5.0"));
	}
}
