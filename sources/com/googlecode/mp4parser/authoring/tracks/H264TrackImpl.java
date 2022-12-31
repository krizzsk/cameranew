package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.tracks.AbstractH26XTrack;
import com.googlecode.mp4parser.h264.model.HRDParameters;
import com.googlecode.mp4parser.h264.model.PictureParameterSet;
import com.googlecode.mp4parser.h264.model.SeqParameterSet;
import com.googlecode.mp4parser.h264.model.VUIParameters;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.util.RangeStartMap;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public class H264TrackImpl extends AbstractH26XTrack {
    private static final Logger LOG = Logger.getLogger(H264TrackImpl.class.getName());
    PictureParameterSet currentPictureParameterSet;
    SeqParameterSet currentSeqParameterSet;
    private boolean determineFrameRate;
    PictureParameterSet firstPictureParameterSet;
    SeqParameterSet firstSeqParameterSet;
    int frameNrInGop;
    private int frametick;
    private int height;
    private String lang;
    RangeStartMap<Integer, byte[]> pictureParameterRangeMap;
    Map<Integer, PictureParameterSet> ppsIdToPps;
    Map<Integer, byte[]> ppsIdToPpsBytes;
    SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    private SEIMessage seiMessage;
    RangeStartMap<Integer, byte[]> seqParameterRangeMap;
    Map<Integer, SeqParameterSet> spsIdToSps;
    Map<Integer, byte[]> spsIdToSpsBytes;
    private long timescale;
    private int width;

    /* loaded from: classes2.dex */
    public class SEIMessage {
        boolean clock_timestamp_flag;
        int cnt_dropped_flag;
        int counting_type;
        int cpb_removal_delay;
        int ct_type;
        int discontinuity_flag;
        int dpb_removal_delay;
        int full_timestamp_flag;
        int hours_value;
        int minutes_value;
        int n_frames;
        int nuit_field_based_flag;
        int payloadSize;
        int payloadType;
        int pic_struct;
        boolean removal_delay_flag;
        int seconds_value;
        SeqParameterSet sps;
        int time_offset;
        int time_offset_length;

        public SEIMessage(InputStream inputStream, SeqParameterSet seqParameterSet) throws IOException {
            int i2;
            boolean z = false;
            this.payloadType = 0;
            this.payloadSize = 0;
            this.sps = seqParameterSet;
            inputStream.read();
            int available = inputStream.available();
            int i3 = 0;
            while (i3 < available) {
                this.payloadType = z ? 1 : 0;
                this.payloadSize = z ? 1 : 0;
                int read = inputStream.read();
                int i4 = i3 + 1;
                while (read == 255) {
                    this.payloadType += read;
                    read = inputStream.read();
                    i4++;
                    z = false;
                }
                this.payloadType += read;
                int read2 = inputStream.read();
                i3 = i4 + 1;
                while (read2 == 255) {
                    this.payloadSize += read2;
                    read2 = inputStream.read();
                    i3++;
                    z = false;
                }
                int i5 = this.payloadSize + read2;
                this.payloadSize = i5;
                if (available - i3 < i5) {
                    i3 = available;
                } else if (this.payloadType == 1) {
                    VUIParameters vUIParameters = seqParameterSet.vuiParams;
                    if (vUIParameters != null && (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null || vUIParameters.pic_struct_present_flag)) {
                        byte[] bArr = new byte[i5];
                        inputStream.read(bArr);
                        i3 += this.payloadSize;
                        CAVLCReader cAVLCReader = new CAVLCReader(new ByteArrayInputStream(bArr));
                        VUIParameters vUIParameters2 = seqParameterSet.vuiParams;
                        HRDParameters hRDParameters = vUIParameters2.nalHRDParams;
                        if (hRDParameters == null && vUIParameters2.vclHRDParams == null) {
                            this.removal_delay_flag = z;
                        } else {
                            this.removal_delay_flag = true;
                            this.cpb_removal_delay = cAVLCReader.readU(hRDParameters.cpb_removal_delay_length_minus1 + 1, "SEI: cpb_removal_delay");
                            this.dpb_removal_delay = cAVLCReader.readU(seqParameterSet.vuiParams.nalHRDParams.dpb_output_delay_length_minus1 + 1, "SEI: dpb_removal_delay");
                        }
                        if (seqParameterSet.vuiParams.pic_struct_present_flag) {
                            int readU = cAVLCReader.readU(4, "SEI: pic_struct");
                            this.pic_struct = readU;
                            switch (readU) {
                                case 3:
                                case 4:
                                case 7:
                                    i2 = 2;
                                    break;
                                case 5:
                                case 6:
                                case 8:
                                    i2 = 3;
                                    break;
                                default:
                                    i2 = 1;
                                    break;
                            }
                            for (int i6 = 0; i6 < i2; i6++) {
                                boolean readBool = cAVLCReader.readBool("pic_timing SEI: clock_timestamp_flag[" + i6 + "]");
                                this.clock_timestamp_flag = readBool;
                                if (readBool) {
                                    this.ct_type = cAVLCReader.readU(2, "pic_timing SEI: ct_type");
                                    this.nuit_field_based_flag = cAVLCReader.readU(1, "pic_timing SEI: nuit_field_based_flag");
                                    this.counting_type = cAVLCReader.readU(5, "pic_timing SEI: counting_type");
                                    this.full_timestamp_flag = cAVLCReader.readU(1, "pic_timing SEI: full_timestamp_flag");
                                    this.discontinuity_flag = cAVLCReader.readU(1, "pic_timing SEI: discontinuity_flag");
                                    this.cnt_dropped_flag = cAVLCReader.readU(1, "pic_timing SEI: cnt_dropped_flag");
                                    this.n_frames = cAVLCReader.readU(8, "pic_timing SEI: n_frames");
                                    if (this.full_timestamp_flag == 1) {
                                        this.seconds_value = cAVLCReader.readU(6, "pic_timing SEI: seconds_value");
                                        this.minutes_value = cAVLCReader.readU(6, "pic_timing SEI: minutes_value");
                                        this.hours_value = cAVLCReader.readU(5, "pic_timing SEI: hours_value");
                                    } else if (cAVLCReader.readBool("pic_timing SEI: seconds_flag")) {
                                        this.seconds_value = cAVLCReader.readU(6, "pic_timing SEI: seconds_value");
                                        if (cAVLCReader.readBool("pic_timing SEI: minutes_flag")) {
                                            this.minutes_value = cAVLCReader.readU(6, "pic_timing SEI: minutes_value");
                                            if (cAVLCReader.readBool("pic_timing SEI: hours_flag")) {
                                                this.hours_value = cAVLCReader.readU(5, "pic_timing SEI: hours_value");
                                            }
                                        }
                                    }
                                    VUIParameters vUIParameters3 = seqParameterSet.vuiParams;
                                    HRDParameters hRDParameters2 = vUIParameters3.nalHRDParams;
                                    if (hRDParameters2 != null) {
                                        this.time_offset_length = hRDParameters2.time_offset_length;
                                    } else {
                                        HRDParameters hRDParameters3 = vUIParameters3.vclHRDParams;
                                        if (hRDParameters3 != null) {
                                            this.time_offset_length = hRDParameters3.time_offset_length;
                                        } else {
                                            this.time_offset_length = 24;
                                        }
                                    }
                                    this.time_offset = cAVLCReader.readU(24, "pic_timing SEI: time_offset");
                                }
                            }
                        }
                    } else {
                        for (int i7 = 0; i7 < this.payloadSize; i7++) {
                            inputStream.read();
                            i3++;
                        }
                    }
                } else {
                    for (int i8 = 0; i8 < this.payloadSize; i8++) {
                        inputStream.read();
                        i3++;
                    }
                }
                H264TrackImpl.LOG.fine(toString());
                z = false;
            }
        }

        public String toString() {
            String str = "SEIMessage{payloadType=" + this.payloadType + ", payloadSize=" + this.payloadSize;
            if (this.payloadType == 1) {
                VUIParameters vUIParameters = this.sps.vuiParams;
                if (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null) {
                    str = String.valueOf(str) + ", cpb_removal_delay=" + this.cpb_removal_delay + ", dpb_removal_delay=" + this.dpb_removal_delay;
                }
                if (this.sps.vuiParams.pic_struct_present_flag) {
                    str = String.valueOf(str) + ", pic_struct=" + this.pic_struct;
                    if (this.clock_timestamp_flag) {
                        str = String.valueOf(str) + ", ct_type=" + this.ct_type + ", nuit_field_based_flag=" + this.nuit_field_based_flag + ", counting_type=" + this.counting_type + ", full_timestamp_flag=" + this.full_timestamp_flag + ", discontinuity_flag=" + this.discontinuity_flag + ", cnt_dropped_flag=" + this.cnt_dropped_flag + ", n_frames=" + this.n_frames + ", seconds_value=" + this.seconds_value + ", minutes_value=" + this.minutes_value + ", hours_value=" + this.hours_value + ", time_offset_length=" + this.time_offset_length + ", time_offset=" + this.time_offset;
                    }
                }
            }
            return String.valueOf(str) + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class SliceHeader {
        public boolean bottom_field_flag;
        public int colour_plane_id;
        public int delta_pic_order_cnt_0;
        public int delta_pic_order_cnt_1;
        public int delta_pic_order_cnt_bottom;
        public boolean field_pic_flag;
        public int first_mb_in_slice;
        public int frame_num;
        public int idr_pic_id;
        public int pic_order_cnt_lsb;
        public int pic_parameter_set_id;
        public SliceType slice_type;

        /* loaded from: classes2.dex */
        public enum SliceType {
            P,
            B,
            I,
            SP,
            SI;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static SliceType[] valuesCustom() {
                SliceType[] valuesCustom = values();
                int length = valuesCustom.length;
                SliceType[] sliceTypeArr = new SliceType[length];
                System.arraycopy(valuesCustom, 0, sliceTypeArr, 0, length);
                return sliceTypeArr;
            }
        }

        public SliceHeader(InputStream inputStream, Map<Integer, SeqParameterSet> map, Map<Integer, PictureParameterSet> map2, boolean z) {
            this.field_pic_flag = false;
            this.bottom_field_flag = false;
            try {
                inputStream.read();
                CAVLCReader cAVLCReader = new CAVLCReader(inputStream);
                this.first_mb_in_slice = cAVLCReader.readUE("SliceHeader: first_mb_in_slice");
                switch (cAVLCReader.readUE("SliceHeader: slice_type")) {
                    case 0:
                    case 5:
                        this.slice_type = SliceType.P;
                        break;
                    case 1:
                    case 6:
                        this.slice_type = SliceType.B;
                        break;
                    case 2:
                    case 7:
                        this.slice_type = SliceType.I;
                        break;
                    case 3:
                    case 8:
                        this.slice_type = SliceType.SP;
                        break;
                    case 4:
                    case 9:
                        this.slice_type = SliceType.SI;
                        break;
                }
                int readUE = cAVLCReader.readUE("SliceHeader: pic_parameter_set_id");
                this.pic_parameter_set_id = readUE;
                PictureParameterSet pictureParameterSet = map2.get(Integer.valueOf(readUE));
                SeqParameterSet seqParameterSet = map.get(Integer.valueOf(pictureParameterSet.seq_parameter_set_id));
                if (seqParameterSet.residual_color_transform_flag) {
                    this.colour_plane_id = cAVLCReader.readU(2, "SliceHeader: colour_plane_id");
                }
                this.frame_num = cAVLCReader.readU(seqParameterSet.log2_max_frame_num_minus4 + 4, "SliceHeader: frame_num");
                if (!seqParameterSet.frame_mbs_only_flag) {
                    boolean readBool = cAVLCReader.readBool("SliceHeader: field_pic_flag");
                    this.field_pic_flag = readBool;
                    if (readBool) {
                        this.bottom_field_flag = cAVLCReader.readBool("SliceHeader: bottom_field_flag");
                    }
                }
                if (z) {
                    this.idr_pic_id = cAVLCReader.readUE("SliceHeader: idr_pic_id");
                }
                if (seqParameterSet.pic_order_cnt_type == 0) {
                    this.pic_order_cnt_lsb = cAVLCReader.readU(seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 + 4, "SliceHeader: pic_order_cnt_lsb");
                    if (pictureParameterSet.bottom_field_pic_order_in_frame_present_flag && !this.field_pic_flag) {
                        this.delta_pic_order_cnt_bottom = cAVLCReader.readSE("SliceHeader: delta_pic_order_cnt_bottom");
                    }
                }
                if (seqParameterSet.pic_order_cnt_type != 1 || seqParameterSet.delta_pic_order_always_zero_flag) {
                    return;
                }
                this.delta_pic_order_cnt_0 = cAVLCReader.readSE("delta_pic_order_cnt_0");
                if (!pictureParameterSet.bottom_field_pic_order_in_frame_present_flag || this.field_pic_flag) {
                    return;
                }
                this.delta_pic_order_cnt_1 = cAVLCReader.readSE("delta_pic_order_cnt_1");
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        public String toString() {
            return "SliceHeader{first_mb_in_slice=" + this.first_mb_in_slice + ", slice_type=" + this.slice_type + ", pic_parameter_set_id=" + this.pic_parameter_set_id + ", colour_plane_id=" + this.colour_plane_id + ", frame_num=" + this.frame_num + ", field_pic_flag=" + this.field_pic_flag + ", bottom_field_flag=" + this.bottom_field_flag + ", idr_pic_id=" + this.idr_pic_id + ", pic_order_cnt_lsb=" + this.pic_order_cnt_lsb + ", delta_pic_order_cnt_bottom=" + this.delta_pic_order_cnt_bottom + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        int a;
        int b;
        boolean c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5075d;

        /* renamed from: e  reason: collision with root package name */
        int f5076e;

        /* renamed from: f  reason: collision with root package name */
        int f5077f;

        /* renamed from: g  reason: collision with root package name */
        int f5078g;

        /* renamed from: h  reason: collision with root package name */
        int f5079h;

        /* renamed from: i  reason: collision with root package name */
        int f5080i;

        /* renamed from: j  reason: collision with root package name */
        int f5081j;

        /* renamed from: k  reason: collision with root package name */
        boolean f5082k;

        /* renamed from: l  reason: collision with root package name */
        int f5083l;

        public a(H264TrackImpl h264TrackImpl, ByteBuffer byteBuffer, int i2, int i3) {
            SliceHeader sliceHeader = new SliceHeader(AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(byteBuffer)), h264TrackImpl.spsIdToSps, h264TrackImpl.ppsIdToPps, i3 == 5);
            this.a = sliceHeader.frame_num;
            int i4 = sliceHeader.pic_parameter_set_id;
            this.b = i4;
            this.c = sliceHeader.field_pic_flag;
            this.f5075d = sliceHeader.bottom_field_flag;
            this.f5076e = i2;
            this.f5077f = h264TrackImpl.spsIdToSps.get(Integer.valueOf(h264TrackImpl.ppsIdToPps.get(Integer.valueOf(i4)).seq_parameter_set_id)).pic_order_cnt_type;
            this.f5078g = sliceHeader.delta_pic_order_cnt_bottom;
            this.f5079h = sliceHeader.pic_order_cnt_lsb;
            this.f5080i = sliceHeader.delta_pic_order_cnt_0;
            this.f5081j = sliceHeader.delta_pic_order_cnt_1;
            this.f5083l = sliceHeader.idr_pic_id;
        }

        boolean a(a aVar) {
            boolean z;
            boolean z2;
            boolean z3;
            if (aVar.a == this.a && aVar.b == this.b && (z = aVar.c) == this.c) {
                if ((!z || aVar.f5075d == this.f5075d) && aVar.f5076e == this.f5076e) {
                    int i2 = aVar.f5077f;
                    if (i2 == 0 && this.f5077f == 0 && (aVar.f5079h != this.f5079h || aVar.f5078g != this.f5078g)) {
                        return true;
                    }
                    if (!(i2 == 1 && this.f5077f == 1 && (aVar.f5080i != this.f5080i || aVar.f5081j != this.f5081j)) && (z2 = aVar.f5082k) == (z3 = this.f5082k)) {
                        return z2 && z3 && aVar.f5083l != this.f5083l;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    public H264TrackImpl(DataSource dataSource, String str, long j2, int i2) throws IOException {
        super(dataSource);
        this.spsIdToSpsBytes = new HashMap();
        this.spsIdToSps = new HashMap();
        this.ppsIdToPpsBytes = new HashMap();
        this.ppsIdToPps = new HashMap();
        this.firstSeqParameterSet = null;
        this.firstPictureParameterSet = null;
        this.currentSeqParameterSet = null;
        this.currentPictureParameterSet = null;
        this.seqParameterRangeMap = new RangeStartMap<>();
        this.pictureParameterRangeMap = new RangeStartMap<>();
        this.frameNrInGop = 0;
        this.determineFrameRate = true;
        this.lang = "eng";
        this.lang = str;
        this.timescale = j2;
        this.frametick = i2;
        if (j2 > 0 && i2 > 0) {
            this.determineFrameRate = false;
        }
        parse(new AbstractH26XTrack.LookAhead(dataSource));
    }

    private void configureFramerate() {
        if (this.determineFrameRate) {
            VUIParameters vUIParameters = this.firstSeqParameterSet.vuiParams;
            if (vUIParameters != null) {
                long j2 = vUIParameters.time_scale >> 1;
                this.timescale = j2;
                int i2 = vUIParameters.num_units_in_tick;
                this.frametick = i2;
                if (j2 == 0 || i2 == 0) {
                    System.err.println("Warning: vuiParams contain invalid values: time_scale: " + this.timescale + " and frame_tick: " + this.frametick + ". Setting frame rate to 25fps");
                    this.timescale = 90000L;
                    this.frametick = 3600;
                    return;
                }
                return;
            }
            System.err.println("Warning: Can't determine frame rate. Guessing 25 fps");
            this.timescale = 90000L;
            this.frametick = 3600;
        }
    }

    private void createSample(List<ByteBuffer> list) throws IOException {
        int i2 = 0;
        boolean z = false;
        for (ByteBuffer byteBuffer : list) {
            if ((byteBuffer.get(0) & 31) == 5) {
                z = true;
            }
        }
        int i3 = z ? 38 : 22;
        if (new SliceHeader(AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(list.get(list.size() - 1))), this.spsIdToSps, this.ppsIdToPps, z).slice_type == SliceHeader.SliceType.B) {
            i3 += 4;
        }
        Sample createSampleObject = createSampleObject(list);
        list.clear();
        SEIMessage sEIMessage = this.seiMessage;
        if (sEIMessage == null || sEIMessage.n_frames == 0) {
            this.frameNrInGop = 0;
        }
        if (sEIMessage != null && sEIMessage.clock_timestamp_flag) {
            i2 = sEIMessage.n_frames - this.frameNrInGop;
        } else if (sEIMessage != null && sEIMessage.removal_delay_flag) {
            i2 = sEIMessage.dpb_removal_delay / 2;
        }
        this.ctts.add(new CompositionTimeToSample.Entry(1, i2 * this.frametick));
        this.sdtp.add(new SampleDependencyTypeBox.Entry(i3));
        this.frameNrInGop++;
        this.samples.add(createSampleObject);
        if (z) {
            this.stss.add(Integer.valueOf(this.samples.size()));
        }
    }

    private void handlePPS(ByteBuffer byteBuffer) throws IOException {
        ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBuffer);
        byteBufferBackedInputStream.read();
        PictureParameterSet read = PictureParameterSet.read(byteBufferBackedInputStream);
        if (this.firstPictureParameterSet == null) {
            this.firstPictureParameterSet = read;
        }
        this.currentPictureParameterSet = read;
        byte[] array = AbstractH26XTrack.toArray((ByteBuffer) byteBuffer.rewind());
        byte[] bArr = this.ppsIdToPpsBytes.get(Integer.valueOf(read.pic_parameter_set_id));
        if (bArr != null && !Arrays.equals(bArr, array)) {
            throw new RuntimeException("OMG - I got two SPS with same ID but different settings! (AVC3 is the solution)");
        }
        if (bArr == null) {
            this.pictureParameterRangeMap.put((RangeStartMap<Integer, byte[]>) Integer.valueOf(this.samples.size()), (Integer) array);
        }
        this.ppsIdToPpsBytes.put(Integer.valueOf(read.pic_parameter_set_id), array);
        this.ppsIdToPps.put(Integer.valueOf(read.pic_parameter_set_id), read);
    }

    private void handleSPS(ByteBuffer byteBuffer) throws IOException {
        InputStream cleanBuffer = AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(byteBuffer));
        cleanBuffer.read();
        SeqParameterSet read = SeqParameterSet.read(cleanBuffer);
        if (this.firstSeqParameterSet == null) {
            this.firstSeqParameterSet = read;
            configureFramerate();
        }
        this.currentSeqParameterSet = read;
        byte[] array = AbstractH26XTrack.toArray((ByteBuffer) byteBuffer.rewind());
        byte[] bArr = this.spsIdToSpsBytes.get(Integer.valueOf(read.seq_parameter_set_id));
        if (bArr != null && !Arrays.equals(bArr, array)) {
            throw new RuntimeException("OMG - I got two SPS with same ID but different settings!");
        }
        if (bArr != null) {
            this.seqParameterRangeMap.put((RangeStartMap<Integer, byte[]>) Integer.valueOf(this.samples.size()), (Integer) array);
        }
        this.spsIdToSpsBytes.put(Integer.valueOf(read.seq_parameter_set_id), array);
        this.spsIdToSps.put(Integer.valueOf(read.seq_parameter_set_id), read);
    }

    private void parse(AbstractH26XTrack.LookAhead lookAhead) throws IOException {
        this.samples = new LinkedList();
        if (readSamples(lookAhead)) {
            if (readVariables()) {
                this.sampleDescriptionBox = new SampleDescriptionBox();
                VisualSampleEntry visualSampleEntry = new VisualSampleEntry(VisualSampleEntry.TYPE3);
                visualSampleEntry.setDataReferenceIndex(1);
                visualSampleEntry.setDepth(24);
                visualSampleEntry.setFrameCount(1);
                visualSampleEntry.setHorizresolution(72.0d);
                visualSampleEntry.setVertresolution(72.0d);
                visualSampleEntry.setWidth(this.width);
                visualSampleEntry.setHeight(this.height);
                visualSampleEntry.setCompressorname("AVC Coding");
                AvcConfigurationBox avcConfigurationBox = new AvcConfigurationBox();
                avcConfigurationBox.setSequenceParameterSets(new ArrayList(this.spsIdToSpsBytes.values()));
                avcConfigurationBox.setPictureParameterSets(new ArrayList(this.ppsIdToPpsBytes.values()));
                avcConfigurationBox.setAvcLevelIndication(this.firstSeqParameterSet.level_idc);
                avcConfigurationBox.setAvcProfileIndication(this.firstSeqParameterSet.profile_idc);
                avcConfigurationBox.setBitDepthLumaMinus8(this.firstSeqParameterSet.bit_depth_luma_minus8);
                avcConfigurationBox.setBitDepthChromaMinus8(this.firstSeqParameterSet.bit_depth_chroma_minus8);
                avcConfigurationBox.setChromaFormat(this.firstSeqParameterSet.chroma_format_idc.getId());
                avcConfigurationBox.setConfigurationVersion(1);
                avcConfigurationBox.setLengthSizeMinusOne(3);
                SeqParameterSet seqParameterSet = this.firstSeqParameterSet;
                avcConfigurationBox.setProfileCompatibility((seqParameterSet.constraint_set_0_flag ? 128 : 0) + (seqParameterSet.constraint_set_1_flag ? 64 : 0) + (seqParameterSet.constraint_set_2_flag ? 32 : 0) + (seqParameterSet.constraint_set_3_flag ? 16 : 0) + (seqParameterSet.constraint_set_4_flag ? 8 : 0) + ((int) (seqParameterSet.reserved_zero_2bits & 3)));
                visualSampleEntry.addBox(avcConfigurationBox);
                this.sampleDescriptionBox.addBox(visualSampleEntry);
                this.trackMetaData.setCreationTime(new Date());
                this.trackMetaData.setModificationTime(new Date());
                this.trackMetaData.setLanguage(this.lang);
                this.trackMetaData.setTimescale(this.timescale);
                this.trackMetaData.setWidth(this.width);
                this.trackMetaData.setHeight(this.height);
                return;
            }
            throw new IOException();
        }
        throw new IOException();
    }

    private boolean readSamples(AbstractH26XTrack.LookAhead lookAhead) throws IOException {
        ArrayList arrayList = new ArrayList();
        a aVar = null;
        while (true) {
            ByteBuffer findNextNal = findNextNal(lookAhead);
            if (findNextNal != null) {
                byte b = findNextNal.get(0);
                int i2 = (b >> 5) & 3;
                int i3 = b & 31;
                switch (i3) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        a aVar2 = new a(this, findNextNal, i2, i3);
                        if (aVar != null) {
                            if (aVar.a(aVar2)) {
                                createSample(arrayList);
                            }
                            arrayList.add((ByteBuffer) findNextNal.rewind());
                            break;
                        }
                        aVar = aVar2;
                        arrayList.add((ByteBuffer) findNextNal.rewind());
                    case 6:
                        if (aVar != null) {
                            createSample(arrayList);
                            aVar = null;
                        }
                        this.seiMessage = new SEIMessage(AbstractH26XTrack.cleanBuffer(new ByteBufferBackedInputStream(findNextNal)), this.currentSeqParameterSet);
                        arrayList.add(findNextNal);
                        break;
                    case 7:
                        if (aVar != null) {
                            createSample(arrayList);
                            aVar = null;
                        }
                        handleSPS((ByteBuffer) findNextNal.rewind());
                        break;
                    case 8:
                        if (aVar != null) {
                            createSample(arrayList);
                            aVar = null;
                        }
                        handlePPS((ByteBuffer) findNextNal.rewind());
                        break;
                    case 9:
                        if (aVar != null) {
                            createSample(arrayList);
                            aVar = null;
                        }
                        arrayList.add(findNextNal);
                        break;
                    case 10:
                    case 11:
                        break;
                    case 12:
                    default:
                        System.err.println("Unknown NAL unit type: " + i3);
                        break;
                    case 13:
                        throw new RuntimeException("Sequence parameter set extension is not yet handled. Needs TLC.");
                }
            }
        }
        createSample(arrayList);
        long[] jArr = new long[this.samples.size()];
        this.decodingTimes = jArr;
        Arrays.fill(jArr, this.frametick);
        return true;
    }

    private boolean readVariables() {
        int i2;
        SeqParameterSet seqParameterSet = this.firstSeqParameterSet;
        this.width = (seqParameterSet.pic_width_in_mbs_minus1 + 1) * 16;
        int i3 = seqParameterSet.frame_mbs_only_flag ? 1 : 2;
        this.height = (seqParameterSet.pic_height_in_map_units_minus1 + 1) * 16 * i3;
        if (seqParameterSet.frame_cropping_flag) {
            if ((seqParameterSet.residual_color_transform_flag ? 0 : seqParameterSet.chroma_format_idc.getId()) != 0) {
                i2 = this.firstSeqParameterSet.chroma_format_idc.getSubWidth();
                i3 *= this.firstSeqParameterSet.chroma_format_idc.getSubHeight();
            } else {
                i2 = 1;
            }
            int i4 = this.width;
            SeqParameterSet seqParameterSet2 = this.firstSeqParameterSet;
            this.width = i4 - (i2 * (seqParameterSet2.frame_crop_left_offset + seqParameterSet2.frame_crop_right_offset));
            this.height -= i3 * (seqParameterSet2.frame_crop_top_offset + seqParameterSet2.frame_crop_bottom_offset);
        }
        return true;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    /* loaded from: classes2.dex */
    public class ByteBufferBackedInputStream extends InputStream {
        private final ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer.duplicate();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.buf.hasRemaining()) {
                return this.buf.get() & Draft_75.END_OF_FRAME;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (this.buf.hasRemaining()) {
                int min = Math.min(i3, this.buf.remaining());
                this.buf.get(bArr, i2, min);
                return min;
            }
            return -1;
        }
    }

    public H264TrackImpl(DataSource dataSource, String str) throws IOException {
        this(dataSource, str, -1L, -1);
    }

    public H264TrackImpl(DataSource dataSource) throws IOException {
        this(dataSource, "eng");
    }
}
