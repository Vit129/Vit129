package com.example.android.architecture.blueprints.todoapp.statistics

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_empty_returnsZero() {
        // Create an active task
        /*val tasks = listOf<Task>(
            Task("", "", isCompleted = false)
        )*/
        // Call your function
        val result = getActiveAndCompletedStats(emptyList())

        // Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsZeroHundred() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = true)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        // Create an active task
        /*val tasks = listOf<Task>(
            Task("", "", isCompleted = false)
        )*/
        // Call your function
        val result = getActiveAndCompletedStats(null)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStat_both_returnFortySixty() {
        // Create an active task
        val tasks = listOf<Task>(
            Task("title1", "desc", isCompleted = true),
            Task("title2", "desc", isCompleted = true),
            Task("title3", "desc", isCompleted = true),
            Task("title4", "desc", isCompleted = false),
            Task("title5", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(40f))
        assertThat(result.completedTasksPercent, `is`(60f))
    }
}