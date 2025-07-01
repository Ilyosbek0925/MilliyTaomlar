package org.spring.milliytaomlar.service;

import org.spring.milliytaomlar.DTO.response.DocumentResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileStorageService {


    public DocumentResponse uploadFile(MultipartFile file) ;

    public byte[] downloadFile(String serverName) ;


}
