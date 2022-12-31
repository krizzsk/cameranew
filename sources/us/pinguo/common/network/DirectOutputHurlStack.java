package us.pinguo.common.network;

import com.android.volley.Request;
import java.io.IOException;
import java.net.HttpURLConnection;
/* loaded from: classes4.dex */
public class DirectOutputHurlStack extends TrustAllCertsHurlStack {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";

    @Override // com.android.volley.toolbox.HurlStack
    protected void handleNullBodyRequest(HttpURLConnection httpURLConnection, Request<?> request) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        }
        if (request instanceof WriteBodyRequest) {
            try {
                ((WriteBodyRequest) request).writeToBody(httpURLConnection.getOutputStream());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
