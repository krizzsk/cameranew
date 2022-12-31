package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class a {
    private static final a a = new o0(1, null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(String str, String str2) {
        return new o0(0, str, str2);
    }

    @Nullable
    public abstract String c();

    public abstract int d();

    @Nullable
    public abstract String e();
}
