package com.gong.faker.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conf {

    private List<Property> schema;
    private Long count;
    private Integer threadNum;
    private String topic;

}
