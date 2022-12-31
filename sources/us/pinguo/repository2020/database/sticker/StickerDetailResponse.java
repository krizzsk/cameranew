package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class StickerDetailResponse implements NoProguard {
    private final StickerDetail[] data;
    private final String message;
    private final int status;

    public StickerDetailResponse(StickerDetail[] data, int i2, String message) {
        s.h(data, "data");
        s.h(message, "message");
        this.data = data;
        this.status = i2;
        this.message = message;
    }

    public static /* synthetic */ StickerDetailResponse copy$default(StickerDetailResponse stickerDetailResponse, StickerDetail[] stickerDetailArr, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            stickerDetailArr = stickerDetailResponse.data;
        }
        if ((i3 & 2) != 0) {
            i2 = stickerDetailResponse.status;
        }
        if ((i3 & 4) != 0) {
            str = stickerDetailResponse.message;
        }
        return stickerDetailResponse.copy(stickerDetailArr, i2, str);
    }

    public final StickerDetail[] component1() {
        return this.data;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.message;
    }

    public final StickerDetailResponse copy(StickerDetail[] data, int i2, String message) {
        s.h(data, "data");
        s.h(message, "message");
        return new StickerDetailResponse(data, i2, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerDetailResponse.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerDetailResponse");
            StickerDetailResponse stickerDetailResponse = (StickerDetailResponse) obj;
            return Arrays.equals(this.data, stickerDetailResponse.data) && this.status == stickerDetailResponse.status && s.c(this.message, stickerDetailResponse.message);
        }
        return false;
    }

    public final StickerDetail[] getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.data) * 31) + this.status) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "StickerDetailResponse(data=" + Arrays.toString(this.data) + ", status=" + this.status + ", message=" + this.message + ')';
    }
}
