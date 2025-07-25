package org.spring.milliytaomlar.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AWSConfig {
@Value("${aws.access.key}")
private String accessKey;
@Value("${aws.secret.key}")
private String secretKey;

    @Bean
    public AmazonS3 getS3Client() {
        String accessKey = this.accessKey;
        String secretKey = this.secretKey;
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.EU_NORTH_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
        return s3Client;
    }
}
