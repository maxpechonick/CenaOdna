package com.cena.odna.rest.file;

import com.cloudinary.StoredFile;
import com.cloudinary.Transformation;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Admin on 20.01.2017.
 */
public class PhotoUpload extends StoredFile {

    private MultipartFile file;

    public String getUrl() {
        if (version != null && format != null && publicId != null) {
            return UploadTools.getCloudinary().url()
                    .resourceType(resourceType)
                    .type(type)
                    .format(format)
                    .version(version)
                    .generate(publicId);
        } else return null;
    }

    public String getThumbnailUrl() {
        if (version != null && format != null && publicId != null) {
            return UploadTools.getCloudinary().url().format(format)
                    .resourceType(resourceType)
                    .type(type)
                    .version(version).transformation(new Transformation().width(400).height(400))
                    .generate(publicId);
        } else return null;
    }

    public String getComputedSignature() {
        return getComputedSignature(UploadTools.getCloudinary());
    }

    public boolean validSignature() {
        return getComputedSignature().equals(signature);
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
