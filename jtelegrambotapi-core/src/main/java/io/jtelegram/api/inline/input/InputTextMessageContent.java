package io.jtelegram.api.inline.input;

import io.jtelegram.api.requests.message.framework.ParseMode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class InputTextMessageContent extends InputMessageContent {
    private String messageText;
    private ParseMode parseMode;
    private Boolean disableWebPagePreview;
}
