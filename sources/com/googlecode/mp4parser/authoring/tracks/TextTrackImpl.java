package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.sampleentry.TextSampleEntry;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.SampleImpl;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class TextTrackImpl extends AbstractTrack {
    SampleDescriptionBox sampleDescriptionBox;
    List<Line> subs;
    TrackMetaData trackMetaData;

    /* loaded from: classes2.dex */
    public static class Line {
        long from;
        String text;
        long to;

        public Line(long j2, long j3, String str) {
            this.from = j2;
            this.to = j3;
            this.text = str;
        }

        public long getFrom() {
            return this.from;
        }

        public String getText() {
            return this.text;
        }

        public long getTo() {
            return this.to;
        }
    }

    public TextTrackImpl() {
        super("subtiles");
        this.trackMetaData = new TrackMetaData();
        this.subs = new LinkedList();
        this.sampleDescriptionBox = new SampleDescriptionBox();
        TextSampleEntry textSampleEntry = new TextSampleEntry(TextSampleEntry.TYPE1);
        textSampleEntry.setDataReferenceIndex(1);
        textSampleEntry.setStyleRecord(new TextSampleEntry.StyleRecord());
        textSampleEntry.setBoxRecord(new TextSampleEntry.BoxRecord());
        this.sampleDescriptionBox.addBox(textSampleEntry);
        FontTableBox fontTableBox = new FontTableBox();
        fontTableBox.setEntries(Collections.singletonList(new FontTableBox.FontRecord(1, "Serif")));
        textSampleEntry.addBox(fontTableBox);
        this.trackMetaData.setCreationTime(new Date());
        this.trackMetaData.setModificationTime(new Date());
        this.trackMetaData.setTimescale(1000L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return null;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "sbtl";
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
        ArrayList<Long> arrayList = new ArrayList();
        long j2 = 0;
        for (Line line : this.subs) {
            long j3 = line.from - j2;
            int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i2 > 0) {
                arrayList.add(Long.valueOf(j3));
            } else if (i2 < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            arrayList.add(Long.valueOf(line.to - line.from));
            j2 = line.to;
        }
        long[] jArr = new long[arrayList.size()];
        int i3 = 0;
        for (Long l2 : arrayList) {
            jArr[i3] = l2.longValue();
            i3++;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        LinkedList linkedList = new LinkedList();
        long j2 = 0;
        for (Line line : this.subs) {
            int i2 = ((line.from - j2) > 0L ? 1 : ((line.from - j2) == 0L ? 0 : -1));
            if (i2 > 0) {
                linkedList.add(new SampleImpl(ByteBuffer.wrap(new byte[2])));
            } else if (i2 < 0) {
                throw new Error("Subtitle display times may not intersect");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(line.text.getBytes("UTF-8").length);
                dataOutputStream.write(line.text.getBytes("UTF-8"));
                dataOutputStream.close();
                linkedList.add(new SampleImpl(ByteBuffer.wrap(byteArrayOutputStream.toByteArray())));
                j2 = line.to;
            } catch (IOException unused) {
                throw new Error("VM is broken. Does not support UTF-8");
            }
        }
        return linkedList;
    }

    public List<Line> getSubs() {
        return this.subs;
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
}
