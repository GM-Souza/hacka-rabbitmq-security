package com.hackathon.application.dto;

import java.time.LocalDateTime;

public record ErrorResponse (String error, String detail, LocalDateTime time) {
}
