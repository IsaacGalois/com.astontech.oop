package com.astontech.dao;

import com.astontech.bo.EntityType;
import java.util.List;

public interface EntityTypeDAO {

    //notes: GET methods
    public EntityType getEntityTypeById(int entityTypeId);
    public List<EntityType> getEntityTypeList();

    //notes: EXECUTE methods
    public int insertEntityType(EntityType entityType);
    public boolean updateEntityType(EntityType entityType);
    public boolean deleteEntityType(int entityTypeId);
    
}
