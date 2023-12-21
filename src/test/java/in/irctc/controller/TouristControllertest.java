package in.irctc.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ch.qos.logback.core.net.ObjectWriter;
import in.irctc.model.Tourist;
import in.irctc.service.TouristService;

@WebMvcTest(TouristController.class)
public class TouristControllertest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private TouristService service;
	
	Tourist touristOne;
	Tourist touristTwo;
	List<Tourist>touristList=new ArrayList<>();
	@BeforeEach
	void setUp()
	{
		touristOne=new Tourist(1,"abc","nan","vel","30 min",80);
		touristTwo=new Tourist(2,"abc2","nan2","vel2","30 min2",90);
		touristList.add(touristOne);
		touristList.add(touristTwo);
	}
	@Test
	void touristRegistrationTest() throws Exception
	{
		ObjectMapper object= new ObjectMapper();
		object.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		com.fasterxml.jackson.databind.ObjectWriter ow=object.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(touristOne);
		when(service.registerTourist(touristOne)).thenReturn(touristOne);
		this.mockMvc.perform(post("/tourist/register")
		.contentType(MediaType.APPLICATION_JSON).
		content(requestJson)).
		andDo(print()).andExpect(status().isOk());
	}
	@Test
	void fetchByIdTest() throws Exception
	{
		when(service.findById(1)).thenReturn(touristOne);
		this.mockMvc.perform(get("/tourist/get/1")).andDo(print()).andExpect(status().isOk());
	}
	@Test
	void fetchTouristTest() throws Exception
	{
		when(service.fetchingTouristbyId()).thenReturn((ArrayList<Tourist>) touristList);
		this.mockMvc.perform(get("/tourist/gettourist")).andDo(print()).andExpect(status().isOk());
	}
	@Test
	void deletetouristTest() throws Exception
	{
		when(service.deleteTourist(1)).thenReturn(touristOne);
		this.mockMvc.perform(delete("/tourist/delete/1")).andDo(print()).andExpect(status().isOk());
	}
}
