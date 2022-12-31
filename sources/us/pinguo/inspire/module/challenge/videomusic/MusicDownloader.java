package us.pinguo.inspire.module.challenge.videomusic;

import com.nostra13.universalimageloader.core.ImageLoader;
import d.f.a.b.c;
import java.io.File;
import java.io.IOException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.inspire.Inspire;
import us.pinguo.ui.C360BaseImageDownloader;
/* compiled from: MusicDownloader.kt */
/* loaded from: classes9.dex */
public final class MusicDownloader {
    public static final MusicDownloader INSTANCE = new MusicDownloader();
    private static final C360BaseImageDownloader downloader = new C360BaseImageDownloader(Inspire.a());
    private static final d.f.a.a.a.d.c nameGenerator = new d.f.a.a.a.d.c();

    private MusicDownloader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadMusic$lambda-1  reason: not valid java name */
    public static final void m109downloadMusic$lambda1(final String url, File file, final MusicDownloadListener listener, Subscriber subscriber) {
        kotlin.jvm.internal.s.h(url, "$url");
        kotlin.jvm.internal.s.h(listener, "$listener");
        try {
            ImageLoader.getInstance().m().b(url, downloader.a(url, null), new c.a() { // from class: us.pinguo.inspire.module.challenge.videomusic.d
                @Override // d.f.a.b.c.a
                public final boolean a(int i2, int i3) {
                    boolean m110downloadMusic$lambda1$lambda0;
                    m110downloadMusic$lambda1$lambda0 = MusicDownloader.m110downloadMusic$lambda1$lambda0(MusicDownloadListener.this, url, i2, i3);
                    return m110downloadMusic$lambda1$lambda0;
                }
            });
            us.pinguo.common.utils.e.e(ImageLoader.getInstance().m().get(url), file);
            subscriber.onNext(Boolean.TRUE);
        } catch (IOException unused) {
            subscriber.onNext(Boolean.FALSE);
        }
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadMusic$lambda-1$lambda-0  reason: not valid java name */
    public static final boolean m110downloadMusic$lambda1$lambda0(MusicDownloadListener listener, String url, int i2, int i3) {
        kotlin.jvm.internal.s.h(listener, "$listener");
        kotlin.jvm.internal.s.h(url, "$url");
        listener.onProgress(url, i2 / i3, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadMusic$lambda-2  reason: not valid java name */
    public static final void m111downloadMusic$lambda2(MusicDownloadListener listener, String url, File file, Boolean success) {
        kotlin.jvm.internal.s.h(listener, "$listener");
        kotlin.jvm.internal.s.h(url, "$url");
        kotlin.jvm.internal.s.g(success, "success");
        if (success.booleanValue()) {
            listener.onComplete(url, true, file);
        } else {
            listener.onComplete(url, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadMusic$lambda-3  reason: not valid java name */
    public static final void m112downloadMusic$lambda3(MusicDownloadListener listener, String url, Throwable th) {
        kotlin.jvm.internal.s.h(listener, "$listener");
        kotlin.jvm.internal.s.h(url, "$url");
        us.pinguo.common.log.a.f(th);
        listener.onComplete(url, false, null);
    }

    public final void downloadMusic(final String url, final MusicDownloadListener listener) {
        kotlin.jvm.internal.s.h(url, "url");
        kotlin.jvm.internal.s.h(listener, "listener");
        final File downloadedMusic = getDownloadedMusic(url);
        us.pinguo.foundation.utils.h.a(Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.challenge.videomusic.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MusicDownloader.m109downloadMusic$lambda1(url, downloadedMusic, listener, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.challenge.videomusic.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MusicDownloader.m111downloadMusic$lambda2(MusicDownloadListener.this, url, downloadedMusic, (Boolean) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.challenge.videomusic.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                MusicDownloader.m112downloadMusic$lambda3(MusicDownloadListener.this, url, (Throwable) obj);
            }
        }));
    }

    public final File getDownloadedMusic(String str) {
        if (str == null) {
            return null;
        }
        return new File(new File(Inspire.b(), "music"), nameGenerator.a(str));
    }
}
