package androidx.activity.result;

import android.content.Intent;
import kotlin.jvm.internal.s;
/* compiled from: ActivityResult.kt */
/* loaded from: classes.dex */
public final class ActivityResultKt {
    public static final int component1(ActivityResult component1) {
        s.h(component1, "$this$component1");
        return component1.getResultCode();
    }

    public static final Intent component2(ActivityResult component2) {
        s.h(component2, "$this$component2");
        return component2.getData();
    }
}
