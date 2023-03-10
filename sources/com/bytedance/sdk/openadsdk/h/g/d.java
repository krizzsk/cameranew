package com.bytedance.sdk.openadsdk.h.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.e.f;
import com.bytedance.sdk.openadsdk.h.i;
import com.growingio.android.sdk.collection.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class d {
    private static final Handler b = new Handler(Looper.getMainLooper());
    public static final Charset a = Charset.forName("UTF-8");
    private static final ExecutorService c = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int b(String str) {
        return a(str, 0);
    }

    public static boolean c(String str) {
        return str != null && (str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str));
    }

    public static void a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(int i2, int i3) {
        if (i2 >= 0 && i3 > 0) {
            return i2 + PGTransHeader.CONNECTOR + i3;
        } else if (i2 > 0) {
            return i2 + PGTransHeader.CONNECTOR;
        } else if (i2 >= 0 || i3 <= 0) {
            return null;
        } else {
            return PGTransHeader.CONNECTOR + i3;
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean a(String str) {
        return str != null && (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) || str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX));
    }

    public static void b(Runnable runnable) {
        if (runnable != null) {
            if (b()) {
                runnable.run();
            } else {
                b.post(runnable);
            }
        }
    }

    public static int a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static String a(com.bytedance.sdk.openadsdk.h.e.a aVar, int i2) {
        int a2;
        if (aVar == null || !aVar.b()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.e().toUpperCase());
        sb.append(' ');
        sb.append(aVar.a());
        sb.append(' ');
        sb.append(aVar.f());
        sb.append("\r\n");
        if (e.c) {
            Log.i("TAG_PROXY_headers", aVar.e().toUpperCase() + " " + aVar.a() + " " + aVar.f());
        }
        List<i.b> a3 = a(aVar.c());
        boolean z = true;
        if (a3 != null) {
            int size = a3.size();
            for (int i3 = 0; i3 < size; i3++) {
                i.b bVar = a3.get(i3);
                if (bVar != null) {
                    String str = bVar.a;
                    String str2 = bVar.b;
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    sb.append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        }
        if (z && (a2 = a(aVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i2, 0));
            sb.append(PGTransHeader.CONNECTOR);
            sb.append(a2 - 1);
            sb.append("/");
            sb.append(a2);
            sb.append("\r\n");
        }
        sb.append("Connection: close");
        sb.append("\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        if (e.c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static String b(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            i.b bVar = list.get(0);
            if (bVar != null) {
                sb.append(bVar.a);
                sb.append(": ");
                sb.append(bVar.b);
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append(": ");
            sb.append((Object) entry.getValue());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public static String a(int i2, int i3) {
        String b2 = b(i2, i3);
        if (b2 == null) {
            return null;
        }
        return "bytes=" + b2;
    }

    public static List<String> a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (a(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String a(com.bytedance.sdk.openadsdk.h.b.a aVar, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 <= 0) {
            sb.append("HTTP/1.1 200 OK");
            sb.append("\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content");
            sb.append("\r\n");
        }
        sb.append("Accept-Ranges: bytes");
        sb.append("\r\n");
        sb.append("Content-Type: ");
        sb.append(aVar.b);
        sb.append("\r\n");
        if (i2 <= 0) {
            sb.append("Content-Length: ");
            sb.append(aVar.c);
            sb.append("\r\n");
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i2);
            sb.append(PGTransHeader.CONNECTOR);
            sb.append(aVar.c - 1);
            sb.append("/");
            sb.append(aVar.c);
            sb.append("\r\n");
            sb.append("Content-Length: ");
            sb.append(aVar.c - i2);
            sb.append("\r\n");
        }
        sb.append("Connection: close");
        sb.append("\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        if (e.c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static int a() {
        File[] listFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.h.g.d.1
                private Pattern a = Pattern.compile("^cpu[0-9]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return this.a.matcher(str).matches();
                }
            })) == null) {
                return 1;
            }
            return Math.max(listFiles.length, 1);
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.h.e.a aVar) {
        int lastIndexOf;
        if (aVar == null) {
            return -1;
        }
        if (aVar.a() == 200) {
            return a(aVar.a(HttpRequest.HEADER_CONTENT_LENGTH, null), -1);
        }
        if (aVar.a() == 206) {
            String a2 = aVar.a("Content-Range", null);
            if (!TextUtils.isEmpty(a2) && (lastIndexOf = a2.lastIndexOf("/")) >= 0 && lastIndexOf < a2.length() - 1) {
                return a(a2.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String a(com.bytedance.sdk.openadsdk.h.e.a aVar, boolean z, boolean z2) {
        String a2;
        if (aVar == null) {
            if (e.c) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        } else if (!aVar.b()) {
            if (e.c) {
                Log.e("TAG_PROXY_Response", "response code: " + aVar.a());
            }
            return "response code: " + aVar.a();
        } else {
            String a3 = aVar.a(HttpRequest.HEADER_CONTENT_TYPE, null);
            if (!c(a3)) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "Content-Type: " + a3);
                }
                return "Content-Type: " + a3;
            }
            int a4 = a(aVar);
            if (a4 <= 0) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "Content-Length: " + a4);
                }
                return "Content-Length: " + a4;
            } else if (z && ((a2 = aVar.a("Accept-Ranges", null)) == null || !a2.contains("bytes"))) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "Accept-Ranges: " + a2);
                }
                return "Accept-Ranges: " + a2;
            } else if (z2 && aVar.d() == null) {
                if (e.c) {
                    Log.e("TAG_PROXY_Response", "response body null");
                }
                return "response body null";
            } else {
                return null;
            }
        }
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (b()) {
                c.execute(runnable);
                if (e.c) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            runnable.run();
            if (e.c) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static List<i.b> a(List<i.b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (e.c) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                i.b bVar = list.get(i2);
                if (bVar != null) {
                    Log.i("TAG_PROXY_PRE_FILTER", bVar.a + ": " + bVar.a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (i.b bVar2 : list) {
            if ("Host".equals(bVar2.a) || "Keep-Alive".equals(bVar2.a) || "Connection".equals(bVar2.a) || "Proxy-Connection".equals(bVar2.a)) {
                arrayList.add(bVar2);
            }
        }
        list.removeAll(arrayList);
        if (e.c) {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                i.b bVar3 = list.get(i3);
                if (bVar3 != null) {
                    Log.i("TAG_PROXY_POST_FILTER", bVar3.a + ": " + bVar3.b);
                }
            }
        }
        return list;
    }

    public static List<i.b> a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : entrySet) {
                    arrayList.add(new i.b(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static com.bytedance.sdk.openadsdk.h.b.a a(com.bytedance.sdk.openadsdk.h.e.a aVar, com.bytedance.sdk.openadsdk.h.b.c cVar, String str, int i2) {
        String str2;
        String str3;
        String str4;
        com.bytedance.sdk.openadsdk.h.b.a a2 = cVar.a(str, i2);
        if (a2 == null) {
            int a3 = a(aVar);
            String a4 = aVar.a(HttpRequest.HEADER_CONTENT_TYPE, null);
            if (a3 <= 0 || TextUtils.isEmpty(a4)) {
                return a2;
            }
            f g2 = aVar.g();
            if (g2 != null) {
                str3 = g2.b;
                str2 = b(g2.f2043e);
            } else {
                str2 = "";
                str3 = str2;
            }
            String b2 = b(aVar.c());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("requestUrl", str3);
                jSONObject.put("requestHeaders", str2);
                jSONObject.put("responseHeaders", b2);
                str4 = jSONObject.toString();
            } catch (Throwable unused) {
                str4 = "";
            }
            com.bytedance.sdk.openadsdk.h.b.a aVar2 = new com.bytedance.sdk.openadsdk.h.b.a(str, a4, a3, i2, str4);
            cVar.a(aVar2);
            return aVar2;
        }
        return a2;
    }
}
