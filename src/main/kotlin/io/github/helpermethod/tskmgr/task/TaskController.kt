package io.github.helpermethod.tskmgr.task

import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/tasks")
@RestController
class TaskController(private val taskService: TaskService) {
    @PostMapping
    fun create(@RequestBody task: Task) =
        taskService.create(task)

    @GetMapping
    fun list() =
        taskService.list()

    @ResponseStatus(NO_CONTENT)
    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody task: Task) {
        taskService.update(id, task)
    }
}