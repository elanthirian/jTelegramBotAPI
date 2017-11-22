package io.jtelegram.api.message.types.updatable.edit;

import io.jtelegram.api.chat.id.ChatId;
import io.jtelegram.api.ex.TelegramException;
import io.jtelegram.api.message.types.updatable.helpers.UpdatableChatRequest;
import lombok.Builder;
import lombok.Getter;

import java.util.function.Consumer;

@Getter
public class DeleteMessage extends UpdatableChatRequest {
    private Integer messageId;

    @Builder
    public DeleteMessage(Consumer<TelegramException> errorHandler, Runnable callback, ChatId chatId, int messageId) {
        super("deleteMessage", errorHandler, callback, chatId);
        this.messageId = messageId;
    }

    @Override
    protected boolean isValid() {
        return super.isValid() && messageId != null;
    }
}
