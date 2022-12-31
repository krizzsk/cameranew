package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: TargetFragmentUsageViolation.kt */
/* loaded from: classes.dex */
public abstract class TargetFragmentUsageViolation extends Violation {
    public /* synthetic */ TargetFragmentUsageViolation(Fragment fragment, String str, int i2, o oVar) {
        this(fragment, (i2 & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TargetFragmentUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        s.h(fragment, "fragment");
    }
}
