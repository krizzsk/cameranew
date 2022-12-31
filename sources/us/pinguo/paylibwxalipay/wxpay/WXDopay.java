package us.pinguo.paylibwxalipay.wxpay;

import com.tencent.mm.opensdk.modelbase.BaseResp;
/* loaded from: classes5.dex */
public class WXDopay {

    /* loaded from: classes5.dex */
    private static class a {
        private static WXDopay a = new WXDopay();
    }

    public static synchronized WXDopay getInstance() {
        WXDopay wXDopay;
        synchronized (WXDopay.class) {
            wXDopay = a.a;
        }
        return wXDopay;
    }

    public void a(BaseResp baseResp) {
    }
}
