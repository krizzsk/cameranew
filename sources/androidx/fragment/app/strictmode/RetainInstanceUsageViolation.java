package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: RetainInstanceUsageViolation.kt */
/* loaded from: classes.dex */
public abstract class RetainInstanceUsageViolation extends Violation {
    public /* synthetic */ RetainInstanceUsageViolation(Fragment fragment, String str, int i2, o oVar) {
        this(fragment, (i2 & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainInstanceUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        s.h(fragment, "fragment");
    }
}
