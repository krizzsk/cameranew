package us.pinguo.foundation.utils;
/* compiled from: VideoThumbnailUtils.java */
/* loaded from: classes4.dex */
public class q0 {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap a(java.lang.String r4, int r5, int r6) {
        /*
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            r1 = 0
            r0.setDataSource(r4)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L1a
            r2 = 0
            android.graphics.Bitmap r4 = r0.getFrameAtTime(r2)     // Catch: java.lang.Throwable -> L15 java.lang.Throwable -> L1a
            r0.release()     // Catch: java.lang.RuntimeException -> L13
            goto L1e
        L13:
            goto L1e
        L15:
            r4 = move-exception
            r0.release()     // Catch: java.lang.RuntimeException -> L19
        L19:
            throw r4
        L1a:
            r0.release()     // Catch: java.lang.RuntimeException -> L1d
        L1d:
            r4 = r1
        L1e:
            if (r4 != 0) goto L21
            return r1
        L21:
            r0 = 2
            android.graphics.Bitmap r4 = android.media.ThumbnailUtils.extractThumbnail(r4, r5, r6, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.utils.q0.a(java.lang.String, int, int):android.graphics.Bitmap");
    }
}
