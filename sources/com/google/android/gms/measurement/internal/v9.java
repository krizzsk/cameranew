package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class v9 {
    private final o4 a;

    public v9(o4 o4Var) {
        this.a = o4Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void a() {
        this.a.c().f();
        if (e()) {
            if (d()) {
                this.a.y().z.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.a.D().V("auto", "_cmpx", bundle);
            } else {
                String a = this.a.y().z.a();
                if (TextUtils.isEmpty(a)) {
                    this.a.a().n().a("Cache still valid but referrer not found");
                } else {
                    long a2 = ((this.a.y().A.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", a2);
                    this.a.D().V((String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.a.y().z.b(null);
            }
            this.a.y().A.b(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void b(String str, Bundle bundle) {
        String uri;
        this.a.c().f();
        if (this.a.i()) {
            return;
        }
        if (bundle.isEmpty()) {
            uri = null;
        } else {
            if (true == str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            uri = builder.build().toString();
        }
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        this.a.y().z.b(uri);
        this.a.y().A.b(this.a.zzax().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (e() && d()) {
            this.a.y().z.b(null);
        }
    }

    final boolean d() {
        return e() && this.a.zzax().currentTimeMillis() - this.a.y().A.a() > this.a.x().q(null, x2.R);
    }

    final boolean e() {
        return this.a.y().A.a() > 0;
    }
}
