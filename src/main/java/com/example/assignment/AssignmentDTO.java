package com.example.assignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentDTO {
    private String _id;
    private String playerName;
    private String teamName;
    private String teamID;
    private LocalDate start;
    private LocalDate end;
}
