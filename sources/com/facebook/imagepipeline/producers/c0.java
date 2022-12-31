package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: LocalContentUriThumbnailFetchProducer.java */
/* loaded from: classes.dex */
public class c0 extends d0 implements c1<com.facebook.imagepipeline.image.e> {

    /* renamed from: d  reason: collision with root package name */
    private static final Class<?> f2879d = c0.class;

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f2880e = {"_id", "_data"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f2881f = {"_data"};

    /* renamed from: g  reason: collision with root package name */
    private static final Rect f2882g = new Rect(0, 0, 512, 384);

    /* renamed from: h  reason: collision with root package name */
    private static final Rect f2883h = new Rect(0, 0, 96, 96);
    private final ContentResolver c;

    public c0(Executor executor, com.facebook.common.memory.f fVar, ContentResolver contentResolver) {
        super(executor, fVar);
        this.c = contentResolver;
    }

    @Nullable
    private com.facebook.imagepipeline.image.e g(Uri uri, @Nullable com.facebook.imagepipeline.common.d dVar) throws IOException {
        Cursor query;
        com.facebook.imagepipeline.image.e j2;
        if (dVar == null || (query = this.c.query(uri, f2880e, null, null, null)) == null) {
            return null;
        }
        try {
            if (!query.moveToFirst() || (j2 = j(dVar, query.getLong(query.getColumnIndex("_id")))) == null) {
                return null;
            }
            j2.i0(i(query.getString(query.getColumnIndex("_data"))));
            return j2;
        } finally {
            query.close();
        }
    }

    private static int h(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    private static int i(@Nullable String str) {
        if (str != null) {
            try {
                return com.facebook.imageutils.c.a(new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
            } catch (IOException e2) {
                com.facebook.common.logging.a.g(f2879d, e2, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }

    @Nullable
    private com.facebook.imagepipeline.image.e j(com.facebook.imagepipeline.common.d dVar, long j2) throws IOException {
        Cursor queryMiniThumbnail;
        int k2 = k(dVar);
        if (k2 == 0 || (queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.c, j2, k2, f2881f)) == null) {
            return null;
        }
        try {
            if (queryMiniThumbnail.moveToFirst()) {
                String string = queryMiniThumbnail.getString(queryMiniThumbnail.getColumnIndex("_data"));
                com.facebook.common.internal.h.g(string);
                String str = string;
                if (new File(str).exists()) {
                    return e(new FileInputStream(str), h(str));
                }
            }
            return null;
        } finally {
            queryMiniThumbnail.close();
        }
    }

    private static int k(com.facebook.imagepipeline.common.d dVar) {
        Rect rect = f2883h;
        if (d1.b(rect.width(), rect.height(), dVar)) {
            return 3;
        }
        Rect rect2 = f2882g;
        return d1.b(rect2.width(), rect2.height(), dVar) ? 1 : 0;
    }

    @Override // com.facebook.imagepipeline.producers.c1
    public boolean a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        Rect rect = f2882g;
        return d1.b(rect.width(), rect.height(), dVar);
    }

    @Override // com.facebook.imagepipeline.producers.d0
    @Nullable
    protected com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException {
        Uri s = imageRequest.s();
        if (com.facebook.common.util.d.h(s)) {
            return g(s, imageRequest.o());
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.d0
    protected String f() {
        return "LocalContentUriThumbnailFetchProducer";
    }
}
