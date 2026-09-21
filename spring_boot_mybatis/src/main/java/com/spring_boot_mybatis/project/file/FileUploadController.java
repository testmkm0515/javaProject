package com.spring_boot_mybatis.project.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;  //자바 util 제공 표준 식별자 클래스

@Controller
public class FileUploadController {

	@GetMapping("/fileUploadForm")
	public String ViewUploadForm() {
		return "upload/fileUploadForm";
	}
	
	// (1) 1개 파일 업로드 : 파일명 중복 방지 - uuid 사용
	@PostMapping("/fileUpload")
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file, //스프링컨테이너 임시 저장 파일
							 Model model) throws IOException {
		//1. 파일 저장 경로 설정
		//구성한 경로가 디렉터리기 때문에 마지막에 / 필요함
		String uploadPath = "E:/hy9/springBootWorkspace/upload/";
		
		//2. 원본파일 이름 저장
		String originalFileName = file.getOriginalFilename();
		
		//3. 파일 이름 변경(새로 구성)
		UUID uuid = UUID.randomUUID(); //UUID 객체 반환
		String savedFileName = uuid.toString() + "_" + originalFileName;
		
		//4. 파일(객체) 생성
		File sendFile = new File(uploadPath + savedFileName);
		
		//5. 파일 시스템으로 trans
		file.transferTo(sendFile); //스프링 컨테이너 임시저장 파일 -> 파일 시스템에 저장
		
		model.addAttribute("originalFilename", originalFileName);
		
		return "upload/fileUploadResultView";
	}
	
	//(2) 여러개 파일 업로드
	@PostMapping("/fileUploadMultiple")
	public String fileUploadMultiple(
									@RequestParam("uploadFileMulti") ArrayList<MultipartFile> files,
									Model model
								) throws IOException {
		String uploadPath = "E:/hy9/springBootWorkspace/upload/";
		
		//2. 원본 파일명 추출
		ArrayList<String> originalFileNameList = new ArrayList<String>();
		for(MultipartFile file : files) {
			String originalFileName = file.getOriginalFilename();
			originalFileNameList.add(originalFileName); //view 표현위해 add
			
			UUID uuid = UUID.randomUUID();
			String savedFileName = uuid.toString()+"_"+originalFileName;
			
			File sendFile = new File(uploadPath + savedFileName);
			
			file.transferTo(sendFile);					
		}
		
		model.addAttribute("originalFileNameList", originalFileNameList);
		
		return "upload/fileUploadMultipleResultView";		
	}
	
	//3. 파일명 변경없이 업로드 - 파일명 중복 없음을 가정
	@PostMapping("/fileOriginalNameUpload")
	public String fileOriginalNameUpload(@RequestParam("uploadFileOriginal") MultipartFile file, Model model) throws IOException {
		String uploadPath = "E:/hy9/springBootWorkspace/upload/product_image/";
		String originalFileName = file.getOriginalFilename();
		File sendFile = new File(uploadPath + originalFileName);
		file.transferTo(sendFile);
		
		model.addAttribute("originalFileName",originalFileName);
		return "upload/fileUploadResultView";
	}
	
	
	@GetMapping("/imageFileUploadForm")
	public String imageFileUploadForm() {
		return "upload/imageFileUploadForm";
	}
	
	//비동기요청에 대한 처리 후 응답 메소드
	@ResponseBody
	@PostMapping("/imageFileUpload")
	public String imageFileUpload(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		//1. 파일 저장 경로 설정
		String uploadPath = "E:/hy9/springBootWorkspace/upload/";
		
		//2. 원본파일 이름 저장
		String originalFileName = file.getOriginalFilename();
		
		//4. 파일(객체) 생성
		File sendFile = new File(uploadPath + originalFileName);
		
		//5. 파일 시스템으로 trans
		file.transferTo(sendFile); //스프링 컨테이너 임시저장 파일 -> 파일 시스템에 저장
		
		String result = "success";
		return result;
	}
}
























