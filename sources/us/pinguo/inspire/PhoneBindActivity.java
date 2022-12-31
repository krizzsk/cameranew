package us.pinguo.inspire;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonSyntaxException;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import org.slf4j.Marker;
import rx.Observable;
import rx.functions.Action1;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.module.contact.PhoneBindLoader;
import us.pinguo.inspire.module.contact.entry.PhoneBindResponse;
import us.pinguo.inspire.profile.CountryZone;
import us.pinguo.user.GetUserInfo;
import us.pinguo.user.User;
import us.pinguo.user.api.f0;
import us.pinguo.user.ui.view.CompatibleToolbar;
import us.pinguo.user.util.BaseInfoResult;
/* loaded from: classes4.dex */
public class PhoneBindActivity extends InspireBaseActivity implements View.OnClickListener, us.pinguo.user.util.g {
    private EditText a;
    private EditText b;
    private EditText c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11211d;

    /* renamed from: e  reason: collision with root package name */
    private TextInputLayout f11212e;

    /* renamed from: f  reason: collision with root package name */
    private TextInputLayout f11213f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f11214g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f11215h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<CountryZone> f11216i;

    /* renamed from: j  reason: collision with root package name */
    private EditText f11217j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f11218k;

    /* renamed from: l  reason: collision with root package name */
    private ViewGroup f11219l;
    private boolean o;
    private int q;
    private boolean m = false;
    private int n = 86;
    private Runnable p = new a();

    /* loaded from: classes4.dex */
    class a implements Runnable {

        /* renamed from: us.pinguo.inspire.PhoneBindActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class RunnableC0401a implements Runnable {
            RunnableC0401a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PhoneBindActivity.this.f11214g.setText(String.format(PhoneBindActivity.this.getResources().getString(us.pinguo.c360.i18n.R.string.aready_send), Integer.valueOf(PhoneBindActivity.this.q)));
                PhoneBindActivity.this.q--;
                PhoneBindActivity.this.Q0();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PhoneBindActivity.this.runOnUiThread(new RunnableC0401a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends j.a.c.b.d<Void> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnClickListener {
            final /* synthetic */ User.Info a;

