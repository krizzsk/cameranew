package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class MP3TrackImpl extends AbstractTrack {
    private static final int ES_OBJECT_TYPE_INDICATION = 107;
    private static final int ES_STREAM_TYPE = 5;
    private static final int MPEG_L3 = 1;
    private static final int MPEG_V1 = 3;
    private static final int SAMPLES_PER_FRAME = 1152;
    long avgBitRate;
    private final DataSource dataSource;
    private long[] durations;
    a firstHeader;
    long maxBitRate;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    TrackMetaData trackMetaData;
    private static final int[] SAMPLE_RATE = {44100, 48000, 32000};
    private static final int[] BIT_RATE = {0, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        int a;
        int b;
        int c;

        /* renamed from: d  reason: collision with root package name */
        int f5086d;

        /* renamed from: e  reason: collision with root package name */
        int f5087e;

        /* renamed from: f  reason: collision with root package name */
        int f5088f;

        /* renamed from: g  reason: collision with root package name */
        int f5089g;

        /* renamed from: h  reason: collision with root package name */
        int f5090h;

        /* renamed from: i  reason: collision with root package name */
        int f5091i;

        a(MP3TrackImpl mP3TrackImpl) {
        }

        int a() {
            return ((this.f5086d * IjkMediaMeta.FF_PROFILE_H264_HIGH_444) / this.f5088f) + this.f5089g;
        }
    }

    public MP3TrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
    }

    private a readMP3Header(DataSource dataSource) throws IOException {
        a aVar = new a(this);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        while (allocate.position() < 4) {
            if (dataSource.read(allocate) == -1) {
                return null;
            }
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
        if (bitReaderBuffer.readBits(11) == 2047) {
            int readBits = bitReaderBuffer.readBits(2);
            aVar.a = readBits;
            if (readBits == 3) {
                int readBits2 = bitReaderBuffer.readBits(2);
                aVar.b = readBits2;
                if (readBits2 == 1) {
                    bitReaderBuffer.readBits(1);
                    int readBits3 = bitReaderBuffer.readBits(4);
                    aVar.c = readBits3;
                    int i2 = BIT_RATE[readBits3];
                    aVar.f5086d = i2;
                    if (i2 != 0) {
                        int readBits4 = bitReaderBuffer.readBits(2);
                        aVar.f5087e = readBits4;
                        int i3 = SAMPLE_RATE[readBits4];
                        aVar.f5088f = i3;
                        if (i3 != 0) {
                            aVar.f5089g = bitReaderBuffer.readBits(1);
                            bitReaderBuffer.readBits(1);
                            int readBits5 = bitReaderBuffer.readBits(2);
                            aVar.f5090h = readBits5;
                            aVar.f5091i = readBits5 == 3 ? 1 : 2;
                            return aVar;
                        }
                        throw new IOException("Unexpected (reserved) sample rate frequency");
                    }
                    throw new IOException("Unexpected (free/bad) bit rate");
                }
                throw new IOException("Expected Layer III");
            }
            throw new IOException("Expected MPEG Version 1 (ISO/IEC 11172-3)");
        }
        throw new IOException("Expected Start Word 0x7ff");
    }

    private a readSamples(DataSource dataSource) throws IOException {
        a aVar = null;
        while (true) {
            long position = dataSource.position();
            a readMP3Header = readMP3Header(dataSource);
            if (readMP3Header == null) {
                return aVar;
            }
            if (aVar == null) {
                aVar = readMP3Header;
            }
            dataSource.position(position);
            ByteBuffer allocate = ByteBuffer.allocate(readMP3Header.a());
            dataSource.read(allocate);
            allocate.rewind();
            this.samples.add(new SampleImpl(allocate));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "soun";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.durations;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public String toString() {
        return "MP3TrackImpl";
    }

    public MP3TrackImpl(DataSource dataSource, String str) throws IOException {
        super(dataSource.toString());
        this.trackMetaData = new TrackMetaData();
        this.dataSource = dataSource;
        this.samples = new LinkedList();
        a readSamples = readSamples(dataSource);
        this.firstHeader = readSamples;
        double d2 = readSamples.f5088f / 1152.0d;
        double size = this.samples.size() / d2;
        LinkedList linkedList = new LinkedList();
        Iterator<Sample> it = this.samples.iterator();
        long j2 = 0;
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                this.avgBitRate = (int) ((j2 * 8) / size);
                this.sampleDescriptionBox = new SampleDescriptionBox();
                AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
                audioSampleEntry.setChannelCount(this.firstHeader.f5091i);
                audioSampleEntry.setSampleRate(this.firstHeader.f5088f);
                audioSampleEntry.setDataReferenceIndex(1);
                audioSampleEntry.setSampleSize(16);
                ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
                ESDescriptor eSDescriptor = new ESDescriptor();
                eSDescriptor.setEsId(0);
                SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
                sLConfigDescriptor.setPredefined(2);
                eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
                DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
                decoderConfigDescriptor.setObjectTypeIndication(107);
                decoderConfigDescriptor.setStreamType(5);
                decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
                decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
                eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
                eSDescriptorBox.setData(eSDescriptor.serialize());
                audioSampleEntry.addBox(eSDescriptorBox);
                this.sampleDescriptionBox.addBox(audioSampleEntry);
                this.trackMetaData.setCreationTime(new Date());
                this.trackMetaData.setModificationTime(new Date());
                this.trackMetaData.setLanguage(str);
                this.trackMetaData.setVolume(1.0f);
                this.trackMetaData.setTimescale(this.firstHeader.f5088f);
                long[] jArr = new long[this.samples.size()];
                this.durations = jArr;
                Arrays.fill(jArr, 1152L);
                return;
            }
            int size2 = (int) it.next().getSize();
            j2 += size2;
            linkedList.add(Integer.valueOf(size2));
            while (linkedList.size() > d2) {
                linkedList.pop();
            }
            if (linkedList.size() == ((int) d2)) {
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    i2 += ((Integer) it2.next()).intValue();
                }
                double size3 = ((i2 * 8.0d) / linkedList.size()) * d2;
                if (size3 > this.maxBitRate) {
                    this.maxBitRate = (int) size3;
                }
            }
        }
    }
}
