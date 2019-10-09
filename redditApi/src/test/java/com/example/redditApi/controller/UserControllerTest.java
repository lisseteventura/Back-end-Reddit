package com.example.redditApi.controller;


import com.example.redditApi.config.JwtUtil;
import com.example.redditApi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private JwtUtil jwtUtil;

    //mock test to mock login request
    @Test
    public void login_Returns200_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("drake","416"));
        //mocking a method without actually calling it
        when(userService.login(any())).thenReturn("123456");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
    //method convert username and password to a JSON format string
    private static String createUserInJson (String name, String password) {
        return "{ \"name\": \"" + name + "\", " +
                "\"password\":\"" + password + "\"}";
    }

    @Test
    public void signUp_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserSignUpInJson("drake", "416"));
        //if successful then it'll return hooray
        when(userService.createUser(any())).thenReturn("hooray");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"hooray\"}"))
                //method returns the response after the method executes and stores it in the MvcResult object
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private static String createUserSignUpInJson(String username, String password) {
        return "{ \"name\": \"" + username + "\", " +
                "\"password\":\"" + password + "\"}";
    }
}
