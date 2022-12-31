package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher addCallback, LifecycleOwner lifecycleOwner, final boolean z, final l<? super OnBackPressedCallback, u> onBackPressed) {
        s.h(addCallback, "$this$addCallback");
        s.h(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(z) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                l.this.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            addCallback.addCallback(lifecycleOwner, onBackPressedCallback);
        } else {
            addCallback.addCallback(onBackPressedCallback);
        }
        return onBackPressedCallback;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z, lVar);
    }
}
