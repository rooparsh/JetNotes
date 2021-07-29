package com.darklabs.multimoduledata

class Greeting {
    fun greeting(): String {
        return "Hello, ${com.darklabs.multimoduledata.Platform().platform}!"
    }
}