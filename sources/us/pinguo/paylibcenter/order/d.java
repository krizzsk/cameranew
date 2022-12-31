package us.pinguo.paylibcenter.order;

import android.content.Context;
import com.android.volley.AuthFailureError;
import java.util.Map;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.n.c;
/* compiled from: RestoryOrderTask.java */
/* loaded from: classes5.dex */
public class d extends us.pinguo.paylibcenter.n.a<String> {

    /* renamed from: d  reason: collision with root package name */
    private RestoreOrderReq f11601d;

    /* compiled from: RestoryOrderTask.java */
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
                if (d.this.f11601d != null) {
                    map.put(GuestProfileFragment.USER_ID, d.this.f11601d.getUserId());
                } else {
                    map.put(GuestProfileFragment.USER_ID, "");
                }
                us.pinguo.common.log.a.q("userid:" + d.this.f11601d.getUserId(), new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            map.put("sig", us.pinguo.paylibcenter.n.d.b(map));
            return map;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
            d.this.c(this.a, exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            d.this.d(this.a, str);
        }
    }

    public d(Context context, RestoreOrderReq restoreOrderReq) {
        super(context);
        this.f11601d = restoreOrderReq;
    }

    @Override // us.pinguo.paylibcenter.n.a
    public void b(us.pinguo.paylibcenter.n.b<String> bVar) {
        a(new a(1, c.a.f11597f, bVar));
    }
}
