package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.s;
/* compiled from: GetTargetFragmentUsageViolation.kt */
/* loaded from: classes.dex */
public final class GetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTargetFragmentUsageViolation(Fragment fragment) {
        super(fragment, s.q("Attempting to get target fragment from fragment ", fragment));
        s.h(fragment, "fragment");
    }
}
