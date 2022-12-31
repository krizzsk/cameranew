package com.pinguo.camera360.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.request.PhoneBindEmail;
import us.pinguo.foundation.network.Fault;
import us.pinguo.user.api.f0;
import us.pinguo.user.ui.PGLoginBaseActivity;
import us.pinguo.user.ui.view.EditTextWithPrompt;
import us.pinguo.util.q;
import us.pinguo.util.t;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class PGPhoneBindEmailActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private EditTextWithPrompt f7003d;

    /* renamed from: e  reason: collision with root package name */
    private PhoneBindEmail f7004e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends j.a.c.b.d<Void> {
        a() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r3) {
            a.h.a(false);
            PGPhoneBindEmailActivity.this.q0();
            PGPhoneBindEmailActivity.this.setResult(-1, null);
            PGPhoneBindEmailActivity.this.finish();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PGPhoneBindEmailActivity.this.q0();
            if (exc instanceof Fault) {
                int status = ((Fault) exc).getStatus();
                if (status != 10518 && status != 10520) {
                    str = f0.a(PGPhoneBindEmailActivity.this, status);
                } else {
                    str = PGPhoneBindEmailActivity.this.getString(R.string.phone_bind_email_error_10518);
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                PGPhoneBindEmailActivity.this.v0(PGPhoneBindEmailActivity.this.getString(R.string.pg_login_network_exception));
                return;
            }
            PGPhoneBindEmailActivity.this.u0(str);
        }
    }

    private void x0() {
        s0(this.f7003d);
        if (!q.f(this)) {
            v0(getString(R.string.pg_login_network_exception));
            return;
        }
        String obj = this.f7003d.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            u0(getString(R.string.pg_login_email_empty));
        } else if (!t.a(obj)) {
            u0(getString(R.string.pg_login_email_format_error));
        } else {
            PhoneBindEmail phoneBindEmail = this.f7004e;
            if (phoneBindEmail != null) {
                phoneBindEmail.cancel(true);
            }
            this.f7004e = new PhoneBindEmail(this, obj);
            t0();
            this.f7004e.get(new a());
        }
    }

    public void initView() {
        ((TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781)).setTiTleText(R.string.bind_email);
        this.f7003d = (EditTextWithPrompt) findViewById(R.id.register_email_edittext);
        this.a = (TextView) findViewById(R.id.id_phone_bind_email_tip);
        r0();
        findViewById(R.id.id_phone_bind_email_btn).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() == R.id.id_phone_bind_email_btn) {
            r0();
            x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_phone_bind_email);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        s0(this.f7003d);
        PhoneBindEmail phoneBindEmail = this.f7004e;
        if (phoneBindEmail != null) {
            phoneBindEmail.cancel(true);
        }
        super.onDestroy();
    }
}
