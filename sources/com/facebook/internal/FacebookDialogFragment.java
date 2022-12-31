package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.internal.WebDialog;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class FacebookDialogFragment extends DialogFragment {
    private Dialog a;

    /* loaded from: classes.dex */
    class a implements WebDialog.g {
        a() {
        }

        @Override // com.facebook.internal.WebDialog.g
        public void a(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.this.c0(bundle, facebookException);
        }
    }

    /* loaded from: classes.dex */
    class b implements WebDialog.g {
        b() {
        }

        @Override // com.facebook.internal.WebDialog.g
        public void a(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.this.d0(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, t.n(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }

    public void e0(Dialog dialog) {
        this.a = dialog;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.a instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.a).s();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        WebDialog A;
        super.onCreate(bundle);
        if (this.a == null) {
            FragmentActivity activity = getActivity();
            Bundle y = t.y(activity.getIntent());
            if (!y.getBoolean("is_fallback", false)) {
                String string = y.getString(AuthActivity.ACTION_KEY);
                Bundle bundle2 = y.getBundle("params");
                if (x.S(string)) {
                    x.Y("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                WebDialog.d dVar = new WebDialog.d(activity, string, bundle2);
                dVar.h(new a());
                A = dVar.a();
            } else {
                String string2 = y.getString("url");
                if (x.S(string2)) {
                    x.Y("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                A = j.A(activity, string2, String.format("fb%s://bridge/", com.facebook.f.g()));
                A.w(new b());
            }
            this.a = A;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            c0(null, null);
            setShowsDialog(false);
        }
        return this.a;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.a;
        if (dialog instanceof WebDialog) {
            ((WebDialog) dialog).s();
        }
    }
}
