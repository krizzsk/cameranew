package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class hg {
    long c;

    /* renamed from: d  reason: collision with root package name */
    boolean f7612d;

    /* renamed from: e  reason: collision with root package name */
    public gs f7613e;

    /* renamed from: f  reason: collision with root package name */
    public String f7614f;

    /* renamed from: g  reason: collision with root package name */
    fq f7615g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, @Nullable String str) {
        if (jq.c(str)) {
            return;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception unused) {
        }
    }

    public abstract void a(ha haVar, fw fwVar);

    public abstract void b();

    public boolean c() {
        return true;
    }
}
