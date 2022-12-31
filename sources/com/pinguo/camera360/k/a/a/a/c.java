package com.pinguo.camera360.k.a.a.a;

import com.tapjoy.TJAdUnitConstants;
import us.pinguo.foundation.j;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: SwitchPreference.java */
/* loaded from: classes3.dex */
public class c extends a {
    public c(String str, String str2) {
        super(str, str2);
    }

    @Override // us.pinguo.foundation.h
    public String i() {
        String k2 = j.e().k(this.m, PortalFollowFeeds.TYPE_NONE);
        if (!k2.equals(PortalFollowFeeds.TYPE_NONE)) {
            return TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(k2) ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off";
        }
        String str = this.f11007e;
        return str != null ? str : this.f11008f[0];
    }

    public boolean p() {
        return i().equals(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
    }

    public void q(boolean z) {
        n(z ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off");
    }
}
