package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class q3 extends z8 {

    /* renamed from: d  reason: collision with root package name */
    private final SSLSocketFactory f3917d;

    public q3(i9 i9Var) {
        super(i9Var);
        this.f3917d = Build.VERSION.SDK_INT < 19 ? new p9(HttpsURLConnection.getDefaultSSLSocketFactory()) : null;
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        return false;
    }

    public final boolean k() {
        h();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.zzaw().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @WorkerThread
    public final HttpURLConnection l(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            SSLSocketFactory sSLSocketFactory = this.f3917d;
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
