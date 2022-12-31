package com.googlecode.mp4parser.authoring.builder;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.HintMediaHeaderBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.NullMediaHeaderBox;
import com.coremedia.iso.boxes.SampleDependencyTypeBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SubtitleMediaHeaderBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.TrackReferenceTypeBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentRandomAccessOffsetBox;
import com.coremedia.iso.boxes.fragment.SampleFlags;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.authoring.Edit;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.tracks.CencEncryptedTrack;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
/* loaded from: classes2.dex */
public class FragmentedMp4Builder implements Mp4Builder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = Logger.getLogger(FragmentedMp4Builder.class.getName());
    protected FragmentIntersectionFinder intersectionFinder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Comparator<Track> {
        private final /* synthetic */ Map a;
        private final /* synthetic */ int b;

        a(FragmentedMp4Builder fragmentedMp4Builder, Map map, int i2) {
            this.a = map;
            this.b = i2;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Track track, Track track2) {
            long j2 = ((long[]) this.a.get(track))[this.b];
            long j3 = ((long[]) this.a.get(track2))[this.b];
            long[] sampleDurations = track.getSampleDurations();
            long[] sampleDurations2 = track2.getSampleDurations();
            long j4 = 0;
            for (int i2 = 1; i2 < j2; i2++) {
                j4 += sampleDurations[i2 - 1];
            }
            long j5 = 0;
            for (int i3 = 1; i3 < j3; i3++) {
                j5 += sampleDurations2[i3 - 1];
            }
            return (int) (((j4 / track.getTrackMetaData().getTimescale()) - (j5 / track2.getTrackMetaData().getTimescale())) * 100.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Box {
        Container a;
        long b = -1;

        /* renamed from: d  reason: collision with root package name */
        private final /* synthetic */ long f5063d;

        /* renamed from: e  reason: collision with root package name */
        private final /* synthetic */ long f5064e;

        /* renamed from: f  reason: collision with root package name */
        private final /* synthetic */ Track f5065f;

        /* renamed from: g  reason: collision with root package name */
        private final /* synthetic */ int f5066g;

        b(long j2, long j3, Track track, int i2) {
            this.f5063d = j2;
            this.f5064e = j3;
            this.f5065f = track;
            this.f5066g = i2;
        }

        @Override // com.coremedia.iso.boxes.Box
        public void getBox(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            IsoTypeWriter.writeUInt32(allocate, CastUtils.l2i(getSize()));
            allocate.put(IsoFile.fourCCtoBytes(getType()));
            allocate.rewind();
            writableByteChannel.write(allocate);
            for (Sample sample : FragmentedMp4Builder.this.getSamples(this.f5063d, this.f5064e, this.f5065f, this.f5066g)) {
                sample.writeTo(writableByteChannel);
            }
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getOffset() {
            throw new RuntimeException("Doesn't have any meaning for programmatically created boxes");
        }

        @Override // com.coremedia.iso.boxes.Box
        public Container getParent() {
            return this.a;
        }

        @Override // com.coremedia.iso.boxes.Box
        public long getSize() {
            long j2 = this.b;
            if (j2 != -1) {
                return j2;
            }
            long j3 = 8;
            for (Sample sample : FragmentedMp4Builder.this.getSamples(this.f5063d, this.f5064e, this.f5065f, this.f5066g)) {
                j3 += sample.getSize();
            }
            this.b = j3;
            return j3;
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

    private long getTrackDuration(Movie movie, Track track) {
        return (track.getDuration() * movie.getTimescale()) / track.getTrackMetaData().getTimescale();
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Mp4Builder
    public Container build(Movie movie) {
        Logger logger = LOG;
        logger.fine("Creating movie " + movie);
        if (this.intersectionFinder == null) {
            Track track = null;
            Iterator<Track> it = movie.getTracks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Track next = it.next();
                if (next.getHandler().equals("vide")) {
                    track = next;
                    break;
                }
            }
            this.intersectionFinder = new SyncSampleIntersectFinderImpl(movie, track, -1);
        }
        BasicContainer basicContainer = new BasicContainer();
        basicContainer.addBox(createFtyp(movie));
        basicContainer.addBox(createMoov(movie));
        for (Box box : createMoofMdat(movie)) {
            basicContainer.addBox(box);
        }
        basicContainer.addBox(createMfra(movie, basicContainer));
        return basicContainer;
    }

    protected DataInformationBox createDinf(Movie movie, Track track) {
        DataInformationBox dataInformationBox = new DataInformationBox();
        DataReferenceBox dataReferenceBox = new DataReferenceBox();
        dataInformationBox.addBox(dataReferenceBox);
        DataEntryUrlBox dataEntryUrlBox = new DataEntryUrlBox();
        dataEntryUrlBox.setFlags(1);
        dataReferenceBox.addBox(dataEntryUrlBox);
        return dataInformationBox;
    }

    protected Box createEdts(Track track, Movie movie) {
        if (track.getEdits() == null || track.getEdits().size() <= 0) {
            return null;
        }
        EditListBox editListBox = new EditListBox();
        editListBox.setVersion(1);
        ArrayList arrayList = new ArrayList();
        for (Edit edit : track.getEdits()) {
            arrayList.add(new EditListBox.Entry(editListBox, Math.round(edit.getSegmentDuration() * movie.getTimescale()), (edit.getMediaTime() * track.getTrackMetaData().getTimescale()) / edit.getTimeScale(), edit.getMediaRate()));
        }
        editListBox.setEntries(arrayList);
        EditBox editBox = new EditBox();
        editBox.addBox(editListBox);
        return editBox;
    }

    protected int createFragment(List<Box> list, Track track, long[] jArr, int i2, int i3) {
        if (i2 < jArr.length) {
            long j2 = jArr[i2];
            int i4 = i2 + 1;
            long size = i4 < jArr.length ? jArr[i4] : track.getSamples().size() + 1;
            if (j2 != size) {
                long j3 = size;
                list.add(createMoof(j2, j3, track, i3));
                int i5 = i3 + 1;
                list.add(createMdat(j2, j3, track, i3));
                return i5;
            }
            return i3;
        }
        return i3;
    }

    public Box createFtyp(Movie movie) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("iso2");
        linkedList.add(VisualSampleEntry.TYPE3);
        return new FileTypeBox("isom", 0L, linkedList);
    }

    protected Box createMdat(long j2, long j3, Track track, int i2) {
        return new b(j2, j3, track, i2);
    }

    protected Box createMdhd(Movie movie, Track track) {
        MediaHeaderBox mediaHeaderBox = new MediaHeaderBox();
        mediaHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        mediaHeaderBox.setModificationTime(getDate());
        mediaHeaderBox.setDuration(0L);
        mediaHeaderBox.setTimescale(track.getTrackMetaData().getTimescale());
        mediaHeaderBox.setLanguage(track.getTrackMetaData().getLanguage());
        return mediaHeaderBox;
    }

    protected Box createMdia(Track track, Movie movie) {
        MediaBox mediaBox = new MediaBox();
        mediaBox.addBox(createMdhd(movie, track));
        mediaBox.addBox(createMdiaHdlr(track, movie));
        mediaBox.addBox(createMinf(track, movie));
        return mediaBox;
    }

    protected Box createMdiaHdlr(Track track, Movie movie) {
        HandlerBox handlerBox = new HandlerBox();
        handlerBox.setHandlerType(track.getHandler());
        return handlerBox;
    }

    protected void createMfhd(long j2, long j3, Track track, int i2, MovieFragmentBox movieFragmentBox) {
        MovieFragmentHeaderBox movieFragmentHeaderBox = new MovieFragmentHeaderBox();
        movieFragmentHeaderBox.setSequenceNumber(i2);
        movieFragmentBox.addBox(movieFragmentHeaderBox);
    }

    protected Box createMfra(Movie movie, Container container) {
        MovieFragmentRandomAccessBox movieFragmentRandomAccessBox = new MovieFragmentRandomAccessBox();
        for (Track track : movie.getTracks()) {
            movieFragmentRandomAccessBox.addBox(createTfra(track, container));
        }
        MovieFragmentRandomAccessOffsetBox movieFragmentRandomAccessOffsetBox = new MovieFragmentRandomAccessOffsetBox();
        movieFragmentRandomAccessBox.addBox(movieFragmentRandomAccessOffsetBox);
        movieFragmentRandomAccessOffsetBox.setMfraSize(movieFragmentRandomAccessBox.getSize());
        return movieFragmentRandomAccessBox;
    }

    protected Box createMinf(Track track, Movie movie) {
        MediaInformationBox mediaInformationBox = new MediaInformationBox();
        if (track.getHandler().equals("vide")) {
            mediaInformationBox.addBox(new VideoMediaHeaderBox());
        } else if (track.getHandler().equals("soun")) {
            mediaInformationBox.addBox(new SoundMediaHeaderBox());
        } else if (track.getHandler().equals("text")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        } else if (track.getHandler().equals("subt")) {
            mediaInformationBox.addBox(new SubtitleMediaHeaderBox());
        } else if (track.getHandler().equals(TrackReferenceTypeBox.TYPE1)) {
            mediaInformationBox.addBox(new HintMediaHeaderBox());
        } else if (track.getHandler().equals("sbtl")) {
            mediaInformationBox.addBox(new NullMediaHeaderBox());
        }
        mediaInformationBox.addBox(createDinf(movie, track));
        mediaInformationBox.addBox(createStbl(movie, track));
        return mediaInformationBox;
    }

    protected Box createMoof(long j2, long j3, Track track, int i2) {
        MovieFragmentBox movieFragmentBox = new MovieFragmentBox();
        createMfhd(j2, j3, track, i2, movieFragmentBox);
        createTraf(j2, j3, track, i2, movieFragmentBox);
        TrackRunBox trackRunBox = movieFragmentBox.getTrackRunBoxes().get(0);
        trackRunBox.setDataOffset(1);
        trackRunBox.setDataOffset((int) (movieFragmentBox.getSize() + 8));
        return movieFragmentBox;
    }

    protected List<Box> createMoofMdat(Movie movie) {
        List<Box> linkedList = new LinkedList<>();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        for (Track track : movie.getTracks()) {
            long[] sampleNumbers = this.intersectionFinder.sampleNumbers(track);
            hashMap.put(track, sampleNumbers);
            i2 = Math.max(i2, sampleNumbers.length);
        }
        int i3 = 1;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i3;
            for (Track track2 : sortTracksInSequence(movie.getTracks(), i4, hashMap)) {
                i5 = createFragment(linkedList, track2, (long[]) hashMap.get(track2), i4, i5);
            }
            i4++;
            i3 = i5;
        }
        return linkedList;
    }

    protected Box createMoov(Movie movie) {
        MovieBox movieBox = new MovieBox();
        movieBox.addBox(createMvhd(movie));
        for (Track track : movie.getTracks()) {
            movieBox.addBox(createTrak(track, movie));
        }
        movieBox.addBox(createMvex(movie));
        return movieBox;
    }

    protected Box createMvex(Movie movie) {
        MovieExtendsBox movieExtendsBox = new MovieExtendsBox();
        MovieExtendsHeaderBox movieExtendsHeaderBox = new MovieExtendsHeaderBox();
        movieExtendsHeaderBox.setVersion(1);
        for (Track track : movie.getTracks()) {
            long trackDuration = getTrackDuration(movie, track);
            if (movieExtendsHeaderBox.getFragmentDuration() < trackDuration) {
                movieExtendsHeaderBox.setFragmentDuration(trackDuration);
            }
        }
        movieExtendsBox.addBox(movieExtendsHeaderBox);
        for (Track track2 : movie.getTracks()) {
            movieExtendsBox.addBox(createTrex(movie, track2));
        }
        return movieExtendsBox;
    }

    protected Box createMvhd(Movie movie) {
        MovieHeaderBox movieHeaderBox = new MovieHeaderBox();
        movieHeaderBox.setVersion(1);
        movieHeaderBox.setCreationTime(getDate());
        movieHeaderBox.setModificationTime(getDate());
        long j2 = 0;
        movieHeaderBox.setDuration(0L);
        movieHeaderBox.setTimescale(movie.getTimescale());
        for (Track track : movie.getTracks()) {
            if (j2 < track.getTrackMetaData().getTrackId()) {
                j2 = track.getTrackMetaData().getTrackId();
            }
        }
        movieHeaderBox.setNextTrackId(j2 + 1);
        return movieHeaderBox;
    }

    protected void createSaio(long j2, long j3, CencEncryptedTrack cencEncryptedTrack, int i2, TrackFragmentBox trackFragmentBox) {
        Box next;
        SchemeTypeBox schemeTypeBox = (SchemeTypeBox) Path.getPath((AbstractContainerBox) cencEncryptedTrack.getSampleDescriptionBox(), "enc.[0]/sinf[0]/schm[0]");
        SampleAuxiliaryInformationOffsetsBox sampleAuxiliaryInformationOffsetsBox = new SampleAuxiliaryInformationOffsetsBox();
        trackFragmentBox.addBox(sampleAuxiliaryInformationOffsetsBox);
        sampleAuxiliaryInformationOffsetsBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationOffsetsBox.setFlags(1);
        long j4 = 8;
        Iterator<Box> it = trackFragmentBox.getBoxes().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Box next2 = it.next();
            if (next2 instanceof SampleEncryptionBox) {
                j4 += ((SampleEncryptionBox) next2).getOffsetToFirstIV();
                break;
            }
            j4 += next2.getSize();
        }
        long j5 = j4 + 16;
        Iterator<Box> it2 = ((MovieFragmentBox) trackFragmentBox.getParent()).getBoxes().iterator();
        while (it2.hasNext() && (next = it2.next()) != trackFragmentBox) {
            j5 += next.getSize();
        }
        sampleAuxiliaryInformationOffsetsBox.setOffsets(new long[]{j5});
    }

    protected void createSaiz(long j2, long j3, CencEncryptedTrack cencEncryptedTrack, int i2, TrackFragmentBox trackFragmentBox) {
        SampleDescriptionBox sampleDescriptionBox = cencEncryptedTrack.getSampleDescriptionBox();
        SchemeTypeBox schemeTypeBox = (SchemeTypeBox) Path.getPath((AbstractContainerBox) sampleDescriptionBox, "enc.[0]/sinf[0]/schm[0]");
        TrackEncryptionBox trackEncryptionBox = (TrackEncryptionBox) Path.getPath((AbstractContainerBox) sampleDescriptionBox, "enc.[0]/sinf[0]/schi[0]/tenc[0]");
        SampleAuxiliaryInformationSizesBox sampleAuxiliaryInformationSizesBox = new SampleAuxiliaryInformationSizesBox();
        sampleAuxiliaryInformationSizesBox.setAuxInfoType("cenc");
        sampleAuxiliaryInformationSizesBox.setFlags(1);
        if (cencEncryptedTrack.hasSubSampleEncryption()) {
            int l2i = CastUtils.l2i(j3 - j2);
            short[] sArr = new short[l2i];
            List<CencSampleAuxiliaryDataFormat> subList = cencEncryptedTrack.getSampleEncryptionEntries().subList(CastUtils.l2i(j2 - 1), CastUtils.l2i(j3 - 1));
            for (int i3 = 0; i3 < l2i; i3++) {
                sArr[i3] = (short) subList.get(i3).getSize();
            }
            sampleAuxiliaryInformationSizesBox.setSampleInfoSizes(sArr);
        } else {
            sampleAuxiliaryInformationSizesBox.setDefaultSampleInfoSize(trackEncryptionBox.getDefaultIvSize());
            sampleAuxiliaryInformationSizesBox.setSampleCount(CastUtils.l2i(j3 - j2));
        }
        trackFragmentBox.addBox(sampleAuxiliaryInformationSizesBox);
    }

    protected void createSenc(long j2, long j3, CencEncryptedTrack cencEncryptedTrack, int i2, TrackFragmentBox trackFragmentBox) {
        SampleEncryptionBox sampleEncryptionBox = new SampleEncryptionBox();
        sampleEncryptionBox.setSubSampleEncryption(cencEncryptedTrack.hasSubSampleEncryption());
        sampleEncryptionBox.setEntries(cencEncryptedTrack.getSampleEncryptionEntries().subList(CastUtils.l2i(j2 - 1), CastUtils.l2i(j3 - 1)));
        trackFragmentBox.addBox(sampleEncryptionBox);
    }

    protected Box createStbl(Movie movie, Track track) {
        SampleTableBox sampleTableBox = new SampleTableBox();
        createStsd(track, sampleTableBox);
        sampleTableBox.addBox(new TimeToSampleBox());
        sampleTableBox.addBox(new SampleToChunkBox());
        sampleTableBox.addBox(new SampleSizeBox());
        sampleTableBox.addBox(new StaticChunkOffsetBox());
        return sampleTableBox;
    }

    protected void createStsd(Track track, SampleTableBox sampleTableBox) {
        sampleTableBox.addBox(track.getSampleDescriptionBox());
    }

    protected void createTfdt(long j2, Track track, TrackFragmentBox trackFragmentBox) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox();
        trackFragmentBaseMediaDecodeTimeBox.setVersion(1);
        long[] sampleDurations = track.getSampleDurations();
        long j3 = 0;
        for (int i2 = 1; i2 < j2; i2++) {
            j3 += sampleDurations[i2 - 1];
        }
        trackFragmentBaseMediaDecodeTimeBox.setBaseMediaDecodeTime(j3);
        trackFragmentBox.addBox(trackFragmentBaseMediaDecodeTimeBox);
    }

    protected void createTfhd(long j2, long j3, Track track, int i2, TrackFragmentBox trackFragmentBox) {
        TrackFragmentHeaderBox trackFragmentHeaderBox = new TrackFragmentHeaderBox();
        trackFragmentHeaderBox.setDefaultSampleFlags(new SampleFlags());
        trackFragmentHeaderBox.setBaseDataOffset(-1L);
        trackFragmentHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackFragmentHeaderBox.setDefaultBaseIsMoof(true);
        trackFragmentBox.addBox(trackFragmentHeaderBox);
    }

    protected Box createTfra(Track track, Container container) {
        SampleFlags defaultSampleFlags;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox;
        LinkedList linkedList;
        TrackExtendsBox trackExtendsBox;
        Iterator<Box> it;
        int i2;
        int i3;
        int i4;
        List list;
        List list2;
        Box box;
        LinkedList linkedList2;
        TrackFragmentRandomAccessBox trackFragmentRandomAccessBox2 = new TrackFragmentRandomAccessBox();
        trackFragmentRandomAccessBox2.setVersion(1);
        LinkedList linkedList3 = new LinkedList();
        r4 = null;
        for (TrackExtendsBox trackExtendsBox2 : Path.getPaths(container, "moov/mvex/trex")) {
            TrackExtendsBox trackExtendsBox3 = trackExtendsBox2;
            trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
            linkedList3 = linkedList3;
            if (trackExtendsBox2.getTrackId() != track.getTrackMetaData().getTrackId()) {
                trackExtendsBox2 = trackExtendsBox3;
            }
        }
        Iterator<Box> it2 = container.getBoxes().iterator();
        long j2 = 0;
        long j3 = 0;
        while (it2.hasNext()) {
            Box next = it2.next();
            if (next instanceof MovieFragmentBox) {
                List boxes = ((MovieFragmentBox) next).getBoxes(TrackFragmentBox.class);
                int i5 = 0;
                int i6 = 0;
                while (i6 < boxes.size()) {
                    TrackFragmentBox trackFragmentBox = (TrackFragmentBox) boxes.get(i6);
                    if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == track.getTrackMetaData().getTrackId()) {
                        List boxes2 = trackFragmentBox.getBoxes(TrackRunBox.class);
                        int i7 = 0;
                        while (i7 < boxes2.size()) {
                            LinkedList linkedList4 = new LinkedList();
                            TrackRunBox trackRunBox = (TrackRunBox) boxes2.get(i7);
                            long j4 = j3;
                            int i8 = 0;
                            while (i8 < trackRunBox.getEntries().size()) {
                                TrackRunBox.Entry entry = trackRunBox.getEntries().get(i8);
                                if (i8 == 0 && trackRunBox.isFirstSampleFlagsPresent()) {
                                    defaultSampleFlags = trackRunBox.getFirstSampleFlags();
                                } else if (trackRunBox.isSampleFlagsPresent()) {
                                    defaultSampleFlags = entry.getSampleFlags();
                                } else {
                                    defaultSampleFlags = trackExtendsBox2.getDefaultSampleFlags();
                                }
                                if (defaultSampleFlags == null && track.getHandler().equals("vide")) {
                                    throw new RuntimeException("Cannot find SampleFlags for video track but it's required to build tfra");
                                }
                                if (defaultSampleFlags == null || defaultSampleFlags.getSampleDependsOn() == 2) {
                                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox2;
                                    linkedList = linkedList3;
                                    trackExtendsBox = trackExtendsBox2;
                                    it = it2;
                                    i2 = i8;
                                    i3 = i7;
                                    i4 = i6;
                                    list = boxes2;
                                    list2 = boxes;
                                    box = next;
                                    linkedList2 = linkedList4;
                                    linkedList2.add(new TrackFragmentRandomAccessBox.Entry(j4, j2, i6 + 1, i7 + 1, i8 + 1));
                                } else {
                                    trackFragmentRandomAccessBox = trackFragmentRandomAccessBox2;
                                    linkedList = linkedList3;
                                    trackExtendsBox = trackExtendsBox2;
                                    it = it2;
                                    i2 = i8;
                                    i3 = i7;
                                    linkedList2 = linkedList4;
                                    i4 = i6;
                                    list = boxes2;
                                    list2 = boxes;
                                    box = next;
                                }
                                j4 += entry.getSampleDuration();
                                i8 = i2 + 1;
                                boxes = list2;
                                linkedList4 = linkedList2;
                                trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox;
                                linkedList3 = linkedList;
                                trackExtendsBox2 = trackExtendsBox;
                                it2 = it;
                                next = box;
                                i7 = i3;
                                i6 = i4;
                                boxes2 = list;
                                i5 = 0;
                            }
                            if (linkedList4.size() == trackRunBox.getEntries().size() && trackRunBox.getEntries().size() > 0) {
                                linkedList3.add((TrackFragmentRandomAccessBox.Entry) linkedList4.get(i5));
                            } else {
                                linkedList3.addAll(linkedList4);
                            }
                            i7++;
                            j3 = j4;
                        }
                        continue;
                    }
                    i6++;
                    boxes = boxes;
                    trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
                    linkedList3 = linkedList3;
                    trackExtendsBox2 = trackExtendsBox2;
                    it2 = it2;
                    next = next;
                    i5 = 0;
                }
                continue;
            }
            j2 += next.getSize();
            trackFragmentRandomAccessBox2 = trackFragmentRandomAccessBox2;
            linkedList3 = linkedList3;
            trackExtendsBox2 = trackExtendsBox2;
            it2 = it2;
        }
        trackFragmentRandomAccessBox2.setEntries(linkedList3);
        trackFragmentRandomAccessBox2.setTrackId(track.getTrackMetaData().getTrackId());
        return trackFragmentRandomAccessBox2;
    }

    protected Box createTkhd(Movie movie, Track track) {
        TrackHeaderBox trackHeaderBox = new TrackHeaderBox();
        trackHeaderBox.setVersion(1);
        trackHeaderBox.setFlags(7);
        trackHeaderBox.setAlternateGroup(track.getTrackMetaData().getGroup());
        trackHeaderBox.setCreationTime(track.getTrackMetaData().getCreationTime());
        trackHeaderBox.setDuration(0L);
        trackHeaderBox.setHeight(track.getTrackMetaData().getHeight());
        trackHeaderBox.setWidth(track.getTrackMetaData().getWidth());
        trackHeaderBox.setLayer(track.getTrackMetaData().getLayer());
        trackHeaderBox.setModificationTime(getDate());
        trackHeaderBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackHeaderBox.setVolume(track.getTrackMetaData().getVolume());
        return trackHeaderBox;
    }

    protected void createTraf(long j2, long j3, Track track, int i2, MovieFragmentBox movieFragmentBox) {
        TrackFragmentBox trackFragmentBox = new TrackFragmentBox();
        movieFragmentBox.addBox(trackFragmentBox);
        createTfhd(j2, j3, track, i2, trackFragmentBox);
        createTfdt(j2, track, trackFragmentBox);
        createTrun(j2, j3, track, i2, trackFragmentBox);
        if (track instanceof CencEncryptedTrack) {
            CencEncryptedTrack cencEncryptedTrack = (CencEncryptedTrack) track;
            createSaiz(j2, j3, cencEncryptedTrack, i2, trackFragmentBox);
            createSenc(j2, j3, cencEncryptedTrack, i2, trackFragmentBox);
            createSaio(j2, j3, cencEncryptedTrack, i2, trackFragmentBox);
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<GroupEntry, long[]> entry : track.getSampleGroups().entrySet()) {
            String type = entry.getKey().getType();
            List list = (List) hashMap.get(type);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(type, list);
            }
            list.add(entry.getKey());
        }
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            SampleGroupDescriptionBox sampleGroupDescriptionBox = new SampleGroupDescriptionBox();
            sampleGroupDescriptionBox.setGroupEntries((List) entry2.getValue());
            SampleToGroupBox sampleToGroupBox = new SampleToGroupBox();
            sampleToGroupBox.setGroupingType((String) entry2.getKey());
            long j4 = 1;
            SampleToGroupBox.Entry entry3 = null;
            for (int l2i = CastUtils.l2i(j2 - 1); l2i < CastUtils.l2i(j3 - j4); l2i++) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < ((List) entry2.getValue()).size()) {
                    Iterator it2 = it;
                    i4 = Arrays.binarySearch(track.getSampleGroups().get((GroupEntry) ((List) entry2.getValue()).get(i3)), (long) l2i) >= 0 ? i3 + 1 : i4;
                    i3++;
                    it = it2;
                    j4 = 1;
                }
                if (entry3 != null && entry3.getGroupDescriptionIndex() == i4) {
                    entry3.setSampleCount(entry3.getSampleCount() + j4);
                } else {
                    SampleToGroupBox.Entry entry4 = new SampleToGroupBox.Entry(j4, i4);
                    sampleToGroupBox.getEntries().add(entry4);
                    entry3 = entry4;
                }
            }
            trackFragmentBox.addBox(sampleGroupDescriptionBox);
            trackFragmentBox.addBox(sampleToGroupBox);
        }
    }

    protected Box createTrak(Track track, Movie movie) {
        Logger logger = LOG;
        logger.fine("Creating Track " + track);
        TrackBox trackBox = new TrackBox();
        trackBox.addBox(createTkhd(movie, track));
        Box createEdts = createEdts(track, movie);
        if (createEdts != null) {
            trackBox.addBox(createEdts);
        }
        trackBox.addBox(createMdia(track, movie));
        return trackBox;
    }

    protected Box createTrex(Movie movie, Track track) {
        TrackExtendsBox trackExtendsBox = new TrackExtendsBox();
        trackExtendsBox.setTrackId(track.getTrackMetaData().getTrackId());
        trackExtendsBox.setDefaultSampleDescriptionIndex(1L);
        trackExtendsBox.setDefaultSampleDuration(0L);
        trackExtendsBox.setDefaultSampleSize(0L);
        SampleFlags sampleFlags = new SampleFlags();
        if ("soun".equals(track.getHandler()) || "subt".equals(track.getHandler())) {
            sampleFlags.setSampleDependsOn(2);
            sampleFlags.setSampleIsDependedOn(2);
        }
        trackExtendsBox.setDefaultSampleFlags(sampleFlags);
        return trackExtendsBox;
    }

    protected void createTrun(long j2, long j3, Track track, int i2, TrackFragmentBox trackFragmentBox) {
        long[] jArr;
        long j4;
        TrackRunBox trackRunBox = new TrackRunBox();
        trackRunBox.setVersion(1);
        long[] sampleSizes = getSampleSizes(j2, j3, track, i2);
        trackRunBox.setSampleDurationPresent(true);
        trackRunBox.setSampleSizePresent(true);
        ArrayList arrayList = new ArrayList(CastUtils.l2i(j3 - j2));
        List<CompositionTimeToSample.Entry> compositionTimeEntries = track.getCompositionTimeEntries();
        CompositionTimeToSample.Entry[] entryArr = (compositionTimeEntries == null || compositionTimeEntries.size() <= 0) ? null : (CompositionTimeToSample.Entry[]) compositionTimeEntries.toArray(new CompositionTimeToSample.Entry[compositionTimeEntries.size()]);
        long count = entryArr != null ? entryArr[0].getCount() : -1;
        trackRunBox.setSampleCompositionTimeOffsetPresent(count > 0);
        long j5 = 1;
        int i3 = 0;
        while (j5 < j2) {
            long[] jArr2 = sampleSizes;
            if (entryArr != null) {
                count--;
                j4 = 0;
                if (count == 0) {
                    if (entryArr.length - i3 > 1) {
                        i3++;
                        count = entryArr[i3].getCount();
                    }
                    j5++;
                    sampleSizes = jArr2;
                }
            } else {
                j4 = 0;
            }
            j5++;
            sampleSizes = jArr2;
        }
        boolean z = ((track.getSampleDependencies() == null || track.getSampleDependencies().isEmpty()) && (track.getSyncSamples() == null || track.getSyncSamples().length == 0)) ? false : true;
        trackRunBox.setSampleFlagsPresent(z);
        int i4 = 0;
        while (i4 < sampleSizes.length) {
            TrackRunBox.Entry entry = new TrackRunBox.Entry();
            entry.setSampleSize(sampleSizes[i4]);
            if (z) {
                SampleFlags sampleFlags = new SampleFlags();
                if (track.getSampleDependencies() != null && !track.getSampleDependencies().isEmpty()) {
                    SampleDependencyTypeBox.Entry entry2 = track.getSampleDependencies().get(i4);
                    sampleFlags.setSampleDependsOn(entry2.getSampleDependsOn());
                    sampleFlags.setSampleIsDependedOn(entry2.getSampleIsDependentOn());
                    sampleFlags.setSampleHasRedundancy(entry2.getSampleHasRedundancy());
                }
                if (track.getSyncSamples() == null || track.getSyncSamples().length <= 0) {
                    jArr = sampleSizes;
                } else {
                    jArr = sampleSizes;
                    if (Arrays.binarySearch(track.getSyncSamples(), j2 + i4) >= 0) {
                        sampleFlags.setSampleIsDifferenceSample(false);
                        sampleFlags.setSampleDependsOn(2);
                    } else {
                        sampleFlags.setSampleIsDifferenceSample(true);
                        sampleFlags.setSampleDependsOn(1);
                    }
                }
                entry.setSampleFlags(sampleFlags);
            } else {
                jArr = sampleSizes;
            }
            entry.setSampleDuration(track.getSampleDurations()[CastUtils.l2i((j2 + i4) - 1)]);
            if (entryArr != null) {
                entry.setSampleCompositionTimeOffset(entryArr[i3].getOffset());
                count--;
                if (count == 0 && entryArr.length - i3 > 1) {
                    i3++;
                    count = entryArr[i3].getCount();
                }
            }
            arrayList.add(entry);
            i4++;
            sampleSizes = jArr;
        }
        trackRunBox.setEntries(arrayList);
        trackFragmentBox.addBox(trackRunBox);
    }

    public Date getDate() {
        return new Date();
    }

    public FragmentIntersectionFinder getFragmentIntersectionFinder() {
        return this.intersectionFinder;
    }

    protected long[] getSampleSizes(long j2, long j3, Track track, int i2) {
        List<Sample> samples = getSamples(j2, j3, track, i2);
        int size = samples.size();
        long[] jArr = new long[size];
        for (int i3 = 0; i3 < size; i3++) {
            jArr[i3] = samples.get(i3).getSize();
        }
        return jArr;
    }

    protected List<Sample> getSamples(long j2, long j3, Track track, int i2) {
        return track.getSamples().subList(CastUtils.l2i(j2) - 1, CastUtils.l2i(j3) - 1);
    }

    public void setIntersectionFinder(FragmentIntersectionFinder fragmentIntersectionFinder) {
        this.intersectionFinder = fragmentIntersectionFinder;
    }

    protected List<Track> sortTracksInSequence(List<Track> list, int i2, Map<Track, long[]> map) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList, new a(this, map, i2));
        return linkedList;
    }
}
