package us.pinguo.user.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.ui.view.EditTextWithPrompt;
/* loaded from: classes6.dex */
public class PGNewModifyPasswordActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    private ImageView f12418e;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.user.request.h f12420g;

    /* renamed from: h  reason: collision with root package name */
    private String f12421h;

    /* renamed from: i  reason: collision with root package name */
    private String f12422i;

    /* renamed from: j  reason: collision with root package name */
    private User.Info f12423j;

    /* renamed from: d  reason: collision with root package name */
    private EditTextWithPrompt f12417d = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12419f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends us.pinguo.foundation.ui.g {
        a() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PGNewModifyPasswordActivity.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            PGNewModifyPasswordActivity pGNewModifyPasswordActivity = PGNewModifyPasswordActivity.this;
            pGNewModifyPasswordActivity.f12419f = !pGNewModifyPasswordActivity.f12419f;
            PGNewModifyPasswordActivity.this.f12418e.setSelected(PGNewModifyPasswordActivity.this.f12419f);
            Editable text = PGNewModifyPasswordActivity.this.f12417d.getText();
            PGNewModifyPasswordActivity.this.f12417d.setInputType((PGNewModifyPasswordActivity.this.f12419f ? IjkMediaMeta.FF_PROFILE_H264_HIGH_444 : 128) | 1);
            PGNewModifyPasswordActivity.this.f12417d.setSelection(text.length());
            PGNewModifyPasswordActivity.this.f12417d.setTypeface(Typeface.DEFAULT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c extends j.a.c.b.d<String> {
        c() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(String str) {
            PGNewModifyPasswordActivity.this.q0();
            if (PGNewModifyPasswordActivity.this.f12423j != null) {
                PGNewModifyPasswordActivity.this.f12423j.forgetPass = 0;
                PGNewModifyPasswordActivity.this.f12423j.token = str;
                User.v(PGNewModifyPasswordActivity.this.f12423j);
                PGNewModifyPasswordActivity.this.setResult(-1);
                PGNewModifyPasswordActivity.this.finish();
                return;
            }
            PGNewModifyPasswordActivity.this.finish();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            PGNewModifyPasswordActivity.this.q0();
            String a = exc instanceof Fault ? us.pinguo.user.api.f0.a(PGNewModifyPasswordActivity.this, ((Fault) exc).getStatus()) : null;
            if (TextUtils.isEmpty(a)) {
                PGNewModifyPasswordActivity.this.v0(PGNewModifyPasswordActivity.this.getString(R.string.pg_login_network_exception));
            } else {
                PGNewModifyPasswordActivity.this.u0(a);
            }
        }
    }

    private void C0() {
        s0(this.f12417d);
        String obj = this.f12417d.getText().toString();
        if (!us.pinguo.util.q.f(this)) {
            v0(getString(R.string.pg_login_network_exception));
        } else if (TextUtils.isEmpty(obj)) {
            u0(getString(R.string.pg_login_password_empty));
        } else if (obj.length() >= 6 && obj.length() <= 20) {
            us.pinguo.user.request.h hVar = this.f12420g;
            if (hVar != null) {
                hVar.cancel(true);
            }
            this.f12420g = new us.pinguo.user.request.h(this, obj, this.f12421h, this.f12422i);
            t0();
            this.f12420g.get(new c());
        } else {
            u0(getString(R.string.pg_login_password_prompt));
        }
    }

    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(R.string.set_new_passowrd);
        EditTextWithPrompt editTextWithPrompt = (EditTextWithPrompt) findViewById(R.id.register_password_edittext);
        this.f12417d = editTextWithPrompt;
        editTextWithPrompt.setTypeface(Typeface.DEFAULT);
        this.f12417d.addTextChangedListener(new a());
        ImageView imageView = (ImageView) findViewById(R.id.register_password_eye);
        this.f12418e = imageView;
        imageView.setOnClickListener(new b());
        findViewById(R.id.id_modify_password_btn).setOnClickListener(this);
        this.a = (TextView) findViewById(R.id.id_modify_password_error_prompt_text);
        r0();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        int id = view.getId();
        view.setClickable(false);
        r0.d(view, true, 500);
        if (id == R.id.id_modify_password_btn) {
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_modify_password);
        User d2 = User.d();
        if (d2.q()) {
            User.Info h2 = d2.h();
            this.f12423j = h2;
            this.f12421h = h2.userId;
            this.f12422i = h2.token;
            User.s();
        } else {
            finish();
        }
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        s0(this.f12417d);
        us.pinguo.user.request.h hVar = this.f12420g;
        if (hVar != null) {
            hVar.cancel(true);
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }
}
