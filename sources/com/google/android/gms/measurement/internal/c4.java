package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class c4 extends b3 {
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c4(o4 o4Var) {
        super(o4Var);
        this.a.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        if (!g()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void i() {
        if (!this.b) {
            if (k()) {
                return;
            }
            this.a.n();
            this.b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void j() {
        if (!this.b) {
            l();
            this.a.n();
            this.b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean k();

    protected void l() {
    }
}
