package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.common.R;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.t;
import com.facebook.internal.x;
import com.facebook.login.LoginFragment;
import com.facebook.referrals.ReferralFragment;
import com.facebook.share.internal.DeviceShareDialogFragment;
import com.facebook.share.model.ShareContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class FacebookActivity extends FragmentActivity {
    public static String b = "PassThrough";
    private static String c = "SingleFragment";

    /* renamed from: d  reason: collision with root package name */
    private static final String f2243d = FacebookActivity.class.getName();
    private Fragment a;

    private void n0() {
        setResult(0, t.n(getIntent(), null, t.t(t.y(getIntent()))));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (com.facebook.core.internal.logging.dumpsys.a.j(str, printWriter, strArr)) {
                return;
            }
            super.dump(str, fileDescriptor, printWriter, strArr);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    protected Fragment getFragment() {
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(c);
        if (findFragmentByTag == null) {
            if ("FacebookDialogFragment".equals(intent.getAction())) {
                FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
                facebookDialogFragment.setRetainInstance(true);
                String str = c;
                facebookDialogFragment.show(supportFragmentManager, str);
                VdsAgent.showDialogFragment(facebookDialogFragment, supportFragmentManager, str);
                return facebookDialogFragment;
            } else if ("DeviceShareDialogFragment".equals(intent.getAction())) {
                DeviceShareDialogFragment deviceShareDialogFragment = new DeviceShareDialogFragment();
                deviceShareDialogFragment.setRetainInstance(true);
                deviceShareDialogFragment.j0((ShareContent) intent.getParcelableExtra(FirebaseAnalytics.Param.CONTENT));
                String str2 = c;
                deviceShareDialogFragment.show(supportFragmentManager, str2);
                VdsAgent.showDialogFragment(deviceShareDialogFragment, supportFragmentManager, str2);
                return deviceShareDialogFragment;
            } else if ("ReferralFragment".equals(intent.getAction())) {
                ReferralFragment referralFragment = new ReferralFragment();
                referralFragment.setRetainInstance(true);
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                int i2 = R.id.com_facebook_fragment_container;
                String str3 = c;
                FragmentTransaction add = beginTransaction.add(i2, referralFragment, str3);
                VdsAgent.onFragmentTransactionAdd(beginTransaction, i2, referralFragment, str3, add);
                add.commit();
                return referralFragment;
            } else {
                LoginFragment loginFragment = new LoginFragment();
                loginFragment.setRetainInstance(true);
                FragmentTransaction beginTransaction2 = supportFragmentManager.beginTransaction();
                int i3 = R.id.com_facebook_fragment_container;
                String str4 = c;
                FragmentTransaction add2 = beginTransaction2.add(i3, loginFragment, str4);
                VdsAgent.onFragmentTransactionAdd(beginTransaction2, i3, loginFragment, str4, add2);
                add2.commit();
                return loginFragment;
            }
        }
        return findFragmentByTag;
    }

    public Fragment m0() {
        return this.a;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Fragment fragment = this.a;
        if (fragment != null) {
            fragment.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!f.z()) {
            x.Y(f2243d, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            f.F(getApplicationContext());
        }
        setContentView(R.layout.com_facebook_activity_layout);
        if (b.equals(intent.getAction())) {
            n0();
        } else {
            this.a = getFragment();
        }
    }
}
