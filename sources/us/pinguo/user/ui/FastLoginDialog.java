package us.pinguo.user.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonSyntaxException;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HuaweiAgent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Action1;
import us.pinguo.foundation.base.SubscriptionDialogFragment;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.module.contact.PhoneBindLoader;
import us.pinguo.inspire.module.contact.entry.PhoneBindResponse;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.model.CityZones;
import us.pinguo.user.util.BaseInfoResult;
/* loaded from: classes6.dex */
public class FastLoginDialog extends SubscriptionDialogFragment implements View.OnClickListener, o0, us.pinguo.user.util.g {
    public static final String KEY_POSITION = "key-position";
    public static final String KEY_REQ_CODE = "key-req-code";
    public static final String KEY_RESOURCE = "key-resource";
    private FrameLayout fastLoginContainer;
    private boolean isChina;
    private ViewGroup layoutPwd;
    private RelativeLayout mBtnSendVerifyCode;
    private RelativeLayout mChild_fast_phone_bind_btn;
    private EditText mEdtInputPhone;
    private EditText mEdtInputPwd;
    private EditText mEdtInputVerifyCode;
    private View mFbBtn;
    private View mHuaweiBtn;
    private n0 mPresenter;
    private int mSecond;
    private TextInputLayout mTextInputLayout;
    private TextView mTextVerifyCode;
    private View mTwBtn;
    private TextInputLayout mVerifyCodeInputLayout;
    private View mWbBtn;
    private View mWxBtn;
    private f outerDismiss;
    private View phoneBindView;
    private Spinner spinner;
    private int cc = 86;
    private boolean needPwd = false;
    private Runnable postTimeRunnable = new a();

    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: us.pinguo.user.ui.FastLoginDialog$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0458a implements Runnable {
            RunnableC0458a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FastLoginDialog.this.mTextVerifyCode.setText(String.format(FastLoginDialog.this.getResources().getString(R.string.aready_send), Integer.valueOf(FastLoginDialog.this.mSecond)));
                FastLoginDialog.this.mSecond--;
                FastLoginDialog.this.postTime();
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FastLoginDialog.this.getActivity() == null) {
                return;
            }
            FastLoginDialog.this.getActivity().runOnUiThread(new RunnableC0458a());
        }
    }

    /* loaded from: classes6.dex */
    class b extends us.pinguo.foundation.ui.g {
        b() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FastLoginDialog.this.setBindBtnStatus();
        }
    }

    /* loaded from: classes6.dex */
    class c extends us.pinguo.foundation.ui.g {
        c() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FastLoginDialog.this.setBindBtnStatus();
        }
    }

    /* loaded from: classes6.dex */
    class d extends us.pinguo.foundation.ui.g {
        d() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FastLoginDialog.this.setBindBtnStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements AdapterView.OnItemSelectedListener {
        final /* synthetic */ us.pinguo.user.ui.p0.a a;

        e(us.pinguo.user.ui.p0.a aVar) {
            this.a = aVar;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        @Instrumented
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
            VdsAgent.onItemSelected(this, adapterView, view, i2, j2);
            try {
                FastLoginDialog.this.cc = Integer.valueOf(this.a.getItem(i2).getCc()).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
                FastLoginDialog.this.cc = 86;
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(String str) {
        us.pinguo.common.log.a.d("zhouwei", "bind phone：" + str, new Object[0]);
        bindSuccess(str);
    }

    private void bindingSpinnerData() {
        try {
            String inputStream = getInputStream();
            if (inputStream != null) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONObject(inputStream).getJSONArray("list");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    arrayList.add(new CityZones(jSONObject.getString("name"), jSONObject.getString("code"), jSONObject.getString("cc")));
                }
                us.pinguo.user.ui.p0.a aVar = new us.pinguo.user.ui.p0.a(getContext(), arrayList);
                this.spinner.setAdapter((SpinnerAdapter) aVar);
                this.spinner.setOnItemSelectedListener(new e(aVar));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        if (th.getCause() instanceof JsonSyntaxException) {
            String message = ((VolleyError) th).getMessage();
            us.pinguo.common.log.a.m("zhouwei", "json:" + message, new Object[0]);
            this.mVerifyCodeInputLayout.setError(us.pinguo.user.api.f0.a(getActivity(), PhoneBindResponse.parseGson(message).status));
            this.mEdtInputVerifyCode.setHint("");
            this.mVerifyCodeInputLayout.setHint("");
            return;
        }
        showErrorMessage(th);
    }

    private void changeBtnStatus() {
        this.mBtnSendVerifyCode.setEnabled(false);
    }

    private boolean checkBindEnable() {
        return ((this.needPwd && TextUtils.isEmpty(this.mEdtInputPwd.getText().toString())) || TextUtils.isEmpty(this.mEdtInputPhone.getText().toString()) || TextUtils.isEmpty(this.mEdtInputVerifyCode.getText().toString())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(Boolean bool) {
        us.pinguo.common.log.a.d("zhouwei", "verifyCode:" + bool, new Object[0]);
        if (bool.booleanValue()) {
            changeBtnStatus();
            this.mBtnSendVerifyCode.setEnabled(false);
            this.mBtnSendVerifyCode.setBackgroundResource(R.drawable.fast_login_c360_unable_btn_border);
            this.mTextVerifyCode.setTextColor(getResources().getColor(R.color.send_code_text_color));
            this.mSecond = 60;
        } else {
            this.mSecond = 0;
            us.pinguo.foundation.utils.j0.d(getString(R.string.get_verfiy_code_error));
        }
        postTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        showErrorMessage(th);
        this.mSecond = 0;
        postTime();
    }

    private String getInputStream() throws IOException {
        String str;
        Locale locale = getResources().getConfiguration().locale;
        String country = locale.getCountry();
        String language = locale.getLanguage();
        if ("zh".equals(language) && "CN".equals(country)) {
            str = "city_zh.json";
        } else {
            str = "zh".equals(language) ? "city_tw.json" : "city_en.json";
        }
        return us.pinguo.foundation.utils.e.b(us.pinguo.util.v.a(), str);
    }

    private void hideSoftInputKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void launchFastLogin(Activity activity, int i2, int i3, String str) {
        FastLoginDialog fastLoginDialog = new FastLoginDialog();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_REQ_CODE, i2);
        bundle.putInt(KEY_POSITION, i3);
        bundle.putString(KEY_RESOURCE, str);
        fastLoginDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        fastLoginDialog.show(supportFragmentManager, "fast-login-dialog");
        VdsAgent.showDialogFragment(fastLoginDialog, supportFragmentManager, "fast-login-dialog");
    }

    private void logoutIfNotBind() {
        BaseInfoResult g2 = us.pinguo.user.util.n.a.g();
        User.Info h2 = User.d().h();
        if (g2 == null || h2 == null || !us.pinguo.user.util.n.m(h2, g2.isChina())) {
            return;
        }
        User.s();
    }

    private boolean needPwd() {
        User.Info h2 = User.d().h();
        return (h2 == null || h2.setPass == 1) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postTime() {
        if (this.mSecond <= 0) {
            this.mBtnSendVerifyCode.setEnabled(true);
            this.mBtnSendVerifyCode.setBackgroundResource(R.drawable.fast_login_c360_btn_border);
            this.mTextVerifyCode.setTextColor(getResources().getColor(R.color.send_code_can_user_color));
            this.mTextVerifyCode.setText(R.string.send_again);
            return;
        }
        this.mTextVerifyCode.removeCallbacks(this.postTimeRunnable);
        this.mTextVerifyCode.postDelayed(this.postTimeRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBindBtnStatus() {
        if (checkBindEnable()) {
            this.mChild_fast_phone_bind_btn.setBackgroundResource(R.drawable.fast_phone_bind_btn_border);
            this.mChild_fast_phone_bind_btn.setEnabled(true);
            return;
        }
        this.mChild_fast_phone_bind_btn.setBackgroundResource(R.drawable.fast_phone_bind_btn_unable_border);
        this.mChild_fast_phone_bind_btn.setEnabled(false);
    }

    private void showErrorMessage(Throwable th) {
        Fault fault;
        if (!(th instanceof Fault) || (fault = (Fault) th) == null) {
            return;
        }
        this.mVerifyCodeInputLayout.setError(us.pinguo.user.api.f0.a(getContext(), fault.getStatus()));
        this.mVerifyCodeInputLayout.setHint("");
        this.mEdtInputVerifyCode.setHint("");
    }

    private void switchByLocal() {
        if (us.pinguo.foundation.utils.z.b(Locale.getDefault())) {
            View view = this.mFbBtn;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            View view2 = this.mTwBtn;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
            View view3 = this.mWxBtn;
            view3.setVisibility(0);
            VdsAgent.onSetViewVisibility(view3, 0);
            View view4 = this.mWbBtn;
            view4.setVisibility(0);
            VdsAgent.onSetViewVisibility(view4, 0);
        } else {
            View view5 = this.mWxBtn;
            view5.setVisibility(8);
            VdsAgent.onSetViewVisibility(view5, 8);
            View view6 = this.mWbBtn;
            view6.setVisibility(8);
            VdsAgent.onSetViewVisibility(view6, 8);
            View view7 = this.mHuaweiBtn;
            view7.setVisibility(8);
            VdsAgent.onSetViewVisibility(view7, 8);
            View view8 = this.mFbBtn;
            view8.setVisibility(0);
            VdsAgent.onSetViewVisibility(view8, 0);
            View view9 = this.mTwBtn;
            view9.setVisibility(0);
            VdsAgent.onSetViewVisibility(view9, 0);
        }
        if (HuaweiAgent.isHuaweiSupport() && HuaweiAgent.isHuaweiPhone()) {
            View view10 = this.mHuaweiBtn;
            view10.setVisibility(0);
            VdsAgent.onSetViewVisibility(view10, 0);
        }
    }

    public void bindPhone(String str, String str2, int i2, boolean z) {
        addSubscription(new PhoneBindLoader().phoneBind(str, str2, i2, z).subscribe(new Action1() { // from class: us.pinguo.user.ui.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FastLoginDialog.this.b0((String) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.ui.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FastLoginDialog.this.d0((Throwable) obj);
            }
        }));
    }

    public void bindSuccess(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bind_mobile", str);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        this.mTextVerifyCode.removeCallbacks(this.postTimeRunnable);
        this.mPresenter.h(true, intent);
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment, us.pinguo.inspire.module.comment.IFeedsInfoView
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Override // us.pinguo.user.ui.o0
    public View getDecorView() {
        return getDialog().getWindow().getDecorView();
    }

    @Override // us.pinguo.user.ui.o0
    public Fragment getFragment() {
        return this;
    }

    public void getVerifyCode(String str, int i2, String str2) {
        Observable<Boolean> verifyCode;
        if (TextUtils.isEmpty(str2)) {
            verifyCode = new PhoneBindLoader().getVerifyCode(str, i2);
        } else {
            verifyCode = new PhoneBindLoader().getVerifyCode(str, i2, str2);
        }
        addSubscription(verifyCode.subscribe(new Action1() { // from class: us.pinguo.user.ui.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FastLoginDialog.this.f0((Boolean) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.ui.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FastLoginDialog.this.h0((Throwable) obj);
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mPresenter.A(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        String str;
        VdsAgent.onClick(this, view);
        if (view.getId() == R.id.fast_login_close_btn) {
            dismissAllowingStateLoss();
            f fVar = this.outerDismiss;
            if (fVar != null) {
                fVar.a();
            }
            logoutIfNotBind();
        } else if (view.getId() == R.id.child_fast_login_wx_btn) {
            this.mPresenter.G();
        } else if (view.getId() == R.id.child_fast_login_wb_btn) {
            this.mPresenter.F();
        } else if (view.getId() == R.id.child_fast_login_fb_btn) {
            this.mPresenter.C();
        } else if (view.getId() == R.id.child_fast_login_tw_btn) {
            this.mPresenter.E();
        } else if (view.getId() == R.id.child_fast_login_c360_btn) {
            this.mPresenter.B();
        } else if (view.getId() == R.id.child_fast_login_huawei_btn) {
            this.mPresenter.D();
        } else if (view.getId() == R.id.phone_bind_send_verify_code) {
            String obj = this.mEdtInputPhone.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                us.pinguo.foundation.utils.j0.d(getString(R.string.error_empty_phone_info));
                return;
            }
            if (this.needPwd) {
                str = this.mEdtInputPwd.getText().toString();
                if (str.length() < 6 || str.length() > 20) {
                    us.pinguo.foundation.utils.j0.d(getString(R.string.pg_password_prompt));
                    return;
                }
            } else {
                str = "";
            }
            this.mBtnSendVerifyCode.setEnabled(false);
            this.mBtnSendVerifyCode.setBackgroundResource(R.drawable.fast_login_c360_unable_btn_border);
            this.mTextVerifyCode.setTextColor(getResources().getColor(R.color.send_code_text_color));
            this.mSecond = 60;
            postTime();
            getVerifyCode(obj, this.cc, str);
        } else if (view.getId() == R.id.child_fast_phone_bind_btn) {
            String obj2 = this.mEdtInputPhone.getText().toString();
            String obj3 = this.mEdtInputVerifyCode.getText().toString();
            if (TextUtils.isEmpty(obj2)) {
                us.pinguo.foundation.utils.j0.d(getString(R.string.error_empty_phone_info));
            } else if (TextUtils.isEmpty(obj3)) {
                us.pinguo.foundation.utils.j0.d(getString(R.string.error_empty_code_info));
            } else {
                hideSoftInputKeyBoard();
                bindPhone(obj2, obj3, this.cc, this.isChina);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        us.pinguo.foundation.statistics.g.f("fast_login_page");
        us.pinguo.foundation.statistics.l.onEvent(getActivity(), "fast_login_page", us.pinguo.util.p.e() ? "china" : us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
        us.pinguo.user.util.n.a.h(this);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(getActivity(), R.style.FastLoginDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fast_login_dialog, viewGroup, false);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.fast_login_content_layout, (ViewGroup) null);
        this.phoneBindView = LayoutInflater.from(getContext()).inflate(R.layout.fast_phone_bind_content_layout, (ViewGroup) null);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.fast_login_container);
        this.fastLoginContainer = frameLayout;
        frameLayout.removeAllViews();
        this.fastLoginContainer.addView(inflate2);
        this.mWxBtn = inflate2.findViewById(R.id.fast_login_wx_btn);
        this.mWbBtn = inflate2.findViewById(R.id.fast_login_wb_btn);
        this.mFbBtn = inflate2.findViewById(R.id.fast_login_fb_btn);
        this.mTwBtn = inflate2.findViewById(R.id.fast_login_tw_btn);
        this.mHuaweiBtn = inflate2.findViewById(R.id.fast_login_huawei_btn);
        inflate2.findViewById(R.id.fast_login_c360_btn).setOnClickListener(this);
        this.spinner = (Spinner) this.phoneBindView.findViewById(R.id.zone_spinner);
        bindingSpinnerData();
        this.mEdtInputPwd = (EditText) this.phoneBindView.findViewById(R.id.edt_input_pwd);
        this.mEdtInputPhone = (EditText) this.phoneBindView.findViewById(R.id.edt_input_phone);
        this.mEdtInputVerifyCode = (EditText) this.phoneBindView.findViewById(R.id.edt_input_verify_code);
        this.mTextInputLayout = (TextInputLayout) this.phoneBindView.findViewById(R.id.input_phone_text_layout);
        TextInputLayout textInputLayout = (TextInputLayout) this.phoneBindView.findViewById(R.id.input_verify_code_text_layout);
        this.mVerifyCodeInputLayout = textInputLayout;
        textInputLayout.setErrorEnabled(true);
        this.mBtnSendVerifyCode = (RelativeLayout) this.phoneBindView.findViewById(R.id.phone_bind_send_verify_code);
        this.mTextVerifyCode = (TextView) this.phoneBindView.findViewById(R.id.phone_bind_send_verify_code_text);
        this.mChild_fast_phone_bind_btn = (RelativeLayout) this.phoneBindView.findViewById(R.id.child_fast_phone_bind_btn);
        this.needPwd = needPwd();
        this.mBtnSendVerifyCode.setOnClickListener(this);
        this.mChild_fast_phone_bind_btn.setOnClickListener(this);
        this.mEdtInputPhone.addTextChangedListener(new b());
        this.mEdtInputVerifyCode.addTextChangedListener(new c());
        this.mEdtInputPwd.addTextChangedListener(new d());
        this.layoutPwd = (ViewGroup) this.phoneBindView.findViewById(R.id.pwd_layout);
        inflate.findViewById(R.id.fast_login_close_btn).setOnClickListener(this);
        this.mWxBtn.setOnClickListener(this);
        this.mWbBtn.setOnClickListener(this);
        this.mFbBtn.setOnClickListener(this);
        this.mTwBtn.setOnClickListener(this);
        this.mHuaweiBtn.setOnClickListener(this);
        setCancelable(true);
        switchByLocal();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.foundation.statistics.g.e("fast_login_page");
    }

    @Override // us.pinguo.foundation.base.SubscriptionDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        n0 n0Var = this.mPresenter;
        if (n0Var != null) {
            n0Var.detachView();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.mTextVerifyCode.removeCallbacks(this.postTimeRunnable);
        f fVar = this.outerDismiss;
        if (fVar != null) {
            fVar.a();
        }
        logoutIfNotBind();
    }

    @Override // us.pinguo.user.util.g
    public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
        this.isChina = baseInfoResult != null && baseInfoResult.isChina();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        n0 n0Var = new n0();
        this.mPresenter = n0Var;
        n0Var.attachView(this);
    }

    @Override // us.pinguo.user.ui.o0
    public void phoneBind() {
        this.fastLoginContainer.removeAllViews();
        this.fastLoginContainer.addView(this.phoneBindView);
        boolean needPwd = needPwd();
        this.needPwd = needPwd;
        ViewGroup viewGroup = this.layoutPwd;
        int i2 = needPwd ? 0 : 8;
        viewGroup.setVisibility(i2);
        VdsAgent.onSetViewVisibility(viewGroup, i2);
    }

    public void setOuterDismiss(f fVar) {
        this.outerDismiss = fVar;
    }

    public void showHuaweiBtn() {
        View view = this.mHuaweiBtn;
        if (view != null) {
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        }
    }
}
