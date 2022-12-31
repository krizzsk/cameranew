package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class StaticStickerResponse implements NoProguard {
    private final StaticStickerJson data;
    private final String message;
    private final float serverTime;
    private final Integer status;

    public StaticStickerResponse(StaticStickerJson staticStickerJson, Integer num, String str, float f2) {
        this.data = staticStickerJson;
        this.status = num;
        this.message = str;
        this.serverTime = f2;
    }

    public static /* synthetic */ StaticStickerResponse copy$default(StaticStickerResponse staticStickerResponse, StaticStickerJson staticStickerJson, Integer num, String str, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            staticStickerJson = staticStickerResponse.data;
        }
        if ((i2 & 2) != 0) {
            num = staticStickerResponse.status;
        }
        if ((i2 & 4) != 0) {
            str = staticStickerResponse.message;
        }
        if ((i2 & 8) != 0) {
            f2 = staticStickerResponse.serverTime;
        }
        return staticStickerResponse.copy(staticStickerJson, num, str, f2);
    }

    public final StaticStickerJson component1() {
        return this.data;
    }

    public final Integer component2() {
        return this.status;
    }

    public final String component3() {
        return this.message;
    }

    public final float component4() {
        return this.serverTime;
    }

    public final StaticStickerResponse copy(StaticStickerJson staticStickerJson, Integer num, String str, float f2) {
        return new StaticStickerResponse(staticStickerJson, num, str, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticStickerResponse) {
            StaticStickerResponse staticStickerResponse = (StaticStickerResponse) obj;
            return s.c(this.data, staticStickerResponse.data) && s.c(this.status, staticStickerResponse.status) && s.c(this.message, staticStickerResponse.message) && s.c(Float.valueOf(this.serverTime), Float.valueOf(staticStickerResponse.serverTime));
        }
        return false;
    }

    public final StaticStickerJson getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final float getServerTime() {
        return this.serverTime;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        StaticStickerJson staticStickerJson = this.data;
        int hashCode = (staticStickerJson == null ? 0 : staticStickerJson.hashCode()) * 31;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.message;
        return ((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Float.floatToIntBits(this.serverTime);
    }

    public String toString() {
        return "StaticStickerResponse(data=" + this.data + ", status=" + this.status + ", message=" + ((Object) this.message) + ", serverTime=" + this.serverTime + ')';
    }
}
