package com.ironsource.sdk.utils;

import android.content.Context;
import com.ironsource.sdk.fileSystem.ISNFile;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* compiled from: IronSourceStorageUtils.java */
/* loaded from: classes2.dex */
public class c {
    private static com.ironsource.sdk.fileSystem.d a;

    public static String a(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + File.separator + str2;
    }

    public static JSONObject b(String str, String str2) {
        File file = new File(str, str2);
        JSONObject jSONObject = new JSONObject();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                try {
                    Object u = u(file2);
                    if (u instanceof JSONArray) {
                        jSONObject.put("files", u(file2));
                    } else if (u instanceof JSONObject) {
                        jSONObject.put(file2.getName(), u(file2));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject c(ISNFile iSNFile, JSONObject jSONObject) throws Exception {
        if (iSNFile != null && iSNFile.isDirectory()) {
            File[] listFiles = iSNFile.listFiles();
            if (listFiles == null) {
                return new JSONObject();
            }
            JSONObject jSONObject2 = new JSONObject();
            for (File file : listFiles) {
                ISNFile iSNFile2 = new ISNFile(file.getPath());
                if (iSNFile2.isFile()) {
                    String name = iSNFile2.getName();
                    JSONObject jSONObject3 = iSNFile2.toJSONObject();
                    if (jSONObject.has(name)) {
                        jSONObject2.put(name, f.B(jSONObject3, jSONObject.getJSONObject(name)));
                    } else {
                        jSONObject2.put(name, jSONObject3);
                    }
                } else if (iSNFile2.isDirectory()) {
                    jSONObject2.put(iSNFile2.getName(), c(iSNFile2, jSONObject));
                }
            }
            return jSONObject2;
        }
        return new JSONObject();
    }

    private static void d(Context context) {
        com.ironsource.sdk.fileSystem.d dVar = a;
        if (dVar != null && dVar.a()) {
            e(context);
        }
        com.ironsource.sdk.fileSystem.d dVar2 = a;
        if (dVar2 == null || !dVar2.b()) {
            return;
        }
        g(context);
    }

    public static void e(Context context) {
        j(com.ironsource.environment.e.z(context));
        j(com.ironsource.environment.e.D(context));
    }

    public static synchronized boolean f(ISNFile iSNFile) {
        synchronized (c.class) {
            if (iSNFile.exists()) {
                return iSNFile.delete();
            }
            return false;
        }
    }

    public static void g(Context context) {
        j(com.ironsource.environment.e.A(context));
        j(com.ironsource.environment.e.E(context));
    }

    public static synchronized boolean h(String str) {
        boolean z;
        synchronized (c.class) {
            File file = new File(str);
            if (i(file)) {
                z = file.delete();
            }
        }
        return z;
    }

    public static boolean i(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= i(file2);
                }
                if (!file2.delete()) {
                    z = false;
                }
            }
        }
        return z;
    }

    private static void j(File file) {
        if (file != null) {
            h(q(file).getPath());
        }
    }

    public static String k(String str, String str2) {
        JSONObject b = b(str, str2);
        try {
            b.put(PGEditResultActivity2.PATH, str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return b.toString();
    }

    public static String l(Context context) {
        File m;
        if (f.w() && (m = m(context)) != null && m.canWrite()) {
            return m.getPath();
        }
        return o(context).getPath();
    }

    private static File m(Context context) {
        com.ironsource.sdk.fileSystem.d dVar = a;
        if (dVar != null && dVar.c()) {
            return com.ironsource.environment.e.z(context);
        }
        return com.ironsource.environment.e.A(context);
    }

    public static ArrayList<ISNFile> n(ISNFile iSNFile) {
        if (iSNFile != null && iSNFile.isDirectory()) {
            ArrayList<ISNFile> arrayList = new ArrayList<>();
            File[] listFiles = iSNFile.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    ISNFile iSNFile2 = new ISNFile(file.getPath());
                    if (iSNFile2.isDirectory()) {
                        arrayList.addAll(n(iSNFile2));
                    }
                    if (iSNFile2.isFile()) {
                        arrayList.add(iSNFile2);
                    }
                }
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    private static File o(Context context) {
        com.ironsource.sdk.fileSystem.d dVar = a;
        if (dVar != null && dVar.c()) {
            return com.ironsource.environment.e.D(context);
        }
        return com.ironsource.environment.e.E(context);
    }

    public static String p(Context context) {
        File q = q(new File(l(context)));
        if (!q.exists()) {
            q.mkdir();
        }
        return q.getPath();
    }

    private static File q(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("supersonicads");
        sb.append(str);
        return new File(sb.toString());
    }

    public static long r(ISNFile iSNFile) {
        long r;
        long j2 = 0;
        if (iSNFile != null && iSNFile.isDirectory()) {
            File[] listFiles = iSNFile.listFiles();
            if (listFiles == null) {
                return 0L;
            }
            for (File file : listFiles) {
                ISNFile iSNFile2 = new ISNFile(file.getPath());
                if (iSNFile2.isFile()) {
                    r = iSNFile2.length();
                } else if (iSNFile2.isDirectory()) {
                    r = r(iSNFile2);
                }
                j2 += r;
            }
        }
        return j2;
    }

    public static void s(Context context, com.ironsource.sdk.fileSystem.d dVar) {
        a = dVar;
        d(context);
    }

    public static boolean t(String str, String str2) {
        return new File(str, str2).exists();
    }

    private static Object u(File file) {
        File[] listFiles;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (file.isFile()) {
            jSONArray.put(file.getName());
            return jSONArray;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                jSONObject.put(file2.getName(), u(file2));
            } else {
                jSONArray.put(file2.getName());
                jSONObject.put("files", jSONArray);
            }
        }
        return jSONObject;
    }

    public static String v(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static String w(ISNFile iSNFile) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(iSNFile));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append('\n');
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static boolean x(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    public static int y(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[102400];
            int i2 = 0;
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return i2;
                }
                fileOutputStream.write(bArr2, 0, read);
                i2 += read;
            }
        } finally {
            fileOutputStream.close();
            byteArrayInputStream.close();
        }
    }
}
