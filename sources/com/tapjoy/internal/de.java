package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import java.util.Collections;
/* loaded from: classes3.dex */
public final class de {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    private static de f7363f = new de();
    public Context a;
    public BroadcastReceiver b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7364d;

    /* renamed from: e  reason: collision with root package name */
    public a f7365e;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    private de() {
    }

    public static de a() {
        return f7363f;
    }

    static /* synthetic */ void a(de deVar, boolean z) {
        if (deVar.f7364d != z) {
            deVar.f7364d = z;
            if (deVar.c) {
                deVar.c();
                a aVar = deVar.f7365e;
                if (aVar != null) {
                    aVar.a(deVar.b());
                }
            }
        }
    }

    public final boolean b() {
        return !this.f7364d;
    }

    public final void c() {
        boolean z = !this.f7364d;
        for (cz czVar : Collections.unmodifiableCollection(dd.a().a)) {
            ds dsVar = czVar.c;
            if (dsVar.a.get() != 0) {
                dg.a().a(dsVar.c(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }
}
