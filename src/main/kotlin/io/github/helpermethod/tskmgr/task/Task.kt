package io.github.helpermethod.tskmgr.task

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY

data class Task(
    @JsonProperty(access = READ_ONLY)
    val id: Long? = null,
    val summary: String,
    val description: String,
    val status: Status,
) {
    enum class Status {
        OPEN,
        IN_PROGRESS,
        COMPLETED,
    }
}

fun Task.toEntity() = TaskEntity(summary = summary, description = description, status = status)