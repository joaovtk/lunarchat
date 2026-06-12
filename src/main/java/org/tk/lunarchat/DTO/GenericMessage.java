package org.tk.lunarchat.DTO;

import org.springframework.http.HttpStatus;

public record GenericMessage(String message, HttpStatus status) {
}