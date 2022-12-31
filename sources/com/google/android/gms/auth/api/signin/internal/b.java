package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.q;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class b {
    private static final Lock c = new ReentrantLock();
    @GuardedBy("sLk")

    /* renamed from: d  reason: collision with root package name */
    private static b f3574d;
    private final Lock a = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences b;

    private b(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        q.j(context);
        Lock lock = c;
        lock.lock();
        try {
            if (f3574d == null) {
                f3574d = new b(context.getApplicationContext());
            }
            b bVar = f3574d;
            lock.unlock();
            return bVar;
        } catch (Throwable th) {
            c.unlock();
            throw th;
        }
    }

    private static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    private final GoogleSignInAccount d(String str) {
        String e2;
        if (!TextUtils.isEmpty(str) && (e2 = e(c("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.Z(e2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    private final String e(String str) {
        this.a.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            this.a.unlock();
        }
    }

    @Nullable
    public GoogleSignInAccount b() {
        return d(e("defaultGoogleSignInAccount"));
    }
}
