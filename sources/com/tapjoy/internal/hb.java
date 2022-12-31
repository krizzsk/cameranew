package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyReceiver;
import com.tapjoy.internal.ji;
import javax.annotation.Nullable;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes3.dex */
public final class hb extends p {
    private static hb c;

    private hb(Context context) {
        super(context, new r() { // from class: com.tapjoy.internal.hb.1
            @Override // com.tapjoy.internal.r
            public final String a(Context context2) {
                return hj.a(context2).b.getString("gcm.senderIds", "");
            }

            @Override // com.tapjoy.internal.r
            public final String b(Context context2) {
                return hj.a(context2).b.getString("gcm.regId", "");
            }

            @Override // com.tapjoy.internal.r
            public final boolean c(Context context2) {
                return hj.a(context2).b.getBoolean("gcm.stale", true);
            }

            @Override // com.tapjoy.internal.r
            public final int d(Context context2) {
                return hj.a(context2).b.getInt("gcm.appVersion", Integer.MIN_VALUE);
            }

            @Override // com.tapjoy.internal.r
            public final boolean e(Context context2) {
                return hj.a(context2).b.getBoolean("gcm.onServer", false);
            }

            @Override // com.tapjoy.internal.r
            public final long f(Context context2) {
                return hj.a(context2).b.getLong("gcm.onServerExpirationTime", 0L);
            }

            @Override // com.tapjoy.internal.r
            public final int g(Context context2) {
                return hj.a(context2).b.getInt("gcm.backoff", 0);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context2, String str) {
                n.a(hj.a(context2).b, "gcm.senderIds", str);
            }

            @Override // com.tapjoy.internal.r
            public final void b(Context context2, String str) {
                n.a(hj.a(context2).b, "gcm.regId", str);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context2, boolean z) {
                n.a(hj.a(context2).b, "gcm.stale", z);
            }

            @Override // com.tapjoy.internal.r
            public final void b(Context context2, boolean z) {
                hj.a(context2).a(z);
            }

            @Override // com.tapjoy.internal.r
            public final void b(Context context2, int i2) {
                n.a(hj.a(context2).b, "gcm.backoff", i2);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context2, int i2) {
                n.a(hj.a(context2).b, "gcm.appVersion", i2);
            }

            @Override // com.tapjoy.internal.r
            public final void a(Context context2, long j2) {
                SharedPreferences.Editor edit = hj.a(context2).b.edit();
                edit.putLong("gcm.onServerExpirationTime", j2);
                edit.apply();
            }
        });
    }

    public static synchronized hb b(Context context) {
        hb hbVar;
        synchronized (hb.class) {
            if (c == null) {
                c = new hb(context);
            }
            hbVar = c;
        }
        return hbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final void a(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final void a(Context context, String str) {
        gz.a(context).a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final boolean c(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final boolean d(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        super.a(this.a);
        super.a(new String[]{str}[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final boolean a(Context context, Intent intent) {
        intent.getExtras();
        String stringExtra = intent.getStringExtra("fiverocks");
        if (stringExtra != null) {
            if (hc.a(context).f()) {
                gz.a(context).b(stringExtra);
                return true;
            }
            String stringExtra2 = intent.getStringExtra("title");
            String stringExtra3 = intent.getStringExtra("message");
            if (stringExtra3 != null) {
                Bundle extras = intent.getExtras();
                Object obj = extras.get("rich");
                Object obj2 = extras.get("sound");
                String string = extras.getString("payload");
                Object obj3 = extras.get("always");
                boolean z = "true".equals(obj3) || Boolean.TRUE.equals(obj3);
                Object obj4 = extras.get("repeatable");
                boolean z2 = "true".equals(obj4) || Boolean.TRUE.equals(obj4);
                String string2 = extras.getString("placement");
                int b = b(extras.get("nid"));
                String string3 = extras.getString("channel_id");
                if (z || !gz.a(context).d()) {
                    Notification a = a(context, stringExtra, jq.a(stringExtra2), stringExtra3, a(obj), a(obj2), string, string2, b, string3);
                    if (gz.a(context).a(context, stringExtra, z2)) {
                        a(context, b, a);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.q
    public final void b(String str) {
        a();
    }

    public static int b(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return 0;
    }

    public static boolean a(Object obj) {
        return Boolean.TRUE.equals(obj) || "true".equals(obj);
    }

    public static void a(Context context, int i2, Notification notification) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.notify(i2, notification);
        VdsAgent.onNotify(notificationManager, i2, notification);
    }

    private static int a(Bundle bundle, String str, Context context) {
        if (bundle != null) {
            Object obj = bundle.get(str);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                try {
                    if ("drawable".equals(context.getResources().getResourceTypeName(intValue))) {
                        return intValue;
                    }
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (obj != null) {
                Object[] objArr = {str};
                if (gw.a) {
                    x.a(4, "Tapjoy", "meta-data of {} invalid", objArr);
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.text.Spanned] */
    @Nullable
    public static Notification a(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, int i2, String str6) {
        Bundle bundle;
        Intent intent = new Intent(context.getApplicationContext(), TapjoyReceiver.class);
        intent.setAction("com.tapjoy.PUSH_CLICK");
        intent.putExtra("com.tapjoy.PUSH_ID", str);
        if (str4 != null) {
            intent.putExtra(Tapjoy.INTENT_EXTRA_PUSH_PAYLOAD, str4);
        }
        if (str5 != null) {
            intent.putExtra("com.tapjoy.PUSH_PLACEMENT", str5);
        }
        int i3 = Build.VERSION.SDK_INT;
        int i4 = i3 == 19 ? PGImageSDK.SDK_STATUS_CREATE : 134217728;
        Context applicationContext = context.getApplicationContext();
        VdsAgent.onPendingIntentGetBroadcastBefore(applicationContext, i2, intent, i4);
        PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, i2, intent, i4);
        VdsAgent.onPendingIntentGetBroadcastAfter(applicationContext, i2, intent, i4, broadcast);
        String str7 = null;
        if (broadcast == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            int length = str2.length();
            Spanned spanned = str2;
            if (length == 0) {
                spanned = packageManager.getApplicationLabel(applicationInfo);
            } else if (z) {
                spanned = Html.fromHtml(str2);
            }
            if (z) {
                str3 = Html.fromHtml(str3);
            }
            int a = a(applicationInfo.metaData, "com.tapjoy.notification.icon", context);
            if (a == 0 && (a = applicationInfo.icon) == 0) {
                a = 17301651;
            }
            int a2 = a(applicationInfo.metaData, "com.tapjoy.notification.icon.large", context);
            Bitmap decodeResource = a2 != 0 ? BitmapFactory.decodeResource(context.getResources(), a2) : null;
            if (str6 == null && (bundle = applicationInfo.metaData) != null) {
                str6 = bundle.getString("com.tapjoy.notification.default_channel_id", "tapjoy");
            }
            if (i3 >= 26) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (str6 == null || notificationManager.getNotificationChannel(str6) == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("tapjoy", "Tapjoy", 3));
                    str7 = "tapjoy";
                } else {
                    str7 = str6;
                }
            }
            ji.c a3 = new ji.c(context, str7).a(a).c(spanned).a(spanned).b(str3).a(broadcast).a().c().a(new ji.b().a(spanned).b(str3));
            if (z2) {
                a3.b();
            }
            if (decodeResource != null) {
                a3.a(decodeResource);
            }
            return a3.d();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
