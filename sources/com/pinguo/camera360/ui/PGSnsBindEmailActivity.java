package com.pinguo.camera360.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.request.EmailBind;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.ui.g;
import us.pinguo.foundation.utils.r0;
import us.pinguo.user.User;
import us.pinguo.user.api.f0;
import us.pinguo.user.ui.PGLoginBaseActivity;
import us.pinguo.user.ui.view.CheckEmailViewGroup;
import us.pinguo.user.ui.view.EditTextWithPrompt;
import us.pinguo.util.q;
import us.pinguo.util.t;
import vStudio.Android.Camera360.R;
@Deprecated
/* loaded from: classes3.dex */
public class PGSnsBindEmailActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private CheckEmailViewGroup f7005d;

    /* renamed from: e  reason: collision with root package name */
    private EditTextWithPrompt f7006e;

    /* renamed from: f  reason: collision with root package name */
    private EditTextWithPrompt f7007f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f7008g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7009h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7010i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7011j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f7012k = 0;

    /* renamed from: l  reason: collision with root package name */
    private EmailBind f7013l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends g {
        a() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PGSnsBindEmailActivity.this.I0(1);
            PGSnsBindEmailActivity.this.K0(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        @Instrumented
        public void onFocusChange(View view, boolean z) {
            VdsAgent.onFocusChange(this, view, z);
            if (z) {
                return;
            }
            PGSnsBindEmailActivity.this.H0(PGSnsBindEmailActivity.this.f7006e.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends g {
        c() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (PGSnsBindEmailActivity.this.f7009h) {
                PGSnsBindEmailActivity.this.f7009h = false;
                return;
            }
            if (PGSnsBindEmailActivity.this.H0(PGSnsBindEmailActivity.this.f7006e.getText().toString())) {
                if (PGSnsBindEmailActivity.this.f7012k == 2 || PGSnsBindEmailActivity.this.f7012k == 3) {
                    PGSnsBindEmailActivity.this.I0(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends j.a.c.b.d<Void> {
        d() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r3) {
            a.h.a(true);
            PGSnsBindEmailActivity.this.q0();
            PGSnsBindEmailActivity.this.setResult(-1, null);
            PGSnsBindEmailActivity.this.finish();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PGSnsBindEmailActivity.this.q0();
            if (exc instanceof Fault) {
                Fault fault = (Fault) exc;
                if (fault.getStatus() == 420) {
                    Intent intent = new Intent();
                    intent.putExtra("destroy_account", TypedValues.CycleType.TYPE_EASING);
                    PGSnsBindEmailActivity.this.setResult(1001, intent);
                    return;
                }
                int status = fault.getStatus();
                if (status != 10518 && status != 10520) {
                    str = f0.a(PGSnsBindEmailActivity.this, status);
                } else {
                    str = PGSnsBindEmailActivity.this.getString(R.string.status_bind_errorcode10518);
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                PGSnsBindEmailActivity.this.f7012k = 3;
                PGSnsBindEmailActivity.this.v0(PGSnsBindEmailActivity.this.getString(R.string.pg_login_network_exception));
                return;
            }
            PGSnsBindEmailActivity.this.L0(str, 3);
        }
    }

    private void G0() {
        s0(this.f7006e);
        if (!q.f(this)) {
            v0(getString(R.string.pg_login_network_exception));
            return;
        }
        String obj = this.f7006e.getText().toString();
        String obj2 = this.f7007f.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            L0(getString(R.string.pg_login_email_empty), 1);
            K0(4);
        } else if (!t.a(obj)) {
            L0(getString(R.string.pg_login_email_format_error), 1);
            K0(4);
        } else {
            if (!this.f7011j) {
                if (TextUtils.isEmpty(obj2)) {
                    L0(getString(R.string.pg_login_password_empty), 2);
                    return;
                } else if (obj2.length() < 6 || obj2.length() > 20) {
                    L0(getString(R.string.pg_login_password_prompt), 2);
                    return;
                }
            }
            EmailBind emailBind = this.f7013l;
            if (emailBind != null) {
                emailBind.cancel(true);
            }
            t0();
            if (this.f7011j) {
                this.f7013l = new EmailBind(this, obj);
            } else {
                this.f7013l = new EmailBind(this, obj, obj2);
            }
            this.f7013l.get(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H0(String str) {
        if (TextUtils.isEmpty(str)) {
            L0(getString(R.string.pg_login_email_empty), 1);
            return false;
        } else if (t.a(str)) {
            return true;
        } else {
            L0(getResources().getString(R.string.pg_login_email_format_error), 1);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(int i2) {
        int i3 = this.f7012k;
        if (i3 == 1 && i2 == 2) {
            return;
        }
        if (i3 == 2 && i2 == 1) {
            return;
        }
        r0();
    }

    private void J0() {
        this.f7006e.addTextChangedListener(new a());
        this.f7006e.setOnFocusChangeListener(new b());
        this.f7007f.addTextChangedListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i2) {
        this.f7005d.f(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(String str, int i2) {
        this.f7012k = i2;
        if (i2 == 1) {
            K0(4);
        }
        u0(str);
    }

    public void initView() {
        ((TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781)).setTiTleText(R.string.bind_email);
        this.f7005d = (CheckEmailViewGroup) findViewById(R.id.id_sns_bind_email_input_parent);
        this.f7006e = (EditTextWithPrompt) findViewById(R.id.register_email_edittext);
        EditTextWithPrompt editTextWithPrompt = (EditTextWithPrompt) findViewById(R.id.register_password_edittext);
        this.f7007f = editTextWithPrompt;
        editTextWithPrompt.setTypeface(Typeface.DEFAULT);
        J0();
        this.a = (TextView) findViewById(R.id.id_sns_bind_email_error_prompt_text);
        ImageView imageView = (ImageView) findViewById(R.id.register_password_eye);
        this.f7008g = imageView;
        imageView.setOnClickListener(this);
        findViewById(R.id.id_sns_bind_email_bind_btn).setOnClickListener(this);
        if (this.f7011j) {
            View findViewById = findViewById(R.id.id_sns_bind_email_password_parent);
            findViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(findViewById, 8);
            return;
        }
        View findViewById2 = findViewById(R.id.id_sns_bind_email_password_parent);
        findViewById2.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById2, 0);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        view.setClickable(false);
        r0.d(view, true, 500);
        if (id == R.id.id_sns_bind_email_bind_btn) {
            r0();
            G0();
        } else if (id == R.id.register_password_eye) {
            this.f7009h = true;
            boolean z = !this.f7010i;
            this.f7010i = z;
            this.f7008g.setSelected(z);
            Editable text = this.f7007f.getText();
            this.f7007f.setInputType(1 | (this.f7010i ? IjkMediaMeta.FF_PROFILE_H264_HIGH_444 : 128));
            this.f7007f.setSelection(text.length());
            this.f7007f.setTypeface(Typeface.DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_sns_bind_email);
        User d2 = User.d();
        if (d2.n()) {
            this.f7011j = d2.h().setPass == 1;
            initView();
            return;
        }
        throw new RuntimeException("用户没有登录，不能够进行绑定操作");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f7005d.e();
        s0(this.f7006e);
        EmailBind emailBind = this.f7013l;
        if (emailBind != null) {
            emailBind.cancel(true);
        }
        super.onDestroy();
    }
}
