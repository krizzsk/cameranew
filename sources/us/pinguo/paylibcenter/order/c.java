package us.pinguo.paylibcenter.order;

import android.content.Context;
import com.android.volley.AuthFailureError;
import java.util.Map;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.n.c;
/* compiled from: PurchaseTask.java */
/* loaded from: classes5.dex */
public class c extends us.pinguo.paylibcenter.n.a<String> {

    /* renamed from: d  reason: collision with root package name */
    private PurchaseReq f11599d;

    /* renamed from: e  reason: collision with root package name */
    private String f11600e;

    /* compiled from: PurchaseTask.java */
    /* loaded from: classes5.dex */
    class a extends HttpStringRequest {
        final /* synthetic */ us.pinguo.paylibcenter.n.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, String str, us.pinguo.paylibcenter.n.b bVar) {
            super(i2, str);
            this.a = bVar;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = null;
            try {
                map = PayHelp.getInstance().w();
                String str = "";
                map.put("productId", c.this.f11599d.getProductId() == null ? "" : c.this.f11599d.getProductId());
                map.put(GuestProfileFragment.USER_ID, c.this.f11599d.getUserId() == null ? "" : c.this.f11599d.getUserId());
                map.put("receipt", c.this.f11599d.getReceipt() == null ? "" : c.this.f11599d.getReceipt());
                map.put("way", c.this.f11599d.getWay() == null ? "" : c.this.f11599d.getWay());
                map.put("signture", c.this.f11599d.getSignture() == null ? "" : c.this.f11599d.getSignture());
                map.put("purchaseTag", c.this.f11599d.getPurchaseTag() == null ? "" : c.this.f11599d.getPurchaseTag());
                map.put("purchaseToken", c.this.f11599d.getPurchaseToken() == null ? "" : c.this.f11599d.getPurchaseToken());
                map.put("subscribeId", c.this.f11599d.getSubscribeId() == null ? "" : c.this.f11599d.getSubscribeId());
                if (c.this.f11599d.getHmsProductId() != null) {
                    str = c.this.f11599d.getHmsProductId();
                }
                map.put("hmsProductId", str);
                us.pinguo.common.log.a.q("product:" + c.this.f11599d.getProductId(), new Object[0]);
                us.pinguo.common.log.a.q("userId:" + c.this.f11599d.getUserId(), new Object[0]);
                us.pinguo.common.log.a.q("receipt:" + c.this.f11599d.getReceipt(), new Object[0]);
                us.pinguo.common.log.a.q("way:" + c.this.f11599d.getWay(), new Object[0]);
                us.pinguo.common.log.a.q("signture:" + c.this.f11599d.getSignture(), new Object[0]);
                us.pinguo.common.log.a.q("purchaseTag:" + c.this.f11599d.getPurchaseTag(), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            map.put("sig", us.pinguo.paylibcenter.n.d.b(map));
            return map;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            c.this.c(this.a, exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            c.this.d(this.a, str);
        }
    }

    public c(Context context, PurchaseReq purchaseReq, boolean z) {
        super(context);
        String str = c.a.a;
        this.f11600e = str;
        this.f11599d = purchaseReq;
        if (z) {
            this.f11600e = c.a.b;
        } else {
            this.f11600e = str;
        }
    }

    @Override // us.pinguo.paylibcenter.n.a
    public void b(us.pinguo.paylibcenter.n.b<String> bVar) {
        a(new a(1, this.f11600e, bVar));
    }
}
