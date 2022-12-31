package butterknife.internal;

import android.util.TypedValue;
import android.view.View;
import androidx.annotation.IdRes;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class a {
    static {
        new TypedValue();
    }

    public static <T> T a(View view, @IdRes int i2, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e2) {
            String d2 = d(view, i2);
            throw new IllegalStateException("View '" + d2 + "' with ID " + i2 + " for " + str + " was of the wrong type. See cause for more info.", e2);
        }
    }

    public static View b(View view, @IdRes int i2, String str) {
        View findViewById = view.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        String d2 = d(view, i2);
        throw new IllegalStateException("Required view '" + d2 + "' with ID " + i2 + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T c(View view, @IdRes int i2, String str, Class<T> cls) {
        return (T) a(b(view, i2, str), i2, str, cls);
    }

    private static String d(View view, @IdRes int i2) {
        return view.isInEditMode() ? "<unavailable while editing>" : view.getContext().getResources().getResourceEntryName(i2);
    }
}
