package com.ironsource.mediationsdk.l0;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.i;
import com.ironsource.mediationsdk.utils.j;
import java.util.List;
import kotlin.jvm.internal.s;
/* compiled from: ExternalImpressionDataHandler.kt */
/* loaded from: classes2.dex */
public final class a implements j {
    @Override // com.ironsource.mediationsdk.utils.j
    public void a(String str) {
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void k(List<IronSource.AD_UNIT> list, boolean z, i iVar) {
        if (iVar != null) {
            com.ironsource.mediationsdk.model.b applicationConfigurations = iVar.a();
            s.d(applicationConfigurations, "applicationConfigurations");
            applicationConfigurations.c().b();
            com.ironsource.mediationsdk.model.b applicationConfigurations2 = iVar.a();
            s.d(applicationConfigurations2, "applicationConfigurations");
            applicationConfigurations2.c().a();
        }
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void l() {
    }
}
