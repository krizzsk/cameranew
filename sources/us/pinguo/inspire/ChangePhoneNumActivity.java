package us.pinguo.inspire;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.google.gson.JsonSyntaxException;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.x;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.functions.Action1;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.k0;
import us.pinguo.inspire.module.contact.PhoneBindLoader;
import us.pinguo.inspire.module.contact.entry.PhoneBindResponse;
import us.pinguo.user.api.f0;
import us.pinguo.user.model.CityZones;
import us.pinguo.user.ui.view.CompatibleToolbar;
/* compiled from: ChangePhoneNumActivity.kt */
/* loaded from: classes4.dex */
public final class ChangePhoneNumActivity extends BaseSplitActivity implements View.OnClickListener {
    private int c;
    public Map<Integer, View> a = new LinkedHashMap();
    private int b = 86;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f11194d = new Runnable() { // from class: us.pinguo.inspire.b
        @Override // java.lang.Runnable
        public final void run() {
            ChangePhoneNumActivity.K0(ChangePhoneNumActivity.this);
        }
    };

    /* compiled from: ChangePhoneNumActivity.kt */
    /* loaded from: classes4.dex */
    public static final class a extends us.pinguo.foundation.ui.g {
        a() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            kotlin.jvm.internal.s.h(s, "s");
            ChangePhoneNumActivity.this.M0();
        }
    }

    /* compiled from: ChangePhoneNumActivity.kt */
    /* loaded from: classes4.dex */
    public static final class b extends us.pinguo.foundation.ui.g {
        b() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            kotlin.jvm.internal.s.h(s, "s");
            ChangePhoneNumActivity.this.M0();
        }
    }

    /* compiled from: ChangePhoneNumActivity.kt */
    /* loaded from: classes4.dex */
    public static final class c extends us.pinguo.foundation.ui.g {
        c() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            kotlin.jvm.internal.s.h(s, "s");
            ChangePhoneNumActivity.this.M0();
        }
    }

    /* compiled from: ChangePhoneNumActivity.kt */
    /* loaded from: classes4.dex */
    public static final class d implements AdapterView.OnItemSelectedListener {
        final /* synthetic */ us.pinguo.user.ui.p0.a b;

        d(us.pinguo.user.ui.p0.a aVar) {
            this.b = aVar;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        @Instrumented
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            int i3;
            VdsAgent.onItemSelected(this, adapterView, view, i2, j2);
            ChangePhoneNumActivity changePhoneNumActivity = ChangePhoneNumActivity.this;
            try {
                Integer valueOf = Integer.valueOf(this.b.getItem(i2).getCc());
                kotlin.jvm.internal.s.g(valueOf, "{\n                      …                        }");
                i3 = valueOf.intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                i3 = 86;
            }
            changePhoneNumActivity.b = i3;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private final void A0() {
        Object systemService = getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(ChangePhoneNumActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.A0();
        this$0.onBackPressed();
    }

    private final void J0() {
        if (this.c <= 0) {
            int i2 = us.pinguo.user.R.id.change_phone_send_verify_code;
            ((RelativeLayout) _$_findCachedViewById(i2)).setEnabled(true);
            ((RelativeLayout) _$_findCachedViewById(i2)).setBackgroundResource(us.pinguo.user.R.drawable.fast_login_c360_btn_border);
            int i3 = us.pinguo.user.R.id.change_phone_send_verify_code_text;
            ((TextView) _$_findCachedViewById(i3)).setTextColor(getResources().getColor(us.pinguo.user.R.color.send_code_can_user_color));
            ((TextView) _$_findCachedViewById(i3)).setText(us.pinguo.user.R.string.send_again);
            return;
        }
        int i4 = us.pinguo.user.R.id.change_phone_send_verify_code_text;
        ((TextView) _$_findCachedViewById(i4)).removeCallbacks(this.f11194d);
        ((TextView) _$_findCachedViewById(i4)).postDelayed(this.f11194d, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(final ChangePhoneNumActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.runOnUiThread(new Runnable() { // from class: us.pinguo.inspire.a
            @Override // java.lang.Runnable
            public final void run() {
                ChangePhoneNumActivity.L0(ChangePhoneNumActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(ChangePhoneNumActivity this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        x xVar = x.a;
        String string = this$0.getResources().getString(us.pinguo.user.R.string.aready_send);
        kotlin.jvm.internal.s.g(string, "resources.getString(us.p…ser.R.string.aready_send)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this$0.c)}, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        ((TextView) this$0._$_findCachedViewById(us.pinguo.user.R.id.change_phone_send_verify_code_text)).setText(format);
        this$0.c--;
        this$0.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0() {
        if (v0()) {
            int i2 = us.pinguo.user.R.id.child_chang_phone_btn;
            ((RelativeLayout) _$_findCachedViewById(i2)).setBackgroundResource(us.pinguo.user.R.drawable.fast_phone_bind_btn_border);
            ((RelativeLayout) _$_findCachedViewById(i2)).setEnabled(true);
            return;
        }
        int i3 = us.pinguo.user.R.id.child_chang_phone_btn;
        ((RelativeLayout) _$_findCachedViewById(i3)).setBackgroundResource(us.pinguo.user.R.drawable.fast_phone_bind_btn_unable_border);
        ((RelativeLayout) _$_findCachedViewById(i3)).setEnabled(false);
    }

    private final void N0(Throwable th) {
        if (th instanceof Fault) {
            j0.d(f0.a(this, ((Fault) th).getStatus()));
        }
    }

    private final void initView() {
        int i2 = us.pinguo.user.R.id.change_phone_toolbar;
        ((CompatibleToolbar) _$_findCachedViewById(i2)).setTitle(us.pinguo.user.R.string.change_phone);
        ((CompatibleToolbar) _$_findCachedViewById(i2)).setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        ((CompatibleToolbar) _$_findCachedViewById(i2)).setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangePhoneNumActivity.B0(ChangePhoneNumActivity.this, view);
            }
        });
        ((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edit_old_phone)).addTextChangedListener(new a());
        ((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edit_input_phone)).addTextChangedListener(new b());
        ((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edt_input_verify_code)).addTextChangedListener(new c());
        ((RelativeLayout) _$_findCachedViewById(us.pinguo.user.R.id.child_chang_phone_btn)).setOnClickListener(this);
        ((RelativeLayout) _$_findCachedViewById(us.pinguo.user.R.id.change_phone_send_verify_code)).setOnClickListener(this);
        try {
            String w0 = w0();
            if (w0 != null) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONObject(w0).getJSONArray("list");
                int i3 = 0;
                int length = jSONArray.length();
                while (i3 < length) {
                    int i4 = i3 + 1;
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    arrayList.add(new CityZones(jSONObject.getString("name"), jSONObject.getString("code"), jSONObject.getString("cc")));
                    i3 = i4;
                }
                us.pinguo.user.ui.p0.a aVar = new us.pinguo.user.ui.p0.a(this, arrayList);
                int i5 = us.pinguo.user.R.id.zone_spinner;
                ((Spinner) _$_findCachedViewById(i5)).setAdapter((SpinnerAdapter) aVar);
                ((Spinner) _$_findCachedViewById(i5)).setOnItemSelectedListener(new d(aVar));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(ChangePhoneNumActivity this$0, String phoneNumber) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(phoneNumber, "phoneNumber");
        ((TextView) this$0._$_findCachedViewById(us.pinguo.user.R.id.change_phone_send_verify_code_text)).removeCallbacks(this$0.f11194d);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(ChangePhoneNumActivity this$0, Throwable error) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(error, "error");
        us.pinguo.foundation.e.e(error);
        us.pinguo.common.log.a.f(error);
        if (error.getCause() instanceof JsonSyntaxException) {
            j0.d(f0.a(this$0, PhoneBindResponse.parseGson(((VolleyError) error).getMessage()).status));
        } else {
            this$0.N0(error);
        }
    }

    private final boolean v0() {
        return (TextUtils.isEmpty(((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edit_old_phone)).getText().toString()) || TextUtils.isEmpty(((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edit_input_phone)).getText().toString()) || TextUtils.isEmpty(((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edt_input_verify_code)).getText().toString())) ? false : true;
    }

    private final String w0() {
        String str;
        Locale locale = getResources().getConfiguration().locale;
        String country = locale.getCountry();
        String language = locale.getLanguage();
        if (kotlin.jvm.internal.s.c("zh", language) && kotlin.jvm.internal.s.c("CN", country)) {
            str = "city_zh.json";
        } else {
            str = kotlin.jvm.internal.s.c("zh", language) ? "city_tw.json" : "city_en.json";
        }
        return us.pinguo.foundation.utils.e.b(us.pinguo.util.v.a(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(ChangePhoneNumActivity this$0, boolean z) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.common.log.a.e(kotlin.jvm.internal.s.q("==========getVerifyCode==========:", Boolean.valueOf(z)), new Object[0]);
        if (z) {
            int i2 = us.pinguo.user.R.id.change_phone_send_verify_code;
            ((RelativeLayout) this$0._$_findCachedViewById(i2)).setEnabled(false);
            ((RelativeLayout) this$0._$_findCachedViewById(i2)).setBackgroundResource(us.pinguo.user.R.drawable.fast_login_c360_unable_btn_border);
            ((TextView) this$0._$_findCachedViewById(us.pinguo.user.R.id.change_phone_send_verify_code_text)).setTextColor(this$0.getResources().getColor(us.pinguo.user.R.color.send_code_text_color));
            this$0.c = 60;
        } else {
            this$0.c = 0;
            j0.d(this$0.getString(us.pinguo.user.R.string.get_verfiy_code_error));
        }
        this$0.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(ChangePhoneNumActivity this$0, Throwable th) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        this$0.N0(th);
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        CharSequence H0;
        CharSequence H02;
        CharSequence H03;
        CharSequence H04;
        CharSequence H05;
        CharSequence H06;
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i2 = us.pinguo.user.R.id.change_phone_send_verify_code;
        if (valueOf != null && valueOf.intValue() == i2) {
            int i3 = us.pinguo.user.R.id.edit_input_phone;
            String obj = ((EditText) _$_findCachedViewById(i3)).getText().toString();
            int i4 = us.pinguo.user.R.id.edit_old_phone;
            String obj2 = ((EditText) _$_findCachedViewById(i4)).getText().toString();
            H0 = StringsKt__StringsKt.H0(obj2);
            if (!(H0.toString().length() == 0)) {
                H02 = StringsKt__StringsKt.H0(obj2);
                if (H02.toString().length() >= 6) {
                    H03 = StringsKt__StringsKt.H0(obj2);
                    if (H03.toString().length() <= 15) {
                        H04 = StringsKt__StringsKt.H0(obj);
                        if (!(H04.toString().length() == 0)) {
                            H05 = StringsKt__StringsKt.H0(obj);
                            if (H05.toString().length() >= 6) {
                                H06 = StringsKt__StringsKt.H0(obj);
                                if (H06.toString().length() <= 15) {
                                    x0(((EditText) _$_findCachedViewById(i3)).getText().toString(), ((EditText) _$_findCachedViewById(i4)).getText().toString(), this.b);
                                    return;
                                }
                            }
                        }
                        k0.a.a(us.pinguo.user.R.string.status_errorcode10546);
                        return;
                    }
                }
            }
            k0.a.a(us.pinguo.user.R.string.status_errorcode10546);
            return;
        }
        int i5 = us.pinguo.user.R.id.child_chang_phone_btn;
        if (valueOf != null && valueOf.intValue() == i5) {
            s0(((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edit_input_phone)).getText().toString(), ((EditText) _$_findCachedViewById(us.pinguo.user.R.id.edt_input_verify_code)).getText().toString(), this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(us.pinguo.user.R.layout.activity_change_phone_num);
        initView();
    }

    public final void s0(String mobile, String code, int i2) {
        kotlin.jvm.internal.s.h(mobile, "mobile");
        kotlin.jvm.internal.s.h(code, "code");
        addSubscription(new PhoneBindLoader().changePhone(mobile, code, i2).subscribe(new Action1() { // from class: us.pinguo.inspire.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChangePhoneNumActivity.t0(ChangePhoneNumActivity.this, (String) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChangePhoneNumActivity.u0(ChangePhoneNumActivity.this, (Throwable) obj);
            }
        }));
    }

    public final void x0(String str, String str2, int i2) {
        addSubscription(new PhoneBindLoader().getChangePhoneVerifyCode(str2, str, i2).subscribe(new Action1() { // from class: us.pinguo.inspire.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChangePhoneNumActivity.y0(ChangePhoneNumActivity.this, ((Boolean) obj).booleanValue());
            }
        }, new Action1() { // from class: us.pinguo.inspire.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ChangePhoneNumActivity.z0(ChangePhoneNumActivity.this, (Throwable) obj);
            }
        }));
    }
}
