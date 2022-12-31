package us.pinguo.paylibcenter.order;

import android.content.Context;
import com.android.volley.AuthFailureError;
import java.util.Map;
import us.pinguo.common.network.HttpGsonRequest;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.n.c;
/* compiled from: SyncOrderTask.java */
/* loaded from: classes5.dex */
public class e extends us.pinguo.paylibcenter.n.a<SyncOrderResp> {

    /* renamed from: d  reason: collision with root package name */
    private SyncOrderReq f11602d;

    /* compiled from: SyncOrderTask.java */
    /* loaded from: classes5.dex */
    class a extends HttpGsonRequest<SyncOrderResp> {
        final /* synthetic */ us.pinguo.paylibcenter.n.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, String str, us.pinguo.paylibcenter.n.b bVar) {
            super(i2, str);
            this.a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        /* renamed from: a */
        public void onResponse(SyncOrderResp syncOrderResp) {
            e.this.d(this.a, syncOrderResp);
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = null;
            try {
                map = PayHelp.getInstance().w();
                map.put("status", e.this.f11602d.getStatus());
                map.put("out_trade_no", e.this.f11602d.getOut_trade_no());
                map.put("receipt", e.this.f11602d.getReceipt());
                us.pinguo.common.log.a.q("status" + e.this.f11602d.getStatus(), new Object[0]);
                us.pinguo.common.log.a.q("out_trade_no" + e.this.f11602d.getOut_trade_no(), new Object[0]);
                us.pinguo.common.log.a.q("receipt" + e.this.f11602d.getReceipt(), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            map.put("sig", us.pinguo.paylibcenter.n.d.b(map));
            return map;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            e.this.c(this.a, exc);
        }
    }

    public e(Context context, SyncOrderReq syncOrderReq) {
        super(context);
        this.f11602d = syncOrderReq;
    }

    @Override // us.pinguo.paylibcenter.n.a
    public void b(us.pinguo.paylibcenter.n.b<SyncOrderResp> bVar) {
        a(new a(1, c.a.f11596e, bVar));
    }
}
