package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.j;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class k {
    public static <L> j<L> a(@NonNull L l2, @NonNull Looper looper, @NonNull String str) {
        com.google.android.gms.common.internal.q.k(l2, "Listener must not be null");
        com.google.android.gms.common.internal.q.k(looper, "Looper must not be null");
        com.google.android.gms.common.internal.q.k(str, "Listener type must not be null");
        return new j<>(looper, l2, str);
    }

    public static <L> j.a<L> b(@NonNull L l2, @NonNull String str) {
        com.google.android.gms.common.internal.q.k(l2, "Listener must not be null");
        com.google.android.gms.common.internal.q.k(str, "Listener type must not be null");
        com.google.android.gms.common.internal.q.g(str, "Listener type must not be empty");
        return new j.a<>(l2, str);
    }
}
