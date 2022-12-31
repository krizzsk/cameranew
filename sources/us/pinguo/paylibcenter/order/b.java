package us.pinguo.paylibcenter.order;

import android.content.Context;
import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import java.util.Map;
import us.pinguo.common.network.HttpGsonRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.n.c;
/* compiled from: CreateOrderTask.java */
/* loaded from: classes5.dex */
public class b extends us.pinguo.paylibcenter.n.a<CreateOrderResp> {

    /* renamed from: d  reason: collision with root package name */
    protected CreateOrderReq f11598d;

    /* compiled from: CreateOrderTask.java */
    /* loaded from: classes5.dex */
    class a extends HttpGsonRequest<CreateOrderResp> {
        final /* synthetic */ us.pinguo.paylibcenter.n.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, String str, us.pinguo.paylibcenter.n.b bVar) {
            super(i2, str);
            this.a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        /* renamed from: a */
        public void onResponse(CreateOrderResp createOrderResp) {
            b.this.d(this.a, createOrderResp);
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = null;
            try {
                map = PayHelp.getInstance().w();
                CreateOrderReq createOrderReq = b.this.f11598d;
                if (createOrderReq != null) {
                    map.put(GuestProfileFragment.USER_ID, createOrderReq.getUserId());
                    map.put("productId", b.this.f11598d.getProductId());
                    map.put("way", b.this.f11598d.getWay());
                    map.put("purchaseTag", b.this.f11598d.getPurchaseTag());
                    us.pinguo.common.log.a.q("userid:" + b.this.f11598d.getUserId(), new Object[0]);
                    us.pinguo.common.log.a.q("productId:" + b.this.f11598d.getProductId(), new Object[0]);
                    us.pinguo.common.log.a.q("way:" + b.this.f11598d.getWay(), new Object[0]);
                    us.pinguo.common.log.a.q("purchaseTag:" + b.this.f11598d.getPurchaseTag(), new Object[0]);
                }
                String extra = b.this.f11598d.getExtra();
                if (map != null && !TextUtils.isEmpty(extra)) {
                    map.put(JsonMarshaller.EXTRA, extra);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            map.put("sig", us.pinguo.paylibcenter.n.d.b(map));
            return map;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            b.this.c(this.a, exc);
        }
    }

    public b(Context context, CreateOrderReq createOrderReq) {
        super(context);
        this.f11598d = createOrderReq;
    }

    @Override // us.pinguo.paylibcenter.n.a
    public void b(us.pinguo.paylibcenter.n.b<CreateOrderResp> bVar) {
        a(new a(1, c.a.c, bVar));
    }
}
