package com.sysnormal.libs.db.entities.basic_entities.commons;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@Table(
        name = "resource_types",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "resource_types_u1",
                        columnNames = {
                                "(coalesce(parent_id, 0))","status_reg_id","data_origin_id","(coalesce(table_origin_id, 0))","(coalesce(id_at_origin, 0))",
                                "name"
                        }
                )
        }
)
public class ResourceType extends BaseBasicEntity<ResourceType> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_data", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_data in (0,1)")
    private byte isData = 0;

    @Column(name = "is_interface", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_interface in (0,1)")
    private byte isInterface = 0;

    @Column(name = "is_server", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_server in (0,1)")
    private byte isServer = 0;

    @Column(name = "notes")
    private String notes;

    protected static final long TABLE_ID = 201;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long DATA_ID = 1;
    public static final long INTERFACE_ID = 2;
    public static final long SERVER_ID = 3;

    public static  final ResourceType DATA = new ResourceType(){{
        setId(DATA_ID);
        setIsSysRec((byte) 1);
        setName("DATA");
        setIsData((byte) 1);
    }};
    public static  final ResourceType INTERFACE = new ResourceType(){{
        setId(INTERFACE_ID);
        setIsSysRec((byte) 1);
        setName("INTERFACE");
        setIsInterface((byte) 1);
    }};
    public static  final ResourceType SERVER = new ResourceType(){{
        setId(SERVER_ID);
        setIsSysRec((byte) 1);
        setName("SERVER");
        setIsServer((byte) 1);
    }};

}