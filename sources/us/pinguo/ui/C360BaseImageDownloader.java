package us.pinguo.ui;

import android.content.Context;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes6.dex */
public class C360BaseImageDownloader extends BaseImageDownloader {
    public C360BaseImageDownloader(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.core.download.BaseImageDownloader
    public HttpURLConnection b(String str, Object obj) throws IOException {
        HttpURLConnection b = super.b(str, obj);
        if (b instanceof HttpsURLConnection) {
            ((HttpsURLConnection) b).setSSLSocketFactory(HttpRequest.getTrustedFactory());
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.nostra13.universalimageloader.core.download.BaseImageDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream g(java.lang.String r7, java.lang.Object r8) throws java.io.IOException {
        /*
            r6 = this;
            android.net.Uri r0 = android.net.Uri.parse(r7)
            java.lang.String r1 = "len"
            java.lang.String r0 = r0.getQueryParameter(r1)
            r1 = 0
            if (r0 == 0) goto L12
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L12
            goto L13
        L12:
            r0 = 0
        L13:
            r2 = 0
            if (r0 != 0) goto L20
            java.io.InputStream r7 = super.g(r7, r8)     // Catch: java.io.FileNotFoundException -> L1b
            return r7
        L1b:
            r7 = move-exception
            r7.printStackTrace()
            return r2
        L20:
            java.io.InputStream r7 = super.g(r7, r8)     // Catch: java.io.FileNotFoundException -> L65
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch: java.io.FileNotFoundException -> L65
            r8.<init>(r0)     // Catch: java.io.FileNotFoundException -> L65
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r3]     // Catch: java.io.FileNotFoundException -> L65
        L2d:
            int r4 = r7.read(r3)     // Catch: java.io.FileNotFoundException -> L65
            r5 = -1
            if (r4 == r5) goto L38
            r8.write(r3, r1, r4)     // Catch: java.io.FileNotFoundException -> L65
            goto L2d
        L38:
            byte[] r7 = r8.toByteArray()     // Catch: java.io.FileNotFoundException -> L65
            int r8 = r7.length     // Catch: java.io.FileNotFoundException -> L65
            if (r8 != r0) goto L45
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch: java.io.FileNotFoundException -> L65
            r8.<init>(r7)     // Catch: java.io.FileNotFoundException -> L65
            return r8
        L45:
            java.io.IOException r8 = new java.io.IOException     // Catch: java.io.FileNotFoundException -> L65
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L65
            r1.<init>()     // Catch: java.io.FileNotFoundException -> L65
            java.lang.String r3 = "image len error, param len:"
            r1.append(r3)     // Catch: java.io.FileNotFoundException -> L65
            r1.append(r0)     // Catch: java.io.FileNotFoundException -> L65
            java.lang.String r0 = ",image len:"
            r1.append(r0)     // Catch: java.io.FileNotFoundException -> L65
            int r7 = r7.length     // Catch: java.io.FileNotFoundException -> L65
            r1.append(r7)     // Catch: java.io.FileNotFoundException -> L65
            java.lang.String r7 = r1.toString()     // Catch: java.io.FileNotFoundException -> L65
            r8.<init>(r7)     // Catch: java.io.FileNotFoundException -> L65
            throw r8     // Catch: java.io.FileNotFoundException -> L65
        L65:
            r7 = move-exception
            r7.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.C360BaseImageDownloader.g(java.lang.String, java.lang.Object):java.io.InputStream");
    }
}
