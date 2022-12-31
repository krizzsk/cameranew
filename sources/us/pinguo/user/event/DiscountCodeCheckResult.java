package us.pinguo.user.event;

import kotlin.jvm.internal.s;
/* compiled from: DiscountCodeCheckResult.kt */
/* loaded from: classes6.dex */
public final class DiscountCodeCheckResult extends us.pinguo.foundation.eventbus.a {
    private String c;

    public DiscountCodeCheckResult(String productId) {
        s.h(productId, "productId");
        this.c = productId;
    }

    public final String d() {
        return this.c;
    }
}
