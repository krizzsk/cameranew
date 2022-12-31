package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.database.Cursor;
import android.os.Build;
import com.pinguo.camera360.gallery.data.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.common.network.common.header.PGTransHeader;
import vStudio.Android.Camera360.R;
/* compiled from: AbstractAlbum.java */
/* loaded from: classes3.dex */
public abstract class b extends y {

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f6332g = {"count(*)"};

    /* renamed from: h  reason: collision with root package name */
    protected static final int f6333h = TimeZone.getDefault().getRawOffset();

    /* renamed from: f  reason: collision with root package name */
    protected final Application f6334f;

    public b(Application application, Path path, long j2) {
        super(path, j2);
        this.f6334f = application;
    }

    private void F(ArrayList<y.c> arrayList, int i2, int i3) {
        int i4;
        int i5 = 0;
        while (i5 < arrayList.size()) {
            y.c cVar = arrayList.get(i5);
            i5++;
            int i6 = (i5 > arrayList.size() + (-1) ? i3 : arrayList.get(i5).f6392d) - cVar.f6392d;
            if (i6 % i2 == 0) {
                i4 = i6 / i2;
            } else {
                i4 = (i6 / i2) + 1;
            }
            cVar.f6393e = i6;
            cVar.f6395g = i4;
        }
    }

    private int H(int i2, int i3) {
        if (i2 % i3 == 0) {
            return i2 / i3;
        }
        return (i2 / i3) + 1;
    }

