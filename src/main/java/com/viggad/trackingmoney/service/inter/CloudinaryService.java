package com.viggad.trackingmoney.service.inter;


import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    String uploadImage(MultipartFile file);
    String deleteImage(String publicId);
}

