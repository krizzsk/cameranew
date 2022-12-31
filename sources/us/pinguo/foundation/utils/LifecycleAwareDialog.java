package us.pinguo.foundation.utils;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: LifecycleAwareDialog.kt */
/* loaded from: classes4.dex */
public class LifecycleAwareDialog extends AlertDialog implements LifecycleObserver {
    private boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleAwareDialog(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void onLifecycleCreated() {
        this.a = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onLifecycleDestroy() {
        this.a = true;
        dismiss();
    }

    public final void a(Lifecycle lifecycle) {
        kotlin.jvm.internal.s.h(lifecycle, "lifecycle");
        lifecycle.addObserver(this);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.a) {
            return;
        }
        super.show();
        VdsAgent.showDialog(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleAwareDialog(Context context, int i2) {
        super(context, i2);
        kotlin.jvm.internal.s.h(context, "context");
    }
}
