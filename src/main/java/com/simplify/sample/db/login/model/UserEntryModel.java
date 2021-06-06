package com.simplify.sample.db.login.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class UserEntryModel {
    private String id;
    private String animalpicture;
    private String introduction;
    private String mbti;
    private int isActive = 1;

}
