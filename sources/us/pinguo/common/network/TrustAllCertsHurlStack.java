package us.pinguo.common.network;

import com.android.volley.toolbox.HurlStack;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public class TrustAllCertsHurlStack extends HurlStack {
    public TrustAllCertsHurlStack() {
        super(null, getSocketFactory());
    }

    static SSLSocketFactory getSocketFactory() {
        try {
            return HttpRequest.getTrustedFactory();
        } catch (Exception unused) {
            return null;
        }
    }
}
