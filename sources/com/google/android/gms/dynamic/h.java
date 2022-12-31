package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class h implements a.InterfaceC0139a {
    private final /* synthetic */ FrameLayout a;
    private final /* synthetic */ LayoutInflater b;
    private final /* synthetic */ ViewGroup c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f3700d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ a f3701e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3701e = aVar;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.c = viewGroup;
        this.f3700d = bundle;
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final void a(c cVar) {
        c cVar2;
        this.a.removeAllViews();
        FrameLayout frameLayout = this.a;
        cVar2 = this.f3701e.a;
        frameLayout.addView(cVar2.f(this.b, this.c, this.f3700d));
    }

    @Override // com.google.android.gms.dynamic.a.InterfaceC0139a
    public final int getState() {
        return 2;
    }
}
