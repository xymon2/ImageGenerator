package com.smokyearlgray.image

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ImageController {
    @GetMapping("/image")
    fun getImage(): String {
        return "Hello World!"
    }
}