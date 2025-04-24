package org.pehlivanmert.springsecurityjwtexample.dto;

public record AuthRequest (
        String username,
        String password
){
}