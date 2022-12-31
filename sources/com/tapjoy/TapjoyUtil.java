package com.tapjoy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.adjust.sdk.Constants;
import com.tapjoy.TJAdUnitConstants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* loaded from: classes3.dex */
public class TapjoyUtil {
    private static HashMap a = new HashMap();
    private static final AtomicInteger b = new AtomicInteger(1);

    public static String SHA1(String str) {
        return a(Constants.SHA1, str);
    }

    public static String SHA256(String str) {
        return a(Constants.SHA256, str);
    }

    private static String a(String str, String str2) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(str2.getBytes("iso-8859-1"), 0, str2.length());
        return convertToHex(messageDigest.digest());
    }

    public static Document buildDocument(String str) {
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            return newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            TapjoyLog.e("TapjoyUtil", "buildDocument exception: " + e2.toString());
            return null;
        }
    }

    public static String convertToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >>> 4) & 15;
            int i4 = 0;
            while (true) {
                if (i3 >= 0 && i3 <= 9) {
                    stringBuffer.append((char) (i3 + 48));
                } else {
                    stringBuffer.append((char) ((i3 - 10) + 97));
                }
                i3 = bArr[i2] & 15;
                int i5 = i4 + 1;
                if (i4 > 0) {
                    break;
                }
                i4 = i5;
            }
        }
        return stringBuffer.toString();
    }

    public static String convertURLParams(Map map, boolean z) {
        String str = "";
        for (Map.Entry entry : map.entrySet()) {
            if (str.length() > 0) {
                str = str + "&";
            }
            str = z ? str + Uri.encode((String) entry.getKey()) + "=" + Uri.encode((String) entry.getValue()) : str + ((String) entry.getKey()) + "=" + ((String) entry.getValue());
        }
        return str;
    }

    public static String copyTextFromJarIntoString(String str) {
        return copyTextFromJarIntoString(str, null);
    }

    public static Bitmap createBitmapFromView(View view) {
        Bitmap bitmap = null;
        if (view == null || view.getLayoutParams().width <= 0 || view.getLayoutParams().height <= 0) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(view.getLayoutParams().width, view.getLayoutParams().height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            view.draw(canvas);
            return bitmap;
        } catch (Exception e2) {
            TapjoyLog.d("TapjoyUtil", "error creating bitmap: " + e2.toString());
            return bitmap;
        }
    }

    public static void deleteFileOrDirectory(File file) {
        File[] listFiles;
        if (file == null) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                deleteFileOrDirectory(file2);
            }
        }
        TapjoyLog.d("TapjoyUtil", "****************************************");
        TapjoyLog.d("TapjoyUtil", "deleteFileOrDirectory: " + file.getAbsolutePath());
        TapjoyLog.d("TapjoyUtil", "****************************************");
        file.delete();
    }

    public static String determineMimeType(String str) {
        if (str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
        }
        String substring = str.lastIndexOf(46) != -1 ? str.substring(str.lastIndexOf(46) + 1) : "";
        return substring.equals("css") ? "text/css" : substring.equals("js") ? "text/javascript" : substring.equals(TJAdUnitConstants.String.HTML) ? "text/html" : "application/octet-stream";
    }

    public static long fileOrDirectorySize(File file) {
        File[] listFiles;
        long fileOrDirectorySize;
        long j2 = 0;
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                fileOrDirectorySize = file2.length();
            } else {
                fileOrDirectorySize = fileOrDirectorySize(file2);
            }
            j2 += fileOrDirectorySize;
        }
        return j2;
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = b;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static String getFileContents(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!z) {
            String readLine = bufferedReader.readLine();
            boolean z2 = readLine == null;
            if (readLine != null) {
                sb.append(readLine);
            }
            z = z2;
        }
        bufferedReader.close();
        fileInputStream.close();
        return sb.toString();
    }

    public static String getNodeTrimValue(NodeList nodeList) {
        Node item;
        Element element = (Element) nodeList.item(0);
        if (element != null) {
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            String str = "";
            for (int i2 = 0; i2 < length; i2++) {
                if (childNodes.item(i2) != null) {
                    str = str + item.getNodeValue();
                }
            }
            if (str != null && !str.equals("")) {
                return str.trim();
            }
        }
        return null;
    }

    public static String getRedirectDomain(String str) {
        return str != null ? str.substring(str.indexOf("//") + 2, str.lastIndexOf("/")) : "";
    }

    public static Object getResource(String str) {
        return a.get(str);
    }

    public static Map jsonToStringMap(JSONObject jSONObject) {
        return jSONObject != JSONObject.NULL ? toStringMap(jSONObject) : new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap loadBitmapFromJar(java.lang.String r6, android.content.Context r7) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            java.lang.Object r2 = getResource(r6)
            byte[] r2 = (byte[]) r2
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L1c
            int r5 = r2.length
            android.graphics.BitmapFactory.decodeByteArray(r2, r3, r5, r0)
            int r5 = r2.length
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeByteArray(r2, r3, r5)
            goto L1d
        L1c:
            r2 = r4
        L1d:
            if (r2 != 0) goto Lb1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "com/tapjoy/res/"
            r2.<init>(r5)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            java.lang.Class<com.tapjoy.TapjoyUtil> r2 = com.tapjoy.TapjoyUtil.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.net.URL r2 = r2.getResource(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r2 != 0) goto L4c
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.io.InputStream r2 = r7.open(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            android.graphics.BitmapFactory.decodeStream(r2, r4, r0)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> La9
            java.io.InputStream r6 = r7.open(r6)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> La9
        L48:
            r2 = r6
            goto L8b
        L4a:
            r6 = move-exception
            goto La0
        L4c:
            java.lang.String r7 = r2.getFile()     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.lang.String r2 = "jar:"
            boolean r2 = r7.startsWith(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r2 == 0) goto L5d
            r2 = 4
            java.lang.String r7 = r7.substring(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L5d:
            java.lang.String r2 = "file:"
            boolean r2 = r7.startsWith(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r2 == 0) goto L6a
            r2 = 5
            java.lang.String r7 = r7.substring(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L6a:
            java.lang.String r2 = "!"
            int r2 = r7.indexOf(r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            if (r2 <= 0) goto L76
            java.lang.String r7 = r7.substring(r3, r2)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
        L76:
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.util.jar.JarEntry r6 = r2.getJarEntry(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            java.io.InputStream r7 = r2.getInputStream(r6)     // Catch: java.lang.Throwable -> L9c java.lang.Exception -> L9e
            android.graphics.BitmapFactory.decodeStream(r7, r4, r0)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            java.io.InputStream r6 = r2.getInputStream(r6)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L99
            goto L48
        L8b:
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> La9
            if (r2 == 0) goto L94
            r2.close()     // Catch: java.io.IOException -> L94
        L94:
            r2 = r6
            goto Lb1
        L96:
            r6 = move-exception
            r4 = r7
            goto Lab
        L99:
            r6 = move-exception
            r2 = r7
            goto La0
        L9c:
            r6 = move-exception
            goto Lab
        L9e:
            r6 = move-exception
            r2 = r4
        La0:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> La9
            if (r2 == 0) goto La8
            r2.close()     // Catch: java.io.IOException -> La8
        La8:
            return r4
        La9:
            r6 = move-exception
            r4 = r2
        Lab:
            if (r4 == 0) goto Lb0
            r4.close()     // Catch: java.io.IOException -> Lb0
        Lb0:
            throw r6
        Lb1:
            float r6 = com.tapjoy.TapjoyConnectCore.getDeviceScreenDensityScale()
            if (r2 == 0) goto Lc7
            int r7 = r0.outWidth
            float r7 = (float) r7
            float r7 = r7 * r6
            int r7 = (int) r7
            int r0 = r0.outHeight
            float r0 = (float) r0
            float r0 = r0 * r6
            int r6 = (int) r0
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createScaledBitmap(r2, r7, r6, r1)
        Lc7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyUtil.loadBitmapFromJar(java.lang.String, android.content.Context):android.graphics.Bitmap");
    }

    public static void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static void safePut(Map map, String str, String str2, boolean z) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return;
        }
        if (z) {
            map.put(Uri.encode(str), Uri.encode(str2));
        } else {
            map.put(str, str2);
        }
    }

    public static View scaleDisplayAd(View view, int i2) {
        int i3 = view.getLayoutParams().width;
        int i4 = view.getLayoutParams().height;
        TapjoyLog.d("TapjoyUtil", "wxh: " + i3 + "x" + i4);
        if (i3 > i2) {
            int intValue = Double.valueOf(Double.valueOf(Double.valueOf(i2).doubleValue() / Double.valueOf(i3).doubleValue()).doubleValue() * 100.0d).intValue();
            WebView webView = (WebView) view;
            webView.getSettings().setSupportZoom(true);
            webView.setPadding(0, 0, 0, 0);
            webView.setVerticalScrollBarEnabled(false);
            webView.setHorizontalScrollBarEnabled(false);
            webView.setInitialScale(intValue);
            view.setLayoutParams(new ViewGroup.LayoutParams(i2, (i4 * i2) / i3));
        }
        return view;
    }

    public static void setResource(String str, Object obj) {
        a.put(str, obj);
    }

    public static Map toStringMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.get(next).toString());
        }
        return hashMap;
    }

    public static void writeFileToDevice(BufferedInputStream bufferedInputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String copyTextFromJarIntoString(java.lang.String r6, android.content.Context r7) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.Class<com.tapjoy.TapjoyUtil> r2 = com.tapjoy.TapjoyUtil.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            java.net.URL r2 = r2.getResource(r6)
            r3 = 0
            r4 = 0
            if (r7 == 0) goto L22
            if (r2 != 0) goto L22
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.io.InputStream r6 = r7.open(r6)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            goto L59
        L22:
            java.lang.String r7 = r2.getFile()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r2 = "jar:"
            boolean r2 = r7.startsWith(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r2 == 0) goto L33
            r2 = 4
            java.lang.String r7 = r7.substring(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
        L33:
            java.lang.String r2 = "file:"
            boolean r2 = r7.startsWith(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r2 == 0) goto L40
            r2 = 5
            java.lang.String r7 = r7.substring(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
        L40:
            java.lang.String r2 = "!"
            int r2 = r7.indexOf(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r2 <= 0) goto L4c
            java.lang.String r7 = r7.substring(r3, r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
        L4c:
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.util.jar.JarEntry r6 = r2.getJarEntry(r6)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.io.InputStream r6 = r2.getInputStream(r6)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
        L59:
            int r7 = r6.read(r0)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7a
            if (r7 <= 0) goto L6c
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7a
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7a
            java.lang.String r7 = r2.substring(r3, r7)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7a
            r1.append(r7)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7a
            goto L59
        L6c:
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L7a
            if (r6 == 0) goto L75
            r6.close()     // Catch: java.lang.Exception -> L75
        L75:
            return r7
        L76:
            r7 = move-exception
            r4 = r6
            r6 = r7
            goto La5
        L7a:
            r7 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L83
        L7f:
            r6 = move-exception
            goto La5
        L81:
            r6 = move-exception
            r7 = r4
        L83:
            java.lang.String r0 = "TapjoyUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            java.lang.String r2 = "file exception: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La3
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> La3
            r1.append(r2)     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La3
            com.tapjoy.TapjoyLog.d(r0, r1)     // Catch: java.lang.Throwable -> La3
            r6.printStackTrace()     // Catch: java.lang.Throwable -> La3
            if (r7 == 0) goto La2
            r7.close()     // Catch: java.lang.Exception -> La2
        La2:
            return r4
        La3:
            r6 = move-exception
            r4 = r7
        La5:
            if (r4 == 0) goto Laa
            r4.close()     // Catch: java.lang.Exception -> Laa
        Laa:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TapjoyUtil.copyTextFromJarIntoString(java.lang.String, android.content.Context):java.lang.String");
    }

    public static void safePut(Map map, String str, Number number) {
        if (str == null || str.length() <= 0 || number == null) {
            return;
        }
        map.put(str, number.toString());
    }

    public static Map convertURLParams(String str, boolean z) {
        HashMap hashMap = new HashMap();
        String str2 = "";
        String str3 = str2;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length() && i2 != -1; i2++) {
            char charAt = str.charAt(i2);
            if (z2) {
                if (z2) {
                    if (charAt == '&') {
                        if (z) {
                            str2 = Uri.decode(str2);
                        }
                        hashMap.put(str3, str2);
                        str2 = "";
                        z2 = false;
                    } else {
                        str2 = str2 + charAt;
                    }
                }
            } else if (charAt == '=') {
                if (z) {
                    str2 = Uri.decode(str2);
                }
                str3 = str2;
                z2 = true;
                str2 = "";
            } else {
                str2 = str2 + charAt;
            }
        }
        if (z2 && str2.length() > 0) {
            if (z) {
                str2 = Uri.decode(str2);
            }
            hashMap.put(str3, str2);
        }
        return hashMap;
    }
}
