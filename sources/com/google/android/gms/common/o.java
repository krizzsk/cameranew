package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@CheckReturnValue
/* loaded from: classes2.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    private static final o f3689d = new o(true, null, null);
    final boolean a;
    @Nullable
    private final String b;
    @Nullable
    private final Throwable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.a = z;
        this.b = str;
        this.c = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        return f3689d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o b(@NonNull String str) {
        return new o(false, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o c(@NonNull String str, @NonNull Throwable th) {
        return new o(false, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o d(Callable<String> callable) {
        return new q(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str, h hVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, com.google.android.gms.common.util.j.a(com.google.android.gms.common.util.a.b(Constants.SHA1).digest(hVar.y0())), Boolean.valueOf(z), "12451009.false");
    }

    @Nullable
    String f() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g() {
        if (this.a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.c != null) {
            Log.d("GoogleCertificatesRslt", f(), this.c);
        } else {
            Log.d("GoogleCertificatesRslt", f());
        }
    }
}
