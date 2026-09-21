package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileDownloadController {

	//1. 다운로드 가능한 파일 리스트 출력 :  upload된 파일 중 다운로드 대상 파일 리스트 출력
	@GetMapping("/fileDownloadList")
	public String fileDownloadList(Model model) {
		File path = new File("E:/hy9/springBootWorkspace/upload/product_image");
		String[] filelist = path.list(); //위 파일 객체(디렉터리)의 정보 반환(디렉터리 내부의 정보들)
		model.addAttribute("filelist",filelist);
		
		return "upload/fileDownloadListtView";
	}
	
	//다운로드 진행 후 반환할 내용 없음
	@GetMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file,
							 HttpServletResponse response) throws IOException{ //파일명 주입
		String downloadPath = "E:/hy9/springBootWorkspace/upload/product_image";
		File f = new File(downloadPath,file);
		
		//한글파일명인 경우 인코딩된 형태여야 함 - 응답객체에 추가할 때 사용할 이름(클라이언트가 보는 이름)
		String encodedFileName = new String(file.getBytes("UTF-8"),"ISO-8859-1");
		
		//파일 다운로드 응답객체에 포함되어져서 진행됨 - 주입받아서 사용
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition","attatchment;filename=\"" + encodedFileName + "\"");
		
		//파일다운로드 진행 - 스트림 방식 사용
		FileInputStream fis = new FileInputStream(f);
		OutputStream ost = response.getOutputStream();
		
		//FileCopyUtils : 스프링이 제공하는 내장된 파일 컨트롤 클래스(다운로드 시 사용)
		FileCopyUtils.copy(fis, ost); //응답객체로 파일이 복사되고(스트리밍방식) 클라이언트에게 전달(다운로드)
	}
	
}
















