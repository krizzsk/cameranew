package us.pinguo.foundation.m;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import us.pinguo.common.network.DirectOutputHurlStack;
/* compiled from: HurlStreamStack.java */
/* loaded from: classes4.dex */
public class c extends DirectOutputHurlStack {
    private int a;

    public c(int i2) {
        this.a = 0;
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.toolbox.HurlStack
    public HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection createConnection = super.createConnection(url);
        createConnection.setFixedLengthStreamingMode(this.a);
        return createConnection;
    }
}
