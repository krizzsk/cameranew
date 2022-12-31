package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class ShopCategory implements NoProguard {
    private final String cid;
    private final String name;
    private final Long off_time;
    private final Long onsale_time;
    private final String[] pids;

    public ShopCategory(String str, String str2, String[] strArr, Long l2, Long l3) {
        this.cid = str;
        this.name = str2;
        this.pids = strArr;
        this.onsale_time = l2;
        this.off_time = l3;
    }

    public static /* synthetic */ ShopCategory copy$default(ShopCategory shopCategory, String str, String str2, String[] strArr, Long l2, Long l3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = shopCategory.cid;
        }
        if ((i2 & 2) != 0) {
            str2 = shopCategory.name;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            strArr = shopCategory.pids;
        }
        String[] strArr2 = strArr;
        if ((i2 & 8) != 0) {
            l2 = shopCategory.onsale_time;
        }
        Long l4 = l2;
        if ((i2 & 16) != 0) {
            l3 = shopCategory.off_time;
        }
        return shopCategory.copy(str, str3, strArr2, l4, l3);
    }

    public final String component1() {
        return this.cid;
    }

    public final String component2() {
        return this.name;
    }

    public final String[] component3() {
        return this.pids;
    }

    public final Long component4() {
        return this.onsale_time;
    }

    public final Long component5() {
        return this.off_time;
    }

    public final ShopCategory copy(String str, String str2, String[] strArr, Long l2, Long l3) {
        return new ShopCategory(str, str2, strArr, l2, l3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(ShopCategory.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.ShopCategory");
            ShopCategory shopCategory = (ShopCategory) obj;
            if (s.c(this.cid, shopCategory.cid) && s.c(this.name, shopCategory.name)) {
                String[] strArr = this.pids;
                if (strArr != null) {
                    String[] strArr2 = shopCategory.pids;
                    if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                        return false;
                    }
                } else if (shopCategory.pids != null) {
                    return false;
                }
                return s.c(this.onsale_time, shopCategory.onsale_time) && s.c(this.off_time, shopCategory.off_time);
            }
            return false;
        }
        return false;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getOff_time() {
        return this.off_time;
    }

    public final Long getOnsale_time() {
        return this.onsale_time;
    }

    public final String[] getPids() {
        return this.pids;
    }

    public int hashCode() {
        String str = this.cid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String[] strArr = this.pids;
        int hashCode3 = (hashCode2 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Long l2 = this.onsale_time;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.off_time;
        return hashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public final boolean isValid(long j2) {
        Long l2 = this.onsale_time;
        if (l2 == null) {
            return false;
        }
        long longValue = l2.longValue();
        Long l3 = this.off_time;
        if (l3 == null) {
            return false;
        }
        long longValue2 = l3.longValue();
        if (j2 != 0 && longValue > 0 && longValue2 > 0) {
            long j3 = 1000;
            if (j2 < longValue * j3 || j2 > longValue2 * j3) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "ShopCategory(cid=" + ((Object) this.cid) + ", name=" + ((Object) this.name) + ", pids=" + Arrays.toString(this.pids) + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ')';
    }
}
