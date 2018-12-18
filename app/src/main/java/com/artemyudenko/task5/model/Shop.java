package com.artemyudenko.task5.model;

import lombok.Data;

@Data
public class Shop {
    private String name;
    private String branch;
    private String description;
    //maybe location
    private boolean isIn;
}
