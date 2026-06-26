package io.github.helpermethod.tskmgr.task

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class TaskService(private val taskRepository: TaskRepository) {
    @Transactional
    fun create(task: Task) =
        taskRepository
            .save(task.toEntity())
            .toDomain()

    fun list() =
        taskRepository
            .findByOrderByIdDesc()
            .map { it.toDomain() }

    @Transactional
    fun update(id: Long, task: Task) {
        val existingTask = taskRepository.findByIdOrNull(id) ?: throw TaskNotFoundException("Task not found")

        with(existingTask) {
            summary = task.summary
            description = task.description
            status = task.status
        }
    }
}