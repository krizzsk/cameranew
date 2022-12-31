package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
/* compiled from: Half.kt */
/* loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s) {
        Half valueOf = Half.valueOf(s);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f2) {
        Half valueOf = Half.valueOf(f2);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        s.h(str, "<this>");
        Half valueOf = Half.valueOf(str);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d2) {
        Half valueOf = Half.valueOf((float) d2);
        s.g(valueOf, "valueOf(this)");
        return valueOf;
    }
}
