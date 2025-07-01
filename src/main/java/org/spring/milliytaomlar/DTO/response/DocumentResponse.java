package org.spring.milliytaomlar.DTO.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DocumentResponse {
    private Integer documentId;
    private String downloadUrl;
    private String serverName;
    private byte[] file;
    private String fileType;
    private String originalName;
    private double size;
}
