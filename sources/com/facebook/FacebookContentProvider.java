package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes.dex */
public class FacebookContentProvider extends ContentProvider {
    private static final String a = FacebookContentProvider.class.getName();

    public static String a(String str, UUID uuid, String str2) {
        return String.format("%s%s/%s/%s", "content://com.facebook.app.FacebookContentProvider", str, uuid.toString(), str2);
    }

    Pair<UUID, String> b(Uri uri) {
        try {
            String[] split = uri.getPath().substring(1).split("/");
            String str = split[0];
            String str2 = split[1];
            if (!"..".contentEquals(str) && !"..".contentEquals(str2)) {
                return new Pair<>(UUID.fromString(str), str2);
            }
            throw new Exception();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
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
        Pair<UUID, String> b = b(uri);
        if (b != null) {
            try {
                File j2 = s.j((UUID) b.first, (String) b.second);
                if (j2 != null) {
                    return ParcelFileDescriptor.open(j2, PGImageSDK.SDK_STATUS_CREATE);
                }
                throw new FileNotFoundException();
            } catch (FileNotFoundException e2) {
                String str2 = a;
                Log.e(str2, "Got unexpected exception:" + e2);
                throw e2;
            }
        }
        throw new FileNotFoundException();
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
