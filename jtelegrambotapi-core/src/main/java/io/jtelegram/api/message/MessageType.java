package io.jtelegram.api.message;

import io.jtelegram.api.events.message.*;
import io.jtelegram.api.message.impl.*;
import lombok.Getter;

public enum MessageType {
    TEXT(TextMessage.class, TextMessageEvent.class),
    AUDIO(AudioMessage.class, AudioMessageEvent.class),
    DOCUMENT(DocumentMessage.class, DocumentMessageEvent.class),
    GAME(GameMessage.class, GameMessageEvent.class),
    PHOTO(PhotoMessage.class, PhotoMessageEvent.class),
    STICKER(StickerMessage.class, StickerMessageEvent.class),
    VIDEO(VideoMessage.class, VideoMessageEvent.class),
    VOICE(VoiceMessage.class, VoiceMessageEvent.class),
    VIDEO_NOTE(VideoNoteMessage.class, VideoNoteMessageEvent.class),
    CONTACT(ContactMessage.class, ContactMessageEvent.class),
    LOCATION(LocationMessage.class, LocationMessageEvent.class),
    VENUE(VenueMessage.class, VenueMessageEvent.class),
    INVOICE(InvoiceMessage.class, InvoiceMessageEvent.class)
    ;

    @Getter
    private Class<? extends Message> messageClass;
    @Getter
    private Class<? extends MessageEvent> receiveEventClass;

    MessageType(Class<? extends Message> messageClass, Class<? extends MessageEvent> receiveEventClass) {
        this.messageClass = messageClass;
        this.receiveEventClass = receiveEventClass;
    }

    public static MessageType typeFrom(Class<? extends Message> clazz) {
        for (MessageType type : values()) {
            if (type.getMessageClass().isAssignableFrom(clazz)) {
                return type;
            }
        }

        return null;
    }

    public static <T extends Message> MessageType typeFrom(T message) {
        return typeFrom(message.getClass());
    }
}
