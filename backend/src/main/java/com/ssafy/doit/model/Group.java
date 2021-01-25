package com.ssafy.doit.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "`group`")
public class Group{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupPk;

    private String name;
    private int maxNum;
    private String content;
    private Long leader;
    private LocalDate startDate;
    private LocalDate endDate;
    private int score;
    private int totalNum;

    @OneToMany(cascade = CascadeType.ALL)
    public List<GroupHashTag> tagList; // 태그리스트

    @Builder
    public Group(String name, String content, int maxNum,
                 LocalDate startDate, LocalDate endDate, Long leader){
        this.name = name;
        this.content = content;
        this.totalNum = 1;
        this.maxNum = maxNum;
        this.score = 0;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leader = leader;
    }

//    public boolean hasTag(String tag) {
//        for (GroupHashTag ght : tagList) {
//            if (ght.getHashTag().getName().equals(tag)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
