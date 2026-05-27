package com.viggad.trackingmoney.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.viggad.trackingmoney.service.inter.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile file) {
        try {

            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );

            return uploadResult.get("secure_url").toString();

        } catch (IOException e) {
            throw new RuntimeException("Upload image failed");
        }
    }

    @Override
    public String deleteImage(String imageUrl) {
        try {

            String publicId = imageUrl.substring(
                    imageUrl.lastIndexOf("/") + 1,
                    imageUrl.lastIndexOf(".")
            );

            Map result = cloudinary.uploader().destroy(
                    publicId,
                    ObjectUtils.emptyMap()
            );

            return result.get("result").toString();

        } catch (IOException e) {
            throw new RuntimeException("Delete image failed");
        }
    }
}
