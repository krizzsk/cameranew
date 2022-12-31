package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: PayInfo.kt */
/* loaded from: classes6.dex */
public final class PayInfo implements NoProguard {
    private final Integer pay_way;
    private final String pid;
    private final String price;

    public PayInfo(Integer num, String str, String str2) {
        this.pay_way = num;
        this.price = str;
        this.pid = str2;
    }

    public static /* synthetic */ PayInfo copy$default(PayInfo payInfo, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = payInfo.pay_way;
        }
        if ((i2 & 2) != 0) {
            str = payInfo.price;
        }
        if ((i2 & 4) != 0) {
            str2 = payInfo.pid;
        }
        return payInfo.copy(num, str, str2);
    }

    public final Integer component1() {
        return this.pay_way;
    }

    public final String component2() {
        return this.price;
    }

    public final String component3() {
        return this.pid;
    }

    public final PayInfo copy(Integer num, String str, String str2) {
        return new PayInfo(num, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayInfo) {
            PayInfo payInfo = (PayInfo) obj;
            return s.c(this.pay_way, payInfo.pay_way) && s.c(this.price, payInfo.price) && s.c(this.pid, payInfo.pid);
        }
        return false;
    }

    public final Integer getPay_way() {
        return this.pay_way;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String getPrice() {
        return this.price;
    }

    public int hashCode() {
        Integer num = this.pay_way;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.price;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pid;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PayInfo(pay_way=" + this.pay_way + ", price=" + ((Object) this.price) + ", pid=" + ((Object) this.pid) + ')';
    }
}
