package org.pehlivanmert.springsecurityjwtexample.dto;

import lombok.Builder;
import org.pehlivanmert.springsecurityjwtexample.model.Role;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}
