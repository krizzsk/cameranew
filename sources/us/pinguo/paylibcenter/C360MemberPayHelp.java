package us.pinguo.paylibcenter;

import android.content.Context;
import us.pinguo.paylibcenter.order.CreateOrderReq;
/* loaded from: classes5.dex */
public class C360MemberPayHelp extends PayHelp {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static C360MemberPayHelp a = new C360MemberPayHelp();
    }

    public static synchronized C360MemberPayHelp getInstance() {
        C360MemberPayHelp c360MemberPayHelp;
        synchronized (C360MemberPayHelp.class) {
            c360MemberPayHelp = a.a;
        }
        return c360MemberPayHelp;
    }

    @Override // us.pinguo.paylibcenter.PayHelp
    protected us.pinguo.paylibcenter.order.b L(Context context, CreateOrderReq createOrderReq) {
        return new us.pinguo.paylibcenter.order.a(context, createOrderReq);
    }
}
