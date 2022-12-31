package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d {
    private static StatLogger c = com.tencent.stat.common.k.b();

    /* renamed from: d  reason: collision with root package name */
    private static d f8306d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Context f8307e = null;
    DefaultHttpClient a;
    Handler b;

    private d() {
        this.a = null;
        this.b = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            handlerThread.getId();
            this.b = new Handler(handlerThread.getLooper());
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            this.a = defaultHttpClient;
            defaultHttpClient.setKeepAliveStrategy(new e(this));
            if (StatConfig.b() != null) {
                this.a.getParams().setParameter("http.route.default-proxy", StatConfig.b());
            }
        } catch (Throwable th) {
            c.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context a() {
        return f8307e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        f8307e = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            if (f8306d == null) {
                f8306d = new d();
            }
            dVar = f8306d;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.tencent.stat.a.e eVar, c cVar) {
        f(Arrays.asList(eVar.d()), cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(List<String> list, c cVar) {
        boolean z;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= list.size()) {
                    break;
                }
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append(",");
                }
                i2++;
            }
            sb.append("]");
            String statReportUrl = StatConfig.getStatReportUrl();
            StatLogger statLogger = c;
            statLogger.i("[" + statReportUrl + "]Send request(" + sb.toString().length() + "bytes):" + sb.toString());
            HttpPost httpPost = new HttpPost(statReportUrl);
            httpPost.addHeader(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            httpPost.setHeader("Connection", "Keep-Alive");
            httpPost.removeHeaders(HttpRequest.HEADER_CACHE_CONTROL);
            HttpHost a = com.tencent.stat.common.k.a(f8307e);
            if (a != null) {
                this.a.getParams().setParameter("http.route.default-proxy", com.tencent.stat.common.k.a(f8307e));
                httpPost.addHeader("X-Online-Host", StatConstants.MTA_SERVER);
                httpPost.addHeader(HttpRequest.HEADER_ACCEPT, "*/*");
                httpPost.addHeader(HttpRequest.HEADER_CONTENT_TYPE, "json");
            } else {
                z = false;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = sb.toString().getBytes("UTF-8");
            int length = bytes.length;
            if (sb.length() >= 256) {
                if (a == null) {
                    httpPost.addHeader(HttpRequest.HEADER_CONTENT_ENCODING, "rc4,gzip");
                } else {
                    httpPost.addHeader("X-Content-Encoding", "rc4,gzip");
                }
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                StatLogger statLogger2 = c;
                statLogger2.d("before Gzip:" + length + " bytes, after Gzip:" + bytes.length + " bytes");
            } else if (a == null) {
                httpPost.addHeader(HttpRequest.HEADER_CONTENT_ENCODING, "rc4");
            } else {
                httpPost.addHeader("X-Content-Encoding", "rc4");
            }
            httpPost.setEntity(new ByteArrayEntity(com.tencent.stat.common.e.a(bytes)));
            HttpResponse execute = this.a.execute(httpPost);
            if (z) {
                this.a.getParams().removeParameter("http.route.default-proxy");
            }
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            StatLogger statLogger3 = c;
            statLogger3.i("recv response status code:" + statusCode + ", content length:" + contentLength);
            int i3 = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
            if (i3 == 0) {
                EntityUtils.toString(entity);
                if (statusCode != 200) {
                    StatLogger statLogger4 = c;
                    statLogger4.error("Server response error code:" + statusCode);
                } else if (cVar != null) {
                    cVar.a();
                }
            } else if (i3 > 0) {
                InputStream content = entity.getContent();
                DataInputStream dataInputStream = new DataInputStream(content);
                byte[] bArr = new byte[(int) entity.getContentLength()];
                dataInputStream.readFully(bArr);
                content.close();
                dataInputStream.close();
                Header firstHeader = execute.getFirstHeader(HttpRequest.HEADER_CONTENT_ENCODING);
                if (firstHeader != null) {
                    if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                        bArr = com.tencent.stat.common.e.b(com.tencent.stat.common.k.a(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                        bArr = com.tencent.stat.common.k.a(com.tencent.stat.common.e.b(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase(HttpRequest.ENCODING_GZIP)) {
                        bArr = com.tencent.stat.common.k.a(bArr);
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                        bArr = com.tencent.stat.common.e.b(bArr);
                    }
                }
                if (statusCode == 200) {
                    String str = new String(bArr, "UTF-8");
                    c.d(str);
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.isNull("cfg")) {
                        StatConfig.a(jSONObject.getJSONObject("cfg"));
                    }
                    if (!jSONObject.isNull("et") && !jSONObject.isNull("st")) {
                        StatLogger statLogger5 = c;
                        statLogger5.d("get mid respone:" + str);
                        if (jSONObject.getInt("et") == com.tencent.stat.a.f.SESSION_ENV.a()) {
                            int i4 = jSONObject.getInt("st");
                            if (i4 != -1 && i4 != 0) {
                                StatLogger statLogger6 = c;
                                statLogger6.e("error type for st:" + i4);
                            } else if (!jSONObject.isNull(DeviceInfo.TAG_MID)) {
                                StatMid.updateDeviceInfo(f8307e, jSONObject.getString(DeviceInfo.TAG_MID));
                            }
                        }
                    }
                    if (cVar != null) {
                        cVar.a();
                    }
                } else {
                    StatLogger statLogger7 = c;
                    statLogger7.error("Server response error code:" + statusCode + ", error:" + new String(bArr, "UTF-8"));
                }
                content.close();
            } else {
                EntityUtils.toString(entity);
            }
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            c.e(th);
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(List<String> list, c cVar) {
        Handler handler;
        if (list.isEmpty() || (handler = this.b) == null) {
            return;
        }
        handler.post(new f(this, list, cVar));
    }
}
