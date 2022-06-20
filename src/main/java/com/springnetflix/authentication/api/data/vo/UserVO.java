package com.springnetflix.authentication.api.data.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserVO implements Serializable {

    private String userName;
    private String password;

}
