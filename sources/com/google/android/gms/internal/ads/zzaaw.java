package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.wrappers.b;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaaw {
    private final Context context;

    public zzaaw(Context context) {
        q.k(context, "Context can not be null");
        this.context = context;
    }

    private final boolean zza(Intent intent) {
        q.k(intent, "Intent can not be null");
        return !this.context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean zzrx() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzry() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public final boolean zzrz() {
        return ((Boolean) com.google.android.gms.ads.internal.util.zzbr.zza(this.context, new zzaaz())).booleanValue() && b.a(this.context).a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean zzsa() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
