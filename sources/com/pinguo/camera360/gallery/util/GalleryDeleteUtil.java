package com.pinguo.camera360.gallery.util;

import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.ContentUris;
import android.content.IntentSender;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.pinguo.camera360.gallery.data.h;
import com.pinguo.camera360.gallery.data.w;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.p0;
/* compiled from: GalleryDeleteUtil.kt */
/* loaded from: classes3.dex */
public final class GalleryDeleteUtil {
    public static final GalleryDeleteUtil a = new GalleryDeleteUtil();
    private static boolean b;
    private static Integer c;

    /* renamed from: d  reason: collision with root package name */
    private static ArrayList<b> f6718d;

    /* renamed from: e  reason: collision with root package name */
    private static final MutableLiveData<c> f6719e;

    /* renamed from: f  reason: collision with root package name */
    private static final LiveData<c> f6720f;

    /* renamed from: g  reason: collision with root package name */
    private static final m0 f6721g;

    static {
        MutableLiveData<c> mutableLiveData = new MutableLiveData<>();
        f6719e = mutableLiveData;
        f6720f = mutableLiveData;
        f6721g = n0.a(z0.b());
    }

    private GalleryDeleteUtil() {
    }

    private final int j(String str, Uri uri) {
        int i2 = 0;
        Cursor query = e.b().getContentResolver().query(uri, new String[]{"_id", "_data"}, "_data = ?", new String[]{str}, null);
        if (query != null) {
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                while (query.moveToNext()) {
                    i2 = (int) query.getLong(columnIndexOrThrow);
                }
                u uVar = u.a;
                kotlin.io.b.a(query, null);
            } finally {
            }
        }
        return i2;
    }

    public final void c() {
        ArrayList<b> arrayList = f6718d;
        if (arrayList != null) {
            arrayList.clear();
        }
        f6718d = null;
        c = null;
    }

    public final void d() {
        l.d(f6721g, null, null, new GalleryDeleteUtil$deleteLocalDB$1(null), 3, null);
    }

    public final void e(List<? extends w> pendingDeletes) {
        Number valueOf;
        s.h(pendingDeletes, "pendingDeletes");
        f6718d = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        for (w wVar : pendingDeletes) {
            Uri uriType = wVar.y() ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            if (wVar instanceof h) {
                String str = ((h) wVar).f6359k;
                s.g(str, "value.localPath");
                s.g(uriType, "uriType");
                valueOf = Integer.valueOf(j(str, uriType));
            } else {
                valueOf = Long.valueOf(wVar.r());
            }
            Uri withAppendedId = ContentUris.withAppendedId(uriType, valueOf.longValue());
            s.g(withAppendedId, "withAppendedId(uriType, id.toLong())");
            ArrayList<b> arrayList2 = f6718d;
            if (arrayList2 != null) {
                arrayList2.add(new b(valueOf.intValue(), wVar.y()));
            }
            arrayList.add(withAppendedId);
        }
        PendingIntent createDeleteRequest = MediaStore.createDeleteRequest(e.b().getContentResolver(), arrayList);
        s.g(createDeleteRequest, "createDeleteRequest(Foun…().contentResolver, uris)");
        MutableLiveData<c> mutableLiveData = f6719e;
        IntentSender intentSender = createDeleteRequest.getIntentSender();
        s.g(intentSender, "pendingIntent.intentSender");
        mutableLiveData.postValue(new c("", intentSender));
    }

    public final void f() {
        l.d(f6721g, null, null, new GalleryDeleteUtil$deleteResource$1(null), 3, null);
    }

    public final void g(boolean z, Integer num) {
        if (num == null) {
            num = c;
        }
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        Uri uri = z ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        b = z;
        try {
            Uri withAppendedId = ContentUris.withAppendedId(uri, intValue);
            s.g(withAppendedId, "withAppendedId(uriType, id.toLong())");
            e.b().getContentResolver().delete(withAppendedId, "_id = ?", new String[]{String.valueOf(intValue)});
            if (z) {
                return;
            }
            BigAlbumManager.instance().deletePhotoBySystemDbId(intValue);
        } catch (SecurityException e2) {
            if (p0.a(this)) {
                RecoverableSecurityException recoverableSecurityException = e2 instanceof RecoverableSecurityException ? (RecoverableSecurityException) e2 : null;
                if (recoverableSecurityException != null) {
                    c = Integer.valueOf(intValue);
                    MutableLiveData<c> mutableLiveData = f6719e;
                    IntentSender intentSender = recoverableSecurityException.getUserAction().getActionIntent().getIntentSender();
                    s.g(intentSender, "recoverableSecurityExcep…actionIntent.intentSender");
                    mutableLiveData.postValue(new c("single", intentSender));
                    return;
                }
                throw e2;
            }
            CrashReport.postCatchedException(e2);
        }
    }

    public final void h(String filePath, boolean z) {
        s.h(filePath, "filePath");
        Uri uriType = z ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        s.g(uriType, "uriType");
        g(z, Integer.valueOf(j(filePath, uriType)));
    }

    public final LiveData<c> i() {
        return f6720f;
    }
}
