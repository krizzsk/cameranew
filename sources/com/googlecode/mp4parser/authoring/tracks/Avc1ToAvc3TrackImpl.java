package com.googlecode.mp4parser.authoring.tracks;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.MemoryDataSourceImpl;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.WrappingTrack;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Path;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class Avc1ToAvc3TrackImpl extends WrappingTrack {
    AvcConfigurationBox avcC;
    List<Sample> samples;
    SampleDescriptionBox stsd;

    /* loaded from: classes2.dex */
    private class a extends AbstractList<Sample> {
        List<Sample> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.googlecode.mp4parser.authoring.tracks.Avc1ToAvc3TrackImpl$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0192a implements Sample {
            private final /* synthetic */ ByteBuffer b;
            private final /* synthetic */ int c;

            /* renamed from: d  reason: collision with root package name */
            private final /* synthetic */ Sample f5070d;

            C0192a(ByteBuffer byteBuffer, int i2, Sample sample) {
                this.b = byteBuffer;
                this.c = i2;
                this.f5070d = sample;
            }

            @Override // com.googlecode.mp4parser.authoring.Sample
            public ByteBuffer asByteBuffer() {
                int i2 = 0;
                for (byte[] bArr : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSets()) {
                    i2 += this.c + bArr.length;
                }
                for (byte[] bArr2 : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSetExts()) {
                    i2 += this.c + bArr2.length;
                }
                for (byte[] bArr3 : Avc1ToAvc3TrackImpl.this.avcC.getPictureParameterSets()) {
                    i2 += this.c + bArr3.length;
                }
                ByteBuffer allocate = ByteBuffer.allocate(CastUtils.l2i(this.f5070d.getSize()) + i2);
                for (byte[] bArr4 : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSets()) {
                    IsoTypeWriterVariable.write(bArr4.length, allocate, this.c);
                    allocate.put(bArr4);
                }
                for (byte[] bArr5 : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSetExts()) {
                    IsoTypeWriterVariable.write(bArr5.length, allocate, this.c);
                    allocate.put(bArr5);
                }
                for (byte[] bArr6 : Avc1ToAvc3TrackImpl.this.avcC.getPictureParameterSets()) {
                    IsoTypeWriterVariable.write(bArr6.length, allocate, this.c);
                    allocate.put(bArr6);
                }
                allocate.put(this.f5070d.asByteBuffer());
                return (ByteBuffer) allocate.rewind();
            }

            @Override // com.googlecode.mp4parser.authoring.Sample
            public long getSize() {
                int i2 = 0;
                for (byte[] bArr : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSets()) {
                    i2 += this.c + bArr.length;
                }
                for (byte[] bArr2 : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSetExts()) {
                    i2 += this.c + bArr2.length;
                }
                for (byte[] bArr3 : Avc1ToAvc3TrackImpl.this.avcC.getPictureParameterSets()) {
                    i2 += this.c + bArr3.length;
                }
                return this.f5070d.getSize() + i2;
            }

            @Override // com.googlecode.mp4parser.authoring.Sample
            public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                for (byte[] bArr : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSets()) {
                    IsoTypeWriterVariable.write(bArr.length, (ByteBuffer) this.b.rewind(), this.c);
                    writableByteChannel.write((ByteBuffer) this.b.rewind());
                    writableByteChannel.write(ByteBuffer.wrap(bArr));
                }
                for (byte[] bArr2 : Avc1ToAvc3TrackImpl.this.avcC.getSequenceParameterSetExts()) {
                    IsoTypeWriterVariable.write(bArr2.length, (ByteBuffer) this.b.rewind(), this.c);
                    writableByteChannel.write((ByteBuffer) this.b.rewind());
                    writableByteChannel.write(ByteBuffer.wrap(bArr2));
                }
                for (byte[] bArr3 : Avc1ToAvc3TrackImpl.this.avcC.getPictureParameterSets()) {
                    IsoTypeWriterVariable.write(bArr3.length, (ByteBuffer) this.b.rewind(), this.c);
                    writableByteChannel.write((ByteBuffer) this.b.rewind());
                    writableByteChannel.write(ByteBuffer.wrap(bArr3));
                }
                this.f5070d.writeTo(writableByteChannel);
            }
        }

        public a(List<Sample> list) {
            this.a = list;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: c */
        public Sample get(int i2) {
            if (Arrays.binarySearch(Avc1ToAvc3TrackImpl.this.getSyncSamples(), i2 + 1) >= 0) {
                int lengthSizeMinusOne = Avc1ToAvc3TrackImpl.this.avcC.getLengthSizeMinusOne() + 1;
                return new C0192a(ByteBuffer.allocate(lengthSizeMinusOne), lengthSizeMinusOne, this.a.get(i2));
            }
            return this.a.get(i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.a.size();
        }
    }

    public Avc1ToAvc3TrackImpl(Track track) throws IOException {
        super(track);
        if (VisualSampleEntry.TYPE3.equals(track.getSampleDescriptionBox().getSampleEntry().getType())) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            track.getSampleDescriptionBox().getBox(Channels.newChannel(byteArrayOutputStream));
            SampleDescriptionBox sampleDescriptionBox = (SampleDescriptionBox) Path.getPath(new IsoFile(new MemoryDataSourceImpl(byteArrayOutputStream.toByteArray())), SampleDescriptionBox.TYPE);
            this.stsd = sampleDescriptionBox;
            ((VisualSampleEntry) sampleDescriptionBox.getSampleEntry()).setType(VisualSampleEntry.TYPE4);
            this.avcC = (AvcConfigurationBox) Path.getPath((AbstractContainerBox) this.stsd, "avc./avcC");
            this.samples = new a(track.getSamples());
            return;
        }
        throw new RuntimeException("Only avc1 tracks can be converted to avc3 tracks");
    }

    @Override // com.googlecode.mp4parser.authoring.WrappingTrack, com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.stsd;
    }

    @Override // com.googlecode.mp4parser.authoring.WrappingTrack, com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }
}
