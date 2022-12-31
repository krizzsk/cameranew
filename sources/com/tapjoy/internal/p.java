package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.firebase.iid.GmsRpc;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.sql.Timestamp;
/* loaded from: classes3.dex */
public abstract class p extends q {
    public final Context a;
    public final r b;
    private boolean c = false;

    public p(Context context, r rVar) {
        this.a = context.getApplicationContext();
        this.b = rVar;
    }

    private boolean b() {
        boolean e2 = this.b.e(this.a);
        if (e2) {
            long f2 = this.b.f(this.a);
            if (f2 == 0 || System.currentTimeMillis() <= f2) {
                return e2;
            }
            new Timestamp(f2);
            return false;
        }
        return e2;
    }

    private static boolean c(Context context, String str) {
        Intent intent;
        try {
            z.b(context.getPackageManager(), "com.google.android.gsf");
            intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gsf");
            b(context, intent);
            intent.putExtra("sender", str);
        } catch (RuntimeException unused) {
        }
        return context.startService(intent) != null;
    }

    private void e(String str) {
        this.b.a(this.a, str);
        this.b.a(this.a, true);
        if ((this.c || !b(this.a, str)) && c(this.a, str)) {
        }
    }

    private synchronized void f(String str) {
        a(this.a);
        this.b.a(this.a, false);
        this.b.a(this.a, z.a(this.a));
        if (!str.equals(this.b.b(this.a))) {
            this.b.b(this.a, false);
            this.b.b(this.a, str);
            a(this.a, str);
        } else if (b()) {
        } else {
            a(this.a, str);
        }
    }

    public final boolean a() {
        String a = this.b.a(this.a);
        if (jq.c(a)) {
            return false;
        }
        a(a);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        String b = this.b.b(this.a);
        if (b.length() == 0) {
            e(str);
        } else if (!str.equals(this.b.a(this.a))) {
            e(str);
        } else {
            int d2 = this.b.d(this.a);
            int a = z.a(this.a);
            if (d2 != Integer.MIN_VALUE && d2 != a) {
                e(str);
            } else if (this.b.c(this.a)) {
                e(str);
            } else if (b()) {
            } else {
                a(this.a, b);
            }
        }
    }

    private static boolean b(Context context, String str) {
        try {
            if (z.b(context.getPackageManager(), "com.google.android.gms") >= 3159130) {
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                b(context, intent);
                intent.putExtra("sender", str);
                if (context.startService(intent) != null) {
                    return true;
                }
            }
        } catch (RuntimeException unused) {
        }
        return false;
    }

    private static void b(Context context, Intent intent) {
        Intent intent2 = new Intent();
        VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent2, 0);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 0);
        VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent2, 0, broadcast);
        intent.putExtra("app", broadcast);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context) {
        this.b.b(context, PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    public final boolean a(Intent intent) {
        String str;
        String stringExtra;
        boolean d2;
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra2 = intent.getStringExtra("registration_id");
            String stringExtra3 = intent.getStringExtra("unregistered");
            String stringExtra4 = intent.getStringExtra("error");
            if (stringExtra2 != null) {
                if (stringExtra2.length() > 0) {
                    if (stringExtra2.startsWith(Effect.DIVIDER)) {
                        return false;
                    }
                    f(stringExtra2);
                    return false;
                } else if (stringExtra3 == null && stringExtra4 == null && !this.c) {
                    this.c = true;
                    a();
                    return true;
                }
            }
            if (stringExtra3 != null) {
                String b = this.b.b(this.a);
                a(this.a);
                this.b.b(this.a, false);
                this.b.b(this.a, "");
                this.b.a(this.a, true);
                b(b);
                return false;
            } else if (stringExtra4 != null) {
                if (GmsRpc.ERROR_SERVICE_NOT_AVAILABLE.equals(stringExtra4)) {
                    d2 = c(stringExtra4);
                } else if (!this.c) {
                    c(stringExtra4);
                    this.c = true;
                    a();
                    return true;
                } else {
                    d2 = d(stringExtra4);
                }
                if (d2) {
                    int g2 = this.b.g(this.a);
                    Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                    intent2.setPackage(this.a.getPackageName());
                    Context context = this.a;
                    VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent2, 0);
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 0);
                    VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent2, 0, broadcast);
                    ((AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + g2, broadcast);
                    if (g2 < 3600000) {
                        this.b.b(this.a, g2 * 2);
                    }
                }
                return true;
            } else {
                return false;
            }
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            String stringExtra5 = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            if (stringExtra5 != null) {
                if (Constants.MessageTypes.DELETED.equals(stringExtra5) && (stringExtra = intent.getStringExtra("total_deleted")) != null) {
                    try {
                        a(Integer.parseInt(stringExtra));
                    } catch (NumberFormatException unused) {
                    }
                }
                return false;
            }
            return a(this.a, intent);
        } else if ("com.google.android.gcm.intent.RETRY".equals(action) && (str = intent.getPackage()) != null && str.equals(this.a.getPackageName())) {
            a();
            return true;
        } else {
            return false;
        }
    }
}
