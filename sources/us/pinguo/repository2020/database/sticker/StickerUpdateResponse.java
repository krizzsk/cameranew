package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class StickerUpdateResponse implements NoProguard {
    private final StickerUpdateData[] data;
    private final String message;
    private final int status;

    public StickerUpdateResponse(StickerUpdateData[] data, int i2, String message) {
        s.h(data, "data");
        s.h(message, "message");
        this.data = data;
        this.status = i2;
        this.message = message;
    }

    public static /* synthetic */ StickerUpdateResponse copy$default(StickerUpdateResponse stickerUpdateResponse, StickerUpdateData[] stickerUpdateDataArr, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            stickerUpdateDataArr = stickerUpdateResponse.data;
        }
        if ((i3 & 2) != 0) {
            i2 = stickerUpdateResponse.status;
        }
        if ((i3 & 4) != 0) {
            str = stickerUpdateResponse.message;
        }
        return stickerUpdateResponse.copy(stickerUpdateDataArr, i2, str);
    }

    public final StickerUpdateData[] component1() {
        return this.data;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.message;
    }

    public final StickerUpdateResponse copy(StickerUpdateData[] data, int i2, String message) {
        s.h(data, "data");
        s.h(message, "message");
        return new StickerUpdateResponse(data, i2, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerUpdateResponse.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerUpdateResponse");
            StickerUpdateResponse stickerUpdateResponse = (StickerUpdateResponse) obj;
            return Arrays.equals(this.data, stickerUpdateResponse.data) && this.status == stickerUpdateResponse.status && s.c(this.message, stickerUpdateResponse.message);
        }
        return false;
    }

    public final StickerUpdateData[] getData() {
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
        return "StickerUpdateResponse(data=" + Arrays.toString(this.data) + ", status=" + this.status + ", message=" + this.message + ')';
    }
}
