package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class zaj extends Drawable.ConstantState {
    int mChangingConfigurations;
    int zaoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaj(zaj zajVar) {
        if (zajVar != null) {
            this.mChangingConfigurations = zajVar.mChangingConfigurations;
            this.zaoc = zajVar.zaoc;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zaf(this);
    }
}
