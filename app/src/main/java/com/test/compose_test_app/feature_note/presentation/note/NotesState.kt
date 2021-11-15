package com.test.compose_test_app.feature_note.presentation.note

import com.test.compose_test_app.feature_note.domain.model.Note
import com.test.compose_test_app.feature_note.domain.util.NoteOrder
import com.test.compose_test_app.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
