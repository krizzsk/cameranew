package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import d.f.a.b.c;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public class BaseImageDownloader implements ImageDownloader {
    protected final Context a;
    protected final int b = 5000;
    protected final int c = 20000;

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this.a = context.getApplicationContext();
    }

    private boolean i(Uri uri) {
        String type = this.a.getContentResolver().getType(uri);
        if (type == null) {
            return false;
        }
        return type.startsWith("video/");
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream a(String str, Object obj) throws IOException {
        switch (a.a[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return g(str, obj);
            case 3:
                return f(str, obj);
            case 4:
                return d(str, obj);
            case 5:
                return c(str, obj);
            case 6:
                return e(str, obj);
            default:
                h(str, obj);
                throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpURLConnection b(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
        return httpURLConnection;
    }

    protected InputStream c(String str, Object obj) throws IOException {
        return this.a.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    protected InputStream d(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.a.getContentResolver();
        Uri parse = Uri.parse(str);
        if (i(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith("content://com.android.contacts/")) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, parse);
        }
        return contentResolver.openInputStream(parse);
    }

    protected InputStream e(String str, Object obj) {
        return this.a.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    protected InputStream f(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream g(String str, Object obj) throws IOException {
        HttpURLConnection b = b(str, obj);
        for (int i2 = 0; b.getResponseCode() / 100 == 3 && i2 < 5; i2++) {
            b = b(b.getHeaderField(HttpRequest.HEADER_LOCATION), obj);
        }
        try {
            return new com.nostra13.universalimageloader.core.assist.a(new BufferedInputStream(b.getInputStream(), 32768), b.getContentLength());
        } catch (IOException e2) {
            c.d(b.getErrorStream());
            throw e2;
        }
    }

    protected InputStream h(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", str));
    }
}
