package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: LocalVideoThumbnailProducer.java */
/* loaded from: classes.dex */
public class g0 implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final Executor a;
    private final ContentResolver b;

    /* compiled from: LocalVideoThumbnailProducer.java */
    /* loaded from: classes.dex */
    class a extends v0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q0 f2902f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ o0 f2903g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ImageRequest f2904h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, q0 q0Var, o0 o0Var, String str, q0 q0Var2, o0 o0Var2, ImageRequest imageRequest) {
            super(lVar, q0Var, o0Var, str);
            this.f2902f = q0Var2;
            this.f2903g = o0Var2;
            this.f2904h = imageRequest;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0, com.facebook.common.executors.f
        public void e(Exception exc) {
            super.e(exc);
            this.f2902f.b(this.f2903g, "VideoThumbnailProducer", false);
            this.f2903g.g("local");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        /* renamed from: j */
        public void b(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
            com.facebook.common.references.a.y(aVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0
        /* renamed from: k */
        public Map<String, String> i(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
            return ImmutableMap.of("createdThumbnail", String.valueOf(aVar != null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        @Nullable
        /* renamed from: l */
        public com.facebook.common.references.a<com.facebook.imagepipeline.image.c> c() throws Exception {
            String str;
            try {
                str = g0.this.i(this.f2904h);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            Bitmap createVideoThumbnail = str != null ? ThumbnailUtils.createVideoThumbnail(str, g0.g(this.f2904h)) : g0.h(g0.this.b, this.f2904h.s());
            if (createVideoThumbnail == null) {
                return null;
            }
            com.facebook.imagepipeline.image.d dVar = new com.facebook.imagepipeline.image.d(createVideoThumbnail, SimpleBitmapReleaser.getInstance(), com.facebook.imagepipeline.image.h.f2818d, 0);
            this.f2903g.b("image_format", "thumbnail");
            dVar.x(this.f2903g.getExtras());
            return com.facebook.common.references.a.R(dVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0, com.facebook.common.executors.f
        /* renamed from: m */
        public void f(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
            super.f(aVar);
            this.f2902f.b(this.f2903g, "VideoThumbnailProducer", aVar != null);
            this.f2903g.g("local");
        }
    }

    /* compiled from: LocalVideoThumbnailProducer.java */
    /* loaded from: classes.dex */
    class b extends e {
        final /* synthetic */ v0 a;

        b(g0 g0Var, v0 v0Var) {
            this.a = v0Var;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            this.a.a();
        }
    }

    public g0(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.b = contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(ImageRequest imageRequest) {
        return (imageRequest.k() > 96 || imageRequest.j() > 96) ? 1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static Bitmap h(ContentResolver contentResolver, Uri uri) {
        if (Build.VERSION.SDK_INT >= 10) {
            try {
                ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
                return mediaMetadataRetriever.getFrameAtTime(-1L);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String i(ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
        Uri s = imageRequest.s();
        if (com.facebook.common.util.d.k(s)) {
            return imageRequest.r().getPath();
        }
        if (com.facebook.common.util.d.j(s)) {
            if (Build.VERSION.SDK_INT < 19 || !"com.android.providers.media.documents".equals(s.getAuthority())) {
                uri = s;
                str = null;
                strArr = null;
            } else {
                String documentId = DocumentsContract.getDocumentId(s);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(":")[1]};
            }
            Cursor query = this.b.query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        q0 h2 = o0Var.h();
        ImageRequest j2 = o0Var.j();
        o0Var.e("local", "video");
        a aVar = new a(lVar, h2, o0Var, "VideoThumbnailProducer", h2, o0Var, j2);
        o0Var.c(new b(this, aVar));
        this.a.execute(aVar);
    }
}
