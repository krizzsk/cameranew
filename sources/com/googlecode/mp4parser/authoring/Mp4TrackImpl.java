package com.googlecode.mp4parser.authoring;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.SampleList;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class Mp4TrackImpl extends AbstractTrack {
    private List<CompositionTimeToSample.Entry> compositionTimeEntries;
    private long[] decodingTimes;
    IsoFile[] fragments;
    private String handler;
    private List<SampleDependencyTypeBox.Entry> sampleDependencies;
    private SampleDescriptionBox sampleDescriptionBox;
    private List<Sample> samples;
    private SubSampleInformationBox subSampleInformationBox;
    private long[] syncSamples;
    TrackBox trackBox;
    private TrackMetaData trackMetaData;

    public Mp4TrackImpl(String str, TrackBox trackBox, IsoFile... isoFileArr) {
        super(str);
        Iterator it;
        long j2;
        Iterator it2;
        ArrayList arrayList;
        Iterator it3;
        Iterator it4;
        SampleFlags defaultSampleFlags;
        int i2;
        int i3 = 0;
        this.syncSamples = new long[0];
        this.trackMetaData = new TrackMetaData();
        this.subSampleInformationBox = null;
        long trackId = trackBox.getTrackHeaderBox().getTrackId();
        this.samples = new SampleList(trackBox, isoFileArr);
        SampleTableBox sampleTableBox = trackBox.getMediaBox().getMediaInformationBox().getSampleTableBox();
        this.handler = trackBox.getMediaBox().getHandlerBox().getHandlerType();
        ArrayList arrayList2 = new ArrayList();
        this.compositionTimeEntries = new ArrayList();
        this.sampleDependencies = new ArrayList();
        arrayList2.addAll(sampleTableBox.getTimeToSampleBox().getEntries());
        if (sampleTableBox.getCompositionTimeToSample() != null) {
            this.compositionTimeEntries.addAll(sampleTableBox.getCompositionTimeToSample().getEntries());
        }
        if (sampleTableBox.getSampleDependencyTypeBox() != null) {
            this.sampleDependencies.addAll(sampleTableBox.getSampleDependencyTypeBox().getEntries());
        }
        if (sampleTableBox.getSyncSampleBox() != null) {
            this.syncSamples = sampleTableBox.getSyncSampleBox().getSampleNumber();
        }
        String str2 = "subs";
        this.subSampleInformationBox = (SubSampleInformationBox) Path.getPath((AbstractContainerBox) sampleTableBox, "subs");
        ArrayList<MovieFragmentBox> arrayList3 = new ArrayList();
        arrayList3.addAll(((Box) trackBox.getParent()).getParent().getBoxes(MovieFragmentBox.class));
        int length = isoFileArr.length;
        int i4 = 0;
        while (i4 < length) {
            ArrayList arrayList4 = arrayList3;
            arrayList4.addAll(isoFileArr[i4].getBoxes(MovieFragmentBox.class));
            i4++;
            arrayList3 = arrayList4;
            trackId = trackId;
            i3 = 0;
        }
        this.sampleDescriptionBox = sampleTableBox.getSampleDescriptionBox();
        List boxes = trackBox.getParent().getBoxes(MovieExtendsBox.class);
        if (boxes.size() > 0) {
            Iterator it5 = boxes.iterator();
            while (it5.hasNext()) {
                for (TrackExtendsBox trackExtendsBox : ((MovieExtendsBox) it5.next()).getBoxes(TrackExtendsBox.class)) {
                    if (trackExtendsBox.getTrackId() == trackId) {
                        if (Path.getPaths(((Box) trackBox.getParent()).getParent(), "/moof/traf/subs").size() > 0) {
                            this.subSampleInformationBox = new SubSampleInformationBox();
                        }
                        LinkedList<Long> linkedList = new LinkedList();
                        Iterator it6 = arrayList3.iterator();
                        long j3 = 1;
                        while (it6.hasNext()) {
                            Iterator it7 = ((MovieFragmentBox) it6.next()).getBoxes(TrackFragmentBox.class).iterator();
                            while (it7.hasNext()) {
                                TrackFragmentBox trackFragmentBox = (TrackFragmentBox) it7.next();
                                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                                    SubSampleInformationBox subSampleInformationBox = (SubSampleInformationBox) Path.getPath((AbstractContainerBox) trackFragmentBox, str2);
                                    if (subSampleInformationBox != null) {
                                        j2 = trackId;
                                        long j4 = (j3 - i3) - 1;
                                        for (SubSampleInformationBox.SubSampleEntry subSampleEntry : subSampleInformationBox.getEntries()) {
                                            SubSampleInformationBox.SubSampleEntry subSampleEntry2 = new SubSampleInformationBox.SubSampleEntry();
                                            Iterator it8 = it5;
                                            String str3 = str2;
                                            subSampleEntry2.getSubsampleEntries().addAll(subSampleEntry.getSubsampleEntries());
                                            long j5 = 0;
                                            if (j4 != 0) {
                                                subSampleEntry2.setSampleDelta(j4 + subSampleEntry.getSampleDelta());
                                            } else {
                                                j5 = j4;
                                                subSampleEntry2.setSampleDelta(subSampleEntry.getSampleDelta());
                                            }
                                            j4 = j5;
                                            this.subSampleInformationBox.getEntries().add(subSampleEntry2);
                                            it5 = it8;
                                            str2 = str3;
                                        }
                                        it = it5;
                                    } else {
                                        it = it5;
                                        j2 = trackId;
                                    }
                                    String str4 = str2;
                                    Iterator it9 = trackFragmentBox.getBoxes(TrackRunBox.class).iterator();
                                    while (it9.hasNext()) {
                                        TrackRunBox trackRunBox = (TrackRunBox) it9.next();
                                        TrackFragmentHeaderBox trackFragmentHeaderBox = ((TrackFragmentBox) trackRunBox.getParent()).getTrackFragmentHeaderBox();
                                        int i5 = 1;
                                        boolean z = true;
                                        for (TrackRunBox.Entry entry : trackRunBox.getEntries()) {
                                            if (trackRunBox.isSampleDurationPresent()) {
                                                if (arrayList2.size() != 0) {
                                                    it2 = it9;
                                                    if (((TimeToSampleBox.Entry) arrayList2.get(arrayList2.size() - 1)).getDelta() == entry.getSampleDuration()) {
                                                        TimeToSampleBox.Entry entry2 = (TimeToSampleBox.Entry) arrayList2.get(arrayList2.size() - i5);
                                                        arrayList = arrayList3;
                                                        it3 = it6;
                                                        it4 = it7;
                                                        entry2.setCount(entry2.getCount() + 1);
                                                    }
                                                } else {
                                                    it2 = it9;
                                                }
                                                arrayList = arrayList3;
                                                it3 = it6;
                                                it4 = it7;
                                                arrayList2.add(new TimeToSampleBox.Entry(1L, entry.getSampleDuration()));
                                            } else {
                                                it2 = it9;
                                                arrayList = arrayList3;
                                                it3 = it6;
                                                it4 = it7;
                                                if (trackFragmentHeaderBox.hasDefaultSampleDuration()) {
                                                    arrayList2.add(new TimeToSampleBox.Entry(1L, trackFragmentHeaderBox.getDefaultSampleDuration()));
                                                } else {
                                                    arrayList2.add(new TimeToSampleBox.Entry(1L, trackExtendsBox.getDefaultSampleDuration()));
                                                }
                                            }
                                            if (trackRunBox.isSampleCompositionTimeOffsetPresent()) {
                                                if (this.compositionTimeEntries.size() != 0) {
                                                    List<CompositionTimeToSample.Entry> list = this.compositionTimeEntries;
                                                    i2 = 1;
                                                    if (list.get(list.size() - 1).getOffset() == entry.getSampleCompositionTimeOffset()) {
                                                        List<CompositionTimeToSample.Entry> list2 = this.compositionTimeEntries;
                                                        CompositionTimeToSample.Entry entry3 = list2.get(list2.size() - 1);
                                                        entry3.setCount(entry3.getCount() + 1);
                                                    }
                                                } else {
                                                    i2 = 1;
                                                }
                                                this.compositionTimeEntries.add(new CompositionTimeToSample.Entry(i2, CastUtils.l2i(entry.getSampleCompositionTimeOffset())));
                                            }
                                            if (trackRunBox.isSampleFlagsPresent()) {
                                                defaultSampleFlags = entry.getSampleFlags();
                                            } else if (z && trackRunBox.isFirstSampleFlagsPresent()) {
                                                defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                            } else if (trackFragmentHeaderBox.hasDefaultSampleFlags()) {
                                                defaultSampleFlags = trackFragmentHeaderBox.getDefaultSampleFlags();
                                            } else {
                                                defaultSampleFlags = trackExtendsBox.getDefaultSampleFlags();
                                            }
                                            if (defaultSampleFlags != null && !defaultSampleFlags.isSampleIsDifferenceSample()) {
                                                linkedList.add(Long.valueOf(j3));
                                            }
                                            j3++;
                                            arrayList3 = arrayList;
                                            it9 = it2;
                                            it6 = it3;
                                            it7 = it4;
                                            i5 = 1;
                                            z = false;
                                        }
                                    }
                                    it5 = it;
                                    trackId = j2;
                                    str2 = str4;
                                    i3 = 0;
                                }
                            }
                        }
                        long[] jArr = this.syncSamples;
                        long[] jArr2 = new long[jArr.length + linkedList.size()];
                        this.syncSamples = jArr2;
                        System.arraycopy(jArr, i3, jArr2, i3, jArr.length);
                        int length2 = jArr.length;
                        for (Long l2 : linkedList) {
                            this.syncSamples[length2] = l2.longValue();
                            length2++;
                        }
                    }
                }
            }
            new ArrayList();
            new ArrayList();
            for (MovieFragmentBox movieFragmentBox : arrayList3) {
                for (TrackFragmentBox trackFragmentBox2 : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == trackId) {
                        this.sampleGroups = getSampleGroups(Path.getPaths((Container) trackFragmentBox2, SampleGroupDescriptionBox.TYPE), Path.getPaths((Container) trackFragmentBox2, SampleToGroupBox.TYPE), this.sampleGroups);
                    }
                }
            }
        } else {
            this.sampleGroups = getSampleGroups(sampleTableBox.getBoxes(SampleGroupDescriptionBox.class), sampleTableBox.getBoxes(SampleToGroupBox.class), this.sampleGroups);
        }
        this.decodingTimes = TimeToSampleBox.blowupTimeToSamples(arrayList2);
        MediaHeaderBox mediaHeaderBox = trackBox.getMediaBox().getMediaHeaderBox();
        TrackHeaderBox trackHeaderBox = trackBox.getTrackHeaderBox();
        this.trackMetaData.setTrackId(trackHeaderBox.getTrackId());
        this.trackMetaData.setCreationTime(mediaHeaderBox.getCreationTime());
        this.trackMetaData.setLanguage(mediaHeaderBox.getLanguage());
        this.trackMetaData.setModificationTime(mediaHeaderBox.getModificationTime());
        this.trackMetaData.setTimescale(mediaHeaderBox.getTimescale());
        this.trackMetaData.setHeight(trackHeaderBox.getHeight());
        this.trackMetaData.setWidth(trackHeaderBox.getWidth());
        this.trackMetaData.setLayer(trackHeaderBox.getLayer());
        this.trackMetaData.setMatrix(trackHeaderBox.getMatrix());
        EditListBox editListBox = (EditListBox) Path.getPath((AbstractContainerBox) trackBox, "edts/elst");
        MovieHeaderBox movieHeaderBox = (MovieHeaderBox) Path.getPath((AbstractContainerBox) trackBox, "../mvhd");
        if (editListBox != null) {
            for (Iterator<EditListBox.Entry> it10 = editListBox.getEntries().iterator(); it10.hasNext(); it10 = it10) {
                EditListBox.Entry next = it10.next();
                this.edits.add(new Edit(next.getMediaTime(), mediaHeaderBox.getTimescale(), next.getMediaRate(), next.getSegmentDuration() / movieHeaderBox.getTimescale()));
                mediaHeaderBox = mediaHeaderBox;
            }
        }
    }

    private Map<GroupEntry, long[]> getSampleGroups(List<SampleGroupDescriptionBox> list, List<SampleToGroupBox> list2, Map<GroupEntry, long[]> map) {
        for (SampleGroupDescriptionBox sampleGroupDescriptionBox : list) {
            boolean z = false;
            for (SampleToGroupBox sampleToGroupBox : list2) {
                if (sampleToGroupBox.getGroupingType().equals(sampleGroupDescriptionBox.getGroupEntries().get(0).getType())) {
                    int i2 = 0;
                    for (SampleToGroupBox.Entry entry : sampleToGroupBox.getEntries()) {
                        if (entry.getGroupDescriptionIndex() > 0) {
                            GroupEntry groupEntry = sampleGroupDescriptionBox.getGroupEntries().get(entry.getGroupDescriptionIndex() - 1);
                            long[] jArr = map.get(groupEntry);
                            if (jArr == null) {
                                jArr = new long[0];
                            }
                            long[] jArr2 = new long[CastUtils.l2i(entry.getSampleCount()) + jArr.length];
                            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                            for (int i3 = 0; i3 < entry.getSampleCount(); i3++) {
                                jArr2[jArr.length + i3] = i2 + i3;
                            }
                            map.put(groupEntry, jArr2);
                        }
                        i2 = (int) (i2 + entry.getSampleCount());
                    }
                    z = true;
                }
            }
            if (!z) {
                throw new RuntimeException("Could not find SampleToGroupBox for " + sampleGroupDescriptionBox.getGroupEntries().get(0).getType() + ".");
            }
        }
        return map;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Container parent = this.trackBox.getParent();
        if (parent instanceof BasicContainer) {
            ((BasicContainer) parent).close();
        }
        for (IsoFile isoFile : this.fragments) {
            isoFile.close();
        }
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<CompositionTimeToSample.Entry> getCompositionTimeEntries() {
        return this.compositionTimeEntries;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return this.handler;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public List<SampleDependencyTypeBox.Entry> getSampleDependencies() {
        return this.sampleDependencies;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public synchronized long[] getSampleDurations() {
        return this.decodingTimes;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.subSampleInformationBox;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public long[] getSyncSamples() {
        if (this.syncSamples.length == this.samples.size()) {
            return null;
        }
        return this.syncSamples;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }
}
