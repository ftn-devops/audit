package ftn.devops.audit.Entity;

import lombok.Data;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("logs")
public class Log {

    @PrimaryKey
    private String component_id;
    @Column
    private LocalDateTime time_of_log;
    @Column
    private String log_text;
}
