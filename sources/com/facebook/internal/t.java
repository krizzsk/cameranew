package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.login.DefaultAudience;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: NativeProtocol.java */
/* loaded from: classes.dex */
public final class t {
    private static final String a = "com.facebook.internal.t";
    private static final List<f> b = f();
    private static final List<f> c = e();

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, List<f>> f3083d = d();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f3084e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private static final List<Integer> f3085f = Arrays.asList(20170417, 20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                for (f fVar : t.c()) {
                    fVar.b(true);
                }
                t.b().set(false);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static class b extends f {
        private b() {
            super(null);
        }

        @Override // com.facebook.internal.t.f
        protected String d() {
            return null;
        }

        @Override // com.facebook.internal.t.f
        protected String e() {
            return "com.facebook.arstudio.player";
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    private static class c extends f {
        private c() {
            super(null);
        }

        @Override // com.facebook.internal.t.f
        protected String d() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        @Override // com.facebook.internal.t.f
        protected String e() {
            return "com.facebook.lite";
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static class d extends f {
        private d() {
            super(null);
        }

        @Override // com.facebook.internal.t.f
        protected String d() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.t.f
        protected String e() {
            return "com.facebook.katana";
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static class e extends f {
        private e() {
            super(null);
        }

        @Override // com.facebook.internal.t.f
        protected String d() {
            return null;
        }

        @Override // com.facebook.internal.t.f
        protected String e() {
            return "com.facebook.orca";
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        private TreeSet<Integer> a;

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
            if (r1.isEmpty() == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized void b(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto Ld
                java.util.TreeSet<java.lang.Integer> r1 = r0.a     // Catch: java.lang.Throwable -> L15
                if (r1 == 0) goto Ld
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L15
                if (r1 == 0) goto L13
            Ld:
                java.util.TreeSet r1 = com.facebook.internal.t.a(r0)     // Catch: java.lang.Throwable -> L15
                r0.a = r1     // Catch: java.lang.Throwable -> L15
            L13:
                monitor-exit(r0)
                return
            L15:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.t.f.b(boolean):void");
        }

        public TreeSet<Integer> c() {
            TreeSet<Integer> treeSet = this.a;
            if (treeSet == null || treeSet.isEmpty()) {
                b(false);
            }
            return this.a;
        }

        protected abstract String d();

        protected abstract String e();

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static class g {
        private f a;
        private int b;

        private g() {
        }

        public static g c(f fVar, int i2) {
            g gVar = new g();
            gVar.a = fVar;
            gVar.b = i2;
            return gVar;
        }

        public static g d() {
            g gVar = new g();
            gVar.b = -1;
            return gVar;
        }

        public int e() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.java */
    /* loaded from: classes.dex */
    public static class h extends f {
        private h() {
            super(null);
        }

        @Override // com.facebook.internal.t.f
        protected String d() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.t.f
        protected String e() {
            return "com.facebook.wakizashi";
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    public static Bundle A(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            int z = z(intent);
            Bundle extras = intent.getExtras();
            if (C(z) && extras != null) {
                return extras.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
            }
            return extras;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static boolean B(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return false;
        }
        try {
            Bundle q = q(intent);
            if (q != null) {
                return q.containsKey("error");
            }
            return intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return false;
        }
    }

    public static boolean C(int i2) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return false;
        }
        try {
            return f3085f.contains(Integer.valueOf(i2)) && i2 >= 20140701;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return false;
        }
    }

    public static void D(Intent intent, String str, String str2, int i2, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return;
        }
        try {
            String g2 = com.facebook.f.g();
            String h2 = com.facebook.f.h();
            intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i2).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", str2).putExtra("com.facebook.platform.extra.APPLICATION_ID", g2);
            if (C(i2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("action_id", str);
                x.g0(bundle2, "app_name", h2);
                intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
                return;
            }
            intent.putExtra("com.facebook.platform.protocol.CALL_ID", str);
            if (!x.S(h2)) {
                intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", h2);
            }
            intent.putExtras(bundle);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
        }
    }

    public static void E() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return;
        }
        try {
            if (f3084e.compareAndSet(false, true)) {
                com.facebook.f.p().execute(new a());
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
        }
    }

    static Intent F(Context context, Intent intent, f fVar) {
        if (com.facebook.internal.instrument.e.a.c(t.class) || intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                return null;
            }
            if (i.b(context, resolveActivity.activityInfo.packageName)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    static Intent G(Context context, Intent intent, f fVar) {
        if (com.facebook.internal.instrument.e.a.c(t.class) || intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService == null) {
                return null;
            }
            if (i.b(context, resolveService.serviceInfo.packageName)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    static /* synthetic */ TreeSet a(f fVar) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            return p(fVar);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    static /* synthetic */ AtomicBoolean b() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            return f3084e;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    static /* synthetic */ List c() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            return b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static Map<String, List<f>> d() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new e(null));
            List<f> list = b;
            hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
            hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
            hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", c);
            hashMap.put("com.facebook.platform.action.request.SHARE_STORY", list);
            return hashMap;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static List<f> e() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(f());
            arrayList.add(0, new b(null));
            return arrayList;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static List<f> f() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d(null));
            arrayList.add(new h(null));
            return arrayList;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static Uri g(f fVar) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            return Uri.parse("content://" + fVar.e() + ".provider.PlatformProvider/versions");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static int h(TreeSet<Integer> treeSet, int i2, int[] iArr) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return 0;
        }
        try {
            int length = iArr.length - 1;
            Iterator<Integer> descendingIterator = treeSet.descendingIterator();
            int i3 = -1;
            while (descendingIterator.hasNext()) {
                int intValue = descendingIterator.next().intValue();
                i3 = Math.max(i3, intValue);
                while (length >= 0 && iArr[length] > intValue) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == intValue) {
                    if (length % 2 == 0) {
                        return Math.min(i3, i2);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return 0;
        }
    }

    public static Bundle i(FacebookException facebookException) {
        if (com.facebook.internal.instrument.e.a.c(t.class) || facebookException == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("error_description", facebookException.toString());
            if (facebookException instanceof FacebookOperationCanceledException) {
                bundle.putString("error_type", "UserCanceled");
            }
            return bundle;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static Intent j(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            c cVar = new c(null);
            return F(context, k(cVar, str, collection, str2, z, z2, defaultAudience, str3, str4, false), cVar);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static Intent k(f fVar, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4, boolean z3) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            String d2 = fVar.d();
            if (d2 == null) {
                return null;
            }
            Intent putExtra = new Intent().setClassName(fVar.e(), d2).putExtra("client_id", str);
            putExtra.putExtra("facebook_sdk_version", com.facebook.f.w());
            if (!x.T(collection)) {
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!x.S(str2)) {
                putExtra.putExtra("e2e", str2);
            }
            putExtra.putExtra("state", str3);
            putExtra.putExtra(ParamKeyConstants.WebViewConstants.QUERY_RESPONSE_TYPE, "token,signed_request,graph_domain");
            putExtra.putExtra("return_scopes", "true");
            if (z2) {
                putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra("legacy_override", com.facebook.f.r());
            putExtra.putExtra("auth_type", str4);
            if (z3) {
                putExtra.putExtra("fail_on_logged_out", true);
            }
            return putExtra;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static Intent l(Context context, String str, String str2, g gVar, Bundle bundle) {
        Intent F;
        if (com.facebook.internal.instrument.e.a.c(t.class) || gVar == null) {
            return null;
        }
        try {
            f fVar = gVar.a;
            if (fVar == null || (F = F(context, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(fVar.e()).addCategory("android.intent.category.DEFAULT"), fVar)) == null) {
                return null;
            }
            D(F, str, str2, gVar.b, bundle);
            return F;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static Intent m(Context context) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            for (f fVar : b) {
                Intent G = G(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(fVar.e()).addCategory("android.intent.category.DEFAULT"), fVar);
                if (G != null) {
                    return G;
                }
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static Intent n(Intent intent, Bundle bundle, FacebookException facebookException) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            UUID r = r(intent);
            if (r == null) {
                return null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", z(intent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", r.toString());
            if (facebookException != null) {
                bundle2.putBundle("error", i(facebookException));
            }
            intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
            if (bundle != null) {
                intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
            }
            return intent2;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static List<Intent> o(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4, boolean z3) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (f fVar : b) {
                Intent k2 = k(fVar, str, collection, str2, z, z2, defaultAudience, str3, str4, z3);
                if (k2 != null) {
                    arrayList.add(k2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static TreeSet<Integer> p(f fVar) {
        Cursor cursor;
        ProviderInfo providerInfo;
        Cursor cursor2;
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            TreeSet<Integer> treeSet = new TreeSet<>();
            ContentResolver contentResolver = com.facebook.f.f().getContentResolver();
            String[] strArr = {"version"};
            Uri g2 = g(fVar);
            try {
                try {
                    providerInfo = com.facebook.f.f().getPackageManager().resolveContentProvider(fVar.e() + ".provider.PlatformProvider", 0);
                } catch (RuntimeException e2) {
                    Log.e(a, "Failed to query content resolver.", e2);
                    providerInfo = null;
                }
                if (providerInfo != null) {
                    try {
                        cursor2 = contentResolver.query(g2, strArr, null, null, null);
                    } catch (IllegalArgumentException | NullPointerException | SecurityException unused) {
                        Log.e(a, "Failed to query content resolver.");
                        cursor2 = null;
                    }
                    if (cursor2 != null) {
                        while (cursor2.moveToNext()) {
                            try {
                                treeSet.add(Integer.valueOf(cursor2.getInt(cursor2.getColumnIndex("version"))));
                            } catch (Throwable th) {
                                cursor = cursor2;
                                th = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    }
                } else {
                    cursor2 = null;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return treeSet;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Throwable th3) {
            com.facebook.internal.instrument.e.a.b(th3, t.class);
            return null;
        }
    }

    public static Bundle q(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            if (C(z(intent))) {
                return intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static UUID r(Intent intent) {
        String stringExtra;
        if (com.facebook.internal.instrument.e.a.c(t.class) || intent == null) {
            return null;
        }
        try {
            if (C(z(intent))) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (stringExtra != null) {
                try {
                    return UUID.fromString(stringExtra);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static Bundle s(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            if (B(intent)) {
                Bundle q = q(intent);
                if (q != null) {
                    return q.getBundle("error");
                }
                return intent.getExtras();
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static FacebookException t(Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(t.class) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
            }
            String string2 = bundle.getString("error_description");
            if (string2 == null) {
                string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
            }
            if (string != null && string.equalsIgnoreCase("UserCanceled")) {
                return new FacebookOperationCanceledException(string2);
            }
            return new FacebookException(string2);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static g u(String str, int[] iArr) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            return v(f3083d.get(str), iArr);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    private static g v(List<f> list, int[] iArr) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            E();
            if (list == null) {
                return g.d();
            }
            for (f fVar : list) {
                int h2 = h(fVar.c(), x(), iArr);
                if (h2 != -1) {
                    return g.c(fVar, h2);
                }
            }
            return g.d();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static int w(int i2) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return 0;
        }
        try {
            return v(b, new int[]{i2}).e();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return 0;
        }
    }

    public static final int x() {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return 0;
        }
        try {
            return f3085f.get(0).intValue();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return 0;
        }
    }

    public static Bundle y(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return null;
        }
        try {
            if (!C(z(intent))) {
                return intent.getExtras();
            }
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return null;
        }
    }

    public static int z(Intent intent) {
        if (com.facebook.internal.instrument.e.a.c(t.class)) {
            return 0;
        }
        try {
            return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, t.class);
            return 0;
        }
    }
}
