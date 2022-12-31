package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.s;
/* compiled from: SetRetainInstanceUsageViolation.kt */
/* loaded from: classes.dex */
public final class SetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetRetainInstanceUsageViolation(Fragment fragment) {
        super(fragment, s.q("Attempting to set retain instance for fragment ", fragment));
        s.h(fragment, "fragment");
    }
}
