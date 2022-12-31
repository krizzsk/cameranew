package us.pinguo.inspire.util.siliconpressor.videocompression;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.Matrix;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: MP4Builder.java */
@TargetApi(16)
/* loaded from: classes9.dex */
public class b {
    private C0403b a = null;
    private c b = null;
    private FileOutputStream c = null;

    /* renamed from: d  reason: collision with root package name */
    private FileChannel f11267d = null;

    /* renamed from: e  reason: collision with root package name */
    private long f11268e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f11269f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11270g = true;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<g, long[]> f11271h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f11272i = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MP4Builder.java */
    /* renamed from: us.pinguo.inspire.util.siliconpressor.videocompression.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0403b implements Box {
        private Container a;
        private long b;
        private long c;

        private C0403b(b bVar) {
            this.b = IjkMediaMeta.AV_CH_STEREO_RIGHT;
            this.c = 0L;
        }

        private boolean b(long j2) {
            return j2 + 8 < IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }

        public long a() {
            return this.b;
        }

        public void c(long j2) {
            this.b = j2;
        }

        public void d(long j2) {
            this.c = j2;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            long size = getSize();
            if (b(size)) {
                IsoTypeWriter.writeUInt32(allocate, size);
            } else {
                IsoTypeWriter.writeUInt32(allocate, 1L);
            }
            allocate.put(IsoFile.fourCCtoBytes(MediaDataBox.TYPE));
            if (b(size)) {
                allocate.put(new byte[8]);
            } else {
                IsoTypeWriter.writeUInt64(allocate, size);
            }
            allocate.rewind();
            writableByteChannel.write(allocate);
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getOffset() {
            return this.c;
        }

        @Override // com.coremedia.iso.boxes.Box
        public Container getParent() {
            return this.a;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            return this.b + 16;
        }

        @Override // com.coremedia.iso.boxes.Box
        public String getType() {
            return MediaDataBox.TYPE;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j2, BoxParser boxParser) throws IOException {
        }

        @Override // com.coremedia.iso.boxes.Box
        public void setParent(Container container) {
            this.a = container;
        }
    }

    private void n() throws Exception {
        long position = this.f11267d.position();
        this.f11267d.position(this.a.getOffset());
        this.a.getBox(this.f11267d);
        this.f11267d.position(position);
        this.a.d(0L);
        this.a.c(0L);
        this.c.flush();
    }

    public static long o(long j2, long j3) {
        return j3 == 0 ? j2 : o(j3, j2 % j3);
    }

    public int a(MediaFormat mediaFormat, boolean z) throws Exception {
        return this.b.b(mediaFormat, z);
    }

    protected FileTypeBox b() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("3gp4");
        return new FileTypeBox("isom", 0L, linkedList);
    }

    public b c(c cVar) throws Exception {
        this.b = cVar;
        FileOutputStream fileOutputStream = new FileOutputStream(cVar.c());
        this.c = fileOutputStream;
        this.f11267d = fileOutputStream.getChannel();
        FileTypeBox b = b();
        b.getBox(this.f11267d);
        long size = this.f11268e + b.getSize();
        this.f11268e = size;
        this.f11269f += size;
        this.a = new C0403b();
        this.f11272i = ByteBuffer.allocateDirect(4);
        return this;
    }

    protected MovieBox d(c cVar) {
        MovieBox movieBox = new MovieBox();
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setCreationTime(new Date());
        movieHeaderBox.setModificationTime(new Date());
        movieHeaderBox.setMatrix(Matrix.ROTATE_0);
        long p = p(cVar);
        Iterator<g> it = cVar.e().iterator();
        long j2 = 0;
        while (it.hasNext()) {
            g next = it.next();
            long c = (next.c() * p) / next.k();
            if (c > j2) {
                j2 = c;
            }
        }
        movieHeaderBox.setDuration(j2);
        movieHeaderBox.setTimescale(p);
        movieHeaderBox.setNextTrackId(cVar.e().size() + 1);
        movieBox.addBox(movieHeaderBox);
        Iterator<g> it2 = cVar.e().iterator();
        while (it2.hasNext()) {
            movieBox.addBox(l(it2.next(), cVar));
        }
        return movieBox;
    }

    protected Box e(g gVar) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        h(gVar, sampleTableBox);
        k(gVar, sampleTableBox);
        i(gVar, sampleTableBox);
        g(gVar, sampleTableBox);
        j(gVar, sampleTableBox);
        f(gVar, sampleTableBox);
        return sampleTableBox;
    }

    protected void f(g gVar, SampleTableBox sampleTableBox) {
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = gVar.i().iterator();
        long j2 = -1;
        while (it.hasNext()) {
            e next = it.next();
            long a2 = next.a();
            if (j2 != -1 && j2 != a2) {
                j2 = -1;
            }
            if (j2 == -1) {
                arrayList.add(Long.valueOf(a2));
            }
            j2 = next.b() + a2;
        }
        long[] jArr = new long[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jArr[i2] = ((Long) arrayList.get(i2)).longValue();
        }
        StaticChunkOffsetBox staticChunkOffsetBox = new StaticChunkOffsetBox();
        staticChunkOffsetBox.setChunkOffsets(jArr);
        sampleTableBox.addBox(staticChunkOffsetBox);
    }

    protected void g(g gVar, SampleTableBox sampleTableBox) {
        SampleToChunkBox sampleToChunkBox = new SampleToChunkBox();
        sampleToChunkBox.setEntries(new LinkedList());
        int size = gVar.i().size();
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < size) {
            e eVar = gVar.i().get(i3);
            i4++;
            if (i3 == size + (-1) || eVar.a() + eVar.b() != gVar.i().get(i3 + 1).a()) {
                if (i2 != i4) {
                    sampleToChunkBox.getEntries().add(new SampleToChunkBox.Entry(i5, i4, 1L));
                    i2 = i4;
                }
                i5++;
                i4 = 0;
            }
            i3++;
        }
        sampleTableBox.addBox(sampleToChunkBox);
    }

    protected void h(g gVar, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(gVar.g());
    }

    protected void i(g gVar, SampleTableBox sampleTableBox) {
        long[] j2 = gVar.j();
        if (j2 == null || j2.length <= 0) {
            return;
        }
        SyncSampleBox syncSampleBox = new SyncSampleBox();
        syncSampleBox.setSampleNumber(j2);
        sampleTableBox.addBox(syncSampleBox);
    }

    protected void j(g gVar, SampleTableBox sampleTableBox) {
        SampleSizeBox sampleSizeBox = new SampleSizeBox();
        sampleSizeBox.setSampleSizes(this.f11271h.get(gVar));
        sampleTableBox.addBox(sampleSizeBox);
    }

    protected void k(g gVar, SampleTableBox sampleTableBox) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = gVar.h().iterator();
        TimeToSampleBox.Entry entry = null;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (entry != null && entry.getDelta() == longValue) {
                entry.setCount(entry.getCount() + 1);
            } else {
                entry = new TimeToSampleBox.Entry(1L, longValue);
                arrayList.add(entry);
            }
        }
        TimeToSampleBox timeToSampleBox = new TimeToSampleBox();
        timeToSampleBox.setEntries(arrayList);
        sampleTableBox.addBox(timeToSampleBox);
    }

    protected TrackBox l(g gVar, c cVar) {
        TrackBox trackBox = new TrackBox();
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setEnabled(true);
        trackHeaderBox.setInMovie(true);
        trackHeaderBox.setInPreview(true);
        if (gVar.o()) {
            trackHeaderBox.setMatrix(Matrix.ROTATE_0);
        } else {
            trackHeaderBox.setMatrix(cVar.d());
        }
        trackHeaderBox.setAlternateGroup(0);
        trackHeaderBox.setCreationTime(gVar.b());
        trackHeaderBox.setDuration((gVar.c() * p(cVar)) / gVar.k());
        trackHeaderBox.setHeight(gVar.e());
        trackHeaderBox.setWidth(gVar.n());
        trackHeaderBox.setLayer(0);
        trackHeaderBox.setModificationTime(new Date());
        trackHeaderBox.setTrackId(gVar.l() + 1);
        trackHeaderBox.setVolume(gVar.m());
        trackBox.addBox(trackHeaderBox);
        MediaBox mediaBox = new MediaBox();
        trackBox.addBox(mediaBox);
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(gVar.b());
        mediaHeaderBox.setDuration(gVar.c());
        mediaHeaderBox.setTimescale(gVar.k());
        mediaHeaderBox.setLanguage("eng");
        mediaBox.addBox(mediaHeaderBox);
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setName(gVar.o() ? "SoundHandle" : "VideoHandle");
        handlerBox.setHandlerType(gVar.d());
        mediaBox.addBox(handlerBox);
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        mediaInformationBox.addBox(gVar.f());
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        mediaInformationBox.addBox(dataInformationBox);
        mediaInformationBox.addBox(e(gVar));
        mediaBox.addBox(mediaInformationBox);
        return trackBox;
    }

    public void m(boolean z) throws Exception {
        if (this.a.a() != 0) {
            n();
        }
        Iterator<g> it = this.b.e().iterator();
        while (it.hasNext()) {
            g next = it.next();
            ArrayList<e> i2 = next.i();
            int size = i2.size();
            long[] jArr = new long[size];
            for (int i3 = 0; i3 < size; i3++) {
                jArr[i3] = i2.get(i3).b();
            }
            this.f11271h.put(next, jArr);
        }
        d(this.b).getBox(this.f11267d);
        this.c.flush();
        this.f11267d.close();
        this.c.close();
    }

    public long p(c cVar) {
        long k2 = !cVar.e().isEmpty() ? cVar.e().iterator().next().k() : 0L;
        Iterator<g> it = cVar.e().iterator();
        while (it.hasNext()) {
            k2 = o(it.next().k(), k2);
        }
        return k2;
    }

    public boolean q(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) throws Exception {
        if (this.f11270g) {
            this.a.c(0L);
            this.a.getBox(this.f11267d);
            this.a.d(this.f11268e);
            this.f11268e += 16;
            this.f11269f += 16;
            this.f11270g = false;
        }
        C0403b c0403b = this.a;
        c0403b.c(c0403b.a() + bufferInfo.size);
        long j2 = this.f11269f + bufferInfo.size;
        this.f11269f = j2;
        boolean z2 = true;
        if (j2 >= 32768) {
            n();
            this.f11270g = true;
            this.f11269f -= 32768;
        } else {
            z2 = false;
        }
        this.b.a(i2, this.f11268e, bufferInfo);
        byteBuffer.position(bufferInfo.offset + (z ? 0 : 4));
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        if (!z) {
            this.f11272i.position(0);
            this.f11272i.putInt(bufferInfo.size - 4);
            this.f11272i.position(0);
            this.f11267d.write(this.f11272i);
        }
        this.f11267d.write(byteBuffer);
        this.f11268e += bufferInfo.size;
        if (z2) {
            this.c.flush();
        }
        return z2;
    }
}
