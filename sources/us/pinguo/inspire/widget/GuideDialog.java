package us.pinguo.inspire.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class GuideDialog extends Dialog {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GuideDialog.this.dismiss();
        }
    }

    public GuideDialog(Context context) {
        super(context, R.style.InspireDialog);
        getWindow().setWindowAnimations(vStudio.Android.Camera360.R.style.GuideDialogAnim_In);
    }

    public void dismissAnim() {
        getWindow().setWindowAnimations(vStudio.Android.Camera360.R.style.GuideDialogAnim_Out);
        new Handler().post(new a());
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            dismissAnim();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
