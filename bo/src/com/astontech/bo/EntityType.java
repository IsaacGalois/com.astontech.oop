package com.astontech.bo;

public class EntityType extends BaseBO {

    //region FIELDS
    private int EntityTypeId;
    private int EntityId;
    private String EntityTypeName;
    //endregion

    //region CONSTRUCTORS
    public EntityType() {}
    public EntityType(String EntityTypeName) {
        this.EntityTypeName = EntityTypeName;
    }
    //endregion

    //region GETTERS AND SETTERS
    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) { EntityId = entityId; }

    public String getEntityTypeName() { return EntityTypeName; }

    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }
    //endregion
}
