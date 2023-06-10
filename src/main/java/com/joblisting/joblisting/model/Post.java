package com.joblisting.joblisting.model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "JobPost")
public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String[] techs;

    public Post() {

    }

    public Post(String profile, String desc, int exp, String[] techs) {
        this.profile = profile;
        this.desc = desc;
        this.exp = exp;
        this.techs = techs;
    }
}
