package us.pinguo.user.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.R;
import us.pinguo.user.util.BaseInfoResult;
import us.pinguo.user.w0;
/* loaded from: classes6.dex */
public class PGRegisterFragment extends PGBaseLoginFragment {
    TextView u;
    private us.pinguo.user.request.f v;
    private us.pinguo.user.request.k w;
    private AppCompatCheckBox x;
    private AlertDialog y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends j.a.c.b.d<Void> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r2) {
            w0.k(1);
            w0.g(true);
            PGRegisterFragment.this.h0();
            PGRegisterFragment.this.B0();
            PGRegisterFragment.this.R0(this.a);
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            int i2;
            PGRegisterFragment.this.h0();
            if (exc instanceof Fault) {
                i2 = ((Fault) exc).getStatus();
                str = us.pinguo.user.api.f0.a(PGRegisterFragment.this.getContext(), i2);
            } else {
                str = null;
                i2 = 0;
            }
            if (PGRegisterFragment.this.isAdded()) {
                if (TextUtils.isEmpty(str)) {
                    PGRegisterFragment.this.F0(PGRegisterFragment.this.getString(R.string.pg_register_fail));
                } else if (i2 == 10518) {
                    PGRegisterFragment.this.X(str, 1);
                } else {
                    PGRegisterFragment.this.X(str, 3);
                }
                if (i2 == 10518) {
                    PGRegisterFragment.this.R(4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends j.a.c.b.d<Void> {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r3) {
            PGRegisterFragment.this.R0(this.a);
            w0.k(0);
            PGRegisterFragment.this.h0();
            Intent intent = new Intent(PGRegisterFragment.this.getContext(), PGPhoneVerifyActivity.class);
            intent.putExtra("phoneNumber", this.a);
            intent.putExtra("phonePassword", this.b);
            PGRegisterFragment.this.startActivityForResult(intent, 1000);
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            int i2;
            PGRegisterFragment.this.h0();
            if (exc instanceof Fault) {
                i2 = ((Fault) exc).getStatus();
                str = us.pinguo.user.api.f0.a(PGRegisterFragment.this.getContext(), i2);
            } else {
                str = null;
                i2 = 0;
            }
            if (PGRegisterFragment.this.isAdded()) {
                if (i2 == 10541) {
                    PGRegisterFragment.this.O0();
                } else if (i2 == 10542) {
                    PGRegisterFragment.this.P0();
                } else if (i2 == 10543) {
                    Intent intent = new Intent(PGRegisterFragment.this.getContext(), PGPhoneVerifyActivity.class);
                    intent.putExtra("phoneNumber", this.a);
                    intent.putExtra("phonePassword", this.b);
                    PGRegisterFragment.this.startActivityForResult(intent, 1000);
                } else if (i2 == 10540) {
                    PGRegisterFragment.this.H0();
                } else {
                    if (TextUtils.isEmpty(str)) {
                        PGRegisterFragment.this.F0(PGRegisterFragment.this.getString(R.string.pg_register_fail));
                    } else if (i2 == 10518) {
                        PGRegisterFragment.this.X(str, 1);
                    } else if (i2 == 10544) {
                        PGRegisterFragment.this.F0(str);
                    } else {
                        PGRegisterFragment.this.X(str, 3);
                    }
                    if (i2 == 10518) {
                        PGRegisterFragment.this.R(4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -2) {
                dialogInterface.dismiss();
            } else if (i2 != -1) {
            } else {
                dialogInterface.dismiss();
                PGRegisterFragment.this.a1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        d(PGRegisterFragment pGRegisterFragment) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class e extends ClickableSpan {
        private String a;

        e(String str) {
            this.a = str;
        }

        @Override // android.text.style.ClickableSpan
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            Intent intent = new Intent();
            intent.setClassName(us.pinguo.util.v.a(), "com.pinguo.camera360.camera.options.OptionsWebviewActivity");
            intent.putExtra("towhere", this.a);
            PGRegisterFragment.this.getActivity().startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.argb(255, 21, 116, 255));
            textPaint.setUnderlineText(false);
        }
    }

    private void N0() {
        if (!us.pinguo.util.q.f(getContext())) {
            F0(getString(R.string.pg_login_network_exception));
            return;
        }
        String obj = this.b.getText().toString();
        String obj2 = this.c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            X(getString(R.string.pg_login_phone_number_empty), 1);
            R(4);
        } else if (!us.pinguo.util.t.b(obj)) {
            X(getString(R.string.pg_login_phone_number_format_error), 1);
            R(4);
        } else if (TextUtils.isEmpty(obj2)) {
            X(getString(R.string.pg_login_password_empty), 2);
        } else if (obj2.length() >= 6 && obj2.length() <= 20) {
            j0(this.b);
            Q0();
        } else {
            X(getString(R.string.pg_login_password_prompt), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        this.b.getText().toString();
        this.c.getText().toString();
        AlertDialog alertDialog = this.y;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.y.cancel();
        }
        AlertDialog g2 = us.pinguo.foundation.utils.w.g(getContext(), -999, R.string.pg_login_phone_number_exist_again, R.string.pg_login_good, -999, m0.a);
        this.y = g2;
        g2.setCancelable(false);
        this.y.setCanceledOnTouchOutside(false);
        AlertDialog alertDialog2 = this.y;
        alertDialog2.show();
        VdsAgent.showDialog(alertDialog2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        AlertDialog alertDialog = this.y;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.y.cancel();
        }
        AlertDialog g2 = us.pinguo.foundation.utils.w.g(getContext(), -999, R.string.pg_login_phone_number_exist_again, R.string.pg_login_good, -999, new d(this));
        this.y = g2;
        g2.setCancelable(false);
        this.y.setCanceledOnTouchOutside(false);
        AlertDialog alertDialog2 = this.y;
        alertDialog2.show();
        VdsAgent.showDialog(alertDialog2);
    }

    private void Q0() {
        String obj = this.b.getText().toString();
        AlertDialog alertDialog = this.y;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.y.cancel();
        }
        AlertDialog h2 = us.pinguo.foundation.utils.w.h(getContext(), getString(R.string.pg_login_confirm_phone_number), getString(R.string.pg_login_sms_verification_code_prompt, obj), getString(R.string.pg_login_good), getString(R.string.cancel), new c());
        this.y = h2;
        h2.show();
        VdsAgent.showDialog(h2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(String str) {
        us.pinguo.librouter.c.d.b().getInterface().n(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void S0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0 */
    public /* synthetic */ void U0(BaseInfoResult baseInfoResult, String str, String str2) {
        if (baseInfoResult == null) {
            F0(getString(R.string.pg_login_network_exception));
            h0();
            return;
        }
        us.pinguo.user.request.f fVar = new us.pinguo.user.request.f(getContext(), str, str2, baseInfoResult.isChina());
        this.v = fVar;
        fVar.get(new a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0 */
    public /* synthetic */ void W0(final String str, final String str2, final BaseInfoResult baseInfoResult, int i2) {
        D0(new Runnable() { // from class: us.pinguo.user.ui.l0
            @Override // java.lang.Runnable
            public final void run() {
                PGRegisterFragment.this.U0(baseInfoResult, str, str2);
            }
        });
    }

    private void Y0() {
        boolean z;
        String string = getResources().getString(R.string.pg_login_auth_text);
        String string2 = getActivity().getResources().getString(R.string.agreement_dialog_user_agreement);
        boolean z2 = true;
        if (string.contains(string2)) {
            string = string.replace(string2, "<a href='agreement' style='color:#4487F2'>" + string2 + "</a>");
            z = true;
        } else {
            z = false;
        }
        String string3 = getActivity().getResources().getString(R.string.agreement_dialog_privacy_policy);
        if (string.contains(string3)) {
            string = string.replace(string3, "<a href='privacy' style='color:#4487F2'>" + string3 + "</a>");
        } else {
            z2 = z;
        }
        if (!z2) {
            this.u.setOnClickListener(this);
            return;
        }
        Spannable spannable = (Spannable) Html.fromHtml(string);
        this.u.setText(spannable);
        this.u.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = this.u.getText();
        if (text instanceof Spannable) {
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, text.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.setSpan(new e(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
            }
            this.u.setText(spannableStringBuilder);
        }
    }

    private void Z0(Context context) {
        if (!us.pinguo.util.q.f(context)) {
            F0(getString(R.string.pg_login_network_exception));
            return;
        }
        final String obj = this.b.getText().toString();
        final String obj2 = this.c.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            X(getString(R.string.pg_login_email_empty), 1);
            R(4);
        } else if (!us.pinguo.util.t.a(obj)) {
            X(getString(R.string.pg_login_email_format_error), 1);
            R(4);
        } else if (TextUtils.isEmpty(obj2)) {
            X(getString(R.string.pg_login_password_empty), 2);
        } else if (obj2.length() >= 6 && obj2.length() <= 20) {
            j0(this.b);
            us.pinguo.user.request.f fVar = this.v;
            if (fVar != null) {
                fVar.cancel(true);
            }
            G0(getString(R.string.login_progress_registering));
            us.pinguo.user.util.n.a.h(new us.pinguo.user.util.g() { // from class: us.pinguo.user.ui.k0
                @Override // us.pinguo.user.util.g
                public final void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
                    PGRegisterFragment.this.W0(obj, obj2, baseInfoResult, i2);
                }
            });
        } else {
            X(getString(R.string.pg_login_password_prompt), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        String obj = this.b.getText().toString();
        String obj2 = this.c.getText().toString();
        us.pinguo.user.request.k kVar = this.w;
        if (kVar != null) {
            kVar.cancel(true);
        }
        this.w = new us.pinguo.user.request.k(getContext(), obj, obj2);
        G0(getString(R.string.login_progress_registering));
        this.w.get(new b(obj, obj2));
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, us.pinguo.user.ui.view.EditTextWithPrompt.e
    public int V() {
        return this.f12403l;
    }

    void X0() {
        if (!this.x.isChecked()) {
            F0(getResources().getString(R.string.pls_check_box_msg));
            return;
        }
        us.pinguo.share.d.a.d(true, null);
        w0.i(3);
        if (this.f12401j) {
            if (this.b.getText().toString().contains("@")) {
                Z0(getContext());
                return;
            } else {
                N0();
                return;
            }
        }
        Z0(getContext());
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1000 && i3 == -1) {
            w0.g(false);
            B0();
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        super.onClick(view);
        if (view.getId() == R.id.login_confirm_btn) {
            X0();
        }
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.u = (TextView) onCreateView.findViewById(R.id.login_register_agreement);
        Y0();
        View findViewById = onCreateView.findViewById(R.id.layout_register_agreement);
        findViewById.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById, 0);
        View findViewById2 = onCreateView.findViewById(R.id.third_site_msg_layout);
        findViewById2.setVisibility(4);
        VdsAgent.onSetViewVisibility(findViewById2, 4);
        View findViewById3 = onCreateView.findViewById(R.id.login_third_site_gridView);
        findViewById3.setVisibility(4);
        VdsAgent.onSetViewVisibility(findViewById3, 4);
        this.a.setText(R.string.login_main_register);
        this.a.setOnClickListener(this);
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) onCreateView.findViewById(R.id.login_agreement_checkbox);
        this.x = appCompatCheckBox;
        appCompatCheckBox.setChecked(false);
        return onCreateView;
    }

    @Override // us.pinguo.user.ui.PGBaseLoginFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        us.pinguo.user.request.f fVar = this.v;
        if (fVar != null) {
            fVar.cancel(true);
        }
        us.pinguo.user.request.k kVar = this.w;
        if (kVar != null) {
            kVar.cancel(true);
        }
        j0(this.b);
        super.onDestroy();
    }
}
