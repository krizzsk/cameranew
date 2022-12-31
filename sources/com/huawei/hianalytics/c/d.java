package com.huawei.hianalytics.c;

import android.text.TextUtils;
import com.huawei.hianalytics.util.m;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.net.HttpURLConnection] */
    public static e a(String str, String str2) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        if (TextUtils.isEmpty(str)) {
            return new e(-100, "");
        }
        if (str2 == null) {
            str2 = "";
        }
        int i2 = -102;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    str = a(str, str2.length(), "POST", null);
                    try {
                        outputStream = str.getOutputStream();
                        try {
                            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        outputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        outputStream = null;
                    }
                } catch (a unused3) {
                    com.huawei.hianalytics.b.b.c("HttpClient", "sendPostRequest(String): SSLConfigException");
                    return new e(-101, "");
                }
            } catch (IOException unused4) {
                str = 0;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                outputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            i2 = str.getResponseCode();
            e eVar = new e(i2, b(str));
            com.huawei.hianalytics.b.b.a("HiAnalytics", "PostRequest(String) resultCode: %d", Integer.valueOf(i2));
            try {
                bufferedWriter.close();
            } catch (IOException unused5) {
                com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(String)'s BufferedWriter close: IOException");
            }
            if (str != 0) {
                str.disconnect();
                com.huawei.hianalytics.b.b.a("HttpClient", "disconnect");
            }
            return eVar;
        } catch (IOException unused6) {
            bufferedWriter2 = bufferedWriter;
            com.huawei.hianalytics.b.b.c("HttpClient", "PostRequest(String): IOException");
            e eVar2 = new e(i2, "");
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException unused7) {
                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(String)'s BufferedWriter close: IOException");
                }
            } else if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused8) {
                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(String)'s OutputStream close: IOException");
                }
            }
            if (str != 0) {
                str.disconnect();
                com.huawei.hianalytics.b.b.a("HttpClient", "disconnect");
            }
            return eVar2;
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException unused9) {
                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(String)'s BufferedWriter close: IOException");
                }
            } else if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused10) {
                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(String)'s OutputStream close: IOException");
                }
            }
            if (str != 0) {
                str.disconnect();
                com.huawei.hianalytics.b.b.a("HttpClient", "disconnect");
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.Map] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.io.OutputStream] */
    public static e a(String str, byte[] bArr, Map<String, String> map) {
        BufferedOutputStream bufferedOutputStream;
        if (TextUtils.isEmpty(str)) {
            return new e(-100, "");
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int i2 = -102;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    str = a(str, bArr.length, "POST", map);
                    try {
                        map = str.getOutputStream();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(map);
                        } catch (IOException unused) {
                        }
                        try {
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            i2 = str.getResponseCode();
                            e eVar = new e(i2, b(str));
                            com.huawei.hianalytics.b.b.a("HiAnalytics", "PostRequest(byte[]) resultCode: %d", Integer.valueOf(i2));
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused2) {
                                com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(byte[])'s BufferedOutputStream close: IOException");
                            }
                            if (str != 0) {
                                str.disconnect();
                                com.huawei.hianalytics.b.b.a("HttpClient", "disconnect");
                            }
                            return eVar;
                        } catch (IOException unused3) {
                            bufferedOutputStream2 = bufferedOutputStream;
                            com.huawei.hianalytics.b.b.c("HttpClient", "PostRequest(byte[]): IOException");
                            e eVar2 = new e(i2, "");
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused4) {
                                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(byte[])'s BufferedOutputStream close: IOException");
                                }
                            } else if (map != 0) {
                                try {
                                    map.close();
                                } catch (IOException unused5) {
                                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(byte[])'s OutputStream close: IOException");
                                }
                            }
                            if (str != 0) {
                                str.disconnect();
                                com.huawei.hianalytics.b.b.a("HttpClient", "disconnect");
                            }
                            return eVar2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused6) {
                                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(byte[])'s BufferedOutputStream close: IOException");
                                }
                            } else if (map != 0) {
                                try {
                                    map.close();
                                } catch (IOException unused7) {
                                    com.huawei.hianalytics.b.b.c("HttpClient", "When the PostRequest(byte[])'s OutputStream close: IOException");
                                }
                            }
                            if (str != 0) {
                                str.disconnect();
                                com.huawei.hianalytics.b.b.a("HttpClient", "disconnect");
                            }
                            throw th;
                        }
                    } catch (IOException unused8) {
                        map = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        map = 0;
                    }
                } catch (a unused9) {
                    com.huawei.hianalytics.b.b.c("HttpClient", "PostRequest(byte[]): SSLConfigException");
                    return new e(-101, "");
                }
            } catch (IOException unused10) {
                str = 0;
                map = 0;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                map = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static HttpURLConnection a(String str, int i2, String str2, Map<String, String> map) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(12000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_LENGTH, String.valueOf(i2));
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SocketFactory a2 = c.a();
            if (a2 == null || !(a2 instanceof SSLSocketFactory)) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory((SSLSocketFactory) a2);
        }
    }

    private static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                return m.a(inputStream, 2048);
            } catch (IOException e2) {
                com.huawei.hianalytics.b.b.b("HttpClient", "When Response Content From Connection happend IOException,the ResponseCode is %d ", Integer.valueOf(httpURLConnection.getResponseCode()));
                throw e2;
            }
        } finally {
            m.a(inputStream);
        }
    }
}
