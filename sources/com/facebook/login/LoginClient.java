package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoginClient implements Parcelable {
    public static final Parcelable.Creator<LoginClient> CREATOR = new a();
    LoginMethodHandler[] a;
    int b;
    Fragment c;

    /* renamed from: d  reason: collision with root package name */
    c f3115d;

    /* renamed from: e  reason: collision with root package name */
    b f3116e;

    /* renamed from: f  reason: collision with root package name */
    boolean f3117f;

    /* renamed from: g  reason: collision with root package name */
    Request f3118g;

    /* renamed from: h  reason: collision with root package name */
    Map<String, String> f3119h;

    /* renamed from: i  reason: collision with root package name */
    Map<String, String> f3120i;
    private com.facebook.login.c loginLogger;
    private int numActivitiesReturned;
    private int numTotalIntentsFired;

    /* loaded from: classes.dex */
    public static class Request implements Parcelable {
        public static final Parcelable.Creator<Request> CREATOR = new a();
        private final String applicationId;
        private final String authId;
        private String authType;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<Request> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Request createFromParcel(Parcel parcel) {
                return new Request(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Request[] newArray(int i2) {
                return new Request[i2];
            }
        }

        /* synthetic */ Request(Parcel parcel, a aVar) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.applicationId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String b() {
            return this.authId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String c() {
            return this.authType;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DefaultAudience f() {
            return this.defaultAudience;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String g() {
            return this.deviceAuthTargetUserId;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String h() {
            return this.deviceRedirectUriString;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LoginBehavior j() {
            return this.loginBehavior;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set<String> k() {
            return this.permissions;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean l() {
            for (String str : this.permissions) {
                if (LoginManager.f(str)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean m() {
            return this.isRerequest;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void n(Set<String> set) {
            y.l(set, "permissions");
            this.permissions = set;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(boolean z) {
            this.isRerequest = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            LoginBehavior loginBehavior = this.loginBehavior;
            parcel.writeString(loginBehavior != null ? loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            DefaultAudience defaultAudience = this.defaultAudience;
            parcel.writeString(defaultAudience != null ? defaultAudience.name() : null);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte(this.isRerequest ? (byte) 1 : (byte) 0);
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
            parcel.writeString(this.deviceAuthTargetUserId);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2, String str3) {
            this.isRerequest = false;
            this.loginBehavior = loginBehavior;
            this.permissions = set == null ? new HashSet<>() : set;
            this.defaultAudience = defaultAudience;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
        }

        private Request(Parcel parcel) {
            this.isRerequest = false;
            String readString = parcel.readString();
            this.loginBehavior = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString2 = parcel.readString();
            this.defaultAudience = readString2 != null ? DefaultAudience.valueOf(readString2) : null;
            this.applicationId = parcel.readString();
            this.authId = parcel.readString();
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = parcel.readString();
            this.deviceAuthTargetUserId = parcel.readString();
        }
    }

    /* loaded from: classes.dex */
    public static class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new a();
        final Code a;
        final AccessToken b;
        final String c;

        /* renamed from: d  reason: collision with root package name */
        final String f3121d;

        /* renamed from: e  reason: collision with root package name */
        final Request f3122e;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum Code {
            SUCCESS(FirebaseAnalytics.Param.SUCCESS),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public String getLoggingValue() {
                return this.loggingValue;
            }
        }

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<Result> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public Result createFromParcel(Parcel parcel) {
                return new Result(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public Result[] newArray(int i2) {
                return new Result[i2];
            }
        }

        /* synthetic */ Result(Parcel parcel, a aVar) {
            this(parcel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result a(Request request, String str) {
            return new Result(request, Code.CANCEL, null, str, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result b(Request request, String str, String str2) {
            return c(request, str, str2, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result c(Request request, String str, String str2, String str3) {
            return new Result(request, Code.ERROR, null, TextUtils.join(": ", x.c(str, str2)), str3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static Result f(Request request, AccessToken accessToken) {
            return new Result(request, Code.SUCCESS, accessToken, null, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.a.name());
            parcel.writeParcelable(this.b, i2);
            parcel.writeString(this.c);
            parcel.writeString(this.f3121d);
            parcel.writeParcelable(this.f3122e, i2);
            x.z0(parcel, this.loggingExtras);
            x.z0(parcel, this.extraData);
        }

        Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            y.l(code, "code");
            this.f3122e = request;
            this.b = accessToken;
            this.c = str;
            this.a = code;
            this.f3121d = str2;
        }

        private Result(Parcel parcel) {
            this.a = Code.valueOf(parcel.readString());
            this.b = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.c = parcel.readString();
            this.f3121d = parcel.readString();
            this.f3122e = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = x.j0(parcel);
            this.extraData = x.j0(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<LoginClient> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LoginClient createFromParcel(Parcel parcel) {
            return new LoginClient(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LoginClient[] newArray(int i2) {
            return new LoginClient[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Result result);
    }

    public LoginClient(Fragment fragment) {
        this.b = -1;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        this.c = fragment;
    }

    private void C(Result result) {
        c cVar = this.f3115d;
        if (cVar != null) {
            cVar.a(result);
        }
    }

    private void a(String str, String str2, boolean z) {
        if (this.f3119h == null) {
            this.f3119h = new HashMap();
        }
        if (this.f3119h.containsKey(str) && z) {
            str2 = this.f3119h.get(str) + "," + str2;
        }
        this.f3119h.put(str, str2);
    }

    private void k() {
        h(Result.b(this.f3118g, "Login attempt failed.", null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    private com.facebook.login.c r() {
        com.facebook.login.c cVar = this.loginLogger;
        if (cVar == null || !cVar.b().equals(this.f3118g.a())) {
            this.loginLogger = new com.facebook.login.c(l(), this.f3118g.a());
        }
        return this.loginLogger;
    }

    public static int s() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    private void u(String str, Result result, Map<String, String> map) {
        x(str, result.a.getLoggingValue(), result.c, result.f3121d, map);
    }

    private void x(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (this.f3118g == null) {
            r().j("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            r().c(this.f3118g.b(), str, str2, str3, str4, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        b bVar = this.f3116e;
        if (bVar != null) {
            bVar.b();
        }
    }

    public boolean D(int i2, int i3, Intent intent) {
        this.numActivitiesReturned++;
        if (this.f3118g != null) {
            if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.f2242h, false)) {
                J();
                return false;
            } else if (!m().p() || intent != null || this.numActivitiesReturned >= this.numTotalIntentsFired) {
                return m().m(i2, i3, intent);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(b bVar) {
        this.f3116e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(Fragment fragment) {
        if (this.c == null) {
            this.c = fragment;
            return;
        }
        throw new FacebookException("Can't set fragment once it is already set.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(c cVar) {
        this.f3115d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(Request request) {
        if (q()) {
            return;
        }
        b(request);
    }

    boolean I() {
        LoginMethodHandler m = m();
        if (m.l() && !f()) {
            a("no_internet_permission", "1", false);
            return false;
        }
        int q = m.q(this.f3118g);
        this.numActivitiesReturned = 0;
        if (q > 0) {
            r().e(this.f3118g.b(), m.h());
            this.numTotalIntentsFired = q;
        } else {
            r().d(this.f3118g.b(), m.h());
            a("not_tried", m.h(), true);
        }
        return q > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        int i2;
        if (this.b >= 0) {
            x(m().h(), TJAdUnitConstants.String.VIDEO_SKIPPED, null, null, m().a);
        }
        do {
            LoginMethodHandler[] loginMethodHandlerArr = this.a;
            if (loginMethodHandlerArr != null && (i2 = this.b) < loginMethodHandlerArr.length - 1) {
                this.b = i2 + 1;
            } else if (this.f3118g != null) {
                k();
                return;
            } else {
                return;
            }
        } while (!I());
    }

    void K(Result result) {
        Result b2;
        if (result.b != null) {
            AccessToken j2 = AccessToken.j();
            AccessToken accessToken = result.b;
            if (j2 != null && accessToken != null) {
                try {
                    if (j2.u().equals(accessToken.u())) {
                        b2 = Result.f(this.f3118g, result.b);
                        h(b2);
                        return;
                    }
                } catch (Exception e2) {
                    h(Result.b(this.f3118g, "Caught exception", e2.getMessage()));
                    return;
                }
            }
            b2 = Result.b(this.f3118g, "User logged in as different Facebook user.", null);
            h(b2);
            return;
        }
        throw new FacebookException("Can't validate without a token");
    }

    void b(Request request) {
        if (request == null) {
            return;
        }
        if (this.f3118g == null) {
            if (!AccessToken.x() || f()) {
                this.f3118g = request;
                this.a = p(request);
                J();
                return;
            }
            return;
        }
        throw new FacebookException("Attempted to authorize while a request is pending.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.b >= 0) {
            m().b();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    boolean f() {
        if (this.f3117f) {
            return true;
        }
        if (g("android.permission.INTERNET") != 0) {
            FragmentActivity l2 = l();
            h(Result.b(this.f3118g, l2.getString(R.string.com_facebook_internet_permission_error_title), l2.getString(R.string.com_facebook_internet_permission_error_message)));
            return false;
        }
        this.f3117f = true;
        return true;
    }

    int g(String str) {
        return l().checkCallingOrSelfPermission(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Result result) {
        LoginMethodHandler m = m();
        if (m != null) {
            u(m.h(), result, m.a);
        }
        Map<String, String> map = this.f3119h;
        if (map != null) {
            result.loggingExtras = map;
        }
        Map<String, String> map2 = this.f3120i;
        if (map2 != null) {
            result.extraData = map2;
        }
        this.a = null;
        this.b = -1;
        this.f3118g = null;
        this.f3119h = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        C(result);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Result result) {
        if (result.b != null && AccessToken.x()) {
            K(result);
        } else {
            h(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentActivity l() {
        return this.c.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginMethodHandler m() {
        int i2 = this.b;
        if (i2 >= 0) {
            return this.a[i2];
        }
        return null;
    }

    public Fragment o() {
        return this.c;
    }

    protected LoginMethodHandler[] p(Request request) {
        ArrayList arrayList = new ArrayList();
        LoginBehavior j2 = request.j();
        if (j2.allowsGetTokenAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (j2.allowsKatanaAuth()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (j2.allowsFacebookLiteAuth()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (j2.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (j2.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (j2.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        return loginMethodHandlerArr;
    }

    boolean q() {
        return this.f3118g != null && this.b >= 0;
    }

    public Request t() {
        return this.f3118g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelableArray(this.a, i2);
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.f3118g, i2);
        x.z0(parcel, this.f3119h);
        x.z0(parcel, this.f3120i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        b bVar = this.f3116e;
        if (bVar != null) {
            bVar.a();
        }
    }

    public LoginClient(Parcel parcel) {
        this.b = -1;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.a = new LoginMethodHandler[readParcelableArray.length];
        for (int i2 = 0; i2 < readParcelableArray.length; i2++) {
            LoginMethodHandler[] loginMethodHandlerArr = this.a;
            loginMethodHandlerArr[i2] = (LoginMethodHandler) readParcelableArray[i2];
            loginMethodHandlerArr[i2].o(this);
        }
        this.b = parcel.readInt();
        this.f3118g = (Request) parcel.readParcelable(Request.class.getClassLoader());
        this.f3119h = x.j0(parcel);
        this.f3120i = x.j0(parcel);
    }
}
