package com.test.compose_test_app.di

import android.content.Context
import androidx.room.Room
import com.test.compose_test_app.feature_note.data.data_source.NoteDao
import com.test.compose_test_app.feature_note.data.data_source.NoteDatabase
import com.test.compose_test_app.feature_note.data.repository.NoteRepositoryImpl
import com.test.compose_test_app.feature_note.domain.repository.NoteRepository
import com.test.compose_test_app.feature_note.domain.use_case.AddNoteUseCase
import com.test.compose_test_app.feature_note.domain.use_case.DeleteNoteUseCase
import com.test.compose_test_app.feature_note.domain.use_case.GetNoteUseCase
import com.test.compose_test_app.feature_note.domain.use_case.GetNotesUseCase
import com.test.compose_test_app.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        NoteDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository = NoteRepositoryImpl(database.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository) = NoteUseCases(
        getNotes = GetNotesUseCase(repository),
        getNote = GetNoteUseCase(repository),
        deleteNote = DeleteNoteUseCase(repository),
        addNote = AddNoteUseCase(repository)
    )
}