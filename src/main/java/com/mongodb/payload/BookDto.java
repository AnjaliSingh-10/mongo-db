package com.mongodb.payload;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class BookDto {
    @Id
    private String id;
    private String name;
    private String course;
    private String category;
}

