package com.darklabs.data.di.component

import com.darklabs.data.repository.JokeRepository
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface RepositoryComponent {

    @DefineComponent.Builder
    interface RepositoryComponentBuilder {
        fun seedJokeRepository(@BindsInstance jokeRepository: JokeRepository): RepositoryComponentBuilder
        fun build(): RepositoryComponent
    }

}
