package com.cena.odna.rest.file;

import com.cena.odna.core.config.settings.CloudinarySettings;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Admin on 20.01.2017.
 */
@Component
public class UploadTools {

    private static Cloudinary cloudinary;

    @Autowired
    public UploadTools(CloudinarySettings settings) {
        cloudinary = new Cloudinary(settings.fullSettings());
    }

    public String upload(String httpUrl) throws IOException {
        Map uploadResult = cloudinary.uploader().upload("http://www.example.com/image.jpg", ObjectUtils.asMap(
                "transformation", new Transformation().width(400).height(400)
        ));
        return (String) uploadResult.get("url");
    }

    public static String upload(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("resource_type", "auto"));
        return (String) uploadResult.get("public_id");
    }

    public static Cloudinary getCloudinary() {
        return cloudinary;
    }

    public static void delete(String publicId) throws Exception {
        cloudinary.api().deleteResources(Collections.singletonList(publicId), ObjectUtils.emptyMap());
    }
}