            a(User.Info info) {
                this.a = info;
            }

            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                PhoneBindActivity.this.x0(this.a.mobile);
            }
        }

        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(Void r6) {
            User.Info h2;
            if (((BaseActivity) PhoneBindActivity.this).pgDistroy || (h2 = User.d().h()) == null) {
                return;
            }
            if (TextUtils.isEmpty(h2.mobile)) {
                PhoneBindActivity.this.f11214g.setTextColor(ContextCompat.getColor(PhoneBindActivity.this, us.pinguo.ui.R.color.blue_common));
                PhoneBindActivity.this.f11214g.setEnabled(true);
                return;
            }
            PhoneBindActivity phoneBindActivity = PhoneBindActivity.this;
            us.pinguo.foundation.utils.w.l(phoneBindActivity, phoneBindActivity.getString(us.pinguo.user.R.string.no_need_to_bind_again), PhoneBindActivity.this.getString(us.pinguo.user.R.string.share_ok), null, new a(h2));
        }

        @Override // j.a.c.b.d
        public void onError(Exception exc) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends us.pinguo.foundation.ui.g {
        c() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PhoneBindActivity.this.R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends us.pinguo.foundation.ui.g {
        d() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PhoneBindActivity.this.R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class e extends us.pinguo.foundation.ui.g {
        e() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PhoneBindActivity.this.R0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class f {
        ArrayList<CountryZone> a;

        f() {
        }
    }

    private InputStream A0(Context context) throws IOException {
        Locale locale = context.getResources().getConfiguration().locale;
        String country = locale.getCountry();
        String language = locale.getLanguage();
        if ("zh".equals(language) && "CN".equals(country)) {
            return Inspire.a().getAssets().open("cc_zh.json");
        }
        if ("zh".equals(language)) {
            return Inspire.a().getAssets().open("cc_tw.json");
        }
        return Inspire.a().getAssets().open("cc_en.json");
    }

    private void B0() {
        new GetUserInfo(this).get(new b());
    }

    private void D0() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    private void E0() {
        try {
            if (this.f11216i == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(A0(this));
                this.f11216i = ((f) new com.google.gson.e().h(inputStreamReader, f.class)).a;
                inputStreamReader.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0(String str) {
        us.pinguo.common.log.a.d("zhouwei", "bind phone：" + str, new Object[0]);
        x0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        if (th.getCause() instanceof JsonSyntaxException) {
            String message = ((VolleyError) th).getMessage();
            us.pinguo.common.log.a.m("zhouwei", "json:" + message, new Object[0]);
            this.f11213f.setError(f0.a(this, PhoneBindResponse.parseGson(message).status));
            this.b.setHint("");
            this.f11213f.setHint("");
            return;
        }
        S0(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0(Boolean bool) {
        us.pinguo.common.log.a.d("zhouwei", "verifyCode:" + bool, new Object[0]);
        if (bool.booleanValue()) {
            y0();
            this.f11214g.setTextColor(getResources().getColor(us.pinguo.user.R.color.send_code_text_color));
            this.q = 60;
        } else {
            this.q = 0;
            j0.d(getString(us.pinguo.user.R.string.get_verfiy_code_error));
        }
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void M0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        S0(th);
        this.q = 0;
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(View view) {
        VdsAgent.lambdaOnClick(view);
        D0();
        onBackPressed();
    }

    private boolean P0() {
        User.Info h2 = User.d().h();
        return (h2 == null || h2.setPass == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        if (this.q <= 0) {
            this.f11214g.setEnabled(true);
            this.f11214g.setTextColor(getResources().getColor(us.pinguo.user.R.color.send_code_can_user_color));
            this.f11214g.setText(us.pinguo.c360.i18n.R.string.send_again);
            return;
        }
        this.f11214g.removeCallbacks(this.p);
        this.f11214g.postDelayed(this.p, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        if (z0()) {
            this.f11211d.setBackgroundResource(us.pinguo.user.R.drawable.bind_phone_btn_shape_select_user);
            this.f11211d.setTextColor(getResources().getColor(us.pinguo.ui.R.color.white));
            this.f11211d.setEnabled(true);
        } else {
            this.f11211d.setBackgroundColor(getResources().getColor(us.pinguo.ui.R.color.bind_color_unable_bg));
            this.f11211d.setTextColor(getResources().getColor(us.pinguo.ui.R.color.unable_text_color));
            this.f11211d.setEnabled(false);
        }
        this.f11214g.setEnabled(!TextUtils.isEmpty(this.a.getText().toString().trim()));
    }

    private void S0(Throwable th) {
        Fault fault;
        if (!(th instanceof Fault) || (fault = (Fault) th) == null) {
            return;
        }
        this.f11213f.setError(f0.a(this, fault.getStatus()));
        this.f11213f.setHint("");
        this.b.setHint("");
    }

    private void initView() {
        EditText editText = (EditText) findViewById(us.pinguo.user.R.id.edt_input_zone);
        this.f11217j = editText;
        editText.setHint(getString(us.pinguo.c360.i18n.R.string.default_country_zone));
        this.f11217j.setEnabled(false);
        TextView textView = (TextView) findViewById(us.pinguo.user.R.id.phone_bind_prefix);
        this.f11218k = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(us.pinguo.user.R.id.phone_bind_select_code);
        this.f11215h = imageView;
        imageView.setOnClickListener(this);
        this.a = (EditText) findViewById(us.pinguo.user.R.id.edt_input_phone);
        this.b = (EditText) findViewById(us.pinguo.user.R.id.edt_input_verify_code);
        this.c = (EditText) findViewById(us.pinguo.user.R.id.edt_input_pwd);
        this.f11211d = (TextView) findViewById(us.pinguo.user.R.id.btn_finish_bind_phone);
        this.f11212e = (TextInputLayout) findViewById(us.pinguo.user.R.id.input_phone_text_layout);
        this.f11213f = (TextInputLayout) findViewById(us.pinguo.user.R.id.input_verify_code_text_layout);
        this.f11212e.setHintAnimationEnabled(false);
        this.f11213f.setHintAnimationEnabled(false);
        this.f11213f.setErrorEnabled(true);
        TextView textView2 = (TextView) findViewById(us.pinguo.user.R.id.phone_bind_send_verify_code);
        this.f11214g = textView2;
        textView2.setTextColor(ContextCompat.getColor(this, us.pinguo.ui.R.color.unable_text_color));
        this.f11214g.setEnabled(false);
        this.f11211d.setOnClickListener(this);
        this.f11214g.setOnClickListener(this);
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) findViewById(us.pinguo.user.R.id.phone_bind_toolbar);
        compatibleToolbar.setTitle(us.pinguo.user.R.string.phone_bind_text);
        compatibleToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindActivity.this.O0(view);
            }
        });
        this.a.addTextChangedListener(new c());
        this.b.addTextChangedListener(new d());
        this.c.addTextChangedListener(new e());
        this.f11219l = (ViewGroup) findViewById(us.pinguo.user.R.id.pwd_layout);
        boolean P0 = P0();
        this.m = P0;
        ViewGroup viewGroup = this.f11219l;
        int i2 = P0 ? 0 : 8;
        viewGroup.setVisibility(i2);
        VdsAgent.onSetViewVisibility(viewGroup, i2);
    }

    private void y0() {
        this.f11214g.setEnabled(false);
    }

    private boolean z0() {
        return ((this.m && TextUtils.isEmpty(this.c.getText().toString())) || TextUtils.isEmpty(this.a.getText().toString()) || TextUtils.isEmpty(this.b.getText().toString())) ? false : true;
    }

    public void C0(String str, int i2, String str2) {
        Observable<Boolean> verifyCode;
        if (TextUtils.isEmpty(str2)) {
            verifyCode = new PhoneBindLoader().getVerifyCode(str, i2);
        } else {
            verifyCode = new PhoneBindLoader().getVerifyCode(str, i2, str2);
        }
        addSubscription(verifyCode.subscribe(new Action1() { // from class: us.pinguo.inspire.t
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PhoneBindActivity.this.K0((Boolean) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.s
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PhoneBindActivity.this.M0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireRedirectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        CountryZone.ListBean listBean;
        super.onActivityResult(i2, i3, intent);
        if (i3 != 0 || intent == null || (listBean = (CountryZone.ListBean) intent.getParcelableExtra("returnData")) == null) {
            return;
        }
        this.f11217j.setText(listBean.b());
        this.f11217j.setHint("");
        TextView textView = this.f11218k;
        textView.setText(Marker.ANY_NON_NULL_MARKER + listBean.a());
        this.n = listBean.a();
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        String str;
        VdsAgent.onClick(this, view);
        if (view.getId() == us.pinguo.user.R.id.base_title_back) {
            D0();
            onBackPressed();
        } else if (view.getId() == us.pinguo.user.R.id.btn_finish_bind_phone) {
            String obj = this.a.getText().toString();
            String obj2 = this.b.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                j0.d(getString(us.pinguo.c360.i18n.R.string.error_empty_phone_info));
            } else if (TextUtils.isEmpty(obj2)) {
                j0.d(getString(us.pinguo.c360.i18n.R.string.error_empty_code_info));
            } else {
                D0();
                w0(obj, obj2, this.n, this.o);
            }
        } else if (view.getId() == us.pinguo.user.R.id.phone_bind_send_verify_code) {
            String obj3 = this.a.getText().toString();
            if (TextUtils.isEmpty(obj3)) {
                j0.d(getString(us.pinguo.c360.i18n.R.string.error_empty_phone_info));
                return;
            }
            if (this.m) {
                str = this.c.getText().toString();
                if (str.length() < 6 || str.length() > 20) {
                    j0.d(getString(us.pinguo.user.R.string.pg_login_password_prompt));
                    return;
                }
            } else {
                str = "";
            }
            this.f11214g.setTextColor(getResources().getColor(us.pinguo.user.R.color.send_code_text_color));
            this.q = 60;
            Q0();
            C0(obj3, this.n, str);
        } else if (view.getId() == us.pinguo.user.R.id.phone_bind_select_code || view.getId() == us.pinguo.user.R.id.phone_bind_prefix) {
            if (this.f11216i != null) {
                this.f11215h.setEnabled(true);
                Intent intent = new Intent(this, CountryZoneMoreActivity.class);
                intent.putParcelableArrayListExtra("countryZones", this.f11216i);
                startActivityForResult(intent, 0);
                return;
            }
            us.pinguo.common.log.a.m("intervalTime", "没有地区数据", new Object[0]);
            this.f11215h.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(us.pinguo.user.R.layout.phone_bind_layout);
        initView();
        E0();
        if (us.pinguo.user.Conditions.a()) {
            this.f11214g.setTextColor(ContextCompat.getColor(this, us.pinguo.ui.R.color.blue_common));
            this.f11214g.setEnabled(true);
        } else {
            B0();
        }
        us.pinguo.user.util.n.a.h(this);
    }

    @Override // us.pinguo.user.util.g
    public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
        this.o = baseInfoResult.isChina();
    }

    public void w0(String str, String str2, int i2, boolean z) {
        addSubscription(new PhoneBindLoader().phoneBind(str, str2, i2, z).subscribe(new Action1() { // from class: us.pinguo.inspire.p
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PhoneBindActivity.this.G0((String) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.u
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PhoneBindActivity.this.I0((Throwable) obj);
            }
        }));
    }

    public void x0(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bind_mobile", str);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }
}
