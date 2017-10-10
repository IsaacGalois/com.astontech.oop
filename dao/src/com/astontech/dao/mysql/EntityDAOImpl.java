package com.astontech.dao.mysql;

import com.astontech.bo.Entity;
import com.astontech.dao.EntityDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityDAOImpl extends MySQL implements EntityDAO {
    @Override
    public Entity getEntityById(int entityId) {
        Connect();
        Entity Entity = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetEntity(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, entityId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                Entity = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return Entity;
    }

    @Override
    public List<Entity> getEntityList() {
        Connect();
        List<Entity> EntityList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetEntity(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                EntityList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return EntityList;
    }

    @Override
    public int insertEntity(Entity entity) {
        return 0;
    }

    @Override
    public boolean updateEntity(Entity entity) {
        return false;
    }

    @Override
    public boolean deleteEntity(int entityId) {
        return false;
    }

    private static Entity HydrateObject(ResultSet rs) throws SQLException {
        /*  private int EntityId;
            private String EntityName;
        */

        //notes:    HYDRATING AN OBJECT
        Entity Entity = new Entity();
        Entity.setEntityId(rs.getInt(1));
        Entity.setEntityName(rs.getString(2));

        return Entity;
    }
}
