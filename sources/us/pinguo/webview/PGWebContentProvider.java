package us.pinguo.webview;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes6.dex */
public abstract class PGWebContentProvider extends ContentProvider {
    public abstract String a();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return QiniuAuthToken.TYPE_IMAGE;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        String j2;
        String a = a();
        if (!TextUtils.isEmpty(a)) {
            if (c.b().equals(a) && (j2 = b.j()) != null) {
                String path = uri.getPath();
                return ParcelFileDescriptor.open(new File(j2 + File.separator + path), PGImageSDK.SDK_STATUS_CREATE);
            }
            return null;
        }
        throw new IllegalArgumentException("null authority");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
