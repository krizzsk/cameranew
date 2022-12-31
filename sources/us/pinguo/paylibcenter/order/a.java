package us.pinguo.paylibcenter.order;

import android.content.Context;
import com.android.volley.AuthFailureError;
import java.util.Map;
import us.pinguo.common.network.HttpGsonRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.n.c;
/* compiled from: CreateC360MemberOrderTask.java */
/* loaded from: classes5.dex */
public class a extends b {

    /* compiled from: CreateC360MemberOrderTask.java */
    /* renamed from: us.pinguo.paylibcenter.order.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0423a extends HttpGsonRequest<CreateOrderResp> {
        final /* synthetic */ us.pinguo.paylibcenter.n.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0423a(int i2, String str, us.pinguo.paylibcenter.n.b bVar) {
            super(i2, str);
            this.a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        /* renamed from: a */
        public void onResponse(CreateOrderResp createOrderResp) {
            a.this.d(this.a, createOrderResp);
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = null;
            try {
                map = C360MemberPayHelp.getInstance().w();
                CreateOrderReq createOrderReq = a.this.f11598d;
                if (createOrderReq != null) {
                    map.put(GuestProfileFragment.USER_ID, createOrderReq.getUserId());
                    map.put("productId", a.this.f11598d.getProductId());
                    map.put("purchaseTag", a.this.f11598d.getPurchaseTag());
                    map.put("way", a.this.f11598d.getWay());
                    us.pinguo.common.log.a.q("userid:" + a.this.f11598d.getUserId(), new Object[0]);
                    us.pinguo.common.log.a.q("productId:" + a.this.f11598d.getProductId(), new Object[0]);
                    us.pinguo.common.log.a.q("way:" + a.this.f11598d.getWay(), new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            map.put("sig", us.pinguo.paylibcenter.n.d.b(map));
            return map;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            a.this.c(this.a, exc);
        }
    }

    public a(Context context, CreateOrderReq createOrderReq) {
        super(context, createOrderReq);
    }

    @Override // us.pinguo.paylibcenter.order.b, us.pinguo.paylibcenter.n.a
    public void b(us.pinguo.paylibcenter.n.b<CreateOrderResp> bVar) {
        a(new C0423a(1, c.a.f11595d, bVar));
    }
}
