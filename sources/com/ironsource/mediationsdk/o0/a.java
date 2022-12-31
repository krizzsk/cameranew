package com.ironsource.mediationsdk.o0;

import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSourceObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: HttpFunctions.java */
/* loaded from: classes2.dex */
public class a {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();

    public static String a(String str, IronSourceObject.b bVar) throws Exception {
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 400) {
                    if (bVar != null) {
                        bVar.a("Bad Request - 400");
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    if (TextUtils.isEmpty(sb2)) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        bufferedReader2.close();
                        return null;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    bufferedReader2.close();
                    return sb2;
                } catch (Exception unused) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return null;
                } catch (Throwable th) {
                    httpURLConnection2 = httpURLConnection;
                    bufferedReader = bufferedReader2;
                    th = th;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedReader2 = null;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                bufferedReader = null;
            }
        } catch (Exception unused3) {
            httpURLConnection = null;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }
}
