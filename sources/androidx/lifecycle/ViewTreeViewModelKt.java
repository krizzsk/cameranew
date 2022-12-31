package androidx.lifecycle;

import android.view.View;
import kotlin.jvm.internal.s;
/* compiled from: ViewTreeViewModel.kt */
/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        s.h(view, "<this>");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
