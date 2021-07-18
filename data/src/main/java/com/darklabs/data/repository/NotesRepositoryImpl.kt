package com.darklabs.data.repository

import com.darklabs.data.di.module.CoroutineDispatcherProvider
import com.darklabs.data.remote.model.Note
import javax.inject.Inject

internal class NotesRepositoryImpl @Inject constructor(private val dispatcher: CoroutineDispatcherProvider) :
    NotesRepository {
    override suspend fun getNotes(): List<Note> {
        with(dispatcher.io()) {
            return listOf(
                Note(title = "First Note", content = "Hello, this is my first note"),
                Note(
                    title = "This is my dog",
                    imageUrl = "https://images.pexels.com/photos/1805164/pexels-photo-1805164.jpeg?cs=srgb&dl=pexels-valeria-boltneva-1805164.jpg&fm=jpg"
                ),
                Note(content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."),
                Note(
                    content = "In today's busy life schedule, sometimes we forget to remember even the basic things. Many people carry a small notepad with them and write down in it whatever they want to remember. But it isn't easy to manage the paper note. Thanks to Android OS and its note-taking apps, which make this task easy.\n" +
                            "\n" +
                            "These days you can use the skill and technique of digital note-taking. You mostly carry your Android smartphone everywhere where you go. Once you install a notepad app on your smartphone, you don't require carrying a notepad. You can write your moments of inspiration at a prime spot. To make your daily note using the Android note-taking app, you have to choose the right app according to your requirements. You can even store audio recordings or store images.\n" +
                            "\n" +
                            "There are several note apps available for Android at the Play Store. Some apps offer to make simple notes, whereas others allow you to create powerful lists and reports. Here, we have listed some best Android note-taking apps"
                ),
                Note(imageUrl = "https://media.istockphoto.com/photos/raptor-picture-id183029105?k=6&m=183029105&s=612x612&w=0&h=m0T1rXzKQBWprRewfqaS-j5Kg2tvUs2dI3r5P4hQ7IA=")
            )
        }
    }
}