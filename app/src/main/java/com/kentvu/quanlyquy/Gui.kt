package com.kentvu.quanlyquy

import kotlinx.coroutines.channels.ReceiveChannel

interface Gui {
    val eventSource: ReceiveChannel<Event>
}

data class Event(val type: EventType, val data: String = "")

enum class EventType {
    EventTyped
}
