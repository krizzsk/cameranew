package us.pinguo.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import java.lang.ref.WeakReference;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.base.d;
/* loaded from: classes6.dex */
public class LifeCycleDialog extends Dialog implements a, d {
    private WeakReference<InspireBaseActivity> a;

    public LifeCycleDialog(Context context) {
        super(context);
    }

    public void a(InspireBaseActivity inspireBaseActivity) {
        if (inspireBaseActivity != null) {
            this.a = new WeakReference<>(inspireBaseActivity);
            inspireBaseActivity.addActivityLifeCycle(this);
        }
    }

    public void b() {
        WeakReference<InspireBaseActivity> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().removeActivityLifeCycle(this);
        this.a = null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        b();
        super.dismiss();
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public LifeCycleDialog(Context context, int i2) {
        super(context, i2);
    }
}
