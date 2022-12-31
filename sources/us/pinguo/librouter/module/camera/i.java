package us.pinguo.librouter.module.camera;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import rx.Observable;
import rx.Subscriber;
import us.pinguo.foundation.domain.PublishMediaItem;
/* compiled from: MediaAlbumDefault.java */
/* loaded from: classes5.dex */
public class i implements e {
    private int a;

    /* compiled from: MediaAlbumDefault.java */
    /* loaded from: classes5.dex */
    class a implements Observable.OnSubscribe<ArrayList<PublishMediaItem>> {
        a() {
        }

        @Override // rx.functions.Action1
        /* renamed from: a */
        public void call(Subscriber<? super ArrayList<PublishMediaItem>> subscriber) {
            Uri uri = MediaStore.Video.Media.INTERNAL_CONTENT_URI;
            Uri uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Uri uri3 = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
            Uri uri4 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ArrayList f2 = i.this.f(uri3);
            ArrayList f3 = i.this.f(uri4);
            ArrayList g2 = i.this.g(uri);
            ArrayList g3 = i.this.g(uri2);
            f2.addAll(f3);
            f2.addAll(g2);
            f2.addAll(g3);
            Collections.sort(f2);
            subscriber.onNext(f2);
            subscriber.onCompleted();
        }
    }

    public static int e(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                if (!TextUtils.isEmpty(extractMetadata)) {
                    return Integer.parseInt(extractMetadata);
                }
            } catch (Exception e2) {
                us.pinguo.foundation.e.e(e2);
            }
            mediaMetadataRetriever.release();
            return 0;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PublishMediaItem> f(Uri uri) {
        int i2;
        int i3;
        ArrayList<PublishMediaItem> arrayList = new ArrayList<>();
        Cursor query = us.pinguo.foundation.e.b().getContentResolver().query(uri, null, "mime_type=? or mime_type=?", new String[]{"image/jpeg"}, "date_modified DESC");
        if (query == null) {
            return arrayList;
        }
        int i4 = 0;
        while (query.moveToNext()) {
            int i5 = i4 + 1;
            if (i4 >= this.a) {
                break;
            }
            String string = query.getString(query.getColumnIndex("_data"));
            int i6 = query.getInt(query.getColumnIndex("width"));
            int i7 = query.getInt(query.getColumnIndex("height"));
            int i8 = query.getInt(query.getColumnIndex("orientation"));
            long j2 = query.getInt(query.getColumnIndex("date_modified"));
            if (i6 <= 0 || i7 <= 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(string, options);
                int i9 = options.outWidth;
                i2 = options.outHeight;
                i3 = i9;
            } else {
                i3 = i6;
                i2 = i7;
            }
            arrayList.add(new PublishMediaItem(null, string, j2, i3, i2, i8, false));
            i4 = i5;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PublishMediaItem> g(Uri uri) {
        ArrayList<PublishMediaItem> arrayList = new ArrayList<>();
        Cursor query = us.pinguo.foundation.e.b().getContentResolver().query(uri, null, "mime_type=? or mime_type=?", new String[]{"video/mp4", "video/3gp"}, "date_modified");
        if (query == null) {
            return arrayList;
        }
        int i2 = 0;
        while (query.moveToNext()) {
            int i3 = i2 + 1;
            if (i2 >= this.a) {
                break;
            }
            String string = query.getString(query.getColumnIndex("_data"));
            int i4 = query.getInt(query.getColumnIndex("width"));
            int i5 = query.getInt(query.getColumnIndex("height"));
            long j2 = query.getInt(query.getColumnIndex("date_modified"));
            int i6 = query.getInt(query.getColumnIndex(TypedValues.TransitionType.S_DURATION));
            int e2 = e(string);
            String format = new SimpleDateFormat("mm:ss").format(Integer.valueOf(i6));
            PublishMediaItem publishMediaItem = new PublishMediaItem(null, string, j2, i4, i5, e2, true);
            publishMediaItem.setDurationInSec(i6 / 1000);
            publishMediaItem.setDurationStr(format);
            arrayList.add(publishMediaItem);
            i2 = i3;
        }
        return arrayList;
    }

    @Override // us.pinguo.librouter.module.camera.e
    public Observable<ArrayList<PublishMediaItem>> a(int i2) {
        this.a = i2;
        return Observable.create(new a());
    }

    @Override // us.pinguo.librouter.module.camera.e
    public void b(Object obj) {
    }
}
