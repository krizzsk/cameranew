package com.facebook.drawee.a.b;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;
/* compiled from: ImageLoadingTimeControllerListener.java */
/* loaded from: classes.dex */
public class a extends com.facebook.drawee.controller.b {
    private long b = -1;
    private long c = -1;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private b f2450d;

    public a(@Nullable b bVar) {
        this.f2450d = bVar;
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void d(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = currentTimeMillis;
        b bVar = this.f2450d;
        if (bVar != null) {
            bVar.a(currentTimeMillis - this.b);
        }
    }

    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
    public void e(String str, Object obj) {
        this.b = System.currentTimeMillis();
    }
}
