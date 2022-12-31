package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.j0;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class GoogleApiAvailabilityLight {
    public static final int a = c.a;
    private static final GoogleApiAvailabilityLight b = new GoogleApiAvailabilityLight();

    public static GoogleApiAvailabilityLight getInstance() {
        return b;
    }

    private static String j(@Nullable Context context, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append(PGTransHeader.CONNECTOR);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(PGTransHeader.CONNECTOR);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(PGTransHeader.CONNECTOR);
        if (context != null) {
            try {
                sb.append(com.google.android.gms.common.wrappers.b.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    public int a(Context context) {
        return c.b(context);
    }

    @Nullable
    public Intent b(@Nullable Context context, int i2, @Nullable String str) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return j0.b("com.google.android.gms");
        } else if (context != null && com.google.android.gms.common.util.i.f(context)) {
            return j0.a();
        } else {
            return j0.c("com.google.android.gms", j(context, str));
        }
    }

    @Nullable
    public PendingIntent c(Context context, int i2, int i3) {
        return d(context, i2, i3, null);
    }

    @Nullable
    public PendingIntent d(Context context, int i2, int i3, @Nullable String str) {
        Intent b2 = b(context, i2, str);
        if (b2 == null) {
            return null;
        }
        VdsAgent.onPendingIntentGetActivityShortBefore(context, i3, b2, 134217728);
        PendingIntent activity = PendingIntent.getActivity(context, i3, b2, 134217728);
        VdsAgent.onPendingIntentGetActivityShortAfter(context, i3, b2, 134217728, activity);
        return activity;
    }

    @NonNull
    public String e(int i2) {
        return c.c(i2);
    }

    public int f(Context context) {
        return g(context, a);
    }

    public int g(Context context, int i2) {
        int g2 = c.g(context, i2);
        if (c.h(context, g2)) {
            return 18;
        }
        return g2;
    }

    public boolean h(int i2) {
        return c.j(i2);
    }

    public void i(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        c.a(context, i2);
    }
}
