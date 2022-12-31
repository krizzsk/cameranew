package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final class zzr {
    private final Context a;
    @GuardedBy("this")
    private int b;
    @GuardedBy("this")
    private int c = 0;

    public zzr(Context context) {
        this.a = context;
    }

    @Nullable
    private final PackageInfo b(String str) {
        try {
            return com.google.android.gms.common.wrappers.b.a(this.a).e(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("Metadata", sb.toString());
            return null;
        }
    }

    public final synchronized int a() {
        int i2 = this.c;
        if (i2 != 0) {
            return i2;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (com.google.android.gms.common.wrappers.b.a(this.a).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!com.google.android.gms.common.util.o.k()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.c = 2;
            return 2;
        }
        Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
        if (com.google.android.gms.common.util.o.k()) {
            this.c = 2;
        } else {
            this.c = 1;
        }
        return this.c;
    }

    public final synchronized int c() {
        PackageInfo b;
        if (this.b == 0 && (b = b("com.google.android.gms")) != null) {
            this.b = b.versionCode;
        }
        return this.b;
    }
}
