package com.google.android.gms.internal.location;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
/* loaded from: classes2.dex */
public final class zzbm {
    public static Looper zza(@Nullable Looper looper) {
        return looper != null ? looper : zzc();
    }

    public static Looper zzc() {
        q.n(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
