package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.s;
/* compiled from: PersistableBundle.kt */
/* loaded from: classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(Pair<String, ? extends Object>... pairs) {
        s.h(pairs, "pairs");
        PersistableBundle persistableBundle = new PersistableBundle(pairs.length);
        int length = pairs.length;
        int i2 = 0;
        while (i2 < length) {
            Pair<String, ? extends Object> pair = pairs[i2];
            i2++;
            String component1 = pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                persistableBundle.putString(component1, null);
            } else if (component2 instanceof Boolean) {
                if (Build.VERSION.SDK_INT >= 22) {
                    persistableBundle.putBoolean(component1, ((Boolean) component2).booleanValue());
                } else {
                    throw new IllegalArgumentException("Illegal value type boolean for key \"" + component1 + '\"');
                }
            } else if (component2 instanceof Double) {
                persistableBundle.putDouble(component1, ((Number) component2).doubleValue());
            } else if (component2 instanceof Integer) {
                persistableBundle.putInt(component1, ((Number) component2).intValue());
            } else if (component2 instanceof Long) {
                persistableBundle.putLong(component1, ((Number) component2).longValue());
            } else if (component2 instanceof String) {
                persistableBundle.putString(component1, (String) component2);
            } else if (component2 instanceof boolean[]) {
                if (Build.VERSION.SDK_INT >= 22) {
                    persistableBundle.putBooleanArray(component1, (boolean[]) component2);
                } else {
                    throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + component1 + '\"');
                }
            } else if (component2 instanceof double[]) {
                persistableBundle.putDoubleArray(component1, (double[]) component2);
            } else if (component2 instanceof int[]) {
                persistableBundle.putIntArray(component1, (int[]) component2);
            } else if (component2 instanceof long[]) {
                persistableBundle.putLongArray(component1, (long[]) component2);
            } else if (component2 instanceof Object[]) {
                Class<?> componentType = component2.getClass().getComponentType();
                s.e(componentType);
                if (String.class.isAssignableFrom(componentType)) {
                    Objects.requireNonNull(component2, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    persistableBundle.putStringArray(component1, (String[]) component2);
                } else {
                    String canonicalName = componentType.getCanonicalName();
                    throw new IllegalArgumentException("Illegal value array type " + ((Object) canonicalName) + " for key \"" + component1 + '\"');
                }
            } else {
                String canonicalName2 = component2.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName2) + " for key \"" + component1 + '\"');
            }
        }
        return persistableBundle;
    }
}
