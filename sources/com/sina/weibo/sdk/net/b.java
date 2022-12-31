package com.sina.weibo.sdk.net;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public final class b implements a {
    @Override // com.sina.weibo.sdk.net.a
    public final f a(d dVar) {
        InputStream errorStream;
        String url = dVar.getUrl();
        Bundle params = dVar.getParams();
        if (params != null && params.size() != 0 && !TextUtils.isEmpty(url)) {
            Uri parse = Uri.parse(url);
            if (params != null && !params.isEmpty()) {
                Uri.Builder buildUpon = parse.buildUpon();
                for (String str : params.keySet()) {
                    buildUpon.appendQueryParameter(str, String.valueOf(params.get(str)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                url = parse.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                Bundle bundle = new Bundle();
                bundle.putString(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_FORM);
                a(httpURLConnection, bundle);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(dVar.getReadTimeout());
                httpURLConnection.setConnectTimeout(dVar.getConnectTimeout());
                httpURLConnection.connect();
                a(httpURLConnection.getOutputStream(), dVar);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                return new g(responseCode, errorStream);
            } catch (Exception e2) {
                throw new Throwable(e2.getMessage());
            }
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }

    private static void a(OutputStream outputStream, d dVar) {
        Bundle h2 = dVar.h();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : h2.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String valueOf = String.valueOf(h2.get(str));
            try {
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(valueOf, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes("UTF-8"));
            dataOutputStream.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
