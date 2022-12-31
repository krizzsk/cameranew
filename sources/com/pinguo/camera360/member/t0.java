package com.pinguo.camera360.member;

import android.content.Context;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.camera360.member.model.RechargeGoodsInfo;
import java.util.Iterator;
/* compiled from: HuaweiDiscountManager.kt */
/* loaded from: classes3.dex */
public final class t0 {
    public static final t0 a = new t0();
    private static RechargeGoodsDiscountInfo b;

    /* compiled from: HuaweiDiscountManager.kt */
    /* loaded from: classes3.dex */
    public static final class a extends us.pinguo.paylibcenter.n.b<RechargeGoodsInfo> {
        a() {
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
        }

        @Override // us.pinguo.paylibcenter.n.b
        /* renamed from: c */
        public void b(RechargeGoodsInfo rechargeGoodsInfo) {
            Object obj;
            if (rechargeGoodsInfo == null) {
                return;
            }
            Iterator<T> it = rechargeGoodsInfo.getData().getList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (kotlin.jvm.internal.s.c(((RechargeGoodsDiscountInfo) obj).getProductId(), "yearly_vip_discount")) {
                    break;
                }
            }
            RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo = (RechargeGoodsDiscountInfo) obj;
            if (rechargeGoodsDiscountInfo == null) {
                return;
            }
            t0 t0Var = t0.a;
            t0.b = rechargeGoodsDiscountInfo;
        }
    }

    private t0() {
    }

    public final RechargeGoodsDiscountInfo b() {
        return b;
    }

    public final void c() {
        a aVar = new a();
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        C360MemberRepository c360MemberRepository = new C360MemberRepository(b2);
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        c360MemberRepository.n(b3, aVar);
    }

    public final boolean d() {
        return us.pinguo.foundation.utils.i.d() && b != null;
    }
}
