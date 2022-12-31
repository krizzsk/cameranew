package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Sticker.kt */
/* loaded from: classes6.dex */
public final class StickerResponseData implements NoProguard {
    private final StickerJson data;
    private final String message;
    private final int status;

    public StickerResponseData(StickerJson data, int i2, String message) {
        s.h(data, "data");
        s.h(message, "message");
        this.data = data;
        this.status = i2;
        this.message = message;
    }

    public static /* synthetic */ StickerResponseData copy$default(StickerResponseData stickerResponseData, StickerJson stickerJson, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            stickerJson = stickerResponseData.data;
        }
        if ((i3 & 2) != 0) {
            i2 = stickerResponseData.status;
        }
        if ((i3 & 4) != 0) {
            str = stickerResponseData.message;
        }
        return stickerResponseData.copy(stickerJson, i2, str);
    }

    public final StickerJson component1() {
        return this.data;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.message;
    }

    public final StickerResponseData copy(StickerJson data, int i2, String message) {
        s.h(data, "data");
        s.h(message, "message");
        return new StickerResponseData(data, i2, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerResponseData) {
            StickerResponseData stickerResponseData = (StickerResponseData) obj;
            return s.c(this.data, stickerResponseData.data) && this.status == stickerResponseData.status && s.c(this.message, stickerResponseData.message);
        }
        return false;
    }

    public final StickerJson getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + this.status) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "StickerResponseData(data=" + this.data + ", status=" + this.status + ", message=" + this.message + ')';
    }
}
