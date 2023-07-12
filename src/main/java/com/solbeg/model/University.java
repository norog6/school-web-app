package com.solbeg.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
@Builder
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "university",cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.ALL})
    private List<Student> students=new ArrayList<>();
    public void addStudent(Student student){
        students.add(student);
        student.setUniversity(this);

    }
}
