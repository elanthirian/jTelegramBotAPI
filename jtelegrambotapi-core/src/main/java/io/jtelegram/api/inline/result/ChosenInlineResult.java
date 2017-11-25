package io.jtelegram.api.inline.result;

import io.jtelegram.api.message.media.Location;
import io.jtelegram.api.user.User;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode(of = "resultId")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChosenInlineResult {
    private String resultId;
    private User from;
    private String query;
    private Location location;
    private String inlineMessageId;
}
