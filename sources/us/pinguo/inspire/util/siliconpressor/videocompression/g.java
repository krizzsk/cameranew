package us.pinguo.inspire.util.siliconpressor.videocompression;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.coremedia.iso.boxes.AbstractMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.DecoderConfigDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.SLConfigDescriptor;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import us.pinguo.paylibcenter.bean.PayResult;
/* compiled from: Track.java */
@TargetApi(16)
/* loaded from: classes9.dex */
public class g {
    private static Map<Integer, Integer> q;
    private long a;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private String f11290d;

    /* renamed from: e  reason: collision with root package name */
    private AbstractMediaHeaderBox f11291e;

    /* renamed from: f  reason: collision with root package name */
    private SampleDescriptionBox f11292f;

    /* renamed from: g  reason: collision with root package name */
    private LinkedList<Integer> f11293g;

    /* renamed from: h  reason: collision with root package name */
    private int f11294h;

    /* renamed from: j  reason: collision with root package name */
    private int f11296j;

    /* renamed from: k  reason: collision with root package name */
    private int f11297k;

    /* renamed from: l  reason: collision with root package name */
    private float f11298l;
    private ArrayList<Long> m;
    private boolean n;
    private long o;
    private boolean p;
    private ArrayList<e> b = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private Date f11295i = new Date();

    static {
        HashMap hashMap = new HashMap();
        q = hashMap;
        hashMap.put(96000, 0);
        q.put(88200, 1);
        q.put(64000, 2);
        q.put(48000, 3);
        q.put(44100, 4);
        q.put(32000, 5);
        q.put(24000, 6);
        q.put(22050, 7);
        q.put(16000, 8);
        q.put(12000, 9);
        q.put(11025, 10);
        q.put(Integer.valueOf((int) PayResult.PAY_RESULT_ALIPAY_CHECK_IN), 11);
    }

