package com.websocket.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user", schema = "ssafy")
public class User implements Serializable {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uid;

    @JsonIgnore
    private String password;
    private String email;
    private String name;
    private String nickname;
    private String role;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createDate;

}
