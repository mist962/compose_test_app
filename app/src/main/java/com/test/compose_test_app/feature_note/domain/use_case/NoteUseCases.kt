package com.test.compose_test_app.feature_note.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val getNote: GetNoteUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddNoteUseCase
)
