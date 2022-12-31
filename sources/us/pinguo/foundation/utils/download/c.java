package us.pinguo.foundation.utils.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: DownloadUtils.java */
/* loaded from: classes4.dex */
public class c {
    private static Observable<Integer> a(final d dVar) {
        return Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.foundation.utils.download.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                c.c((Subscriber) obj, r0.b, r0.a, d.this.c);
            }
        });
    }

    public static Observable<Integer> b(d dVar) {
        return a(dVar).retryWhen(new e(dVar.f11104d, dVar.f11105e)).subscribeOn(Schedulers.io());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Subscriber<? super Integer> subscriber, String str, String str2, Map<String, String> map) {
        try {
            if (new File(str2).exists()) {
                subscriber.onNext(100);
                subscriber.onCompleted();
            }
            String str3 = str2 + ".temp";
            File file = new File(str3);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            long j2 = 0;
            if (file.exists()) {
                j2 = file.length();
                httpURLConnection.setRequestProperty("Range", "bytes=" + file.length() + PGTransHeader.CONNECTOR);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200 && responseCode != 206) {
                subscriber.onError(new DownloadErrorException());
                return;
            }
            long contentLength = httpURLConnection.getContentLength() + j2;
            InputStream inputStream = httpURLConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            byte[] bArr = new byte[4096];
            int i2 = -1;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    j2 += read;
                    int i3 = (int) ((100 * j2) / contentLength);
                    if (i3 == 100) {
                        i3 = 99;
                    }
                    if (i3 != i2) {
                        subscriber.onNext(Integer.valueOf(i3));
                    }
                    i2 = i3;
                } else {
                    new File(str3).renameTo(new File(str3.substring(0, str3.length() - 5)));
                    subscriber.onNext(100);
                    subscriber.onCompleted();
                    return;
                }
            }
        } catch (Throwable th) {
            us.pinguo.foundation.e.e(th);
            subscriber.onError(th);
        }
    }
}
