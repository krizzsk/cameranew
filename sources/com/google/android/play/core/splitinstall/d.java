package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class d {
    public static d a(Bundle bundle) {
        return new f(bundle.getInt(TapjoyConstants.TJC_SESSION_ID), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public static d f(int i2, int i3, int i4, long j2, long j3, List<String> list, List<String> list2) {
        if (i3 != 8) {
            return new f(i2, i3, i4, j2, j3, list, list2, null, null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract List<String> b();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract List<String> c();

    public abstract long d();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract List<Intent> e();

    public abstract int g();

    public boolean h() {
        int m = m();
        return m == 0 || m == 5 || m == 6 || m == 7;
    }

    @NonNull
    public List<String> i() {
        return c() != null ? new ArrayList(c()) : new ArrayList();
    }

    @NonNull
    public List<String> j() {
        return b() != null ? new ArrayList(b()) : new ArrayList();
    }

    @Nullable
    @Deprecated
    public abstract PendingIntent k();

    public abstract int l();

    public abstract int m();

    public abstract long n();
}
