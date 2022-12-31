package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes3.dex */
public enum cw {
    NATIVE(TapjoyConstants.TJC_PLUGIN_NATIVE),
    JAVASCRIPT("javascript"),
    NONE(PortalFollowFeeds.TYPE_NONE);
    

    /* renamed from: d  reason: collision with root package name */
    private final String f7352d;

    cw(String str) {
        this.f7352d = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f7352d;
    }
}
