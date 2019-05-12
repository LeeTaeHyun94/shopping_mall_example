package com.hyun.shopping_mall_example.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

public class UploadFileUtils {
    static final int THUMB_WIDTH = 300;
    static final int THUMB_HEIGHT = 300;

    public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String date) throws Exception {
        UUID uuid = UUID.randomUUID();
        String newFileName = uuid + "_" + fileName, imgPath = uploadPath + date;
        File target = new File(imgPath, newFileName);
        FileCopyUtils.copy(fileData, target);

        String thumbnailFileName = "s_" + newFileName;
        File image = new File(imgPath + File.separator + newFileName);
        File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbnailFileName);
        if (image.exists()) {
            thumbnail.getParentFile().mkdirs();
            Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(thumbnail);
        }
        return newFileName;
    }

    public static String makePath(String uploadPath) {
        Calendar calendar = Calendar.getInstance();
        String year = File.separator + calendar.get(Calendar.YEAR);
        String month = year + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
        String day = month + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DATE));
        makeDirectory(uploadPath, year, month, day);
        makeDirectory(uploadPath, year, month, day + "/s");
        return day;
    }

    public static void makeDirectory(String uploadPath, String... paths) {
        if (new File(paths[paths.length - 1]).exists()) return;
        for (String path : paths) {
            File directoryPath = new File(uploadPath + path);
            if (!directoryPath.exists()) directoryPath.mkdir();
        }
    }
}
