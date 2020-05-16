package com.example.mappers;

import com.example.champion.Champion;
import com.example.champion.ChampionDTO;
import org.bson.types.ObjectId;

public class ChampionMapper {
    public static Champion toEntity(ChampionDTO dto) {
        return new Champion(
                ObjectId.get(),
                dto.getName()
        );
    }

    public static ChampionDTO toDTO(Champion entity) {
        return new ChampionDTO(
                entity.get_id().toString(),
                entity.getName()
        );
    }

}
