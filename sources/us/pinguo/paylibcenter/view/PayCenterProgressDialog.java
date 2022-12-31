package us.pinguo.paylibcenter.view;

import android.app.Dialog;
import android.content.Context;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.paylibcenter.R;
/* loaded from: classes5.dex */
public class PayCenterProgressDialog extends Dialog {
    private Context a;

    public PayCenterProgressDialog(Context context) {
        super(context);
        this.a = context;
    }

    public static PayCenterProgressDialog a(Context context) {
        PayCenterProgressDialog payCenterProgressDialog = new PayCenterProgressDialog(context, R.style.CustomProgressDialog);
        payCenterProgressDialog.setCancelable(false);
        payCenterProgressDialog.setContentView(R.layout.paycenter_layout_loading);
        payCenterProgressDialog.getWindow().getAttributes().gravity = 17;
        return payCenterProgressDialog;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        VdsAgent.showDialog(this);
    }

    public PayCenterProgressDialog(Context context, int i2) {
        super(context, i2);
    }
}
