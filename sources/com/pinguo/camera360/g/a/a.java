package com.pinguo.camera360.g.a;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.utils.f;
import us.pinguo.foundation.utils.p;
/* compiled from: PostUtil.java */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: PostUtil.java */
    /* renamed from: com.pinguo.camera360.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0239a implements Comparator<String> {
        C0239a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public static String a(Map<String, String> map, String str) {
        ArrayList<String> arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + '=' + entry.getValue());
        }
        Collections.sort(arrayList, new C0239a());
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            sb.append(str2);
        }
        try {
            return f.b(sb.toString(), str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String b(String str, Map<String, String> map, Map<String, File> map2) throws IOException {
        String uuid = UUID.randomUUID().toString();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(p.b());
        }
        httpURLConnection.setReadTimeout(50000);
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charsert", "UTF-8");
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "multipart/form-data;boundary=" + uuid);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("--");
            sb.append(uuid);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Content-Type: text/plain; charset=");
            sb2.append("UTF-8");
            sb2.append("\r\n");
            sb.append(sb2.toString());
            sb.append("Content-Transfer-Encoding: 8bit\r\n");
            sb.append("\r\n");
            sb.append(entry.getValue());
            sb.append("\r\n");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        BufferedReader bufferedReader = null;
        try {
            dataOutputStream.write(sb.toString().getBytes());
            if (map2 != null) {
                for (Map.Entry<String, File> entry2 : map2.entrySet()) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("--");
                    sb3.append(uuid);
                    sb3.append("\r\n");
                    sb3.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + entry2.getKey() + "\"\r\n");
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Content-Type: image/jpeg; charset=");
                    sb4.append("UTF-8");
                    sb4.append("\r\n");
                    sb3.append(sb4.toString());
                    sb3.append("\r\n");
                    dataOutputStream.write(sb3.toString().getBytes());
                    FileInputStream fileInputStream = new FileInputStream(entry2.getValue());
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            dataOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileInputStream.close();
                    dataOutputStream.write("\r\n".getBytes());
                }
            }
            dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
            dataOutputStream.flush();
            if (httpURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                try {
                    StringBuilder sb5 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb5.append(readLine);
                    }
                    String sb6 = sb5.toString();
                    bufferedReader2.close();
                    dataOutputStream.close();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return sb6;
                } catch (Throwable th) {
                    bufferedReader = bufferedReader2;
                    th = th;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    dataOutputStream.close();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            dataOutputStream.close();
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
