package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ShopResponse.kt */
/* loaded from: classes6.dex */
public final class ShopResponse implements NoProguard {
    private final ShopData data;
    private final String message;
    private final Integer status;

    public ShopResponse(Integer num, String str, ShopData shopData) {
        this.status = num;
        this.message = str;
        this.data = shopData;
    }

    public static /* synthetic */ ShopResponse copy$default(ShopResponse shopResponse, Integer num, String str, ShopData shopData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = shopResponse.status;
        }
        if ((i2 & 2) != 0) {
            str = shopResponse.message;
        }
        if ((i2 & 4) != 0) {
            shopData = shopResponse.data;
        }
        return shopResponse.copy(num, str, shopData);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final ShopData component3() {
        return this.data;
    }

    public final ShopResponse copy(Integer num, String str, ShopData shopData) {
        return new ShopResponse(num, str, shopData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShopResponse) {
            ShopResponse shopResponse = (ShopResponse) obj;
            return s.c(this.status, shopResponse.status) && s.c(this.message, shopResponse.message) && s.c(this.data, shopResponse.data);
        }
        return false;
    }

    public final ShopData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public int hashCode() {
        Integer num = this.status;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ShopData shopData = this.data;
        return hashCode2 + (shopData != null ? shopData.hashCode() : 0);
    }

    public String toString() {
        return "ShopResponse(status=" + this.status + ", message=" + ((Object) this.message) + ", data=" + this.data + ')';
    }
}
