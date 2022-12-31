package com.pinguo.camera360.vip;

import java.io.Serializable;
import us.pinguo.foundation.utils.y;
/* loaded from: classes3.dex */
public class SubscriptionInfo implements Serializable, Cloneable {
    public static final int STATUS_CHINA_VIP = 5;
    public static final int STATUS_FREE_USE = 2;
    public static final int STATUS_LEGAL_VIP = 3;
    public static final int STATUS_NOT_VIP = 0;
    public static final int STATUS_POOR_VIP = 4;
    public static final int STATUS_VIP_EXPIRED = 1;
    public long expireMillis;
    public int vipStatus = 0;
    public long subscriptionTimeMillis = 0;
    public int failCount = 0;
    public String subscriptionPrice = null;

    public static SubscriptionInfo makeCopy(SubscriptionInfo subscriptionInfo) {
        try {
            return (SubscriptionInfo) subscriptionInfo.clone();
        } catch (CloneNotSupportedException unused) {
            return new SubscriptionInfo();
        }
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscriptionInfo) {
            SubscriptionInfo subscriptionInfo = (SubscriptionInfo) obj;
            return this.vipStatus == subscriptionInfo.vipStatus && this.subscriptionTimeMillis == subscriptionInfo.subscriptionTimeMillis && this.failCount == subscriptionInfo.failCount && this.expireMillis == subscriptionInfo.expireMillis && y.a(this.subscriptionPrice, subscriptionInfo.subscriptionPrice);
        }
        return false;
    }

    public int hashCode() {
        return y.b(Integer.valueOf(this.vipStatus), Long.valueOf(this.subscriptionTimeMillis), Integer.valueOf(this.failCount), this.subscriptionPrice, Long.valueOf(this.expireMillis));
    }
}
