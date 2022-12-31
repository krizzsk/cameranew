package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
final class b3 {
    private static final Pattern a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file2.listFiles(a3.a);
        if (listFiles == null) {
            fileArr = new File[0];
        } else {
            File[] fileArr2 = new File[listFiles.length];
            for (File file3 : listFiles) {
                int parseInt = Integer.parseInt(file3.getName().split(PGTransHeader.CONNECTOR)[0]);
                if (parseInt > listFiles.length || fileArr2[parseInt] != null) {
                    throw new bv("Metadata folder ordering corrupt.");
                }
                fileArr2[parseInt] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    f3 d2 = new t0(fileInputStream).d();
                    if (d2.d() == null) {
                        throw new bv("Metadata files corrupt. Could not read local file header.");
                    }
                    File file5 = new File(file, d2.d());
                    if (!file5.exists()) {
                        throw new bv(String.format("Missing asset file %s during slice reconstruction.", file5.getCanonicalPath()));
                    }
                    arrayList.add(file5);
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        com.google.android.play.core.internal.j1.a(th, th2);
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }
}
