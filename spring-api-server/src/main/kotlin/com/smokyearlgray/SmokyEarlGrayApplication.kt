package com.smokyearlgray

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class SmokyEarlGrayApplication {

    @Bean
    fun setDefaultTimeZone(): TimeZone {
        val timeZone = TimeZone.getTimeZone("UTC")
        TimeZone.setDefault(timeZone)
        return timeZone
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello World!")
            runApplication<SmokyEarlGrayApplication>(*args)
        }
    }
}
