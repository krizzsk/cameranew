package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class h {
    private static int a = 129;
    private static final Object b = new Object();
    private static h c;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: f  reason: collision with root package name */
        private static final Uri f3681f = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority("com.google.android.gms.chimera").build();
        @Nullable
        private final String a;
        @Nullable
        private final String b;
        @Nullable
        private final ComponentName c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3682d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f3683e;

        public a(String str, String str2, int i2, boolean z) {
            q.f(str);
            this.a = str;
            q.f(str2);
            this.b = str2;
            this.c = null;
            this.f3682d = i2;
            this.f3683e = z;
        }

        @Nullable
        private final Intent d(Context context) {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.a);
            try {
                bundle = context.getContentResolver().call(f3681f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                sb.append("Dynamic intent resolution failed: ");
                sb.append(valueOf);
                Log.w("ConnectionStatusConfig", sb.toString());
                bundle = null;
            }
            Intent intent = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                String valueOf2 = String.valueOf(this.a);
                Log.w("ConnectionStatusConfig", valueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf2) : new String("Dynamic lookup for intent failed for action: "));
            }
            return intent;
        }

        public final Intent a(Context context) {
            if (this.a != null) {
                Intent d2 = this.f3683e ? d(context) : null;
                return d2 == null ? new Intent(this.a).setPackage(this.b) : d2;
            }
            return new Intent().setComponent(this.c);
        }

        @Nullable
        public final String b() {
            return this.b;
        }

        @Nullable
        public final ComponentName c() {
            return this.c;
        }

        public final int e() {
            return this.f3682d;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return p.a(this.a, aVar.a) && p.a(this.b, aVar.b) && p.a(this.c, aVar.c) && this.f3682d == aVar.f3682d && this.f3683e == aVar.f3683e;
            }
            return false;
        }

        public final int hashCode() {
            return p.b(this.a, this.b, this.c, Integer.valueOf(this.f3682d), Boolean.valueOf(this.f3683e));
        }

        public final String toString() {
            String str = this.a;
            if (str == null) {
                q.j(this.c);
                return this.c.flattenToString();
            }
            return str;
        }
    }

    public static int a() {
        return a;
    }

    public static h b(Context context) {
        synchronized (b) {
            if (c == null) {
                c = new g0(context.getApplicationContext());
            }
        }
        return c;
    }

    public final void c(String str, String str2, int i2, ServiceConnection serviceConnection, String str3, boolean z) {
        e(new a(str, str2, i2, z), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean d(a aVar, ServiceConnection serviceConnection, String str);

    protected abstract void e(a aVar, ServiceConnection serviceConnection, String str);
}
