package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes.dex */
public class LocalExifThumbnailProducer implements c1<com.facebook.imagepipeline.image.e> {
    private final Executor a;
    private final com.facebook.common.memory.f b;
    private final ContentResolver c;

    /* JADX INFO: Access modifiers changed from: private */
    @com.facebook.soloader.d
    /* loaded from: classes.dex */
    public class Api24Utils {
        private Api24Utils(LocalExifThumbnailProducer localExifThumbnailProducer) {
        }

        @Nullable
        ExifInterface a(FileDescriptor fileDescriptor) throws IOException {
            if (Build.VERSION.SDK_INT >= 24) {
                return new ExifInterface(fileDescriptor);
            }
            return null;
        }

        /* synthetic */ Api24Utils(LocalExifThumbnailProducer localExifThumbnailProducer, a aVar) {
            this(localExifThumbnailProducer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends v0<com.facebook.imagepipeline.image.e> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ImageRequest f2872f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, q0 q0Var, o0 o0Var, String str, ImageRequest imageRequest) {
            super(lVar, q0Var, o0Var, str);
            this.f2872f = imageRequest;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        /* renamed from: j */
        public void b(@Nullable com.facebook.imagepipeline.image.e eVar) {
            com.facebook.imagepipeline.image.e.h(eVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0
        /* renamed from: k */
        public Map<String, String> i(@Nullable com.facebook.imagepipeline.image.e eVar) {
            return ImmutableMap.of("createdThumbnail", Boolean.toString(eVar != null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        @Nullable
        /* renamed from: l */
        public com.facebook.imagepipeline.image.e c() throws Exception {
            ExifInterface g2 = LocalExifThumbnailProducer.this.g(this.f2872f.s());
            if (g2 == null || !g2.hasThumbnail()) {
                return null;
            }
            byte[] thumbnail = g2.getThumbnail();
            com.facebook.common.internal.h.g(thumbnail);
            return LocalExifThumbnailProducer.this.e(LocalExifThumbnailProducer.this.b.d(thumbnail), g2);
        }
    }

    /* loaded from: classes.dex */
    class b extends e {
        final /* synthetic */ v0 a;

        b(LocalExifThumbnailProducer localExifThumbnailProducer, v0 v0Var) {
            this.a = v0Var;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            this.a.a();
        }
    }

    public LocalExifThumbnailProducer(Executor executor, com.facebook.common.memory.f fVar, ContentResolver contentResolver) {
        this.a = executor;
        this.b = fVar;
        this.c = contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.image.e e(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> a2 = com.facebook.imageutils.a.a(new com.facebook.common.memory.g(pooledByteBuffer));
        int h2 = h(exifInterface);
        int intValue = a2 != null ? ((Integer) a2.first).intValue() : -1;
        int intValue2 = a2 != null ? ((Integer) a2.second).intValue() : -1;
        com.facebook.common.references.a R = com.facebook.common.references.a.R(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.image.e eVar = new com.facebook.imagepipeline.image.e(R);
            com.facebook.common.references.a.y(R);
            eVar.h0(com.facebook.imageformat.b.a);
            eVar.i0(h2);
            eVar.k0(intValue);
            eVar.g0(intValue2);
            return eVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.y(R);
            throw th;
        }
    }

    private int h(ExifInterface exifInterface) {
        String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
        com.facebook.common.internal.h.g(attribute);
        return com.facebook.imageutils.c.a(Integer.parseInt(attribute));
    }

    @Override // com.facebook.imagepipeline.producers.c1
    public boolean a(@Nullable com.facebook.imagepipeline.common.d dVar) {
        return d1.b(512, 512, dVar);
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        q0 h2 = o0Var.h();
        ImageRequest j2 = o0Var.j();
        o0Var.e("local", BigAlbumStore.PhotoColumns.EXIF);
        a aVar = new a(lVar, h2, o0Var, "LocalExifThumbnailProducer", j2);
        o0Var.c(new b(this, aVar));
        this.a.execute(aVar);
    }

    @VisibleForTesting
    boolean f(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }

    @Nullable
    @VisibleForTesting
    ExifInterface g(Uri uri) {
        String b2 = com.facebook.common.util.d.b(this.c, uri);
        if (b2 == null) {
            return null;
        }
        try {
        } catch (IOException unused) {
        } catch (StackOverflowError unused2) {
            com.facebook.common.logging.a.d(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
        }
        if (f(b2)) {
            return new ExifInterface(b2);
        }
        AssetFileDescriptor a2 = com.facebook.common.util.d.a(this.c, uri);
        if (a2 != null && Build.VERSION.SDK_INT >= 24) {
            ExifInterface a3 = new Api24Utils(this, null).a(a2.getFileDescriptor());
            a2.close();
            return a3;
        }
        return null;
    }
}
