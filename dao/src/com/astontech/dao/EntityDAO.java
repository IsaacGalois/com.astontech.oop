package com.astontech.dao;

import com.astontech.bo.Entity;
import java.util.List;

public interface EntityDAO {

    //notes: GET methods
    public Entity getEntityById(int entityId);
    public List<Entity> getEntityList();

    //notes: EXECUTE methods
    public int insertEntity(Entity entity);
    public boolean updateEntity(Entity entity);
    public boolean deleteEntity(int entityId);

}
