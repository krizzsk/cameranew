package com.googlecode.mp4parser.authoring.tracks.h265;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.tracks.AbstractH26XTrack;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.util.ByteBufferByteChannel;
import com.mp4parser.iso14496.part15.HevcConfigurationBox;
import com.mp4parser.iso14496.part15.HevcDecoderConfigurationRecord;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* loaded from: classes2.dex */
public class H265TrackImpl extends AbstractH26XTrack implements NalUnitTypes {
    ArrayList<ByteBuffer> pps;
    ArrayList<Sample> samples;
    ArrayList<ByteBuffer> sps;
    SampleDescriptionBox stsd;
    ArrayList<ByteBuffer> vps;

    public H265TrackImpl(DataSource dataSource) throws IOException {
        super(dataSource);
        this.sps = new ArrayList<>();
        this.pps = new ArrayList<>();
        this.vps = new ArrayList<>();
        this.samples = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        AbstractH26XTrack.LookAhead lookAhead = new AbstractH26XTrack.LookAhead(dataSource);
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = {true};
        while (true) {
            ByteBuffer findNextNal = findNextNal(lookAhead);
            if (findNextNal == null) {
                this.stsd = createSampleDescriptionBox();
                this.decodingTimes = new long[this.samples.size()];
                getTrackMetaData().setTimescale(25L);
                Arrays.fill(this.decodingTimes, 1L);
                return;
            }
            NalUnitHeader nalUnitHeader = getNalUnitHeader(findNextNal);
            if (zArr[0]) {
                if (isVcl(nalUnitHeader)) {
                    if ((findNextNal.get(2) & Byte.MIN_VALUE) != 0) {
                        wrapUp(arrayList, zArr, zArr2);
                    }
                } else {
                    switch (nalUnitHeader.nalUnitType) {
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 39:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                            wrapUp(arrayList, zArr, zArr2);
                            break;
                    }
                }
            }
            int i2 = nalUnitHeader.nalUnitType;
            if (i2 != 39) {
                switch (i2) {
                    case 32:
                        findNextNal.position(2);
                        this.vps.add(findNextNal.slice());
                        System.err.println("Stored VPS");
                        break;
                    case 33:
                        findNextNal.position(2);
                        this.sps.add(findNextNal.slice());
                        findNextNal.position(1);
                        new SequenceParameterSetRbsp(Channels.newInputStream(new ByteBufferByteChannel(findNextNal.slice())));
                        System.err.println("Stored SPS");
                        break;
                    case 34:
                        findNextNal.position(2);
                        this.pps.add(findNextNal.slice());
                        System.err.println("Stored PPS");
                        break;
                }
            } else {
                new SEIMessage(new BitReaderBuffer(findNextNal.slice()));
            }
            switch (nalUnitHeader.nalUnitType) {
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                    break;
                default:
                    PrintStream printStream = System.err;
                    printStream.println("Adding " + nalUnitHeader.nalUnitType);
                    arrayList.add(findNextNal);
                    break;
            }
            if (isVcl(nalUnitHeader)) {
                int i3 = nalUnitHeader.nalUnitType;
                if (i3 == 19 || i3 == 20) {
                    zArr2[0] = zArr2[0] & true;
                } else {
                    zArr2[0] = false;
                }
            }
            zArr[0] = zArr[0] | isVcl(nalUnitHeader);
        }
    }

    private SampleDescriptionBox createSampleDescriptionBox() {
        this.stsd = new SampleDescriptionBox();
        VisualSampleEntry visualSampleEntry = new VisualSampleEntry(VisualSampleEntry.TYPE6);
        visualSampleEntry.setDataReferenceIndex(1);
        visualSampleEntry.setDepth(24);
        visualSampleEntry.setFrameCount(1);
        visualSampleEntry.setHorizresolution(72.0d);
        visualSampleEntry.setVertresolution(72.0d);
        visualSampleEntry.setWidth(VideoEdit2Activity.MIN_SCALED_SIZE);
        visualSampleEntry.setHeight(480);
        visualSampleEntry.setCompressorname("HEVC Coding");
        HevcConfigurationBox hevcConfigurationBox = new HevcConfigurationBox();
        HevcDecoderConfigurationRecord.Array array = new HevcDecoderConfigurationRecord.Array();
        array.array_completeness = true;
        array.nal_unit_type = 33;
        array.nalUnits = new ArrayList();
        Iterator<ByteBuffer> it = this.sps.iterator();
        while (it.hasNext()) {
            array.nalUnits.add(AbstractH26XTrack.toArray(it.next()));
        }
        HevcDecoderConfigurationRecord.Array array2 = new HevcDecoderConfigurationRecord.Array();
        array2.array_completeness = true;
        array2.nal_unit_type = 34;
        array2.nalUnits = new ArrayList();
        Iterator<ByteBuffer> it2 = this.pps.iterator();
        while (it2.hasNext()) {
            array2.nalUnits.add(AbstractH26XTrack.toArray(it2.next()));
        }
        HevcDecoderConfigurationRecord.Array array3 = new HevcDecoderConfigurationRecord.Array();
        array3.array_completeness = true;
        array3.nal_unit_type = 34;
        array3.nalUnits = new ArrayList();
        Iterator<ByteBuffer> it3 = this.vps.iterator();
        while (it3.hasNext()) {
            array3.nalUnits.add(AbstractH26XTrack.toArray(it3.next()));
        }
        hevcConfigurationBox.getArrays().addAll(Arrays.asList(array, array3, array2));
        visualSampleEntry.addBox(hevcConfigurationBox);
        this.stsd.addBox(visualSampleEntry);
        return this.stsd;
    }

    public static void main(String[] strArr) throws IOException {
        H265TrackImpl h265TrackImpl = new H265TrackImpl(new FileDataSourceImpl("c:\\content\\test-UHD-HEVC_01_FMV_Med_track1.hvc"));
        Movie movie = new Movie();
        movie.addTrack(h265TrackImpl);
        new DefaultMp4Builder().build(movie).writeContainer(new FileOutputStream("output.mp4").getChannel());
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    public NalUnitHeader getNalUnitHeader(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
        NalUnitHeader nalUnitHeader = new NalUnitHeader();
        nalUnitHeader.forbiddenZeroFlag = (32768 & readUInt16) >> 15;
        nalUnitHeader.nalUnitType = (readUInt16 & 32256) >> 9;
        nalUnitHeader.nuhLayerId = (readUInt16 & TypedValues.PositionType.TYPE_PERCENT_HEIGHT) >> 3;
        nalUnitHeader.nuhTemporalIdPlusOne = readUInt16 & 7;
        return nalUnitHeader;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    boolean isVcl(NalUnitHeader nalUnitHeader) {
        int i2 = nalUnitHeader.nalUnitType;
        return i2 >= 0 && i2 <= 31;
    }

    public void wrapUp(List<ByteBuffer> list, boolean[] zArr, boolean[] zArr2) {
        this.samples.add(createSampleObject(list));
        PrintStream printStream = System.err;
        printStream.print("Create AU from " + list.size() + " NALs");
        if (zArr2[0]) {
            System.err.println("  IDR");
        } else {
            System.err.println();
        }
        zArr[0] = false;
        zArr2[0] = true;
        list.clear();
    }
}
