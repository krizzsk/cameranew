package androidx.lifecycle;

import kotlin.jvm.internal.s;
/* compiled from: LifecycleOwner.kt */
/* loaded from: classes.dex */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner lifecycleOwner) {
        s.h(lifecycleOwner, "<this>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        s.g(lifecycle, "lifecycle");
        return LifecycleKt.getCoroutineScope(lifecycle);
    }
}
