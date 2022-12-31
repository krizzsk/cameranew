package com.googlecode.mp4parser.authoring.samples;

import androidx.core.location.LocationRequestCompat;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DefaultMp4SampleList extends AbstractList<Sample> {
    private static final long MAX_MAP_SIZE = 268435456;
    ByteBuffer[][] cache;
    int[] chunkNumsStartSampleNum;
    long[] chunkOffsets;
    long[] chunkSizes;
    int lastChunk = 0;
    long[][] sampleOffsetsWithinChunks;
    SampleSizeBox ssb;
    Container topLevel;
    TrackBox trackBox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Sample {
        private final /* synthetic */ long a;
        private final /* synthetic */ ByteBuffer b;
        private final /* synthetic */ long c;

        a(DefaultMp4SampleList defaultMp4SampleList, long j2, ByteBuffer byteBuffer, long j3) {
            this.a = j2;
            this.b = byteBuffer;
            this.c = j3;
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public ByteBuffer asByteBuffer() {
            return (ByteBuffer) ((ByteBuffer) this.b.position(CastUtils.l2i(this.c))).slice().limit(CastUtils.l2i(this.a));
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public long getSize() {
            return this.a;
        }

        public String toString() {
            return "DefaultMp4Sample(size:" + this.a + ")";
        }

        @Override // com.googlecode.mp4parser.authoring.Sample
        public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
            writableByteChannel.write(asByteBuffer());
        }
    }

    public DefaultMp4SampleList(long j2, Container container) {
        int i2;
        this.trackBox = null;
        this.cache = null;
        int i3 = 0;
        this.topLevel = container;
        for (TrackBox trackBox : ((MovieBox) container.getBoxes(MovieBox.class).get(0)).getBoxes(TrackBox.class)) {
            if (trackBox.getTrackHeaderBox().getTrackId() == j2) {
                this.trackBox = trackBox;
            }
        }
        TrackBox trackBox2 = this.trackBox;
        if (trackBox2 != null) {
            long[] chunkOffsets = trackBox2.getSampleTableBox().getChunkOffsetBox().getChunkOffsets();
            this.chunkOffsets = chunkOffsets;
            this.chunkSizes = new long[chunkOffsets.length];
            this.cache = new ByteBuffer[chunkOffsets.length];
            this.sampleOffsetsWithinChunks = new long[chunkOffsets.length];
            this.ssb = this.trackBox.getSampleTableBox().getSampleSizeBox();
            List<SampleToChunkBox.Entry> entries = this.trackBox.getSampleTableBox().getSampleToChunkBox().getEntries();
            SampleToChunkBox.Entry[] entryArr = (SampleToChunkBox.Entry[]) entries.toArray(new SampleToChunkBox.Entry[entries.size()]);
            SampleToChunkBox.Entry entry = entryArr[0];
            long firstChunk = entry.getFirstChunk();
            int l2i = CastUtils.l2i(entry.getSamplesPerChunk());
            int size = size();
            int i4 = 0;
            int i5 = 1;
            int i6 = 0;
            int i7 = 1;
            do {
                i4++;
                if (i4 == firstChunk) {
                    if (entryArr.length > i5) {
                        SampleToChunkBox.Entry entry2 = entryArr[i5];
                        i6 = l2i;
                        l2i = CastUtils.l2i(entry2.getSamplesPerChunk());
                        i5++;
                        firstChunk = entry2.getFirstChunk();
                    } else {
                        i6 = l2i;
                        l2i = -1;
                        firstChunk = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                }
                this.sampleOffsetsWithinChunks[i4 - 1] = new long[i6];
                i7 += i6;
            } while (i7 <= size);
            this.chunkNumsStartSampleNum = new int[i4 + 1];
            SampleToChunkBox.Entry entry3 = entryArr[0];
            long firstChunk2 = entry3.getFirstChunk();
            int l2i2 = CastUtils.l2i(entry3.getSamplesPerChunk());
            int i8 = 0;
            int i9 = 1;
            int i10 = 1;
            int i11 = 0;
            while (true) {
                i2 = i8 + 1;
                this.chunkNumsStartSampleNum[i8] = i9;
                if (i2 == firstChunk2) {
                    if (entryArr.length > i10) {
                        SampleToChunkBox.Entry entry4 = entryArr[i10];
                        i11 = l2i2;
                        i10++;
                        l2i2 = CastUtils.l2i(entry4.getSamplesPerChunk());
                        firstChunk2 = entry4.getFirstChunk();
                    } else {
                        i11 = l2i2;
                        l2i2 = -1;
                        firstChunk2 = LocationRequestCompat.PASSIVE_INTERVAL;
                    }
                }
                i9 += i11;
                if (i9 > size) {
                    break;
                }
                i8 = i2;
            }
            this.chunkNumsStartSampleNum[i2] = Integer.MAX_VALUE;
            long j3 = 0;
            for (int i12 = 1; i12 <= this.ssb.getSampleCount(); i12++) {
                while (i12 == this.chunkNumsStartSampleNum[i3]) {
                    i3++;
                    j3 = 0;
                }
                long[] jArr = this.chunkSizes;
                int i13 = i3 - 1;
                int i14 = i12 - 1;
                jArr[i13] = jArr[i13] + this.ssb.getSampleSizeAtIndex(i14);
                this.sampleOffsetsWithinChunks[i13][i12 - this.chunkNumsStartSampleNum[i13]] = j3;
                j3 += this.ssb.getSampleSizeAtIndex(i14);
            }
            return;
        }
        throw new RuntimeException("This MP4 does not contain track " + j2);
    }

    synchronized int getChunkForSample(int i2) {
        int i3 = i2 + 1;
        int[] iArr = this.chunkNumsStartSampleNum;
        int i4 = this.lastChunk;
        if (i3 >= iArr[i4] && i3 < iArr[i4 + 1]) {
            return i4;
        }
        if (i3 < iArr[i4]) {
            this.lastChunk = 0;
            while (true) {
                int[] iArr2 = this.chunkNumsStartSampleNum;
                int i5 = this.lastChunk;
                if (iArr2[i5 + 1] > i3) {
                    return i5;
                }
                this.lastChunk = i5 + 1;
            }
        } else {
            this.lastChunk = i4 + 1;
            while (true) {
                int[] iArr3 = this.chunkNumsStartSampleNum;
                int i6 = this.lastChunk;
                if (iArr3[i6 + 1] > i3) {
                    return i6;
                }
                this.lastChunk = i6 + 1;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return CastUtils.l2i(this.trackBox.getSampleTableBox().getSampleSizeBox().getSampleCount());
    }

    @Override // java.util.AbstractList, java.util.List
    public Sample get(int i2) {
        ByteBuffer byteBuffer;
        long j2;
        if (i2 < this.ssb.getSampleCount()) {
            int chunkForSample = getChunkForSample(i2);
            int i3 = this.chunkNumsStartSampleNum[chunkForSample] - 1;
            long j3 = chunkForSample;
            long j4 = this.chunkOffsets[CastUtils.l2i(j3)];
            long[] jArr = this.sampleOffsetsWithinChunks[CastUtils.l2i(j3)];
            long j5 = jArr[i2 - i3];
            ByteBuffer[] byteBufferArr = this.cache[CastUtils.l2i(j3)];
            if (byteBufferArr == null) {
                ArrayList arrayList = new ArrayList();
                long j6 = 0;
                int i4 = 0;
                while (i4 < jArr.length) {
                    try {
                        long j7 = j3;
                        if ((jArr[i4] + this.ssb.getSampleSizeAtIndex(i4 + i3)) - j6 > MAX_MAP_SIZE) {
                            j2 = j5;
                            arrayList.add(this.topLevel.getByteBuffer(j4 + j6, jArr[i4] - j6));
                            j6 = jArr[i4];
                        } else {
                            j2 = j5;
                        }
                        i4++;
                        j5 = j2;
                        j3 = j7;
                    } catch (IOException e2) {
                        throw new IndexOutOfBoundsException(e2.getMessage());
                    }
                }
                arrayList.add(this.topLevel.getByteBuffer(j4 + j6, (-j6) + jArr[jArr.length - 1] + this.ssb.getSampleSizeAtIndex((i3 + jArr.length) - 1)));
                byteBufferArr = (ByteBuffer[]) arrayList.toArray(new ByteBuffer[arrayList.size()]);
                this.cache[CastUtils.l2i(j3)] = byteBufferArr;
            }
            int length = byteBufferArr.length;
            long j8 = j5;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    byteBuffer = null;
                    break;
                }
                ByteBuffer byteBuffer2 = byteBufferArr[i5];
                if (j8 < byteBuffer2.limit()) {
                    byteBuffer = byteBuffer2;
                    break;
                }
                j8 -= byteBuffer2.limit();
                i5++;
            }
            return new a(this, this.ssb.getSampleSizeAtIndex(i2), byteBuffer, j8);
        }
        throw new IndexOutOfBoundsException();
    }
}
