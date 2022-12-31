package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndeterminateAnimatorDelegate.java */
/* loaded from: classes2.dex */
public abstract class h<T extends Animator> {
    protected i a;
    protected final float[] b;
    protected final int[] c;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(int i2) {
        this.b = new float[i2 * 2];
        this.c = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i2, int i3, int i4) {
        return (i2 - i3) / i4;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull i iVar) {
        this.a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
