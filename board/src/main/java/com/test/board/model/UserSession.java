package com.test.board.model;

import lombok.Data;
import org.springframework.web.context.annotation.SessionScope;

@Data
@SessionScope
public class UserSession {
    private String userId;
    private String userNm;
    private String role;
    private String deptNo;
}
