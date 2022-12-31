package cn.sharesdk.framework;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
/* loaded from: classes.dex */
public class AgreementDialog extends FakeActivity {
    private Dialog a;
    private OnDialogDismiss b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnDialogDismiss {
        void consent();

        void refuse();
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(final Activity activity) {
        super.setActivity(activity);
        try {
            this.a = new Dialog(activity, ResHelper.getStyleRes(activity, "mobcommon_DialogStyle"));
            View inflate = LayoutInflater.from(activity).inflate(ResHelper.getLayoutRes(activity, "sharesdk_agreement_dialog"), (ViewGroup) null);
            this.a.setCanceledOnTouchOutside(false);
            this.a.setContentView(inflate);
            Window window = this.a.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            window.setAttributes(attributes);
            this.a.setCancelable(true);
            inflate.findViewById(ResHelper.getIdRes(activity, "sharesdk_agreement_dialog_reject_tv")).setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.AgreementDialog.1
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view) {
                    VdsAgent.onClick(this, view);
                    AgreementDialog.this.a();
                }
            });
            inflate.findViewById(ResHelper.getIdRes(activity, "sharesdk_agreement_dialog_accept_tv")).setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.AgreementDialog.2
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view) {
                    VdsAgent.onClick(this, view);
                    if (AgreementDialog.this.a != null && AgreementDialog.this.a.isShowing()) {
                        AgreementDialog.this.a.dismiss();
                        if (AgreementDialog.this.b != null) {
                            AgreementDialog.this.b.consent();
                        }
                        cn.sharesdk.framework.b.a.e.a().a(true);
                    }
                    activity.finish();
                }
            });
            this.a.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: cn.sharesdk.framework.AgreementDialog.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    if (i2 == 4) {
                        AgreementDialog.this.a();
                        return false;
                    }
                    return false;
                }
            });
            Dialog dialog = this.a;
            dialog.show();
            VdsAgent.showDialog(dialog);
        } catch (Throwable unused) {
        }
    }

    public void a(OnDialogDismiss onDialogDismiss) {
        this.b = onDialogDismiss;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Dialog dialog = this.a;
        if (dialog != null && dialog.isShowing()) {
            this.a.dismiss();
            OnDialogDismiss onDialogDismiss = this.b;
            if (onDialogDismiss != null) {
                onDialogDismiss.refuse();
            }
        }
        this.activity.finish();
    }
}
