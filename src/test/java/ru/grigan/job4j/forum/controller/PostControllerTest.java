package ru.grigan.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@WithUserDetails("admin")
@Sql(value = {"/create_user_before.sql", "/create_post_before.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create_post_after.sql", "/create_user_after.sql"},
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnEditViewAndEditPostTitle() throws Exception {
        this.mockMvc.perform(get("/addPost"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(xpath("//title").string("Edit post"));
    }

    @Test
    public void whenUpdatePostThenReturnViewEditAndEditPostTitle() throws Exception {
        this.mockMvc.perform(get("/updatePost/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(xpath("//title").string("Edit post"));
    }

    @Test
    public void whenDeletePostThenRedirect() throws Exception {
        this.mockMvc.perform(get("/deletePost/1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void shouldReturnListTopicsWith2Element() throws Exception {
        this.mockMvc.perform(get("/topics"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("topicList"))
                .andExpect(xpath("//tr[@id='topic-el']").exists())
                .andExpect(xpath("//tr[@id='topic-el']").nodeCount(2));
    }

    @Test
    public void shouldReturnPostListWith3Element() throws Exception {
        this.mockMvc.perform(get("/getTopic/topic"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("posts"))
                .andExpect(xpath("//tr[@id='post-el']").exists())
                .andExpect(xpath("//tr[@id='post-el']").nodeCount(3));
    }



}