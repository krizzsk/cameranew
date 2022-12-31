package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.i;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.m;
import com.facebook.internal.u;
import com.facebook.share.internal.LikeContent;
import com.facebook.share.widget.LikeView;
import com.tapjoy.TapjoyAuctionFlags;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: LikeActionController.java */
@Deprecated
/* loaded from: classes.dex */
public class c {
    private static final String o = "c";
    private static com.facebook.internal.m p;
    private static final ConcurrentHashMap<String, c> q = new ConcurrentHashMap<>();
    private static com.facebook.internal.z r = new com.facebook.internal.z(1);
    private static com.facebook.internal.z s = new com.facebook.internal.z(1);
    private static Handler t;
    private static String u;
    private static boolean v;
    private static volatile int w;
    private String a;
    private LikeView.ObjectType b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private String f3199d;

    /* renamed from: e  reason: collision with root package name */
    private String f3200e;

    /* renamed from: f  reason: collision with root package name */
    private String f3201f;

    /* renamed from: g  reason: collision with root package name */
    private String f3202g;

    /* renamed from: h  reason: collision with root package name */
    private String f3203h;

    /* renamed from: i  reason: collision with root package name */
    private String f3204i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3205j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3206k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3207l;
    private Bundle m;
    private InternalAppEventsLogger n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class a implements u.b {
        a() {
        }

        @Override // com.facebook.internal.u.b
        public void a(Bundle bundle) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            if (bundle == null || !bundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                return;
            }
            boolean z = bundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
            if (!bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                str = c.this.f3199d;
            } else {
                str = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
            }
            String str6 = str;
            if (!bundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                str2 = c.this.f3200e;
            } else {
                str2 = bundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
            }
            String str7 = str2;
            if (!bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                str3 = c.this.f3201f;
            } else {
                str3 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
            }
            String str8 = str3;
            if (!bundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                str4 = c.this.f3202g;
            } else {
                str4 = bundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
            }
            String str9 = str4;
            if (!bundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                str5 = c.this.f3203h;
            } else {
                str5 = bundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
            }
            c.this.u0(z, str6, str7, str8, str9, str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class a0 implements Runnable {
        private String a;
        private String b;

        a0(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.o0(this.a, this.b);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class b implements i.a {
        final /* synthetic */ q a;
        final /* synthetic */ s b;
        final /* synthetic */ y c;

        b(q qVar, s sVar, y yVar) {
            this.a = qVar;
            this.b = sVar;
            this.c = yVar;
        }

        @Override // com.facebook.i.a
        public void a(com.facebook.i iVar) {
            FacebookRequestError b;
            c.this.f3204i = this.a.f3215e;
            if (com.facebook.internal.x.S(c.this.f3204i)) {
                c.this.f3204i = this.b.f3221e;
                c.this.f3205j = this.b.f3222f;
            }
            if (com.facebook.internal.x.S(c.this.f3204i)) {
                com.facebook.internal.r.h(LoggingBehavior.DEVELOPER_ERRORS, c.o, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", c.this.a);
                c cVar = c.this;
                if (this.b.b() != null) {
                    b = this.b.b();
                } else {
                    b = this.a.b();
                }
                cVar.Z("get_verified_id", b);
            }
            y yVar = this.c;
            if (yVar != null) {
                yVar.onComplete();
            }
        }
    }

    /* compiled from: LikeActionController.java */
    /* renamed from: com.facebook.share.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0118c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LikeView.ObjectType.values().length];
            a = iArr;
            try {
                iArr[LikeView.ObjectType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class d implements o {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ Intent c;

        d(int i2, int i3, Intent intent) {
            this.a = i2;
            this.b = i3;
            this.c = intent;
        }

        @Override // com.facebook.share.internal.c.o
        public void a(c cVar, FacebookException facebookException) {
            if (facebookException == null) {
                cVar.a0(this.a, this.b, this.c);
            } else {
                com.facebook.internal.x.X(c.o, facebookException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.this.j0();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class f implements CallbackManagerImpl.a {
        f() {
        }

        @Override // com.facebook.internal.CallbackManagerImpl.a
        public boolean onActivityResult(int i2, Intent intent) {
            return c.V(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class g implements Runnable {
        final /* synthetic */ o a;
        final /* synthetic */ c b;
        final /* synthetic */ FacebookException c;

        g(o oVar, c cVar, FacebookException facebookException) {
            this.a = oVar;
            this.b = cVar;
            this.c = facebookException;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.a(this.b, this.c);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class h extends com.facebook.c {
        h() {
        }

        @Override // com.facebook.c
        protected void c(AccessToken accessToken, AccessToken accessToken2) {
            Context f2 = com.facebook.f.f();
            if (accessToken2 == null) {
                int unused = c.w = (c.w + 1) % 1000;
                f2.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", c.w).apply();
                c.q.clear();
                c.p.e();
            }
            c.F(null, "com.facebook.sdk.LikeActionController.DID_RESET");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class i extends com.facebook.share.internal.i {
        final /* synthetic */ Bundle b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(com.facebook.e eVar, Bundle bundle) {
            super(eVar);
            this.b = bundle;
        }

        @Override // com.facebook.share.internal.i
        public void a(com.facebook.internal.a aVar) {
            b(aVar, new FacebookOperationCanceledException());
        }

        @Override // com.facebook.share.internal.i
        public void b(com.facebook.internal.a aVar, FacebookException facebookException) {
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Like Dialog failed with error : %s", facebookException);
            Bundle bundle = this.b;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("call_id", aVar.b().toString());
            c.this.Y("present_dialog", bundle);
            c.G(c.this, "com.facebook.sdk.LikeActionController.DID_ERROR", com.facebook.internal.t.i(facebookException));
        }

        @Override // com.facebook.share.internal.i
        public void c(com.facebook.internal.a aVar, Bundle bundle) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            if (bundle == null || !bundle.containsKey("object_is_liked")) {
                return;
            }
            boolean z = bundle.getBoolean("object_is_liked");
            String str6 = c.this.f3199d;
            String str7 = c.this.f3200e;
            if (bundle.containsKey("like_count_string")) {
                str = bundle.getString("like_count_string");
                str2 = str;
            } else {
                str = str6;
                str2 = str7;
            }
            String str8 = c.this.f3201f;
            String str9 = c.this.f3202g;
            if (bundle.containsKey("social_sentence")) {
                str3 = bundle.getString("social_sentence");
                str4 = str3;
            } else {
                str3 = str8;
                str4 = str9;
            }
            if (!bundle.containsKey("object_is_liked")) {
                str5 = c.this.f3203h;
            } else {
                str5 = bundle.getString("unlike_token");
            }
            String str10 = str5;
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putString("call_id", aVar.b().toString());
            c.this.N().j("fb_like_control_dialog_did_succeed", bundle2);
            c.this.u0(z, str, str2, str3, str4, str10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class j implements y {
        final /* synthetic */ Bundle a;

        /* compiled from: LikeActionController.java */
        /* loaded from: classes.dex */
        class a implements i.a {
            final /* synthetic */ w a;

            a(w wVar) {
                this.a = wVar;
            }

            @Override // com.facebook.i.a
            public void a(com.facebook.i iVar) {
                c.this.f3207l = false;
                if (this.a.b() != null) {
                    c.this.e0(false);
                    return;
                }
                c.this.f3203h = com.facebook.internal.x.i(this.a.f3226e, null);
                c.this.f3206k = true;
                c.this.N().k("fb_like_control_did_like", null, j.this.a);
                j jVar = j.this;
                c.this.d0(jVar.a);
            }
        }

        j(Bundle bundle) {
            this.a = bundle;
        }

        @Override // com.facebook.share.internal.c.y
        public void onComplete() {
            if (com.facebook.internal.x.S(c.this.f3204i)) {
                Bundle bundle = new Bundle();
                bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
                c.G(c.this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
                return;
            }
            com.facebook.i iVar = new com.facebook.i();
            c cVar = c.this;
            w wVar = new w(cVar.f3204i, c.this.b);
            wVar.a(iVar);
            iVar.c(new a(wVar));
            iVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class k implements i.a {
        final /* synthetic */ x a;
        final /* synthetic */ Bundle b;

        k(x xVar, Bundle bundle) {
            this.a = xVar;
            this.b = bundle;
        }

        @Override // com.facebook.i.a
        public void a(com.facebook.i iVar) {
            c.this.f3207l = false;
            if (this.a.b() != null) {
                c.this.e0(true);
                return;
            }
            c.this.f3203h = null;
            c.this.f3206k = false;
            c.this.N().k("fb_like_control_did_unlike", null, this.b);
            c.this.d0(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class l implements y {

        /* compiled from: LikeActionController.java */
        /* loaded from: classes.dex */
        class a implements i.a {
            final /* synthetic */ u a;
            final /* synthetic */ p b;

            a(u uVar, p pVar) {
                this.a = uVar;
                this.b = pVar;
            }

            @Override // com.facebook.i.a
            public void a(com.facebook.i iVar) {
                if (this.a.b() == null && this.b.b() == null) {
                    c cVar = c.this;
                    boolean c = this.a.c();
                    p pVar = this.b;
                    cVar.u0(c, pVar.f3210e, pVar.f3211f, pVar.f3212g, pVar.f3213h, this.a.d());
                    return;
                }
                com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Unable to refresh like state for id: '%s'", c.this.a);
            }
        }

        l() {
        }

        @Override // com.facebook.share.internal.c.y
        public void onComplete() {
            u tVar;
            if (C0118c.a[c.this.b.ordinal()] != 1) {
                c cVar = c.this;
                tVar = new r(cVar.f3204i, c.this.b);
            } else {
                c cVar2 = c.this;
                tVar = new t(cVar2.f3204i);
            }
            c cVar3 = c.this;
            p pVar = new p(cVar3.f3204i, c.this.b);
            com.facebook.i iVar = new com.facebook.i();
            tVar.a(iVar);
            pVar.a(iVar);
            iVar.c(new a(tVar, pVar));
            iVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public abstract class m implements z {
        private GraphRequest a;
        protected String b;
        protected LikeView.ObjectType c;

        /* renamed from: d  reason: collision with root package name */
        protected FacebookRequestError f3209d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LikeActionController.java */
        /* loaded from: classes.dex */
        public class a implements GraphRequest.e {
            a() {
            }

            @Override // com.facebook.GraphRequest.e
            public void a(GraphResponse graphResponse) {
                m.this.f3209d = graphResponse.g();
                m mVar = m.this;
                FacebookRequestError facebookRequestError = mVar.f3209d;
                if (facebookRequestError != null) {
                    mVar.e(facebookRequestError);
                } else {
                    mVar.f(graphResponse);
                }
            }
        }

        protected m(c cVar, String str, LikeView.ObjectType objectType) {
            this.b = str;
            this.c = objectType;
        }

        @Override // com.facebook.share.internal.c.z
        public void a(com.facebook.i iVar) {
            iVar.add(this.a);
        }

        @Override // com.facebook.share.internal.c.z
        public FacebookRequestError b() {
            return this.f3209d;
        }

        protected abstract void e(FacebookRequestError facebookRequestError);

        protected abstract void f(GraphResponse graphResponse);

        protected void g(GraphRequest graphRequest) {
            this.a = graphRequest;
            graphRequest.c0(com.facebook.f.r());
            graphRequest.V(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class n implements Runnable {
        private String a;
        private LikeView.ObjectType b;
        private o c;

        n(String str, LikeView.ObjectType objectType, o oVar) {
            this.a = str;
            this.b = objectType;
            this.c = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                c.J(this.a, this.b, this.c);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: LikeActionController.java */
    @Deprecated
    /* loaded from: classes.dex */
    public interface o {
        void a(c cVar, FacebookException facebookException);
    }

    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    private class p extends m {

        /* renamed from: e  reason: collision with root package name */
        String f3210e;

        /* renamed from: f  reason: collision with root package name */
        String f3211f;

        /* renamed from: g  reason: collision with root package name */
        String f3212g;

        /* renamed from: h  reason: collision with root package name */
        String f3213h;

        p(String str, LikeView.ObjectType objectType) {
            super(c.this, str, objectType);
            this.f3210e = c.this.f3199d;
            this.f3211f = c.this.f3200e;
            this.f3212g = c.this.f3201f;
            this.f3213h = c.this.f3202g;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            bundle.putString("locale", Locale.getDefault().toString());
            g(new GraphRequest(AccessToken.j(), str, bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error fetching engagement for object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
            c.this.Z("get_engagement", facebookRequestError);
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
            JSONObject x0 = com.facebook.internal.x.x0(graphResponse.h(), "engagement");
            if (x0 != null) {
                this.f3210e = x0.optString("count_string_with_like", this.f3210e);
                this.f3211f = x0.optString("count_string_without_like", this.f3211f);
                this.f3212g = x0.optString("social_sentence_with_like", this.f3212g);
                this.f3213h = x0.optString("social_sentence_without_like", this.f3213h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class q extends m {

        /* renamed from: e  reason: collision with root package name */
        String f3215e;

        q(c cVar, String str, LikeView.ObjectType objectType) {
            super(cVar, str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", "og_object.fields(id)");
            bundle.putString("ids", str);
            g(new GraphRequest(AccessToken.j(), "", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.f().contains("og_object")) {
                this.f3209d = null;
            } else {
                com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error getting the FB id for object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
            }
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
            JSONObject optJSONObject;
            JSONObject x0 = com.facebook.internal.x.x0(graphResponse.h(), this.b);
            if (x0 == null || (optJSONObject = x0.optJSONObject("og_object")) == null) {
                return;
            }
            this.f3215e = optJSONObject.optString(TapjoyAuctionFlags.AUCTION_ID);
        }
    }

    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    private class r extends m implements u {

        /* renamed from: e  reason: collision with root package name */
        private boolean f3216e;

        /* renamed from: f  reason: collision with root package name */
        private String f3217f;

        /* renamed from: g  reason: collision with root package name */
        private final String f3218g;

        /* renamed from: h  reason: collision with root package name */
        private final LikeView.ObjectType f3219h;

        r(String str, LikeView.ObjectType objectType) {
            super(c.this, str, objectType);
            this.f3216e = c.this.c;
            this.f3218g = str;
            this.f3219h = objectType;
            Bundle bundle = new Bundle();
            bundle.putString("fields", "id,application");
            bundle.putString("object", str);
            g(new GraphRequest(AccessToken.j(), "me/og.likes", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.c.u
        public boolean c() {
            return this.f3216e;
        }

        @Override // com.facebook.share.internal.c.u
        public String d() {
            return this.f3217f;
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error fetching like status for object '%s' with type '%s' : %s", this.f3218g, this.f3219h, facebookRequestError);
            c.this.Z("get_og_object_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
            JSONArray w0 = com.facebook.internal.x.w0(graphResponse.h(), "data");
            if (w0 != null) {
                for (int i2 = 0; i2 < w0.length(); i2++) {
                    JSONObject optJSONObject = w0.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.f3216e = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken j2 = AccessToken.j();
                        if (optJSONObject2 != null && AccessToken.x() && com.facebook.internal.x.b(j2.h(), optJSONObject2.optString(TapjoyAuctionFlags.AUCTION_ID))) {
                            this.f3217f = optJSONObject.optString(TapjoyAuctionFlags.AUCTION_ID);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class s extends m {

        /* renamed from: e  reason: collision with root package name */
        String f3221e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3222f;

        s(c cVar, String str, LikeView.ObjectType objectType) {
            super(cVar, str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("fields", TapjoyAuctionFlags.AUCTION_ID);
            bundle.putString("ids", str);
            g(new GraphRequest(AccessToken.j(), "", bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error getting the FB id for object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
            JSONObject x0 = com.facebook.internal.x.x0(graphResponse.h(), this.b);
            if (x0 != null) {
                String optString = x0.optString(TapjoyAuctionFlags.AUCTION_ID);
                this.f3221e = optString;
                this.f3222f = !com.facebook.internal.x.S(optString);
            }
        }
    }

    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    private class t extends m implements u {

        /* renamed from: e  reason: collision with root package name */
        private boolean f3223e;

        /* renamed from: f  reason: collision with root package name */
        private String f3224f;

        t(String str) {
            super(c.this, str, LikeView.ObjectType.PAGE);
            this.f3223e = c.this.c;
            this.f3224f = str;
            Bundle bundle = new Bundle();
            bundle.putString("fields", TapjoyAuctionFlags.AUCTION_ID);
            AccessToken j2 = AccessToken.j();
            g(new GraphRequest(j2, "me/likes/" + str, bundle, HttpMethod.GET));
        }

        @Override // com.facebook.share.internal.c.u
        public boolean c() {
            return this.f3223e;
        }

        @Override // com.facebook.share.internal.c.u
        public String d() {
            return null;
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error fetching like status for page id '%s': %s", this.f3224f, facebookRequestError);
            c.this.Z("get_page_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
            JSONArray w0 = com.facebook.internal.x.w0(graphResponse.h(), "data");
            if (w0 == null || w0.length() <= 0) {
                return;
            }
            this.f3223e = true;
        }
    }

    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    private interface u extends z {
        boolean c();

        String d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public static class v implements Runnable {
        private static ArrayList<String> c = new ArrayList<>();
        private String a;
        private boolean b;

        v(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                String str = this.a;
                if (str != null) {
                    c.remove(str);
                    c.add(0, this.a);
                }
                if (!this.b || c.size() < 128) {
                    return;
                }
                while (64 < c.size()) {
                    ArrayList<String> arrayList = c;
                    c.q.remove(arrayList.remove(arrayList.size() - 1));
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    private class w extends m {

        /* renamed from: e  reason: collision with root package name */
        String f3226e;

        w(String str, LikeView.ObjectType objectType) {
            super(c.this, str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            g(new GraphRequest(AccessToken.j(), "me/og.likes", bundle, HttpMethod.POST));
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.c() == 3501) {
                this.f3209d = null;
                return;
            }
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error liking object '%s' with type '%s' : %s", this.b, this.c, facebookRequestError);
            c.this.Z("publish_like", facebookRequestError);
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
            this.f3226e = com.facebook.internal.x.r0(graphResponse.h(), TapjoyAuctionFlags.AUCTION_ID);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public class x extends m {

        /* renamed from: e  reason: collision with root package name */
        private String f3228e;

        x(String str) {
            super(c.this, null, null);
            this.f3228e = str;
            g(new GraphRequest(AccessToken.j(), str, null, HttpMethod.DELETE));
        }

        @Override // com.facebook.share.internal.c.m
        protected void e(FacebookRequestError facebookRequestError) {
            com.facebook.internal.r.h(LoggingBehavior.REQUESTS, c.o, "Error unliking object with unlike token '%s' : %s", this.f3228e, facebookRequestError);
            c.this.Z("publish_unlike", facebookRequestError);
        }

        @Override // com.facebook.share.internal.c.m
        protected void f(GraphResponse graphResponse) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    public interface y {
        void onComplete();
    }

    /* compiled from: LikeActionController.java */
    /* loaded from: classes.dex */
    private interface z {
        void a(com.facebook.i iVar);

        FacebookRequestError b();
    }

    private c(String str, LikeView.ObjectType objectType) {
        this.a = str;
        this.b = objectType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(c cVar, String str) {
        G(cVar, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(c cVar, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (cVar != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", cVar.S());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(com.facebook.f.f()).sendBroadcast(intent);
    }

    private boolean H() {
        AccessToken j2 = AccessToken.j();
        return (this.f3205j || this.f3204i == null || !AccessToken.x() || j2.q() == null || !j2.q().contains("publish_actions")) ? false : true;
    }

    private void I() {
        this.m = null;
        r0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(String str, LikeView.ObjectType objectType, o oVar) {
        c Q = Q(str);
        if (Q != null) {
            v0(Q, objectType, oVar);
            return;
        }
        c K = K(str);
        if (K == null) {
            K = new c(str, objectType);
            n0(K);
        }
        i0(str, K);
        t.post(new e());
        W(oVar, K, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r5 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        com.facebook.internal.x.h(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r5 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.facebook.share.internal.c K(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.String r5 = O(r5)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            com.facebook.internal.m r1 = com.facebook.share.internal.c.p     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            java.io.InputStream r5 = r1.f(r5)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L29
            if (r5 == 0) goto L1e
            java.lang.String r1 = com.facebook.internal.x.i0(r5)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            boolean r2 = com.facebook.internal.x.S(r1)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            if (r2 != 0) goto L1e
            com.facebook.share.internal.c r0 = L(r1)     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L36
            goto L1e
        L1c:
            r1 = move-exception
            goto L2b
        L1e:
            if (r5 == 0) goto L35
        L20:
            com.facebook.internal.x.h(r5)
            goto L35
        L24:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L37
        L29:
            r1 = move-exception
            r5 = r0
        L2b:
            java.lang.String r2 = com.facebook.share.internal.c.o     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "Unable to deserialize controller from disk"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L35
            goto L20
        L35:
            return r0
        L36:
            r0 = move-exception
        L37:
            if (r5 == 0) goto L3c
            com.facebook.internal.x.h(r5)
        L3c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.c.K(java.lang.String):com.facebook.share.internal.c");
    }

    private static c L(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
                return null;
            }
            c cVar = new c(jSONObject.getString("object_id"), LikeView.ObjectType.fromInt(jSONObject.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
            cVar.f3199d = jSONObject.optString("like_count_string_with_like", null);
            cVar.f3200e = jSONObject.optString("like_count_string_without_like", null);
            cVar.f3201f = jSONObject.optString("social_sentence_with_like", null);
            cVar.f3202g = jSONObject.optString("social_sentence_without_like", null);
            cVar.c = jSONObject.optBoolean("is_object_liked");
            cVar.f3203h = jSONObject.optString("unlike_token", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("facebook_dialog_analytics_bundle");
            if (optJSONObject != null) {
                cVar.m = com.facebook.internal.c.a(optJSONObject);
            }
            return cVar;
        } catch (JSONException e2) {
            Log.e(o, "Unable to deserialize controller from JSON", e2);
            return null;
        }
    }

    private void M(y yVar) {
        if (!com.facebook.internal.x.S(this.f3204i)) {
            if (yVar != null) {
                yVar.onComplete();
                return;
            }
            return;
        }
        q qVar = new q(this, this.a, this.b);
        s sVar = new s(this, this.a, this.b);
        com.facebook.i iVar = new com.facebook.i();
        qVar.a(iVar);
        sVar.a(iVar);
        iVar.c(new b(qVar, sVar, yVar));
        iVar.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InternalAppEventsLogger N() {
        if (this.n == null) {
            this.n = new InternalAppEventsLogger(com.facebook.f.f());
        }
        return this.n;
    }

    private static String O(String str) {
        String t2 = AccessToken.x() ? AccessToken.j().t() : null;
        if (t2 != null) {
            t2 = com.facebook.internal.x.c0(t2);
        }
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", str, com.facebook.internal.x.i(t2, ""), Integer.valueOf(w));
    }

    @Deprecated
    public static void P(String str, LikeView.ObjectType objectType, o oVar) {
        if (!v) {
            b0();
        }
        c Q = Q(str);
        if (Q != null) {
            v0(Q, objectType, oVar);
        } else {
            s.b(new n(str, objectType, oVar));
        }
    }

    private static c Q(String str) {
        String O = O(str);
        c cVar = q.get(O);
        if (cVar != null) {
            r.b(new v(O, false));
        }
        return cVar;
    }

    private com.facebook.share.internal.i T(Bundle bundle) {
        return new i(null, bundle);
    }

    @Deprecated
    public static boolean V(int i2, int i3, Intent intent) {
        if (com.facebook.internal.x.S(u)) {
            u = com.facebook.f.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
        }
        if (com.facebook.internal.x.S(u)) {
            return false;
        }
        P(u, LikeView.ObjectType.UNKNOWN, new d(i2, i3, intent));
        return true;
    }

    private static void W(o oVar, c cVar, FacebookException facebookException) {
        if (oVar == null) {
            return;
        }
        t.post(new g(oVar, cVar, facebookException));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("object_id", this.a);
        bundle2.putString("object_type", this.b.toString());
        bundle2.putString("current_action", str);
        N().k("fb_like_control_error", null, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(String str, FacebookRequestError facebookRequestError) {
        JSONObject j2;
        Bundle bundle = new Bundle();
        if (facebookRequestError != null && (j2 = facebookRequestError.j()) != null) {
            bundle.putString("error", j2.toString());
        }
        Y(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i2, int i3, Intent intent) {
        com.facebook.share.internal.k.q(i2, i3, intent, T(this.m));
        I();
    }

    private static synchronized void b0() {
        synchronized (c.class) {
            if (v) {
                return;
            }
            t = new Handler(Looper.getMainLooper());
            w = com.facebook.f.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getInt("OBJECT_SUFFIX", 1);
            p = new com.facebook.internal.m(o, new m.f());
            l0();
            CallbackManagerImpl.c(CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode(), new f());
            v = true;
        }
    }

    private void c0(Activity activity, com.facebook.internal.n nVar, Bundle bundle) {
        String objectType;
        String str = null;
        if (com.facebook.share.internal.d.p()) {
            str = "fb_like_control_did_present_dialog";
        } else if (com.facebook.share.internal.d.q()) {
            str = "fb_like_control_did_present_fallback_dialog";
        } else {
            Y("present_dialog", bundle);
            com.facebook.internal.x.Y(o, "Cannot show the Like Dialog on this device.");
            F(null, "com.facebook.sdk.LikeActionController.UPDATED");
        }
        if (str != null) {
            LikeView.ObjectType objectType2 = this.b;
            if (objectType2 != null) {
                objectType = objectType2.toString();
            } else {
                objectType = LikeView.ObjectType.UNKNOWN.toString();
            }
            LikeContent.b bVar = new LikeContent.b();
            bVar.d(this.a);
            bVar.e(objectType);
            LikeContent c = bVar.c();
            if (nVar != null) {
                new com.facebook.share.internal.d(nVar).k(c);
            } else {
                new com.facebook.share.internal.d(activity).k(c);
            }
            m0(bundle);
            N().j("fb_like_control_did_present_dialog", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(Bundle bundle) {
        boolean z2 = this.c;
        if (z2 == this.f3206k || g0(z2, bundle)) {
            return;
        }
        e0(!this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(boolean z2) {
        t0(z2);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
        G(this, "com.facebook.sdk.LikeActionController.DID_ERROR", bundle);
    }

    private void f0(Bundle bundle) {
        this.f3207l = true;
        M(new j(bundle));
    }

    private boolean g0(boolean z2, Bundle bundle) {
        if (H()) {
            if (z2) {
                f0(bundle);
                return true;
            } else if (!com.facebook.internal.x.S(this.f3203h)) {
                h0(bundle);
                return true;
            }
        }
        return false;
    }

    private void h0(Bundle bundle) {
        this.f3207l = true;
        com.facebook.i iVar = new com.facebook.i();
        x xVar = new x(this.f3203h);
        xVar.a(iVar);
        iVar.c(new k(xVar, bundle));
        iVar.f();
    }

    private static void i0(String str, c cVar) {
        String O = O(str);
        r.b(new v(O, true));
        q.put(O, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        if (!AccessToken.x()) {
            k0();
        } else {
            M(new l());
        }
    }

    private void k0() {
        com.facebook.share.internal.e eVar = new com.facebook.share.internal.e(com.facebook.f.f(), com.facebook.f.g(), this.a);
        if (eVar.g()) {
            eVar.f(new a());
        }
    }

    private static void l0() {
        new h();
    }

    private void m0(Bundle bundle) {
        r0(this.a);
        this.m = bundle;
        n0(this);
    }

    private static void n0(c cVar) {
        String p0 = p0(cVar);
        String O = O(cVar.a);
        if (com.facebook.internal.x.S(p0) || com.facebook.internal.x.S(O)) {
            return;
        }
        s.b(new a0(O, p0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o0(String str, String str2) {
        OutputStream outputStream = null;
        try {
            try {
                outputStream = p.h(str);
                outputStream.write(str2.getBytes());
                if (outputStream == null) {
                    return;
                }
            } catch (IOException e2) {
                Log.e(o, "Unable to serialize controller to disk", e2);
                if (outputStream == null) {
                    return;
                }
            }
            com.facebook.internal.x.h(outputStream);
        } catch (Throwable th) {
            if (outputStream != null) {
                com.facebook.internal.x.h(outputStream);
            }
            throw th;
        }
    }

    private static String p0(c cVar) {
        JSONObject b2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
            jSONObject.put("object_id", cVar.a);
            jSONObject.put("object_type", cVar.b.getValue());
            jSONObject.put("like_count_string_with_like", cVar.f3199d);
            jSONObject.put("like_count_string_without_like", cVar.f3200e);
            jSONObject.put("social_sentence_with_like", cVar.f3201f);
            jSONObject.put("social_sentence_without_like", cVar.f3202g);
            jSONObject.put("is_object_liked", cVar.c);
            jSONObject.put("unlike_token", cVar.f3203h);
            Bundle bundle = cVar.m;
            if (bundle != null && (b2 = com.facebook.internal.c.b(bundle)) != null) {
                jSONObject.put("facebook_dialog_analytics_bundle", b2);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.e(o, "Unable to serialize controller to JSON", e2);
            return null;
        }
    }

    private static void r0(String str) {
        u = str;
        com.facebook.f.f().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", u).apply();
    }

    private void t0(boolean z2) {
        u0(z2, this.f3199d, this.f3200e, this.f3201f, this.f3202g, this.f3203h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(boolean z2, String str, String str2, String str3, String str4, String str5) {
        String i2 = com.facebook.internal.x.i(str, null);
        String i3 = com.facebook.internal.x.i(str2, null);
        String i4 = com.facebook.internal.x.i(str3, null);
        String i5 = com.facebook.internal.x.i(str4, null);
        String i6 = com.facebook.internal.x.i(str5, null);
        if ((z2 == this.c && com.facebook.internal.x.b(i2, this.f3199d) && com.facebook.internal.x.b(i3, this.f3200e) && com.facebook.internal.x.b(i4, this.f3201f) && com.facebook.internal.x.b(i5, this.f3202g) && com.facebook.internal.x.b(i6, this.f3203h)) ? false : true) {
            this.c = z2;
            this.f3199d = i2;
            this.f3200e = i3;
            this.f3201f = i4;
            this.f3202g = i5;
            this.f3203h = i6;
            n0(this);
            F(this, "com.facebook.sdk.LikeActionController.UPDATED");
        }
    }

    private static void v0(c cVar, LikeView.ObjectType objectType, o oVar) {
        LikeView.ObjectType h2 = com.facebook.share.internal.k.h(objectType, cVar.b);
        FacebookException facebookException = null;
        if (h2 == null) {
            Object[] objArr = {cVar.a, cVar.b.toString(), objectType.toString()};
            cVar = null;
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", objArr);
        } else {
            cVar.b = h2;
        }
        W(oVar, cVar, facebookException);
    }

    @Deprecated
    public String R() {
        return this.c ? this.f3199d : this.f3200e;
    }

    @Deprecated
    public String S() {
        return this.a;
    }

    @Deprecated
    public String U() {
        return this.c ? this.f3201f : this.f3202g;
    }

    @Deprecated
    public boolean X() {
        return this.c;
    }

    @Deprecated
    public boolean q0() {
        return false;
    }

    @Deprecated
    public void s0(Activity activity, com.facebook.internal.n nVar, Bundle bundle) {
        boolean z2 = !this.c;
        if (H()) {
            t0(z2);
            if (this.f3207l) {
                N().j("fb_like_control_did_undo_quickly", bundle);
                return;
            } else if (g0(z2, bundle)) {
                return;
            } else {
                t0(!z2);
                c0(activity, nVar, bundle);
                return;
            }
        }
        c0(activity, nVar, bundle);
    }
}
