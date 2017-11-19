package io.jtelegram.api.message.sendable.types;

import io.jtelegram.api.chat.Chat;
import io.jtelegram.api.ex.TelegramException;
import io.jtelegram.api.message.impl.DocumentMessage;
import io.jtelegram.api.message.sendable.InputFile;
import io.jtelegram.api.message.sendable.ReplyMarkup;
import io.jtelegram.api.message.sendable.SendableMessageRequest;
import io.jtelegram.api.message.sendable.SendableMessageType;
import io.jtelegram.api.message.sendable.chatid.ChatID;
import io.jtelegram.api.message.sendable.chatid.LongChatID;
import lombok.Builder;

import java.util.function.Consumer;

public class SendDocument extends SendableMessageRequest<DocumentMessage> {
    private final InputFile document;
    private final String caption;

    @Builder
    protected SendDocument(Consumer<DocumentMessage> callback, Consumer<TelegramException> errorHandler, ChatID chatID, Integer replyToMessageID, Boolean disableNotification, ReplyMarkup replyMarkup, InputFile document, String caption) {
        super("sendDocument", DocumentMessage.class, callback, errorHandler, chatID, replyToMessageID, disableNotification, replyMarkup);
        this.document = document;
        this.caption = caption;
    }

    @Override
    public SendableMessageType getType() {
        return SendableMessageType.DOCUMENT;
    }

    @Override
    protected boolean isValid() {
        return super.isValid() && document != null;
    }

    public static class SendDocumentBuilder {
        public SendDocument.SendDocumentBuilder chatID(Chat chat) {
            this.chatID = new LongChatID(chat.getId());
            return this;
        }

        public SendDocument.SendDocumentBuilder chatID(ChatID chatID) {
            this.chatID = chatID;
            return this;
        }
    }
}
