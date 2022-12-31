package com.google.android.gms.internal.ads;

import android.util.Log;
import com.coremedia.iso.boxes.GenreBox;
import com.coremedia.iso.boxes.RatingBox;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzll {
    private static final int zzayn = zzpt.zzbh("nam");
    private static final int zzayo = zzpt.zzbh("trk");
    private static final int zzayp = zzpt.zzbh("cmt");
    private static final int zzayq = zzpt.zzbh("day");
    private static final int zzayr = zzpt.zzbh("ART");
    private static final int zzays = zzpt.zzbh("too");
    private static final int zzayt = zzpt.zzbh("alb");
    private static final int zzayu = zzpt.zzbh("com");
    private static final int zzayv = zzpt.zzbh("wrt");
    private static final int zzayw = zzpt.zzbh("lyr");
    private static final int zzayx = zzpt.zzbh("gen");
    private static final int zzayy = zzpt.zzbh("covr");
    private static final int zzayz = zzpt.zzbh(GenreBox.TYPE);
    private static final int zzaza = zzpt.zzbh("grp");
    private static final int zzazb = zzpt.zzbh("disk");
    private static final int zzazc = zzpt.zzbh("trkn");
    private static final int zzazd = zzpt.zzbh("tmpo");
    private static final int zzaze = zzpt.zzbh("cpil");
    private static final int zzazf = zzpt.zzbh("aART");
    private static final int zzazg = zzpt.zzbh("sonm");
    private static final int zzazh = zzpt.zzbh("soal");
    private static final int zzazi = zzpt.zzbh("soar");
    private static final int zzazj = zzpt.zzbh("soaa");
    private static final int zzazk = zzpt.zzbh("soco");
    private static final int zzazl = zzpt.zzbh(RatingBox.TYPE);
    private static final int zzazm = zzpt.zzbh("pgap");
    private static final int zzazn = zzpt.zzbh("sosn");
    private static final int zzazo = zzpt.zzbh("tvsh");
    private static final int zzazp = zzpt.zzbh("----");
    private static final String[] zzazq = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzmn zza(int i2, String str, zzpn zzpnVar) {
        int readInt = zzpnVar.readInt();
        if (zzpnVar.readInt() == zzkw.zzawc) {
            zzpnVar.zzbj(8);
            return new zzmn(str, null, zzpnVar.zzbk(readInt - 16));
        }
        String valueOf = String.valueOf(zzkw.zzat(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzmn zzb(int i2, String str, zzpn zzpnVar) {
        int readInt = zzpnVar.readInt();
        if (zzpnVar.readInt() == zzkw.zzawc && readInt >= 22) {
            zzpnVar.zzbj(10);
            int readUnsignedShort = zzpnVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpnVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzmn(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(zzkw.zzat(i2));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: all -> 0x02bf, TryCatch #0 {all -> 0x02bf, blocks: (B:7:0x0023, B:9:0x0028, B:11:0x002e, B:13:0x0033, B:16:0x003a, B:17:0x0041, B:20:0x004a, B:22:0x004e, B:25:0x0058, B:27:0x005c, B:30:0x0066, B:32:0x006b, B:35:0x0075, B:37:0x0079, B:40:0x0083, B:42:0x0088, B:44:0x0094, B:52:0x00ad, B:53:0x00c4, B:54:0x00d5, B:57:0x00de, B:59:0x00e2, B:62:0x00ec, B:64:0x00f0, B:67:0x00fa, B:69:0x00fe, B:72:0x0108, B:74:0x010c, B:77:0x0116, B:79:0x011a, B:82:0x0124, B:84:0x0128, B:87:0x0132, B:89:0x0136, B:92:0x0140, B:94:0x0144, B:97:0x014e, B:99:0x0152, B:102:0x015c, B:104:0x0160, B:107:0x016a, B:110:0x0173, B:112:0x0179, B:114:0x018c, B:115:0x0193, B:117:0x0197, B:118:0x019e, B:121:0x01a4, B:122:0x01aa, B:124:0x01b2, B:128:0x01bd, B:189:0x028a, B:191:0x029a, B:193:0x02a4, B:192:0x029f, B:132:0x01d5, B:134:0x01d9, B:136:0x01e5, B:137:0x01f5, B:139:0x0205, B:141:0x020f, B:140:0x020a, B:144:0x0216, B:146:0x021a, B:149:0x0220, B:151:0x0224, B:154:0x022a, B:156:0x022e, B:159:0x0238, B:161:0x023c, B:164:0x0246, B:166:0x024a, B:169:0x0254, B:171:0x0258, B:174:0x0262, B:176:0x0266, B:179:0x0270, B:181:0x0274, B:184:0x027c, B:186:0x0280, B:196:0x02ab, B:199:0x02b5), top: B:205:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x02bf, TRY_LEAVE, TryCatch #0 {all -> 0x02bf, blocks: (B:7:0x0023, B:9:0x0028, B:11:0x002e, B:13:0x0033, B:16:0x003a, B:17:0x0041, B:20:0x004a, B:22:0x004e, B:25:0x0058, B:27:0x005c, B:30:0x0066, B:32:0x006b, B:35:0x0075, B:37:0x0079, B:40:0x0083, B:42:0x0088, B:44:0x0094, B:52:0x00ad, B:53:0x00c4, B:54:0x00d5, B:57:0x00de, B:59:0x00e2, B:62:0x00ec, B:64:0x00f0, B:67:0x00fa, B:69:0x00fe, B:72:0x0108, B:74:0x010c, B:77:0x0116, B:79:0x011a, B:82:0x0124, B:84:0x0128, B:87:0x0132, B:89:0x0136, B:92:0x0140, B:94:0x0144, B:97:0x014e, B:99:0x0152, B:102:0x015c, B:104:0x0160, B:107:0x016a, B:110:0x0173, B:112:0x0179, B:114:0x018c, B:115:0x0193, B:117:0x0197, B:118:0x019e, B:121:0x01a4, B:122:0x01aa, B:124:0x01b2, B:128:0x01bd, B:189:0x028a, B:191:0x029a, B:193:0x02a4, B:192:0x029f, B:132:0x01d5, B:134:0x01d9, B:136:0x01e5, B:137:0x01f5, B:139:0x0205, B:141:0x020f, B:140:0x020a, B:144:0x0216, B:146:0x021a, B:149:0x0220, B:151:0x0224, B:154:0x022a, B:156:0x022e, B:159:0x0238, B:161:0x023c, B:164:0x0246, B:166:0x024a, B:169:0x0254, B:171:0x0258, B:174:0x0262, B:176:0x0266, B:179:0x0270, B:181:0x0274, B:184:0x027c, B:186:0x0280, B:196:0x02ab, B:199:0x02b5), top: B:205:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzmh.zza zzd(com.google.android.gms.internal.ads.zzpn r14) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzll.zzd(com.google.android.gms.internal.ads.zzpn):com.google.android.gms.internal.ads.zzmh$zza");
    }

    private static int zze(zzpn zzpnVar) {
        zzpnVar.zzbj(4);
        if (zzpnVar.readInt() == zzkw.zzawc) {
            zzpnVar.zzbj(8);
            return zzpnVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzmo zza(int i2, String str, zzpn zzpnVar, boolean z, boolean z2) {
        int zze = zze(zzpnVar);
        if (z2) {
            zze = Math.min(1, zze);
        }
        if (zze >= 0) {
            if (z) {
                return new zzmn(str, null, Integer.toString(zze));
            }
            return new zzmj("und", str, Integer.toString(zze));
        }
        String valueOf = String.valueOf(zzkw.zzat(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }
}
