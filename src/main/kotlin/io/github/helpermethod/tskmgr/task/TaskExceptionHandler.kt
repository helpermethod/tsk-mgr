package io.github.helpermethod.tskmgr.task

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice("io.github.helpermethod.tskmgr.task")
class TaskExceptionHandler {
    @ExceptionHandler(TaskNotFoundException::class)
    fun handleNotFoundException(e: RuntimeException) =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.message)
}