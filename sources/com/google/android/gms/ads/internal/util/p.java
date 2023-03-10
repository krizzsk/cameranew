package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class p implements Callable<String> {
    private final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(zzbu zzbuVar, Context context) {
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", "");
        if (!TextUtils.isEmpty(string)) {
            zzd.zzeb("User agent is already initialized on Google Play Services.");
            return string;
        }
        zzd.zzeb("User agent is not initialized on Google Play Services. Initializing.");
        com.google.android.gms.common.util.r.a(this.a, sharedPreferences.edit().putString("user_agent", WebSettings.getDefaultUserAgent(this.a)), "admob_user_agent");
        throw null;
    }
}
