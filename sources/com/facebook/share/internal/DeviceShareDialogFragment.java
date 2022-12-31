package com.facebook.share.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.common.R;
import com.facebook.internal.y;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes.dex */
public class DeviceShareDialogFragment extends DialogFragment {

    /* renamed from: g  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f3190g;
    private ProgressBar a;
    private TextView b;
    private Dialog c;

    /* renamed from: d  reason: collision with root package name */
    private volatile RequestState f3191d;

    /* renamed from: e  reason: collision with root package name */
    private volatile ScheduledFuture f3192e;

    /* renamed from: f  reason: collision with root package name */
    private ShareContent f3193f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new a();
        private long expiresIn;
        private String userCode;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<RequestState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public RequestState[] newArray(int i2) {
                return new RequestState[i2];
            }
        }

        RequestState() {
        }

        public long a() {
            return this.expiresIn;
        }

        public String b() {
            return this.userCode;
        }

        public void c(long j2) {
            this.expiresIn = j2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void f(String str) {
            this.userCode = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.userCode);
            parcel.writeLong(this.expiresIn);
        }

        protected RequestState(Parcel parcel) {
            this.userCode = parcel.readString();
            this.expiresIn = parcel.readLong();
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                DeviceShareDialogFragment.this.c.dismiss();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements GraphRequest.e {
        b() {
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            FacebookRequestError g2 = graphResponse.g();
            if (g2 != null) {
                DeviceShareDialogFragment.this.f0(g2);
                return;
            }
            JSONObject h2 = graphResponse.h();
            RequestState requestState = new RequestState();
            try {
                requestState.f(h2.getString("user_code"));
                requestState.c(h2.getLong("expires_in"));
                DeviceShareDialogFragment.this.i0(requestState);
            } catch (JSONException unused) {
                DeviceShareDialogFragment.this.f0(new FacebookRequestError(0, "", "Malformed server response"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                DeviceShareDialogFragment.this.c.dismiss();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    private void d0() {
        if (isAdded()) {
            getFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    private void e0(int i2, Intent intent) {
        if (this.f3191d != null) {
            com.facebook.q.a.a.a(this.f3191d.b());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast makeText = Toast.makeText(getContext(), facebookRequestError.f(), 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            activity.setResult(i2, intent);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(FacebookRequestError facebookRequestError) {
        d0();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        e0(-1, intent);
    }

    private static synchronized ScheduledThreadPoolExecutor g0() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (f3190g == null) {
                f3190g = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = f3190g;
        }
        return scheduledThreadPoolExecutor;
    }

    private Bundle h0() {
        ShareContent shareContent = this.f3193f;
        if (shareContent == null) {
            return null;
        }
        if (shareContent instanceof ShareLinkContent) {
            return l.a((ShareLinkContent) shareContent);
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            return l.b((ShareOpenGraphContent) shareContent);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(RequestState requestState) {
        this.f3191d = requestState;
        this.b.setText(requestState.b());
        TextView textView = this.b;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        ProgressBar progressBar = this.a;
        progressBar.setVisibility(8);
        VdsAgent.onSetViewVisibility(progressBar, 8);
        this.f3192e = g0().schedule(new c(), requestState.a(), TimeUnit.SECONDS);
    }

    private void k0() {
        Bundle h0 = h0();
        if (h0 == null || h0.size() == 0) {
            f0(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        h0.putString("access_token", y.b() + Effect.DIVIDER + y.c());
        h0.putString("device_info", com.facebook.q.a.a.d());
        new GraphRequest(null, "device/share", h0, HttpMethod.POST, new b()).i();
    }

    public void j0(ShareContent shareContent) {
        this.f3193f = shareContent;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.c = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.a = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.b = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new a());
        ((TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        this.c.setContentView(inflate);
        k0();
        return this.c;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            i0(requestState);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f3192e != null) {
            this.f3192e.cancel(true);
        }
        e0(-1, new Intent());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f3191d != null) {
            bundle.putParcelable("request_state", this.f3191d);
        }
    }
}
