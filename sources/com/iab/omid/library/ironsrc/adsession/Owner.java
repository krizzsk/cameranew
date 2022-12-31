package com.iab.omid.library.ironsrc.adsession;

import com.tapjoy.TapjoyConstants;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes2.dex */
public enum Owner {
    NATIVE(TapjoyConstants.TJC_PLUGIN_NATIVE),
    JAVASCRIPT("javascript"),
    NONE(PortalFollowFeeds.TYPE_NONE);
    
    private final String owner;

    Owner(String str) {
        this.owner = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.owner;
    }
}
