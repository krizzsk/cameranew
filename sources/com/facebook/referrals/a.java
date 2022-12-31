package com.facebook.referrals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.CustomTabMainActivity;
import com.facebook.f;
import com.facebook.internal.d;
import com.facebook.internal.e;
import com.facebook.internal.x;
import com.tapjoy.TapjoyConstants;
/* compiled from: ReferralClient.java */
/* loaded from: classes.dex */
class a {
    private Fragment a;
    private String b;
    protected String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Fragment fragment) {
        this.a = fragment;
    }

    private void a(int i2, Intent intent) {
        FragmentActivity activity;
        if (!this.a.isAdded() || (activity = this.a.getActivity()) == null) {
            return;
        }
        activity.setResult(i2, intent);
        activity.finish();
    }

    private String b() {
        if (this.b == null) {
            this.b = e.a();
        }
        return this.b;
    }

    static String c() {
        return "fb" + f.g() + "://authorize";
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        this.c = x.q(20);
        bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, e.c(c()));
        bundle.putString(TapjoyConstants.TJC_APP_ID, f.g());
        bundle.putString("state", this.c);
        return bundle;
    }

    private boolean e() {
        return b() != null;
    }

    private boolean h() {
        if (this.a.getActivity() != null && this.a.getActivity().checkCallingOrSelfPermission("android.permission.INTERNET") == 0 && e()) {
            Bundle d2 = d();
            if (f.q) {
                com.facebook.login.a.b(d.a("share_referral", d2));
            }
            Intent intent = new Intent(this.a.getActivity(), CustomTabMainActivity.class);
            intent.putExtra(CustomTabMainActivity.c, "share_referral");
            intent.putExtra(CustomTabMainActivity.f2238d, d2);
            intent.putExtra(CustomTabMainActivity.f2239e, b());
            this.a.startActivityForResult(intent, 1);
            return true;
        }
        return false;
    }

    private boolean i(Bundle bundle) {
        if (this.c != null) {
            boolean equals = this.c.equals(bundle.getString("state"));
            this.c = null;
            return equals;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i2, int i3, Intent intent) {
        String stringExtra;
        if (i2 != 1) {
            return;
        }
        if (intent != null && (stringExtra = intent.getStringExtra(CustomTabMainActivity.f2240f)) != null && stringExtra.startsWith(e.c(c()))) {
            Bundle e0 = x.e0(Uri.parse(stringExtra).getQuery());
            if (i(e0)) {
                intent.putExtras(e0);
            } else {
                i3 = 0;
                intent.putExtra("error_message", "The referral response was missing a valid challenge string.");
            }
        }
        a(i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (h()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("error_message", "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed");
        a(0, intent);
    }
}
