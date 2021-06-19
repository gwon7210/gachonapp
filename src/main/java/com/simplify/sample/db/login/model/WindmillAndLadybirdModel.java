package com.simplify.sample.db.login.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class WindmillAndLadybirdModel {

    String id;
    int windmillCount;
    int ladybirdCount;

}
