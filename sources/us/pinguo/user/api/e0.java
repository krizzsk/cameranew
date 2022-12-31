package us.pinguo.user.api;

import android.app.Application;
import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.open.SocialConstants;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.user.Conditions;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.model.MemberInfo;
import us.pinguo.user.u0;
import us.pinguo.user.y0;
/* compiled from: ApiVipInfoLoader.kt */
/* loaded from: classes6.dex */
public final class e0 {
    public static final e0 a = new e0();
    private static final String b;

    /* compiled from: ApiVipInfoLoader.kt */
    /* loaded from: classes6.dex */
    public static final class a extends j.a.c.b.d<MemberInfo> {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(MemberInfo memberInfo) {
            boolean z = true;
            if (memberInfo != null && memberInfo.getStatus() == 200) {
                us.pinguo.common.log.a.k("ApiVipInfoLoader.syncVipExpireTimeFromServer.onSuccess", new Object[0]);
                us.pinguo.foundation.j.e().r("key_sync_vip_time", System.currentTimeMillis() / 1000);
                us.pinguo.common.log.a.k("goodInfo = " + memberInfo.getData().getExpires() + " isVip = " + memberInfo.getData().isVip(), new Object[0]);
                y0.o(this.a, memberInfo.getData().isVip(), Long.parseLong(memberInfo.getData().getExpires()));
                User.d().r(true);
                try {
                    Class.forName("com.pinguo.camera360.vip.VipManager").getField("INSTANCE").getDeclaringClass().getMethod("updateVipStatus", Integer.TYPE).invoke(null, 5);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (memberInfo.getData().isVip() != 1 && memberInfo.getData().isVip() != 3 && memberInfo.getData().isVip() != 4) {
                    z = false;
                }
                us.pinguo.librouter.c.d.b().getInterface().i(z);
                PGEventBus.getInstance().a(new SyncVipInfoDoneEvent());
            } else if (us.pinguo.foundation.d.f10985d) {
                us.pinguo.common.log.a.e(kotlin.jvm.internal.s.q("syncVipExpireTimeFromServer exception  = ", memberInfo != null ? memberInfo.toString() : null), new Object[0]);
                throw new Exception("syncVipExpireTimeFromServer exception");
            } else {
                us.pinguo.common.log.a.e(kotlin.jvm.internal.s.q("syncVipExpireTimeFromServer error  status = ", memberInfo != null ? Integer.valueOf(memberInfo.getStatus()) : null), new Object[0]);
            }
        }

        @Override // j.a.c.b.d
        public void onError(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            us.pinguo.common.log.a.e("syncVipExpireTimeFromServer onError", new Object[0]);
            e2.printStackTrace();
        }
    }

    static {
        boolean z = us.pinguo.foundation.d.f10985d;
        b = (z && us.pinguo.foundation.d.b) ? "https://bmall-qa.camera360.com" : z ? "https://bmall-dev.camera360.com" : "https://bmall.camera360.com";
    }

    private e0() {
    }

    private final void a(final j.a.c.b.d<MemberInfo> dVar) {
        us.pinguo.common.log.a.k("ApiVipInfoLoader.asyncVipInfo", new Object[0]);
        us.pinguo.foundation.statistics.h.b.n("", "/api/vip/checkVipInfo", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        PGRequest.Builder builder = new PGRequest.Builder(MemberInfo.class);
        builder.withMethod(1).withUriPath("/api/vip/checkVipInfo").withDomain(b);
        u0.d(builder);
        RxVolley.create(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.user.api.u
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                e0.b(currentTimeMillis, dVar, (MemberInfo) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.api.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                e0.c(currentTimeMillis, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(long j2, j.a.c.b.d result, MemberInfo memberInfo) {
        kotlin.jvm.internal.s.h(result, "$result");
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/vip/checkVipInfo", FirebaseAnalytics.Param.SUCCESS);
        if (memberInfo.getStatus() == 200) {
            result.onSuccess(memberInfo);
        } else {
            result.onError(new Exception(kotlin.jvm.internal.s.q("asyncVipInfo error = ", memberInfo)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j2, Throwable th) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/vip/checkVipInfo", "failed");
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    public final void f(Context ctx) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        us.pinguo.common.log.a.k("ApiVipInfoLoader.syncVipExpireTimeFromServer", new Object[0]);
        if (us.pinguo.util.q.f(ctx) && !Conditions.a()) {
            if (ctx instanceof Application) {
                a(new a(ctx));
                return;
            }
            throw new Exception("pls use application context");
        }
    }
}
