package com.simplify.sample.db.login.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class QnAmodel {
    private String topic;
    private String answer;
    private String id;
 }
