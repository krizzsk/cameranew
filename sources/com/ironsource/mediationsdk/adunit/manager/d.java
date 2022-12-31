package com.ironsource.mediationsdk.adunit.manager;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.j;
import com.ironsource.mediationsdk.model.l;
import java.util.List;
import java.util.Set;
/* compiled from: InterstitialAdManager.java */
/* loaded from: classes2.dex */
public class d extends BaseAdUnitManager<com.ironsource.mediationsdk.adunit.smash.b> {
    public d(List<l> list, j jVar, String str, String str2, int i2, Set<com.ironsource.mediationsdk.l0.c> set) {
        super(new a(IronSource.AD_UNIT.INTERSTITIAL, str, str2, list, jVar.h(), jVar.e(), jVar.g(), jVar.f(), i2), set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.adunit.manager.BaseAdUnitManager
    /* renamed from: Q */
    public com.ironsource.mediationsdk.adunit.smash.b p(l lVar, com.ironsource.mediationsdk.j0.a.c.d<?> dVar, int i2) {
        return new com.ironsource.mediationsdk.adunit.smash.b(new com.ironsource.mediationsdk.adunit.smash.a(IronSource.AD_UNIT.INTERSTITIAL, this.p.c(), this.p.j(), i2, this.f5513i, this.f5510f, this.f5511g, this.f5512h, lVar, this.p.i()), dVar, this);
    }
}
