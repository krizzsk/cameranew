package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class z8 extends y8 {
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z8(i9 i9Var) {
        super(i9Var);
        this.b.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        if (!g()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void i() {
        if (!this.c) {
            j();
            this.b.t();
            this.c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean j();
}
