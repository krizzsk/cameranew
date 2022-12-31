package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.s;
/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View findViewTreeSavedStateRegistryOwner) {
        s.h(findViewTreeSavedStateRegistryOwner, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(findViewTreeSavedStateRegistryOwner);
    }
}
