package com.cha.ing.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileManage {

	private final AmazonS3Client amazonS3Client;
	
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${cloud.aws.s3.bucket.url}")
    private String defaultUrl;
    
	public ResponseEntity<String> upload(MultipartFile file) throws IOException {
		try {
	         String fileName=file.getOriginalFilename();
	         String fileUrl= "https://" + bucket + UUID.randomUUID().toString() +fileName;
	         ObjectMetadata metadata= new ObjectMetadata();
	         
	         log.warn("파일왜안와{}",file);
	         if(fileName == null || fileName.isEmpty()) {
	        	 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file name");
	         }
			 metadata.setContentType(file.getContentType());
			 metadata.setContentLength(file.getSize());
	         amazonS3Client.putObject(bucket,fileName,file.getInputStream(),metadata);
	         
	         return ResponseEntity.ok(fileName);
	      } catch (IOException e) {
	         e.printStackTrace();
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	      }
		
	}
	
	
	
	public String fileSave(String path, MultipartFile multipartFile)throws Exception{
		
		File file=new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName=UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
		
		file=new File(file,fileName);
		multipartFile.transferTo(file);
		//파일 객체생성
		//uuid바른거로 다시 생성
		//전송
		
		
		return fileName;
		
	}
	
	
	
}
