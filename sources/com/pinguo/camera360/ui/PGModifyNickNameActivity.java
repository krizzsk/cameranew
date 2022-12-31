package com.pinguo.camera360.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.ui.view.EditTextWithFork;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.ui.g;
import us.pinguo.user.User;
import us.pinguo.user.api.f0;
import us.pinguo.user.ui.PGLoginBaseActivity;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
@Deprecated
/* loaded from: classes3.dex */
public class PGModifyNickNameActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private EditTextWithFork f6998d;

    /* renamed from: e  reason: collision with root package name */
    private j.a.c.b.b<Void> f6999e;

    /* renamed from: f  reason: collision with root package name */
    private Button f7000f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            PGModifyNickNameActivity pGModifyNickNameActivity = PGModifyNickNameActivity.this;
            pGModifyNickNameActivity.s0(pGModifyNickNameActivity.f6998d);
            PGModifyNickNameActivity pGModifyNickNameActivity2 = PGModifyNickNameActivity.this;
            pGModifyNickNameActivity2.z0(pGModifyNickNameActivity2.f6998d.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends g {
        b() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            PGModifyNickNameActivity.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends j.a.c.b.d<Void> {
        c() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r1) {
            PGModifyNickNameActivity.this.q0();
            PGModifyNickNameActivity.this.finish();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PGModifyNickNameActivity.this.q0();
            if (exc instanceof Fault) {
                Fault fault = (Fault) exc;
                if (fault.getStatus() == 420) {
                    Intent intent = new Intent();
                    intent.putExtra("destroy_account", TypedValues.CycleType.TYPE_EASING);
                    PGModifyNickNameActivity.this.setResult(1001, intent);
                    return;
                } else if (fault.getStatus() == 10012) {
                    PGModifyNickNameActivity pGModifyNickNameActivity = PGModifyNickNameActivity.this;
                    pGModifyNickNameActivity.u0(pGModifyNickNameActivity.getString(R.string.personal_infomation_nickname_exist));
                    return;
                } else {
                    str = f0.a(PGModifyNickNameActivity.this, fault.getStatus());
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                PGModifyNickNameActivity.this.v0(PGModifyNickNameActivity.this.getString(R.string.modify_nickname_redefine_fail));
                return;
            }
            PGModifyNickNameActivity.this.u0(str);
        }
    }

    private void A0(String str) {
        j.a.c.b.b<Void> bVar = this.f6999e;
        if (bVar != null) {
            bVar.cancel(true);
        }
        this.f6999e = User.d().c(str);
        t0();
        this.f6999e.get(new c());
    }

    private void B0() {
        String str;
        User.Info h2 = User.d().h();
        if (h2 == null || (str = h2.nickname) == null || str.isEmpty()) {
            return;
        }
        this.f6998d.setText(str);
        EditTextWithFork editTextWithFork = this.f6998d;
        editTextWithFork.setSelection(editTextWithFork.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(String str) {
        if (!q.f(getApplicationContext())) {
            v0(getString(R.string.pg_login_network_exception));
        } else if (TextUtils.isEmpty(str)) {
            u0(getString(R.string.personal_infomation_nickname_input_null));
        } else {
            A0(str);
        }
    }

    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.modify_nickname_title);
        Button button = (Button) findViewById(R.id.login_modify_nickname_btn);
        this.f7000f = button;
        button.setOnClickListener(new a());
        EditTextWithFork editTextWithFork = (EditTextWithFork) findViewById(R.id.cloudLoginModifyInputNickname);
        this.f6998d = editTextWithFork;
        editTextWithFork.setClearButtonEvent();
        this.f6998d.addTextChangedListener(new b());
        this.a = (TextView) findViewById(R.id.id_tv_modify_nickname_tip);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() != R.id.title_right_img_btn) {
            return;
        }
        s0(this.f6998d);
        z0(this.f6998d.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.personal_modify_nickname);
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        initView();
        B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        s0(this.f6998d);
        j.a.c.b.b<Void> bVar = this.f6999e;
        if (bVar != null) {
            bVar.cancel(true);
        }
        super.onDestroy();
    }
}
