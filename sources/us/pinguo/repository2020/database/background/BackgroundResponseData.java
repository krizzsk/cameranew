package us.pinguo.repository2020.database.background;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDisplay.kt */
/* loaded from: classes6.dex */
public final class BackgroundResponseData implements NoProguard {
    private final BackgroundJson data;
    private final String message;
    private final float serverTime;
    private final int status;

    public BackgroundResponseData(float f2, String message, int i2, BackgroundJson data) {
        s.h(message, "message");
        s.h(data, "data");
        this.serverTime = f2;
        this.message = message;
        this.status = i2;
        this.data = data;
    }

    public static /* synthetic */ BackgroundResponseData copy$default(BackgroundResponseData backgroundResponseData, float f2, String str, int i2, BackgroundJson backgroundJson, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f2 = backgroundResponseData.serverTime;
        }
        if ((i3 & 2) != 0) {
            str = backgroundResponseData.message;
        }
        if ((i3 & 4) != 0) {
            i2 = backgroundResponseData.status;
        }
        if ((i3 & 8) != 0) {
            backgroundJson = backgroundResponseData.data;
        }
        return backgroundResponseData.copy(f2, str, i2, backgroundJson);
    }

    public final float component1() {
        return this.serverTime;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status;
    }

    public final BackgroundJson component4() {
        return this.data;
    }

    public final BackgroundResponseData copy(float f2, String message, int i2, BackgroundJson data) {
        s.h(message, "message");
        s.h(data, "data");
        return new BackgroundResponseData(f2, message, i2, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackgroundResponseData) {
            BackgroundResponseData backgroundResponseData = (BackgroundResponseData) obj;
            return s.c(Float.valueOf(this.serverTime), Float.valueOf(backgroundResponseData.serverTime)) && s.c(this.message, backgroundResponseData.message) && this.status == backgroundResponseData.status && s.c(this.data, backgroundResponseData.data);
        }
        return false;
    }

    public final BackgroundJson getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final float getServerTime() {
        return this.serverTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.serverTime) * 31) + this.message.hashCode()) * 31) + this.status) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "BackgroundResponseData(serverTime=" + this.serverTime + ", message=" + this.message + ", status=" + this.status + ", data=" + this.data + ')';
    }
}
