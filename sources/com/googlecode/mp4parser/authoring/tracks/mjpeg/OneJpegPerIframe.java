package com.googlecode.mp4parser.authoring.tracks.mjpeg;

import com.coremedia.iso.Hex;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Edit;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ESDescriptor;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.ObjectDescriptorFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
/* loaded from: classes2.dex */
public class OneJpegPerIframe extends AbstractTrack {
    File[] jpegs;
    long[] sampleDurations;
    SampleDescriptionBox stsd;
    long[] syncSamples;
    TrackMetaData trackMetaData;

    /* loaded from: classes2.dex */
    class a extends AbstractList<Sample> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.googlecode.mp4parser.authoring.tracks.mjpeg.OneJpegPerIframe$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0193a implements Sample {
            ByteBuffer a = null;
            private final /* synthetic */ int c;

            C0193a(int i2) {
                this.c = i2;
            }

            @Override // com.googlecode.mp4parser.authoring.Sample
            public ByteBuffer asByteBuffer() {
                if (this.a == null) {
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(OneJpegPerIframe.this.jpegs[this.c], "r");
                        this.a = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, randomAccessFile.length());
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                return this.a;
            }

            @Override // com.googlecode.mp4parser.authoring.Sample
            public long getSize() {
                return OneJpegPerIframe.this.jpegs[this.c].length();
            }

            @Override // com.googlecode.mp4parser.authoring.Sample
            public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                RandomAccessFile randomAccessFile = new RandomAccessFile(OneJpegPerIframe.this.jpegs[this.c], "r");
                randomAccessFile.getChannel().transferTo(0L, randomAccessFile.length(), writableByteChannel);
                randomAccessFile.close();
            }
        }

        a() {
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: c */
        public Sample get(int i2) {
            return new C0193a(i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return OneJpegPerIframe.this.jpegs.length;
        }
    }

    public OneJpegPerIframe(String str, File[] fileArr, Track track) throws IOException {
        super(str);
        this.trackMetaData = new TrackMetaData();
        this.jpegs = fileArr;
        if (track.getSyncSamples().length == fileArr.length) {
            BufferedImage read = ImageIO.read(fileArr[0]);
            this.trackMetaData.setWidth(read.getWidth());
            this.trackMetaData.setHeight(read.getHeight());
            this.trackMetaData.setTimescale(track.getTrackMetaData().getTimescale());
            long[] sampleDurations = track.getSampleDurations();
            long[] syncSamples = track.getSyncSamples();
            this.sampleDurations = new long[syncSamples.length];
            long j2 = 0;
            boolean z = true;
            long j3 = 0;
            int i2 = 1;
            for (int i3 = 1; i3 < sampleDurations.length; i3++) {
                if (i2 < syncSamples.length && i3 == syncSamples[i2]) {
                    this.sampleDurations[i2 - 1] = j3;
                    i2++;
                    j3 = 0;
                }
                j3 += sampleDurations[i3];
            }
            long[] jArr = this.sampleDurations;
            jArr[jArr.length - 1] = j3;
            this.stsd = new SampleDescriptionBox();
            VisualSampleEntry visualSampleEntry = new VisualSampleEntry(VisualSampleEntry.TYPE1);
            this.stsd.addBox(visualSampleEntry);
            ESDescriptorBox eSDescriptorBox = new ESDescriptorBox();
            eSDescriptorBox.setData(ByteBuffer.wrap(Hex.decodeHex("038080801B000100048080800D6C11000000000A1CB4000A1CB4068080800102")));
            eSDescriptorBox.setEsDescriptor((ESDescriptor) ObjectDescriptorFactory.createFrom(-1, ByteBuffer.wrap(Hex.decodeHex("038080801B000100048080800D6C11000000000A1CB4000A1CB4068080800102"))));
            visualSampleEntry.addBox(eSDescriptorBox);
            this.syncSamples = new long[fileArr.length];
            int i4 = 0;
            while (true) {
                long[] jArr2 = this.syncSamples;
                if (i4 >= jArr2.length) {
                    break;
                }
                int i5 = i4 + 1;
                jArr2[i4] = i5;
                i4 = i5;
            }
            double d2 = 0.0d;
            boolean z2 = true;
            for (Edit edit : track.getEdits()) {
                if (edit.getMediaTime() == -1 && !z) {
                    throw new RuntimeException("Cannot accept edit list for processing (1)");
                }
                if (edit.getMediaTime() >= 0 && !z2) {
                    throw new RuntimeException("Cannot accept edit list for processing (2)");
                }
                if (edit.getMediaTime() == -1) {
                    d2 += edit.getSegmentDuration();
                } else {
                    d2 -= edit.getMediaTime() / edit.getTimeScale();
                    z2 = false;
                    z = false;
                }
            }
            if (track.getCompositionTimeEntries() != null && track.getCompositionTimeEntries().size() > 0) {
                int[] copyOfRange = Arrays.copyOfRange(CompositionTimeToSample.blowupCompositionTimes(track.getCompositionTimeEntries()), 0, 50);
                for (int i6 = 0; i6 < copyOfRange.length; i6++) {
                    copyOfRange[i6] = (int) (copyOfRange[i6] + j2);
                    j2 += track.getSampleDurations()[i6];
                }
                Arrays.sort(copyOfRange);
                d2 += copyOfRange[0] / track.getTrackMetaData().getTimescale();
            }
            if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                getEdits().add(new Edit((long) ((-d2) * getTrackMetaData().getTimescale()), getTrackMetaData().getTimescale(), 1.0d, getDuration() / getTrackMetaData().getTimescale()));
                return;
            } else if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                getEdits().add(new Edit(-1L, getTrackMetaData().getTimescale(), 1.0d, d2));
                getEdits().add(new Edit(0L, getTrackMetaData().getTimescale(), 1.0d, getDuration() / getTrackMetaData().getTimescale()));
                return;
            } else {
                return;
            }
        }
        throw new RuntimeException("Number of sync samples doesn't match the number of stills (" + track.getSyncSamples().length + " vs. " + fileArr.length + ")");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "vide";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        return this.sampleDurations;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return new a();
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        return this.syncSamples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }
}