    public g(int i2, MediaFormat mediaFormat, boolean z) throws Exception {
        this.a = 0L;
        this.c = 0L;
        this.f11291e = null;
        this.f11292f = null;
        this.f11293g = null;
        this.f11298l = 0.0f;
        ArrayList<Long> arrayList = new ArrayList<>();
        this.m = arrayList;
        this.n = false;
        this.o = 0L;
        this.p = true;
        this.a = i2;
        if (!z) {
            arrayList.add(3015L);
            this.c = 3015L;
            this.f11297k = mediaFormat.getInteger("width");
            this.f11296j = mediaFormat.getInteger("height");
            this.f11294h = 90000;
            this.f11293g = new LinkedList<>();
            this.f11290d = "vide";
            this.f11291e = new VideoMediaHeaderBox();
            this.f11292f = new SampleDescriptionBox();
            String string = mediaFormat.getString(IMediaFormat.KEY_MIME);
            if (string.equals("video/avc")) {
                VisualSampleEntry visualSampleEntry = new VisualSampleEntry(VisualSampleEntry.TYPE3);
                visualSampleEntry.setDataReferenceIndex(1);
                visualSampleEntry.setDepth(24);
                visualSampleEntry.setFrameCount(1);
                visualSampleEntry.setHorizresolution(72.0d);
                visualSampleEntry.setVertresolution(72.0d);
                visualSampleEntry.setWidth(this.f11297k);
                visualSampleEntry.setHeight(this.f11296j);
                AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
                if (mediaFormat.getByteBuffer("csd-0") != null) {
                    ArrayList arrayList2 = new ArrayList();
                    ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
                    byteBuffer.position(4);
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    arrayList2.add(bArr);
                    ArrayList arrayList3 = new ArrayList();
                    ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
                    byteBuffer2.position(4);
                    byte[] bArr2 = new byte[byteBuffer2.remaining()];
                    byteBuffer2.get(bArr2);
                    arrayList3.add(bArr2);
                    avcConfigurationBox.setSequenceParameterSets(arrayList2);
                    avcConfigurationBox.setPictureParameterSets(arrayList3);
                }
                avcConfigurationBox.setAvcLevelIndication(13);
                avcConfigurationBox.setAvcProfileIndication(100);
                avcConfigurationBox.setBitDepthLumaMinus8(-1);
                avcConfigurationBox.setBitDepthChromaMinus8(-1);
                avcConfigurationBox.setChromaFormat(-1);
                avcConfigurationBox.setConfigurationVersion(1);
                avcConfigurationBox.setLengthSizeMinusOne(3);
                avcConfigurationBox.setProfileCompatibility(0);
                visualSampleEntry.addBox(avcConfigurationBox);
                this.f11292f.addBox(visualSampleEntry);
                return;
            } else if (string.equals("video/mp4v")) {
                VisualSampleEntry visualSampleEntry2 = new VisualSampleEntry(VisualSampleEntry.TYPE1);
                visualSampleEntry2.setDataReferenceIndex(1);
                visualSampleEntry2.setDepth(24);
                visualSampleEntry2.setFrameCount(1);
                visualSampleEntry2.setHorizresolution(72.0d);
                visualSampleEntry2.setVertresolution(72.0d);
                visualSampleEntry2.setWidth(this.f11297k);
                visualSampleEntry2.setHeight(this.f11296j);
                this.f11292f.addBox(visualSampleEntry2);
                return;
            } else {
                return;
            }
        }
        arrayList.add(1024L);
        this.c = 1024L;
        this.f11298l = 1.0f;
        this.f11294h = mediaFormat.getInteger("sample-rate");
        this.f11290d = "soun";
        this.f11291e = new SoundMediaHeaderBox();
        this.f11292f = new SampleDescriptionBox();
        AudioSampleEntry audioSampleEntry = new AudioSampleEntry(AudioSampleEntry.TYPE3);
        audioSampleEntry.setChannelCount(mediaFormat.getInteger("channel-count"));
        audioSampleEntry.setSampleRate(mediaFormat.getInteger("sample-rate"));
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
        decoderConfigDescriptor.setBufferSizeDB(1536);
        decoderConfigDescriptor.setMaxBitRate(96000L);
        decoderConfigDescriptor.setAvgBitRate(96000L);
        AudioSpecificConfig audioSpecificConfig = new AudioSpecificConfig();
        audioSpecificConfig.setAudioObjectType(2);
        audioSpecificConfig.setSamplingFrequencyIndex(q.get(Integer.valueOf((int) audioSampleEntry.getSampleRate())).intValue());
        audioSpecificConfig.setChannelConfiguration(audioSampleEntry.getChannelCount());
        decoderConfigDescriptor.setAudioSpecificInfo(audioSpecificConfig);
        eSDescriptor.setDecoderConfigDescriptor(decoderConfigDescriptor);
        ByteBuffer serialize = eSDescriptor.serialize();
        eSDescriptorBox.setEsDescriptor(eSDescriptor);
        eSDescriptorBox.setData(serialize);
        audioSampleEntry.addBox(eSDescriptorBox);
        this.f11292f.addBox(audioSampleEntry);
    }

    public void a(long j2, MediaCodec.BufferInfo bufferInfo) {
        boolean z = (this.n || (bufferInfo.flags & 1) == 0) ? false : true;
        this.b.add(new e(j2, bufferInfo.size));
        LinkedList<Integer> linkedList = this.f11293g;
        if (linkedList != null && z) {
            linkedList.add(Integer.valueOf(this.b.size()));
        }
        long j3 = bufferInfo.presentationTimeUs;
        this.o = j3;
        long j4 = (((j3 - this.o) * this.f11294h) + 500000) / 1000000;
        if (!this.p) {
            ArrayList<Long> arrayList = this.m;
            arrayList.add(arrayList.size() - 1, Long.valueOf(j4));
            this.c += j4;
        }
        this.p = false;
    }

    public Date b() {
        return this.f11295i;
    }

    public long c() {
        return this.c;
    }

    public String d() {
        return this.f11290d;
    }

    public int e() {
        return this.f11296j;
    }

    public AbstractMediaHeaderBox f() {
        return this.f11291e;
    }

    public SampleDescriptionBox g() {
        return this.f11292f;
    }

    public ArrayList<Long> h() {
        return this.m;
    }

    public ArrayList<e> i() {
        return this.b;
    }

    public long[] j() {
        LinkedList<Integer> linkedList = this.f11293g;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        long[] jArr = new long[this.f11293g.size()];
        for (int i2 = 0; i2 < this.f11293g.size(); i2++) {
            jArr[i2] = this.f11293g.get(i2).intValue();
        }
        return jArr;
    }

    public int k() {
        return this.f11294h;
    }

    public long l() {
        return this.a;
    }

    public float m() {
        return this.f11298l;
    }

    public int n() {
        return this.f11297k;
    }

    public boolean o() {
        return this.n;
    }
}
