package us.pinguo.user.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.user.R;
import us.pinguo.user.ui.view.EditTextWithPrompt;
/* loaded from: classes6.dex */
public class PGPhoneFindPasswordActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private EditTextWithPrompt f12424d;

    /* renamed from: e  reason: collision with root package name */
    private String f12425e;

    /* renamed from: f  reason: collision with root package name */
    private AlertDialog f12426f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.user.request.i f12427g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends us.pinguo.foundation.ui.g {
        a() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PGPhoneFindPasswordActivity.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends j.a.c.b.d<Void> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r1) {
            PGPhoneFindPasswordActivity.this.q0();
            PGPhoneFindPasswordActivity.this.A0();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PGPhoneFindPasswordActivity.this.q0();
            if (exc instanceof Fault) {
                Fault fault = (Fault) exc;
                if (fault.getStatus() == 10536) {
                    PGPhoneFindPasswordActivity.this.z0();
                    return;
                } else if (fault.getStatus() == 10543) {
                    PGPhoneFindPasswordActivity.this.A0();
                    return;
                } else {
                    str = us.pinguo.user.api.f0.a(PGPhoneFindPasswordActivity.this, fault.getStatus());
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                PGPhoneFindPasswordActivity.this.v0(PGPhoneFindPasswordActivity.this.getString(R.string.pg_login_network_exception));
                return;
            }
            PGPhoneFindPasswordActivity.this.u0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        c(PGPhoneFindPasswordActivity pGPhoneFindPasswordActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        String obj = this.f12424d.getText().toString();
        Intent intent = new Intent(this, PGPhoneVerifyActivity.class);
        intent.putExtra("phoneNumber", obj);
        startActivityForResult(intent, 1000);
    }

    private void B0() {
        s0(this.f12424d);
        if (!us.pinguo.util.q.f(this)) {
            v0(getString(R.string.pg_login_network_exception));
            return;
        }
        String obj = this.f12424d.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            u0(getString(R.string.pg_login_phone_number_empty));
        } else if (!us.pinguo.util.t.b(obj)) {
            u0(getString(R.string.pg_login_phone_number_format_error));
        } else {
            us.pinguo.user.request.i iVar = this.f12427g;
            if (iVar != null) {
                iVar.cancel(true);
            }
            this.f12427g = new us.pinguo.user.request.i(this, obj);
            t0();
            this.f12427g.get(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        AlertDialog alertDialog = this.f12426f;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.f12426f = us.pinguo.foundation.utils.w.g(this, -999, R.string.pg_login_phone_number_not_exist, R.string.share_ok, -999, new c(this));
        }
    }

    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.pg_login_phone_input_number);
        this.f12424d = (EditTextWithPrompt) findViewById(R.id.id_phone_findpassword_input_text);
        if (!TextUtils.isEmpty(this.f12425e)) {
            this.f12424d.setText(this.f12425e);
        }
        this.a = (TextView) findViewById(R.id.id_phone_find_password_error_prompt_text);
        r0();
        this.f12424d.addTextChangedListener(new a());
        findViewById(R.id.id_phone_findpassword_btn).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1000 && i3 == -1) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        view.setClickable(false);
        r0.d(view, true, 500);
        if (id == R.id.id_phone_findpassword_btn) {
            B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_phone_findpassword);
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.f12425e = intent.getStringExtra("phoneNumber");
            }
        } else {
            this.f12425e = bundle.getString("phoneNumber");
        }
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        us.pinguo.user.request.i iVar = this.f12427g;
        if (iVar != null) {
            iVar.cancel(true);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        s0(this.f12424d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("phoneNumber", this.f12425e);
    }
}
