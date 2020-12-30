package com.factory.car;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.MessageFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.factory.car.constants.Constants;

@SpringBootTest
@AutoConfigureMockMvc
class HttpRequestTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final String CAR_REQUEST_URL = "http://localhost:{0}/car?input={1}";

	@LocalServerPort
	private String port;
	
	@Test
	public void returnTypeMustBeCabrio() throws Exception {
		this.mockMvc.perform(get(MessageFormat.format(CAR_REQUEST_URL,port,Constants.CABRIO))).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(Constants.CABRIO)));
	}
	@Test
	public void returnTypeMustBeSedan() throws Exception {
		this.mockMvc.perform(get(MessageFormat.format(CAR_REQUEST_URL,port,Constants.SEDAN))).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(Constants.SEDAN)));
	}
	@Test
	public void returnTypeMustBeHatchBack() throws Exception {
		this.mockMvc.perform(get(MessageFormat.format(CAR_REQUEST_URL,port,Constants.HATCHBACK))).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(Constants.HATCHBACK)));
	}
	
}
