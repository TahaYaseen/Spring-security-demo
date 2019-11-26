/*package com.image.demo.service.impl;

import java.io.File;
import java.io.FileInputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ImageServiceImpl {
	public ResponseEntity fetchImage(String guid, EntityManagerFactory emf) {
		return doFetchImage(guid, emf);
	}
	private ResponseEntity doFetchImage(String guid, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			String fetchCall = "com.sap.sample::IMAGE_MANAGEMENT.IMAGE_STORE";
			String eventIdentificationCall = "SELECT * FROM \"" + fetchCall + "\"  WHERE IMAGE_ID = ?";
			Query query = em.createNativeQuery(eventIdentificationCall, ImageOutput.class);
			query.setParameter(1, guid);
			ImageOutput imo = (ImageOutput) query.getSingleResult();
			byte[] image = imo.getImageBinary();
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("Content-Type", imo.getImageMime());
			httpHeaders.add("Cache-Control", "max-age=259200");
			em.getTransaction().commit();

			return new ResponseEntity(image, httpHeaders, HttpStatus.OK);

		} catch (Exception ex) {
			try {
				File file = new File(getClass().getClassLoader().getResource("default-image.png").getFile());
				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.add("Content-Type", "image/png");
				byte[] image = IOUtils.toByteArray(new FileInputStream(file));
				//LOGGER.error("tenantName: " + ",Upload fetch failed : " + ex.getMessage());
				return new ResponseEntity(image, httpHeaders, HttpStatus.OK);
			} catch (Exception e) {
				HttpHeaders httpHeaders = new HttpHeaders();
				//LOGGER.error("tenantName: " + ",Upload fetch failed : " + ex.getMessage());
				return new ResponseEntity(httpHeaders, HttpStatus.BAD_REQUEST);
			}
		}
	}
}
*/