package com.pinguo.camera360.homepage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.pinguo.camera360.vip.VipManager;
import rx.Subscription;
import rx.functions.Action1;
import us.pinguo.foundation.base.SubscriptionActivity;
import us.pinguo.inspire.model.InspireMsgCountResp;
import us.pinguo.inspire.module.profile.InspireFollowFeedLoader;
import us.pinguo.inspire.module.profile.InspireMsgLoader;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* compiled from: HomeInitPresenter.kt */
/* loaded from: classes3.dex */
public final class l0 {
    private q0 a;
    private boolean b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private long f6801d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(l0 this$0, Integer it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f6801d = System.currentTimeMillis();
        int b = us.pinguo.foundation.g.b();
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("totalUnRead follow count:", it), new Object[0]);
        kotlin.jvm.internal.s.g(it, "it");
        us.pinguo.foundation.g.f(it.intValue());
        if (it.intValue() > b) {
            us.pinguo.foundation.g.c(true);
        }
        q0 q0Var = this$0.a;
        if (q0Var != null) {
            q0Var.v();
        } else {
            kotlin.jvm.internal.s.z("initView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(Throwable th) {
        th.printStackTrace();
        us.pinguo.common.log.a.e("update un read follow fail!!", new Object[0]);
    }

    private final void b() {
        if (this.c == 0) {
            w();
        } else if (((int) ((System.currentTimeMillis() - this.c) / 60000)) > 10) {
            w();
        }
    }

    private final void c() {
        if (this.f6801d == 0) {
            z();
        } else if (((int) ((System.currentTimeMillis() - this.f6801d) / 60000)) > 10) {
            z();
        }
    }

    private final void e() {
        v();
        us.pinguo.librouter.c.d.b().getInterface().j();
    }

    private final int f() {
        return InspireMsgLoader.getInstance().getTabMsgCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(l0 this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.q();
        return false;
    }

    private final void q() {
        us.pinguo.common.log.a.k("onFirstFrameVisible", new Object[0]);
        if (this.b) {
            return;
        }
        us.pinguo.librouter.module.inspire.b portalInterface = us.pinguo.librouter.c.d.b().getPortalInterface();
        q0 q0Var = this.a;
        if (q0Var != null) {
            portalInterface.e(q0Var.getActivity());
            if (User.p()) {
                if (Math.abs(System.currentTimeMillis() - User.f()) > 604800000) {
                    q0 q0Var2 = this.a;
                    if (q0Var2 != null) {
                        new us.pinguo.foundation.ui.e(q0Var2.getActivity(), (int) R.string.user_expired, 0).d();
                        User.A(System.currentTimeMillis());
                    } else {
                        kotlin.jvm.internal.s.z("initView");
                        throw null;
                    }
                }
            } else if (!User.u()) {
                us.pinguo.common.log.a.k("未登录或时间未到， 不刷新token", new Object[0]);
            }
            e();
            return;
        }
        kotlin.jvm.internal.s.z("initView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(l0 this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b();
        if (User.d().n()) {
            this$0.c();
            return false;
        }
        return false;
    }

    private final void u(int i2) {
        InspireMsgLoader.getInstance().saveTabMsgCount(i2);
    }

    private final void v() {
        us.pinguo.common.log.a.k("startLocationService start", new Object[0]);
        us.pinguo.librouter.b.c.f location = us.pinguo.librouter.b.b.b().getInterface().getLocation();
        if (location != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(location.c());
            sb.append(',');
            sb.append(location.d());
            String sb2 = sb.toString();
            us.pinguo.foundation.j e2 = us.pinguo.foundation.j.e();
            kotlin.jvm.internal.s.e(e2);
            e2.s("key_cached_geo_location", sb2);
            AbstractGrowingIO.getInstance().setAppVariable("gps", sb2);
        }
        us.pinguo.common.log.a.k("startLocationService end", new Object[0]);
    }

    private final void w() {
        Subscription subscribe = InspireMsgLoader.getInstance().getMsgCountFromServer().subscribe(new Action1() { // from class: com.pinguo.camera360.homepage.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                l0.x(l0.this, (InspireMsgCountResp) obj);
            }
        }, d.a);
        q0 q0Var = this.a;
        if (q0Var != null) {
            ((SubscriptionActivity) q0Var.getActivity()).addSubscription(subscribe);
        } else {
            kotlin.jvm.internal.s.z("initView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(l0 this$0, InspireMsgCountResp inspireMsgCountResp) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if ((inspireMsgCountResp == null ? null : inspireMsgCountResp.msgCount) != null) {
            this$0.c = System.currentTimeMillis();
            int f2 = this$0.f();
            int count = inspireMsgCountResp.msgCount.getCount();
            this$0.u(count);
            if (count > f2) {
                us.pinguo.foundation.g.d(true);
                us.pinguo.foundation.g.e(true);
            }
            q0 q0Var = this$0.a;
            if (q0Var != null) {
                q0Var.v();
            } else {
                kotlin.jvm.internal.s.z("initView");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Throwable th) {
        us.pinguo.foundation.e.e(th);
    }

    private final void z() {
        InspireFollowFeedLoader.getInstance().getUnReadCount().subscribe(new Action1() { // from class: com.pinguo.camera360.homepage.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                l0.A(l0.this, (Integer) obj);
            }
        }, b.a);
    }

    public void a(us.pinguo.foundation.p.b bVar) {
        kotlin.jvm.internal.s.e(bVar);
        this.a = (q0) bVar;
        new Handler();
    }

    public void d() {
    }

    public final boolean m() {
        us.pinguo.librouter.module.inspire.b portalInterface = us.pinguo.librouter.c.d.b().getPortalInterface();
        q0 q0Var = this.a;
        if (q0Var != null) {
            return portalInterface.d(q0Var.getActivity());
        }
        kotlin.jvm.internal.s.z("initView");
        throw null;
    }

    public final void n() {
        this.b = false;
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.pinguo.camera360.homepage.c
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean o;
                o = l0.o(l0.this);
                return o;
            }
        });
        us.pinguo.librouter.module.camera.d b = us.pinguo.librouter.c.d.b();
        us.pinguo.librouter.module.inspire.b portalInterface = b.getPortalInterface();
        q0 q0Var = this.a;
        if (q0Var != null) {
            portalInterface.b(q0Var.getActivity());
            us.pinguo.librouter.module.camera.c cVar = b.getInterface();
            q0 q0Var2 = this.a;
            if (q0Var2 != null) {
                Context applicationContext = q0Var2.getActivity().getApplicationContext();
                cVar.q(applicationContext);
                cVar.b(applicationContext);
                return;
            }
            kotlin.jvm.internal.s.z("initView");
            throw null;
        }
        kotlin.jvm.internal.s.z("initView");
        throw null;
    }

    public final void p() {
        this.b = true;
        us.pinguo.librouter.c.d.b().getInterface().r().onDestroy();
    }

    public final void r() {
        us.pinguo.librouter.module.inspire.b portalInterface = us.pinguo.librouter.c.d.b().getPortalInterface();
        q0 q0Var = this.a;
        if (q0Var != null) {
            portalInterface.c(q0Var.getActivity());
        } else {
            kotlin.jvm.internal.s.z("initView");
            throw null;
        }
    }

    public final void s() {
        if (VipManager.a.g(true)) {
            com.pinguo.camera360.adv.c.h();
        }
        us.pinguo.librouter.module.inspire.b portalInterface = us.pinguo.librouter.c.d.b().getPortalInterface();
        q0 q0Var = this.a;
        if (q0Var != null) {
            portalInterface.a(q0Var.getActivity());
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.pinguo.camera360.homepage.f
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean t;
                    t = l0.t(l0.this);
                    return t;
                }
            });
            return;
        }
        kotlin.jvm.internal.s.z("initView");
        throw null;
    }
}
