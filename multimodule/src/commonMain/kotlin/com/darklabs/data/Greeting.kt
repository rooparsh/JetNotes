package com.darklabs.data

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}