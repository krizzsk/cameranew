package us.pinguo.camera360.shop.manager;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import vStudio.Android.Camera360.R;
/* compiled from: DialogView.java */
/* loaded from: classes4.dex */
public class o0 {
    protected Activity a;
    protected View b;
    private Dialog c;

    public o0(Activity activity, int i2) {
        this.a = activity;
        this.b = f(i2);
        d();
    }

    private View f(int i2) {
        View inflate = LayoutInflater.from(this.a).inflate(i2, (ViewGroup) null);
        this.b = inflate;
        return inflate;
    }

    public void a() {
        Dialog dialog = this.c;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.c.dismiss();
    }

    public View b() {
        return this.b;
    }

    public Dialog c() {
        return this.c;
    }

    protected void d() {
        Dialog dialog = new Dialog(this.a, R.style.pay_chose_dialog_view_theme);
        this.c = dialog;
        dialog.getWindow().setGravity(80);
        this.c.setCancelable(true);
        this.c.setCanceledOnTouchOutside(true);
        this.c.setContentView(this.b);
    }

    public boolean e() {
        Dialog dialog = this.c;
        return dialog != null && dialog.isShowing();
    }

    public void g() {
        Dialog dialog = this.c;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        try {
            Dialog dialog2 = this.c;
            dialog2.show();
            VdsAgent.showDialog(dialog2);
        } catch (Exception unused) {
        }
    }
}
