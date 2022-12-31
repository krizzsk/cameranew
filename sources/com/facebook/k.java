package com.facebook;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.x;
import com.facebook.internal.y;
/* compiled from: ProfileManager.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: d  reason: collision with root package name */
    private static volatile k f3099d;
    private final LocalBroadcastManager a;
    private final j b;
    private Profile c;

    k(LocalBroadcastManager localBroadcastManager, j jVar) {
        y.l(localBroadcastManager, "localBroadcastManager");
        y.l(jVar, "profileCache");
        this.a = localBroadcastManager;
        this.b = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k b() {
        if (f3099d == null) {
            synchronized (k.class) {
                if (f3099d == null) {
                    f3099d = new k(LocalBroadcastManager.getInstance(f.f()), new j());
                }
            }
        }
        return f3099d;
    }

    private void d(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.a.sendBroadcast(intent);
    }

    private void f(@Nullable Profile profile, boolean z) {
        Profile profile2 = this.c;
        this.c = profile;
        if (z) {
            if (profile != null) {
                this.b.c(profile);
            } else {
                this.b.a();
            }
        }
        if (x.b(profile2, profile)) {
            return;
        }
        d(profile2, profile);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Profile a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        Profile b = this.b.b();
        if (b != null) {
            f(b, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(@Nullable Profile profile) {
        f(profile, true);
    }
}
