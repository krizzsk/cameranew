package com.tapjoy;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.internal.fj;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public class TapjoyURLConnection {
    public static final int TYPE_GET = 0;
    public static final int TYPE_POST = 1;

    public String getContentLength(String str) {
        String str2;
        try {
            String replaceAll = str.replaceAll(" ", "%20");
            TapjoyLog.d("TapjoyURLConnection", "requestURL: " + replaceAll);
            HttpURLConnection httpURLConnection = (HttpURLConnection) fj.a(new URL(replaceAll));
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            str2 = httpURLConnection.getHeaderField("content-length");
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyURLConnection", "Exception: " + e2.toString());
            str2 = null;
        }
        TapjoyLog.d("TapjoyURLConnection", "content-length: " + str2);
        return str2;
    }

    public TapjoyHttpURLResponse getRedirectFromURL(String str) {
        return getResponseFromURL(str, "", 0, true, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, int i2) {
        return getResponseFromURL(str, TapjoyUtil.convertURLParams(map, false), i2);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str) {
        return getResponseFromURL(str, "", 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2) {
        return getResponseFromURL(str, str2, 0);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i2) {
        return getResponseFromURL(str, str2, i2, false, null, null, null);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, Map map3) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, HttpRequest.CONTENT_TYPE_FORM, TapjoyUtil.convertURLParams(map3, false));
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, Map map, Map map2, String str2) {
        return getResponseFromURL(str, map != null ? TapjoyUtil.convertURLParams(map, false) : "", 1, false, map2, "application/json;charset=utf-8", str2);
    }

    public TapjoyHttpURLResponse getResponseFromURL(String str, String str2, int i2, boolean z, Map map, String str3, String str4) {
        String str5;
        TapjoyHttpURLResponse tapjoyHttpURLResponse = new TapjoyHttpURLResponse();
        HttpURLConnection httpURLConnection = null;
        try {
            String str6 = str + str2;
            StringBuilder sb = new StringBuilder("http ");
            sb.append(i2 == 0 ? "get" : "post");
            sb.append(": ");
            sb.append(str6);
            TapjoyLog.i("TapjoyURLConnection", sb.toString());
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) fj.a(new URL(str6));
            if (z) {
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                } catch (Exception e2) {
                    httpURLConnection = httpURLConnection2;
                    e = e2;
                    TapjoyLog.e("TapjoyURLConnection", "Exception: " + e.toString());
                    tapjoyHttpURLResponse.statusCode = 0;
                    if (httpURLConnection != null) {
                        try {
                            if (tapjoyHttpURLResponse.response == null) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                                StringBuilder sb2 = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb2.append(readLine + '\n');
                                }
                                tapjoyHttpURLResponse.response = sb2.toString();
                            }
                        } catch (Exception e3) {
                            TapjoyLog.e("TapjoyURLConnection", "Exception trying to get error code/content: " + e3.toString());
                        }
                    }
                    TapjoyLog.i("TapjoyURLConnection", "--------------------");
                    TapjoyLog.i("TapjoyURLConnection", "response status: " + tapjoyHttpURLResponse.statusCode);
                    TapjoyLog.i("TapjoyURLConnection", "response size: " + tapjoyHttpURLResponse.contentLength);
                    str5 = tapjoyHttpURLResponse.redirectURL;
                    if (str5 != null) {
                        TapjoyLog.i("TapjoyURLConnection", "redirectURL: " + tapjoyHttpURLResponse.redirectURL);
                    }
                    TapjoyLog.i("TapjoyURLConnection", "--------------------");
                    return tapjoyHttpURLResponse;
                }
            }
            httpURLConnection2.setConnectTimeout(15000);
            httpURLConnection2.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (i2 == 1) {
                httpURLConnection2.setRequestMethod("POST");
                if (str4 != null) {
                    TapjoyLog.i("TapjoyURLConnection", "Content-Type: " + str3);
                    TapjoyLog.i("TapjoyURLConnection", "Content:");
                    TapjoyLog.i("TapjoyURLConnection", str4);
                    httpURLConnection2.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, str3);
                    httpURLConnection2.setRequestProperty("Connection", TJAdUnitConstants.String.CLOSE);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setFixedLengthStreamingMode(str4.length());
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection2.getOutputStream());
                    outputStreamWriter.write(str4);
                    outputStreamWriter.close();
                }
            }
            httpURLConnection2.connect();
            tapjoyHttpURLResponse.statusCode = httpURLConnection2.getResponseCode();
            tapjoyHttpURLResponse.headerFields = httpURLConnection2.getHeaderFields();
            tapjoyHttpURLResponse.date = httpURLConnection2.getDate();
            tapjoyHttpURLResponse.expires = httpURLConnection2.getExpiration();
            BufferedReader bufferedReader2 = z ? null : new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
            if (!z) {
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb3.append(readLine2 + '\n');
                }
                tapjoyHttpURLResponse.response = sb3.toString();
            }
            if (tapjoyHttpURLResponse.statusCode == 302) {
                tapjoyHttpURLResponse.redirectURL = httpURLConnection2.getHeaderField(HttpRequest.HEADER_LOCATION);
            }
            String headerField = httpURLConnection2.getHeaderField("content-length");
            if (headerField != null) {
                try {
                    tapjoyHttpURLResponse.contentLength = Integer.valueOf(headerField).intValue();
                } catch (Exception e4) {
                    TapjoyLog.e("TapjoyURLConnection", "Exception: " + e4.toString());
                }
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (Exception e5) {
            e = e5;
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        TapjoyLog.i("TapjoyURLConnection", "response status: " + tapjoyHttpURLResponse.statusCode);
        TapjoyLog.i("TapjoyURLConnection", "response size: " + tapjoyHttpURLResponse.contentLength);
        str5 = tapjoyHttpURLResponse.redirectURL;
        if (str5 != null && str5.length() > 0) {
            TapjoyLog.i("TapjoyURLConnection", "redirectURL: " + tapjoyHttpURLResponse.redirectURL);
        }
        TapjoyLog.i("TapjoyURLConnection", "--------------------");
        return tapjoyHttpURLResponse;
    }
}
