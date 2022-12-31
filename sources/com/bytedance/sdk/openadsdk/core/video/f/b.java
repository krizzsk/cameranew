package com.bytedance.sdk.openadsdk.core.video.f;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.HashMap;
/* compiled from: MediaUtils.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: MediaUtils.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055b {
        void a(Bitmap bitmap);
    }

    public static void a(long j2, String str, InterfaceC0055b interfaceC0055b) {
        new a(interfaceC0055b, j2).execute(str);
    }

    /* compiled from: MediaUtils.java */
    /* loaded from: classes.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {
        private InterfaceC0055b a;
        private long b;

        public a(InterfaceC0055b interfaceC0055b, long j2) {
            this.b = 0L;
            this.a = interfaceC0055b;
            this.b = j2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.b * 1000, 3);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Throwable th) {
                o.c("MediaUtils", "MediaUtils doInBackground : ", th);
                return bitmap;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0055b interfaceC0055b = this.a;
            if (interfaceC0055b != null) {
                interfaceC0055b.a(bitmap);
            }
        }
    }
}
