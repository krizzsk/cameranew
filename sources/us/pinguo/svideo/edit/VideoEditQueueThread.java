package us.pinguo.svideo.edit;

import android.content.Context;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.svideo.b.c;
import us.pinguo.svideo.recorder.RecPcmAudio;
import us.pinguo.svideo.recorder.e;
import us.pinguo.svideo.utils.b;
import us.pinguo.svideo.utils.d;
/* loaded from: classes6.dex */
public class VideoEditQueueThread extends Thread implements RecPcmAudio.a {
    private static final String m = VideoEditQueueThread.class.getSimpleName();
    private LinkedBlockingQueue<a> a;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12021d;

    /* renamed from: e  reason: collision with root package name */
    private c f12022e;

    /* renamed from: h  reason: collision with root package name */
    private PGImageSDK f12025h;

    /* renamed from: i  reason: collision with root package name */
    private Context f12026i;

    /* renamed from: k  reason: collision with root package name */
    private int f12028k;

    /* renamed from: l  reason: collision with root package name */
    private int f12029l;
    private boolean b = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12023f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f12024g = 0;

    /* renamed from: j  reason: collision with root package name */
    private LinkedList<byte[]> f12027j = new LinkedList<>();

    /* loaded from: classes6.dex */
    private static class a {
        private float a;
        private byte[] b;

        private a() {
        }
    }

    public VideoEditQueueThread(Context context) {
        this.f12026i = context.getApplicationContext();
        setPriority(10);
        RecPcmAudio.getInstance().a(this);
        this.a = new LinkedBlockingQueue<>();
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        a take;
        while (true) {
            try {
                str = m;
                b.j(str, "mQueue.take() begin", new Object[0]);
                take = this.a.take();
            } catch (InterruptedException e2) {
                d.a().a(e2);
                String str2 = m;
                b.j(str2, "队列内无数据包", new Object[0]);
                if (this.f12023f) {
                    b.j(str2, "数据写完,break", new Object[0]);
                    break;
                }
            }
            if (take.b == null) {
                break;
            }
            b.j(str, "mQueue.take() r.pts = " + (take.a * 1000.0f) + " 还剩:" + this.a.size(), new Object[0]);
            e.p.lock();
            try {
                b.j(str, "recording: writeAVFrame+", new Object[0]);
                long currentTimeMillis = System.currentTimeMillis();
                this.f12025h.writeAVFrame(take.b, take.a, this.f12028k, this.f12029l, 0, false, false);
                b.j(str, "recording: writeAVFrame-", new Object[0]);
                synchronized (this.f12027j) {
                    this.f12027j.add(take.b);
                }
                b.j(str, "mDataObjectPool.add(r.data)", new Object[0]);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.f12024g = (int) (this.f12024g + currentTimeMillis2);
                this.f12021d++;
                b.j(str, "PGNativeMethod.writeAVFrame:" + currentTimeMillis2 + "ms ave time:" + (this.f12024g / this.f12021d) + " RecordedFrames:" + this.f12021d, new Object[0]);
                e.p.unlock();
                if (this.b) {
                    this.b = false;
                }
                c cVar = this.f12022e;
                if (cVar != null) {
                    cVar.a((int) ((1000.0f / this.c) * this.f12021d));
                }
            } catch (Throwable th) {
                e.p.unlock();
                throw th;
            }
        }
        this.a.clear();
        e.p.lock();
        String str3 = m;
        b.j(str3, "recording: writeAVTrailer", new Object[0]);
        this.f12025h.writeAVTrailer();
        this.f12025h.destroySDK();
        b.j(str3, "destroyVideoSDK success", new Object[0]);
        e.p.unlock();
        this.f12027j.clear();
        this.a.clear();
    }
}
