package com.astontech.dao.mysql;

import com.astontech.bo.EntityType;
import com.astontech.dao.EntityTypeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityTypeDAOImpl extends MySQL implements EntityTypeDAO {
    @Override
    public EntityType getEntityTypeById(int entityTypeId) {
        Connect();
        EntityType EntityType = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetEntityType(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, entityTypeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                EntityType = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return EntityType;
    }

    @Override
    public List<EntityType> getEntityTypeList() {
        Connect();
        List<EntityType> EntityTypeList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetEntityType(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                EntityTypeList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return EntityTypeList;
    }

    @Override
    public int insertEntityType(EntityType entityType) {
        return 0;
    }

    @Override
    public boolean updateEntityType(EntityType entityType) {
        return false;
    }

    @Override
    public boolean deleteEntityType(int entityTypeId) {
        return false;
    }

    private static EntityType HydrateObject(ResultSet rs) throws SQLException {
        /*  private int EntityTypeId;
            private int EntityId;
            private String EntityTypeName;
        */

        //notes:    HYDRATING AN OBJECT
        EntityType EntityType = new EntityType();
        EntityType.setEntityTypeId(rs.getInt(1));
        EntityType.setEntityId(rs.getInt(2));
        EntityType.setEntityTypeName(rs.getString(3));

        return EntityType;
    }
}
