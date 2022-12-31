package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class q implements Callable<String> {
    private final /* synthetic */ Context a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(zzbu zzbuVar, Context context, Context context2) {
        this.a = context;
        this.b = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.a != null) {
            zzd.zzeb("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.a.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzd.zzeb("Attempting to read user agent from local cache.");
            sharedPreferences = this.b.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzd.zzeb("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.b);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzd.zzeb("Persisting user agent.");
            }
        }
        return string;
    }
}
