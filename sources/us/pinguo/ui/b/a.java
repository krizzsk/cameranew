package us.pinguo.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pnikosis.materialishprogress.ProgressWheel;
import us.pinguo.ui.R;
/* compiled from: MDProgressDialogUtils.java */
/* loaded from: classes6.dex */
public class a {

    /* compiled from: MDProgressDialogUtils.java */
    /* renamed from: us.pinguo.ui.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0454a {
        private TextView a;
        private AlertDialog b;

        protected C0454a(Context context) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.md_dialog_layout, (ViewGroup) null);
            this.a = (TextView) inflate.findViewById(R.id.progress_message);
            ProgressWheel progressWheel = (ProgressWheel) inflate.findViewById(R.id.progress_wheel);
            TextView textView = (TextView) inflate.findViewById(R.id.progress_percentage);
            builder.setView(inflate);
            builder.setCancelable(false);
            this.b = builder.create();
        }

        public void a() {
            this.b.dismiss();
        }

        public boolean b() {
            return this.b.isShowing();
        }

        public void c(boolean z) {
            this.b.setCancelable(z);
        }

        public void d(String str) {
            this.a.setText(str);
        }

        public void e() {
            AlertDialog alertDialog = this.b;
            alertDialog.show();
            VdsAgent.showDialog(alertDialog);
        }
    }

    public static AlertDialog a(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.InspireDialog);
        builder.setView(LayoutInflater.from(context).inflate(R.layout.md_progress_layout, (ViewGroup) null));
        builder.setCancelable(false);
        return builder.create();
    }

    public static C0454a b(Context context, String str) {
        C0454a c0454a = new C0454a(context);
        c0454a.d(str);
        return c0454a;
    }

    public static AlertDialog c(Context context, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.md_dialog_layout, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.progress_message)).setText(str);
        builder.setView(inflate);
        builder.setCancelable(false);
        return builder.create();
    }
}
