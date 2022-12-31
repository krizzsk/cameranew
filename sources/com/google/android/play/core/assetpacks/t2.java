package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t2 {
    private static final com.google.android.play.core.internal.j c = new com.google.android.play.core.internal.j("PackageStateCache");
    private final Context a;
    private int b = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t2(Context context) {
        this.a = context;
    }

    public final synchronized int a() {
        if (this.b == -1) {
            try {
                this.b = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                c.e("The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.b;
    }
}
