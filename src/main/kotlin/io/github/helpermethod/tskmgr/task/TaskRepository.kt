package io.github.helpermethod.tskmgr.task

import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<TaskEntity, Long> {
    fun findByOrderByIdDesc(): List<TaskEntity>
}