package us.pinguo.foundation.ui.mddialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwner;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.text.NumberFormat;
import us.pinguo.foundation.R;
import us.pinguo.foundation.utils.LifecycleAwareDialog;
import us.pinguo.foundation.utils.LifecycleDialogBuilder;
/* compiled from: MDProgressDialog.java */
/* loaded from: classes4.dex */
public class a {
    public int a;
    private ProgressWheel b;
    private ProgressBarDeterminate c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11086d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f11087e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11088f;

    /* renamed from: g  reason: collision with root package name */
    private String f11089g;

    /* renamed from: h  reason: collision with root package name */
    private NumberFormat f11090h;

    /* renamed from: i  reason: collision with root package name */
    private AlertDialog f11091i;

    /* renamed from: j  reason: collision with root package name */
    private HandlerC0396a f11092j;

    /* renamed from: k  reason: collision with root package name */
    private Context f11093k;

    /* compiled from: MDProgressDialog.java */
    /* renamed from: us.pinguo.foundation.ui.mddialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class HandlerC0396a extends Handler {
        HandlerC0396a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                int c = a.this.c.c();
                int b = a.this.c.b();
                a.this.f11087e.setText(String.format(a.this.f11089g, Integer.valueOf(c), Integer.valueOf(b)));
                SpannableString spannableString = new SpannableString(a.this.f11090h.format(c / b));
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                a.this.f11088f.setText(spannableString);
            }
        }
    }

    public a(Context context, int i2) {
        this.f11093k = context;
        this.a = i2;
        if (i2 != 1) {
            if (i2 == 2) {
                LifecycleDialogBuilder lifecycleDialogBuilder = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
                View inflate = LayoutInflater.from(context).inflate(R.layout.progress_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.progress_text);
                this.f11086d = textView;
                textView.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView, 8);
                this.b = (ProgressWheel) inflate.findViewById(R.id.progress_wheel);
                lifecycleDialogBuilder.setView(inflate);
                LifecycleAwareDialog create = lifecycleDialogBuilder.create();
                this.f11091i = create;
                if (context instanceof LifecycleOwner) {
                    create.a(((LifecycleOwner) context).getLifecycle());
                    return;
                }
                return;
            }
            return;
        }
        LifecycleDialogBuilder lifecycleDialogBuilder2 = new LifecycleDialogBuilder(context, R.style.AlertDialogCustom);
        View inflate2 = LayoutInflater.from(context).inflate(R.layout.progress_horizontal_layout, (ViewGroup) null);
        this.f11087e = (TextView) inflate2.findViewById(R.id.progress_number);
        this.c = (ProgressBarDeterminate) inflate2.findViewById(R.id.progress_d);
        this.f11088f = (TextView) inflate2.findViewById(R.id.progress_percent);
        this.f11089g = "%d/%d";
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        this.f11090h = percentInstance;
        percentInstance.setMaximumFractionDigits(0);
        this.f11092j = new HandlerC0396a();
        lifecycleDialogBuilder2.setView(inflate2);
        LifecycleAwareDialog create2 = lifecycleDialogBuilder2.create();
        this.f11091i = create2;
        if (context instanceof LifecycleOwner) {
            create2.a(((LifecycleOwner) context).getLifecycle());
        }
    }

    public void f() {
        this.f11091i.dismiss();
    }

    public boolean g() {
        return this.f11091i.isShowing();
    }

    public void h(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f11091i.setButton(i2, charSequence, onClickListener);
    }

    public void i(boolean z) {
        this.f11091i.setCancelable(z);
    }

    public void j(int i2) {
        if (this.a == 1) {
            this.c.setMax(i2);
            this.f11092j.sendEmptyMessage(1);
        }
    }

    public void k(int i2) {
        if (this.a == 2) {
            this.f11086d.setText(i2);
            TextView textView = this.f11086d;
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
        }
    }

    public void l(DialogInterface.OnCancelListener onCancelListener) {
        this.f11091i.setOnCancelListener(onCancelListener);
    }

    public void m(DialogInterface.OnDismissListener onDismissListener) {
        this.f11091i.setOnDismissListener(onDismissListener);
    }

    public void n(DialogInterface.OnKeyListener onKeyListener) {
        this.f11091i.setOnKeyListener(onKeyListener);
    }

    public void o(int i2) {
        int i3 = this.a;
        if (i3 == 2) {
            this.b.setProgress(i2);
        } else if (i3 == 1) {
            this.c.setProgress(i2);
            this.f11092j.sendEmptyMessage(1);
        }
    }

    public void p(int i2) {
        this.f11091i.setTitle(i2);
    }

    public void q() {
        AlertDialog alertDialog = this.f11091i;
        alertDialog.show();
        VdsAgent.showDialog(alertDialog);
    }
}
