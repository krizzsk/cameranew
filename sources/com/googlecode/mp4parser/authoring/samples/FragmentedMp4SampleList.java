package com.googlecode.mp4parser.authoring.samples;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class FragmentedMp4SampleList extends AbstractList<Sample> {
    private List<TrackFragmentBox> allTrafs;
    private int[] firstSamples;
    IsoFile[] fragments;
    private SoftReference<Sample>[] sampleCache;
    Container topLevel;
    TrackBox trackBox;
    TrackExtendsBox trex;
    private Map<TrackRunBox, SoftReference<ByteBuffer>> trunDataCache = new HashMap();
    private int size_ = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Sample {
        private final /* synthetic */ long a;
        private final /* synthetic */ ByteBuffer b;
        private final /* synthetic */ int c;

        a(FragmentedMp4SampleList fragmentedMp4SampleList, long j2, ByteBuffer byteBuffer, int i2) {
            this.a = j2;
            this.b = byteBuffer;
            this.c = i2;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            return (ByteBuffer) ((ByteBuffer) this.b.position(this.c)).slice().limit(CastUtils.l2i(this.a));
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.a;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(asByteBuffer());
        }
    }

    public FragmentedMp4SampleList(long j2, Container container, IsoFile... isoFileArr) {
        this.trackBox = null;
        this.trex = null;
        this.topLevel = container;
        this.fragments = isoFileArr;
        for (TrackBox trackBox : Path.getPaths(container, "moov[0]/trak")) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j2) {
                this.trackBox = trackBox;
            }
        }
        if (this.trackBox != null) {
            for (TrackExtendsBox trackExtendsBox : Path.getPaths(container, "moov[0]/mvex[0]/trex")) {
                if (trackExtendsBox.getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    this.trex = trackExtendsBox;
                }
            }
            this.sampleCache = (SoftReference[]) Array.newInstance(SoftReference.class, size());
            initAllFragments();
            return;
        }
        throw new RuntimeException("This MP4 does not contain track " + j2);
    }

    private int getTrafSize(TrackFragmentBox trackFragmentBox) {
        List<Box> boxes = trackFragmentBox.getBoxes();
        int i2 = 0;
        for (int i3 = 0; i3 < boxes.size(); i3++) {
            Box box = boxes.get(i3);
            if (box instanceof TrackRunBox) {
                i2 += CastUtils.l2i(((TrackRunBox) box).getSampleCount());
            }
        }
        return i2;
    }

    private List<TrackFragmentBox> initAllFragments() {
        List<TrackFragmentBox> list = this.allTrafs;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (MovieFragmentBox movieFragmentBox : this.topLevel.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    arrayList.add(trackFragmentBox);
                }
            }
        }
        IsoFile[] isoFileArr = this.fragments;
        if (isoFileArr != null) {
            for (IsoFile isoFile : isoFileArr) {
                for (MovieFragmentBox movieFragmentBox2 : isoFile.getBoxes(MovieFragmentBox.class)) {
                    for (TrackFragmentBox trackFragmentBox2 : movieFragmentBox2.getBoxes(TrackFragmentBox.class)) {
                        if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                            arrayList.add(trackFragmentBox2);
                        }
                    }
                }
            }
        }
        this.allTrafs = arrayList;
        this.firstSamples = new int[arrayList.size()];
        int i2 = 1;
        for (int i3 = 0; i3 < this.allTrafs.size(); i3++) {
            this.firstSamples[i3] = i2;
            i2 += getTrafSize(this.allTrafs.get(i3));
        }
        return arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int i2 = this.size_;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (MovieFragmentBox movieFragmentBox : this.topLevel.getBoxes(MovieFragmentBox.class)) {
            for (TrackFragmentBox trackFragmentBox : movieFragmentBox.getBoxes(TrackFragmentBox.class)) {
                if (trackFragmentBox.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                    i3 = (int) (i3 + ((TrackRunBox) trackFragmentBox.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
                }
            }
        }
        for (IsoFile isoFile : this.fragments) {
            for (MovieFragmentBox movieFragmentBox2 : isoFile.getBoxes(MovieFragmentBox.class)) {
                for (TrackFragmentBox trackFragmentBox2 : movieFragmentBox2.getBoxes(TrackFragmentBox.class)) {
                    if (trackFragmentBox2.getTrackFragmentHeaderBox().getTrackId() == this.trackBox.getTrackHeaderBox().getTrackId()) {
                        i3 = (int) (i3 + ((TrackRunBox) trackFragmentBox2.getBoxes(TrackRunBox.class).get(0)).getSampleCount());
                    }
                }
            }
        }
        this.size_ = i3;
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i2) {
        long j2;
        ByteBuffer byteBuffer;
        long defaultSampleSize;
        Sample sample;
        SoftReference<Sample>[] softReferenceArr = this.sampleCache;
        if (softReferenceArr[i2] == null || (sample = softReferenceArr[i2].get()) == null) {
            int i3 = i2 + 1;
            int length = this.firstSamples.length;
            while (true) {
                length--;
                if (i3 - this.firstSamples[length] >= 0) {
                    break;
                }
            }
            TrackFragmentBox trackFragmentBox = this.allTrafs.get(length);
            int i4 = i3 - this.firstSamples[length];
            MovieFragmentBox movieFragmentBox = (MovieFragmentBox) trackFragmentBox.getParent();
            int i5 = 0;
            for (Box box : trackFragmentBox.getBoxes()) {
                if (box instanceof TrackRunBox) {
                    TrackRunBox trackRunBox = (TrackRunBox) box;
                    int i6 = i4 - i5;
                    if (trackRunBox.getEntries().size() < i6) {
                        i5 += trackRunBox.getEntries().size();
                    } else {
                        List<TrackRunBox.Entry> entries = trackRunBox.getEntries();
                        TrackFragmentHeaderBox trackFragmentHeaderBox = trackFragmentBox.getTrackFragmentHeaderBox();
                        boolean isSampleSizePresent = trackRunBox.isSampleSizePresent();
                        boolean hasDefaultSampleSize = trackFragmentHeaderBox.hasDefaultSampleSize();
                        long j3 = 0;
                        if (isSampleSizePresent) {
                            j2 = 0;
                        } else {
                            if (hasDefaultSampleSize) {
                                defaultSampleSize = trackFragmentHeaderBox.getDefaultSampleSize();
                            } else {
                                TrackExtendsBox trackExtendsBox = this.trex;
                                if (trackExtendsBox != null) {
                                    defaultSampleSize = trackExtendsBox.getDefaultSampleSize();
                                } else {
                                    throw new RuntimeException("File doesn't contain trex box but track fragments aren't fully self contained. Cannot determine sample size.");
                                }
                            }
                            j2 = defaultSampleSize;
                        }
                        SoftReference<ByteBuffer> softReference = this.trunDataCache.get(trackRunBox);
                        ByteBuffer byteBuffer2 = softReference != null ? softReference.get() : null;
                        if (byteBuffer2 == null) {
                            Container container = movieFragmentBox;
                            if (trackFragmentHeaderBox.hasBaseDataOffset()) {
                                j3 = 0 + trackFragmentHeaderBox.getBaseDataOffset();
                                container = movieFragmentBox.getParent();
                            }
                            if (trackRunBox.isDataOffsetPresent()) {
                                j3 += trackRunBox.getDataOffset();
                            }
                            int i7 = 0;
                            for (TrackRunBox.Entry entry : entries) {
                                i7 = isSampleSizePresent ? (int) (i7 + entry.getSampleSize()) : (int) (i7 + j2);
                            }
                            try {
                                ByteBuffer byteBuffer3 = container.getByteBuffer(j3, i7);
                                this.trunDataCache.put(trackRunBox, new SoftReference<>(byteBuffer3));
                                byteBuffer = byteBuffer3;
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        } else {
                            byteBuffer = byteBuffer2;
                        }
                        int i8 = 0;
                        for (int i9 = 0; i9 < i6; i9++) {
                            i8 = (int) (isSampleSizePresent ? i8 + entries.get(i9).getSampleSize() : i8 + j2);
                        }
                        a aVar = new a(this, isSampleSizePresent ? entries.get(i6).getSampleSize() : j2, byteBuffer, i8);
                        this.sampleCache[i2] = new SoftReference<>(aVar);
                        return aVar;
                    }
                }
            }
            throw new RuntimeException("Couldn't find sample in the traf I was looking");
        }
        return sample;
    }
}
