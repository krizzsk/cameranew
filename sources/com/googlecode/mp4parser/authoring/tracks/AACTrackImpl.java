package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import us.pinguo.paylibcenter.bean.PayResult;
/* loaded from: classes2.dex */
public class AACTrackImpl extends AbstractTrack {
    static Map<Integer, String> audioObjectTypes;
    public static Map<Integer, Integer> samplingFrequencyIndexMap;
    long avgBitRate;
    int bufferSizeDB;
    private DataSource dataSource;
    long[] decTimes;
    b firstHeader;
    private String lang;
    long maxBitRate;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    TrackMetaData trackMetaData;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Sample {
        private final /* synthetic */ long b;
        private final /* synthetic */ long c;

        a(long j2, long j3) {
            this.b = j2;
            this.c = j3;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            try {
                return AACTrackImpl.this.dataSource.map(this.b, this.c);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.c;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            AACTrackImpl.this.dataSource.transferTo(this.b, this.c, writableByteChannel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {
        int a;
        int b;
        int c;

        /* renamed from: d  reason: collision with root package name */
        int f5067d;

        /* renamed from: e  reason: collision with root package name */
        int f5068e;

        /* renamed from: f  reason: collision with root package name */
        int f5069f;

        b(AACTrackImpl aACTrackImpl) {
        }

        int a() {
            return (this.b == 0 ? 2 : 0) + 7;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        audioObjectTypes = hashMap;
        hashMap.put(1, "AAC Main");
        audioObjectTypes.put(2, "AAC LC (Low Complexity)");
        audioObjectTypes.put(3, "AAC SSR (Scalable Sample Rate)");
        audioObjectTypes.put(4, "AAC LTP (Long Term Prediction)");
        audioObjectTypes.put(5, "SBR (Spectral Band Replication)");
        audioObjectTypes.put(6, "AAC Scalable");
        audioObjectTypes.put(7, "TwinVQ");
        audioObjectTypes.put(8, "CELP (Code Excited Linear Prediction)");
        audioObjectTypes.put(9, "HXVC (Harmonic Vector eXcitation Coding)");
        audioObjectTypes.put(10, "Reserved");
        audioObjectTypes.put(11, "Reserved");
        audioObjectTypes.put(12, "TTSI (Text-To-Speech Interface)");
        audioObjectTypes.put(13, "Main Synthesis");
        audioObjectTypes.put(14, "Wavetable Synthesis");
        audioObjectTypes.put(15, "General MIDI");
        audioObjectTypes.put(16, "Algorithmic Synthesis and Audio Effects");
        audioObjectTypes.put(17, "ER (Error Resilient) AAC LC");
        audioObjectTypes.put(18, "Reserved");
        audioObjectTypes.put(19, "ER AAC LTP");
        audioObjectTypes.put(20, "ER AAC Scalable");
        audioObjectTypes.put(21, "ER TwinVQ");
        audioObjectTypes.put(22, "ER BSAC (Bit-Sliced Arithmetic Coding)");
        audioObjectTypes.put(23, "ER AAC LD (Low Delay)");
        audioObjectTypes.put(24, "ER CELP");
        audioObjectTypes.put(25, "ER HVXC");
        audioObjectTypes.put(26, "ER HILN (Harmonic and Individual Lines plus Noise)");
        audioObjectTypes.put(27, "ER Parametric");
        audioObjectTypes.put(28, "SSC (SinuSoidal Coding)");
        audioObjectTypes.put(29, "PS (Parametric Stereo)");
        audioObjectTypes.put(30, "MPEG Surround");
        audioObjectTypes.put(31, "(Escape value)");
        audioObjectTypes.put(32, "Layer-1");
        audioObjectTypes.put(33, "Layer-2");
        audioObjectTypes.put(34, "Layer-3");
        audioObjectTypes.put(35, "DST (Direct Stream Transfer)");
        audioObjectTypes.put(36, "ALS (Audio Lossless)");
        audioObjectTypes.put(37, "SLS (Scalable LosslesS)");
        audioObjectTypes.put(38, "SLS non-core");
        audioObjectTypes.put(39, "ER AAC ELD (Enhanced Low Delay)");
        audioObjectTypes.put(40, "SMR (Symbolic Music Representation) Simple");
        audioObjectTypes.put(41, "SMR Main");
        audioObjectTypes.put(42, "USAC (Unified Speech and Audio Coding) (no SBR)");
        audioObjectTypes.put(43, "SAOC (Spatial Audio Object Coding)");
        audioObjectTypes.put(44, "LD MPEG Surround");
        audioObjectTypes.put(45, "USAC");
        HashMap hashMap2 = new HashMap();
        samplingFrequencyIndexMap = hashMap2;
        hashMap2.put(96000, 0);
        samplingFrequencyIndexMap.put(88200, 1);
        samplingFrequencyIndexMap.put(64000, 2);
        samplingFrequencyIndexMap.put(48000, 3);
        samplingFrequencyIndexMap.put(44100, 4);
        samplingFrequencyIndexMap.put(32000, 5);
        samplingFrequencyIndexMap.put(24000, 6);
        samplingFrequencyIndexMap.put(22050, 7);
        samplingFrequencyIndexMap.put(16000, 8);
        samplingFrequencyIndexMap.put(12000, 9);
        samplingFrequencyIndexMap.put(11025, 10);
        samplingFrequencyIndexMap.put(Integer.valueOf((int) PayResult.PAY_RESULT_ALIPAY_CHECK_IN), 11);
        samplingFrequencyIndexMap.put(0, 96000);
        samplingFrequencyIndexMap.put(1, 88200);
        samplingFrequencyIndexMap.put(2, 64000);
        samplingFrequencyIndexMap.put(3, 48000);
        samplingFrequencyIndexMap.put(4, 44100);
        samplingFrequencyIndexMap.put(5, 32000);
        samplingFrequencyIndexMap.put(6, 24000);
        samplingFrequencyIndexMap.put(7, 22050);
        samplingFrequencyIndexMap.put(8, 16000);
        samplingFrequencyIndexMap.put(9, 12000);
        samplingFrequencyIndexMap.put(10, 11025);
        samplingFrequencyIndexMap.put(11, Integer.valueOf((int) PayResult.PAY_RESULT_ALIPAY_CHECK_IN));
    }

    public AACTrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
    }

    private b readADTSHeader(DataSource dataSource) throws IOException {
        b bVar = new b(this);
        ByteBuffer allocate = ByteBuffer.allocate(7);
        while (allocate.position() < 7) {
            if (dataSource.read(allocate) == -1) {
                return null;
            }
        }
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer((ByteBuffer) allocate.rewind());
        if (bitReaderBuffer.readBits(12) == 4095) {
            bitReaderBuffer.readBits(1);
            bitReaderBuffer.readBits(2);
            bVar.b = bitReaderBuffer.readBits(1);
            bitReaderBuffer.readBits(2);
            int readBits = bitReaderBuffer.readBits(4);
            bVar.a = readBits;
            bVar.c = samplingFrequencyIndexMap.get(Integer.valueOf(readBits)).intValue();
            bitReaderBuffer.readBits(1);
            bVar.f5067d = bitReaderBuffer.readBits(3);
            bitReaderBuffer.readBits(1);
            bitReaderBuffer.readBits(1);
            bitReaderBuffer.readBits(1);
            bitReaderBuffer.readBits(1);
            bVar.f5068e = bitReaderBuffer.readBits(13);
            bitReaderBuffer.readBits(11);
            int readBits2 = bitReaderBuffer.readBits(2) + 1;
            bVar.f5069f = readBits2;
            if (readBits2 == 1) {
                if (bVar.b == 0) {
                    dataSource.read(ByteBuffer.allocate(2));
                }
                return bVar;
            }
            throw new IOException("This muxer can only work with 1 AAC frame per ADTS frame");
        }
        throw new IOException("Expected Start Word 0xfff");
    }

    private b readSamples(DataSource dataSource) throws IOException {
        b bVar = null;
        while (true) {
            b readADTSHeader = readADTSHeader(dataSource);
            if (readADTSHeader == null) {
                return bVar;
            }
            if (bVar == null) {
                bVar = readADTSHeader;
            }
            this.samples.add(new a(dataSource.position(), readADTSHeader.f5068e - readADTSHeader.a()));
            dataSource.position((dataSource.position() + readADTSHeader.f5068e) - readADTSHeader.a());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "soun";
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.decTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public String toString() {
        return "AACTrackImpl{sampleRate=" + this.firstHeader.c + ", channelconfig=" + this.firstHeader.f5067d + '}';
    }

    public AACTrackImpl(DataSource dataSource, String str) throws IOException {
        super(dataSource.toString());
        this.trackMetaData = new TrackMetaData();
        this.lang = "eng";
        this.lang = str;
        this.dataSource = dataSource;
        this.samples = new ArrayList();
        b readSamples = readSamples(dataSource);
        this.firstHeader = readSamples;
        double d2 = readSamples.c / 1024.0d;
        double size = this.samples.size() / d2;
        LinkedList linkedList = new LinkedList();
        Iterator<Sample> it = this.samples.iterator();
        long j2 = 0;
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                break;
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
        this.avgBitRate = (int) ((j2 * 8) / size);
        this.bufferSizeDB = 1536;
        this.sampleDescriptionBox = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
        int i3 = this.firstHeader.f5067d;
        if (i3 == 7) {
            audioSampleEntry.setChannelCount(8);
        } else {
            audioSampleEntry.setChannelCount(i3);
        }
        audioSampleEntry.setSampleRate(this.firstHeader.c);
        audioSampleEntry.setDataReferenceIndex(1);
        audioSampleEntry.setSampleSize(16);
        ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
        ESDescriptor eSDescriptor = new ESDescriptor();
        eSDescriptor.setEsId(0);
        SLConfigDescriptor sLConfigDescriptor = new SLConfigDescriptor();
        sLConfigDescriptor.setPredefined(2);
        eSDescriptor.setSlConfigDescriptor(sLConfigDescriptor);
        DecoderConfigDescriptor decoderConfigDescriptor = new DecoderConfigDescriptor();
        decoderConfigDescriptor.setObjectTypeIndication(64);
        decoderConfigDescriptor.setStreamType(5);
        decoderConfigDescriptor.setBufferSizeDB(this.bufferSizeDB);
        decoderConfigDescriptor.setMaxBitRate(this.maxBitRate);
        decoderConfigDescriptor.setAvgBitRate(this.avgBitRate);
        AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
        audioSpecificConfig.setAudioObjectType(2);
        audioSpecificConfig.setSamplingFrequencyIndex(this.firstHeader.a);
        audioSpecificConfig.setChannelConfiguration(this.firstHeader.f5067d);
        decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
        eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        ByteBuffer serialize = eSDescriptor.serialize();
        eSDescriptorBox.setEsDescriptor(eSDescriptor);
        eSDescriptorBox.setData(serialize);
        audioSampleEntry.addBox(eSDescriptorBox);
        this.sampleDescriptionBox.addBox(audioSampleEntry);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setLanguage(str);
        this.trackMetaData.setVolume(1.0f);
        this.trackMetaData.setTimescale(this.firstHeader.c);
        long[] jArr = new long[this.samples.size()];
        this.decTimes = jArr;
        Arrays.fill(jArr, 1024L);
    }
}
