package us.pinguo.repository2020.database.staticsticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ShopDetail.kt */
/* loaded from: classes6.dex */
public final class ShopDetailResponse implements NoProguard {
    private final ShopDetail data;
    private final String message;
    private final Float serverTime;
    private final Integer status;

    public ShopDetailResponse(ShopDetail shopDetail, Integer num, String str, Float f2) {
        this.data = shopDetail;
        this.status = num;
        this.message = str;
        this.serverTime = f2;
    }

    public static /* synthetic */ ShopDetailResponse copy$default(ShopDetailResponse shopDetailResponse, ShopDetail shopDetail, Integer num, String str, Float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            shopDetail = shopDetailResponse.data;
        }
        if ((i2 & 2) != 0) {
            num = shopDetailResponse.status;
        }
        if ((i2 & 4) != 0) {
            str = shopDetailResponse.message;
        }
        if ((i2 & 8) != 0) {
            f2 = shopDetailResponse.serverTime;
        }
        return shopDetailResponse.copy(shopDetail, num, str, f2);
    }

    public final ShopDetail component1() {
        return this.data;
    }

    public final Integer component2() {
        return this.status;
    }

    public final String component3() {
        return this.message;
    }

    public final Float component4() {
        return this.serverTime;
    }

    public final ShopDetailResponse copy(ShopDetail shopDetail, Integer num, String str, Float f2) {
        return new ShopDetailResponse(shopDetail, num, str, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopDetailResponse) {
            ShopDetailResponse shopDetailResponse = (ShopDetailResponse) obj;
            return s.c(this.data, shopDetailResponse.data) && s.c(this.status, shopDetailResponse.status) && s.c(this.message, shopDetailResponse.message) && s.c(this.serverTime, shopDetailResponse.serverTime);
        }
        return false;
    }

    public final ShopDetail getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Float getServerTime() {
        return this.serverTime;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        ShopDetail shopDetail = this.data;
        int hashCode = (shopDetail == null ? 0 : shopDetail.hashCode()) * 31;
        Integer num = this.status;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.message;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Float f2 = this.serverTime;
        return hashCode3 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return "ShopDetailResponse(data=" + this.data + ", status=" + this.status + ", message=" + ((Object) this.message) + ", serverTime=" + this.serverTime + ')';
    }
}
