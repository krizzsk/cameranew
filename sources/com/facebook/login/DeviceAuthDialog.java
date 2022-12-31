package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.h;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.facebook.login.LoginClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class DeviceAuthDialog extends DialogFragment {
    private View a;
    private TextView b;
    private TextView c;

    /* renamed from: d  reason: collision with root package name */
    private DeviceAuthMethodHandler f3102d;

    /* renamed from: f  reason: collision with root package name */
    private volatile h f3104f;

    /* renamed from: g  reason: collision with root package name */
    private volatile ScheduledFuture f3105g;

    /* renamed from: h  reason: collision with root package name */
    private volatile RequestState f3106h;

    /* renamed from: i  reason: collision with root package name */
    private Dialog f3107i;

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f3103e = new AtomicBoolean();

    /* renamed from: j  reason: collision with root package name */
    private boolean f3108j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3109k = false;

    /* renamed from: l  reason: collision with root package name */
    private LoginClient.Request f3110l = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new a();
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
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

        public String a() {
            return this.authorizationUri;
        }

        public long b() {
            return this.interval;
        }

        public String c() {
            return this.requestCode;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String f() {
            return this.userCode;
        }

        public void g(long j2) {
            this.interval = j2;
        }

        public void h(long j2) {
            this.lastPoll = j2;
        }

        public void j(String str) {
            this.requestCode = str;
        }

        public void k(String str) {
            this.userCode = str;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", str);
        }

        public boolean l() {
            return this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }

        protected RequestState(Parcel parcel) {
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements GraphRequest.e {
        a() {
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            if (DeviceAuthDialog.this.f3108j) {
                return;
            }
            if (graphResponse.g() != null) {
                DeviceAuthDialog.this.s0(graphResponse.g().h());
                return;
            }
            JSONObject h2 = graphResponse.h();
            RequestState requestState = new RequestState();
            try {
                requestState.k(h2.getString("user_code"));
                requestState.j(h2.getString("code"));
                requestState.g(h2.getLong(TJAdUnitConstants.String.INTERVAL));
                DeviceAuthDialog.this.x0(requestState);
            } catch (JSONException e2) {
                DeviceAuthDialog.this.s0(new FacebookException(e2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                DeviceAuthDialog.this.r0();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
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
                DeviceAuthDialog.this.u0();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements GraphRequest.e {
        d() {
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            if (DeviceAuthDialog.this.f3103e.get()) {
                return;
            }
            FacebookRequestError g2 = graphResponse.g();
            if (g2 != null) {
                int l2 = g2.l();
                if (l2 != 1349152) {
                    switch (l2) {
                        case 1349172:
                        case 1349174:
                            DeviceAuthDialog.this.w0();
                            return;
                        case 1349173:
                            DeviceAuthDialog.this.r0();
                            return;
                        default:
                            DeviceAuthDialog.this.s0(graphResponse.g().h());
                            return;
                    }
                }
                if (DeviceAuthDialog.this.f3106h != null) {
                    com.facebook.q.a.a.a(DeviceAuthDialog.this.f3106h.f());
                }
                if (DeviceAuthDialog.this.f3110l != null) {
                    DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                    deviceAuthDialog.y0(deviceAuthDialog.f3110l);
                    return;
                }
                DeviceAuthDialog.this.r0();
                return;
            }
            try {
                JSONObject h2 = graphResponse.h();
                DeviceAuthDialog.this.t0(h2.getString("access_token"), Long.valueOf(h2.getLong("expires_in")), Long.valueOf(h2.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
            } catch (JSONException e2) {
                DeviceAuthDialog.this.s0(new FacebookException(e2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            DeviceAuthDialog.this.f3107i.setContentView(DeviceAuthDialog.this.q0(false));
            DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
            deviceAuthDialog.y0(deviceAuthDialog.f3110l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {
        final /* synthetic */ String a;
        final /* synthetic */ x.e b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Date f3111d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Date f3112e;

        f(String str, x.e eVar, String str2, Date date, Date date2) {
            this.a = str;
            this.b = eVar;
            this.c = str2;
            this.f3111d = date;
            this.f3112e = date2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            DeviceAuthDialog.this.n0(this.a, this.b, this.c, this.f3111d, this.f3112e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements GraphRequest.e {
        final /* synthetic */ String a;
        final /* synthetic */ Date b;
        final /* synthetic */ Date c;

        g(String str, Date date, Date date2) {
            this.a = str;
            this.b = date;
            this.c = date2;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            if (DeviceAuthDialog.this.f3103e.get()) {
                return;
            }
            if (graphResponse.g() != null) {
                DeviceAuthDialog.this.s0(graphResponse.g().h());
                return;
            }
            try {
                JSONObject h2 = graphResponse.h();
                String string = h2.getString(TapjoyAuctionFlags.AUCTION_ID);
                x.e G = x.G(h2);
                String string2 = h2.getString("name");
                com.facebook.q.a.a.a(DeviceAuthDialog.this.f3106h.f());
                if (!FetchedAppSettingsManager.j(com.facebook.f.g()).m().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.f3109k) {
                    DeviceAuthDialog.this.n0(string, G, this.a, this.b, this.c);
                    return;
                }
                DeviceAuthDialog.this.f3109k = true;
                DeviceAuthDialog.this.v0(string, G, this.a, string2, this.b, this.c);
            } catch (JSONException e2) {
                DeviceAuthDialog.this.s0(new FacebookException(e2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(String str, x.e eVar, String str2, Date date, Date date2) {
        this.f3102d.x(str2, com.facebook.f.g(), str, eVar.c(), eVar.a(), eVar.b(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.f3107i.dismiss();
    }

    private GraphRequest p0() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.f3106h.c());
        return new GraphRequest(null, "device/login_status", bundle, HttpMethod.POST, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(String str, Long l2, Long l3) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date = null;
        Date date2 = l2.longValue() != 0 ? new Date(new Date().getTime() + (l2.longValue() * 1000)) : null;
        if (l3.longValue() != 0 && l3 != null) {
            date = new Date(l3.longValue() * 1000);
        }
        new GraphRequest(new AccessToken(str, com.facebook.f.g(), "0", null, null, null, null, date2, null, date), "me", bundle, HttpMethod.GET, new g(str, date2, date)).i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.f3106h.h(new Date().getTime());
        this.f3104f = p0().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str, x.e eVar, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
        String string3 = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
        String format = String.format(string2, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new f(str, eVar, str2, date, date2)).setPositiveButton(string3, new e());
        AlertDialog create = builder.create();
        create.show();
        VdsAgent.showDialog(create);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.f3105g = DeviceAuthMethodHandler.s().schedule(new c(), this.f3106h.b(), TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(RequestState requestState) {
        this.f3106h = requestState;
        this.b.setText(requestState.f());
        this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), com.facebook.q.a.a.c(requestState.a())), (Drawable) null, (Drawable) null);
        TextView textView = this.b;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        View view = this.a;
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
        if (!this.f3109k && com.facebook.q.a.a.f(requestState.f())) {
            new InternalAppEventsLogger(getContext()).i("fb_smart_login_service");
        }
        if (requestState.l()) {
            w0();
        } else {
            u0();
        }
    }

    @LayoutRes
    protected int o0(boolean z) {
        return z ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.f3107i = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        this.f3107i.setContentView(q0(com.facebook.q.a.a.e() && !this.f3109k));
        return this.f3107i;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f3102d = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).m0()).d0().m();
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            x0(requestState);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f3108j = true;
        this.f3103e.set(true);
        super.onDestroyView();
        if (this.f3104f != null) {
            this.f3104f.cancel(true);
        }
        if (this.f3105g != null) {
            this.f3105g.cancel(true);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f3108j) {
            return;
        }
        r0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f3106h != null) {
            bundle.putParcelable("request_state", this.f3106h);
        }
    }

    protected View q0(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(o0(z), (ViewGroup) null);
        this.a = inflate.findViewById(R.id.progress_bar);
        this.b = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new b());
        TextView textView = (TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions);
        this.c = textView;
        textView.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        return inflate;
    }

    protected void r0() {
        if (this.f3103e.compareAndSet(false, true)) {
            if (this.f3106h != null) {
                com.facebook.q.a.a.a(this.f3106h.f());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.f3102d;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.t();
            }
            this.f3107i.dismiss();
        }
    }

    protected void s0(FacebookException facebookException) {
        if (this.f3103e.compareAndSet(false, true)) {
            if (this.f3106h != null) {
                com.facebook.q.a.a.a(this.f3106h.f());
            }
            this.f3102d.u(facebookException);
            this.f3107i.dismiss();
        }
    }

    public void y0(LoginClient.Request request) {
        this.f3110l = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.k()));
        String h2 = request.h();
        if (h2 != null) {
            bundle.putString(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, h2);
        }
        String g2 = request.g();
        if (g2 != null) {
            bundle.putString("target_user_id", g2);
        }
        bundle.putString("access_token", y.b() + Effect.DIVIDER + y.c());
        bundle.putString("device_info", com.facebook.q.a.a.d());
        new GraphRequest(null, "device/login", bundle, HttpMethod.POST, new a()).i();
    }
}
