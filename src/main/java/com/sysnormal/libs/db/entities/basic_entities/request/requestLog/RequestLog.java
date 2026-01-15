package com.sysnormal.libs.db.entities.basic_entities.request.requestLog;

import com.sysnormal.libs.db.entities.base_entities.BaseEntity;
import com.sysnormal.libs.db.entities.basic_entities.agents.agent.Agent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(
        name = "request_logs"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RequestLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "client_ip", length = 127)
    private String clientIp;

    @Column(name = "path", length = Integer.MAX_VALUE)
    private String path;

    @Column(name = "headers", length = Integer.MAX_VALUE)
    private String headers;

    @Column(name = "protocol", length = 10, nullable = false)
    private String protocol;

    @Column(name = "method", length = 10)
    private String method;

    @Column(name = "params", length = 16777215)
    private String params;

    @Column(name = "body", length = 16777215)
    private String body;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", insertable = false, updatable = false)
    private Agent agent;

    protected static final long TABLE_ID = 130;
    public static long getTableId() {
        return TABLE_ID;
    }

}
