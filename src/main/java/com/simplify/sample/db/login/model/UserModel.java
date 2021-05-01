package com.simplify.sample.db.login.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class UserModel {
    private String id;
    private String password;

    private String gachonId;
    private String gachonPass;

}
