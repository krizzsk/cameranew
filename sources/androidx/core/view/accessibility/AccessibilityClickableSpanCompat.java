package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
    private final int mClickableSpanActionId;
    private final AccessibilityNodeInfoCompat mNodeInfoCompat;
    private final int mOriginalClickableSpanId;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityClickableSpanCompat(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i3) {
        this.mOriginalClickableSpanId = i2;
        this.mNodeInfoCompat = accessibilityNodeInfoCompat;
        this.mClickableSpanActionId = i3;
    }

    @Override // android.text.style.ClickableSpan
    @Instrumented
    public void onClick(@NonNull View view) {
        VdsAgent.onClick(this, view);
        Bundle bundle = new Bundle();
        bundle.putInt(SPAN_ID, this.mOriginalClickableSpanId);
        this.mNodeInfoCompat.performAction(this.mClickableSpanActionId, bundle);
    }
}
