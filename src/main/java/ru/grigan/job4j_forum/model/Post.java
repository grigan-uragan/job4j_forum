package ru.grigan.job4j_forum.model;

import java.util.Calendar;

public class Post {
    private int id;
    private String name;
    private String description;
    private Calendar created;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Post of(String name, String description) {
        Post post = new Post();
        post.setName(name);
        post.setDescription(description);
        post.setCreated(Calendar.getInstance());
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        return id == post.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Post{" + "id="
                + id + ", name='"
                + name + '\'' + ", description='"
                + description + '\'' + ", created="
                + created + ", user="
                + user + '}';
    }
}
