package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public abstract class AssetPackState {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static AssetPackState a(Bundle bundle, String str, f1 f1Var, h0 h0Var) {
        return b(str, h0Var.a(bundle.getInt(com.google.android.play.core.internal.p1.f("status", str)), str), bundle.getInt(com.google.android.play.core.internal.p1.f("error_code", str)), bundle.getLong(com.google.android.play.core.internal.p1.f("bytes_downloaded", str)), bundle.getLong(com.google.android.play.core.internal.p1.f("total_bytes_to_download", str)), f1Var.c(str));
    }

    public static AssetPackState b(@NonNull String str, int i2, int i3, long j2, long j3, double d2) {
        return new p0(str, i2, i3, j2, j3, (int) Math.rint(100.0d * d2));
    }

    public abstract long c();

    public abstract int d();

    public abstract String e();

    public abstract int f();

    public abstract long g();

    public abstract int h();
}
