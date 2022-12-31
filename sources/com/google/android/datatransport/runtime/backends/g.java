package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
/* compiled from: CreationContext.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class g {
    public static g a(Context context, com.google.android.datatransport.runtime.x.a aVar, com.google.android.datatransport.runtime.x.a aVar2, String str) {
        return new c(context, aVar, aVar2, str);
    }

    public abstract Context b();

    @NonNull
    public abstract String c();

    public abstract com.google.android.datatransport.runtime.x.a d();

    public abstract com.google.android.datatransport.runtime.x.a e();
}
