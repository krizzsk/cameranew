package us.pinguo.user.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.utils.j0;
import us.pinguo.foundation.utils.w;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.s0;
import us.pinguo.user.u0;
import us.pinguo.user.util.g;
import us.pinguo.user.util.n;
import us.pinguo.util.q;
import us.pinguo.util.u;
import us.pinguo.util.v;
/* compiled from: VerificationUtil.kt */
/* loaded from: classes6.dex */
public final class n implements g {
    private static a b;

    /* renamed from: e  reason: collision with root package name */
    private static long f12467e;

    /* renamed from: f  reason: collision with root package name */
    private static BaseInfoResult f12468f;
    public static final n a = new n();
    private static final ArrayList<g> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f12466d = new Object();

    /* compiled from: VerificationUtil.kt */
    /* loaded from: classes6.dex */
    public static final class a extends HttpStringRequest {
        private final g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g listener) {
            super(1, u0.n);
            s.h(listener, "listener");
            this.a = listener;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap hashMap = new HashMap();
            u0.e(BaseApplication.d(), hashMap);
            hashMap.put("appName", "Camera360");
            hashMap.put(BigAlbumStore.PhotoAddressColumns.COUNTRY, "1");
            hashMap.put(BigAlbumStore.PhotoAddressColumns.CITY, "1");
            us.pinguo.foundation.m.d.c(hashMap, "49BC34172930E461AFA65C3C7ACFCEC2");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            this.a.onFetchBaseInfo(null, 1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            try {
                BaseInfoResponse baseInfoResponse = (BaseInfoResponse) new com.google.gson.e().j(str, BaseInfoResponse.class);
                Integer status = baseInfoResponse.getStatus();
                if (status != null && status.intValue() == 200 && baseInfoResponse.getData() != null) {
                    n nVar = n.a;
                    n.f12468f = baseInfoResponse.getData();
                    n.f12467e = System.currentTimeMillis();
                    g.a.a(this.a, n.f12468f, 0, 2, null);
                }
                this.a.onFetchBaseInfo(null, 2);
            } catch (Exception unused) {
                this.a.onFetchBaseInfo(null, 2);
            }
        }
    }

    /* compiled from: VerificationUtil.kt */
    /* loaded from: classes6.dex */
    public static final class b implements g {
        final /* synthetic */ Activity a;
        final /* synthetic */ Runnable b;

        b(Activity activity, Runnable runnable) {
            this.a = activity;
            this.b = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Activity activity, DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            s.h(activity, "$activity");
            if (i2 == -2) {
                if (dialogInterface == null) {
                    return;
                }
                dialogInterface.dismiss();
            } else if (i2 != -1) {
            } else {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                Intent intent = new Intent();
                intent.setClassName(us.pinguo.foundation.e.b(), "us.pinguo.inspire.PhoneBindActivity");
                activity.startActivityForResult(intent, 1006);
            }
        }