    private y.c I(String str, List<y.c> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equals(list.get(i2).b)) {
                return list.get(i2);
            }
        }
        return null;
    }

    private int J(TreeMap<String, Integer> treeMap, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((Integer) treeMap.getOrDefault(str, 0)).intValue();
        }
        return treeMap.get(str) != null ? treeMap.get(str).intValue() : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0129 A[Catch: all -> 0x015f, TryCatch #2 {all -> 0x015f, blocks: (B:10:0x0070, B:14:0x0087, B:16:0x0096, B:18:0x00a5, B:38:0x0112, B:40:0x0129, B:43:0x0132, B:41:0x012d, B:20:0x00b7, B:22:0x00bf, B:26:0x00d5, B:28:0x00dd, B:29:0x00e7, B:33:0x00f1, B:35:0x00f7, B:36:0x0107, B:15:0x008d), top: B:63:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012d A[Catch: all -> 0x015f, TryCatch #2 {all -> 0x015f, blocks: (B:10:0x0070, B:14:0x0087, B:16:0x0096, B:18:0x00a5, B:38:0x0112, B:40:0x0129, B:43:0x0132, B:41:0x012d, B:20:0x00b7, B:22:0x00bf, B:26:0x00d5, B:28:0x00dd, B:29:0x00e7, B:33:0x00f1, B:35:0x00f7, B:36:0x0107, B:15:0x008d), top: B:63:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132 A[Catch: all -> 0x015f, TRY_LEAVE, TryCatch #2 {all -> 0x015f, blocks: (B:10:0x0070, B:14:0x0087, B:16:0x0096, B:18:0x00a5, B:38:0x0112, B:40:0x0129, B:43:0x0132, B:41:0x012d, B:20:0x00b7, B:22:0x00bf, B:26:0x00d5, B:28:0x00dd, B:29:0x00e7, B:33:0x00f1, B:35:0x00f7, B:36:0x0107, B:15:0x008d), top: B:63:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int C(java.util.ArrayList<com.pinguo.camera360.gallery.data.y.c> r23, android.database.Cursor r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.data.b.C(java.util.ArrayList, android.database.Cursor, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Finally extract failed */
    public int D(ArrayList<y.c> arrayList, Cursor cursor, int i2, int i3) {
        long j2;
        int i4;
        int integer = this.f6334f.getResources().getInteger(R.integer.album_rows_port);
        if (cursor == null) {
            us.pinguo.common.log.a.s("query fail ", new Object[0]);
            return 0;
        }
        ArrayList arrayList2 = new ArrayList();
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        try {
            com.pinguo.camera360.gallery.util.a aVar = new com.pinguo.camera360.gallery.util.a();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd E", us.pinguo.foundation.utils.v.a());
            String format = simpleDateFormat.format(new Date());
            String substring = format.substring(0, 4);
            String format2 = simpleDateFormat.format(new Date(new Date().getTime() - AdvTimeUtils.MILLIS_OF_A_DAY));
            long i5 = com.pinguo.album.j.c.i();
            long j3 = com.pinguo.album.j.c.j();
            while (cursor.moveToNext()) {
                y.c cVar = new y.c();
                ArrayList arrayList3 = arrayList2;
                long j4 = cursor.getLong(i2);
                String format3 = simpleDateFormat.format(new Date(j4));
                cVar.b = format3;
                SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                int i6 = (j4 > i5 ? 1 : (j4 == i5 ? 0 : -1));
                if (i6 > 0 && j4 < j3) {
                    cVar.c = format3;
                    j2 = i5;
                    i4 = 0;
                } else {
                    j2 = i5;
                    i4 = 0;
                    cVar.c = format3.substring(0, 10);
                }
                String substring2 = cVar.b.substring(i4, 4);
                if (format.equals(cVar.b)) {
                    cVar.c = this.f6334f.getResources().getString(R.string.today_res_0x7f1106e7);
                } else if (format2.equals(cVar.b)) {
                    cVar.c = this.f6334f.getResources().getString(R.string.yesterday_res_0x7f110804);
                } else if (i6 > 0 && j4 < j3) {
                    if (cVar.c.length() > 10) {
                        cVar.c = cVar.b.substring(11);
                    }
                    if (!substring.equals(substring2)) {
                    }
                    cVar.a = Long.parseLong(cVar.b.substring(0, 10).replaceAll(PGTransHeader.CONNECTOR, ""));
                    arrayList3.add(cVar);
                    String str = cVar.b;
                    treeMap.put(str, Integer.valueOf(J(treeMap, str) + 1));
                    arrayList2 = arrayList3;
                    simpleDateFormat = simpleDateFormat2;
                    i5 = j2;
                } else if (substring.equals(substring2)) {
                    cVar.c = aVar.a(cVar.c.substring(5));
                    cVar.a = Long.parseLong(cVar.b.substring(0, 10).replaceAll(PGTransHeader.CONNECTOR, ""));
                    arrayList3.add(cVar);
                    String str2 = cVar.b;
                    treeMap.put(str2, Integer.valueOf(J(treeMap, str2) + 1));
                    arrayList2 = arrayList3;
                    simpleDateFormat = simpleDateFormat2;
                    i5 = j2;
                } else {
                    cVar.c = aVar.b(cVar.c);
                }
                substring = substring2;
                cVar.a = Long.parseLong(cVar.b.substring(0, 10).replaceAll(PGTransHeader.CONNECTOR, ""));
                arrayList3.add(cVar);
                String str22 = cVar.b;
                treeMap.put(str22, Integer.valueOf(J(treeMap, str22) + 1));
                arrayList2 = arrayList3;
                simpleDateFormat = simpleDateFormat2;
                i5 = j2;
            }
            ArrayList arrayList4 = arrayList2;
            cursor.close();
            int i7 = 0;
            for (Map.Entry<String, Integer> entry : treeMap.descendingMap().entrySet()) {
                y.c cVar2 = new y.c();
                y.c I = I(entry.getKey(), arrayList4);
                if (I != null) {
                    cVar2.a = I.a;
                    cVar2.c = I.c;
                    cVar2.b = I.b;
                    cVar2.f6393e = entry.getValue().intValue();
                    cVar2.f6392d = i7;
                    i7 += entry.getValue().intValue();
                    cVar2.f6395g = H(entry.getValue().intValue(), integer);
                    arrayList.add(cVar2);
                }
            }
            if (arrayList.size() > 0) {
                y.c cVar3 = arrayList.get(arrayList.size() - 1);
                return cVar3.f6392d + cVar3.f6393e;
            }
            return 0;
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E(ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, int i2) {
        com.pinguo.camera360.gallery.util.a aVar = new com.pinguo.camera360.gallery.util.a();
        String substring = new SimpleDateFormat("yyyy-MM-dd E", us.pinguo.foundation.utils.v.a()).format(new Date()).substring(0, 4);
        int i3 = 0;
        int i4 = 0;
        while (i3 < arrayList.size()) {
            y.c cVar = arrayList.get(i3);
            y.c cVar2 = i3 > 0 ? arrayList.get(i3 - 1) : null;
            String substring2 = cVar.b.substring(0, 7);
            if (!substring2.equals(cVar2 != null ? cVar2.b.substring(0, 7) : null)) {
                y.c cVar3 = new y.c();
                if (cVar2 != null && arrayList2.size() != 0) {
                    cVar3.f6392d = cVar.f6392d;
                } else {
                    cVar3.f6392d = 0;
                }
                String substring3 = substring2.substring(0, 4);
                cVar3.b = substring2;
                cVar3.c = substring2;
                if (substring.equals(substring3)) {
                    cVar3.c = aVar.a(cVar3.c.substring(5));
                } else {
                    cVar3.c = aVar.b(cVar3.c);
                    substring = substring3;
                }
                cVar3.a = Long.parseLong(cVar3.b.replaceAll(PGTransHeader.CONNECTOR, ""));
                arrayList2.add(cVar3);
                i4 = i3;
            }
            i3++;
        }
        if (i4 != arrayList.size() - 1 && i4 < arrayList.size()) {
            y.c cVar4 = arrayList.get(i4);
            y.c cVar5 = new y.c();
            cVar5.f6392d = cVar4.f6392d;
            String substring4 = cVar4.b.substring(0, 7);
            cVar5.b = substring4;
            String substring5 = substring4.substring(0, 4);
            cVar5.c = cVar5.b;
            if (substring.equals(substring5)) {
                cVar5.c = cVar5.c.substring(5);
            }
            if (cVar5.c.startsWith("0") && cVar5.c.length() > 1) {
                cVar5.c = cVar5.c.substring(1);
            }
            cVar5.a = Long.parseLong(cVar5.b.replaceAll(PGTransHeader.CONNECTOR, ""));
            arrayList2.add(cVar5);
        }
        if (arrayList2.size() == 0 && arrayList.size() > 0) {
            y.c cVar6 = new y.c();
            cVar6.f6392d = 0;
            String substring6 = arrayList.get(arrayList.size() - 1).b.substring(0, 7);
            cVar6.b = substring6;
            cVar6.c = substring6;
            if (substring6.startsWith("0") && cVar6.c.length() > 1) {
                cVar6.c = cVar6.c.substring(1);
            }
            cVar6.a = Long.parseLong(cVar6.b.replaceAll(PGTransHeader.CONNECTOR, ""));
            arrayList2.add(cVar6);
        }
        F(arrayList2, com.pinguo.album.e.e().b().getResources().getInteger(R.integer.album_rows_land), i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d5 A[Catch: all -> 0x0338, TryCatch #0 {all -> 0x0338, blocks: (B:5:0x001f, B:6:0x008c, B:8:0x0092, B:13:0x00a8, B:15:0x00c1, B:17:0x00d5, B:22:0x00f3, B:44:0x0176, B:62:0x01df, B:64:0x01fe, B:66:0x020f, B:70:0x0232, B:72:0x024a, B:74:0x0252, B:88:0x02b1, B:75:0x0262, B:77:0x026a, B:81:0x0280, B:83:0x028a, B:84:0x0295, B:86:0x029b, B:87:0x02a9, B:71:0x023b, B:91:0x02e1, B:45:0x0183, B:47:0x018d, B:51:0x01a3, B:53:0x01ad, B:54:0x01b7, B:57:0x01c0, B:59:0x01c8, B:61:0x01d7, B:20:0x00ea, B:14:0x00b5), top: B:103:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0183 A[Catch: all -> 0x0338, TryCatch #0 {all -> 0x0338, blocks: (B:5:0x001f, B:6:0x008c, B:8:0x0092, B:13:0x00a8, B:15:0x00c1, B:17:0x00d5, B:22:0x00f3, B:44:0x0176, B:62:0x01df, B:64:0x01fe, B:66:0x020f, B:70:0x0232, B:72:0x024a, B:74:0x0252, B:88:0x02b1, B:75:0x0262, B:77:0x026a, B:81:0x0280, B:83:0x028a, B:84:0x0295, B:86:0x029b, B:87:0x02a9, B:71:0x023b, B:91:0x02e1, B:45:0x0183, B:47:0x018d, B:51:0x01a3, B:53:0x01ad, B:54:0x01b7, B:57:0x01c0, B:59:0x01c8, B:61:0x01d7, B:20:0x00ea, B:14:0x00b5), top: B:103:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fe A[Catch: all -> 0x0338, TryCatch #0 {all -> 0x0338, blocks: (B:5:0x001f, B:6:0x008c, B:8:0x0092, B:13:0x00a8, B:15:0x00c1, B:17:0x00d5, B:22:0x00f3, B:44:0x0176, B:62:0x01df, B:64:0x01fe, B:66:0x020f, B:70:0x0232, B:72:0x024a, B:74:0x0252, B:88:0x02b1, B:75:0x0262, B:77:0x026a, B:81:0x0280, B:83:0x028a, B:84:0x0295, B:86:0x029b, B:87:0x02a9, B:71:0x023b, B:91:0x02e1, B:45:0x0183, B:47:0x018d, B:51:0x01a3, B:53:0x01ad, B:54:0x01b7, B:57:0x01c0, B:59:0x01c8, B:61:0x01d7, B:20:0x00ea, B:14:0x00b5), top: B:103:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e1 A[Catch: all -> 0x0338, TRY_LEAVE, TryCatch #0 {all -> 0x0338, blocks: (B:5:0x001f, B:6:0x008c, B:8:0x0092, B:13:0x00a8, B:15:0x00c1, B:17:0x00d5, B:22:0x00f3, B:44:0x0176, B:62:0x01df, B:64:0x01fe, B:66:0x020f, B:70:0x0232, B:72:0x024a, B:74:0x0252, B:88:0x02b1, B:75:0x0262, B:77:0x026a, B:81:0x0280, B:83:0x028a, B:84:0x0295, B:86:0x029b, B:87:0x02a9, B:71:0x023b, B:91:0x02e1, B:45:0x0183, B:47:0x018d, B:51:0x01a3, B:53:0x01ad, B:54:0x01b7, B:57:0x01c0, B:59:0x01c8, B:61:0x01d7, B:20:0x00ea, B:14:0x00b5), top: B:103:0x001f }] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int G(java.util.ArrayList<com.pinguo.camera360.gallery.data.y.c> r39, java.util.ArrayList<com.pinguo.camera360.gallery.data.y.b> r40, android.database.Cursor r41, int r42, int r43, int r44, int r45) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.gallery.data.b.G(java.util.ArrayList, java.util.ArrayList, android.database.Cursor, int, int, int, int):int");
    }

    public void K(w wVar) {
    }
}
