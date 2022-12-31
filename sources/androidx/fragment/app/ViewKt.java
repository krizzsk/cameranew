package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.s;
/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        s.h(view, "<this>");
        F f2 = (F) FragmentManager.findFragment(view);
        s.g(f2, "findFragment(this)");
        return f2;
    }
}
