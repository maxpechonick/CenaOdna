package com.cena.odna.rest.file;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Admin on 20.01.2017.
 */
public class PhotoUploadValidator implements Validator {
    public boolean supports(Class clazz) {
        return PhotoUpload.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        PhotoUpload pu = (PhotoUpload) obj;
        if (pu.getFile() == null || pu.getFile().isEmpty()) {
            if (!pu.validSignature()) {
                e.rejectValue("signature", "signature.mismatch");
            }
        }
    }

}
