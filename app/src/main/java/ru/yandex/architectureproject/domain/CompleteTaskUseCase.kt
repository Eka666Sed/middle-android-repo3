package ru.yandex.architectureproject.domain

import kotlinx.coroutines.delay
import ru.yandex.architectureproject.data.repository.TaskRepository

private const val TASK_DELETION_DELAY_MILLIS = 10_000L

class CompleteTaskUseCase(
    private val repository: TaskRepository,
) {
    suspend operator fun invoke(taskId: Int) {
        repository.completeTask(taskId)
        // TODO: Здесь будет автоудаление задачи
        delay(TASK_DELETION_DELAY_MILLIS)
        repository.deleteTask(taskId)
    }
}