        @Override // us.pinguo.user.util.g
        public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
            if (i2 != 0) {
                j0.c(R.string.no_connect);
            } else if (baseInfoResult != null) {
                if (baseInfoResult.isShareOn()) {
                    if (s0.getInstance().e()) {
                        if (n.m(User.d().h(), baseInfoResult.isChina())) {
                            Resources resources = this.a.getResources();
                            Activity activity = this.a;
                            CharSequence text = resources.getText(R.string.bind_phone_title);
                            CharSequence text2 = resources.getText(R.string.bind_phone_detail);
                            CharSequence text3 = resources.getText(R.string.ok_bind);
                            CharSequence text4 = resources.getText(R.string.cancel);
                            final Activity activity2 = this.a;
                            w.h(activity, text, text2, text3, text4, new DialogInterface.OnClickListener() { // from class: us.pinguo.user.util.d
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i3) {
                                    n.b.b(activity2, dialogInterface, i3);
                                }
                            });
                            return;
                        }
                        Runnable runnable = this.b;
                        if (runnable == null) {
                            return;
                        }
                        runnable.run();
                        return;
                    } else if (baseInfoResult.isChina()) {
                        s0.getInstance().a(this.a, 206, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                        return;
                    } else {
                        Runnable runnable2 = this.b;
                        if (runnable2 == null) {
                            return;
                        }
                        runnable2.run();
                        return;
                    }
                }
                j0.c(R.string.share_disabled);
            } else {
                j0.c(R.string.no_connect);
            }
        }
    }

    /* compiled from: VerificationUtil.kt */
    /* loaded from: classes6.dex */
    public static final class c extends HttpStringRequest {
        final /* synthetic */ Runnable a;
        final /* synthetic */ Runnable b;
        final /* synthetic */ Runnable c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List<String> f12469d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Runnable runnable, Runnable runnable2, Runnable runnable3, List<String> list) {
            super(1, str);
            this.a = runnable;
            this.b = runnable2;
            this.c = runnable3;
            this.f12469d = list;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() {
            Iterator<String> it;
            String K0;
            HashMap hashMap = new HashMap();
            u0.e(BaseApplication.d(), hashMap);
            hashMap.put("appName", "Camera360");
            String str = "";
            while (this.f12469d.iterator().hasNext()) {
                str = str + it.next() + ',';
            }
            K0 = StringsKt__StringsKt.K0(str, ',');
            hashMap.put("imgUrl", K0);
            us.pinguo.foundation.m.d.c(hashMap, "49BC34172930E461AFA65C3C7ACFCEC2");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            j0.c(R.string.no_connect);
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            if (exc == null) {
                return;
            }
            exc.printStackTrace();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            if (str == null) {
                Runnable runnable = this.a;
                if (runnable == null) {
                    return;
                }
                runnable.run();
                return;
            }
            VerifyResponse verifyResponse = (VerifyResponse) new com.google.gson.e().j(str, VerifyResponse.class);
            Integer status = verifyResponse.getStatus();
            if (status != null && status.intValue() == 200) {
                VerifyResult data = verifyResponse.getData();
                if (s.c("pass", data == null ? null : data.getSuggestion())) {
                    Runnable runnable2 = this.b;
                    if (runnable2 == null) {
                        return;
                    }
                    runnable2.run();
                    return;
                }
                Runnable runnable3 = this.c;
                if (runnable3 == null) {
                    return;
                }
                runnable3.run();
                return;
            }
            j0.c(R.string.no_connect);
            Runnable runnable4 = this.a;
            if (runnable4 == null) {
                return;
            }
            runnable4.run();
        }
    }

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Activity activity, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        s.h(activity, "$activity");
        if (i2 == -2) {
            if (dialogInterface == null) {
                return;
            }
            dialogInterface.dismiss();
        } else if (i2 != -1) {
        } else {
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            Intent intent = new Intent();
            intent.setClassName(us.pinguo.foundation.e.b(), "us.pinguo.inspire.PhoneBindActivity");
            activity.startActivityForResult(intent, 1006);
        }
    }

    public static final boolean i() {
        if (us.pinguo.foundation.utils.i.c()) {
            return false;
        }
        return s.c("zh", Locale.getDefault().getLanguage());
    }

    public static final boolean j() {
        if (us.pinguo.foundation.utils.i.c()) {
            return false;
        }
        Locale locale = Locale.getDefault();
        return s.c("zh", locale.getLanguage()) && s.c("CN", locale.getCountry());
    }

    public static final boolean k() {
        boolean m;
        String id = TimeZone.getDefault().getID();
        if (id == null) {
            return s.c("ko", Locale.getDefault().getLanguage());
        }
        m = kotlin.collections.n.m(u.a.c(), id);
        return m;
    }

    public static final boolean m(User.Info info, boolean z) {
        CharSequence H0;
        if (z) {
            if (!(info == null || TextUtils.isEmpty(info.userId) || TextUtils.isEmpty(info.token))) {
                s.e(info);
                String str = info.mobile;
                if (str != null) {
                    H0 = StringsKt__StringsKt.H0(str);
                    if (H0.toString().length() <= 5) {
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final void d(final Activity activity, Runnable runnable) {
        s.h(activity, "activity");
        BaseInfoResult g2 = g();
        if (g2 != null) {
            if (g2.isShareOn()) {
                if (s0.getInstance().e()) {
                    if (m(User.d().h(), g2.isChina())) {
                        Resources resources = activity.getResources();
                        w.h(activity, resources.getText(R.string.bind_phone_title), resources.getText(R.string.bind_phone_detail), resources.getText(R.string.ok_bind), resources.getText(R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.user.util.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                n.e(activity, dialogInterface, i2);
                            }
                        });
                        return;
                    } else if (runnable == null) {
                        return;
                    } else {
                        runnable.run();
                        return;
                    }
                } else if (g2.isChina()) {
                    s0.getInstance().a(activity, 206, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                    return;
                } else if (runnable == null) {
                    return;
                } else {
                    runnable.run();
                    return;
                }
            }
            j0.c(R.string.share_disabled);
            return;
        }
        h(new b(activity, runnable));
    }

    public final void f() {
        synchronized (f12466d) {
            c.clear();
            kotlin.u uVar = kotlin.u.a;
        }
    }

    public final BaseInfoResult g() {
        BaseInfoResult baseInfoResult = f12468f;
        if (baseInfoResult == null || Math.abs(f12467e - System.currentTimeMillis()) < 7200000) {
            return baseInfoResult;
        }
        f12468f = null;
        return null;
    }

    public final boolean h(g gVar) {
        if (!q.e(v.a())) {
            if (gVar != null) {
                gVar.onFetchBaseInfo(null, 1);
            }
            return false;
        }
        BaseInfoResult g2 = g();
        if (g2 != null) {
            if (gVar != null) {
                g.a.a(gVar, g2, 0, 2, null);
            }
            return false;
        }
        synchronized (f12466d) {
            BaseInfoResult g3 = a.g();
            if (g3 != null) {
                if (gVar != null) {
                    g.a.a(gVar, g3, 0, 2, null);
                }
                return false;
            }
            if (gVar != null) {
                ArrayList<g> arrayList = c;
                if (!arrayList.contains(gVar)) {
                    arrayList.add(gVar);
                }
            }
            if (b != null) {
                return true;
            }
            a aVar = new a(this);
            aVar.setRetryPolicy(u0.a());
            aVar.execute();
            b = aVar;
            kotlin.u uVar = kotlin.u.a;
            return true;
        }
    }

    public final void n(g listener) {
        s.h(listener, "listener");
        synchronized (f12466d) {
            c.remove(listener);
        }
    }

    public final void o(String requestUrl, List<String> imageUrls, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        s.h(requestUrl, "requestUrl");
        s.h(imageUrls, "imageUrls");
        if (imageUrls.isEmpty()) {
            if (runnable3 == null) {
                return;
            }
            runnable3.run();
            return;
        }
        c cVar = new c(requestUrl, runnable3, runnable, runnable2, imageUrls);
        cVar.setRetryPolicy(u0.a());
        cVar.execute();
    }

    @Override // us.pinguo.user.util.g
    public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
        synchronized (f12466d) {
            for (g gVar : c) {
                gVar.onFetchBaseInfo(baseInfoResult, i2);
            }
            c.clear();
            b = null;
            kotlin.u uVar = kotlin.u.a;
        }
    }
}
