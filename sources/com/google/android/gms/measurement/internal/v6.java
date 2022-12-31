package com.google.android.gms.measurement.internal;

import android.os.Build;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class v6 extends j5 {
    private final SSLSocketFactory c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v6(o4 o4Var) {
        super(o4Var);
        this.c = Build.VERSION.SDK_INT < 19 ? new p9(HttpsURLConnection.getDefaultSSLSocketFactory()) : null;
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final HttpURLConnection m(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            SSLSocketFactory sSLSocketFactory = this.c;
            if (sSLSocketFactory != null && (openConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(sSLSocketFactory);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            this.a.x();
            httpURLConnection.setConnectTimeout(60000);
            this.a.x();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }
}
