package com.google.android.material.f;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;
/* compiled from: CancelableFontCallback.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a extends f {
    private final Typeface a;
    private final InterfaceC0171a b;
    private boolean c;

    /* compiled from: CancelableFontCallback.java */
    /* renamed from: com.google.android.material.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0171a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0171a interfaceC0171a, Typeface typeface) {
        this.a = typeface;
        this.b = interfaceC0171a;
    }

    private void d(Typeface typeface) {
        if (this.c) {
            return;
        }
        this.b.a(typeface);
    }

    @Override // com.google.android.material.f.f
    public void a(int i2) {
        d(this.a);
    }

    @Override // com.google.android.material.f.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.c = true;
    }
}
