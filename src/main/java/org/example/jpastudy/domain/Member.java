package org.example.jpastudy.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "members")
@Getter @Setter
@NoArgsConstructor
@ToString(of = {"id", "username", "age"})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String username;
    private Integer age;

    @Lob
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Member(String username, Integer age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        // 기존 팀에서 나를 제거하는 코드가 있어야 하지만 생략했습니다!!
        team.getMembers().add(this); // jpa 의 특징, 즉 양방향 연관관계에 의거해서 서로 연결해줘야 합니다!!
    }

    public Team enrollTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
        return team;
    }

    public void changeBasicLevel() {
        // 여기 한 줄 만 수정하면 됩니다!!
    }

    public void changeAdminLevel() {

    }

    public boolean validationForUser() {
        return true;
    }

    public boolean validationForAdmin() {
        return false;
    }


    static enum Role {
        ADMIN, USER
    }
}
