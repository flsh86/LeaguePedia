package com.example.repository;

import com.example.assignment.Assignment;

import com.example.team.Team;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findAllByTeam_id(ObjectId id);
}
