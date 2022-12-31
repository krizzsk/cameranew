package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.f;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.n;
import com.facebook.internal.y;
import com.facebook.login.LoginClient;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes.dex */
public class LoginManager {

    /* renamed from: e  reason: collision with root package name */
    private static final Set<String> f3123e = e();

    /* renamed from: f  reason: collision with root package name */
    private static volatile LoginManager f3124f;
    private final SharedPreferences c;
    private LoginBehavior a = LoginBehavior.NATIVE_WITH_FALLBACK;
    private DefaultAudience b = DefaultAudience.FRIENDS;

    /* renamed from: d  reason: collision with root package name */
    private String f3125d = "rerequest";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements CallbackManagerImpl.a {
        final /* synthetic */ com.facebook.e a;

        a(com.facebook.e eVar) {
            this.a = eVar;
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            return LoginManager.this.p(i2, intent, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements CallbackManagerImpl.a {
        b() {
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            return LoginManager.this.o(i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements com.facebook.login.e {
        private final Activity a;

        c(Activity activity) {
            y.l(activity, "activity");
            this.a = activity;
        }

        @Override // com.facebook.login.e
        public void a(Intent intent, int i2) {
            this.a.startActivityForResult(intent, i2);
        }

        @Override // com.facebook.login.e
        public Activity b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements com.facebook.login.e {
        private final n a;

        d(n nVar) {
            y.l(nVar, "fragment");
            this.a = nVar;
        }

        @Override // com.facebook.login.e
        public void a(Intent intent, int i2) {
            this.a.d(intent, i2);
        }

        @Override // com.facebook.login.e
        public Activity b() {
            return this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e {
        private static com.facebook.login.c a;

        /* JADX INFO: Access modifiers changed from: private */
        public static synchronized com.facebook.login.c b(Context context) {
            synchronized (e.class) {
                if (context == null) {
                    context = f.f();
                }
                if (context == null) {
                    return null;
                }
                if (a == null) {
                    a = new com.facebook.login.c(context, f.g());
                }
                return a;
            }
        }
    }

    LoginManager() {
        y.n();
        this.c = f.f().getSharedPreferences("com.facebook.loginManager", 0);
        if (!f.q || com.facebook.internal.e.a() == null) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(f.f(), "com.android.chrome", new com.facebook.login.a());
        CustomTabsClient.connectAndInitialize(f.f(), f.f().getPackageName());
    }

    static com.facebook.login.d a(LoginClient.Request request, AccessToken accessToken) {
        Set<String> k2 = request.k();
        HashSet hashSet = new HashSet(accessToken.q());
        if (request.m()) {
            hashSet.retainAll(k2);
        }
        HashSet hashSet2 = new HashSet(k2);
        hashSet2.removeAll(hashSet);
        return new com.facebook.login.d(accessToken, hashSet, hashSet2);
    }

    private void c(AccessToken accessToken, LoginClient.Request request, FacebookException facebookException, boolean z, com.facebook.e<com.facebook.login.d> eVar) {
        if (accessToken != null) {
            AccessToken.B(accessToken);
            Profile.b();
        }
        if (eVar != null) {
            com.facebook.login.d a2 = accessToken != null ? a(request, accessToken) : null;
            if (z || (a2 != null && a2.b().size() == 0)) {
                eVar.onCancel();
            } else if (facebookException != null) {
                eVar.onError(facebookException);
            } else if (accessToken != null) {
                s(true);
                eVar.onSuccess(a2);
            }
        }
    }

    private static Set<String> e() {
        return Collections.unmodifiableSet(new HashSet<String>() { // from class: com.facebook.login.LoginManager.2
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str) {
        return str != null && (str.startsWith("publish") || str.startsWith("manage") || f3123e.contains(str));
    }

    private void g(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        com.facebook.login.c b2 = e.b(context);
        if (b2 == null) {
            return;
        }
        if (request == null) {
            b2.i("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("try_login_activity", z ? "1" : "0");
        b2.f(request.b(), hashMap, code, map, exc);
    }

    public static LoginManager getInstance() {
        if (f3124f == null) {
            synchronized (LoginManager.class) {
                if (f3124f == null) {
                    f3124f = new LoginManager();
                }
            }
        }
        return f3124f;
    }

    private void l(n nVar, Collection<String> collection) {
        v(collection);
        i(nVar, collection);
    }

    private void n(Context context, LoginClient.Request request) {
        com.facebook.login.c b2 = e.b(context);
        if (b2 == null || request == null) {
            return;
        }
        b2.h(request);
    }

    private boolean r(Intent intent) {
        return f.f().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private void s(boolean z) {
        SharedPreferences.Editor edit = this.c.edit();
        edit.putBoolean("express_login_allowed", z);
        edit.apply();
    }

    private void t(com.facebook.login.e eVar, LoginClient.Request request) throws FacebookException {
        n(eVar.b(), request);
        CallbackManagerImpl.c(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new b());
        if (u(eVar, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        g(eVar.b(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    private boolean u(com.facebook.login.e eVar, LoginClient.Request request) {
        Intent d2 = d(request);
        if (r(d2)) {
            try {
                eVar.a(d2, LoginClient.s());
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
        return false;
    }

    private void v(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (f(str)) {
                throw new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", str));
            }
        }
    }

    protected LoginClient.Request b(Collection<String> collection) {
        LoginClient.Request request = new LoginClient.Request(this.a, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.b, this.f3125d, f.g(), UUID.randomUUID().toString());
        request.o(AccessToken.x());
        return request;
    }

    protected Intent d(LoginClient.Request request) {
        Intent intent = new Intent();
        intent.setClass(f.f(), FacebookActivity.class);
        intent.setAction(request.j().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable(SocialConstants.TYPE_REQUEST, request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        return intent;
    }

    public void h(Activity activity, Collection<String> collection) {
        t(new c(activity), b(collection));
    }

    public void i(n nVar, Collection<String> collection) {
        t(new d(nVar), b(collection));
    }

    public void j(Activity activity, Collection<String> collection) {
        v(collection);
        h(activity, collection);
    }

    public void k(Fragment fragment, Collection<String> collection) {
        l(new n(fragment), collection);
    }

    public void m() {
        AccessToken.B(null);
        Profile.f(null);
        s(false);
    }

    boolean o(int i2, Intent intent) {
        return p(i2, intent, null);
    }

    boolean p(int i2, Intent intent, com.facebook.e<com.facebook.login.d> eVar) {
        LoginClient.Result.Code code;
        AccessToken accessToken;
        LoginClient.Request request;
        Map<String, String> map;
        boolean z;
        Map<String, String> map2;
        LoginClient.Request request2;
        boolean z2;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z3 = false;
        if (intent != null) {
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                LoginClient.Request request3 = result.f3122e;
                LoginClient.Result.Code code3 = result.a;
                if (i2 == -1) {
                    if (code3 == LoginClient.Result.Code.SUCCESS) {
                        accessToken = result.b;
                    } else {
                        facebookException = new FacebookAuthorizationException(result.c);
                        accessToken = null;
                    }
                } else if (i2 == 0) {
                    accessToken = null;
                    z3 = true;
                } else {
                    accessToken = null;
                }
                map2 = result.loggingExtras;
                boolean z4 = z3;
                request2 = request3;
                code2 = code3;
                z2 = z4;
            } else {
                accessToken = null;
                map2 = null;
                request2 = null;
                z2 = false;
            }
            map = map2;
            code = code2;
            request = request2;
            z = z2;
        } else if (i2 == 0) {
            code = LoginClient.Result.Code.CANCEL;
            accessToken = null;
            request = null;
            map = null;
            z = true;
        } else {
            code = code2;
            accessToken = null;
            request = null;
            map = null;
            z = false;
        }
        if (facebookException == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        g(null, code, map, facebookException, true, request);
        c(accessToken, request, facebookException, z, eVar);
        return true;
    }

    public void q(com.facebook.d dVar, com.facebook.e<com.facebook.login.d> eVar) {
        if (dVar instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) dVar).b(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new a(eVar));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }
}
