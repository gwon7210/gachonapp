package com.simplify.sample.db.login.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class QuestionEntryModel {
    private String topic;
    private String name;
    private String discription;
    private String content;

}
