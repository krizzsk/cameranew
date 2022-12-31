package us.pinguo.user.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.user.R;
import us.pinguo.user.ui.view.EditTextWithPrompt;
/* loaded from: classes6.dex */
public class PGEmailFindPasswordActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private EditTextWithPrompt f12404d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f12405e = null;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.user.request.g f12406f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends us.pinguo.foundation.ui.g {
        a() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PGEmailFindPasswordActivity.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends j.a.c.b.d<Void> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r2) {
            PGEmailFindPasswordActivity.this.q0();
            PGEmailFindPasswordActivity.this.setResult(-1);
            PGEmailFindPasswordActivity.this.finish();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            PGEmailFindPasswordActivity.this.q0();
            String a = exc instanceof Fault ? us.pinguo.user.api.f0.a(PGEmailFindPasswordActivity.this, ((Fault) exc).getStatus()) : null;
            if (TextUtils.isEmpty(a)) {
                PGEmailFindPasswordActivity.this.v0(PGEmailFindPasswordActivity.this.getString(R.string.pg_login_network_exception));
            } else {
                PGEmailFindPasswordActivity.this.u0(a);
            }
        }
    }

    private void x0(Context context) {
        String obj = this.f12404d.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            u0(getString(R.string.pg_login_email_empty));
        } else if (!us.pinguo.util.t.a(obj)) {
            u0(getString(R.string.pg_login_email_format_error));
        } else {
            us.pinguo.user.request.g gVar = this.f12406f;
            if (gVar != null) {
                gVar.cancel(true);
            }
            this.f12406f = new us.pinguo.user.request.g(context, obj);
            t0();
            this.f12406f.get(new b());
        }
    }

    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.cloud_native_find_password);
        this.a = (TextView) findViewById(R.id.id_find_password_error_prompt_text);
        r0();
        EditTextWithPrompt editTextWithPrompt = (EditTextWithPrompt) findViewById(R.id.id_find_password_input_text);
        this.f12404d = editTextWithPrompt;
        editTextWithPrompt.addTextChangedListener(new a());
        findViewById(R.id.id_find_password_btn).setOnClickListener(this);
        if (TextUtils.isEmpty(this.f12405e)) {
            return;
        }
        this.f12404d.setText(this.f12405e);
        this.f12404d.setSelection(this.f12405e.length());
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        view.setClickable(false);
        r0.d(view, true, 500);
        if (id == R.id.id_find_password_btn) {
            s0(this.f12404d);
            x0(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_find_password);
        if (bundle != null) {
            this.f12405e = bundle.getString(NotificationCompat.CATEGORY_EMAIL);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.f12405e = intent.getStringExtra(NotificationCompat.CATEGORY_EMAIL);
            }
        }
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        us.pinguo.user.request.g gVar = this.f12406f;
        if (gVar != null) {
            gVar.cancel(true);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        s0(this.f12404d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String obj = this.f12404d.getText().toString();
        if (TextUtils.isEmpty(obj) && !TextUtils.isEmpty(this.f12405e)) {
            obj = this.f12405e;
        }
        bundle.putString(NotificationCompat.CATEGORY_EMAIL, obj);
    }
}
