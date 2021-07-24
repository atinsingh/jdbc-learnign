package io.pragra.learning.jdbc_learning.domain;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;


@Builder()
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date createDate;
    private Date updateDate;
    private StudentStatus status;

}
