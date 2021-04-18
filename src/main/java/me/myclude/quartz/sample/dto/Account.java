package me.myclude.quartz.sample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString(of = {"id", "name", "email"})
public class Account {

    private Long id;
    private String name;
    private String email;

}
