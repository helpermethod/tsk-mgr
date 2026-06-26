package io.github.helpermethod.tskmgr.task

import io.github.helpermethod.tskmgr.task.Task.Status
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant

@Table(name = "task")
@Entity
class TaskEntity(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long? = null,
    var summary: String,
    var description: String,
    @Enumerated(EnumType.STRING)
    var status: Status,
)

fun TaskEntity.toDomain() = Task(id = id, summary = summary, description = description, status = status)