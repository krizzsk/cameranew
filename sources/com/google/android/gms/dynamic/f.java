package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class f implements a.InterfaceC0139a {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;
    private final /* synthetic */ Bundle c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ a f3699d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f3699d = aVar;
        this.a = activity;
        this.b = bundle;
        this.c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final void a(c cVar) {
        c cVar2;
        cVar2 = this.f3699d.a;
        cVar2.e(this.a, this.b, this.c);
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final int getState() {
        return 0;
    }
}
