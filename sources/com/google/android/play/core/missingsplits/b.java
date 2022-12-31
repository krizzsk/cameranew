package com.google.android.play.core.missingsplits;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public class b {
    private static final AtomicReference<Boolean> a = new AtomicReference<>(null);

    @NonNull
    public static a a(@NonNull Context context) {
        return new d(context, Runtime.getRuntime(), new c(context, context.getPackageManager()), a);
    }
}
