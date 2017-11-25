package io.jtelegram.api.inline.result;

import com.google.gson.annotations.SerializedName;
import io.jtelegram.api.inline.input.InputMessageContent;
import io.jtelegram.api.inline.keyboard.InlineKeyboardMarkup;
import io.jtelegram.api.inline.result.framework.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InlineResultVoice extends InlineResult implements InlineResult.Urlable, InlineResult.Captioned,
        InlineResult.Titled, InlineResult.Duratable {
    private String title;
    private String caption;
    @SerializedName("voice_duration")
    private String duration;
    @SerializedName("voice_url")
    private String url;

    @Builder
    private InlineResultVoice(String id, InlineKeyboardMarkup replyMarkup, InputMessageContent inputMessageContent,
                              String title, String caption, String duration, String url) {
        super(id, replyMarkup, inputMessageContent);
        this.title = title;
        this.caption = caption;
        this.duration = duration;
        this.url = url;
    }
}
