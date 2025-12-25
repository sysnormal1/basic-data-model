package com.sysnormal.libs.db.entities.basic_entities;

import com.sysnormal.libs.db.entities.base_entities.BaseCommonEntityWithParent;
import com.sysnormal.libs.db.entities.basic_entities.agents.Agent;
import com.sysnormal.libs.db.entities.basic_entities.commons.DataOrigin;
import com.sysnormal.libs.db.entities.basic_entities.commons.RecordStatus;
import com.sysnormal.libs.db.entities.basic_entities.database.Tables;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseBasicEntity<T extends BaseBasicEntity<T>>  extends BaseCommonEntityWithParent<T> {

    @Column(name = "status_reg_id", nullable = false)
    @ColumnDefault(RecordStatus.ACTIVE_ID+"")
    private Long statusRegId = RecordStatus.ACTIVE_ID;

    @Column(name = "creator_agent_id", nullable = false)
    @ColumnDefault(Agent.SYSTEM_ID+"")
    private Long creatorAgentId = Agent.SYSTEM_ID;

    @Column(name = "updater_agent_id")
    private Long updaterAgentId;

    @Column(name = "data_origin_id", nullable = false)
    @ColumnDefault(DataOrigin.DEFAULT_ORIGINDATA_ID+"")
    private Long dataOriginId = DataOrigin.DEFAULT_ORIGINDATA_ID;

    @Column(name = "table_origin_id")
    private Long tableOriginId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_reg_id", insertable = false, updatable = false)
    private RecordStatus statusReg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_agent_id", insertable = false, updatable = false)
    private Agent creatorAgent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updater_agent_id", insertable = false, updatable = false)
    private Agent updaterAgent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_origin_id", insertable = false, updatable = false)
    private DataOrigin dataOrigin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_origin_id", insertable = false, updatable = false)
    private Tables tableOrigin;

}
