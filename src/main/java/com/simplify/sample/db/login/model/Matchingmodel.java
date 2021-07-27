package com.simplify.sample.db.login.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
@Data
public class Matchingmodel {
    private String sender;
    private String receiver;
    private String message;
    private Date registerdate;
 }
