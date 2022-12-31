package us.pinguo.ui.widget.snack;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.R;
/* compiled from: ThemeUtils.java */
/* loaded from: classes6.dex */
class b {
    private static final int[] a = {R.attr.colorPrimary};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
