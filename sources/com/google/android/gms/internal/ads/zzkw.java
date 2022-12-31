package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.EditListBox;
import com.coremedia.iso.boxes.FileTypeBox;
import com.coremedia.iso.boxes.HandlerBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaHeaderBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MetaBox;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.OriginalFormatBox;
import com.coremedia.iso.boxes.ProtectionSchemeInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SampleToChunkBox;
import com.coremedia.iso.boxes.SchemeInformationBox;
import com.coremedia.iso.boxes.SchemeTypeBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.coremedia.iso.boxes.TrackBox;
import com.coremedia.iso.boxes.TrackHeaderBox;
import com.coremedia.iso.boxes.UserBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.apple.AppleItemListBox;
import com.coremedia.iso.boxes.apple.AppleWaveBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsBox;
import com.coremedia.iso.boxes.fragment.MovieExtendsHeaderBox;
import com.coremedia.iso.boxes.fragment.MovieFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackExtendsBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentBox;
import com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox;
import com.coremedia.iso.boxes.fragment.TrackRunBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.TextSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.dece.SampleEncryptionBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleToGroupBox;
import com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox;
import com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import com.mp4parser.iso14496.part15.HevcConfigurationBox;
import com.mp4parser.iso14496.part30.WebVTTSampleEntry;
import com.mp4parser.iso14496.part30.XMLSubtitleSampleEntry;
import com.mp4parser.iso23001.part7.ProtectionSystemSpecificHeaderBox;
import com.mp4parser.iso23001.part7.TrackEncryptionBox;
import com.mp4parser.iso23009.part1.EventMessageBox;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
class zzkw {
    public static final int zzasx = zzpt.zzbh(FileTypeBox.TYPE);
    public static final int zzasy = zzpt.zzbh(VisualSampleEntry.TYPE3);
    public static final int zzasz = zzpt.zzbh(VisualSampleEntry.TYPE4);
    public static final int zzata = zzpt.zzbh(VisualSampleEntry.TYPE6);
    public static final int zzatb = zzpt.zzbh(VisualSampleEntry.TYPE7);
    public static final int zzatc = zzpt.zzbh(VisualSampleEntry.TYPE2);
    public static final int zzatd = zzpt.zzbh("d263");
    public static final int zzate = zzpt.zzbh(MediaDataBox.TYPE);
    public static final int zzatf = zzpt.zzbh(AudioSampleEntry.TYPE3);
    public static final int zzatg = zzpt.zzbh(".mp3");
    public static final int zzath = zzpt.zzbh(AppleWaveBox.TYPE);
    public static final int zzati = zzpt.zzbh("lpcm");
    public static final int zzatj = zzpt.zzbh("sowt");
    public static final int zzatk = zzpt.zzbh(AudioSampleEntry.TYPE8);
    public static final int zzatl = zzpt.zzbh(AC3SpecificBox.TYPE);
    public static final int zzatm = zzpt.zzbh(AudioSampleEntry.TYPE9);
    public static final int zzatn = zzpt.zzbh(EC3SpecificBox.TYPE);
    public static final int zzato = zzpt.zzbh("dtsc");
    public static final int zzatp = zzpt.zzbh(AudioSampleEntry.TYPE12);
    public static final int zzatq = zzpt.zzbh(AudioSampleEntry.TYPE11);
    public static final int zzatr = zzpt.zzbh(AudioSampleEntry.TYPE13);
    public static final int zzats = zzpt.zzbh(DTSSpecificBox.TYPE);
    public static final int zzatt = zzpt.zzbh(TrackFragmentBaseMediaDecodeTimeBox.TYPE);
    public static final int zzatu = zzpt.zzbh(TrackFragmentHeaderBox.TYPE);
    public static final int zzatv = zzpt.zzbh(TrackExtendsBox.TYPE);
    public static final int zzatw = zzpt.zzbh(TrackRunBox.TYPE);
    public static final int zzatx = zzpt.zzbh(SegmentIndexBox.TYPE);
    public static final int zzaty = zzpt.zzbh(MovieBox.TYPE);
    public static final int zzatz = zzpt.zzbh(MovieHeaderBox.TYPE);
    public static final int zzaua = zzpt.zzbh(TrackBox.TYPE);
    public static final int zzaub = zzpt.zzbh(MediaBox.TYPE);
    public static final int zzauc = zzpt.zzbh(MediaInformationBox.TYPE);
    public static final int zzaud = zzpt.zzbh(SampleTableBox.TYPE);
    public static final int zzaue = zzpt.zzbh(AvcConfigurationBox.TYPE);
    public static final int zzauf = zzpt.zzbh(HevcConfigurationBox.TYPE);
    public static final int zzaug = zzpt.zzbh(ESDescriptorBox.TYPE);
    public static final int zzauh = zzpt.zzbh(MovieFragmentBox.TYPE);
    public static final int zzaui = zzpt.zzbh(TrackFragmentBox.TYPE);
    public static final int zzauj = zzpt.zzbh(MovieExtendsBox.TYPE);
    public static final int zzauk = zzpt.zzbh(MovieExtendsHeaderBox.TYPE);
    public static final int zzaul = zzpt.zzbh(TrackHeaderBox.TYPE);
    public static final int zzaum = zzpt.zzbh(EditBox.TYPE);
    public static final int zzaun = zzpt.zzbh(EditListBox.TYPE);
    public static final int zzauo = zzpt.zzbh(MediaHeaderBox.TYPE);
    public static final int zzaup = zzpt.zzbh(HandlerBox.TYPE);
    public static final int zzauq = zzpt.zzbh(SampleDescriptionBox.TYPE);
    public static final int zzaur = zzpt.zzbh(ProtectionSystemSpecificHeaderBox.TYPE);
    public static final int zzaus = zzpt.zzbh(ProtectionSchemeInformationBox.TYPE);
    public static final int zzaut = zzpt.zzbh(SchemeTypeBox.TYPE);
    public static final int zzauu = zzpt.zzbh(SchemeInformationBox.TYPE);
    public static final int zzauv = zzpt.zzbh(TrackEncryptionBox.TYPE);
    public static final int zzauw = zzpt.zzbh(VisualSampleEntry.TYPE_ENCRYPTED);
    public static final int zzaux = zzpt.zzbh(AudioSampleEntry.TYPE_ENCRYPTED);
    public static final int zzauy = zzpt.zzbh(OriginalFormatBox.TYPE);
    public static final int zzauz = zzpt.zzbh(SampleAuxiliaryInformationSizesBox.TYPE);
    public static final int zzava = zzpt.zzbh(SampleAuxiliaryInformationOffsetsBox.TYPE);
    public static final int zzavb = zzpt.zzbh(SampleToGroupBox.TYPE);
    public static final int zzavc = zzpt.zzbh(SampleGroupDescriptionBox.TYPE);
    public static final int zzavd = zzpt.zzbh(UserBox.TYPE);
    public static final int zzave = zzpt.zzbh(SampleEncryptionBox.TYPE);
    public static final int zzavf = zzpt.zzbh(PixelAspectRationAtom.TYPE);
    public static final int zzavg = zzpt.zzbh("TTML");
    private static final int zzavh = zzpt.zzbh(VideoMediaHeaderBox.TYPE);
    public static final int zzavi = zzpt.zzbh(VisualSampleEntry.TYPE1);
    public static final int zzavj = zzpt.zzbh(TimeToSampleBox.TYPE);
    public static final int zzavk = zzpt.zzbh(SyncSampleBox.TYPE);
    public static final int zzavl = zzpt.zzbh(CompositionTimeToSample.TYPE);
    public static final int zzavm = zzpt.zzbh(SampleToChunkBox.TYPE);
    public static final int zzavn = zzpt.zzbh(SampleSizeBox.TYPE);
    public static final int zzavo = zzpt.zzbh("stz2");
    public static final int zzavp = zzpt.zzbh(StaticChunkOffsetBox.TYPE);
    public static final int zzavq = zzpt.zzbh(ChunkOffset64BitBox.TYPE);
    public static final int zzavr = zzpt.zzbh(TextSampleEntry.TYPE1);
    public static final int zzavs = zzpt.zzbh(WebVTTSampleEntry.TYPE);
    public static final int zzavt = zzpt.zzbh(XMLSubtitleSampleEntry.TYPE);
    public static final int zzavu = zzpt.zzbh("c608");
    public static final int zzavv = zzpt.zzbh(AudioSampleEntry.TYPE1);
    public static final int zzavw = zzpt.zzbh(AudioSampleEntry.TYPE2);
    public static final int zzavx = zzpt.zzbh(UserDataBox.TYPE);
    public static final int zzavy = zzpt.zzbh(MetaBox.TYPE);
    public static final int zzavz = zzpt.zzbh(AppleItemListBox.TYPE);
    public static final int zzawa = zzpt.zzbh("mean");
    public static final int zzawb = zzpt.zzbh("name");
    public static final int zzawc = zzpt.zzbh("data");
    public static final int zzawd = zzpt.zzbh(EventMessageBox.TYPE);
    public static final int zzawe = zzpt.zzbh("st3d");
    public static final int zzawf = zzpt.zzbh("sv3d");
    public static final int zzawg = zzpt.zzbh("proj");
    public static final int zzawh = zzpt.zzbh("vp08");
    public static final int zzawi = zzpt.zzbh("vp09");
    public static final int zzawj = zzpt.zzbh("vpcC");
    public static final int zzawk = zzpt.zzbh("camm");
    public static final int zzawl = zzpt.zzbh("alac");
    public final int type;

    public zzkw(int i2) {
        this.type = i2;
    }

    public static int zzar(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int zzas(int i2) {
        return i2 & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static String zzat(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >>> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }

    public String toString() {
        return zzat(this.type);
    }
}
