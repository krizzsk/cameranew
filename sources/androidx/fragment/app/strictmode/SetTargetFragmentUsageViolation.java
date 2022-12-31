package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.s;
/* compiled from: SetTargetFragmentUsageViolation.kt */
/* loaded from: classes.dex */
public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    private final int requestCode;
    private final Fragment targetFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(Fragment fragment, Fragment targetFragment, int i2) {
        super(fragment, "Attempting to set target fragment " + targetFragment + " with request code " + i2 + " for fragment " + fragment);
        s.h(fragment, "fragment");
        s.h(targetFragment, "targetFragment");
        this.targetFragment = targetFragment;
        this.requestCode = i2;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
