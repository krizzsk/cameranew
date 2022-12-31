package us.pinguo.user.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.ui.view.EditTextWithPrompt;
import us.pinguo.user.util.BaseInfoResult;
/* loaded from: classes6.dex */
public class PGPhoneVerifyActivity extends PGLoginBaseActivity implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    private TextView f12428d;

    /* renamed from: e  reason: collision with root package name */
    private Button f12429e;

    /* renamed from: f  reason: collision with root package name */
    private EditTextWithPrompt f12430f;

    /* renamed from: g  reason: collision with root package name */
    private AlertDialog f12431g;

    /* renamed from: h  reason: collision with root package name */
    private AlertDialog f12432h;

    /* renamed from: i  reason: collision with root package name */
    private AlertDialog f12433i;

    /* renamed from: j  reason: collision with root package name */
    private String f12434j;

    /* renamed from: k  reason: collision with root package name */
    private String f12435k;

    /* renamed from: l  reason: collision with root package name */
    private us.pinguo.user.request.m f12436l;
    private us.pinguo.user.request.l m;
    private g p;
    private boolean n = true;
    private int o = 60;
    private Handler q = new a();

    /* loaded from: classes6.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                PGPhoneVerifyActivity.this.o = 60;
                PGPhoneVerifyActivity.this.f12429e.setEnabled(true);
                PGPhoneVerifyActivity.this.f12429e.setText(R.string.pg_login_phone_resend_verify_code);
                return;
            }
            if (PGPhoneVerifyActivity.this.f12429e.isEnabled()) {
                PGPhoneVerifyActivity.this.f12429e.setEnabled(false);
            }
            PGPhoneVerifyActivity.A0(PGPhoneVerifyActivity.this);
            Button button = PGPhoneVerifyActivity.this.f12429e;
            button.setText(PGPhoneVerifyActivity.this.o + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnClickListener {
        b(PGPhoneVerifyActivity pGPhoneVerifyActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnClickListener {
        c(PGPhoneVerifyActivity pGPhoneVerifyActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnClickListener {
        d(PGPhoneVerifyActivity pGPhoneVerifyActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e extends j.a.c.b.d<Void> {
        e() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r3) {
            PGPhoneVerifyActivity.this.q0();
            if (User.d().h().forgetPass == 1) {
                PGPhoneVerifyActivity.this.startActivityForResult(new Intent(PGPhoneVerifyActivity.this, PGNewModifyPasswordActivity.class), 1088);
                return;
            }
            PGPhoneVerifyActivity.this.setResult(-1, null);
            PGPhoneVerifyActivity.this.finish();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PGPhoneVerifyActivity.this.q0();
            if (exc instanceof Fault) {
                int status = ((Fault) exc).getStatus();
                str = us.pinguo.user.api.f0.a(PGPhoneVerifyActivity.this, status);
                if (status == 10537) {
                    PGPhoneVerifyActivity.this.I0();
                    return;
                } else if (status == 10539) {
                    PGPhoneVerifyActivity.this.H0();
                    return;
                } else if (status == 10543) {
                    PGPhoneVerifyActivity.this.J0();
                    return;
                } else if (status == 10540) {
                    PGPhoneVerifyActivity.this.w0();
                    return;
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                PGPhoneVerifyActivity pGPhoneVerifyActivity = PGPhoneVerifyActivity.this;
                pGPhoneVerifyActivity.v0(pGPhoneVerifyActivity.getString(R.string.pg_login_network_exception));
                return;
            }
            PGPhoneVerifyActivity.this.u0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f extends j.a.c.b.d<Void> {
        f() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r3) {
            PGPhoneVerifyActivity.this.q0();
            if (PGPhoneVerifyActivity.this.p != null) {
                PGPhoneVerifyActivity.this.p.a(false);
            }
            PGPhoneVerifyActivity.this.p = new g();
            PGPhoneVerifyActivity.this.p.start();
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
            String str;
            PGPhoneVerifyActivity.this.q0();
            if (exc instanceof Fault) {
                int status = ((Fault) exc).getStatus();
                if (status == 10543) {
                    PGPhoneVerifyActivity.this.J0();
                    return;
                } else if (status == 10540) {
                    PGPhoneVerifyActivity.this.w0();
                    return;
                } else {
                    str = us.pinguo.user.api.f0.a(PGPhoneVerifyActivity.this, status);
                }
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = PGPhoneVerifyActivity.this.getString(R.string.pg_login_network_exception);
            }
            PGPhoneVerifyActivity.this.v0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class g extends Thread {
        private volatile boolean a;

        public g() {
            this.a = false;
            this.a = true;
        }

        public void a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            PGPhoneVerifyActivity.this.q.sendEmptyMessage(0);
            long j2 = currentTimeMillis;
            while (this.a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 - j2 > 1000) {
                    PGPhoneVerifyActivity.this.q.sendEmptyMessage(0);
                    j2 = currentTimeMillis2;
                }
                if (currentTimeMillis2 - currentTimeMillis > 60000) {
                    break;
                }
            }
            PGPhoneVerifyActivity.this.q.sendEmptyMessage(1);
        }
    }

    static /* synthetic */ int A0(PGPhoneVerifyActivity pGPhoneVerifyActivity) {
        int i2 = pGPhoneVerifyActivity.o;
        pGPhoneVerifyActivity.o = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        AlertDialog alertDialog = this.f12432h;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog g2 = us.pinguo.foundation.utils.w.g(this, -999, R.string.pg_login_phone_verify_code_expired, R.string.share_ok, -999, new c(this));
            this.f12432h = g2;
            g2.show();
            VdsAgent.showDialog(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        AlertDialog alertDialog = this.f12431g;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog g2 = us.pinguo.foundation.utils.w.g(this, -999, R.string.pg_login_phone_verify_error, R.string.share_ok, -999, new b(this));
            this.f12431g = g2;
            g2.show();
            VdsAgent.showDialog(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        AlertDialog alertDialog = this.f12433i;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog g2 = us.pinguo.foundation.utils.w.g(this, -999, R.string.status_errorcode10543, R.string.share_ok, -999, new d(this));
            this.f12433i = g2;
            g2.show();
            VdsAgent.showDialog(g2);
        }
    }

    private void K0() {
        us.pinguo.user.request.l lVar = this.m;
        if (lVar != null) {
            lVar.cancel(true);
        }
        this.m = new us.pinguo.user.request.l(this, this.f12434j);
        t0();
        this.m.get(new f());
    }

    private void L0(String str) {
        us.pinguo.user.request.m mVar = this.f12436l;
        if (mVar != null) {
            mVar.cancel(true);
        }
        t0();
        BaseInfoResult g2 = us.pinguo.user.util.n.a.g();
        us.pinguo.user.request.m mVar2 = new us.pinguo.user.request.m(this, this.f12434j, str, g2 != null ? g2.isChina() : false);
        this.f12436l = mVar2;
        mVar2.get(new e());
    }

    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.input_verify_code_title));
        this.f12428d = (TextView) findViewById(R.id.id_phone_number_verify_prompt);
        this.f12428d.setText(getString(R.string.pg_login_sms_verification_code_has_send, new Object[]{this.f12434j}));
        this.f12430f = (EditTextWithPrompt) findViewById(R.id.id_phone_verify_number);
        findViewById(R.id.id_phone_number_verify_btn).setOnClickListener(this);
        Button button = (Button) findViewById(R.id.id_phone_verify_number_resend);
        this.f12429e = button;
        button.setOnClickListener(this);
        this.a = (TextView) findViewById(R.id.id_phone_verify_number_error_prompt_text);
        r0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1088 && i3 == -1) {
            setResult(-1, intent);
            finish();
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        view.setClickable(false);
        r0.d(view, true, 500);
        int id = view.getId();
        if (id == R.id.id_phone_number_verify_btn) {
            s0(this.f12430f);
            String obj = this.f12430f.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                v0(getString(R.string.pg_login_phone_verify_code_empty));
            } else {
                L0(obj);
            }
        } else if (id == R.id.id_phone_verify_number_resend) {
            K0();
        }
    }

    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_phone_verify);
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.f12434j = intent.getStringExtra("phoneNumber");
                this.f12435k = intent.getStringExtra("phonePassword");
                this.n = intent.getBooleanExtra("regetVerifyCode", true);
            }
        } else {
            this.f12434j = bundle.getString("phoneNumber");
            this.f12435k = bundle.getString("phonePassword");
        }
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g gVar = this.p;
        if (gVar != null) {
            gVar.a(false);
        }
        s0(this.f12430f);
        us.pinguo.user.request.m mVar = this.f12436l;
        if (mVar != null) {
            mVar.cancel(true);
        }
        us.pinguo.user.request.l lVar = this.m;
        if (lVar != null) {
            lVar.cancel(true);
        }
        this.q.removeMessages(0);
        this.q.removeMessages(1);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.n) {
            this.n = false;
            g gVar = this.p;
            if (gVar != null) {
                gVar.a(false);
            }
            g gVar2 = new g();
            this.p = gVar2;
            gVar2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("phoneNumber", this.f12434j);
        bundle.putString("phonePassword", this.f12435k);
    }
}
