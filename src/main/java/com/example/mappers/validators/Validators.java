package com.example.mappers.validators;

import com.example.role.Role;
import com.example.team.Team;
import org.bson.types.ObjectId;

public class Validators {
    public static boolean validName(String name) {
        return name == null || name.isEmpty();
    }
    public static ObjectId validId(String id) {
        ObjectId objectId;
        if(id == null || id.isEmpty()) {
            objectId = new ObjectId();
        } else {
            try {
                objectId = new ObjectId(id);
            } catch (IllegalArgumentException e) {
                objectId = new ObjectId();
            }
        }
        return objectId;
    }
    public static Role validRole(String role) {
        Role validRole;
        try{
            validRole = Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            validRole = Role.EMPTY;
        }
        return validRole;
    }

}
