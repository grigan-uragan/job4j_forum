package ru.grigan.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.grigan.job4j.forum.model.User;
import ru.grigan.job4j.forum.service.UserService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
class RegControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;

    @Test
    public void shouldReturnRegView() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    @Test
    public void whenAddNewUserThenReturnNewUserName() throws Exception {
        this.mockMvc.perform(post("/reg")
                .param("username", "newUser")
                .param("password", "1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(service).saveUser(captor.capture());
        assertThat(captor.getValue().getUsername(), is("newUser"));
    }

}