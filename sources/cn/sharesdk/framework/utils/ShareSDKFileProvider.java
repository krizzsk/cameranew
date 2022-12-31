package cn.sharesdk.framework.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes.dex */
public class ShareSDKFileProvider extends ContentProvider {
    private static final String[] a = {"_display_name", "_size"};
    private static final File b = new File("/");
    private static HashMap<String, PathStrategy> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private PathStrategy f213d;

    /* renamed from: e  reason: collision with root package name */
    private ProviderInfo f214e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface PathStrategy {
        File getFileForUri(Uri uri);

        Uri getUriForFile(File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements PathStrategy {
        private final String a;
        private final HashMap<String, File> b = new HashMap<>();

        public a(String str) {
            this.a = str;
        }

        public void a(String str, File file) {
            File absoluteFile;
            if (!TextUtils.isEmpty(str)) {
                try {
                    absoluteFile = file.getCanonicalFile();
                } catch (Throwable unused) {
                    absoluteFile = file.getAbsoluteFile();
                }
                this.b.put(str, absoluteFile);
                return;
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // cn.sharesdk.framework.utils.ShareSDKFileProvider.PathStrategy
        public File getFileForUri(Uri uri) {
            File absoluteFile;
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    absoluteFile = file2.getCanonicalFile();
                } catch (Throwable unused) {
                    absoluteFile = file2.getAbsoluteFile();
                }
                if (absoluteFile.getPath().startsWith(file.getPath())) {
                    return absoluteFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }

        @Override // cn.sharesdk.framework.utils.ShareSDKFileProvider.PathStrategy
        public Uri getUriForFile(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith("/")) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(this.a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }
    }

    public static Uri a(Context context, String str, File file) {
        return a(context, str).getUriForFile(file);
    }

    private static PathStrategy b(Context context, String str) {
        a aVar = new a(str);
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            aVar.a("imageNameFilesDir", a(filesDir, "Mob/cache/images"));
            aVar.a("videoNameFilesDir", a(filesDir, "Mob/cache/videos"));
        }
        String str2 = "Mob/" + MobSDK.getContext().getPackageName() + "/cache/images";
        if (MobSDK.getContext().getCacheDir() != null) {
            aVar.a("cachename", a(filesDir, "."));
            aVar.a("imageNameExternal", a(filesDir, str2));
            aVar.a("imageNameExternal", a(filesDir, "Mob/cache/images"));
        }
        String str3 = "Mob/" + MobSDK.getContext().getPackageName() + "/cache/images";
        String str4 = "Mob/" + MobSDK.getContext().getPackageName() + "/cache/videos";
        File[] a2 = a(MobSDK.getContext());
        File file = a2.length > 0 ? a2[0] : null;
        if (file != null) {
            aVar.a("imageNameExternal", a(file, str3));
            aVar.a("videoNameExternal", a(file, str4));
            aVar.a("mihayou", a(file, "."));
            aVar.a("more", a(file, "./."));
        }
        String str5 = "Mob/" + MobSDK.getContext().getPackageName() + "/cache/images";
        String str6 = "Mob/" + MobSDK.getContext().getPackageName() + "/cache/videos";
        File[] b2 = b(MobSDK.getContext());
        File file2 = b2.length > 0 ? b2[0] : null;
        if (file2 != null) {
            aVar.a("imageNameEtc", a(file2, str5));
            aVar.a("videoNameEtc", a(file2, str6));
        }
        if (b != null) {
            aVar.a("imageNameRoot", a((File) null, "Mob/cache/images"));
            aVar.a("videoNameRoot", a((File) null, "Mob/cache/videos"));
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            aVar.a("externalStDir", a(externalStorageDirectory, "."));
        }
        return aVar;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        this.f214e = providerInfo;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        a("del");
        PathStrategy pathStrategy = this.f213d;
        if (pathStrategy == null) {
            return 0;
        }
        return pathStrategy.getFileForUri(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        a("g-t");
        PathStrategy pathStrategy = this.f213d;
        if (pathStrategy == null) {
            return "";
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        int lastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        a("o-f");
        PathStrategy pathStrategy = this.f213d;
        if (pathStrategy == null) {
            return null;
        }
        return ParcelFileDescriptor.open(pathStrategy.getFileForUri(uri), b(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i2;
        a("q");
        PathStrategy pathStrategy = this.f213d;
        if (pathStrategy == null) {
            return null;
        }
        File fileForUri = pathStrategy.getFileForUri(uri);
        if (strArr == null) {
            strArr = a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i3 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i2 = i3 + 1;
                objArr[i3] = fileForUri.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i2 = i3 + 1;
                objArr[i3] = Long.valueOf(fileForUri.length());
            }
            i3 = i2;
        }
        String[] a2 = a(strArr3, i3);
        Object[] a3 = a(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    private static PathStrategy a(Context context, String str) {
        PathStrategy pathStrategy;
        synchronized (c) {
            pathStrategy = c.get(str);
            if (pathStrategy == null) {
                pathStrategy = b(context, str);
                c.put(str, pathStrategy);
            }
        }
        return pathStrategy;
    }

    private void a(String str) {
        ProviderInfo providerInfo;
        if (this.f213d == null && (providerInfo = this.f214e) != null) {
            if (!providerInfo.exported) {
                if (providerInfo.grantUriPermissions) {
                    try {
                        this.f213d = a(getContext(), this.f214e.authority);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                throw new SecurityException("Provider must grant uri permissions");
            }
            throw new SecurityException("Provider must not be exported");
        }
    }

    public static File[] a(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(null) : new File[]{context.getExternalFilesDir(null)};
    }

    private static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] a(String[] strArr, int i2) {
        String[] strArr2 = new String[i2];
        System.arraycopy(strArr, 0, strArr2, 0, i2);
        return strArr2;
    }

    private static Object[] a(Object[] objArr, int i2) {
        Object[] objArr2 = new Object[i2];
        System.arraycopy(objArr, 0, objArr2, 0, i2);
        return objArr2;
    }

    public static File[] b(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    private static int b(String str) {
        if ("r".equals(str)) {
            return PGImageSDK.SDK_STATUS_CREATE;
        }
        if (PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W.equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }
}
