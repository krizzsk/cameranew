package com.ironsource.mediationsdk.j0.a.c;

import android.app.Activity;
import com.ironsource.mediationsdk.AdapterRepository;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.j0.a.c.a;
import com.ironsource.mediationsdk.model.l;
/* compiled from: BaseAdAdapter.java */
/* loaded from: classes2.dex */
public abstract class d<NetworkAdapter extends a> {
    private final IronSource.AD_UNIT a;
    private final l b;

    public d(IronSource.AD_UNIT ad_unit, l lVar) {
        this.a = ad_unit;
        this.b = lVar;
    }

    public NetworkAdapter m() {
        NetworkAdapter networkadapter = (NetworkAdapter) AdapterRepository.getInstance().j(this.b, this.a);
        if (networkadapter != null) {
            return networkadapter;
        }
        return null;
    }

    public abstract boolean n(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar);

    public abstract void o(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar, Activity activity, com.ironsource.mediationsdk.j0.a.d.a aVar2);

    public abstract void q(com.ironsource.mediationsdk.adunit.adapter.utility.a aVar, com.ironsource.mediationsdk.j0.a.d.a aVar2);
}
