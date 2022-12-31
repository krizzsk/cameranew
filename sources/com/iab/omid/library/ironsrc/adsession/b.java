package com.iab.omid.library.ironsrc.adsession;

import android.view.View;
/* loaded from: classes2.dex */
public abstract class b {
    public static b a(c cVar, d dVar) {
        d.d.a.a.a.g.e.a();
        d.d.a.a.a.g.e.c(cVar, "AdSessionConfiguration is null");
        d.d.a.a.a.g.e.c(dVar, "AdSessionContext is null");
        return new g(cVar, dVar);
    }

    public abstract void b();

    public abstract void c(View view);

    public abstract void d();
}
