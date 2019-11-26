package com.image.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class LoginController {

	@Autowired
	ServletContext context;

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello!!!!!";
	}

	@GetMapping("/getImages")
	public ResponseEntity<List<String>> getImages() {
		List<String> images = new ArrayList<>();
		String filePath = context.getRealPath("/images");

//		String filePath = context.getRealPath(System.getProperty("user.dir")
//				+"/src/main/resources/static/images");

		File fileFolder = new File(filePath);
		System.out.println("Working Directory = " + System.getProperty("user.dir"));

		if (fileFolder != null) {
			for (final File file : fileFolder.listFiles()) {
				// File file = fileFolder.listFiles()[0];
				if (!file.isDirectory()) {
					String encodeBase64 = null;

					try {
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fileInputStream = new FileInputStream(file);
						byte bytes[] = new byte[(int) file.length()];
						fileInputStream.read(bytes);
						encodeBase64 = Base64.getEncoder().encodeToString(bytes);
						images.add("data:image/" + extension + ";base64," + encodeBase64);
						fileInputStream.close();
					} catch (Exception e) {

					}
				}

			}

		}

		// images.remove(1);
		return new ResponseEntity<List<String>>(images, HttpStatus.OK);
	}

	@GetMapping("/getImage")
	@CrossOrigin
	public ResponseEntity<String> getImage() {
		List<String> images = new ArrayList<>();
		String filePath = context.getRealPath("/home/taha/Documents/File");
		File fileFolder = new File(filePath);

		File file = new File("/home/taha/Documents/File/bajaj.png");

		if (fileFolder != null) {
			// File file = fileFolder.listFiles()[0];
			String encodeBase64 = null;

			try {
				String extension = FilenameUtils.getExtension(file.getName());
				FileInputStream fileInputStream = new FileInputStream(file);
				byte bytes[] = new byte[(int) file.length()];
				fileInputStream.read(bytes);
				encodeBase64 = Base64.getEncoder().encodeToString(bytes);
				images.add("data:image/" + extension + ";base64," + encodeBase64);
				// images.add(encodeBase64);
				fileInputStream.close();
			} catch (Exception e) {

			}
		}

		return new ResponseEntity<String>(images.get(0), HttpStatus.OK);
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		String filePath = context.getRealPath("/images");

		System.out.println("FilePath : " + filePath);
		String UPLOADED_FOLDER = filePath + "/";

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
