package com.sysnormal.libs.db.entities.basic_entities.systems.systemSide;

import com.sysnormal.libs.db.entities.basic_entities.BaseBasicEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(
        name = "system_sides",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "system_sides_u1",
                        columnNames = {
                                "(coalesce(parent_id, -1))","status_reg_id","data_origin_id","(coalesce(table_origin_id, -1))","(coalesce(id_at_origin, -1))",
                                "name"
                        }
                )
        }
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SystemSide extends BaseBasicEntity<SystemSide> {

    @Column(name = "name", nullable = false, length = 127)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_server", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_server in (0,1)")
    private byte isServer = 0;

    @Column(name = "is_client", nullable = false)
    @ColumnDefault("0")
    @Check(constraints = "is_client in (0,1)")
    private byte isClient = 0;

    @Column(name = "notes")
    private String notes;

    protected static final long TABLE_ID = 202;
    public static long getTableId() {
        return TABLE_ID;
    }

    public static final long WITHOUT_SIDE_ID = 0;
    public static final long SERVER_SIDE_ID = 1;
    public static final long CLIENT_SIDE_ID = 2;

    public static final SystemSide SERVER_SIDE = new SystemSide(){{
        setId(SERVER_SIDE_ID);
        setIsSysRec((byte) 1);
        setName("SERVER SIDE");
        setIsServer((byte) 1);
    }};

    public static final SystemSide CLIENT_SIDE = new SystemSide(){{
        setId(CLIENT_SIDE_ID);
        setIsSysRec((byte) 1);
        setName("CLIENT SIDE");
        setIsClient((byte) 1);
    }};

    public static final SystemSide WITHOUT_SIDE = new SystemSide(){{
        setId(WITHOUT_SIDE_ID);
        setIsSysRec((byte) 1);
        setName("WITHOUT SIDE");
    }};
    

}
