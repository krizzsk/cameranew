package us.pinguo.user.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.user.R;
/* loaded from: classes6.dex */
public abstract class PGLoginBaseActivity extends BaseActivity {
    public TextView a;
    private AlertDialog b;
    private AlertDialog c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {
        a(PGLoginBaseActivity pGLoginBaseActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().clearFlags(1024);
        super.onCreate(bundle);
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
    }

    @Override // android.app.Activity
    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        if (menuItem.getItemId() != 16908332) {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected));
            return onOptionsItemSelected;
        }
        finish();
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
    }

    public void q0() {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void r0() {
        TextView textView = this.a;
        if (textView == null || textView.getVisibility() == 4) {
            return;
        }
        TextView textView2 = this.a;
        textView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView2, 4);
        this.a.setText("");
    }

    public void s0(EditText editText) {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void t0() {
        AlertDialog alertDialog = this.b;
        if (alertDialog == null) {
            this.b = us.pinguo.foundation.utils.w.p(this, -999);
            return;
        }
        alertDialog.show();
        VdsAgent.showDialog(alertDialog);
    }

    public void u0(String str) {
        TextView textView = this.a;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                TextView textView2 = this.a;
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
            }
            this.a.setText(str);
        }
    }

    public void v0(String str) {
        new us.pinguo.foundation.ui.e(this, str, 0).d();
    }

    public void w0() {
        AlertDialog alertDialog = this.c;
        if (alertDialog == null) {
            this.c = us.pinguo.foundation.utils.w.g(this, -999, R.string.status_errorcode10540, R.string.share_ok, -999, new a(this));
            return;
        }
        alertDialog.show();
        VdsAgent.showDialog(alertDialog);
    }
}
