package com.example.team;

import com.example.assignment.Assignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "teams")
public class Team {
    private ObjectId id;
    private String name;
    @DBRef(lazy = true)
    private List<Assignment> assignments;

    public Team(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }

}
