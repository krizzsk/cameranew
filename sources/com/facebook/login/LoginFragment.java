package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.R;
import com.facebook.login.LoginClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tencent.open.SocialConstants;
@Instrumented
/* loaded from: classes.dex */
public class LoginFragment extends Fragment {
    private String a;
    private LoginClient b;
    private LoginClient.Request c;

    /* loaded from: classes.dex */
    class a implements LoginClient.c {
        a() {
        }

        @Override // com.facebook.login.LoginClient.c
        public void a(LoginClient.Result result) {
            LoginFragment.this.f0(result);
        }
    }

    /* loaded from: classes.dex */
    class b implements LoginClient.b {
        final /* synthetic */ View a;

        b(LoginFragment loginFragment, View view) {
            this.a = view;
        }

        @Override // com.facebook.login.LoginClient.b
        public void a() {
            View view = this.a;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
        }

        @Override // com.facebook.login.LoginClient.b
        public void b() {
            View view = this.a;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
    }

    private void e0(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return;
        }
        this.a = callingActivity.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(LoginClient.Result result) {
        this.c = null;
        int i2 = result.a == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i2, intent);
            getActivity().finish();
        }
    }

    protected LoginClient b0() {
        return new LoginClient(this);
    }

    @LayoutRes
    protected int c0() {
        return R.layout.com_facebook_login_fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginClient d0() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.b.D(i2, i3, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            LoginClient loginClient = (LoginClient) bundle.getParcelable("loginClient");
            this.b = loginClient;
            loginClient.F(this);
        } else {
            this.b = b0();
        }
        this.b.G(new a());
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        e0(activity);
        Intent intent = activity.getIntent();
        if (intent == null || (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) == null) {
            return;
        }
        this.c = (LoginClient.Request) bundleExtra.getParcelable(SocialConstants.TYPE_REQUEST);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(c0(), viewGroup, false);
        this.b.E(new b(this, inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar)));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.b.c();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        VdsAgent.onFragmentPause(this);
        super.onPause();
        View findViewById = getView() == null ? null : getView().findViewById(R.id.com_facebook_login_fragment_progress_bar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            VdsAgent.onSetViewVisibility(findViewById, 8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        VdsAgent.onFragmentResume(this);
        super.onResume();
        if (this.a == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        this.b.H(this.c);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.b);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}
